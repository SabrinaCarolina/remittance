package br.com.adrianoaluizio.models.dto;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class LayoutTest {

	@Test
	void render() {
		LayoutBB bb = new LayoutBB();
		bb.addHeader(h -> h.identificacaoRegistro(0)
		                   .tipoOperacao(1)
		                   .identificacaoExtensoTipoOperacao("REMESSA")
		                   .identificacaoTipoServico(1)
		                   .identificacaoExtensoTipoServico("COBRANCA")
		                   .prefixoAgencia("1")
		                   .digitoVerificadorAgencia("9")
		                   .numeroContaCorrente("777")
		                   .digitoConta("2")
		                   .nomeCedente("adriano")
		                   .dataGravacao(LocalDate.now())
		                   .numeroConvenioLider("12312")
		                   .sequencialRegistro(1)
		            );

		LayoutBB.Details.Multa interest = LayoutBB.Details.Multa.builder()
		                                                        .tipoServico("tt")
		                                                        .codigoMulta(1)
		                                                        .valorMulta(BigDecimal.TEN)
		                                                        .dataInicio(LocalDate.now())
		                                                        .numeroSequencial(1)
		                                                        .build();

		bb.addDetails(d ->
				              d.tipoInscricaoCedente(2)
				               .numeroCpfCliente("34265115845")
				               .prefixoAgencia("2345")
				               .digitoVerificadorAgencia("32")
				               .numeroContaCorrente("65855")
				               .digitoConta("7")
				               .numeroConvenioCliente("365")
				               .codigoControleEmpresa(2)
				               .nossoNumero(3)
				               .convenioNn("65478")
				               .variacaoCarteira("8")
				               .carteiraCobranca("98")
				               .comando(1)
				               .numeroTitulo(98111)
				               .dataVencimento(LocalDate.now())
				               .valorTitulo(BigDecimal.TEN)
				               .numeroBanco(1)
				               .prefixoAgenciaCobradora("0000")
				               .especieTitulo("44455")
				               .aceiteTitulo("N")
				               .dataVencimento(LocalDate.now())
				               .dataEmissaoTitulo(LocalDate.now())
				               .instrucaoCodificada1("teste")
				               .instrucaoCodificada2("tyeste")
				               .jurosMora(BigDecimal.ONE)
				               .tipoInscricaoSacado(1)
				               .nomeSacado("adriano")
				               .cpfSacado("34265115845")
				               .enderecoSacado("teste")
				               .bairroSacado("teste")
				               .cepSacado("teste")
				               .cidadeSacado("teste")
				               .ufCidadeSacado("teste")
				               .sequencialRegistro(1)
				               .multa(interest)
		             );
		bb.addTrailer(t -> t.numeroSequencialRegistro(1)
		                    .codigoDoRegistro("zz"));
		String render = bb.render();
		assertNotEquals("", render);
		assertNotNull(render);
	}
}