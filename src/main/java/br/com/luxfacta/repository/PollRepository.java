package br.com.luxfacta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.luxfacta.entity.Poll;

@Repository
public interface PollRepository extends JpaRepository<Poll, Long>{

}
