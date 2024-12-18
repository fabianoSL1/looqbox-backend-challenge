package fabiano.poke.controllers;

import fabiano.poke.dtos.PokemonHighlight;
import fabiano.poke.dtos.PokemonHighlightResult;
import fabiano.poke.dtos.PokemonResult;
import fabiano.poke.enums.SortOption;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequestMapping("/pokemons")
@RestController
public class PokemonController {

    @GetMapping()
    public ResponseEntity<PokemonResult> getPokemon(
            @RequestParam(required = false) String query,
            @RequestParam(required = false, defaultValue = "alphabetical") SortOption sort
    ) {

        var result = new PokemonResult(List.of("pidgey", "pidgeotto", "pidgeot"));

        if (sort.equals(SortOption.LENGTH)) {
            result = new PokemonResult(List.of("pidgeotto", "pidgeot", "pidgey"));
        }

        return ResponseEntity.ok(result);
    }

    @GetMapping("/highlight")
    public ResponseEntity<PokemonHighlightResult> getPokemonHighlight(
            @RequestParam(required = false) String query,
            @RequestParam(required = false, defaultValue = "alphabetical") SortOption sort
    ) {
        var result = new PokemonHighlightResult(List.of(new PokemonHighlight("pichu", "<pre>pi</pre>chu")));

        return ResponseEntity.ok(result);
    }
}
