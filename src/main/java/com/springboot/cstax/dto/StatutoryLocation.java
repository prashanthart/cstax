
package com.springboot.cstax.dto;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatutoryLocation {

    @JsonProperty("statutoryClassificationCode")
    public String statutoryClassificationCode;
    @JsonProperty("locations")
    public List<Location> locations;
}
