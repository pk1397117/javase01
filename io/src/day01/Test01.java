package day01;







import org.junit.Test;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test01 {

    @Test
    public void test01() {
        System.out.println(File.separator);
    }

    @Test
    public void test02() {
        try (FileInputStream fin = new FileInputStream("F:/zzz/aaa.txt");
             DataInputStream din = new DataInputStream(fin);
        ) {
            double x = din.read();
            System.out.println(x);
            System.out.println((char) 104);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test03() {
        try (InputStreamReader in = new InputStreamReader(new FileInputStream("F:/zzz/aaa.txt"), "GBK");
             OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream("F:/zzz/bbb.txt"), "utf8");
        ) {
            int codepoint;
            while ((codepoint = in.read()) != -1) {
                System.out.print((char) codepoint);
                out.write(codepoint);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test04() {
        try (InputStreamReader in = new InputStreamReader(new FileInputStream("F:/zzz/aaa.txt"), "GBK");
             PrintWriter out = new PrintWriter("F:/zzz/bbb.txt", StandardCharsets.UTF_8);
        ) {
            int codepoint;
            while ((codepoint = in.read()) != -1) {
                System.out.print((char) codepoint);
                out.write(codepoint);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test05() {
        String s = null;
        try {
            s = Files.readString(Path.of("F:/zzz/aaa.txt"), Charset.forName("GBK"));
            System.out.println(s);

            Stream<String> lines = Files.lines(Path.of("F:/zzz/aaa.txt"), Charset.defaultCharset());
            List<String> collect = lines.collect(Collectors.toList());
            System.out.println(collect);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test06() {
        try {
            Scanner in = new Scanner(Path.of("F:/zzz/aaa.txt"));
            in.useDelimiter("[^a-zA-Z]+"); //按照正则表达式作为分隔符
            while (in.hasNext()) {
                System.out.println(in.next());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test07() {
        try {
            Scanner in = new Scanner(Path.of("F:/zzz/aaa.txt"));
            Stream<String> tokens = in.tokens(); //获取所有字符的流
            String[] strings = tokens.toArray(String[]::new);
            for (String string : strings) {
                System.out.println(string);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 读写二进制数据
     */
    @Test
    public void test08() {
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream("F:/zzz/ccc.txt"));
        ){
//            for (int i = 65;i<=90;i++){
//                out.write(i);
//            }
            out.writeBytes("ABCD");


        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
