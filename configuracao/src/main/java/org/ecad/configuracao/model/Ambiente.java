package org.ecad.configuracao.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "TB_AMBIENTE")
public class Ambiente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(hidden = true)
	private Long id;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ambiente")
	private List<Propriedade> propriedades;
	
	@ManyToOne
	private Sistema sistema;
	
	@NotNull(message="Nome do Ambiente é obrigatório")
	private String nome;
	
	private String descricao;

	public Ambiente() {}
	
	public Ambiente(Long id, String nome, String descricao) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}

	public Ambiente(String nome, String descricao) {
		super();
		this.nome = nome;
		this.descricao = descricao;
	}

	public Ambiente(String nome, String descricao, Sistema sistema) {
		this.nome = nome;
		this.descricao = descricao;
		this.sistema = sistema;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public List<Propriedade> getPropriedades() {
		return propriedades;
	}

	public void setPropriedades(List<Propriedade> propriedades) {
		this.propriedades = propriedades;
	}

	public Sistema getSistema() {
		return sistema;
	}

	public void setSitema(Sistema sitema) {
		this.sistema = sitema;
	}

	@Override
	public String toString() {
		return "Ambiente [nome=" + nome + "]";
	}
	
}
