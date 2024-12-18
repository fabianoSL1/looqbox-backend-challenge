package fabiano.poke.config.converter;

import fabiano.poke.enums.SortOption;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/*
 *
 * https://www.baeldung.com/spring-enum-request-param
 */
@Component
public class SortOptionConverter implements Converter<String, SortOption> {
    @Override
    public SortOption convert(String value) {
        return SortOption.valueOf(value.toUpperCase());
    }

}
