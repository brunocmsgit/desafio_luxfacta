package br.com.luxfacta.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class PollCreateResponseDTO {
	
	@JsonProperty("poll_id")
	private Long pollId;

}
