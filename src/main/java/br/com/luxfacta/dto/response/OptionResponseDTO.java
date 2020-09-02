package br.com.luxfacta.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@Data
@JsonPropertyOrder({"option_id", "option_description"})
public class OptionResponseDTO {
	
	@JsonProperty("option_id")
	private Long optionId;
	@JsonProperty("option_description")
	private String optionDescription;

}
