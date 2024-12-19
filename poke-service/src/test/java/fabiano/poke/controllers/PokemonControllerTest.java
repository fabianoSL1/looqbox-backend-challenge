package fabiano.poke.controllers;

import fabiano.poke.exceptions.PokemonApiException;
import fabiano.poke.services.PokemonService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(PokemonController.class)
public class PokemonControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockitoBean
    private PokemonService pokemonService;

    @Test
    public void givenValidRequest_whenPokemonServiceThrowsException_thenReturnsBadGateway() throws Exception {
        Mockito.when(pokemonService.getAll()).thenThrow(new PokemonApiException("any exception"));

        mvc.perform(MockMvcRequestBuilders.get("/pokemons"))
                .andExpect(MockMvcResultMatchers.status().isBadGateway());
    }

}
