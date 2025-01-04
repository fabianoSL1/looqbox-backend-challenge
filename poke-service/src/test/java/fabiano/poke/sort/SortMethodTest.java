package fabiano.poke.sort;

import fabiano.poke.enums.SortOption;
import fabiano.poke.sort.impl.SortMethodAlphabetic;
import fabiano.poke.sort.impl.SortMethodLength;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SortMethodTest {

    @Test
    void when_lengthOption_then_SortMethodLength() {

        var input = SortOption.valueOf("LENGTH");
        var response = SortMethodFactory.createSortMethod(input);
        Assertions.assertInstanceOf(SortMethodLength.class, response);
    }


    @Test
    void when_alphabeticOption_then_SortMethodAlphabetic() {
        var input = SortOption.valueOf("ALPHABETIC");
        var response = SortMethodFactory.createSortMethod(input);
        Assertions.assertInstanceOf(SortMethodAlphabetic.class, response);
    }

}
