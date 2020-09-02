package br.com.luxfacta.dto.request;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.Data;

@Data
public class PollRequestDTO {
	
	@NotEmpty
	@JsonAlias("poll_description")
	private String pollDescription;
	
	@NotEmpty
	private List<String> options;

}
