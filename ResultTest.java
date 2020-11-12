/**
 * Andrés Castaño. 2016. Monads for Java developers, Part 2. (November 2016). 
 * Retrieved November 6, 2020, from 
 * https://medium.com/@afcastano/monads-for-java-developers-part-2-the-result-and-log-monads-a9ecc0f231bb
 * 
 * This class is referenced from Andrés Castaño's medium article on Monads for Java developers,
 * where he implements the Result class.
 * 
 * This class, along with Result.java, was referenced to devise the 2-parametrized Either<E, A> class,
 * discussed in my Monads for the Java developer Term Paper for CS2104 (NUS Semester 1 2020-2021), 
 * written along with my teammates Ryan Tay and Ye Guoquan.
 */
    
public class ResultTest {
    public static void main(String[] args) {
        Result<Integer> a = getResultValue(3);
        Result<Integer> b = getResultValue(null);
        
        Result<Integer> sum = 
            a.bind(val1 -> 
            b.bind(val2 -> 
            Either.unit(val1 + val2)  
        ));

        System.out.println(sum); // Left Value is null!
    }

    private static Result<Integer> getResultValue(Integer value) {
        if (value == null) return Result.unit("Value is null!");
        else return Result.unit(value);
    }
}
