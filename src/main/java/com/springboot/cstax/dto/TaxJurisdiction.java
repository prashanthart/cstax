
package com.springboot.cstax.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaxJurisdiction {

    @JsonProperty("jurisdictionID")
    public String jurisdictionID;
    @JsonProperty("jurisdictionCode")
    public JurisdictionCode jurisdictionCode;
    @JsonProperty("jurisdictionLevelCode")
    public JurisdictionLevelCode jurisdictionLevelCode;
}
