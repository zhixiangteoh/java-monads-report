/**
 * Oleg Šelajev. 2015. Unlocking the Magic of Monads in Java 8. (2 June 2015). 
 * Retrieved November 6, 2020 from https://www.youtube.com/watch?v=nkUafcNWiQE&ab_channel=OracleDevelopers
 * 
 * This class is referenced from Oleg Šelajev's talk on "Unlocking the Magic of Monads in Java 8",
 * where he implements the Promise class.
 */

public class Promise<V> {
    // ... Fields, Constructors and other methods ...

    public static <V> Promise<V> unit(final V v) {
        Promise<V> p = new Promise<>();
        p.invoke();
        return p;
    }
    public <R> Promise<R> bind(Function<V, Promise<R>> f) {
        Promise<R> result = new Promise<>();
        this.onRedeem(callback -> {
            V v = callback.get();
            Promise<R> applicationResult = function.apply(v);
            applicationResult.onRedeem(c -> {
                R r = c.get();
                result.invoke(r);
            });
        });
        return result;
    }
    public V get() throws InterruptedException, ExecutionException {
        taskLock.await();
        if (exception != null) {
            throw new ExecutionException(exception);
        }
        return result;
    }
}
