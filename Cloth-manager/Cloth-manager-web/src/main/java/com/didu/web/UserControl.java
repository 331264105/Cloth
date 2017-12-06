package com.didu.web;

import com.didu.domain.User;
import com.didu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2017/12/4.
 */
@Controller
public class UserControl {
    @Autowired
    private UserService userService;
    //更改个人信息
    @RequestMapping("/updateUser" )
    @ResponseBody
    public User updateUser(User user) {
        List<User> users = userService.queryUser(user);
        if (users.size()==0){
            boolean b = userService.addUser(user);
            if (b){
               List<User> ls= userService.queryUser(user);
                return ls.get(0);
            }else {
                return new User();
            }
        }else{
            boolean b = userService.updateUser(user);
            List<User> u = userService.queryUser(user);
            if (b){
                return u.get(0);
            }else {
                return u.get(0);
            }
        }
    }
    @RequestMapping("/queryUsers")
    @ResponseBody
    public List<User> queryUsers(User user){
        return userService.queryUser(user);
    }
}
