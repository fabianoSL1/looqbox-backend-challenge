package fabiano.poke.controllers;

import fabiano.poke.dtos.PokemonHighlightResult;
import fabiano.poke.dtos.PokemonResult;
import fabiano.poke.enums.SortOption;
import fabiano.poke.services.PokemonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RequestMapping("/pokemons")
@RestController
public class PokemonController {

    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping()
    public ResponseEntity<PokemonResult> getPokemon(
            @RequestParam(required = false) String query,
            @RequestParam(required = false, defaultValue = "alphabetical") SortOption sort
    ) {
        var pokemonList = query != null ? pokemonService.getByName(query) : pokemonService.getAll();

        pokemonService.sort(pokemonList, sort);

        var result = new PokemonResult(pokemonService.toStringList(pokemonList));

        return ResponseEntity.ok(result);
    }

    @GetMapping("/highlight")
    public ResponseEntity<PokemonHighlightResult> getPokemonHighlight(
            @RequestParam(required = false) Optional<String> query,
            @RequestParam(required = false, defaultValue = "alphabetical") SortOption sort
    ) {
        var pokemonList = query.isPresent() ? pokemonService.getByName(query.get()) : pokemonService.getAll();

        pokemonService.sort(pokemonList, sort);

        var result = new PokemonHighlightResult(pokemonService.toHighlightList(pokemonList, query.orElse("")));

        return ResponseEntity.ok(result);
    }
}
