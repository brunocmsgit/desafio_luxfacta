package br.com.luxfacta.dto.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@Data
@JsonPropertyOrder({"views", "votes"})
public class StatsResponseDTO {
	
	@JsonProperty("views")
	private Integer views;
	
	@JsonProperty("votes")
	private List<VotesResponseDTO> votes;

}
