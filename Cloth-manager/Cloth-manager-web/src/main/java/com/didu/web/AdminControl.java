package com.didu.web;

import com.didu.domain.Admin;
import com.didu.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

/**
 * Created by Administrator on 2017/12/4.
 */
@Controller
public class AdminControl {
    @Autowired
    private AdminService adminService;
    @RequestMapping("/addAdmin")
    @ResponseBody
    public String addAdmin(Admin user){
        Admin users = adminService.queryAdmin(user);
        if (users!=null){
            return "false";
        }else {
            boolean b = adminService.addAdmin(user);
            if (b) {
                return "true";
            } else {
                return "false";
            }
        }
    }
    @RequestMapping("/queryAdmin")
    @ResponseBody
    public List<Admin> queryUsers(Admin user){
        return adminService.queryAdmins(user);
    }
    @RequestMapping("/admin/login")
    @ResponseBody
    public String login(Admin user){
        Admin admin = adminService.queryAdmin(user);
        if (user.getUserphone().equals(admin.getUserphone())&&user.getPassword().equals(admin.getPassword())){
            return "true";
        }else {
            return "false";
        }
    }
    @RequestMapping("/updateAdmin")
    @ResponseBody
    public String updateAdmin(Admin admin){
        boolean a = adminService.updateAdmin(admin);
        if (a){
            return "true";
        }else {
            return "false";
        }
    }
    @RequestMapping("/deAdmin")
    @ResponseBody
    public String deAdmin(Admin user){
        boolean b = adminService.deAdmin(user);
        if (b){
            return "true";
        }else{
            return "false";
        }
    }
}
