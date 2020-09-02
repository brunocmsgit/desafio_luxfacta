package br.com.luxfacta.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@Data
@JsonPropertyOrder({"option_id", "qty"})
public class VotesResponseDTO {
	
	@JsonProperty("option_id")
	private Long optionId;
	
	@JsonProperty("qty")
	private Integer qty;

}
