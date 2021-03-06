package org.freedom.persist.entity;

// Generated 12/05/2014 09:11:34 by Hibernate Tools 4.0.0

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Fnrazforvw01Id generated by hbm2java
 */
@Embeddable
public class Fnrazforvw01Id implements java.io.Serializable {

	private Integer codempfr;
	private Short codfilialfr;
	private Integer codfor;
	private String razfor;
	private Integer codemppg;
	private Short codfilialpg;
	private Integer codempsl;
	private Short codfilialsl;
	private Integer codempvd;
	private Short codfilialvd;
	private Date data;
	private Character tipo;
	private Character tiposublanca;
	private Integer doc;
	private BigDecimal vlrdeb;
	private BigDecimal vlrcred;

	public Fnrazforvw01Id() {
	}

	public Fnrazforvw01Id(Integer codempfr, Short codfilialfr, Integer codfor,
			String razfor, Integer codemppg, Short codfilialpg,
			Integer codempsl, Short codfilialsl, Integer codempvd,
			Short codfilialvd, Date data, Character tipo,
			Character tiposublanca, Integer doc, BigDecimal vlrdeb,
			BigDecimal vlrcred) {
		this.codempfr = codempfr;
		this.codfilialfr = codfilialfr;
		this.codfor = codfor;
		this.razfor = razfor;
		this.codemppg = codemppg;
		this.codfilialpg = codfilialpg;
		this.codempsl = codempsl;
		this.codfilialsl = codfilialsl;
		this.codempvd = codempvd;
		this.codfilialvd = codfilialvd;
		this.data = data;
		this.tipo = tipo;
		this.tiposublanca = tiposublanca;
		this.doc = doc;
		this.vlrdeb = vlrdeb;
		this.vlrcred = vlrcred;
	}

	@Column(name = "CODEMPFR")
	public Integer getCodempfr() {
		return this.codempfr;
	}

	public void setCodempfr(Integer codempfr) {
		this.codempfr = codempfr;
	}

	@Column(name = "CODFILIALFR")
	public Short getCodfilialfr() {
		return this.codfilialfr;
	}

	public void setCodfilialfr(Short codfilialfr) {
		this.codfilialfr = codfilialfr;
	}

	@Column(name = "CODFOR")
	public Integer getCodfor() {
		return this.codfor;
	}

	public void setCodfor(Integer codfor) {
		this.codfor = codfor;
	}

	@Column(name = "RAZFOR", length = 60)
	public String getRazfor() {
		return this.razfor;
	}

	public void setRazfor(String razfor) {
		this.razfor = razfor;
	}

	@Column(name = "CODEMPPG")
	public Integer getCodemppg() {
		return this.codemppg;
	}

	public void setCodemppg(Integer codemppg) {
		this.codemppg = codemppg;
	}

	@Column(name = "CODFILIALPG")
	public Short getCodfilialpg() {
		return this.codfilialpg;
	}

	public void setCodfilialpg(Short codfilialpg) {
		this.codfilialpg = codfilialpg;
	}

	@Column(name = "CODEMPSL")
	public Integer getCodempsl() {
		return this.codempsl;
	}

	public void setCodempsl(Integer codempsl) {
		this.codempsl = codempsl;
	}

	@Column(name = "CODFILIALSL")
	public Short getCodfilialsl() {
		return this.codfilialsl;
	}

	public void setCodfilialsl(Short codfilialsl) {
		this.codfilialsl = codfilialsl;
	}

	@Column(name = "CODEMPVD")
	public Integer getCodempvd() {
		return this.codempvd;
	}

	public void setCodempvd(Integer codempvd) {
		this.codempvd = codempvd;
	}

	@Column(name = "CODFILIALVD")
	public Short getCodfilialvd() {
		return this.codfilialvd;
	}

	public void setCodfilialvd(Short codfilialvd) {
		this.codfilialvd = codfilialvd;
	}

	@Column(name = "DATA", length = 10)
	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@Column(name = "TIPO", length = 1)
	public Character getTipo() {
		return this.tipo;
	}

	public void setTipo(Character tipo) {
		this.tipo = tipo;
	}

	@Column(name = "TIPOSUBLANCA", length = 1)
	public Character getTiposublanca() {
		return this.tiposublanca;
	}

	public void setTiposublanca(Character tiposublanca) {
		this.tiposublanca = tiposublanca;
	}

	@Column(name = "DOC")
	public Integer getDoc() {
		return this.doc;
	}

	public void setDoc(Integer doc) {
		this.doc = doc;
	}

	@Column(name = "VLRDEB", precision = 0, scale = 5)
	public BigDecimal getVlrdeb() {
		return this.vlrdeb;
	}

	public void setVlrdeb(BigDecimal vlrdeb) {
		this.vlrdeb = vlrdeb;
	}

	@Column(name = "VLRCRED", precision = 0, scale = 5)
	public BigDecimal getVlrcred() {
		return this.vlrcred;
	}

	public void setVlrcred(BigDecimal vlrcred) {
		this.vlrcred = vlrcred;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof Fnrazforvw01Id))
			return false;
		Fnrazforvw01Id castOther = (Fnrazforvw01Id) other;

		return ((this.getCodempfr() == castOther.getCodempfr()) || (this
				.getCodempfr() != null && castOther.getCodempfr() != null && this
				.getCodempfr().equals(castOther.getCodempfr())))
				&& ((this.getCodfilialfr() == castOther.getCodfilialfr()) || (this
						.getCodfilialfr() != null
						&& castOther.getCodfilialfr() != null && this
						.getCodfilialfr().equals(castOther.getCodfilialfr())))
				&& ((this.getCodfor() == castOther.getCodfor()) || (this
						.getCodfor() != null && castOther.getCodfor() != null && this
						.getCodfor().equals(castOther.getCodfor())))
				&& ((this.getRazfor() == castOther.getRazfor()) || (this
						.getRazfor() != null && castOther.getRazfor() != null && this
						.getRazfor().equals(castOther.getRazfor())))
				&& ((this.getCodemppg() == castOther.getCodemppg()) || (this
						.getCodemppg() != null
						&& castOther.getCodemppg() != null && this
						.getCodemppg().equals(castOther.getCodemppg())))
				&& ((this.getCodfilialpg() == castOther.getCodfilialpg()) || (this
						.getCodfilialpg() != null
						&& castOther.getCodfilialpg() != null && this
						.getCodfilialpg().equals(castOther.getCodfilialpg())))
				&& ((this.getCodempsl() == castOther.getCodempsl()) || (this
						.getCodempsl() != null
						&& castOther.getCodempsl() != null && this
						.getCodempsl().equals(castOther.getCodempsl())))
				&& ((this.getCodfilialsl() == castOther.getCodfilialsl()) || (this
						.getCodfilialsl() != null
						&& castOther.getCodfilialsl() != null && this
						.getCodfilialsl().equals(castOther.getCodfilialsl())))
				&& ((this.getCodempvd() == castOther.getCodempvd()) || (this
						.getCodempvd() != null
						&& castOther.getCodempvd() != null && this
						.getCodempvd().equals(castOther.getCodempvd())))
				&& ((this.getCodfilialvd() == castOther.getCodfilialvd()) || (this
						.getCodfilialvd() != null
						&& castOther.getCodfilialvd() != null && this
						.getCodfilialvd().equals(castOther.getCodfilialvd())))
				&& ((this.getData() == castOther.getData()) || (this.getData() != null
						&& castOther.getData() != null && this.getData()
						.equals(castOther.getData())))
				&& ((this.getTipo() == castOther.getTipo()) || (this.getTipo() != null
						&& castOther.getTipo() != null && this.getTipo()
						.equals(castOther.getTipo())))
				&& ((this.getTiposublanca() == castOther.getTiposublanca()) || (this
						.getTiposublanca() != null
						&& castOther.getTiposublanca() != null && this
						.getTiposublanca().equals(castOther.getTiposublanca())))
				&& ((this.getDoc() == castOther.getDoc()) || (this.getDoc() != null
						&& castOther.getDoc() != null && this.getDoc().equals(
						castOther.getDoc())))
				&& ((this.getVlrdeb() == castOther.getVlrdeb()) || (this
						.getVlrdeb() != null && castOther.getVlrdeb() != null && this
						.getVlrdeb().equals(castOther.getVlrdeb())))
				&& ((this.getVlrcred() == castOther.getVlrcred()) || (this
						.getVlrcred() != null && castOther.getVlrcred() != null && this
						.getVlrcred().equals(castOther.getVlrcred())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getCodempfr() == null ? 0 : this.getCodempfr().hashCode());
		result = 37
				* result
				+ (getCodfilialfr() == null ? 0 : this.getCodfilialfr()
						.hashCode());
		result = 37 * result
				+ (getCodfor() == null ? 0 : this.getCodfor().hashCode());
		result = 37 * result
				+ (getRazfor() == null ? 0 : this.getRazfor().hashCode());
		result = 37 * result
				+ (getCodemppg() == null ? 0 : this.getCodemppg().hashCode());
		result = 37
				* result
				+ (getCodfilialpg() == null ? 0 : this.getCodfilialpg()
						.hashCode());
		result = 37 * result
				+ (getCodempsl() == null ? 0 : this.getCodempsl().hashCode());
		result = 37
				* result
				+ (getCodfilialsl() == null ? 0 : this.getCodfilialsl()
						.hashCode());
		result = 37 * result
				+ (getCodempvd() == null ? 0 : this.getCodempvd().hashCode());
		result = 37
				* result
				+ (getCodfilialvd() == null ? 0 : this.getCodfilialvd()
						.hashCode());
		result = 37 * result
				+ (getData() == null ? 0 : this.getData().hashCode());
		result = 37 * result
				+ (getTipo() == null ? 0 : this.getTipo().hashCode());
		result = 37
				* result
				+ (getTiposublanca() == null ? 0 : this.getTiposublanca()
						.hashCode());
		result = 37 * result
				+ (getDoc() == null ? 0 : this.getDoc().hashCode());
		result = 37 * result
				+ (getVlrdeb() == null ? 0 : this.getVlrdeb().hashCode());
		result = 37 * result
				+ (getVlrcred() == null ? 0 : this.getVlrcred().hashCode());
		return result;
	}

}
