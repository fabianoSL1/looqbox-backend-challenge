package fabiano.poke.dtos;

public abstract class Result<T> {

    private final T result;

    protected Result(T result) {
        this.result = result;
    }

    public T getResult() {
        return result;
    }
}
