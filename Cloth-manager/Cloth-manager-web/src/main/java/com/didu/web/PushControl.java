package com.didu.web;

import com.didu.domain.Push;
import com.didu.service.PushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2017/11/28.
 */
@Controller
public class PushControl {
    @Autowired
    private PushService pushService;
    @ModelAttribute("dir")
    public File pre(HttpServletRequest request) {
        File dir = new File(new File(request.getServletContext().getRealPath("/")), "push");
        System.out.println(request.getServletContext().getRealPath("/"));
        // 验证文件夹是否存在，不存在就新建
        if (!dir.exists()) {
            dir.mkdirs();
        }
        return dir;
    }
    //上传主推图片
    @RequestMapping("/PushUp")
    @ResponseBody
    public boolean CarouselUp(@RequestParam(name = "files", required = false) CommonsMultipartFile[] files, @ModelAttribute(value = "dir") File dir
            ,Push carousel) throws IOException {
        for (int i = 0; i < files.length; i++) {
            if (!files[i].isEmpty() && files[i].getSize() > 0) {
                // 获取上传的文件的名称
                String fileName = files[i].getOriginalFilename();
                if (fileName.endsWith(".jpg") || fileName.endsWith(".png")) {
                    // 设置文件存储位置--->当前项目的平级目录下
                    // 限制文件名称最长位50，若超出截取后面部分
                    if (fileName.length() > 50) {
                        fileName = fileName.substring(fileName.length() - 51);
                    }
                    File file1 = new File(dir,System.currentTimeMillis() +"_"+ fileName);
                    files[i].transferTo(file1);
                    carousel.setUrl("push"+File.separator+file1.getName());
                    boolean a = pushService.addImage(carousel);
                    return a;
                }
                return false;
            }
        }
        return false;
    }
    //删除主推图片
    @RequestMapping("/removePush")
    @ResponseBody
    public boolean removePush(Push push,HttpServletRequest request){
       List<Push> pushs= pushService.queryPush(push);
        String url = pushs.get(0).getUrl();
        String s = request.getServletContext().getRealPath("/") + url;
        File file=new File(s);
        file.delete();
        boolean b=pushService.dePush(push);
        return b;
    }
    //查看主推图片
    @RequestMapping("/queryPush")
    @ResponseBody
    public List<Push> queryPush(Push push){
        return pushService.queryPush(push);
    }
}
