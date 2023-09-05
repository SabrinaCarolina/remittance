package br.com.adrianoaluizio.models.dto;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicReference;

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
		                   .sequencialRegistro(1L)
		            );

		AtomicReference<LayoutBB.Details.Multa> interest = new AtomicReference<>();
		Execute<LayoutBB.Details.DetailsBuilder> e = d ->
				d.tipoInscricaoCedente(2L)
				 .numeroCpfCliente("34265115845")
				 .prefixoAgencia("2345")
				 .digitoVerificadorAgencia("32")
				 .numeroContaCorrente("65855")
				 .digitoConta("7")
				 .numeroConvenioCliente("365")
				 .codigoControleEmpresa(2L)
				 .nossoNumero(3L)
				 .convenioNn("65478")
				 .variacaoCarteira("8")
				 .carteiraCobranca("98")
				 .comando(1L)
				 .numeroTitulo(98111L)
				 .dataVencimento(LocalDate.now())
				 .valorTitulo(BigDecimal.TEN)
				 .numeroBanco(1L)
				 .prefixoAgenciaCobradora("0000")
				 .especieTitulo("44455")
				 .aceiteTitulo("N")
				 .dataVencimento(LocalDate.now())
				 .dataEmissaoTitulo(LocalDate.now())
				 .instrucaoCodificada1("teste")
				 .instrucaoCodificada2("tyeste")
				 .jurosMora(BigDecimal.ONE)
				 .tipoInscricaoSacado(1L)
				 .nomeSacado("adriano")
				 .cpfSacado("34265115845")
				 .enderecoSacado("teste")
				 .bairroSacado("teste")
				 .cepSacado("teste")
				 .cidadeSacado("teste")
				 .ufCidadeSacado("teste")
				 .sequencialRegistro(2L)
				 .multa(interest.get());
		interest.set(LayoutBB.Details.Multa.builder()
		                                   .tipoServico("tt")
		                                   .codigoMulta(1L)
		                                   .valorMulta(BigDecimal.TEN)
		                                   .dataInicio(LocalDate.now())
		                                   .numeroSequencial(3L)
		                                   .build());
		bb.addDetails(e);
		bb.addTrailer(t -> t.numeroSequencialRegistro(4L)
		                    .codigoDoRegistro("zz"));
		String render = bb.render();
		System.out.println(render);
		assertNotEquals("", render);
		assertNotNull(render);
	}

	@Test
	void renderMultaNull() {
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
		                   .sequencialRegistro(1L)
		            );

		LayoutBB.Details.Multa interest = null;

		bb.addDetails(d ->
				              d.tipoInscricaoCedente(2L)
				               .numeroCpfCliente("34265115845")
				               .prefixoAgencia("2345")
				               .digitoVerificadorAgencia("32")
				               .numeroContaCorrente("65855")
				               .digitoConta("7")
				               .numeroConvenioCliente("365")
				               .codigoControleEmpresa(2L)
				               .nossoNumero(3L)
				               .convenioNn("65478")
				               .variacaoCarteira("8")
				               .carteiraCobranca("98")
				               .comando(1L)
				               .numeroTitulo(98111L)
				               .dataVencimento(LocalDate.now())
				               .valorTitulo(BigDecimal.TEN)
				               .numeroBanco(1L)
				               .prefixoAgenciaCobradora("0000")
				               .especieTitulo("44455")
				               .aceiteTitulo("N")
				               .dataVencimento(LocalDate.now())
				               .dataEmissaoTitulo(LocalDate.now())
				               .instrucaoCodificada1("teste")
				               .instrucaoCodificada2("tyeste")
				               .jurosMora(BigDecimal.ONE)
				               .tipoInscricaoSacado(1L)
				               .nomeSacado("adriano")
				               .cpfSacado("34265115845")
				               .enderecoSacado("teste")
				               .bairroSacado("teste")
				               .cepSacado("teste")
				               .cidadeSacado("teste")
				               .ufCidadeSacado("teste")
				               .sequencialRegistro(2L)
				               .multa(interest)
		             );
		bb.addTrailer(t -> t.numeroSequencialRegistro(1L)
		                    .codigoDoRegistro("zz"));
		String render = bb.render();
		System.out.println(render);
		assertNotEquals("", render);
		assertNotNull(render);
	}

	@Test
	void renderBradesco() {
		LayoutBradesco bb = new LayoutBradesco();
		bb.addHeader(h -> h.codigoServico(1)
				             .codigoEmpresa("1")
				             .nomeEmpresa("teste")
				             .codigoBanco("12")
				             .dataGravacao(LocalDate.now())
				             .identificacaoRemessa("2")
				             .numeroSequencialRemessa(98)
				             .numeroSequencialRegistro(1)
		            );

		bb.addDetails(d ->
				              d.agenciaDebitoAuto("66")
						              .valorTitulo(BigDecimal.valueOf(23.12))
						              .bancoCobranca("99")
						              .valorJurosMora(BigDecimal.TEN)
		             );
		bb.addTrailer(t -> t.numeroSequencialRegistro(1)
		                    .codigoDoRegistro("zz"));
		String render = bb.render();
		System.out.println(render);
		assertNotEquals("", render);
		assertNotNull(render);
	}

	@Test
	void renderItau() {
		LayoutItau bb = new LayoutItau();

		LayoutItau.Details.Multa interest = LayoutItau.Details.Multa.builder().dataInicio(LocalDate.now()).build();
		bb.addHeader(h -> h.tipoOperacao(1)
		            );

		bb.addDetails(d ->
				              d.tipoInscricaoCedente(66)
						              .multa(interest)
		             );
		bb.addTrailer(t -> t.numeroSequencialRegistro("1")
		                    .codigoDoRegistro("zz"));
		String render = bb.render();
		System.out.println(render);
		assertNotEquals("", render);
		assertNotNull(render);
	}
}