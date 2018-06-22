package org.ecad.configuracao.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.ecad.configuracao.TipoPropriedade;

@Entity
@Table(name = "TB_PROPRIEDADE")
public class Propriedade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	private Sistema sistema;
	
	private String nome, valor, descricao;
	
	@Enumerated(EnumType.STRING)
	private TipoPropriedade tipoPropriedade;
	
	public Propriedade() {
		super();
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

	public Sistema getSistema() {
		return sistema;
	}

	public void setSistema(Sistema sistema) {
		this.sistema = sistema;
	}

	public TipoPropriedade getTipoPropriedade() {
		return tipoPropriedade;
	}

	public void setTipoPropriedade(TipoPropriedade tipoPropriedade) {
		this.tipoPropriedade = tipoPropriedade;
	}

	@Override
	public String toString() {
		return "Propriedade [sistema=" + sistema + ", nome=" + nome + ", valor=" + valor + ", tipoPropriedade="
				+ tipoPropriedade + "]";
	}
	
}
