package com.weasel.frp.interfaces.controller.manager;

import com.weasel.frp.domain.Common;
import com.weasel.frp.domain.IniConfig;
import com.weasel.frp.domain.device.Device;
import com.weasel.frp.infrastructure.Frp;
import com.weasel.frp.infrastructure.helper.SystemHelper;
import com.weasel.frp.infrastructure.ini.IniWriter;
import com.weasel.frp.interfaces.controller.VelocityTemplateController;
import com.weasel.frp.service.DeviceService;
import com.weasel.frp.service.FrpConfigService;
import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.velocity.VelocityEngineUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.*;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author Dylan
 * @date 2017/1/22.
 */
@RestController
@RequestMapping(value = "/admin")
public class AdminController extends VelocityTemplateController{

    private final static Logger log = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private FrpConfigService frpConfigService;

    @RequestMapping(value = {"/","home","index"},method = GET)
    public String home(){

        return VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "manager/index.vm", "utf-8", new HashMap<>());
    }

    @RequestMapping(value = "/welcome",method = GET)
    public String welcome(){

        return VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "manager/welcome.vm", "utf-8", new HashMap<>());
    }

    @RequestMapping(value = "/reload-config",method = GET)
    public String reload(){


        try {
            frpConfigService.reloadConfig(Frp.getHome());
            return "success";
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "error";
    }
}
