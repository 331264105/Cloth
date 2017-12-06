package com.didu.web;

import com.didu.domain.Address;
import com.didu.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2017/11/27.
 */
@Controller
public class AddressControl {
    @Autowired
    private AddressService addressService;
    //添加收货地址
    @RequestMapping("/addAddress")
    @ResponseBody
    public String addAddress(Address address){
        int p = address.getPid();
        Address address1 = new Address();
        address1.setPid(p);
        List<Address> addresses = addressService.queryAddress(address1);
        if(addresses.size()>0){
            address.setSelected("");
            boolean b = addressService.addAddress(address);
            if (b) {
                return "true";
            }else{
                return  "false";
            }
        }else{
            address.setSelected("true");
            boolean b = addressService.addAddress(address);
            if (b) {
                return "true";
            }else {
                return "false";
            }
        }
    }
    //查看收货地址
    @RequestMapping("/queryAddress")
    @ResponseBody
    public List<Address> queryAdress(Address address){
        List<Address> dress = addressService.queryAddress(address);
        return dress;
    }
    //修改收货地址
    @RequestMapping("/updateAddress")
    @ResponseBody
    public String updateAddress(Address address){
        String moren = address.getSelected();
        if (moren==null){
            boolean b = addressService.updateAddress(address);
            if (b){
                return "true";
            }else {
                return "false";
            }
        }else {
            boolean sb = addressService.updateSelected();
            if (sb) {
                boolean b = addressService.updateAddress(address);
                if (b) {
                    return "true";
                }
                return "false";
            }else {
                return "false";
            }
        }
    }
    //删除收货地址
    @RequestMapping("/removeAddress")
    @ResponseBody
    public boolean deAdress(int id,int pid){
        Address address=new Address();
        address.setId(id);
        boolean a=false;
        boolean b=false;
        List<Address> addresses = addressService.queryAddress(address);
        if (addresses.size()==0){
            return false;
        }
        if ("true".equals(addresses.get(0).getSelected())){
            b = addressService.deAddress(id);
            address.setId(0);
            address.setPid(pid);
            List<Address> addresses1 = addressService.queryAddress(address);
            if (addresses1.size()>0) {
                addresses1.get(0).setSelected("true");
                a = addressService.updateAddress(addresses1.get(0));
                if (a&&b){
                    return true;
                }else {
                    return false;
                }
            }else{
               b= addressService.deAddress(id);
                if (b) {
                    return true;
                }else{
                    return false;
                }
            }
        }else{
            b=addressService.deAddress(id);
            if (b) {
                return true;
            }else {
                return false;
            }
        }
    }
}
