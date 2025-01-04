package fabiano.poke.sort.algorithms;

import java.util.List;

import fabiano.poke.external.pokemon.dtos.PokemonResponse;


/*
 * https://www.baeldung.com/java-quicksort
 *
 * Livro entendendo algoritmos
*/
public class QuickSort {

    private final Condition condition;

    public QuickSort(Condition condition) {
        this.condition = condition;
    }

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

            if (this.condition.execute(current, pivot)) {
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
