/*
 * Projeto: Freedom Pacote: org.freedom.modules.std Classe: @(#)DLBuscaVenda.java
 * 
 * Este arquivo � parte do sistema Freedom-ERP, o Freedom-ERP � um software livre; voc� pode redistribui-lo e/ou <BR> modifica-lo dentro dos termos da Licen�a P�blica Geral GNU como publicada pela Funda��o do Software Livre (FSF); <BR> na vers�o 2 da Licen�a, ou (na sua opni�o) qualquer vers�o. <BR>
 * Este programa � distribuido na esperan�a que possa ser util, mas SEM NENHUMA GARANTIA; <BR> sem uma garantia implicita de ADEQUA��O a qualquer MERCADO ou APLICA��O EM PARTICULAR. <BR> Veja a Licen�a P�blica Geral GNU para maiores detalhes. <BR> Voc� deve ter recebido uma c�pia da Licen�a P�blica
 * Geral GNU junto com este programa, se n�o, <BR> escreva para a Funda��o do Software Livre(FSF) Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA <BR> <BR>
 */

package org.freedom.modulos.std.view.dialog.utility;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;

import org.freedom.acao.CarregaEvent;
import org.freedom.acao.CarregaListener;
import org.freedom.bmps.Icone;
import org.freedom.infra.functions.ConversionFunctions;
import org.freedom.infra.model.jdbc.DbConnection;
import org.freedom.library.functions.Funcoes;
import org.freedom.library.persistence.GuardaCampo;
import org.freedom.library.persistence.ListaCampos;
import org.freedom.library.swing.component.JButtonPad;
import org.freedom.library.swing.component.JLabelPad;
import org.freedom.library.swing.component.JPanelPad;
import org.freedom.library.swing.component.JTablePad;
import org.freedom.library.swing.component.JTextFieldFK;
import org.freedom.library.swing.component.JTextFieldPad;
import org.freedom.library.swing.dialog.FFDialogo;
import org.freedom.library.swing.frame.Aplicativo;

/**
 * Busca nota de remessa para importar itens para remessa consignada.
 * 
 * @author Setpoint Inform�tica Ltda./Alex Rodrigues
 * @version 27/08/2009
 */
public class DLBuscaListaVendas extends FFDialogo implements CarregaListener {

	private static final long serialVersionUID = 1L;

	private JPanelPad panelGeral = new JPanelPad( JPanelPad.TP_JPANEL, new BorderLayout() );

	private JPanelPad panelMaster = new JPanelPad( 700, 60 );

	private JPanelPad panelGrid = new JPanelPad( JPanelPad.TP_JPANEL, new BorderLayout() );

	private JPanelPad panelGridActions = new JPanelPad( 41, 200 );

	private JTextFieldPad txtCodVenda = new JTextFieldPad( JTextFieldPad.TP_INTEGER, 8, 0 );

	private JTextFieldPad txtTipoVenda = new JTextFieldPad( JTextFieldPad.TP_STRING, 1, 0 );

	private JTextFieldFK txtDocVenda = new JTextFieldFK( JTextFieldPad.TP_INTEGER, 9, 0 );

	private JTextFieldFK txtDtEmitVenda = new JTextFieldFK( JTextFieldPad.TP_DATE, 10, 0 );

	private JTextFieldFK txtVlrLiqVenda = new JTextFieldFK( JTextFieldPad.TP_DECIMAL, 15, Aplicativo.casasDecFin );

	private JButtonPad btSelecionarTodos = new JButtonPad( Icone.novo( "btTudo.png" ) );

	private JButtonPad btSelecionarNenhum = new JButtonPad( Icone.novo( "btNada.png" ) );

	private JTextFieldPad txtTipoMov = new JTextFieldPad( JTextFieldPad.TP_STRING, 2, 0 );

	private JTablePad tabItens = new JTablePad();

	private ListaCampos lcVenda = new ListaCampos( this );

	private enum ITENS {
		SEL, CODVENDA, DOCVENDA, ITEM, CODPROD, DESCPROD, CODLOTE, QUANTIDADE, PRECO, CODCLI, RAZCLI, CODPLANOPAG, DESCPLANOPAG, CHAVENFE, REFPROD;
	}

	public final String tipoMovimento;

	public DLBuscaListaVendas( String tipoMovimento ) {

		super();
		setTitulo( "Pesquisa de vendas" );
		setAtribos( 700, 320 );
		setResizable( true );

		txtTipoVenda.setVlrString( "V" );

		this.tipoMovimento = tipoMovimento;
		txtTipoMov.setVlrString( this.tipoMovimento );

		montaListaCampos();
		montaTela();

		lcVenda.addCarregaListener( this );

		btSelecionarTodos.addActionListener( this );
		btSelecionarNenhum.addActionListener( this );
	}

	private void montaListaCampos() {

		lcVenda.add( new GuardaCampo( txtCodVenda, "CodVenda", "N. pedido", ListaCampos.DB_PK, false ) );
		lcVenda.add( new GuardaCampo( txtDocVenda, "DocVenda", "N doc.", ListaCampos.DB_SI, false ) );
		lcVenda.add( new GuardaCampo( txtDtEmitVenda, "DtEmitVenda", "Data emis.", ListaCampos.DB_SI, false ) );
		lcVenda.add( new GuardaCampo( txtVlrLiqVenda, "VlrLiqVenda", "Valor", ListaCampos.DB_SI, false ) );
		txtCodVenda.setTabelaExterna( lcVenda, null );
		txtCodVenda.setNomeCampo( "CodVenda" );
		txtCodVenda.setFK( true );
		txtCodVenda.setPK( true );
		lcVenda.setDinWhereAdic( "TIPOVENDA = #S", txtTipoVenda );
		if ( tipoMovimento != null ) {
			lcVenda.setDinWhereAdic( "EXISTS (SELECT TM.CODTIPOMOV FROM EQTIPOMOV TM " + "WHERE TM.CODEMP=V.CODEMPTM AND TM.CODFILIAL=V.CODFILIALTM AND " + "TM.CODTIPOMOV=V.CODTIPOMOV AND TM.TIPOMOV = #S ) ", txtTipoMov );
		}
		lcVenda.montaSql( false, "VENDA V", "VD" );
		lcVenda.setReadOnly( true );
	}

	private void montaTela() {

		setPanel( panelGeral );
		panelGeral.add( panelMaster, BorderLayout.NORTH );

		panelMaster.adic( new JLabelPad( "C�d.venda" ), 7, 10, 100, 20 );
		panelMaster.adic( txtCodVenda, 7, 30, 100, 20 );
		panelMaster.adic( new JLabelPad( "Doc.venda" ), 110, 10, 100, 20 );
		panelMaster.adic( txtDocVenda, 110, 30, 100, 20 );
		panelMaster.adic( new JLabelPad( "Emiss�o" ), 213, 10, 100, 20 );
		panelMaster.adic( txtDtEmitVenda, 213, 30, 100, 20 );
		panelMaster.adic( new JLabelPad( "Valor l�quido" ), 316, 10, 100, 20 );
		panelMaster.adic( txtVlrLiqVenda, 316, 30, 100, 20 );

		// ***** Grid

		panelGeral.add( panelGrid, BorderLayout.CENTER );
		panelGrid.setBorder( BorderFactory.createEtchedBorder() );

		tabItens.adicColuna( "" );
		tabItens.adicColuna( "Pedido" );
		tabItens.adicColuna( "Documento" );
		tabItens.adicColuna( "Item" );
		tabItens.adicColuna( "C�digo" );
		tabItens.adicColuna( "Descri��o do produto" );
		tabItens.adicColuna( "C�d.lote" );
		tabItens.adicColuna( "Quantidade" );
		tabItens.adicColuna( "Pre�o" );
		tabItens.adicColuna( "C�d.cli." );
		tabItens.adicColuna( "Raz�o social do cliente" );
		tabItens.adicColuna( "C�d.pl.pag." );
		tabItens.adicColuna( "Descri��o do plano de pagamento" );
		tabItens.adicColuna( "Chave NFE" );
		tabItens.adicColuna( "Refer�ncia" );

		tabItens.setTamColuna( 20, ITENS.SEL.ordinal() );
		tabItens.setTamColuna( 80, ITENS.CODVENDA.ordinal() );
		tabItens.setTamColuna( 80, ITENS.DOCVENDA.ordinal() );
		tabItens.setTamColuna( 60, ITENS.ITEM.ordinal() );
		tabItens.setTamColuna( 80, ITENS.CODPROD.ordinal() );
		tabItens.setTamColuna( 230, ITENS.DESCPROD.ordinal() );
		tabItens.setTamColuna( 100, ITENS.CODLOTE.ordinal() );
		tabItens.setTamColuna( 80, ITENS.QUANTIDADE.ordinal() );
		tabItens.setTamColuna( 80, ITENS.PRECO.ordinal() );
		tabItens.setTamColuna( 80, ITENS.CODCLI.ordinal() );
		tabItens.setTamColuna( 230, ITENS.RAZCLI.ordinal() );
		tabItens.setTamColuna( 80, ITENS.CODPLANOPAG.ordinal() );
		tabItens.setTamColuna( 230, ITENS.DESCPLANOPAG.ordinal() );
		tabItens.setTamColuna( 230, ITENS.CHAVENFE.ordinal() );
		tabItens.setTamColuna( 60, ITENS.REFPROD.ordinal() );

		tabItens.setColunaEditavel( ITENS.SEL.ordinal(), true );

		panelGrid.add( new JScrollPane( tabItens ), BorderLayout.CENTER );

		panelGridActions.adic( btSelecionarTodos, 3, 3, 30, 30 );
		panelGridActions.adic( btSelecionarNenhum, 3, 38, 30, 30 );
		panelGrid.add( panelGridActions, BorderLayout.EAST );
	}

	private void selecionarTodos() {

		for ( int row = 0; row < tabItens.getNumLinhas(); row++ ) {
			tabItens.setValor( new Boolean( true ), row, ITENS.SEL.ordinal() );
		}
	}

	private void selecionarNenhum() {

		for ( int row = 0; row < tabItens.getNumLinhas(); row++ ) {
			tabItens.setValor( new Boolean( false ), row, ITENS.SEL.ordinal() );
		}
	}

	private void carregaVendas() {

		try {

			StringBuilder selectVendas = new StringBuilder();
			selectVendas.append( "SELECT I.CODVENDA, V.DOCVENDA, I.CODITVENDA, I.CODPROD, P.DESCPROD, coalesce(I.CODLOTE,'') CODLOTE");
			selectVendas.append( ", I.QTDITVENDA, I.PRECOITVENDA " );
			selectVendas.append( ", V.CODCLI, C.RAZCLI, V.CODPLANOPAG, PG.DESCPLANOPAG, coalesce(V.CHAVENFEVENDA,'') CHAVENFE " );
			selectVendas.append( ", P.REFPROD ");
			selectVendas.append( "FROM VDITVENDA I, VDVENDA V, EQPRODUTO P, VDCLIENTE C, FNPLANOPAG PG " );
			selectVendas.append( "WHERE I.CODEMP=V.CODEMP AND I.CODFILIAL=V.CODFILIAL AND I.CODVENDA=V.CODVENDA AND I.TIPOVENDA=V.TIPOVENDA AND " );
			selectVendas.append( "V.CODEMP=? AND V.CODFILIAL=? AND V.CODVENDA=? AND V.TIPOVENDA=? AND " );
			selectVendas.append( "P.CODEMP=I.CODEMPPD AND P.CODFILIAL=I.CODFILIALPD AND P.CODPROD=I.CODPROD AND " );
			selectVendas.append( "C.CODEMP=V.CODEMPCL AND C.CODFILIAL=V.CODFILIALCL AND C.CODCLI=V.CODCLI AND " );
			selectVendas.append( "PG.CODEMP=V.CODEMPPG AND PG.CODFILIAL=V.CODFILIALPG AND PG.CODPLANOPAG=V.CODPLANOPAG " );
			selectVendas.append( "ORDER BY I.CODVENDA, I.CODITVENDA" );

			PreparedStatement ps = con.prepareStatement( selectVendas.toString() );
			ps.setInt( 1, Aplicativo.iCodEmp );
			ps.setInt( 2, ListaCampos.getMasterFilial( "VDITVENDA" ) );
			ps.setInt( 3, txtCodVenda.getVlrInteger() );
			ps.setString( 4, txtTipoVenda.getVlrString() );

			ResultSet rs = ps.executeQuery();

			tabItens.limpa();

			int row = 0;
			while ( rs.next() ) {

				tabItens.adicLinha();
				tabItens.setValor( new Boolean( true ), row, ITENS.SEL.ordinal() );
				tabItens.setValor( rs.getInt( "CODVENDA" ), row, ITENS.CODVENDA.ordinal() );
				tabItens.setValor( rs.getInt( "DOCVENDA" ), row, ITENS.DOCVENDA.ordinal() );
				tabItens.setValor( rs.getInt( "CODITVENDA" ), row, ITENS.ITEM.ordinal() );
				tabItens.setValor( rs.getInt( "CODPROD" ), row, ITENS.CODPROD.ordinal() );
				tabItens.setValor( rs.getString( "DESCPROD" ), row, ITENS.DESCPROD.ordinal() );
				tabItens.setValor( rs.getString( "CODLOTE" ), row, ITENS.CODLOTE.ordinal() );
				tabItens.setValor( Funcoes.bdToStr( rs.getBigDecimal( "QTDITVENDA" ) ), row, ITENS.QUANTIDADE.ordinal() );
				tabItens.setValor( Funcoes.bdToStr( rs.getBigDecimal( "PRECOITVENDA" ) ), row, ITENS.PRECO.ordinal() );
				tabItens.setValor( rs.getInt( "CODCLI" ), row, ITENS.CODCLI.ordinal() );
				tabItens.setValor( rs.getString( "RAZCLI" ), row, ITENS.RAZCLI.ordinal() );
				tabItens.setValor( rs.getInt( "CODPLANOPAG" ), row, ITENS.CODPLANOPAG.ordinal() );
				tabItens.setValor( rs.getString( "DESCPLANOPAG" ), row, ITENS.DESCPLANOPAG.ordinal() );
				tabItens.setValor( rs.getString( "CHAVENFE" ), row, ITENS.CHAVENFE.ordinal() );
				tabItens.setValor( rs.getString( "REFPROD" ), row, ITENS.REFPROD.ordinal() );

				row++;
			}

			rs.close();
			ps.close();
			con.commit();

		} catch ( SQLException e ) {
			e.printStackTrace();
			Funcoes.mensagemErro( this, "Erro ao buscar nota de remessa.\n" + e.getMessage(), true, con, e );
		}
	}

	public List<GridBuscaRemessa> getGridBuscaRemessa() {

		List<GridBuscaRemessa> list = new ArrayList<GridBuscaRemessa>();

		for ( int row = 0; row < tabItens.getNumLinhas(); row++ ) {

			if ( (Boolean) tabItens.getValor( row, ITENS.SEL.ordinal() ) ) {

				GridBuscaRemessa gridBuscaRemessa = new GridBuscaRemessa();

				gridBuscaRemessa.setCodigoVenda( (Integer) tabItens.getValor( row, ITENS.CODVENDA.ordinal() ) );
				gridBuscaRemessa.setDocvenda( (Integer) tabItens.getValor( row, ITENS.DOCVENDA.ordinal() ) );
				gridBuscaRemessa.setItemVenda( (Integer) tabItens.getValor( row, ITENS.ITEM.ordinal() ) );
				gridBuscaRemessa.setCodigoProduto( (Integer) tabItens.getValor( row, ITENS.CODPROD.ordinal() ) );
				gridBuscaRemessa.setDescricaoProduto( (String) tabItens.getValor( row, ITENS.DESCPROD.ordinal() ) );
				gridBuscaRemessa.setCodlote( (String) tabItens.getValor( row, ITENS.CODLOTE.ordinal() ) );
				gridBuscaRemessa.setQuantidade( ConversionFunctions.stringToBigDecimal( tabItens.getValor( row, ITENS.QUANTIDADE.ordinal() ) ) );
				gridBuscaRemessa.setPreco( ConversionFunctions.stringToBigDecimal( tabItens.getValor( row, ITENS.PRECO.ordinal() ) ) );
				gridBuscaRemessa.setCliente( (Integer) tabItens.getValor( row, ITENS.CODCLI.ordinal() ) );
				gridBuscaRemessa.setPlanoPagamento( (Integer) tabItens.getValor( row, ITENS.CODPLANOPAG.ordinal() ) );
				gridBuscaRemessa.setChaveNFE( (String) tabItens.getValor( row, ITENS.CHAVENFE.ordinal() ) );
				gridBuscaRemessa.setRefprod( (String) tabItens.getValor( row, ITENS.REFPROD.ordinal() ) );

				list.add( gridBuscaRemessa );
			}
		}

		return list;
	}

	@ Override
	public void actionPerformed( ActionEvent e ) {

		if ( e.getSource() == btSelecionarTodos ) {
			selecionarTodos();
		}
		else if ( e.getSource() == btSelecionarNenhum ) {
			selecionarNenhum();
		}
		else {
			super.actionPerformed( e );
		}
	}

	public void beforeCarrega( CarregaEvent e ) {

	}

	public void afterCarrega( CarregaEvent e ) {

		if ( e.getListaCampos() == lcVenda ) {
			carregaVendas();
		}
	}

	@ Override
	public void setConexao( DbConnection cn ) {

		super.setConexao( cn );
		lcVenda.setConexao( cn );
	}

	public class GridBuscaRemessa {

		private Integer codigoVenda;

		private Integer itemVenda;
		
		private Integer docvenda;

		private Integer codigoProduto;

		private String codlote;
		
		private String descricaoProduto;

		private BigDecimal quantidade;

		private BigDecimal preco;

		private Integer cliente;

		private String razaoSocialCliente;

		private Integer planoPagamento;

		private String descricaoPlanoPagamento;
		
		private String chaveNFE;
		
		private String refprod;

		public GridBuscaRemessa() {

		}

		public Integer getCodigoVenda() {

			return codigoVenda;
		}

		public void setCodigoVenda( Integer codigoVenda ) {

			this.codigoVenda = codigoVenda;
		}

		public Integer getItemVenda() {

			return itemVenda;
		}

		public void setItemVenda( Integer itemVenda ) {

			this.itemVenda = itemVenda;
		}

		public Integer getCodigoProduto() {

			return codigoProduto;
		}

		public void setCodigoProduto( Integer codigoProduto ) {

			this.codigoProduto = codigoProduto;
		}

		
		public String getCodlote() {
		
			return codlote;
		}

		
		public void setCodlote( String codlote ) {
		
			this.codlote = codlote;
		}

		public String getDescricaoProduto() {

			return descricaoProduto;
		}

		public void setDescricaoProduto( String descricaoProduto ) {

			this.descricaoProduto = descricaoProduto;
		}

		public BigDecimal getQuantidade() {

			return quantidade;
		}

		public void setQuantidade( BigDecimal quantidade ) {

			this.quantidade = quantidade;
		}

		public BigDecimal getPreco() {

			return preco;
		}

		public void setPreco( BigDecimal preco ) {

			this.preco = preco;
		}

		public Integer getCliente() {

			return cliente;
		}

		public void setCliente( Integer cliente ) {

			this.cliente = cliente;
		}

		public String getRazaoSocialCliente() {

			return razaoSocialCliente;
		}

		public void setRazaoSocialCliente( String razaoSocialCliente ) {

			this.razaoSocialCliente = razaoSocialCliente;
		}

		public Integer getPlanoPagamento() {

			return planoPagamento;
		}

		public void setPlanoPagamento( Integer planoPagamento ) {

			this.planoPagamento = planoPagamento;
		}

		public String getDescricaoPlanoPagamento() {

			return descricaoPlanoPagamento;
		}

		public void setDescricaoPlanoPagamento( String descricaoPlanoPagamento ) {

			this.descricaoPlanoPagamento = descricaoPlanoPagamento;
		}

		
		public String getChaveNFE() {
		
			return chaveNFE;
		}

		
		public void setChaveNFE( String chaveNFE ) {
		
			this.chaveNFE = chaveNFE;
		}

		
		public String getRefprod() {
		
			return refprod;
		}

		
		public void setRefprod( String refprod ) {
		
			this.refprod = refprod;
		}

		
		public Integer getDocvenda() {
		
			return docvenda;
		}

		
		public void setDocvenda( Integer docvenda ) {
		
			this.docvenda = docvenda;
		}
	}
}
