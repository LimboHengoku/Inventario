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
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Condicion generated by hbm2java
 */
@Entity
@Table(name = "condicion", catalog = "inventario")
public class Condicion implements java.io.Serializable {

	private Integer idCondicion;
	private String nomCondicion;
	private List<CpuSo> cpuSos = new ArrayList<>();
	private List<DispositivoIp> dispositivoIps = new ArrayList<>();
	private List<RecursoDispositivo> recursoDispositivos = new ArrayList<>();
	private List<DispositivoUsuario> dispositivoUsuarios = new ArrayList<>();
	private List<Servicio> servicios = new ArrayList<>();
	private List<UsuarioUbicacion> usuarioUbicacions = new ArrayList<>();

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_condicion", unique = true, nullable = false)
	public Integer getIdCondicion() {
		return this.idCondicion;
	}

	public void setIdCondicion(Integer idCondicion) {
		this.idCondicion = idCondicion;
	}

	@Column(name = "nom_condicion", nullable = false, length = 100)
	public String getNomCondicion() {
		return this.nomCondicion;
	}

	public void setNomCondicion(String nomCondicion) {
		this.nomCondicion = nomCondicion;
	}

	@OneToMany(mappedBy = "condicion")
	public List<CpuSo> getCpuSos() {
		return this.cpuSos;
	}

	public void setCpuSos(List<CpuSo> cpuSos) {
		this.cpuSos = cpuSos;
	}

	@OneToMany(mappedBy = "condicion")
	public List<DispositivoIp> getDispositivoIps() {
		return this.dispositivoIps;
	}

	public void setDispositivoIps(List<DispositivoIp> dispositivoIps) {
		this.dispositivoIps = dispositivoIps;
	}

	@OneToMany(mappedBy = "condicion")
	public List<RecursoDispositivo> getRecursoDispositivos() {
		return this.recursoDispositivos;
	}

	public void setRecursoDispositivos(List<RecursoDispositivo> recursoDispositivos) {
		this.recursoDispositivos = recursoDispositivos;
	}

	@OneToMany(mappedBy = "condicion")
	public List<DispositivoUsuario> getDispositivoUsuarios() {
		return this.dispositivoUsuarios;
	}

	public void setDispositivoUsuarios(List<DispositivoUsuario> dispositivoUsuarios) {
		this.dispositivoUsuarios = dispositivoUsuarios;
	}

	@OneToMany(mappedBy = "condicion")
	public List<Servicio> getServicios() {
		return this.servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}

	@OneToMany(mappedBy = "condicion")
	public List<UsuarioUbicacion> getUsuarioUbicacions() {
		return this.usuarioUbicacions;
	}

	public void setUsuarioUbicacions(List<UsuarioUbicacion> usuarioUbicacions) {
		this.usuarioUbicacions = usuarioUbicacions;
	}

}
