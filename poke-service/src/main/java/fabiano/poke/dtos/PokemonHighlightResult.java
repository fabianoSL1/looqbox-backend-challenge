package fabiano.poke.dtos;

import java.util.List;

public class PokemonHighlightResult extends Result<List<PokemonHighlight>> {

    public PokemonHighlightResult(List<PokemonHighlight> result) {
        super(result);
    }

}
