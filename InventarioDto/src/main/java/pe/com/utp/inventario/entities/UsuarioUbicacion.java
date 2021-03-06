package pe.com.utp.inventario.entities;
// Generated 30/04/2020 08:56:29 PM by Hibernate Tools 4.3.1

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * UsuarioUbicacion generated by hbm2java
 */
@Entity
@Table(name = "usuario_ubicacion", catalog = "inventario")
public class UsuarioUbicacion implements java.io.Serializable {

	private Integer idUsuUbi;
	private Condicion condicion;
	private Dominio dominio;
	private Ubicacion ubicacion;
	private Usuario usuario;
	private Date fecMod;
	private List<DispositivoUsuario> dispositivoUsuarios = new ArrayList<>();

	public UsuarioUbicacion() {
	}

	public UsuarioUbicacion(Condicion condicion, Ubicacion ubicacion, Usuario usuario, Date fecMod) {
		this.condicion = condicion;
		this.ubicacion = ubicacion;
		this.usuario = usuario;
		this.fecMod = fecMod;
	}

	public UsuarioUbicacion(Condicion condicion, Dominio dominio, Ubicacion ubicacion, Usuario usuario, Date fecMod,
			List<DispositivoUsuario> dispositivoUsuarios) {
		this.condicion = condicion;
		this.dominio = dominio;
		this.ubicacion = ubicacion;
		this.usuario = usuario;
		this.fecMod = fecMod;
		this.dispositivoUsuarios = dispositivoUsuarios;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_usu_ubi", unique = true, nullable = false)
	public Integer getIdUsuUbi() {
		return this.idUsuUbi;
	}

	public void setIdUsuUbi(Integer idUsuUbi) {
		this.idUsuUbi = idUsuUbi;
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
	@JoinColumn(name = "id_dominio")
	public Dominio getDominio() {
		return this.dominio;
	}

	public void setDominio(Dominio dominio) {
		this.dominio = dominio;
	}

	@ManyToOne
	@JoinColumn(name = "id_ubicacion", nullable = false)
	public Ubicacion getUbicacion() {
		return this.ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}

	@ManyToOne
	@JoinColumn(name = "id_usuario", nullable = false)
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fec_mod", nullable = false, length = 26)
	public Date getFecMod() {
		return this.fecMod;
	}

	public void setFecMod(Date fecMod) {
		this.fecMod = fecMod;
	}

	@OneToMany(mappedBy = "usuarioUbicacion")
	public List<DispositivoUsuario> getDispositivoUsuarios() {
		return this.dispositivoUsuarios;
	}

	public void setDispositivoUsuarios(List<DispositivoUsuario> dispositivoUsuarios) {
		this.dispositivoUsuarios = dispositivoUsuarios;
	}

}
