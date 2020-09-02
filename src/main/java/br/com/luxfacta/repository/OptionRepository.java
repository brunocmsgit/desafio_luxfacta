package br.com.luxfacta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.luxfacta.entity.Option;

@Repository
public interface OptionRepository extends JpaRepository<Option, Long>{

}
