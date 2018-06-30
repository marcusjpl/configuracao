package org.ecad.configuracao.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "TB_SISTEMA")
public class Sistema {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(hidden = true)
	private Long id;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "sistema")
	private List<Propriedade> propriedades;

	@OneToOne
	@NotNull(message = "Sistema deve possuir ao menos um Ambiente")
	private Ambiente ambiente;

	@NotNull(message = "Campo nome é obrigatório")
	private String nome;

	private String descricao;

	public Sistema() {}

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

	public Ambiente getAmbiente() {
		return ambiente;
	}

	public void setAmbiente(Ambiente ambiente) {
		this.ambiente = ambiente;
	}

	@Override
	public String toString() {
		return "Sistema [nome=" + nome + ", descricao=" + descricao + "]";
	}

}
