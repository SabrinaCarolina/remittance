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
public class LayoutSantander implements Layout<LayoutSantander.Header.HeaderBuilder, LayoutSantander.Details.DetailsBuilder, LayoutSantander.Trailer.TrailerBuilder> {
    private Header header;
    private List<Details> details;
    private Trailer trailer;

    public LayoutSantander() {
        this.details = new ArrayList<>();
    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Header implements AttSpecProcessor {
        @AttSpec(orientation = FillOrientation.LEFT, fillChar = '0')
        private int codigoRegistro;
        /**
         * Default: 1
         */
        @AttSpec(value = "1", orientation = FillOrientation.LEFT, fillChar = '0')
        private String codigoRemessa;
        /**
         * Default: REMESSA
         */
        @AttSpec(value = "REMESSA", length = 7)
        private String literalTransmissao;
        /**
         * Default: 1
         */
        @AttSpec(length = 2, value = "1", orientation = FillOrientation.LEFT, fillChar = '0')
        private String codigoServico;
        /**
         * Default: COBRANCA
         */
        @AttSpec(length = 15, value = "COBRANCA")
        private String literalServico;
        @AttSpec(length = 20, orientation = FillOrientation.LEFT, fillChar = '0')
        private String codigoTransmissao;
        @AttSpec(length = 30)
        private String nomeBeneficiario;
        /**
         * Default: 003
         */
        @AttSpec(length = 3, value = "003", orientation = FillOrientation.LEFT, fillChar = '0')
        private String codigoBanco;
        /**
         * Default: SANTANDER
         */
        @AttSpec(length = 15, value = "SANTANDER", orientation = FillOrientation.LEFT, fillChar = '0')
        private String nomeBanco;
        @AttSpec(length = 6, orientation = FillOrientation.LEFT, fillChar = '0', format = Format.DATE_DDMMYY, cleanerType = CleanerType.NUMBER_ONLY)
        private LocalDate dataGravacao;
        @AttSpec(length = 16, orientation = FillOrientation.LEFT, fillChar = '0')
        private final String zeros = "";
        @AttSpec(length = 47)
        private String mensagens1;
        @AttSpec(length = 47)
        private String mensagens2;
        @AttSpec(length = 47)
        private String mensagens3;
        @AttSpec(length = 47)
        private String mensagens4;
        @AttSpec(length = 47)
        private String mensagens5;
        @AttSpec(length = 34)
        private final String brancos = "";
        @AttSpec(length = 6)
        private final String brancos1 = "";
        @AttSpec(length = 3, orientation = FillOrientation.LEFT, fillChar = '0')
        private String numeroRemessaOpcional;
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
        @AttSpec(value = "1", orientation = FillOrientation.LEFT, fillChar = '0')
        private String codigoRegistro;
        @AttSpec(length = 2, orientation = FillOrientation.LEFT, fillChar = '0')
        private int tipoInscricaoBeneficiario;
        @AttSpec(length = 14, orientation = FillOrientation.LEFT, fillChar = '0', cleanerType = CleanerType.NUMBER_ONLY)
        private String numeroCnpjcpfBeneficiario;
        @AttSpec(length = 20, orientation = FillOrientation.LEFT, fillChar = '0')
        private String codigoTransmissao;
        @AttSpec(length = 25)
        private String numeroControleCliente;
        @AttSpec(length = 8, orientation = FillOrientation.LEFT, fillChar = '0')
        private long nossoNumero;
        @AttSpec(length = 6, orientation = FillOrientation.LEFT, fillChar = '0', format = Format.DATE_DDMMYY, cleanerType = CleanerType.NUMBER_ONLY)
        private LocalDate dataSegundoDesconto;
        @AttSpec()
        private final String branco = "";
        @AttSpec(orientation = FillOrientation.LEFT, fillChar = '0')
        private int informacaoMulta;
        @AttSpec(length = 4, orientation = FillOrientation.LEFT, fillChar = '0', cleanerType = CleanerType.NUMBER_ONLY, format = Format.DECIMAL_DD)
        private BigDecimal percentualMultaAtraso;
        @AttSpec(length = 2, orientation = FillOrientation.LEFT, fillChar = '0')
        private String unidadeValorMoedaCorrente;
        @AttSpec(length = 13, orientation = FillOrientation.LEFT, fillChar = '0', format = Format.DECIMAL_DD, cleanerType = CleanerType.NUMBER_ONLY)
        private BigDecimal valorTituloOutraUnidade;
        @AttSpec(length = 4)
        private final String brancos = "";
        @AttSpec(length = 6, orientation = FillOrientation.LEFT, fillChar = '0', format = Format.DATE_DDMMYY, cleanerType = CleanerType.NUMBER_ONLY)
        private LocalDate dataCobrancaMulta;
        @AttSpec(orientation = FillOrientation.LEFT, fillChar = '0')
        private int codigoCarteira;
        @AttSpec(length = 2, orientation = FillOrientation.LEFT, fillChar = '0')
        private int codigoOcorrencia;
        @AttSpec(length = 10)
        private String seuNumero;
        @AttSpec(length = 6, orientation = FillOrientation.LEFT, fillChar = '0', format = Format.DATE_DDMMYY, cleanerType = CleanerType.NUMBER_ONLY)
        private LocalDate dataVencimento;
        @AttSpec(length = 13, orientation = FillOrientation.LEFT, fillChar = '0', format = Format.DECIMAL_DD, cleanerType = CleanerType.NUMBER_ONLY)
        private BigDecimal valorTitulo;
        @AttSpec(length = 3)
        private String numeroBancoCobrador;
        @AttSpec(length = 5, orientation = FillOrientation.LEFT, fillChar = '0')
        private int codigoAgenciaCobradora;
        @AttSpec(length = 2, orientation = FillOrientation.LEFT, fillChar = '0')
        private int especieDocumento;
        /**
         * Default: N
         */
        @AttSpec(value = "N")
        private String tipoAceite;
        @AttSpec(length = 6, orientation = FillOrientation.LEFT, fillChar = '0', format = Format.DATE_DDMMYY, cleanerType = CleanerType.NUMBER_ONLY)
        private LocalDate dataEmissaoTitulo;
        @AttSpec(length = 2, orientation = FillOrientation.LEFT, fillChar = '0')
        private String primeiraInstrucaoCobranca;
        @AttSpec(length = 2, orientation = FillOrientation.LEFT, fillChar = '0')
        private String segundaInstrucaoCobranca;
        @AttSpec(length = 13, orientation = FillOrientation.LEFT, fillChar = '0', format = Format.DECIMAL_DD, cleanerType = CleanerType.NUMBER_ONLY)
        private BigDecimal valorMoraCobradoDiaAtraso;
        @AttSpec(length = 6, orientation = FillOrientation.LEFT, fillChar = '0', format = Format.DATE_DDMMYY, cleanerType = CleanerType.NUMBER_ONLY)
        private LocalDate dataLimiteDesconto;
        @AttSpec(length = 13, orientation = FillOrientation.LEFT, fillChar = '0', format = Format.DECIMAL_DD, cleanerType = CleanerType.NUMBER_ONLY)
        private BigDecimal valorDesconto;
        @AttSpec(length = 13, orientation = FillOrientation.LEFT, fillChar = '0', format = Format.DECIMAL_DD, cleanerType = CleanerType.NUMBER_ONLY)
        private BigDecimal valorIof;
        @AttSpec(length = 13, orientation = FillOrientation.LEFT, fillChar = '0', format = Format.DECIMAL_DD, cleanerType = CleanerType.NUMBER_ONLY)
        private BigDecimal valorAbatimento;
        @AttSpec(length = 2, orientation = FillOrientation.LEFT, fillChar = '0')
        private int tipoInscricaoPagador;
        @AttSpec(length = 14, orientation = FillOrientation.LEFT, fillChar = '0', cleanerType = CleanerType.NUMBER_ONLY)
        private String cnpjcpfPagador;
        @AttSpec(length = 40)
        private String nomePagador;
        @AttSpec(length = 40)
        private String enderecoPagador;
        @AttSpec(length = 12)
        private String bairroPagador;
        @AttSpec(length = 8, orientation = FillOrientation.LEFT, fillChar = '0', cleanerType = CleanerType.NUMBER_ONLY)
        private String cepPagador;
        @AttSpec(length = 15)
        private String municipioPagador;
        @AttSpec(length = 2)
        private String ufEstadoPagador;
        @AttSpec(length = 30)
        private String nomeSacador;
        @AttSpec()
        private final String brancos1 = "";
        @AttSpec(orientation = FillOrientation.LEFT, fillChar = '0')
        private String identificadorComplemento;
        @AttSpec(length = 2)
        private String complemento;
        @AttSpec(length = 6)
        private final String brancos2 = "";
        @AttSpec(length = 2, orientation = FillOrientation.LEFT, fillChar = '0')
        private int numeroDiasProtesto;
        @AttSpec()
        private final String branco3 = "";
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
        @AttSpec(length = 6, orientation = FillOrientation.LEFT, fillChar = '0')
        private int quantidadeDocumentos;
        @AttSpec(length = 13, orientation = FillOrientation.LEFT, fillChar = '0', format = Format.DECIMAL_DD, cleanerType = CleanerType.NUMBER_ONLY)
        private BigDecimal valorTotalTitulos;
        @AttSpec(length = 374, orientation = FillOrientation.LEFT, fillChar = '0')
        private final String zeros = "";
        @AttSpec(length = 6, orientation = FillOrientation.LEFT, fillChar = '0')
        private String numeroSequencialRegistro;
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
