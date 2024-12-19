package fabiano.poke.sortMethods;

import fabiano.poke.external.pokemonApi.pokemonApiDtos.PokemonResponse;

import java.util.List;

public interface SortMethod {
    void execute(List<PokemonResponse> pokemonList);
}

