package com.weasel.frp.interfaces.controller;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by dypan on 2017/2/18.
 */
public abstract class VelocityTemplateController {

    @Autowired
    protected VelocityEngine velocityEngine;
}
