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
public class LayoutBancoNordeste implements Layout<LayoutBancoNordeste.Header.HeaderBuilder, LayoutBancoNordeste.Details.DetailsBuilder, LayoutBancoNordeste.Trailer.TrailerBuilder> {
    private Header header;
    private List<Details> details;
    private Trailer trailer;

    public LayoutBancoNordeste() {
        this.details = new ArrayList<>();
    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Header implements AttSpecProcessor {
        /**
         * default: 0
         */
        @AttSpec(value = "0")
        private int codigoDoRegistro;
        /**
         * default: 1
         */
        @AttSpec(value = "1", length = 2, orientation = FillOrientation.LEFT, fillChar = '0')
        private int identificacaoRemessa;
        /**
         * default: REMESSA
         */
        @AttSpec(length = 7, value = "REMESSA")
        private String literalRemessa;
        @AttSpec(length = 2, value = "1", orientation = FillOrientation.LEFT, fillChar = '0')
        private String codigoServico;
        /**
         * default: COBRANCA
         */
        @AttSpec(length = 15, value = "COBRANCA")
        private String literalServico;
        @AttSpec(length = 4, orientation = FillOrientation.LEFT, fillChar = '0')
        private String codigoAgencia;
        @AttSpec(length = 2, value = "00", orientation = FillOrientation.LEFT, fillChar = '0')
        private final String zeros = "";
        @AttSpec(length = 7, orientation = FillOrientation.LEFT, fillChar = '0')
        private String numeroConta;
        @AttSpec(orientation = FillOrientation.LEFT, fillChar = '0')
        private String digitoConta;
        @AttSpec(length = 6)
        private final String branco1 = "";
        @AttSpec(length = 30)
        private String nomeEmpresa;
        @AttSpec(length = 3, orientation = FillOrientation.LEFT, fillChar = '0')
        private String codigoBanco;
        /**
         * default: B. DO NORDESTE
         */
        @AttSpec(length = 15, value = "B.DO NORDESTE")
        private String nomeBanco;
        @AttSpec(length = 6, format = Format.DATE_DDMMYY)
        private LocalDate dataGravacao;
        @AttSpec(length = 3, orientation = FillOrientation.LEFT, fillChar = '0')
        private String codigoUsuario;
        @AttSpec(length = 291)
        private final String branco2 = "";
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
         * default: 1
         */
        @AttSpec(value = "1", cleanerType = CleanerType.NUMBER_ONLY)
        private int codigoRegistro;
        @AttSpec(length = 16)
        private final String branco = "";
        @AttSpec(length = 4, orientation = FillOrientation.LEFT, fillChar = '0')
        private String codigoAgencia;
        /**
         * default: 00
         */
        @AttSpec(length = 2, value = "00", cleanerType = CleanerType.NUMBER_ONLY)
        private final int zeros = 0;
        @AttSpec(length = 7, orientation = FillOrientation.LEFT, fillChar = '0')
        private String numeroConta;
        @AttSpec(orientation = FillOrientation.LEFT, fillChar = '0')
        private String digitoConta;
        @AttSpec(length = 2, orientation = FillOrientation.LEFT, fillChar = '0', cleanerType = CleanerType.NUMBER_ONLY, format = Format.DECIMAL_DD)
        private BigDecimal percentualMulta;
        @AttSpec(length = 4)
        private final String branco1 = "";
        @AttSpec(length = 25, orientation = FillOrientation.LEFT, fillChar = '0')
        private long numeroControle;
        @AttSpec(length = 7, orientation = FillOrientation.LEFT, fillChar = '0')
        private long nossoNumero;
        @AttSpec(orientation = FillOrientation.LEFT, fillChar = '0')
        private String digitoNossoNumero;
        @AttSpec(length = 10, orientation = FillOrientation.LEFT, fillChar = '0')
        private String numeroContrato;
        @AttSpec(length = 6, format = Format.DATE_DDMMYY)
        private LocalDate dataSegundoDesconto;
        @AttSpec(length = 13, orientation = FillOrientation.LEFT, fillChar = '0', format = Format.DECIMAL_DD, cleanerType = CleanerType.NUMBER_ONLY)
        private BigDecimal valorSegundoDesconto;
        @AttSpec(length = 8)
        private final String branco2 = "";
        @AttSpec(orientation = FillOrientation.LEFT, fillChar = '0')
        private String carteira;
        @AttSpec(length = 2, orientation = FillOrientation.LEFT, fillChar = '0')
        private String codigoDoServico;
        @AttSpec(length = 10, orientation = FillOrientation.LEFT, fillChar = '0')
        private long seuNumero;
        @AttSpec(length = 6, format = Format.DATE_DDMMYY)
        private LocalDate dataVencimento;
        @AttSpec(length = 13, orientation = FillOrientation.LEFT, fillChar = '0', format = Format.DECIMAL_DD, cleanerType = CleanerType.NUMBER_ONLY)
        private BigDecimal valorTitulo;
        @AttSpec(length = 3, orientation = FillOrientation.LEFT, fillChar = '0')
        private String codigoBanco;
        @AttSpec(length = 4, orientation = FillOrientation.LEFT, fillChar = '0')
        private String agenciaCobradora;
        @AttSpec()
        private final String branco3 = "";
        @AttSpec(length = 2, orientation = FillOrientation.LEFT, fillChar = '0')
        private String especieTitulo;
        @AttSpec()
        private String aceite;
        @AttSpec(length = 6, orientation = FillOrientation.LEFT, fillChar = '0', format = Format.DATE_DDMMYY)
        private LocalDate dataEmissaoTitulo;
        @AttSpec(length = 4, orientation = FillOrientation.LEFT, fillChar = '0')
        private String codigoInstrucao;
        @AttSpec(length = 13, orientation = FillOrientation.LEFT, fillChar = '0', format = Format.DECIMAL_DD, cleanerType = CleanerType.NUMBER_ONLY)
        private BigDecimal jurosDeUmDia;
        @AttSpec(length = 6, orientation = FillOrientation.LEFT, fillChar = '0', format = Format.DATE_DDMMYY)
        private LocalDate dataLimiteDesconto;
        @AttSpec(length = 13, orientation = FillOrientation.LEFT, fillChar = '0', format = Format.DECIMAL_DD, cleanerType = CleanerType.NUMBER_ONLY)
        private BigDecimal valorDesconto;
        @AttSpec(length = 13, orientation = FillOrientation.LEFT, fillChar = '0', format = Format.DECIMAL_DD, cleanerType = CleanerType.NUMBER_ONLY)
        private BigDecimal valorIoc;
        @AttSpec(length = 13, orientation = FillOrientation.LEFT, fillChar = '0', format = Format.DECIMAL_DD, cleanerType = CleanerType.NUMBER_ONLY)
        private BigDecimal valorAbatimento;
        @AttSpec(length = 2, orientation = FillOrientation.LEFT, fillChar = '0', cleanerType = CleanerType.NUMBER_ONLY)
        private int tipoInscricaoPagador;
        @AttSpec(length = 14, orientation = FillOrientation.LEFT, fillChar = '0', cleanerType = CleanerType.NUMBER_ONLY)
        private String numeroInscricaoPagador;
        @AttSpec(length = 40)
        private String nomePagador;
        @AttSpec(length = 40)
        private String enderecoPagador;
        @AttSpec(length = 12)
        private String complementoEndereco;
        @AttSpec(length = 8, orientation = FillOrientation.LEFT, fillChar = '0', cleanerType = CleanerType.NUMBER_ONLY)
        private String cepPagador;
        @AttSpec(length = 15)
        private String cidadePagador;
        @AttSpec(length = 2)
        private String ufPagador;
        @AttSpec(length = 40)
        private String mensagemCedente;
        @AttSpec(length = 2, orientation = FillOrientation.LEFT, fillChar = '0')
        private int prazoProtesto;
        @AttSpec()
        private String codigoMoeda;
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
         * default: 9
         */
        @AttSpec(value = "9")
        private String codigoDoRegistro;
        @AttSpec(length = 393)
        private final String branco = "";
        @AttSpec(length = 6, orientation = FillOrientation.LEFT, fillChar = '0', cleanerType = CleanerType.NUMBER_ONLY)
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
