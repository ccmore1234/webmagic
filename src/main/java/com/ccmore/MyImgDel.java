package com.ccmore;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class MyImgDel  {
    //todo splitNums可以根据你给到的图片色差进行调整，在你自己使用时，可以针对splitNums做一个循环，每次加多少，得到不同的色差比的二值化后的图片，因为不同的图片可能干扰线、干扰点颜色原因，二值化后会有差异
    //todo splitWidthNum：把图片根据长度切分的分数，这个可以根据你图片中的数字个数进行切分
    public static final int splitNums=4000000;
    public static final int splitWidthNum=5;
    public static void main(String[] args) {
        String path="F://image.jpg";
        try{
            BufferedImage img=removeBackgroud(path);
            ImageIO.write(img, "JPG", new File("F://test1-1.jpg"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public static BufferedImage removeBackgroud(String picFile)
            throws Exception {
        BufferedImage img = ImageIO.read(new File(picFile));

        img = img.getSubimage(1, 1, img.getWidth()-2, img.getHeight()-2);
        int width = img.getWidth();
        int height = img.getHeight();
        double subWidth = (double) width/(splitWidthNum+0.0);
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < splitWidthNum; i++) {

            //todo 以下是对图片进行二值化处理，在这里我的思路是规定，色差范围在splitNums到负splitNums之间的，算是同色，放入同一个色值，放入一个map中，map中的Key放色值，value放这个色值得个数，后期就根据这个色值来对验证码进行二值化
            for (int x = (int) (1 + i * subWidth); x < (i + 1) * subWidth && x < width - 1; ++x) {
                for (int y = 0; y < height; ++y) {
                    if (isWhite(img.getRGB(x, y)) == 1){
                        continue;
                    }
                    Map<Integer, Integer> map2 = new HashMap<Integer, Integer>();
                    for (Integer color : map.keySet()) {
                        map2.put(color,map.get(color));
                    }

                    for (Integer color : map2.keySet()) {
                        System.out.println(Math.abs(color)-Math.abs(img.getRGB(x, y)));
                        if (Math.abs(color)-Math.abs(img.getRGB(x, y))<splitNums&&Math.abs(color)-Math.abs(img.getRGB(x, y))>-splitNums){
                            map.put(color, map.get(color) + 1);
                        }else{
                            map.put(img.getRGB(x, y), 1);
                        }
                    }
                    if (map.isEmpty()){
                        map.put(img.getRGB(x, y), 1);
                    }
                }
            }
            System.out.println("==============================");

            int max = 0;
            int colorMax = 0;
            for (Integer color : map.keySet()) {
                if (max < map.get(color)) {
                    max = map.get(color);
                    colorMax = color;
                }
            }

            for (int x = (int) (1 + i * subWidth); x < (i + 1) * subWidth&& x < width - 1; ++x) {
                for (int y = 0; y < height; ++y) {
                    int ress=Math.abs(img.getRGB(x, y))-Math.abs(colorMax);
                    if (ress<splitNums&&ress>-splitNums) {
                        img.setRGB(x, y, Color.WHITE.getRGB());
                    } else {
                        img.setRGB(x, y, Color.BLACK.getRGB());
                    }
                }
            }
        }
        return img;
    }

    //todo 判断是否为白色的方法
    public static int isWhite(int colorInt) {
        Color color = new Color(colorInt);
        if (color.getRed() + color.getGreen() + color.getBlue()>600) {
            return 1;
        }
        return 0;
    }

}
