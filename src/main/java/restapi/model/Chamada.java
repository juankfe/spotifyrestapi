package restapi.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="chamadas")
public class Chamada implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idChamada;
	
	private String chamada;

	private LocalDateTime dataHora;

	public Long getIdChamada() {
		return idChamada;
	}

	public void setIdChamada(Long idChamada) {
		this.idChamada = idChamada;
	}

	public String getChamada() {
		return chamada;
	}

	public void setChamada(String chamada) {
		this.chamada = chamada;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

}
