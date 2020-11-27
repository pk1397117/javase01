package stream.stream01;

import java.util.Optional;

public class Demo05 {

    public static void main(String[] args) {

        Optional<Double> result = inverse(5.0).flatMap(Demo05::squareRoot);
        Optional<Double> result1 = Optional.of(4.0).flatMap(Demo05::inverse).flatMap(Demo05::squareRoot);
        System.out.println(result);
        System.out.println(result1);




    }

    public static Optional<Double> inverse(Double x){
        return x == 0 ? Optional.empty() : Optional.of(1 / x);
    }

    public static Optional<Double> squareRoot(Double x){
        return x < 0 ? Optional.empty() : Optional.of(Math.sqrt(x));
    }


}
