package br.com.luxfacta.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.luxfacta.controlleradvice.CustomNotFoundException;
import br.com.luxfacta.dto.request.PollRequestDTO;
import br.com.luxfacta.dto.response.PollCreateResponseDTO;
import br.com.luxfacta.dto.response.PollResponseDTO;
import br.com.luxfacta.dto.response.StatsResponseDTO;
import br.com.luxfacta.dto.response.VotesResponseDTO;
import br.com.luxfacta.entity.Option;
import br.com.luxfacta.entity.Poll;
import br.com.luxfacta.repository.OptionRepository;
import br.com.luxfacta.repository.PollRepository;

@Service
public class PollService {

	@Autowired
	private PollRepository pollRepository;
	
	@Autowired
	private OptionRepository optionRepository;
	
	public PollCreateResponseDTO createPoll(PollRequestDTO pollRequestDTO) {
		ModelMapper mapper = new ModelMapper();
		
		Poll poll = mapper.map(pollRequestDTO, Poll.class);
				
		List<Option> options = new ArrayList<>();
		
		Option option;
		
		for(String optionString : pollRequestDTO.getOptions()) {
			option = new Option();
			option.setPoll(poll);
			option.setOptionDescription(optionString);
			option.setQty(0);
			options.add(option);
		}
		
		poll.setViews(0);
		poll.setOptions(options);
		
		pollRepository.save(poll);
		
		PollCreateResponseDTO pollCreateResponseDTO = new PollCreateResponseDTO();
		pollCreateResponseDTO.setPollId(poll.getPollId());
		
		return pollCreateResponseDTO;
		
	}
	
	public PollResponseDTO findById (Long id) {
		ModelMapper mapper = new ModelMapper();
		Optional<Poll> poll = pollRepository.findById(id);
		
		if (!poll.isPresent()) {
			throw new CustomNotFoundException();
		}
		
		poll.get().setViews(Integer.sum(poll.get().getViews(), 1));
		pollRepository.save(poll.get());
		
		return mapper.map(poll.get(), PollResponseDTO.class);
	}
	
	public void registerVote(Long id) {
		Optional<Option> option = optionRepository.findById(id);
		
		if (!option.isPresent()) {
			throw new CustomNotFoundException();
		}
		
		option.get().setQty(Integer.sum(option.get().getQty(), 1));
		optionRepository.save(option.get());
	}
	
	public StatsResponseDTO getStats(Long id) {
		Optional<Poll> poll = pollRepository.findById(id);
		
		if (!poll.isPresent()) {
			throw new CustomNotFoundException();
		}
		
		StatsResponseDTO statsResponseDTO = new StatsResponseDTO();
		
		if (!poll.get().getOptions().isEmpty() ) {
			
			List<VotesResponseDTO> votesResponseDTOList = new ArrayList<>();
						
			poll.get().getOptions().forEach(o -> {
				VotesResponseDTO votesResponseDTO = new VotesResponseDTO();
				votesResponseDTO.setOptionId(o.getOptionId());
				votesResponseDTO.setQty(o.getQty());
				votesResponseDTOList.add(votesResponseDTO);	
			});
			
			statsResponseDTO.setVotes(votesResponseDTOList);
			statsResponseDTO.setViews(poll.get().getViews());
		}
		return statsResponseDTO;
	}
	
}
