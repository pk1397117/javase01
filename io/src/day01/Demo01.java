package day01;

import java.io.*;
import java.net.URL;
import java.util.Scanner;

public class Demo01 {

    public static void main(String[] args) {
        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            in = new FileInputStream("F:/zzz/a.jpg");
            out = new FileOutputStream("F:/zzz/b.jpg");
            //方式一
//            byte[] bytes = in.readAllBytes(); //读取所有字节
//            out.write(bytes);

            //方式二
//            long l = in.transferTo(out); //返回所读的总字节，也就是文件的大小
//            System.out.println(l);

            //方式三
//            int byteData;
//            while((byteData = in.read()) != -1){
//                out.write(byteData);
//            }

            //方式四
//            int len;
//            byte [] bytes = new byte[1020];
//            while((len = in.read(bytes)) != -1){
//                out.write(bytes,0,len);
//            }

            //方式五
            int bytesAvailable = in.available(); //获取数据源剩余数据总字节数
            if (bytesAvailable > 0){
                byte[] bytes = new byte[bytesAvailable];
                //剩余数据一次读写
                in.read(bytes);
                out.write(bytes);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
