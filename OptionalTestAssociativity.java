/**
 * This test for conformity to the Monad law of Associativity is discussed in my Monads for the Java developer 
 * Term Paper for CS2104 (NUS Semester 1 2020-2021), written along with my teammates Ryan Tay and Ye Guoquan.
 */

import java.util.function.Function;
import java.util.Optional;

public class OptionalTestAssociativity {
    public static void main(String[] args) {
        Function<Integer, Optional<Integer>> f = x -> (x % 2 == 0) ? Optional.ofNullable(null) : Optional.ofNullable(x);
        Function<Integer, Optional<Integer>> g = y -> y == null    ? Optional.ofNullable(null) : Optional.ofNullable(y);

        Optional<Integer> m = Optional.of(2);
        boolean isAssociative = m.flatMap(f).flatMap(g).equals(m.flatMap(y -> f.apply(y).flatMap(g)));
        System.out.println(isAssociative); // true
    }
}
