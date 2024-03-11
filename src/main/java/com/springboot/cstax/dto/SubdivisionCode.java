
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
public class SubdivisionCode {

    @JsonProperty("code")
    public String code;
    @JsonProperty("name")
    public String name;
    @JsonProperty("subdivisionType")
    public String subdivisionType;

}
