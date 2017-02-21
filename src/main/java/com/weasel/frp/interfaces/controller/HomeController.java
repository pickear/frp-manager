package com.weasel.frp.interfaces.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.velocity.VelocityEngineUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author Dylan
 * @date 2017/1/20.
 */
@RestController
public class HomeController extends VelocityTemplateController{

    @RequestMapping(value = {"/","/home","/index"},method = GET)
    public String home(){

        return VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "home.vm", "utf-8", new HashMap<>());
    }
}
