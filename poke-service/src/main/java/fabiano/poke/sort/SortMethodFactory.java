package fabiano.poke.sort;


import fabiano.poke.enums.SortOption;
import fabiano.poke.sort.impl.SortMethodAlphabetic;
import fabiano.poke.sort.impl.SortMethodLength;

public class SortMethodFactory {
    
    private SortMethodFactory() {
        throw new IllegalStateException("Factory class");
    }

    public static SortMethod createSortMethod(SortOption option) {
        return switch (option) {
            case LENGTH -> new SortMethodLength();
            case ALPHABETIC -> new SortMethodAlphabetic();
        };
    }

}
