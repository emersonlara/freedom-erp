package org.freedom.persist.entity;

// Generated 12/05/2014 09:11:34 by Hibernate Tools 4.0.0

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Svexecucao generated by hbm2java
 */
@Entity
@Table(name = "SVEXECUCAO")
public class Svexecucao implements java.io.Serializable {

	private SvexecucaoId id;
	private Eqproduto eqproduto;
	private Svitos svitos;
	private String refprod;
	private String sitexec;
	private BigDecimal qtdexec;
	private BigDecimal precoexec;
	private BigDecimal vlrtotexec;
	private BigDecimal vlrdescexec;
	private BigDecimal vlrliqexec;
	private Date dtexec;
	private String obsexec;
	private Date dtins;
	private Date hins;
	private String idusuins;
	private Date dtalt;
	private Date halt;
	private String idusualt;

	public Svexecucao() {
	}

	public Svexecucao(SvexecucaoId id, Eqproduto eqproduto, Svitos svitos,
			String refprod, String sitexec, BigDecimal qtdexec,
			BigDecimal precoexec, BigDecimal vlrtotexec,
			BigDecimal vlrdescexec, BigDecimal vlrliqexec, Date dtins,
			Date hins, String idusuins) {
		this.id = id;
		this.eqproduto = eqproduto;
		this.svitos = svitos;
		this.refprod = refprod;
		this.sitexec = sitexec;
		this.qtdexec = qtdexec;
		this.precoexec = precoexec;
		this.vlrtotexec = vlrtotexec;
		this.vlrdescexec = vlrdescexec;
		this.vlrliqexec = vlrliqexec;
		this.dtins = dtins;
		this.hins = hins;
		this.idusuins = idusuins;
	}

	public Svexecucao(SvexecucaoId id, Eqproduto eqproduto, Svitos svitos,
			String refprod, String sitexec, BigDecimal qtdexec,
			BigDecimal precoexec, BigDecimal vlrtotexec,
			BigDecimal vlrdescexec, BigDecimal vlrliqexec, Date dtexec,
			String obsexec, Date dtins, Date hins, String idusuins, Date dtalt,
			Date halt, String idusualt) {
		this.id = id;
		this.eqproduto = eqproduto;
		this.svitos = svitos;
		this.refprod = refprod;
		this.sitexec = sitexec;
		this.qtdexec = qtdexec;
		this.precoexec = precoexec;
		this.vlrtotexec = vlrtotexec;
		this.vlrdescexec = vlrdescexec;
		this.vlrliqexec = vlrliqexec;
		this.dtexec = dtexec;
		this.obsexec = obsexec;
		this.dtins = dtins;
		this.hins = hins;
		this.idusuins = idusuins;
		this.dtalt = dtalt;
		this.halt = halt;
		this.idusualt = idusualt;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "codos", column = @Column(name = "CODOS", nullable = false)),
			@AttributeOverride(name = "coditos", column = @Column(name = "CODITOS", nullable = false)),
			@AttributeOverride(name = "codexec", column = @Column(name = "CODEXEC", nullable = false)),
			@AttributeOverride(name = "codfilial", column = @Column(name = "CODFILIAL", nullable = false)),
			@AttributeOverride(name = "codemp", column = @Column(name = "CODEMP", nullable = false)) })
	public SvexecucaoId getId() {
		return this.id;
	}

	public void setId(SvexecucaoId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODPROD", referencedColumnName = "CODPROD", nullable = false),
			@JoinColumn(name = "CODFILIALPD", referencedColumnName = "CODFILIAL", nullable = false),
			@JoinColumn(name = "CODEMPPD", referencedColumnName = "CODEMP", nullable = false) })
	public Eqproduto getEqproduto() {
		return this.eqproduto;
	}

	public void setEqproduto(Eqproduto eqproduto) {
		this.eqproduto = eqproduto;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODOS", referencedColumnName = "CODOS", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "CODITOS", referencedColumnName = "CODITOS", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "CODFILIAL", referencedColumnName = "CODFILIAL", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "CODEMP", referencedColumnName = "CODEMP", nullable = false, insertable = false, updatable = false) })
	public Svitos getSvitos() {
		return this.svitos;
	}

	public void setSvitos(Svitos svitos) {
		this.svitos = svitos;
	}

	@Column(name = "REFPROD", nullable = false, length = 20)
	public String getRefprod() {
		return this.refprod;
	}

	public void setRefprod(String refprod) {
		this.refprod = refprod;
	}

	@Column(name = "SITEXEC", nullable = false, length = 2)
	public String getSitexec() {
		return this.sitexec;
	}

	public void setSitexec(String sitexec) {
		this.sitexec = sitexec;
	}

	@Column(name = "QTDEXEC", nullable = false, precision = 15, scale = 5)
	public BigDecimal getQtdexec() {
		return this.qtdexec;
	}

	public void setQtdexec(BigDecimal qtdexec) {
		this.qtdexec = qtdexec;
	}

	@Column(name = "PRECOEXEC", nullable = false, precision = 15, scale = 5)
	public BigDecimal getPrecoexec() {
		return this.precoexec;
	}

	public void setPrecoexec(BigDecimal precoexec) {
		this.precoexec = precoexec;
	}

	@Column(name = "VLRTOTEXEC", nullable = false, precision = 15, scale = 5)
	public BigDecimal getVlrtotexec() {
		return this.vlrtotexec;
	}

	public void setVlrtotexec(BigDecimal vlrtotexec) {
		this.vlrtotexec = vlrtotexec;
	}

	@Column(name = "VLRDESCEXEC", nullable = false, precision = 15, scale = 5)
	public BigDecimal getVlrdescexec() {
		return this.vlrdescexec;
	}

	public void setVlrdescexec(BigDecimal vlrdescexec) {
		this.vlrdescexec = vlrdescexec;
	}

	@Column(name = "VLRLIQEXEC", nullable = false, precision = 15, scale = 5)
	public BigDecimal getVlrliqexec() {
		return this.vlrliqexec;
	}

	public void setVlrliqexec(BigDecimal vlrliqexec) {
		this.vlrliqexec = vlrliqexec;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DTEXEC", length = 10)
	public Date getDtexec() {
		return this.dtexec;
	}

	public void setDtexec(Date dtexec) {
		this.dtexec = dtexec;
	}

	@Column(name = "OBSEXEC", length = 1000)
	public String getObsexec() {
		return this.obsexec;
	}

	public void setObsexec(String obsexec) {
		this.obsexec = obsexec;
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

}
