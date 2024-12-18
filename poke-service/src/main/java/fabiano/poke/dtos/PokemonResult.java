package fabiano.poke.dtos;

import java.util.List;

public class PokemonResult extends Result<List<String>> {

    public PokemonResult(List<String> result) {
        super(result);
    }
}
