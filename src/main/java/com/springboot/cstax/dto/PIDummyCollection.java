
package com.springboot.cstax.dto;


import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="PiDummyCollection")
public class PIDummyCollection {

	@Id
	public String id; 
    @JsonProperty("taxPolicyEligibilitySolutions")
    public List<TaxPolicyEligibilitySolution> taxPolicyEligibilitySolutions;


}
