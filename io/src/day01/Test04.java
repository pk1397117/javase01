package day01;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

/**
 * �ļ�����
 */
public class Test04 {
    /**
     * ��ȡ�ļ�����
     */
    @Test
    public void test01() {
        //Path path = Path.of("day01");
        Path path = Paths.get("resources/aaa.txt");
        System.out.println(path.toAbsolutePath());
        try {
            String s = new String(Files.readAllBytes(path));
            System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * ����·��
     * p.resolve(q)
     * ��qΪ����·��������Ϊq
     * ��qΪ���·��������Ϊp\q
     * <p>
     * ������·���������ֵ�·��
     * p.resolveSibling(q)
     * ��qΪ����·��������Ϊq
     * ��qΪ���·��������Ϊ..\q
     */
    @Test
    public void test02() {
        //��Ŀ¼
        Path baseDir = Path.of("resources");

        //����·��
        Path aaa = baseDir.resolve("aaa.txt"); //���·��
        System.out.println(aaa); // resources\aaa.txt

        Path root = baseDir.resolve("E:/"); //����·��
        System.out.println(root); // E:\

        //������·��,�����ֵ�·��
        //���Ǿ���·����ͬ��
        Path day01 = baseDir.resolveSibling("day01").toAbsolutePath();
        System.out.println(day01); // E:\Program Files\javase\io\day01

        //��ȡ���·��
        Path relativize = baseDir.relativize(aaa);
        System.out.println(relativize);

        //ͨ��·�����󴴽��ļ�����
        File file = aaa.toFile();
    }

    /**
     * ��д�ļ�
     * �򵥵Ķ�д����
     * �������еȳ��ȵ��ı��ļ�
     * ���ȹ�����ʹ��I/O��
     */
    @Test
    public void test03() throws IOException {
        Path path = Paths.get("resources/bbb.txt");
        Files.writeString(path, "456789һ����", StandardCharsets.UTF_8);
        System.out.println(Files.readString(path, Charset.forName("UTF-8")));
    }

    /**
     * ͨ��·�����������
     */
    @Test
    public void test04() {
        try (BufferedReader in = Files.newBufferedReader(Paths.get("resources/bbb.txt"), StandardCharsets.UTF_8)) {
//            int codePoint;
//            while ((codePoint = in.read()) != -1){
//                System.out.print((char)codePoint);
//            }
            char[] chars = new char[3];
            int len;
            while ((len = in.read(chars)) != -1) {
                for (int i = 0; i < len; i++) {
                    System.out.print(chars[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * �����ļ�
     *
     * @throws IOException
     */
    @Test
    public void test06() throws IOException {
        Files.copy(Paths.get("resources/bbb.txt"), Paths.get("resources/ddd.txt"), StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.COPY_ATTRIBUTES);
    }

    /**
     * sɾ���ļ�
     *
     * @throws IOException
     */
    @Test
    public void test07() throws IOException {
        Files.delete(Paths.get("resources/ddd.txt"));
        Files.delete(Paths.get("resources/dir"));
    }

    /**
     * �ƶ��ļ�
     * @throws IOException
     */
    @Test
    public void test08() throws IOException {
        Files.move(Paths.get("resources/dir/ddd.txt"),Paths.get("resources/ddd.txt"));
    }

    /**
     *��ȡ�ļ�����
     * @throws IOException
     */
    @Test
    public void test09() throws IOException {
        BasicFileAttributes attributes = Files.readAttributes(Paths.get("resources/bbb.txt"), BasicFileAttributes.class);
        System.out.println(attributes.size());
        System.out.println(Files.getAttribute(Paths.get("resources/bbb.txt"), "isDirectory"));
        System.out.println(Files.getAttribute(Paths.get("resources/bbb.txt"), "fileKey"));
    }
}
