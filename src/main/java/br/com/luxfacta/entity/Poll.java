package br.com.luxfacta.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
@Entity
@Table(name = "poll")
public class Poll implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "poll_id")
	private Long pollId;
	
	@NotEmpty
	@Length(min = 1, max = 100)
	@Column(name = "poll_description")
	private String pollDescription;
	
	@Column(name = "views")
	private Integer views;
	
	@NotEmpty
	@OneToMany(mappedBy = "poll", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Option> options;

}
