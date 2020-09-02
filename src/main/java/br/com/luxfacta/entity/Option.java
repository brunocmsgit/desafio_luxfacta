package br.com.luxfacta.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "options")
public class Option implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "option_id")
	private Long optionId;
	
	@NotNull
	@Length(min = 1, max = 100)
	@Column(name = "option_description")
	private String optionDescription;
	
	@Column(name = "qty")
	private Integer qty;
	
	@ManyToOne
	@JoinColumn(name = "poll_id")
	@JsonIgnore
	private Poll poll;
		
}
