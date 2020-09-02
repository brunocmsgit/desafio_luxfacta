package br.com.luxfacta.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.luxfacta.dto.request.PollRequestDTO;
import br.com.luxfacta.dto.response.PollCreateResponseDTO;
import br.com.luxfacta.dto.response.PollResponseDTO;
import br.com.luxfacta.dto.response.StatsResponseDTO;
import br.com.luxfacta.service.PollService;

@RestController
@RequestMapping("/poll")
public class PollController {
	
	@Autowired
	private PollService pollService;
	
	@PostMapping
	public ResponseEntity<PollCreateResponseDTO> createPoll(@RequestBody @Valid PollRequestDTO pollRequestDTO){
		return ResponseEntity.ok(pollService.createPoll(pollRequestDTO));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PollResponseDTO> findById(@PathVariable Long id){
		return ResponseEntity.ok(pollService.findById(id));
	}
	
	@PostMapping("/{id}/vote")
	public void registerVote(@PathVariable Long id){
		pollService.registerVote(id);
	}
	
	@GetMapping("/{id}/stats")
	public ResponseEntity<StatsResponseDTO> getStats(@PathVariable Long id){
		return ResponseEntity.ok(pollService.getStats(id));
	}
}
