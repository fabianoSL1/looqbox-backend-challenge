package fabiano.poke.sort.impl;

import fabiano.poke.external.pokemon.dtos.PokemonResponse;
import fabiano.poke.sort.SortMethod;
import fabiano.poke.sort.algorithms.QuickSort;

import java.util.List;

public class SortMethodAlphabetic implements SortMethod {

    @Override
    public void execute(List<PokemonResponse> pokemonList) {
        var quickSort = new QuickSort((left, right) -> left.getName().compareTo(right.getName()) < 0);
        quickSort.execute(pokemonList);
    }

}
