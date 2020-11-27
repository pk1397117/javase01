package stream.stream01;

public class Demo08 {

    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "hello";
        String s3 = new String("hello");
        String s4 = new String("hello");
        System.out.println(System.identityHashCode(s1));
        System.out.println(System.identityHashCode(s2));
        System.out.println(System.identityHashCode(s3));
        System.out.println(System.identityHashCode(s4));
        System.out.println(System.identityHashCode(new String("hello")));
        int i = 10;
        System.out.println("i=" + System.identityHashCode(i));
        new Thread(new Runnable() {
            @Override
            public void run() {
                String s1 = "hello";
                System.out.println("new" + System.identityHashCode(new String("hello")));
                String s2 = s4;
                System.out.println("s2" + s2);
                int i1 = 10;
                System.out.println("i1=" + System.identityHashCode(i1));
            }
        }).start();

    }

}

