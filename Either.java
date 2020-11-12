/**
 * Andrés Castaño. 2016. Monads for Java developers, Part 2. (November 2016). 
 * Retrieved November 6, 2020, from 
 * https://medium.com/@afcastano/monads-for-java-developers-part-2-the-result-and-log-monads-a9ecc0f231bb
 * 
 * ResultTest.java, along with Result.java, was referenced to devise the 2-parametrized Either<E, A> class,
 * discussed in my Monads for the Java developer Term Paper for CS2104 (NUS Semester 1 2020-2021), 
 * written along with my teammates Ryan Tay and Ye Guoquan.
 */

import java.util.function.Function;
import java.util.Optional;

public class Either<E, A> {
    private Optional<E> error;
    private Optional<A> a;
    
    private Either(E error, A a) {
        this.error = Optional.ofNullable(error);
        this.a     = Optional.ofNullable(a);
    }
    public static <E, A> Either<E, A> unit(E error, A a) {
        if (error != null) return new Either<>(error, null);
        else return new Either<>(null, a);
    }
    public <B> Either<E, B> bind(Function<A, Either<E, B>> f) {
        if (!isError()) return f.apply(a.get());
        else return Either.unit(error.get(), (B) null);
    }
    boolean isError() {
        return error.isPresent();
    }
    public String toString() {
        if (!error.isPresent()) return "Right " + a.get();
        else return "Left " + error.get();
    }
}
