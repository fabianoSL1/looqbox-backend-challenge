package fabiano.poke.services;

import fabiano.poke.dtos.PokemonHighlight;
import fabiano.poke.enums.SortOption;
import fabiano.poke.external.pokemonApi.PokemonClient;
import fabiano.poke.external.pokemonApi.pokemonApiDtos.PokemonResponse;
import fabiano.poke.facotories.SortMethodFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PokemonService {

    private final PokemonClient pokemonClient;

    PokemonService(PokemonClient pokemonClient) {
        this.pokemonClient = pokemonClient;
    }

    public List<PokemonResponse> getAll() {
        return this.pokemonClient.listAll().getResults();
    }

    public List<PokemonResponse> getByName(String name) {
        return this.pokemonClient.listAll().getResults()
                .stream()
                .filter(pokemon -> pokemon.getName().contains(name))
                .collect(Collectors.toList());
    }

    public void sort(List<PokemonResponse> pokemonList, SortOption sortOption) {
        var sortMethod = SortMethodFactory.createSortMethod(sortOption);
        sortMethod.execute(pokemonList);
    }

    public List<String> toStringList(List<PokemonResponse> pokemonList) {
        return pokemonList.stream().map(PokemonResponse::getName).toList();
    }

    public List<PokemonHighlight> toHighlightList(List<PokemonResponse> pokemonList, String highlight) {
        return pokemonList.stream()
                .map(pokemon -> new PokemonHighlight(pokemon.getName(), highlight))
                .toList();
    }
}
