package com.weasel.frp.service.impl;

import com.weasel.frp.domain.Common;
import com.weasel.frp.domain.IniConfig;
import com.weasel.frp.domain.device.Device;
import com.weasel.frp.infrastructure.Frp;
import com.weasel.frp.infrastructure.helper.SystemHelper;
import com.weasel.frp.infrastructure.ini.IniWriter;
import com.weasel.frp.service.DeviceService;
import com.weasel.frp.service.FrpConfigService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;

/**
 * @author Dylan
 * @date 2017/1/23.
 */
@Service
public class FrpConfigServiceImpl implements FrpConfigService {

    private final static Logger log = LoggerFactory.getLogger(FrpConfigServiceImpl.class);

    @Autowired
    private DeviceService deviceService;


    @Override
    public int reloadConfig(String frpHome) throws IOException, InterruptedException {

        Assert.hasText(frpHome,"frp目录没指定，请在启动系统的时候将frp所在目录作为启动参数...");

        IniConfig config = new IniConfig();
        List<Device> devices = deviceService.query(new Device());
        config.setDevices(new HashSet<>(devices));
        config.setCommon(new Common());

        IniWriter.create()
                .load(config)
                .store(new File(Frp.getHome()+"\\frps.ini"));

        String reloadCommand;

        if(SystemHelper.isWindows()){
            reloadCommand = Frp.getHome()+"/frps.exe -c "+Frp.getHome()+"/frps.ini --reload";
        }else {
            reloadCommand = Frp.getHome()+"/frps -c "+Frp.getHome()+"/frps.ini --reload";
        }

        log.info("重新加载配置文件，执行以下命令[{}]",reloadCommand);
        Runtime.getRuntime().exec(reloadCommand).waitFor();
        log.info("重新加载配置文件成功");
        return 0;
    }
}
