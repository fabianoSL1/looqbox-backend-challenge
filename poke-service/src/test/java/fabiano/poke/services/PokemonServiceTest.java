package fabiano.poke.services;

import fabiano.poke.enums.SortOption;
import fabiano.poke.external.pokemon.dtos.PokemonResponse;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class PokemonServiceTest {

    @InjectMocks
    private PokemonService pokemonService;

    @Test
    void givenList_whenSortedByAlphabet_thenSortedCorrectly() {
        var expect = List.of(
            createPokemonResponse("A"),
            createPokemonResponse("B"),
            createPokemonResponse("C")
        );

        var toSort = Arrays.asList(
            createPokemonResponse("B"),
            createPokemonResponse("C"),
            createPokemonResponse("A")
        );

        pokemonService.sort(toSort, SortOption.ALPHABETIC);

        Assertions.assertEquals(expect.get(0).getName(), toSort.get(0).getName());
        Assertions.assertEquals(expect.get(1).getName(), toSort.get(1).getName());
        Assertions.assertEquals(expect.get(2).getName(), toSort.get(2).getName());
    }

    @Test
    void givenList_whenSortedByLength_thenSortedCorrectly() {
        var expect = List.of(
                createPokemonResponse("A"),
                createPokemonResponse("AA"),
                createPokemonResponse("AAA")
        );

        var toSort = Arrays.asList(
                createPokemonResponse("AAA"),
                createPokemonResponse("A"),
                createPokemonResponse("AA")
        );

        pokemonService.sort(toSort, SortOption.LENGTH);

        Assertions.assertEquals(expect.get(0).getName(), toSort.get(0).getName());
        Assertions.assertEquals(expect.get(1).getName(), toSort.get(1).getName());
        Assertions.assertEquals(expect.get(2).getName(), toSort.get(2).getName());
    }

    private PokemonResponse createPokemonResponse(String name) {
        var pokemon = new PokemonResponse();

        pokemon.setName(name);
        pokemon.setUrl("");

        return pokemon;
    }
}
