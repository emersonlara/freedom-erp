package org.freedom.library.business.object;

import java.math.BigDecimal;

import org.freedom.infra.model.jdbc.DbConnection;
import org.freedom.library.functions.Funcoes;
import org.freedom.library.persistence.ListaCampos;
import org.freedom.library.swing.frame.Aplicativo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class CustosProd {

	private BigDecimal custoPEPSProd = new BigDecimal(0);
	private BigDecimal custoPEPSAlmox = new BigDecimal(0);
	private BigDecimal custoMPMProd = new BigDecimal(0);
	private BigDecimal custoMPMAlmox = new BigDecimal(0);
	String sSQL = null;
	ResultSet rs = null;
	PreparedStatement ps = null;

	public BigDecimal getCustoMPMAlmox() {

		return custoMPMAlmox;
	}

	public void setCustoMPMAlmox(BigDecimal custoMPMAlmox) {

		this.custoMPMAlmox = custoMPMAlmox;
	}

	public BigDecimal getCustoMPMProd() {

		return custoMPMProd;
	}

	public void setCustoMPMProd(BigDecimal custoMPMProd) {

		this.custoMPMProd = custoMPMProd;
	}

	public BigDecimal getCustoPEPSAlmox() {

		return custoPEPSAlmox;
	}

	public void setCustoPEPSAlmox(BigDecimal custoPEPSAlmox) {

		this.custoPEPSAlmox = custoPEPSAlmox;
	}

	public BigDecimal getCustoPEPSProd() {

		return custoPEPSProd;
	}

	public void setCustoPEPSProd(BigDecimal custoPEPSProd) {

		this.custoPEPSProd = custoPEPSProd;
	}

	public CustosProd(Integer codalmox, Integer codprod, Date dtpesq, DbConnection con) {
		try {

			sSQL = "SELECT NCUSTOPEPS, NCUSTOMPM, NCUSTOMPMAX, NCUSTOPEPSAX FROM EQPRODUTOSP01(?,?,?,?,?,?,?)";

			ps = con.prepareStatement(sSQL);
			int param = 1;
			ps.setInt(param++, Aplicativo.iCodEmp);
			ps.setInt(param++, ListaCampos.getMasterFilial("EQPRODUTO"));
			ps.setInt(param++, codprod.intValue());
			ps.setInt(param++, Aplicativo.iCodEmp);
			ps.setInt(param++, ListaCampos.getMasterFilial("EQALMOX"));
			ps.setInt(param++, codalmox.intValue());
			ps.setDate(param++, Funcoes.dateToSQLDate(dtpesq));
			rs = ps.executeQuery();

			if (rs.next()) {
				setCustoPEPSProd(new BigDecimal(rs.getFloat("NCUSTOPEPS")));
				setCustoMPMProd(new BigDecimal(rs.getFloat("NCUSTOMPM")));
				setCustoPEPSAlmox(new BigDecimal(rs.getFloat("NCUSTOPEPSAX")));
				setCustoMPMAlmox(new BigDecimal(rs.getFloat("NCUSTOMPMAX")));
			}

			rs.close();
			ps.close();

			con.commit();

		}
		catch (SQLException e) {
			Funcoes.mensagemErro(null, "N�o foi poss�vel carregar o valor de custo PEPS!\n" + e.getMessage());
		}
		finally {
			rs = null;
			ps = null;
			sSQL = null;
		}

	}

}
