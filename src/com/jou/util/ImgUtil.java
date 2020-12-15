package com.jou.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ImgUtil {
    public static int WIDTH=200;
    public static int HEIGHT=100;
    public static int PADDING=10;

    public static void writeCodeToStream(String code, OutputStream os) throws IOException {
        BufferedImage bi=new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
        Graphics g= bi.getGraphics();
        g.setColor(Color.PINK);
        g.fillRect(0,0,WIDTH,HEIGHT);
        g.setColor(Color.BLACK);
        g.drawLine(0,0,WIDTH,HEIGHT);
        g.setColor(Color.BLUE);
        g.setFont(new Font(Font.SERIF,Font.BOLD,HEIGHT-PADDING*4));
        g.drawString(code,10,HEIGHT-10);
        g.dispose();
//        FileOutputStream fos=new FileOutputStream("D:/Temp/code.jpg");
        ImageIO.write(bi,"JPEG",os);
    }

//    产生随机字符
    public static String randomStr(){
        StringBuffer bu=new StringBuffer();
        for (int i=0;i<4;i++){
            char c= (char) (Math.random()*26+'A');
            bu.append(c);
        }
        return bu.toString();
    }

    public static void main(String[] args) throws IOException {
        FileOutputStream fos=new FileOutputStream("D:/Temp/code.jpg");
        writeCodeToStream(randomStr(),fos);
    }
}
