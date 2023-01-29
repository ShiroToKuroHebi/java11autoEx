package api_objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ResultDto {
    @JsonProperty("country")
    List<CountryDto> countryList;
    String name;
}
