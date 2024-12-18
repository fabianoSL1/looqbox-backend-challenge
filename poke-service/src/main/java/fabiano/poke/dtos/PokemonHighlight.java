package fabiano.poke.dtos;

public class PokemonHighlight {

    private final String name;

    private final String highlight;


    public PokemonHighlight(String name, String highlight) {
        this.name = name;
        this.highlight = highlight;
    }

    public String getName() {
        return name;
    }

    public String getHighlight() {
        return highlight;
    }
}
