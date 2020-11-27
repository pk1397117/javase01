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

        //��ȡ�ļ��ַ���
        String contents = new String(Files.readAllBytes(Paths.get("advanced/src/stream/stream01/alice.txt")), StandardCharsets.UTF_8);
        //��ȡ�����ַ�������
        String[] split = contents.split("[^a-zA-Z��]+");
        //�ַ�������ת�ַ�������
        List<String> words = List.of(split);

        //���˳�������
        Stream<String> longWords = words.stream().filter(e -> e.length() > 9);
        System.out.println(longWords.count());

        //����������Ԫ��ת��ΪСд��ĸ
        Stream<String> lowercaseWords = words.stream().map(String::toLowerCase);

        //��ȡ���е�������ĸ
        Stream<String> firstLetters = words.stream().map(e -> e.substring(0, 1));

        //������
        Stream<Stream<String>> result = words.stream().map(e -> codePoints(e));
        //ʹ��flatMap��������ƽ̯Ϊ������
        Stream<String> flatResult = words.stream().flatMap(e -> codePoints(e));

        //limit(n)�ü���(����������),������Ԫ�ظ���С��n���ȡȫ����
        Stream<Double> randoms = Stream.generate(Math::random).limit(5);

        //skip(n)����ǰn��Ԫ��
        Stream<Integer> skip = Stream.of(1, 2, 3, 4, 5).skip(2);

        //takeWhile(predicate) ȡν��Ϊ��ʱ��Ԫ��ֱ��ν��Ϊ��ʱ����
        Stream.of("a", "a", "b", "a", "c").takeWhile(e -> e.equals("a")).collect(Collectors.toList());//ֻȡ���ڶ���a����
        //dropWhile(predicate) ν��Ϊ��ʱ����Ԫ��,��ȡ��һ��ν��Ϊ��ʱ��Ԫ���Լ�֮������Ԫ��
        Stream.of("a", "a", "b", "a", "c").dropWhile(e -> e.equals("a")).collect(Collectors.toList());//����ǰ����a,��ȡ֮���bac

        //concat(stream),�ϲ���
        Stream.concat(Stream.of(1, 2, 3), Stream.of(4, 5, 6)).collect(Collectors.toList());//[1,2,3,4,5,6]


    }

    /**
     * �ַ���ת��Ϊ�ַ�����(��ȷ������Ҫ����charֵ��ʾ��Unicode�ַ�)
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
