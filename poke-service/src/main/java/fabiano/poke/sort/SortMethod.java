package fabiano.poke.sort;

import java.util.List;

import fabiano.poke.external.pokemon.dtos.PokemonResponse;

public interface SortMethod {
    void execute(List<PokemonResponse> pokemonList);
}

