package pe.com.utp.inventario.entities;
// Generated 30/04/2020 08:56:29 PM by Hibernate Tools 4.3.1

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * Cpu generated by hbm2java
 */
@Entity
@Table(name = "cpu", catalog = "inventario")
public class Cpu implements java.io.Serializable {

	private Integer idDispositivo;
	private Antivirus antivirus;
	private Dispositivo dispositivo;
	private String procesador;
	private String nomCpu;
	private List<CpuSo> cpuSos = new ArrayList<>();

	public Cpu() {
	}

	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "dispositivo"))
	@Id
	@GeneratedValue(generator = "generator")

	@Column(name = "id_dispositivo", unique = true, nullable = false)
	public Integer getIdDispositivo() {
		return this.idDispositivo;
	}

	public void setIdDispositivo(Integer idDispositivo) {
		this.idDispositivo = idDispositivo;
	}

	@ManyToOne
	@JoinColumn(name = "id_antivirus")
	public Antivirus getAntivirus() {
		return this.antivirus;
	}

	public void setAntivirus(Antivirus antivirus) {
		this.antivirus = antivirus;
	}

	@OneToOne
	@PrimaryKeyJoinColumn
	public Dispositivo getDispositivo() {
		return this.dispositivo;
	}

	public void setDispositivo(Dispositivo dispositivo) {
		this.dispositivo = dispositivo;
	}

	@Column(name = "procesador", nullable = false, length = 250)
	public String getProcesador() {
		return this.procesador;
	}

	public void setProcesador(String procesador) {
		this.procesador = procesador;
	}

	@Column(name = "nom_cpu", nullable = false, length = 250)
	public String getNomCpu() {
		return this.nomCpu;
	}

	public void setNomCpu(String nomCpu) {
		this.nomCpu = nomCpu;
	}

	@OneToMany(mappedBy = "cpu")
	public List<CpuSo> getCpuSos() {
		return this.cpuSos;
	}

	public void setCpuSos(List<CpuSo> cpuSos) {
		this.cpuSos = cpuSos;
	}

}