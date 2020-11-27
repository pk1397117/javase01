package stream.stream01;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo03 {

    public static void main(String[] args) throws IOException {

        //读取文件字符串
        String contents = new String(Files.readAllBytes(Paths.get("advanced/src/stream/stream01/alice.txt")), StandardCharsets.UTF_8);
        //提取单词字符串数组
        String[] split = contents.split("[^a-zA-Z’]+");
        //字符串数组转字符串集合
        List<String> words = List.of(split);

        //distinct(不同的),去除重复元素
        System.out.println(Stream.of(1, 2, 1, 2, 2, 3).distinct().collect(Collectors.toList()));

        //排序
        Stream<String> longestFirst = words.stream().sorted(Comparator.comparing(String::length).reversed());
        System.out.println(longestFirst.collect(Collectors.toList()));

        System.out.println(Stream.of(new Person("张三三", 15), new Person("李四", 20), new Person("王五", 18)).sorted(Comparator.comparing(e -> e.getName().length())).collect(Collectors.toList()));

        Stream<String> sorted = Stream.of("111", "22", "3333").sorted(Comparator.comparing(e -> e.length()));

        //peek(),只有操作元素时才调用
        words.stream().peek(e -> System.out.println(e)).count();//此处没有操作元素，所以不会调用方法


    }



}
