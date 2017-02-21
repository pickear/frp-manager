package com.weasel.frp.interfaces.controller.manager;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import com.google.common.collect.Maps;
import com.weasel.frp.domain.Page;
import com.weasel.frp.domain.User;
import com.weasel.frp.infrastructure.exception.UserExistException;
import com.weasel.frp.infrastructure.helper.GsonHelper;
import com.weasel.frp.interfaces.controller.VelocityTemplateController;
import com.weasel.frp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.velocity.VelocityEngineUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author Dylan
 * @date 2017/1/22.
 */
@RestController
@RequestMapping(value = "/admin/user")
public class UserController  extends VelocityTemplateController{

    @Autowired
    private UserService service;


    @RequestMapping(value = "/regitster",method = GET)
    public String register(){

        return "";
    }

    @RequestMapping(value = "/regitster",method = POST)
    public String register(User user){

        try {
            if(service.notExist(user)){
                int result = service.save(user);
            }
            return "";
        } catch (UserExistException e) {
            e.printStackTrace();
            return "";
        }
    }

    @RequestMapping(value = "/list",method = GET)
    @ResponseBody
    public String list(){

        Page<User> page = service.queryPage(new Page<>());

        String gson = GsonHelper.toGson(page.getResult());
        return gson;
    }

    @RequestMapping(value = "/list_view",method = GET)
    public String listView(){

        HashMap<String,Object> datas = Maps.newHashMap();
        return VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "manager/user.vm", "utf-8", datas);
    }
}
