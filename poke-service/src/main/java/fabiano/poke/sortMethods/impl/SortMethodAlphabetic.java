package fabiano.poke.sortMethods.impl;

import fabiano.poke.external.pokemonApi.pokemonApiDtos.PokemonResponse;
import fabiano.poke.sortMethods.SortMethod;

import java.util.List;

public class SortMethodAlphabetic implements SortMethod {

    @Override
    public void execute(List<PokemonResponse> pokemonList) {
        quickSort(pokemonList, 0, pokemonList.size() - 1);
    }

    private void quickSort(List<PokemonResponse> pokemonList, int start, int end) {
        if (start < end) {
            int pivot = partition(pokemonList, start, end);

            quickSort(pokemonList, start, pivot - 1);
            quickSort(pokemonList, pivot + 1, end);
        }
    }

    private int partition(List<PokemonResponse> pokemonList, int start, int end) {
        var pivot = pokemonList.get(end);
        int i = start - 1;

        for (int j = start; j < end; j++) {
            var current = pokemonList.get(j);

            if (current.getName().compareTo(pivot.getName()) < 0) {
                i++;

                swap(pokemonList, i, j);
            }
        }

        swap(pokemonList, i + 1, end);
        return i + 1;
    }

    private void swap(List<PokemonResponse> pokemonList, int i, int j) {
        var temp = pokemonList.get(i);
        pokemonList.set(i, pokemonList.get(j));
        pokemonList.set(j, temp);
    }

}
