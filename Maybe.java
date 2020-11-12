/**
 * This is a Maybe class written in the flavor of the Maybe monad in Haskell. This Maybe class is
 * discussed in my Monads for the Java developer Term Paper for CS2104 (NUS Semester 1 2020-2021), 
 * written along with my teammates Ryan Tay and Ye Guoquan.
 */

import java.util.function.Function;

class Maybe<A> {
    private A a;

    private Maybe(A aVal) {
        if (!isNull(aVal)) a = aVal;
        else a = null;
    }
    public static <A> Maybe<A> unit(A a) {
        return new Maybe<>(a);
    }
    public <B> Maybe<B> bind(Function<A, Maybe<B>> f) {
        if (!isNull(a)) return f.apply(a);
        else return new Maybe<B>(null);
    }
    boolean isNull(A a) {
        return a == null;
    }
    public String toString() {
        if (!isNull(a)) return "Just " + a;
        else return "Nothing";
    }
    public static void main(String[] args) {
        Maybe<Integer> a = Maybe.unit(3);
        Maybe<Integer> b = Maybe.unit(null);
        
        Maybe<Integer> sum = 
            a.bind(val1 -> 
            b.bind(val2 -> 
            Maybe.unit(val1 + val2)  
        ));

        System.out.println(sum); // Nothing
    }
}