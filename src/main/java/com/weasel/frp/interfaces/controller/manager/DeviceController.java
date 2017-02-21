package com.weasel.frp.interfaces.controller.manager;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import com.google.gson.Gson;
import com.weasel.frp.domain.device.Device;
import com.weasel.frp.interfaces.controller.VelocityTemplateController;
import com.weasel.frp.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Dylan
 * @date 2017/1/22.
 */
@RestController
@RequestMapping(value = "/device")
public class DeviceController extends VelocityTemplateController{

    @Autowired
    private DeviceService service;


    @RequestMapping(value = {"/list"},method = GET)
    public String list(){

        Device device = new Device();
        List<Device> devices = service.query(device);

        return new Gson().toJson(devices);
    }
}
