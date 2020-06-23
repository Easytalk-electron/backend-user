package com.example.UserManagement.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.UserManagement.bean.Result;
import com.example.UserManagement.entity.Login;
import com.example.UserManagement.entity.User;
import com.example.UserManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FriendListController {
    @Autowired
    private UserService userService;

    @RequestMapping("/friendList")
    public JSONArray getFriendList(@RequestBody Login login){
        String id = login.getId();
        int id1 = Integer.parseInt(id);
        Result result = userService.getFriendList(id1);
        var userList = (List<User>)result.getDetail();
        JSONArray ja = new JSONArray();
        if (userList != null)
            for (int i = 0; i<userList.size(); ++i){
                JSONObject jo = JSON.parseObject(JSON.toJSONString(userList.get(i)));
                ja.add(jo);
            }



        return ja;
    }
}
