package com.didu.web;

import com.didu.domain.Carousel;
import com.didu.service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2017/11/27.
 */
@Controller
public class CarouselControl {
    @Autowired
    private CarouselService carouselService;
    @ModelAttribute("dir")
    public File pre(HttpServletRequest request) {
        File dir = new File(new File(request.getServletContext().getRealPath("/")), "carousel");
        System.out.println(request.getServletContext().getRealPath("/"));
        // 验证文件夹是否存在，不存在就新建
        if (!dir.exists()) {
            dir.mkdirs();
        }
        return dir;
    }
    //动态路径
    @RequestMapping("{jn}")
    public String t1(@PathVariable String jn,HttpServletRequest request){
        System.out.print(jn);
        return jn;
    }
    //上传轮播图片
    @RequestMapping("/CarouselUp")
    @ResponseBody
    public boolean CarouselUp(@RequestParam(name = "files", required = false) CommonsMultipartFile[] files, @ModelAttribute(value = "dir") File dir
            ,Carousel carousel) throws IOException {
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
                    carousel.setUrl("carousel"+File.separator+file1.getName());
                    carouselService.addImage(carousel);
                    return true;
                }
                return false;
            }
        }
        return false;
    }
    @RequestMapping("/queryCarousel")
    @ResponseBody
    public List<Carousel> queryCarousel(Carousel carousel){
       return carouselService.queryCarousel(carousel);
    }
    @RequestMapping("updateCarousel")
    @ResponseBody
    public boolean updateCarousel(Carousel carousel,@RequestParam(name = "files", required = false) CommonsMultipartFile[] files,@ModelAttribute(value = "dir") File dir) throws IOException {
        List<Carousel> carousels = carouselService.queryCarousel(carousel);
        for (int i=0;i<files.length;i++){
            String originalFilename = files[i].getOriginalFilename();
            if(originalFilename.endsWith(".jpg")||originalFilename.endsWith(".png")){
                if (originalFilename.length() > 50) {
                    originalFilename = originalFilename.substring(originalFilename.length() - 51);
                }
                File f=new File(dir,System.currentTimeMillis()+"_"+originalFilename);
                files[i].transferTo(f);
                String path = "carousel"+File.separator+f.getName();
                String url = carousels.get(0).getUrl();
                String s = path.replaceAll("\\\\", "/");
                String[] split = url.split("\\/");
                System.err.println(split[1]);
                File file=new File(dir,split[1]);
                file.delete();
                carousel.setUrl(s);
                boolean c = carouselService.updateCarousel(carousel);
                if (c) {
                    return true;
                }else {
                    return false;
                }
            }else{
                return false;
            }
        }
        return false;
    }
}
