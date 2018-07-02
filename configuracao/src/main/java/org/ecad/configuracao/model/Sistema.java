package org.ecad.configuracao.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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

	@OneToMany(cascade = CascadeType.ALL)
	private List<Ambiente> ambientes;

	@NotNull(message = "Campo nome é obrigatório")
	private String nome;

	private String descricao;

	public Sistema() {
	}

	public Sistema(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
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

	public List<Ambiente> getAmbiente() {
		return ambientes;
	}

	public void setAmbiente(List<Ambiente> ambientes) {
		this.ambientes = ambientes;
	}

	@Override
	public String toString() {
		return "Sistema [nome=" + nome + ", descricao=" + descricao + "]";
	}

}
