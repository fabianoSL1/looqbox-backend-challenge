package fabiano.poke.sortMethods.impl;

import fabiano.poke.external.pokemonApi.pokemonApiDtos.PokemonResponse;
import fabiano.poke.sortMethods.SortMethod;
import fabiano.poke.sortMethods.algorithms.QuickSort;

import java.util.List;

public class SortMethodLength implements SortMethod {

    @Override
    public void execute(List<PokemonResponse> pokemonList) {
        var quickSort = new QuickSort((left, right) -> left.getName().length() <= right.getName().length());
        quickSort.execute(pokemonList);
    }

}
