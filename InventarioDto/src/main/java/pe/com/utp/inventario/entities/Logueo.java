package pe.com.utp.inventario.entities;
// Generated 30/04/2020 08:56:29 PM by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Logueo generated by hbm2java
 */
@Entity
@Table(name = "logueo", catalog = "inventario")
public class Logueo implements java.io.Serializable {

	private Integer idLogueo;
	private TipoLogueo tipoLogueo;
	private Usuario usuario;
	private String user;
	private String pass;
	private int sesiones;

	public Logueo() {
	}

	public Logueo(TipoLogueo tipoLogueo, Usuario usuario, String user, String pass, int sesiones) {
		this.tipoLogueo = tipoLogueo;
		this.usuario = usuario;
		this.user = user;
		this.pass = pass;
		this.sesiones = sesiones;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_logueo", unique = true, nullable = false)
	public Integer getIdLogueo() {
		return this.idLogueo;
	}

	public void setIdLogueo(Integer idLogueo) {
		this.idLogueo = idLogueo;
	}

	@ManyToOne
	@JoinColumn(name = "id_tipologueo", nullable = false)
	public TipoLogueo getTipoLogueo() {
		return this.tipoLogueo;
	}

	public void setTipoLogueo(TipoLogueo tipoLogueo) {
		this.tipoLogueo = tipoLogueo;
	}

	@ManyToOne
	@JoinColumn(name = "id_usuario", nullable = false)
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Column(name = "user", nullable = false, length = 100)
	public String getUser() {
		return this.user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	@Column(name = "pass", nullable = false, length = 500)
	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Column(name = "sesiones", nullable = false)
	public int getSesiones() {
		return this.sesiones;
	}

	public void setSesiones(int sesiones) {
		this.sesiones = sesiones;
	}

}
