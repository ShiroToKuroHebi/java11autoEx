package api_objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CountryDto {
    @JsonProperty("country_id")
    String countryId;
    String probability;
}
