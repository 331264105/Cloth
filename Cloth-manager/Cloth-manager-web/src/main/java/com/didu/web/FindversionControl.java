package com.didu.web;

        import com.didu.domain.Findversion;
        import com.didu.domain.Findversionpic;
        import com.didu.service.FindversionService;
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
 * Created by Administrator on 2017/12/4.
 */
@Controller
public class FindversionControl {
    @Autowired
    private FindversionService findversionService;
    @ModelAttribute("dir")
    public File pre(HttpServletRequest request) {
        File dir = new File(new File(request.getServletContext().getRealPath("/")), "findversion");
        // 验证文件夹是否存在，不存在就新建
        if (!dir.exists()) {
            dir.mkdirs();
        }
        return dir;
    }
    //添加找版图片
    @RequestMapping("/addFindversionpic")
    @ResponseBody
    public boolean FindversionUp(@RequestParam(name = "files", required = false) CommonsMultipartFile[] files, @ModelAttribute(value = "dir") File dir
            ,Findversionpic findversionpic) throws IOException {
        System.err.println(findversionpic.getId());
        boolean a =false;
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
                    System.err.println(file1.toString());
                    files[i].transferTo(file1);
                    findversionpic.setUrl("findversion/"+file1.getName());
                    findversionpic.setUid(findversionpic.getUid());
                    a = findversionService.addFindversionpic(findversionpic);
                }
            }
        }
        if (a){
            return true;
        }else {
            return false;
        }
    }
    public synchronized String createSerial() {
        String s = "DBL" + System.currentTimeMillis();
        return s;
    }
    //添加找版信息
    @RequestMapping("/addFindversion")
    @ResponseBody
    public int addseller(Findversion seller){
        synchronized(this.getClass()){
            String str = createSerial();
            seller.setSerial(str);
        }
        boolean addseller = findversionService.addFindversion(seller);
        int id = findversionService.queryIdByuid(seller.getUid());
        if (addseller){
            return id;
        }else {
            return  0;
        }
    }
    //删除找版
    @RequestMapping("/removeFindversion")
    @ResponseBody
    public boolean removeFindversion(Findversion findversion,HttpServletRequest request){
        List<Findversionpic> findversions= findversionService.queryFindversionpicByid(findversion.getId());
        boolean a = false;
        for (Findversionpic f:findversions) {
            String url = f.getUrl();
            String s = request.getServletContext().getRealPath("/") + url;
            File file = new File(s);
            file.delete();
            a = findversionService.deFindversionpic(f.getId());
        }
        if (a) {
            boolean b = findversionService.deFindversion(findversion);
            return b;
        }else {
            return a;
        }
    }
    @RequestMapping("/queryFindversion")
    @ResponseBody
    public List<Findversion> queryFindversion(String status,int uid){
        List<Findversion> fs = findversionService.queryFindversion(status,uid);
        for (Findversion f:fs){
            List<Findversionpic> fps = findversionService.queryFindversionpicByid(f.getId());
            f.setFindversionpics(fps);
        }
        return fs;
    }
}
