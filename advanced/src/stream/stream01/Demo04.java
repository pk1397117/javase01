package stream.stream01;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo04 {

    public static void main(String[] args) throws IOException {

        //提取字符串
        String contents = new String(Files.readAllBytes(Paths.get("advanced/src/stream/stream01/alice.txt")),StandardCharsets.UTF_8);
        //提取单词到字符串数组
        String[] split = contents.split("[^a-zA-Z’]+");
        //字符串数组转字符串集合
        List<String> words = List.of(split);
        System.out.println("words: "+words);

        //获取流中的最大值
        Optional<String> largest = words.stream().max(String::compareToIgnoreCase);//字典顺序忽略大小写
        System.out.println("largest: "+largest.orElse(""));//为null就返回other
        //找到流中第一个以字母D开头的单词
        Optional<String> startWithD = words.stream().filter(e -> e.startsWith("D")).findFirst(); //Dream
        System.out.println("startWithD: "+startWithD.orElse(""));

        //找到任意一个以字母T开头的单词(适用于并行流)
        Optional<String> startWithT = words.parallelStream().filter(e -> e.startsWith("T")).findAny();
        System.out.println("startWithT: "+startWithT.orElse(""));

        //判断是否存在,存在返回true,不存在返回false
        boolean q = words.stream().anyMatch(e -> e.startsWith("Q"));
        //判断是否不存在,不存在返回true,存在返回false
        boolean d = words.stream().noneMatch(e -> e.startsWith("D"));
        System.out.println(q+" "+d);

        //Optional为空时的替代方法
        Optional<String> q1 = words.stream().filter(e -> e.startsWith("Q")).findFirst();
        //Optional<T>为空时,自定义返回为T的函数
        String result = q1.orElseGet(() -> System.getProperty("myapp.default"));
        System.out.println(result);
        //Optional为空时抛出异常
        //String s = q1.orElseThrow(IllegalAccessError::new);

        //Optional不为空时的消费方法
        Optional<String> d1 = words.stream().filter(e -> e.startsWith("D")).findFirst();
        //存在就将值传递给一个Consumer
        d1.ifPresent(v -> System.out.println(v));
        //ifPresentOrElse方法包含存在和不存在时的两种不同操作
        d1.ifPresentOrElse(v -> System.out.println(v),() -> System.out.println("null"));

        //使用map来转换Optional对象内部的值
        Optional<String> q2 = words.stream().findFirst().map(String::toUpperCase);
        System.out.println(q2.get()); //THERE

        

    }
}
