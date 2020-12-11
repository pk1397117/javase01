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
            //��ʽһ
//            byte[] bytes = in.readAllBytes(); //��ȡ�����ֽ�
//            out.write(bytes);

            //��ʽ��
//            long l = in.transferTo(out); //�������������ֽڣ�Ҳ�����ļ��Ĵ�С
//            System.out.println(l);

            //��ʽ��
//            int byteData;
//            while((byteData = in.read()) != -1){
//                out.write(byteData);
//            }

            //��ʽ��
//            int len;
//            byte [] bytes = new byte[1020];
//            while((len = in.read(bytes)) != -1){
//                out.write(bytes,0,len);
//            }

            //��ʽ��
            int bytesAvailable = in.available(); //��ȡ����Դʣ���������ֽ���
            if (bytesAvailable > 0){
                byte[] bytes = new byte[bytesAvailable];
                //ʣ������һ�ζ�д
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
