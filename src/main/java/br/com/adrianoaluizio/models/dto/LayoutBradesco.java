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
public class LayoutBradesco implements Layout<LayoutBradesco.Header.HeaderBuilder, LayoutBradesco.Details.DetailsBuilder, LayoutBradesco.Trailer.TrailerBuilder> {
    private Header header;
    private List<Details> details;
    private Trailer trailer;

    public LayoutBradesco() {
        this.details = new ArrayList<>();
    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Header implements AttSpecProcessor {
        /**
         * Default: 0
         */
        @AttSpec(value = "0")
        private String codigoDoRegistro;
        /**
         * Default: 1
         */
        @AttSpec(value = "1", orientation = FillOrientation.LEFT, fillChar = '0')
        private String identificacaoRemessa;
        /**
         * Default: REMESSA
         */
        @AttSpec(length = 7, value = "REMESSA")
        private String literalRemessa;
        @AttSpec(length = 2, orientation = FillOrientation.LEFT, fillChar = '0')
        private int codigoServico;
        /**
         * Default: COBRANCA
         */
        @AttSpec(length = 15, value = "COBRANCA")
        private String literalServico;
        @AttSpec(length = 20, orientation = FillOrientation.LEFT, fillChar = '0')
        private String codigoEmpresa;
        @AttSpec(length = 30)
        private String nomeEmpresa;
        @AttSpec(length = 3, orientation = FillOrientation.LEFT, fillChar = '0')
        private String codigoBanco;
        /**
         * Default: BRADESCO
         */
        @AttSpec(length = 15, value = "BRADESCO")
        private String nomeBanco;
        @AttSpec(length = 6, format = Format.DATE_DDMMYY, cleanerType = CleanerType.NUMBER_ONLY)
        private LocalDate dataGravacao;
        @AttSpec(length = 8)
        private final String branco = "";
        @AttSpec(length = 2)
        private String identificacaoSistema;
        @AttSpec(length = 7, orientation = FillOrientation.LEFT, fillChar = '0')
        private String numeroSequencialRemessa;
        @AttSpec(length = 277)
        private final String branco1 = "";
        @AttSpec(length = 6, orientation = FillOrientation.LEFT, fillChar = '0')
        private int numeroSequencialRegistro;
    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Details implements AttSpecProcessor {
        /**
         * Default: 1
         */
        @AttSpec(value = "1")
        private int codigoRegistro;
        @AttSpec(length = 5, orientation = FillOrientation.LEFT, fillChar = '0')
        private String agenciaDebitoAuto;
        @AttSpec(orientation = FillOrientation.LEFT, fillChar = '0')
        private String digitoAgenciaDebitoAuto;
        @AttSpec(length = 5, orientation = FillOrientation.LEFT, fillChar = '0')
        private String razaoContaDebitoAuto;
        @AttSpec(length = 7, orientation = FillOrientation.LEFT, fillChar = '0')
        private String contaDebitoAuto;
        @AttSpec(orientation = FillOrientation.LEFT, fillChar = '0')
        private String digitoContaDebitoAuto;
        @AttSpec(length = 17)
        private String identificacaoEmpresa;
        @AttSpec(length = 25)
        private String controleEmpresa;
        @AttSpec(length = 3, orientation = FillOrientation.LEFT, fillChar = '0')
        private String codigoBanco;
        @AttSpec(orientation = FillOrientation.LEFT, fillChar = '0')
        private int campoMulta;
        @AttSpec(length = 4, orientation = FillOrientation.LEFT, fillChar = '0', format = Format.DECIMAL_DD, cleanerType = CleanerType.NUMBER_ONLY)
        private BigDecimal percentualMulta;
        @AttSpec(length = 11, orientation = FillOrientation.LEFT, fillChar = '0')
        private long identificacaoTitulo;
        @AttSpec()
        private String digitoConferencia;
        @AttSpec(length = 10, orientation = FillOrientation.LEFT, fillChar = '0')
        private String descontoBonificacao;
        @AttSpec()
        private String condicaoEmissao;
        @AttSpec()
        private String identificacaoDebitoAutomatico;
        @AttSpec(length = 10)
        private final String brancos = "";
        @AttSpec()
        private String rateioCredito;
        @AttSpec(orientation = FillOrientation.LEFT, fillChar = '0')
        private int enderecamentoDebitoAutomatico;
        @AttSpec(length = 2)
        private String quantidadePagamento;
        @AttSpec(length = 2, value = "01")
        private String indentificacaoOcorrencia;
        @AttSpec(length = 10)
        private String numeroDocumento;
        @AttSpec(length = 6, orientation = FillOrientation.LEFT, fillChar = '0', format = Format.DATE_DDMMYY, cleanerType = CleanerType.NUMBER_ONLY)
        private LocalDate dataVencimento;
        @AttSpec(length = 13, orientation = FillOrientation.LEFT, fillChar = '0', format = Format.DECIMAL_DD, cleanerType = CleanerType.NUMBER_ONLY)
        private BigDecimal valorTitulo;
        @AttSpec(length = 3, orientation = FillOrientation.LEFT, fillChar = '0')
        private String bancoCobranca;
        @AttSpec(length = 5, orientation = FillOrientation.LEFT, fillChar = '0')
        private String agenciaDepositaria;
        @AttSpec(length = 2, orientation = FillOrientation.LEFT, fillChar = '0')
        private String especieTitulo;
        /**
         * Default: N
         */
        @AttSpec(value = "N")
        private String identificacao;
        @AttSpec(length = 6, orientation = FillOrientation.LEFT, fillChar = '0', format = Format.DATE_DDMMYY, cleanerType = CleanerType.NUMBER_ONLY)
        private LocalDate dataEmissaoTitulo;
        @AttSpec(length = 2, orientation = FillOrientation.LEFT, fillChar = '0')
        private String primeiraInstrucao;
        @AttSpec(length = 2, orientation = FillOrientation.LEFT, fillChar = '0')
        private int diasProtesto;
        @AttSpec(length = 13, orientation = FillOrientation.LEFT, fillChar = '0', format = Format.DECIMAL_DD, cleanerType = CleanerType.NUMBER_ONLY)
        private BigDecimal valorJurosMora;
        @AttSpec(length = 6, orientation = FillOrientation.LEFT, fillChar = '0', format = Format.DATE_DDMMYY, cleanerType = CleanerType.NUMBER_ONLY)
        private LocalDate dataLimiteDesconto;
        @AttSpec(length = 13, orientation = FillOrientation.LEFT, fillChar = '0', format = Format.DECIMAL_DD, cleanerType = CleanerType.NUMBER_ONLY)
        private String valorDesconto;
        @AttSpec(length = 13, orientation = FillOrientation.LEFT, fillChar = '0', format = Format.DECIMAL_DD, cleanerType = CleanerType.NUMBER_ONLY)
        private BigDecimal valorIof;
        @AttSpec(length = 13, orientation = FillOrientation.LEFT, fillChar = '0', format = Format.DECIMAL_DD, cleanerType = CleanerType.NUMBER_ONLY)
        private BigDecimal valorAbatimento;
        @AttSpec(length = 2, orientation = FillOrientation.LEFT, fillChar = '0')
        private int tipoInscricaoPagador;
        @AttSpec(length = 14, orientation = FillOrientation.LEFT, fillChar = '0')
        private String numeroInscricaoPagador;
        @AttSpec(length = 40)
        private String nomePagador;
        @AttSpec(length = 40)
        private String enderecoPagador;
        @AttSpec(length = 12)
        private String primeiraMensagem;
        @AttSpec(length = 8, orientation = FillOrientation.LEFT, fillChar = '0')
        private String cepPagador;
        @AttSpec(length = 60)
        private String segundaMensagem;
        @AttSpec(length = 6, orientation = FillOrientation.LEFT, fillChar = '0')
        private int sequencialRegistro;
    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Trailer implements AttSpecProcessor {
        /**
         * Default: 9
         */
        @AttSpec(value = "9")
        private String codigoDoRegistro;
        @AttSpec(length = 393)
        private final String brancos = "";
        @AttSpec(length = 6, orientation = FillOrientation.LEFT, fillChar = '0')
        private int numeroSequencialRegistro;
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
