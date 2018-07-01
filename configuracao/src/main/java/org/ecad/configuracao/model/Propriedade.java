package org.ecad.configuracao.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.ecad.configuracao.TipoPropriedade;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "TB_PROPRIEDADE")
public class Propriedade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(hidden = true)
	private Long id;

	@ManyToOne
	@NotNull(message="Propriedade deve ser de um ambiente")
	private Ambiente ambiente;
	
	@NotNull(message="Valor não pode ser nulo")
	private String nome, valor;
	
	private String descricao;
	
	@Enumerated(EnumType.STRING)
	@NotNull
	private TipoPropriedade tipoPropriedade;
	
	public Propriedade() {
		
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

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Ambiente getAmbiente() {
		return ambiente;
	}

	public void setSistema(Ambiente ambiente) {
		this.ambiente = ambiente;
	}

	public TipoPropriedade getTipoPropriedade() {
		return tipoPropriedade;
	}

	public void setTipoPropriedade(TipoPropriedade tipoPropriedade) {
		this.tipoPropriedade = tipoPropriedade;
	}

	@Override
	public String toString() {
		return "Propriedade [ambiente=" + ambiente + ", nome=" + nome + ", valor=" + valor + ", tipoPropriedade="
				+ tipoPropriedade + "]";
	}
	
}
