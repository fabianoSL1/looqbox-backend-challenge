package fabiano.poke.sort;


import fabiano.poke.enums.SortOption;
import fabiano.poke.exceptions.SortMethodNotFound;
import fabiano.poke.sort.impl.SortMethodAlphabetic;
import fabiano.poke.sort.impl.SortMethodLength;

public class SortMethodFactory {
    
    private SortMethodFactory() {
        throw new IllegalStateException("Factory class");
    }

    public static SortMethod createSortMethod(SortOption option) {
        switch (option) {
            case LENGTH -> {
                return new SortMethodLength();
            }

            case ALPHABETIC -> {
                return new SortMethodAlphabetic();
            }

            default -> throw new SortMethodNotFound(option.name());
        }
    }

}
