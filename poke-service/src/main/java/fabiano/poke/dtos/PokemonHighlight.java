package fabiano.poke.dtos;

public class PokemonHighlight {

    private final String name;

    private final String highlight;


    public PokemonHighlight(String name, String highlight) {
        this.name = name;

        if (!highlight.isBlank()) {
            this.highlight = name.replace(highlight, "<pre>" + highlight + "</pre>");
        } else {
            this.highlight = highlight;
        }
    }

    public String getName() {
        return name;
    }

    public String getHighlight() {
        return highlight;
    }
}
