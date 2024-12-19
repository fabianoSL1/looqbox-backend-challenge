package fabiano.poke.facotories;


import fabiano.poke.enums.SortOption;
import fabiano.poke.exceptions.SortMethodNotFound;
import fabiano.poke.sortMethods.SortMethod;
import fabiano.poke.sortMethods.SortMethodAlphabetic;
import fabiano.poke.sortMethods.SortMethodLength;

public class SortMethodFactory {

    public static SortMethod createSortMethod(SortOption option) {
        switch (option) {
            case LENGTH -> {
                return new SortMethodLength();
            }

            case ALPHABETICAL -> {
                return new SortMethodAlphabetic();
            }

            default -> throw new SortMethodNotFound(option.name());
        }
    }

}
