package fabiano.poke.exceptions;

public class SortMethodNotFound extends RuntimeException {

    public SortMethodNotFound(String message) {
        super("sort method not found: " + message);
    }

}
