package fabiano.poke.sortMethods;


import fabiano.poke.enums.SortOption;
import fabiano.poke.exceptions.SortMethodNotFound;
import fabiano.poke.sortMethods.impl.SortMethodAlphabetic;
import fabiano.poke.sortMethods.impl.SortMethodLength;

public class SortMethodFactory {

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
