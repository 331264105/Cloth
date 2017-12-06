package com.didu.web;

import com.didu.domain.Color;
import com.didu.domain.Product;
import com.didu.domain.Slider;
import com.didu.domain.Sliderdetail;
import com.didu.service.ProductService;
import com.didu.utils.Page;
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
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/11/29.
 */
@Controller
public class ProductControl {
    @Autowired
    private ProductService productService;
    @ModelAttribute("dir")
    public File pre(HttpServletRequest request) {
        File dir = new File(new File(request.getServletContext().getRealPath("/")), "product");
        System.out.println(request.getServletContext().getRealPath("/"));
        // 验证文件夹是否存在，不存在就新建
        if (!dir.exists()) {
            dir.mkdirs();
        }
        return dir;
    }
    @RequestMapping("/ProductUp")
    @ResponseBody
    public String addNavtable(@RequestParam(name = "files", required = false) CommonsMultipartFile[] files, @RequestParam(name = "files1", required = false) CommonsMultipartFile[] files1,@RequestParam(name = "files2", required = false) CommonsMultipartFile[] files2,@ModelAttribute(value = "dir") File dir
            , Product picture,Slider slider,Sliderdetail sliderdetail) throws IOException {
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
                    picture.setUrl("product"+File.separator+file1.getName());
                    boolean b1 = productService.addProduct(picture);
                    int i1 = productService.queryMax();
                    for (int j=0;j<files1.length;j++){
                        if (!files1[j].isEmpty() && files1[j].getSize() > 0) {
                            String fileName1 = files1[j].getOriginalFilename();
                            if (fileName1.endsWith(".jpg")||fileName1.endsWith(".png")){
                                if (fileName1.length() > 50) {
                                    fileName1 = fileName1.substring(fileName1.length() - 51);
                                }
                                File file2 = new File(dir,System.currentTimeMillis() +"_"+ fileName1);
                                files1[j].transferTo(file2);
                                sliderdetail.setUrl("product"+File.separator+file2.getName());
                                sliderdetail.setCid(i1);
                                boolean b = productService.addSliderdetail(sliderdetail);
                            }
                        }
                    }
                    for (int m=0;m<files2.length;m++){
                        if (!files2[m].isEmpty() && files2[m].getSize() > 0) {
                            String fileName2 = files2[m].getOriginalFilename();
                            if (fileName2.endsWith(".jpg")||fileName2.endsWith(".png")){
                                if (fileName2.length() > 50) {
                                    fileName2 = fileName2.substring(fileName2.length() - 51);
                                }
                                File file2 = new File(dir,System.currentTimeMillis() +"_"+ fileName2);
                                files2[m].transferTo(file2);
                                slider.setUrl("product"+File.separator+file2.getName());
                                slider.setCid(i1);
                                boolean b = productService.addSlider(slider);
                            }
                        }
                    }
                    return "true";
                }
                return "false";
            }
        }
        return "false";
    }
    //删除产品图片
    @RequestMapping("/removeProduct")
    @ResponseBody
    public boolean removeProduct(int id,HttpServletRequest request){
        Product product= productService.queryProductById(id);
        String url = product.getUrl();
        String s = request.getServletContext().getRealPath("/") + url;
        File file=new File(s);
        file.delete();
        boolean a=false;
        boolean a1=false;
        List<Slider> sliders = productService.querySlider(id);
        for (Slider ss:sliders){
            String url1 = ss.getUrl();
            String s1 = request.getServletContext().getRealPath("/") + url1;
            File file1=new File(s1);
            file1.delete();
            a =productService.deSlider(id);
        }
        List<Sliderdetail> sliderdetails = productService.querySliderdetail(id);
        for (Sliderdetail ss:sliderdetails){
            String url1 = ss.getUrl();
            String s1 = request.getServletContext().getRealPath("/") + url1;
            File file1=new File(s1);
            file1.delete();
            a1 =productService.deSliderdetail(id);
        }
        boolean b=productService.deProduct(id);
        return b;
    }
    @RequestMapping("/queryProduct")
    @ResponseBody
    public List<Product> queryProduct(Product product,Page page){
        page.setPage(page.getPage()-1);
        page.setRows(10);
        return productService.queryProduct(product,page);
    }
    @RequestMapping("/queryProductClolor")
    @ResponseBody
    public List<Color> queryProductColor(String color){
        String[] split = color.split("\\,");
        List<Color> list=new ArrayList<>();
        for (String s:split) {
            int i = Integer.parseInt(s);
            Color color1 = productService.queryProductColor(i);
            list.add(color1);
        }
        return list;
    }
    @RequestMapping("/querySlider")
    @ResponseBody
    public List<Slider> querySlider(int id){
        return productService.querySlider(id);
    }
    @RequestMapping("/querySliderdetail")
    @ResponseBody
    public List<Sliderdetail> querySliderdetail(int id){
        return productService.querySliderdetail(id);
    }
}
