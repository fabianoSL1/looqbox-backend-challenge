package fabiano.poke.dtos;

public abstract class Result<T> {

    private final T result;

    public Result(T result) {
        this.result = result;
    }

    public T getResult() {
        return result;
    }
}
