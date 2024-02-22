package br.com.adrianoaluizio.models.dto;

import br.com.adrianoaluizio.models.annotations.AttSpec;
import br.com.adrianoaluizio.models.enums.CleanerType;
import br.com.adrianoaluizio.models.enums.FillOrientation;
import br.com.adrianoaluizio.models.enums.Format;
import br.com.adrianoaluizio.processors.AttSpecProcessor;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class LayoutBB implements
                      Layout<LayoutBB.Header.HeaderBuilder, LayoutBB.Details.DetailsBuilder, LayoutBB.Trailer.TrailerBuilder> {
	private Header header;
	private List<Details> details;
	private Trailer trailer;

	public LayoutBB() {
		this.details = new ArrayList<>();
	}

	@Getter
	@Setter
	@Builder
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Header implements AttSpecProcessor {

		@AttSpec(required=true)
		private Integer identificacaoRegistro;
		@AttSpec(orientation=FillOrientation.LEFT, fillChar='0')
		private Integer tipoOperacao;
		@AttSpec(length=7, required=true)
		private String identificacaoExtensoTipoOperacao;
		@AttSpec(length=2, orientation=FillOrientation.LEFT, fillChar='0')
		private Integer identificacaoTipoServico;
		@AttSpec(length=8, required=true)
		private String identificacaoExtensoTipoServico;
		@AttSpec(length=7)
		private final String complementoRegistro7 = "";
		@AttSpec(length=4, orientation=FillOrientation.LEFT, fillChar='0')
		private String prefixoAgencia;
		@AttSpec(required=true)
		private String digitoVerificadorAgencia;
		@AttSpec(length=8, orientation=FillOrientation.LEFT, fillChar='0')
		private String numeroContaCorrente;
		@AttSpec
		private String digitoConta;
		@AttSpec(length=6, orientation=FillOrientation.LEFT, fillChar='0')
		private final String complementoRegistro6 = "";
		@AttSpec(length=30, required=true)
		private String nomeCedente;
		/**
		 Default: 001BANCODOBRASIL
		 */
		@AttSpec(length=18, value="001BANCODOBRASIL")
		private String banco;
		@AttSpec(length=6, format=Format.DATE_DDMMYY, orientation=FillOrientation.LEFT, fillChar='0')
		private LocalDate dataGravacao;
		@AttSpec(length=7, orientation=FillOrientation.LEFT, fillChar='0')
		private Long sequencialRemessa;
		@AttSpec(length=22)
		private final String complementoRegistro22 = "";
		@AttSpec(length=7, orientation=FillOrientation.LEFT, fillChar='0')
		private String numeroConvenioLider;
		@AttSpec(length=258)
		private final String complementoRegistro258 = "";
		@AttSpec(length=6, orientation=FillOrientation.LEFT, fillChar='0')
		private Long sequencialRegistro;

	}

	@Getter
	@Setter
	@Builder
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Details implements AttSpecProcessor {
		@AttSpec(value="7")
		private String identificacaoRegistro;
		@AttSpec(length=2, orientation=FillOrientation.LEFT, fillChar='0', cleanerType=CleanerType.NUMBER_ONLY)
		private Long tipoInscricaoCedente;
		@AttSpec(length=14, orientation=FillOrientation.LEFT, fillChar='0', cleanerType=CleanerType.NUMBER_ONLY)
		private String numeroCpfCliente;
		@AttSpec(length=4, orientation=FillOrientation.LEFT, fillChar='0')
		private String prefixoAgencia;
		@AttSpec()
		private String digitoVerificadorAgencia;
		@AttSpec(length=8, orientation=FillOrientation.LEFT, fillChar='0')
		private String numeroContaCorrente;
		@AttSpec()
		private String digitoConta;
		@AttSpec(length=7, orientation=FillOrientation.LEFT, fillChar='0')
		private String numeroConvenioCliente;
		@AttSpec(length=25)
		private Long codigoControleEmpresa;
		@AttSpec(length=7, orientation=FillOrientation.LEFT, fillChar='0')
		private String convenioNn;
		@AttSpec(length=10, orientation=FillOrientation.LEFT, fillChar='0', cleanerType=CleanerType.NUMBER_ONLY)
		private Long nossoNumero;
		@AttSpec(length=2, orientation=FillOrientation.LEFT, fillChar='0', cleanerType=CleanerType.NUMBER_ONLY)
		private Long numeroPrestacao;
		@AttSpec(length=2, orientation=FillOrientation.LEFT, fillChar='0', cleanerType=CleanerType.NUMBER_ONLY)
		private Long grupoValor;
		@AttSpec(length=3)
		private String complementoRegistro3;
		@AttSpec()
		private String indicativoMensagemSacadorAvalista;
		@AttSpec(length=3)
		private String prefixoTitulo;
		@AttSpec(length=3, orientation=FillOrientation.LEFT, fillChar='0')
		private String variacaoCarteira;
		@AttSpec(orientation=FillOrientation.LEFT, fillChar='0', cleanerType=CleanerType.NUMBER_ONLY)
		private Long contaCaucao;
		@AttSpec(length=6, orientation=FillOrientation.LEFT, fillChar='0', cleanerType=CleanerType.NUMBER_ONLY)
		private Long numeroBordero;
		@AttSpec(length=5)
		private String tipoCobranca;
		@AttSpec(length=2, orientation=FillOrientation.LEFT, fillChar='0')
		private String carteiraCobranca;
		@AttSpec(length=2, orientation=FillOrientation.LEFT, fillChar='0')
		private Long comando;
		@AttSpec(length=10)
		private String numeroTitulo;
		@AttSpec(length=6, format=Format.DATE_DDMMYY, cleanerType=CleanerType.NUMBER_ONLY, fillChar = '0')
		private LocalDate dataVencimento;
		@AttSpec(length=13, orientation=FillOrientation.LEFT, fillChar='0', format=Format.DECIMAL_DD, cleanerType=CleanerType.NUMBER_ONLY)
		private BigDecimal valorTitulo;
		@AttSpec(length=3, orientation=FillOrientation.LEFT, fillChar='0')
		private Long numeroBanco;
		@AttSpec(length=4, orientation=FillOrientation.LEFT, fillChar='0')
		private String prefixoAgenciaCobradora;
		@AttSpec()
		private String digitoVerificadorAgenciaCobradora;
		@AttSpec(length=2, orientation=FillOrientation.LEFT, fillChar='0', value="02")
		private String especieTitulo;
		@AttSpec()
		private String aceiteTitulo;
		@AttSpec(length=6, format=Format.DATE_DDMMYY, cleanerType=CleanerType.NUMBER_ONLY, fillChar = '0')
		private LocalDate dataEmissaoTitulo;
		@AttSpec(length=2, orientation=FillOrientation.LEFT, fillChar='0')
		private String instrucaoCodificada1;
		@AttSpec(length=2, orientation=FillOrientation.LEFT, fillChar='0')
		private String instrucaoCodificada2;
		@AttSpec(length=13, orientation=FillOrientation.LEFT, fillChar='0', format=Format.DECIMAL_DD, cleanerType=CleanerType.NUMBER_ONLY)
		private BigDecimal jurosMora;
		@AttSpec(length=6, format=Format.DATE_DDMMYY, cleanerType=CleanerType.NUMBER_ONLY, fillChar = '0')
		private LocalDate dataLimiteDesconto;
		@AttSpec(length=13, orientation=FillOrientation.LEFT, fillChar='0', format=Format.DECIMAL_DD, cleanerType=CleanerType.NUMBER_ONLY)
		private BigDecimal valorDesconto;
		@AttSpec(length=13, orientation=FillOrientation.LEFT, fillChar='0', format=Format.DECIMAL_DD, cleanerType=CleanerType.NUMBER_ONLY)
		private BigDecimal valorIof;
		@AttSpec(length=13, orientation=FillOrientation.LEFT, fillChar='0', format=Format.DECIMAL_DD, cleanerType=CleanerType.NUMBER_ONLY)
		private BigDecimal valorAbatimento;
		@AttSpec(length=2, orientation=FillOrientation.LEFT, fillChar='0')
		private Long tipoInscricaoSacado;
		@AttSpec(length=14, orientation=FillOrientation.LEFT, fillChar='0', cleanerType=CleanerType.NUMBER_ONLY)
		private String cpfSacado;
		@AttSpec(length=37)
		private String nomeSacado;
		@AttSpec(length=3)
		private String complemento;
		@AttSpec(length=40)
		private String enderecoSacado;
		@AttSpec(length=12)
		private String bairroSacado;
		@AttSpec(length=8, orientation=FillOrientation.LEFT, fillChar='0', cleanerType=CleanerType.NUMBER_ONLY)
		private String cepSacado;
		@AttSpec(length=15)
		private String cidadeSacado;
		@AttSpec(length=2)
		private String ufCidadeSacado;
		@AttSpec(length=40)
		private String observacaoSacador;
		@AttSpec(length=2, orientation=FillOrientation.LEFT, fillChar='0')
		private String numeroDiasProtesto;
		@AttSpec()
		private String complementoRegistro;
		@AttSpec(length=6, orientation=FillOrientation.LEFT, fillChar='0')
		private Long sequencialRegistro;
		@AttSpec(breakLine=true)
		private Multa multa;


		@Getter
		@Setter
		@Builder
		@AllArgsConstructor
		@NoArgsConstructor
		public static class Multa implements AttSpecProcessor {
			@AttSpec(required=true, value="5")
			private String identificacaoRegistro;
			@AttSpec(length=2)
			private String tipoServico;
			@AttSpec()
			private Long codigoMulta;
			@AttSpec(length=6, format=Format.DATE_DDMMYY, fillChar='0', orientation=FillOrientation.LEFT)
			private LocalDate dataInicio;
			@AttSpec(length=12, orientation=FillOrientation.LEFT, fillChar='0', format=Format.DECIMAL_DD, cleanerType=CleanerType.NUMBER_ONLY)
			private BigDecimal valorMulta;
			@AttSpec(length=372)
			private String branco;
			@AttSpec(length=6, orientation=FillOrientation.LEFT, fillChar='0', cleanerType=CleanerType.NUMBER_ONLY)
			private Long numeroSequencial;
		}
	}

	@Getter
	@Setter
	@Builder
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Trailer implements AttSpecProcessor {
		/**
		 Default: 9
		 */
		@AttSpec(value="9")
		private String codigoDoRegistro;
		@AttSpec(length=393)
		private final String filter = "";
		@AttSpec(length=6, orientation=FillOrientation.LEFT, fillChar='0', cleanerType=CleanerType.NUMBER_ONLY)
		private Long numeroSequencialRegistro;
	}

	public void addHeader(Execute<Header.HeaderBuilder> builder) {
		Header.HeaderBuilder b = Header.builder();
		builder.execute(b);
		this.header = b.build();
	}

	public void addDetails(Execute<Details.DetailsBuilder> builder) {
		Details.DetailsBuilder b = Details.builder();
		builder.execute(b);
		this.details.add(b.build());
	}

	public void addTrailer(Execute<Trailer.TrailerBuilder> builder) {
		Trailer.TrailerBuilder b = Trailer.builder();
		builder.execute(b);
		this.trailer = b.build();
	}

}

