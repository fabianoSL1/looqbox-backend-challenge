package fabiano.poke.sortMethods.impl;

import fabiano.poke.external.pokemonApi.pokemonApiDtos.PokemonResponse;
import fabiano.poke.sortMethods.SortMethod;
import fabiano.poke.sortMethods.algorithms.QuickSort;

import java.util.List;

public class SortMethodAlphabetic implements SortMethod {

    @Override
    public void execute(List<PokemonResponse> pokemonList) {
        var quickSort = new QuickSort((left, right) -> left.getName().compareTo(right.getName()) < 0);
        quickSort.execute(pokemonList);
    }

}
