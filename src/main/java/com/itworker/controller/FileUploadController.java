package com.itworker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;

/**
 * Created by GIOPPL
 * on 2020/10/24 20:35
 * TODO:
 */
@Controller
@RequestMapping("/file")
public class FileUploadController {
    /**
     * 文件上传SpringMVC方式
     */
    @RequestMapping(value = "/fileUpload")
    public  @ResponseBody
    String fileUpload(HttpServletRequest request, MultipartFile upload) throws Exception {
        System.out.println("SpringMVC文件上传...");
//        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        String path = request.getSession().getServletContext().getRealPath("/images/");
        //判断该路径是否存在
        File file = new File(path);
        if (!file.exists()) {
            //创建该文件夹
            boolean mkdirs = file.mkdirs();
            System.out.println("文件夹是否创建成功" + mkdirs + "  " + file.getAbsolutePath());
        }
        //文件项
        String filename = upload.getOriginalFilename();
        //把文件名称设为唯一值
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid + "_" + filename;
        upload.transferTo(new File(path,filename));

        return "http://m.bujiangwude.work:8080/ssm_war/images/"+filename;
    }
    /**
     * 文件上传SpringMVC方式
     */
    @RequestMapping(value = "/fileUpload2")
    public  @ResponseBody String fileUpload2(HttpServletRequest request, MultipartFile upload) throws Exception {
        System.out.println("SpringMVC文件上传...");

        //使用fileUpload组件完成文件上传
        //上传的位置
//        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        String path = "D:/upload/";
        //判断该路径是否存在
        File file = new File(path);
        if (!file.exists()) {
            //创建该文件夹
            boolean mkdirs = file.mkdirs();
            System.out.println("文件夹是否创建成功" + mkdirs + "  " + file.getAbsolutePath());
        }
        //文件项
        String filename = upload.getOriginalFilename();
        //把文件名称设为唯一值
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid + "_" + filename;
        upload.transferTo(new File(path,filename));

        return "success";
    }

//    @RequestMapping(value = {"/img/render"}, method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
//    @CrossOrigin(origins = "*")
//    @ResponseBody
//    public String execute(HttpServletRequest httpServletRequest,
//                          HttpServletResponse httpServletResponse) throws IOException {
//        // img为图片的二进制流
//        byte[] img = ByteToFile(im);
//        httpServletResponse.setContentType("image/png");
//        OutputStream os = httpServletResponse.getOutputStream();
//        os.write(img);
//        os.flush();
//        os.close();
//        return "success";
//    }
//
//    public static byte[] fileToByte(File img) throws Exception {
//        byte[] bytes;
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        try {
//            BufferedImage bi;
//            bi = ImageIO.read(img);
//            ImageIO.write(bi, "jpg", baos);
//            bytes = baos.toByteArray();
//            System.err.println(bytes.length);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            baos.close();
//        }
//    }
}
