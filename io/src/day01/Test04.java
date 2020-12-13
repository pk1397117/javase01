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
 * 文件操作
 */
public class Test04 {
    /**
     * 读取文件数据
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
     * 解析路径
     * p.resolve(q)
     * 若q为绝对路径，则结果为q
     * 若q为相对路径，则结果为p\q
     * <p>
     * 解析父路径，返回兄弟路径
     * p.resolveSibling(q)
     * 若q为绝对路径，则结果为q
     * 若q为相对路径，则结果为..\q
     */
    @Test
    public void test02() {
        //基目录
        Path baseDir = Path.of("resources");

        //解析路径
        Path aaa = baseDir.resolve("aaa.txt"); //相对路径
        System.out.println(aaa); // resources\aaa.txt

        Path root = baseDir.resolve("E:/"); //绝对路径
        System.out.println(root); // E:\

        //解析父路径,返回兄弟路径
        //若是绝对路径则同上
        Path day01 = baseDir.resolveSibling("day01").toAbsolutePath();
        System.out.println(day01); // E:\Program Files\javase\io\day01

        //获取相对路径
        Path relativize = baseDir.relativize(aaa);
        System.out.println(relativize);

        //通过路径对象创建文件对象
        File file = aaa.toFile();
    }

    /**
     * 读写文件
     * 简单的读写方法
     * 适用于中等长度的文本文件
     * 长度过大建议使用I/O流
     */
    @Test
    public void test03() throws IOException {
        Path path = Paths.get("resources/bbb.txt");
        Files.writeString(path, "456789一二三", StandardCharsets.UTF_8);
        System.out.println(Files.readString(path, Charset.forName("UTF-8")));
    }

    /**
     * 通过路径创建输出流
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
     * 复制文件
     *
     * @throws IOException
     */
    @Test
    public void test06() throws IOException {
        Files.copy(Paths.get("resources/bbb.txt"), Paths.get("resources/ddd.txt"), StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.COPY_ATTRIBUTES);
    }

    /**
     * s删除文件
     *
     * @throws IOException
     */
    @Test
    public void test07() throws IOException {
        Files.delete(Paths.get("resources/ddd.txt"));
        Files.delete(Paths.get("resources/dir"));
    }

    /**
     * 移动文件
     * @throws IOException
     */
    @Test
    public void test08() throws IOException {
        Files.move(Paths.get("resources/dir/ddd.txt"),Paths.get("resources/ddd.txt"));
    }

    /**
     *获取文件属性
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
