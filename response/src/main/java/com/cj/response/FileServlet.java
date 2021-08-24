package com.cj.response;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * @author CJ
 * @date 2021/7/9 10:30
 */
public class FileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 1. 获取需要下载的文件的输入流
//        String realPath = this.getServletContext().getRealPath("/1.jpg");
        String realPath = "C:\\Users\\Administrator\\Desktop\\UselessProject\\javaweb-demo\\response\\src\\main\\resources";
        String fileName = "1.jpg";
        FileInputStream fis = new FileInputStream(realPath + "\\" + fileName);

        // 2. 设置响应头，让浏览器下载文件(如果不设置，会显示图片而不会下载);中文文件名使用URLEncoder.encode编码，否则有可能乱码
        resp.setHeader("Content-Disposition","attachment; filename=" + fileName + URLEncoder.encode(fileName,"UTF-8"));

        // 3. 获取响应的输出流
        ServletOutputStream os = resp.getOutputStream();

        // 4. 创建缓冲区，将FileOutputStream通过缓冲区写入到响应中
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = fis.read(buffer)) > 0) {
            os.write(buffer,0,len);
        }

        fis.close();
        os.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
