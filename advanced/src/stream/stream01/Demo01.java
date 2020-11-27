package stream.stream01;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo01 {

    public static void main(String[] args) throws IOException {

//        File directory = new File("./");
//        System.out.println(directory.getAbsolutePath());

        byte[] bytes = Files.readAllBytes(Paths.get("advanced/src/stream/stream01/alice.txt"));

        String contents = new String(bytes, StandardCharsets.UTF_8);

        String[] split = contents.split("\\PL+");

        //String[] split = contents.split("[^a-zA-Z’]+");

        List<String> words = List.of(split);

        System.out.println(words);

        //使用for循环计数
        int count1 = 0;
        for (String word : words) {
            if (word.length()>5){
                count1++;
            }
        }
        System.out.println("count1: "+count1);

        //使用stream
        long count2 = words.stream().filter(w -> w.length() > 5).count();
        System.out.println("count2: "+count2);

        Map<String,Integer> map = new HashMap<>(){{put("张三",15);put("李四",20);put("王五",17);}};

//        int[] numbers = {1,2,3,4,5,6,7,8,9};
//
//        List<int[]> list = Stream.of(numbers).filter(n -> n.length==9).collect(Collectors.toList());//元素变成int[]
//        System.out.println(Arrays.toString(list.get(0)));

        Integer[] numbers = {1,2,3,4,5,6,7,8,9};
        Integer[] integers = Stream.of(numbers).filter(n -> n > 4).toArray(Integer[]::new);
        List<Integer> list = Stream.of(numbers).filter(n -> n > 4).collect(Collectors.toList());
        System.out.println(Arrays.toString(integers));
        System.out.println(list);

        List<Integer> list1 = Arrays.stream(numbers, 2,numbers.length).collect(Collectors.toList());//左闭右开
        System.out.println(list1);

        //空流
        Stream<String> empty = Stream.empty();
        empty.forEach(System.out::println);


        //无限流
        Stream<String> echos = Stream.generate(() -> "Echo");
        Stream<Double> randoms = Stream.generate(Math::random);

        List<BigInteger> integers1 = Stream.iterate(BigInteger.ZERO, n -> n.compareTo(new BigInteger("100"))<0, n -> n.add(BigInteger.ONE)).collect(Collectors.toList());
        System.out.println(integers1);

        List<BigInteger> integers2 = Stream.iterate(BigInteger.ZERO, n -> n.intValue()<200, n -> n.add(BigInteger.ONE)).collect(Collectors.toList());
        System.out.println(integers2);

        //
        Stream<String> wordsStream= Pattern.compile("[^a-zA-Z’]+").splitAsStream(contents);
        List<String> strings = wordsStream.collect(Collectors.toList());
        System.out.println(strings);
        long you = strings.stream().filter(w -> w.equals("you")).count();
        System.out.println(you);

        
    }
}
