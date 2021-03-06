package org.freedom.persist.entity;

// Generated 12/05/2014 09:11:34 by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * FnpagtocomiId generated by hbm2java
 */
@Embeddable
public class FnpagtocomiId implements java.io.Serializable {

	private int codpcomi;
	private short codfilial;
	private int codemp;

	public FnpagtocomiId() {
	}

	public FnpagtocomiId(int codpcomi, short codfilial, int codemp) {
		this.codpcomi = codpcomi;
		this.codfilial = codfilial;
		this.codemp = codemp;
	}

	@Column(name = "CODPCOMI", nullable = false)
	public int getCodpcomi() {
		return this.codpcomi;
	}

	public void setCodpcomi(int codpcomi) {
		this.codpcomi = codpcomi;
	}

	@Column(name = "CODFILIAL", nullable = false)
	public short getCodfilial() {
		return this.codfilial;
	}

	public void setCodfilial(short codfilial) {
		this.codfilial = codfilial;
	}

	@Column(name = "CODEMP", nullable = false)
	public int getCodemp() {
		return this.codemp;
	}

	public void setCodemp(int codemp) {
		this.codemp = codemp;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof FnpagtocomiId))
			return false;
		FnpagtocomiId castOther = (FnpagtocomiId) other;

		return (this.getCodpcomi() == castOther.getCodpcomi())
				&& (this.getCodfilial() == castOther.getCodfilial())
				&& (this.getCodemp() == castOther.getCodemp());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCodpcomi();
		result = 37 * result + this.getCodfilial();
		result = 37 * result + this.getCodemp();
		return result;
	}

}
