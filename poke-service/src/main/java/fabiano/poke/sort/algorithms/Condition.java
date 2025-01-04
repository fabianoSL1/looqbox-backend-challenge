package fabiano.poke.sort.algorithms;

import fabiano.poke.external.pokemon.dtos.PokemonResponse;

public interface Condition {

    boolean execute(PokemonResponse left, PokemonResponse right);
}
