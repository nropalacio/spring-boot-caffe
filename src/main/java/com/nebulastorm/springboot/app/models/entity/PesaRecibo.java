package com.nebulastorm.springboot.app.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "pesa_recibos")
public class PesaRecibo implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private Integer correlativo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "calidad_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Calidad calidad;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tipo_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Tipo tipo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "variedad_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private  Variedad variedad;

	@NotNull
	private Double sacos;
	
	@NotNull
	private Double libras;
	
	private Double taraSacos;
	
	
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Calidad getCalidad() {
		return calidad;
	}



	public void setCalidad(Calidad calidad) {
		this.calidad = calidad;
	}



	public Tipo getTipo() {
		return tipo;
	}



	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}



	public Variedad getVariedad() {
		return variedad;
	}



	public void setVariedad(Variedad variedad) {
		this.variedad = variedad;
	}



	public Double getSacos() {
		return sacos;
	}



	public void setSacos(Double sacos) {
		this.sacos = sacos;
	}



	public Double getLibras() {
		return libras;
	}



	public void setLibras(Double libras) {
		this.libras = libras;
	}



	public Double getTaraSacos() {
		return taraSacos;
	}



	public void setTaraSacos(Double taraSacos) {
		this.taraSacos = taraSacos;
	}

	
	public Integer getCorrelativo() {
		return correlativo;
	}



	public void setCorrelativo(Integer correlativo) {
		this.correlativo = correlativo;
	}



	public Double calcularQuintalNeto() {
		Double neto = 0.0;
		neto = this.libras - (this.sacos*this.taraSacos);
		return neto;
	}


	private static final long serialVersionUID = 1L;
	
	
}
