/**
 * Andrés Castaño. 2016. Monads for Java developers, Part 2. (November 2016). 
 * Retrieved November 6, 2020, from 
 * https://medium.com/@afcastano/monads-for-java-developers-part-2-the-result-and-log-monads-a9ecc0f231bb
 * 
 * ResultTest.java, along with Result.java, was referenced to devise the 2-parametrized Either<E, A> class,
 * discussed in my Monads for the Java developer Term Paper for CS2104 (NUS Semester 1 2020-2021), 
 * written along with my teammates Ryan Tay and Ye Guoquan.
 */

public class EitherTest {
    public static void main(String[] args) {
        Either<Exception, Integer> a = either(3);
        Either<Exception, Integer> b = either(5);
        Either<Exception, Integer> c = either(null);
    
        Either<Exception, Integer> sum = 
            a.bind(e1 -> 
            b.bind(e2 -> 
            either(e1 + e2)
        ));

        Either<Exception, Integer> sum1 = 
            a.bind(e1 -> 
            c.bind(e2 -> 
            either(e1 + e2)
        ));

        System.out.println(sum);  // Right 8
        System.out.println(sum1); // Left java.lang.NumberFormatException
    }

    private static Either<Exception, Integer> either(Integer value) {
        if (value == null) return Either.unit(new NumberFormatException(), null);
        else return Either.unit(null, value);
    }
}
