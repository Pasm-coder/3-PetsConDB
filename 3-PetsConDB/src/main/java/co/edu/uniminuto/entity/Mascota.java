package co.edu.uniminuto.entity;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the mascotas database table.
 * 
 */
@Entity
@Table(name="mascotas")
@NamedQuery(name="Mascota.findAll", query="SELECT m FROM Mascota m")
public class Mascota implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="mas_id")
	private int masId;

	@Column(name="mas_edad")
	private byte masEdad;

	@Column(name="mas_estatus")
	private byte masEstatus;

	@Column(name="mas_nombre")
	private String masNombre;

	//bi-directional many-to-one association to TipoMascota
	@ManyToOne
	@JoinColumn(name="tip_id")
	private TipoMascota tipoMascota;

	public Mascota() {
	}

	public int getMasId() {
		return this.masId;
	}

	public void setMasId(int masId) {
		this.masId = masId;
	}

	public byte getMasEdad() {
		return this.masEdad;
	}

	public void setMasEdad(byte masEdad) {
		this.masEdad = masEdad;
	}

	public byte getMasEstatus() {
		return this.masEstatus;
	}

	public void setMasEstatus(byte masEstatus) {
		this.masEstatus = masEstatus;
	}

	public String getMasNombre() {
		return this.masNombre;
	}

	public void setMasNombre(String masNombre) {
		this.masNombre = masNombre;
	}

	public TipoMascota getTipoMascota() {
		return this.tipoMascota;
	}

	public void setTipoMascota(TipoMascota tipoMascota) {
		this.tipoMascota = tipoMascota;
	}

}