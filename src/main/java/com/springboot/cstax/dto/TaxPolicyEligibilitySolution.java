
package com.springboot.cstax.dto;


import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaxPolicyEligibilitySolution {

    @JsonProperty("statutoryLocations")
    public List<StatutoryLocation> statutoryLocations;
    @JsonProperty("policies")
    public List<Policy> policies;

}
