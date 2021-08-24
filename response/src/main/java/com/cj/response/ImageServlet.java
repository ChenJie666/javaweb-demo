package com.cj.response;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @author CJ
 * @date 2021/7/9 11:51
 */
public class ImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BufferedImage image = new BufferedImage(80, 20, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = (Graphics2D) image.getGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, 80, 20);
        graphics.setColor(Color.RED);
        graphics.setFont(new Font(null, Font.BOLD, 20));
        graphics.drawString(getRandom(), 0, 20);

        resp.setContentType("image/jpg");
        resp.setHeader("refresh", "5");  // 页面5s刷新一次
        resp.setDateHeader("expires", -1);  // 不过期
        resp.setHeader("Cache-Control", "no-cache");  // 不缓存
        resp.setHeader("Pragma", "no-cache");  // 不缓存

        ImageIO.write(image, "jpg", resp.getOutputStream());
    }

    private String getRandom() {
        Random random = new Random();
        StringBuilder rand = new StringBuilder(random.nextInt(999999) + "");
        System.out.println("rand: " + rand);
        for (int i = 0; i < 7 - rand.length(); i++) {
            rand.append("0");
        }
        return rand.toString();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
