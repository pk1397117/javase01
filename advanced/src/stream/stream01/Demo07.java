package stream.stream01;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.Serializable;
import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo07 {

    public static void main(String[] args) {

        String collect = Stream.of("zhangsan", "list", "wangwu", "zhaoliu")
                .collect(Collectors.joining(", "));
        System.out.println(collect);
        //Í³¼Æ (count, sum, min, average, max)
        IntSummaryStatistics collect1 = Stream.of("zhangsan", "list", "wangwu", "zhaoliu", 5)
                .map(e -> ((Comparable) e).toString())
                .collect(Collectors.summarizingInt(String::length));
        System.out.println(collect1);



    }
}
