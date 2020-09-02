package br.com.luxfacta.dto.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@Data
@JsonPropertyOrder({"poll_id", "poll_description"})
public class PollResponseDTO {
	
	@JsonProperty("poll_id")
	private Long pollId;
	@JsonProperty("poll_description")
	private String pollDescription;
	private List<OptionResponseDTO> options;

}
