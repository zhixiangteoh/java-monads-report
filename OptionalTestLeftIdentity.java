/**
 * Marcello La Rocca. 2016. How Optional Breaks the Monad Laws and Why It Matters. (September 2016). 
 * Retrieved November 6, 2020 from https://www.sitepoint.com/how-optional-breaks-the-monad-laws-and-why-it-matters/
 * 
 * This code is referenced from Marcello La Rocca's sitepoint article.
 * 
 * This test for conformity to the Monad law of Left Identity is discussed in my Monads for the Java developer 
 * Term Paper for CS2104 (NUS Semester 1 2020-2021), written along with my teammates Ryan Tay and Ye Guoquan.
 */

import java.util.function.Function;
import java.util.Optional;

public class OptionalTestLeftIdentity {
    public static void main(String[] args) {
        Function<Integer, Optional<Integer>> f = (x -> {
            if (x == null) return Optional.ofNullable(-1);
            else return Optional.ofNullable(null);
        });
        System.out.println(Optional.ofNullable((Integer) null).flatMap(f).equals(f.apply(null))); // false
    }    
}
