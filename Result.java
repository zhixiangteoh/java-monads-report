/**
 * Andrés Castaño. 2016. Monads for Java developers, Part 2. (November 2016). 
 * Retrieved November 6, 2020, from 
 * https://medium.com/@afcastano/monads-for-java-developers-part-2-the-result-and-log-monads-a9ecc0f231bb
 * 
 * This class is referenced from Andrés Castaño's medium article on Monads for Java developers,
 * where he implements the Result class.
 * 
 * This class, along with ResultTest.java, was referenced to devise the 2-parametrized Either<E, A> class,
 * discussed in my Monads for the Java developer Term Paper for CS2104 (NUS Semester 1 2020-2021), 
 * written along with my teammates Ryan Tay and Ye Guoquan.
 */

import java.util.function.Function;
import java.util.Optional;

public class Result<A> {
    private Optional<A> a;
    private Optional<String> error;

    private Result(A aVal, String error) {
        this.a = Optional.ofNullable(aVal);
        this.error = Optional.ofNullable(error);
    }
    public static <A> Result<A> unit(A a) {
        return new Result<>(a, null);
    }
    public static <A> Result<A> unit(String error) {
        return new Result<>(null, error);
    }
    public <B> Result<B> bind(Function<A, Result<B>> f) {
        if (!isError()) return f.apply(a.get());
        else return Result.unit(error.get());
    }
    boolean isError() {
        return error.isPresent();
    }
    public String toString() {
        if (!error.isPresent()) return "Right " + a.get();
        else return "Left " + error.get();
    }
}