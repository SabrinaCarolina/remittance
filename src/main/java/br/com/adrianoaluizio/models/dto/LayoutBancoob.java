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
public class LayoutBancoob implements Layout<LayoutBancoob.Header.HeaderBuilder, LayoutBancoob.Details.DetailsBuilder, LayoutBancoob.Trailer.TrailerBuilder> {
    private Header header;
    private List<Details> details;
    private Trailer trailer;

    public LayoutBancoob() {
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
        @AttSpec(value = "0", orientation = FillOrientation.LEFT, fillChar = '0')
        private int codigoDoRegistro;
        /**
         * default: 1
         */
        @AttSpec(value = "1", orientation = FillOrientation.LEFT, fillChar = '0')
        private int identificacaoRemessa;
        /**
         * default: REMESSA
         */
        @AttSpec(length = 7, value = "REMESSA")
        private String literalRemessa;
        /**
         * default: 01
         */
        @AttSpec(length = 2, value = "01", orientation = FillOrientation.LEFT, fillChar = '0')
        private int codigoServico;
        /**
         * default: COBRANCA
         */
        @AttSpec(value = "COBRANCA", length = 8)
        private String literalServico;
        @AttSpec(length = 7)
        private final String brancos = "";
        @AttSpec(length = 4, orientation = FillOrientation.LEFT, fillChar = '0')
        private String prefixoCooperativa;
        @AttSpec(cleanerType = CleanerType.NUMBER_ONLY)
        private int digitoVerificadorPrefixo;
        @AttSpec(length = 8, orientation = FillOrientation.LEFT, fillChar = '0')
        private String codigoCliente;
        @AttSpec()
        private String digitoVerificadorCodigo;
        @AttSpec(length = 6)
        private final String brancos1 = "";
        @AttSpec(length = 30)
        private String nomeEmpresa;
        /**
         * default: 756BANCOOBCED
         */
        @AttSpec(length = 18, value = "756BANCOOBCED")
        private String identificacaoBanco;
        @AttSpec(length = 6, orientation = FillOrientation.LEFT, fillChar = '0', format = Format.DATE_DDMMYY)
        private LocalDate dataGravacao;
        @AttSpec(length = 7, orientation = FillOrientation.LEFT, fillChar = '0')
        private String numeroSequencialRemessa;
        @AttSpec(length = 287)
        private final String brancos2 = "";
        @AttSpec(length = 6, orientation = FillOrientation.LEFT, fillChar = '0')
        private int numeroSequencialRegistro;
    }

    @Getter
    @Setter
    @Builder()
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Details implements AttSpecProcessor {
        /**
         * default: 1
         */
        @AttSpec(value = "1", orientation = FillOrientation.LEFT, fillChar = '0')
        private int codigoRegistro;
        @AttSpec(length = 2, orientation = FillOrientation.LEFT, fillChar = '0', cleanerType = CleanerType.NUMBER_ONLY)
        private int tipoInscricao;
        @AttSpec(length = 14, orientation = FillOrientation.LEFT, fillChar = '0')
        private String numeroBeneficiario;
        @AttSpec(length = 4, orientation = FillOrientation.LEFT, fillChar = '0')
        private String prefixoCooperativa;
        @AttSpec(orientation = FillOrientation.LEFT, fillChar = '0')
        private String digitoVefificador;
        @AttSpec(length = 8, orientation = FillOrientation.LEFT, fillChar = '0')
        private String contaCorrente;
        @AttSpec()
        private String digitoConta;
        @AttSpec(length = 6, orientation = FillOrientation.LEFT, fillChar = '0', cleanerType = CleanerType.NUMBER_ONLY)
        private long numeroBanco;
        @AttSpec(length = 25)
        private String campoLivre;
        @AttSpec(length = 12, orientation = FillOrientation.LEFT, fillChar = '0')
        private long nossoNumero;
        @AttSpec(length = 2, orientation = FillOrientation.LEFT, fillChar = '0')
        private String numeroParcela;
        @AttSpec(length = 2, value = "00", orientation = FillOrientation.LEFT, fillChar = '0')
        private String grupoValor;
        @AttSpec(length = 3)
        private final String brancos = "";
        @AttSpec()
        private String indicativoMensagem;
        @AttSpec(length = 3)
        private final String brancos1 = "";
        @AttSpec(length = 3, value = "000", orientation = FillOrientation.LEFT, fillChar = '0')
        private String variacaoCarteira;
        @AttSpec(orientation = FillOrientation.LEFT, fillChar = '0', cleanerType = CleanerType.NUMBER_ONLY)
        private int contaCaucao;
        @AttSpec(length = 5, orientation = FillOrientation.LEFT, fillChar = '0', cleanerType = CleanerType.NUMBER_ONLY)
        private int numeroContrato;
        @AttSpec()
        private int dvContrato;
        @AttSpec(length = 6, orientation = FillOrientation.LEFT, fillChar = '0', cleanerType = CleanerType.NUMBER_ONLY)
        private int numeroBordero;
        @AttSpec(length = 5)
        private final String brancos2 = "";
        @AttSpec(orientation = FillOrientation.LEFT, fillChar = '0')
        private String tipoEmissao;
        @AttSpec(length = 2, orientation = FillOrientation.LEFT, fillChar = '0')
        private String carteiraModalidade;
        @AttSpec(length = 2, orientation = FillOrientation.LEFT, fillChar = '0')
        private String comandoMovimento;
        @AttSpec(length = 10)
        private String seuNumero;
        @AttSpec(length = 6, format = Format.DATE_DDMMYY, cleanerType = CleanerType.NUMBER_ONLY)
        private LocalDate vencimento;
        @AttSpec(length = 13, orientation = FillOrientation.LEFT, fillChar = '0', cleanerType = CleanerType.NUMBER_ONLY, format = Format.DECIMAL_DD)
        private BigDecimal valorTitulo;
        @AttSpec(length = 3, value = "756", orientation = FillOrientation.LEFT, fillChar = '0')
        private String codigoBanco;
        @AttSpec(length = 4, orientation = FillOrientation.LEFT, fillChar = '0', reference = "prefixoCooperativa")
        private final String prefixoCooperativa1 = "";
        @AttSpec()
        private String digitoVerificador;
        @AttSpec(length = 2, orientation = FillOrientation.LEFT, fillChar = '0')
        private String especieTitulo;
        @AttSpec()
        private String aceite;
        @AttSpec(length = 6, format = Format.DATE_DDMMYY)
        private LocalDate dataEmissao;
        @AttSpec(length = 2, orientation = FillOrientation.LEFT, fillChar = '0')
        private String primeiraInstrucao;
        @AttSpec(length = 2, orientation = FillOrientation.LEFT, fillChar = '0')
        private String segundaInstrucao;
        @AttSpec(length = 6, orientation = FillOrientation.LEFT, fillChar = '0', cleanerType = CleanerType.NUMBER_ONLY, format = Format.DECIMAL_DD)
        private BigDecimal taxaMora;
        @AttSpec(length = 6, orientation = FillOrientation.LEFT, fillChar = '0', cleanerType = CleanerType.NUMBER_ONLY, format = Format.DECIMAL_DD)
        private BigDecimal taxaMulta;
        @AttSpec(orientation = FillOrientation.LEFT, fillChar = '0')
        private String tipoDistribuicao;
        @AttSpec(length = 6, orientation = FillOrientation.LEFT, fillChar = '0', format = Format.DATE_DDMMYY, cleanerType = CleanerType.NUMBER_ONLY)
        private LocalDate dataDesconto;
        @AttSpec(length = 13, orientation = FillOrientation.LEFT, fillChar = '0', format = Format.DECIMAL_DD, cleanerType = CleanerType.NUMBER_ONLY)
        private BigDecimal valorDesconto;
        @AttSpec(length = 13, orientation = FillOrientation.LEFT, fillChar = '0')
        private String codigoMoeda;
        @AttSpec(length = 13, orientation = FillOrientation.LEFT, fillChar = '0', format = Format.DECIMAL_DD, cleanerType = CleanerType.NUMBER_ONLY)
        private BigDecimal valorAbatimento;
        @AttSpec(orientation = FillOrientation.LEFT, fillChar = '0')
        private int tipoInscricao1;
        @AttSpec(length = 14, orientation = FillOrientation.LEFT, fillChar = '0', cleanerType = CleanerType.NUMBER_ONLY)
        private String documentoPagador;
        @AttSpec(length = 40)
        private String nomePagador;
        @AttSpec(length = 37)
        private String enderecoPagador;
        @AttSpec(length = 15)
        private String bairroPagador;
        @AttSpec(length = 8, orientation = FillOrientation.LEFT, fillChar = '0', cleanerType = CleanerType.NUMBER_ONLY)
        private String cepPagador;
        @AttSpec(length = 15)
        private String cidadePagador;
        @AttSpec(length = 2)
        private String ufPagador;
        @AttSpec(length = 40)
        private String observacoes;
        @AttSpec(length = 2)
        private int numDiasProtesto;
        @AttSpec()
        private final String brancos3 = "";
        @AttSpec(length = 6, orientation = FillOrientation.LEFT, fillChar = '0')
        private int numeroSequencialRegistro;
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
