package stream.stream01;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo02 {

    public static void main(String[] args) throws IOException {

        //读取文件字符串
        String contents = new String(Files.readAllBytes(Paths.get("advanced/src/stream/stream01/alice.txt")), StandardCharsets.UTF_8);
        //提取单词字符串数组
        String[] split = contents.split("[^a-zA-Z’]+");
        //字符串数组转字符串集合
        List<String> words = List.of(split);

        //过滤出长单词
        Stream<String> longWords = words.stream().filter(e -> e.length() > 9);
        System.out.println(longWords.count());

        //将流中所有元素转化为小写字母
        Stream<String> lowercaseWords = words.stream().map(String::toLowerCase);

        //提取所有单词首字母
        Stream<String> firstLetters = words.stream().map(e -> e.substring(0, 1));

        //流中流
        Stream<Stream<String>> result = words.stream().map(e -> codePoints(e));
        //使用flatMap将流中流平摊为单个流
        Stream<String> flatResult = words.stream().flatMap(e -> codePoints(e));

        //limit(n)裁剪流(包括无限流),若流的元素个数小于n则截取全部流
        Stream<Double> randoms = Stream.generate(Math::random).limit(5);

        //skip(n)跳过前n个元素
        Stream<Integer> skip = Stream.of(1, 2, 3, 4, 5).skip(2);

        //takeWhile(predicate) 取谓词为真时的元素直到谓词为假时结束
        Stream.of("a", "a", "b", "a", "c").takeWhile(e -> e.equals("a")).collect(Collectors.toList());//只取到第二个a结束
        //dropWhile(predicate) 谓词为真时丢弃元素,截取第一个谓词为假时的元素以及之后所有元素
        Stream.of("a", "a", "b", "a", "c").dropWhile(e -> e.equals("a")).collect(Collectors.toList());//丢弃前两个a,获取之后的bac

        //concat(stream),合并流
        Stream.concat(Stream.of(1, 2, 3), Stream.of(4, 5, 6)).collect(Collectors.toList());//[1,2,3,4,5,6]


    }

    /**
     * 字符串转换为字符串流(正确处理需要两个char值表示的Unicode字符)
     * @param s
     * @return
     */
    public static Stream<String> codePoints(String s){
        ArrayList<String> result = new ArrayList<>();
        int i = 0;
        while (i < s.length()){
            int j = s.offsetByCodePoints(i, 1);
            result.add(s.substring(i,j));
            i = j;
        }
        return result.stream();
    }
}
