package fabiano.poke.external.pokemon;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import fabiano.poke.external.pokemon.dtos.PokemonListResponse;

@Component
public class PokemonClient {

    private final RestTemplate restTemplate;

    private final static String host = "https://pokeapi.co/api/v2";

    private final static int limit = 1000;


    public PokemonClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder
                .defaultHeader("Content-Type", "application/json")
                .build();
    }

    public PokemonListResponse listAll() {
        return restTemplate.getForObject(host + "/pokemon?limit=" + limit, PokemonListResponse.class);
    }

}
