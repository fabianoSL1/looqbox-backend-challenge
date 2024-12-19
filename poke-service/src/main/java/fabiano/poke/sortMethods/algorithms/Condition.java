package fabiano.poke.sortMethods.algorithms;

import fabiano.poke.external.pokemonApi.pokemonApiDtos.PokemonResponse;

public interface Condition {

    boolean execute(PokemonResponse left, PokemonResponse right);
}
