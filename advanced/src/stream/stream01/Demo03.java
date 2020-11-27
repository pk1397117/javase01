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

        //��ȡ�ļ��ַ���
        String contents = new String(Files.readAllBytes(Paths.get("advanced/src/stream/stream01/alice.txt")), StandardCharsets.UTF_8);
        //��ȡ�����ַ�������
        String[] split = contents.split("[^a-zA-Z��]+");
        //�ַ�������ת�ַ�������
        List<String> words = List.of(split);

        //distinct(��ͬ��),ȥ���ظ�Ԫ��
        System.out.println(Stream.of(1, 2, 1, 2, 2, 3).distinct().collect(Collectors.toList()));

        //����
        Stream<String> longestFirst = words.stream().sorted(Comparator.comparing(String::length).reversed());
        System.out.println(longestFirst.collect(Collectors.toList()));

        System.out.println(Stream.of(new Person("������", 15), new Person("����", 20), new Person("����", 18)).sorted(Comparator.comparing(e -> e.getName().length())).collect(Collectors.toList()));

        Stream<String> sorted = Stream.of("111", "22", "3333").sorted(Comparator.comparing(e -> e.length()));

        //peek(),ֻ�в���Ԫ��ʱ�ŵ���
        words.stream().peek(e -> System.out.println(e)).count();//�˴�û�в���Ԫ�أ����Բ�����÷���


    }



}
