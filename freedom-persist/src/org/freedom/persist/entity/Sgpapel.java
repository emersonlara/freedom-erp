package org.freedom.persist.entity;

// Generated 12/05/2014 09:11:34 by Hibernate Tools 4.0.0

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Sgpapel generated by hbm2java
 */
@Entity
@Table(name = "SGPAPEL")
public class Sgpapel implements java.io.Serializable {

	private SgpapelId id;
	private Sgfilial sgfilial;
	private String descpapel;
	private Integer linpapel;
	private Integer altpapel;
	private Integer largpapel;
	private String classnotapapel;
	private Short colpapel;
	private Date dtins;
	private Date hins;
	private String idusuins;
	private Date dtalt;
	private Date halt;
	private String idusualt;
	private Set sgmodetiquetas = new HashSet(0);
	private Set sgestacaoimps = new HashSet(0);

	public Sgpapel() {
	}

	public Sgpapel(SgpapelId id, Sgfilial sgfilial, Date dtins, Date hins,
			String idusuins) {
		this.id = id;
		this.sgfilial = sgfilial;
		this.dtins = dtins;
		this.hins = hins;
		this.idusuins = idusuins;
	}

	public Sgpapel(SgpapelId id, Sgfilial sgfilial, String descpapel,
			Integer linpapel, Integer altpapel, Integer largpapel,
			String classnotapapel, Short colpapel, Date dtins, Date hins,
			String idusuins, Date dtalt, Date halt, String idusualt,
			Set sgmodetiquetas, Set sgestacaoimps) {
		this.id = id;
		this.sgfilial = sgfilial;
		this.descpapel = descpapel;
		this.linpapel = linpapel;
		this.altpapel = altpapel;
		this.largpapel = largpapel;
		this.classnotapapel = classnotapapel;
		this.colpapel = colpapel;
		this.dtins = dtins;
		this.hins = hins;
		this.idusuins = idusuins;
		this.dtalt = dtalt;
		this.halt = halt;
		this.idusualt = idusualt;
		this.sgmodetiquetas = sgmodetiquetas;
		this.sgestacaoimps = sgestacaoimps;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "codpapel", column = @Column(name = "CODPAPEL", nullable = false, length = 10)),
			@AttributeOverride(name = "codfilial", column = @Column(name = "CODFILIAL", nullable = false)),
			@AttributeOverride(name = "codemp", column = @Column(name = "CODEMP", nullable = false)) })
	public SgpapelId getId() {
		return this.id;
	}

	public void setId(SgpapelId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODFILIAL", referencedColumnName = "CODFILIAL", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "CODEMP", referencedColumnName = "CODEMP", nullable = false, insertable = false, updatable = false) })
	public Sgfilial getSgfilial() {
		return this.sgfilial;
	}

	public void setSgfilial(Sgfilial sgfilial) {
		this.sgfilial = sgfilial;
	}

	@Column(name = "DESCPAPEL", length = 40)
	public String getDescpapel() {
		return this.descpapel;
	}

	public void setDescpapel(String descpapel) {
		this.descpapel = descpapel;
	}

	@Column(name = "LINPAPEL")
	public Integer getLinpapel() {
		return this.linpapel;
	}

	public void setLinpapel(Integer linpapel) {
		this.linpapel = linpapel;
	}

	@Column(name = "ALTPAPEL")
	public Integer getAltpapel() {
		return this.altpapel;
	}

	public void setAltpapel(Integer altpapel) {
		this.altpapel = altpapel;
	}

	@Column(name = "LARGPAPEL")
	public Integer getLargpapel() {
		return this.largpapel;
	}

	public void setLargpapel(Integer largpapel) {
		this.largpapel = largpapel;
	}

	@Column(name = "CLASSNOTAPAPEL", length = 20)
	public String getClassnotapapel() {
		return this.classnotapapel;
	}

	public void setClassnotapapel(String classnotapapel) {
		this.classnotapapel = classnotapapel;
	}

	@Column(name = "COLPAPEL")
	public Short getColpapel() {
		return this.colpapel;
	}

	public void setColpapel(Short colpapel) {
		this.colpapel = colpapel;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DTINS", nullable = false, length = 10)
	public Date getDtins() {
		return this.dtins;
	}

	public void setDtins(Date dtins) {
		this.dtins = dtins;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "HINS", nullable = false, length = 8)
	public Date getHins() {
		return this.hins;
	}

	public void setHins(Date hins) {
		this.hins = hins;
	}

	@Column(name = "IDUSUINS", nullable = false, length = 8)
	public String getIdusuins() {
		return this.idusuins;
	}

	public void setIdusuins(String idusuins) {
		this.idusuins = idusuins;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DTALT", length = 10)
	public Date getDtalt() {
		return this.dtalt;
	}

	public void setDtalt(Date dtalt) {
		this.dtalt = dtalt;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "HALT", length = 8)
	public Date getHalt() {
		return this.halt;
	}

	public void setHalt(Date halt) {
		this.halt = halt;
	}

	@Column(name = "IDUSUALT", length = 8)
	public String getIdusualt() {
		return this.idusualt;
	}

	public void setIdusualt(String idusualt) {
		this.idusualt = idusualt;
	}

/*	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sgpapel")
	public Set getSgmodetiquetas() {
		return this.sgmodetiquetas;
	}

	public void setSgmodetiquetas(Set sgmodetiquetas) {
		this.sgmodetiquetas = sgmodetiquetas;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sgpapel")
	public Set getSgestacaoimps() {
		return this.sgestacaoimps;
	}

	public void setSgestacaoimps(Set sgestacaoimps) {
		this.sgestacaoimps = sgestacaoimps;
	}
*/
}
