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
public class LayoutBB implements Layout<LayoutBB.Header.HeaderBuilder, LayoutBB.Details.DetailsBuilder, LayoutBB.Trailer.TrailerBuilder> {
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

        @AttSpec(required = true)
        private Integer identificacaoRegistro;
        @AttSpec(orientation = FillOrientation.LEFT, fillChar = '0')
        private Integer tipoOperacao;
        @AttSpec(length = 7, required = true)
        private String identificacaoExtensoTipoOperacao;
        @AttSpec(length = 2, orientation = FillOrientation.LEFT, fillChar = '0')
        private Integer identificacaoTipoServico;
        @AttSpec(length = 8, required = true)
        private String identificacaoExtensoTipoServico;
        @AttSpec(length = 7)
        private final String complementoRegistro7 = "";
        @AttSpec(length = 4, orientation = FillOrientation.LEFT, fillChar = '0')
        private String prefixoAgencia;
        @AttSpec(required = true)
        private String digitoVerificadorAgencia;
        @AttSpec(length = 8, orientation = FillOrientation.LEFT, fillChar = '0')
        private String numeroContaCorrente;
        @AttSpec
        private String digitoConta;
        @AttSpec(length = 6, orientation = FillOrientation.LEFT, fillChar = '0')
        private final String complementoRegistro6 = "";
        @AttSpec(length = 30, required = true)
        private String nomeCedente;
        /**
         * Default: 001BANCODOBRASIL
         */
        @AttSpec(length = 18, value = "001BANCODOBRASIL")
        private String banco;
        @AttSpec(length = 6, format = Format.DATE_DDMMYY, orientation = FillOrientation.LEFT, fillChar = '0')
        private LocalDate dataGravacao;
        @AttSpec(length = 7, orientation = FillOrientation.LEFT, fillChar = '0')
        private long sequencialRemessa;
        @AttSpec(length = 22)
        private final String complementoRegistro22 = "";
        @AttSpec(length = 7, orientation = FillOrientation.LEFT, fillChar = '0')
        private String numeroConvenioLider;
        @AttSpec(length = 258)
        private final String complementoRegistro258 = "";
        @AttSpec(length = 6, orientation = FillOrientation.LEFT, fillChar = '0')
        private long sequencialRegistro;
    }

    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Details implements AttSpecProcessor {
        @AttSpec(value = "7")
        private String identificacaoRegistro;
        @AttSpec(length = 2, orientation = FillOrientation.LEFT, fillChar = '0', cleanerType = CleanerType.NUMBER_ONLY)
        private long tipoInscricaoCedente;
        @AttSpec(length = 14, orientation = FillOrientation.LEFT, fillChar = '0', cleanerType = CleanerType.NUMBER_ONLY)
        private String numeroCpfCliente;
        @AttSpec(length = 4, orientation = FillOrientation.LEFT, fillChar = '0')
        private String prefixoAgencia;
        @AttSpec()
        private String digitoVerificadorAgencia;
        @AttSpec(length = 8, orientation = FillOrientation.LEFT, fillChar = '0')
        private String numeroContaCorrente;
        @AttSpec()
        private String digitoConta;
        @AttSpec(length = 7, orientation = FillOrientation.LEFT, fillChar = '0')
        private String numeroConvenioCliente;
        @AttSpec(length = 25)
        private long codigoControleEmpresa;
        @AttSpec(length = 7, orientation = FillOrientation.LEFT, fillChar = '0')
        private String convenioNn;
        @AttSpec(length = 10, orientation = FillOrientation.LEFT, fillChar = '0', cleanerType = CleanerType.NUMBER_ONLY)
        private long nossoNumero;
        @AttSpec(length = 2, orientation = FillOrientation.LEFT, fillChar = '0', cleanerType = CleanerType.NUMBER_ONLY)
        private long numeroPrestacao;
        @AttSpec(length = 2, orientation = FillOrientation.LEFT, fillChar = '0', cleanerType = CleanerType.NUMBER_ONLY)
        private long grupoValor;
        @AttSpec(length = 3)
        private String complementoRegistro3;
        @AttSpec()
        private String indicativoMensagemSacadorAvalista;
        @AttSpec(length = 3)
        private String prefixoTitulo;
        @AttSpec(length = 3, orientation = FillOrientation.LEFT, fillChar = '0')
        private String variacaoCarteira;
        @AttSpec(orientation = FillOrientation.LEFT, fillChar = '0', cleanerType = CleanerType.NUMBER_ONLY)
        private long contaCaucao;
        @AttSpec(length = 6, orientation = FillOrientation.LEFT, fillChar = '0', cleanerType = CleanerType.NUMBER_ONLY)
        private long numeroBordero;
        @AttSpec(length = 5)
        private String tipoCobranca;
        @AttSpec(length = 2, orientation = FillOrientation.LEFT, fillChar = '0')
        private String carteiraCobranca;
        @AttSpec(length = 2, orientation = FillOrientation.LEFT, fillChar = '0')
        private long comando;
        @AttSpec(length = 10, orientation = FillOrientation.LEFT, fillChar = '0')
        private long numeroTitulo;
        @AttSpec(length = 6, format = Format.DATE_DDMMYY, cleanerType = CleanerType.NUMBER_ONLY)
        private LocalDate dataVencimento;
        @AttSpec(length = 13, orientation = FillOrientation.LEFT, fillChar = '0', format = Format.DECIMAL_DD, cleanerType = CleanerType.NUMBER_ONLY)
        private BigDecimal valorTitulo;
        @AttSpec(length = 3, orientation = FillOrientation.LEFT, fillChar = '0')
        private long numeroBanco;
        @AttSpec(length = 4, orientation = FillOrientation.LEFT, fillChar = '0')
        private String prefixoAgenciaCobradora;
        @AttSpec()
        private String digitoVerificadorAgenciaCobradora;
        @AttSpec(length = 2, orientation = FillOrientation.LEFT, fillChar = '0')
        private long especieTitulo;
        @AttSpec()
        private String aceiteTitulo;
        @AttSpec(length = 6, format = Format.DATE_DDMMYY, cleanerType = CleanerType.NUMBER_ONLY)
        private LocalDate dataEmissaoTitulo;
        @AttSpec(length = 2, orientation = FillOrientation.LEFT, fillChar = '0')
        private String instrucaoCodificada1;
        @AttSpec(length = 2, orientation = FillOrientation.LEFT, fillChar = '0')
        private String instrucaoCodificada2;
        @AttSpec(length = 13, orientation = FillOrientation.LEFT, fillChar = '0', format = Format.DECIMAL_DD, cleanerType = CleanerType.NUMBER_ONLY)
        private BigDecimal jurosMora;
        @AttSpec(length = 6, format = Format.DATE_DDMMYY, cleanerType = CleanerType.NUMBER_ONLY)
        private LocalDate dataLimiteDesconto;
        @AttSpec(length = 13, orientation = FillOrientation.LEFT, fillChar = '0', format = Format.DECIMAL_DD, cleanerType = CleanerType.NUMBER_ONLY)
        private BigDecimal valorDesconto;
        @AttSpec(length = 13, orientation = FillOrientation.LEFT, fillChar = '0', format = Format.DECIMAL_DD, cleanerType = CleanerType.NUMBER_ONLY)
        private BigDecimal valorIof;
        @AttSpec(length = 13, orientation = FillOrientation.LEFT, fillChar = '0', format = Format.DECIMAL_DD, cleanerType = CleanerType.NUMBER_ONLY)
        private BigDecimal valorAbatimento;
        @AttSpec(length = 2, orientation = FillOrientation.LEFT, fillChar = '0')
        private long tipoInscricaoSacado;
        @AttSpec(length = 14, orientation = FillOrientation.LEFT, fillChar = '0', cleanerType = CleanerType.NUMBER_ONLY)
        private String cpfSacado;
        @AttSpec(length = 37)
        private String nomeSacado;
        @AttSpec(length = 3)
        private String complemento;
        @AttSpec(length = 40)
        private String enderecoSacado;
        @AttSpec(length = 12)
        private String bairroSacado;
        @AttSpec(length = 8, orientation = FillOrientation.LEFT, fillChar = '0', cleanerType = CleanerType.NUMBER_ONLY)
        private String cepSacado;
        @AttSpec(length = 15)
        private String cidadeSacado;
        @AttSpec(length = 2)
        private String ufCidadeSacado;
        @AttSpec(length = 40)
        private String observacaoSacador;
        @AttSpec(length = 2, orientation = FillOrientation.LEFT, fillChar = '0')
        private String numeroDiasProtesto;
        @AttSpec()
        private String complementoRegistro;
        @AttSpec(length = 6, orientation = FillOrientation.LEFT, fillChar = '0')
        private long sequencialRegistro;
    }

    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Trailer implements AttSpecProcessor {
        /**
         * Default: 9
         */
        @AttSpec(value = "9")
        private String codigoDoRegistro;
        @AttSpec(length = 393)
        private final String filter ="";
        @AttSpec(length = 6, orientation = FillOrientation.LEFT, fillChar = '0', cleanerType = CleanerType.NUMBER_ONLY)
        private long numeroSequencialRegistro;
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

