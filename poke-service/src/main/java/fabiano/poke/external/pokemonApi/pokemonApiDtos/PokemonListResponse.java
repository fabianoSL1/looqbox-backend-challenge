package fabiano.poke.external.pokemonApi.pokemonApiDtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonListResponse {

    private String next;

    private List<PokemonResponse> results;

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public List<PokemonResponse> getResults() {
        return results;
    }

    public void setResults(List<PokemonResponse> results) {
        this.results = results;
    }
}

