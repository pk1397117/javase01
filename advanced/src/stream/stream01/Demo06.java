package stream.stream01;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo06 {

    public static void main(String[] args) {

        Stream<String> ids = Stream.of("zhangsan","","lisi",null);

        //map(R r),将r封装进Stream<R>
//        Stream<User> userStream = ids.map(User::lookup)
//                .filter(Optional::isPresent)
//                .map(Optional::get);
        //flatMap(R r),返回r
        Stream<User> userStream1 = ids.map(User::lookup)
                .flatMap(Optional::stream);


        List<User> users = userStream1.collect(Collectors.toList());
        System.out.println(users);
        User[] users1 = Stream.of("zhangsan", "", "lisi", null)
                .map(User::lookup)
                .flatMap(Optional::stream)
                .toArray(User[]::new);
        System.out.println(Arrays.toString(users1));

        List<User> users2 = Stream.of("zhangsan", "", "lisi", null)
                .map(User::lookup)
                .flatMap(Optional::stream)
                .collect(Collectors.toList());

    }

}
