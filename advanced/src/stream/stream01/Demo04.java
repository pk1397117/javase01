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

        //��ȡ�ַ���
        String contents = new String(Files.readAllBytes(Paths.get("advanced/src/stream/stream01/alice.txt")),StandardCharsets.UTF_8);
        //��ȡ���ʵ��ַ�������
        String[] split = contents.split("[^a-zA-Z��]+");
        //�ַ�������ת�ַ�������
        List<String> words = List.of(split);
        System.out.println("words: "+words);

        //��ȡ���е����ֵ
        Optional<String> largest = words.stream().max(String::compareToIgnoreCase);//�ֵ�˳����Դ�Сд
        System.out.println("largest: "+largest.orElse(""));//Ϊnull�ͷ���other
        //�ҵ����е�һ������ĸD��ͷ�ĵ���
        Optional<String> startWithD = words.stream().filter(e -> e.startsWith("D")).findFirst(); //Dream
        System.out.println("startWithD: "+startWithD.orElse(""));

        //�ҵ�����һ������ĸT��ͷ�ĵ���(�����ڲ�����)
        Optional<String> startWithT = words.parallelStream().filter(e -> e.startsWith("T")).findAny();
        System.out.println("startWithT: "+startWithT.orElse(""));

        //�ж��Ƿ����,���ڷ���true,�����ڷ���false
        boolean q = words.stream().anyMatch(e -> e.startsWith("Q"));
        //�ж��Ƿ񲻴���,�����ڷ���true,���ڷ���false
        boolean d = words.stream().noneMatch(e -> e.startsWith("D"));
        System.out.println(q+" "+d);

        //OptionalΪ��ʱ���������
        Optional<String> q1 = words.stream().filter(e -> e.startsWith("Q")).findFirst();
        //Optional<T>Ϊ��ʱ,�Զ��巵��ΪT�ĺ���
        String result = q1.orElseGet(() -> System.getProperty("myapp.default"));
        System.out.println(result);
        //OptionalΪ��ʱ�׳��쳣
        //String s = q1.orElseThrow(IllegalAccessError::new);

        //Optional��Ϊ��ʱ�����ѷ���
        Optional<String> d1 = words.stream().filter(e -> e.startsWith("D")).findFirst();
        //���ھͽ�ֵ���ݸ�һ��Consumer
        d1.ifPresent(v -> System.out.println(v));
        //ifPresentOrElse�����������ںͲ�����ʱ�����ֲ�ͬ����
        d1.ifPresentOrElse(v -> System.out.println(v),() -> System.out.println("null"));

        //ʹ��map��ת��Optional�����ڲ���ֵ
        Optional<String> q2 = words.stream().findFirst().map(String::toUpperCase);
        System.out.println(q2.get()); //THERE

        

    }
}
