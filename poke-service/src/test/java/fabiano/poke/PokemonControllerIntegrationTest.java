package fabiano.poke;

import fabiano.poke.dtos.PokemonHighlight;
import fabiano.poke.dtos.PokemonHighlightResult;
import fabiano.poke.dtos.PokemonResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.List;

/*
 * https://www.baeldung.com/spring-boot-testing
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class PokemonControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void givenValidRequest_whenGetPokemon_thenOk() throws Exception {
        var response = restTemplate.getForEntity("/pokemons", PokemonResult.class);
        Assertions.assertEquals(200, response.getStatusCode().value());

        var body = response.getBody();

        if (body != null) {
            Assertions.assertNotNull(body.getResult());
        }

    }

    @Test
    public void givenQuery_whenGetPokemon_thenAlphabeticOrder() throws Exception {
        var expect = List.of("bulbasaur", "ivysaur", "venusaur");

        var response = restTemplate.getForEntity("/pokemons?query=saur", PokemonResult.class);
        Assertions.assertEquals(200, response.getStatusCode().value());

        var body = response.getBody();

        if (body != null) {
            Assertions.assertEquals(expect.get(0), body.getResult().get(0));
            Assertions.assertEquals(expect.get(1), body.getResult().get(1));
            Assertions.assertEquals(expect.get(2), body.getResult().get(2));
        }
    }

    @Test
    public void givenQueryAndSortByLength_whenGetPokemon_thenLengthOrder() throws Exception {
        var expect = List.of("ivysaur", "venusaur", "bulbasaur");

        var response = restTemplate.getForEntity("/pokemons?query=saur&sort=length", PokemonResult.class);
        Assertions.assertEquals(200, response.getStatusCode().value());

        var body = response.getBody();

        if (body != null) {
            Assertions.assertEquals(expect.get(0), body.getResult().get(0));
            Assertions.assertEquals(expect.get(1), body.getResult().get(1));
            Assertions.assertEquals(expect.get(2), body.getResult().get(2));
        }
    }

    @Test
    public void givenValidRequest_whenGetPokemonHighlight_thenOk() throws Exception {
        var response = restTemplate.getForEntity("/pokemons/highlight", PokemonHighlightResult.class);

        Assertions.assertEquals(200, response.getStatusCode().value());

        var body = response.getBody();

        if (body != null) {
            Assertions.assertNotNull(body.getResult());
            Assertions.assertInstanceOf(PokemonHighlight.class, body.getResult().get(0));
        }
    }

}
