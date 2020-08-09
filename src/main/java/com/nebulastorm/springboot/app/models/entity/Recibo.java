package com.nebulastorm.springboot.app.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "recibos")
public class Recibo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY) // Con esto realiza la consulta solamente cuando se le llama
	@JsonBackReference
	private Cliente cliente;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "motorista_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Motorista motorista;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "placa_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Placa placa;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "create_at")
	private Date createAt;
	
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "recibo_id")
	private List<PesaRecibo> pesas;
	
	@NotEmpty
	private String observaciones;
	
	@PrePersist
	public void prePersist() {
		createAt = new Date();
	}
	
	public Recibo() {
		this.pesas= new ArrayList<PesaRecibo>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@XmlTransient
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Motorista getMotorista() {
		return motorista;
	}

	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}

	public Placa getPlaca() {
		return placa;
	}

	public void setPlaca(Placa placa) {
		this.placa = placa;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public List<PesaRecibo> getPesas() {
		return pesas;
	}

	public void setPesas(List<PesaRecibo> pesas) {
		this.pesas = pesas;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	public void addPesaRecibo(PesaRecibo pesa) {
		this.pesas.add(pesa);
	}
	
	public Double pesoTotal() {
		Double librasTotal = 0.0;
		int largo = this.pesas.size();
		for(int i = 0; i < largo ;i++) {
			librasTotal += this.pesas.get(i).calcularQuintalNeto();
		}
		return librasTotal;
	}
	
	public Double sacosTotal() {
		Double sacosTotal = 0.0;
		int largo = this.pesas.size();
		for(int i = 0; i<largo; i++) {
			sacosTotal += this.pesas.get(i).getSacos();
		}
		return sacosTotal;
	}
	
}
