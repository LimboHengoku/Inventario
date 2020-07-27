package pe.com.utp.inventario.entities;
// Generated 30/04/2020 08:56:29 PM by Hibernate Tools 4.3.1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * CpuSo generated by hbm2java
 */
@Entity
@Table(name = "cpu_so", catalog = "inventario")
public class CpuSo implements java.io.Serializable {

	private Integer idCpuSo;
	private Condicion condicion;
	private Cpu cpu;
	private SistemaOperativo sistemaOperativo;
	private Date fecMod;

	public CpuSo() {
	}

	public CpuSo(Condicion condicion, Cpu cpu, SistemaOperativo sistemaOperativo) {
		this.condicion = condicion;
		this.cpu = cpu;
		this.sistemaOperativo = sistemaOperativo;
	}

	public CpuSo(Condicion condicion, Cpu cpu, SistemaOperativo sistemaOperativo, Date fecMod) {
		this.condicion = condicion;
		this.cpu = cpu;
		this.sistemaOperativo = sistemaOperativo;
		this.fecMod = fecMod;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_cpu_so", unique = true, nullable = false)
	public Integer getIdCpuSo() {
		return this.idCpuSo;
	}

	public void setIdCpuSo(Integer idCpuSo) {
		this.idCpuSo = idCpuSo;
	}

	@ManyToOne
	@JoinColumn(name = "condicion", nullable = false)
	public Condicion getCondicion() {
		return this.condicion;
	}

	public void setCondicion(Condicion condicion) {
		this.condicion = condicion;
	}

	@ManyToOne
	@JoinColumn(name = "id_dispositivo", nullable = false)
	public Cpu getCpu() {
		return this.cpu;
	}

	public void setCpu(Cpu cpu) {
		this.cpu = cpu;
	}

	@ManyToOne
	@JoinColumn(name = "id_so", nullable = false)
	public SistemaOperativo getSistemaOperativo() {
		return this.sistemaOperativo;
	}

	public void setSistemaOperativo(SistemaOperativo sistemaOperativo) {
		this.sistemaOperativo = sistemaOperativo;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fec_mod", length = 26)
	public Date getFecMod() {
		return this.fecMod;
	}

	public void setFecMod(Date fecMod) {
		this.fecMod = fecMod;
	}

}