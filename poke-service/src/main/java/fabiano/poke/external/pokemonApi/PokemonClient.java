package fabiano.poke.external.pokemonApi;

import fabiano.poke.external.pokemonApi.pokemonApiDtos.PokemonListResponse;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PokemonClient {

    private final RestTemplate restTemplate;

    private final String host = "https://pokeapi.co/api/v2";

    private final int LIMIT = 1000;


    public PokemonClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder
                .defaultHeader("Content-Type", "application/json")
                .build();
    }

    public PokemonListResponse listAll() {
        return restTemplate.getForObject(host + "/pokemon?limit=" + LIMIT, PokemonListResponse.class);
    }

}
