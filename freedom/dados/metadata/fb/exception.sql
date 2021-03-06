/* Generated by IB DB Comparer v.1.15.Beta.  23/10/2007 11:05:29 */
/* Server Version: WI-V6.3.4.4910 Firebird 1.5.  ODS Version: 10.1. */

SET NAMES NONE;

SET SQL DIALECT 3;

CONNECT '/opt/firebird/dados/vazio.fdb' USER 'SYSDBA' PASSWORD 'masterkey';

/* Create Exception... */
CREATE EXCEPTION "CPCOMPRAEX03" 'COMPRA N�O PODE SER MAIS ALTERADA!';
CREATE EXCEPTION "CPCOMPRAEX04" 'VALOR DA COMPRA � DIFERENTE DO VALOR A RECEBER!';
CREATE EXCEPTION "CPITCOMPRAEX01" 'PRODUTO N�O PODE SER ALTERADO!';
CREATE EXCEPTION "CPITCOMPRAEX02" 'LOTE N�O PODE SER ALTERADO!';
CREATE EXCEPTION "CPITSOLICITACAO" 'QUANTIDADE APROVADA MAIOR QUE A SOLICITADA!';
CREATE EXCEPTION "CPITSOLICITACAOEX01" 'PRODUTO N�O PODE SER ALTERADO!';
CREATE EXCEPTION "EQALMOX01" 'ALMOXARIFADO N�O PODE SER TROCADO!';
CREATE EXCEPTION "EQINVPRODEX01" 'O PRODUTO N�O PODE SER ALTERADO!';
CREATE EXCEPTION "EQINVPRODEX02" 'O LOTE N�O PODE SER ALTERADO!';
CREATE EXCEPTION "EQINVPRODEX03" 'A DATA N�O PODE SER ALTERADA!';
CREATE EXCEPTION "EQINVPRODEX04" 'O ALMOXARIFADO N�O PODE SER ALTERADO!';
CREATE EXCEPTION "EQINVPRODEX05" 'C�DIGO DO LOTE � REQUERIDO';
CREATE EXCEPTION "EQITRMA" 'QUANTIDADE APROVADA MAIOR QUE A SOLICITADA!';
CREATE EXCEPTION "EQITRMA01" 'Item n�o pode ser exclu�do pois j� est� em andamento.';
CREATE EXCEPTION "EQITRMA02" 'Item n�o pode ser exclu�do pois foi criado por outro usu�rio.';
CREATE EXCEPTION "EQLOTEEX01" 'ESTOQUE DO LOTE ZERADO!';
CREATE EXCEPTION "EQPRODUTOEX01" 'ESTOQUE ZERADO!';
CREATE EXCEPTION "EQSIMILAREX01" 'Produto j� foi agrupado!';
CREATE EXCEPTION "EQTIPOMOVEX01" 'MOVIMENTO DE COMPRA N�O PODE TER TABELA DE PRE�O!';
CREATE EXCEPTION "EQTIPOMOVEX02" 'TABELA DE PRE�O EM BRANCO!';
CREATE EXCEPTION "FNITRECEBEREX01" 'PARCELA J� FOI PAGA!';
CREATE EXCEPTION "FNPAGAREX01" 'PARCELA J� FOI PAGA!';
CREATE EXCEPTION "FNSUBLANCAEX01" 'N�O � POSS�VEL ADICIONAR DOIS SUBLAN�AMENTOS PARA UMA TRANSFER�NCIA!';
CREATE EXCEPTION "FNSUBLANCAEX02" 'CONTAS DE DESPESAS OU RECEITAS N�O PODEM PARTICIPAR DE TRANSFER�NCIAS!';
CREATE EXCEPTION "FNSUBLANCAEX03" 'CONTAS DE BANCOS OU CAIXAS S� PODEM SE INTERAGIREM EM TRANSFER�NCIAS!';
CREATE EXCEPTION "FNSUBLANCAEX04" 'LAN�AMENTO COM VALOR ZERO!';
CREATE EXCEPTION "FNSUBSLANCAEX01" 'N�O � POSS�VEL ADICIONAR DOIS SUBLAN�AMENTOS PARA UMA TRANSFER�NCIA!';
CREATE EXCEPTION "FNSUBSLANCAEX02" 'CONTAS DE DESPESAS OU RECEITAS N�O PODEM PARTICIPAR DE TRANSFER�NCIAS!';
CREATE EXCEPTION "FNSUBSLANCAEX03" 'CONTAS DE BANCOS OU CAIXAS S� PODEM SE INTERAGIREM EM TRANSFER�NCIAS!';
CREATE EXCEPTION "PPESTRUFASE01" 'J� existe uma fase que finalizadora neste processo!';
CREATE EXCEPTION "PPESTRUTURAEX01" 'Estrutura n�o pode ser ativada, pois n�o possui uma fase finalizadora!';
CREATE EXCEPTION "PPOPFASE" 'Existem fases n�o concluidas para essa OP.';
CREATE EXCEPTION "PVSEQCAIXA01" 'FAIXA DE SEQUENCIA DO CAIXA N�O DEFINIDA';
CREATE EXCEPTION "PVSEQCAIXA02" 'FAIXA DE SEQUENCIA DO CAIXA EXCEDIDA!';
CREATE EXCEPTION "SGCONEXAOEX01" 'Banco de dados est� conectado com este usu�rio em outra filial!';
CREATE EXCEPTION "SGCONEXAOEX02" 'Usu�rio inv�lido.';
CREATE EXCEPTION "SGFILIALEX01" 'EMPRESA N�O POSSUI MATRIZ!';
CREATE EXCEPTION "SGFILIALEX02" 'N�O FOI POSS�VEL ENCONTRAR FILIAL ATIVA PARA ESTE USU�RIO!';
CREATE EXCEPTION "VDCLCOMISEX01" 'PERCENTUAL TOTAL DE DISTRIBUI��O INV�LIDO!';
CREATE EXCEPTION "VDCOMISSAOEX01" 'COMISSAO JA FOI PAGA!';
CREATE EXCEPTION "VDCOMISSAOEX02" 'COMISSAO NAO FOI LIBERADA!';
CREATE EXCEPTION "VDITVENDAEX01" 'PRODUTO N�O PODE SER ALTERADO!';
CREATE EXCEPTION "VDITVENDAEX02" 'LOTE N�O PODE SER ALTERADO!';
CREATE EXCEPTION "VDITVENDAEX03" 'N�O FOI POSS�VEL ENCONTRAR A NATUREZA DA OPERA��O';
CREATE EXCEPTION "VDVENDAEX01" 'ERRO LIVRE!!!!';
CREATE EXCEPTION "VDVENDAEX02" 'Venda n�o foi liberada!';
CREATE EXCEPTION "VDVENDAEX03" 'Valor da venda ultrapassa o valor liberado!';
CREATE EXCEPTION "VDVENDAEX04" 'Valor da venda ultrapassa o cr�dito pr�-aprovado!';
CREATE EXCEPTION "VDVENDAEX05" 'ESTA VENDA FOI CANCELADA!';
CREATE EXCEPTION "VDVENDAEX06" 'O TOTAL DA NOTA N�O CONFERE COM TOTAL DAS PARCELAS!';

COMMIT WORK;

/* (c) 1998-2002 by Boris Loboda, barry@audit.kharkov.com */