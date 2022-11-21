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
public class LayoutCaixa implements Layout<LayoutCaixa.Header.HeaderBuilder, LayoutCaixa.Details.DetailsBuilder, LayoutCaixa.Trailer.TrailerBuilder> {
    private Header header;
    private List<Details> details;
    private Trailer trailer;

    public LayoutCaixa() {
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
        @AttSpec(orientation=FillOrientation.LEFT, fillChar='0', value="0")
        private Integer codigoRegistro;
        /**
         * Default: 1
         */
        @AttSpec(orientation=FillOrientation.LEFT, fillChar='0', value="1")
        private Integer codigoRemessa;
        /**
         * Default: REMESSA
         */
        @AttSpec(length=7, value="REMESSA")
        private String literalRemessa;
        /**
         * Default: 1
         */
        @AttSpec(length=2, orientation=FillOrientation.LEFT, fillChar='0', value="01")
        private Integer codigoServico;
        /**
         * Default: COBRANCA
         */
        @AttSpec(length=15, value="COBRANCA")
        private String literalServico;
        @AttSpec(length=4, orientation=FillOrientation.LEFT, fillChar='0')
        private Integer codigoAgencia;
        @AttSpec(length=6, orientation=FillOrientation.LEFT, fillChar='0')
        private Integer codigoBeneficiario;
        @AttSpec(length=10)
        private final String brancos = "";
        @AttSpec(length=30)
        private String nomeEmpresa;
        /**
         * Default: 104
         */
        @AttSpec(length=3, orientation=FillOrientation.LEFT, fillChar='0', value="104")
        private Integer codigoBanco;
        /**
         * Default: CAIXA
         */
        @AttSpec(length=15, value="CAIXA")
        private String nomeBanco;
        @AttSpec(length=6, orientation=FillOrientation.LEFT, fillChar='0', format=Format.DATE_DDMMYY, cleanerType=CleanerType.NUMBER_ONLY)
        private LocalDate dataGravacao;
        @AttSpec(length=289)
        private final String brancos2 = "";
        @AttSpec(length=5, orientation=FillOrientation.LEFT, fillChar='0')
        private Integer numeroRemessa;
        @AttSpec(length=6, orientation=FillOrientation.LEFT, fillChar='0')
        private Integer numeroSequencialRegistro;
    }

    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Details implements AttSpecProcessor {
        /**
         * Default: 1
         */
        @AttSpec(value="1", orientation=FillOrientation.LEFT, fillChar='0')
        private Integer codigoRegistro;
        @AttSpec(length=2, orientation=FillOrientation.LEFT, fillChar='0')
        private Integer tipoInscricaoEmpresa;
        @AttSpec(length=14, orientation=FillOrientation.LEFT, fillChar='0')
        private String numeroInscricaoEmpresa;
        @AttSpec(length=4, orientation=FillOrientation.LEFT, fillChar='0')
        private String codigoAgencia;
        @AttSpec(length=5, orientation=FillOrientation.LEFT, fillChar='0')
        private String codigoBeneficiario;
        @AttSpec(orientation=FillOrientation.LEFT, fillChar='0')
        private Integer idEmissao;
        @AttSpec(orientation=FillOrientation.LEFT, fillChar='0')
        private Integer idPostagem;
        @AttSpec(length=2)
        private String taxaPermanencia;
        @AttSpec(length=25)
        private String usoEmpresa;
        @AttSpec(length=2, orientation=FillOrientation.LEFT, fillChar='0')
        private Integer modalidadeIdentificacao;
        @AttSpec(length=15, orientation=FillOrientation.LEFT, fillChar='0')
        private Integer identificacaoTitulo;
        @AttSpec(length=2)
        private final String brancos = "";
        @AttSpec()
        private String usoLivre;
        @AttSpec(length=30)
        private String mensagem;
        /**
         * Default: 01
         */
        @AttSpec(length=2, value="01", orientation=FillOrientation.LEFT, fillChar='0')
        private String codigoCarteira;
        @AttSpec(length=2, orientation=FillOrientation.LEFT, fillChar='0')
        private int codigoOcorrencia;
        @AttSpec(length=10)
        private String seuNumero;
        @AttSpec(length=6, format=Format.DATE_DDMMYY, cleanerType=CleanerType.NUMBER_ONLY)
        private LocalDate dataVencimento;
        @AttSpec(length=13, format=Format.DECIMAL_DD, cleanerType=CleanerType.NUMBER_ONLY, orientation=FillOrientation.LEFT, fillChar='0')
        private BigDecimal valorTitulo;
        /**
         * Default: 104
         */
        @AttSpec(length=3, value="104")
        private String numeroBancoCobrador;
        @AttSpec(length=5, orientation=FillOrientation.LEFT, fillChar='0')
        private Integer agenciaCobradora;
        @AttSpec(length=2, orientation=FillOrientation.LEFT, fillChar='0')
        private Integer especieTitulo;
        @AttSpec()
        private String tipoAceite;
        @AttSpec(length=6, format=Format.DATE_DDMMYY, cleanerType=CleanerType.NUMBER_ONLY)
        private LocalDate dataEmissaoTitulo;
        @AttSpec(length=2, orientation=FillOrientation.LEFT, fillChar='0')
        private String primeiraInstrucaoCobranca;
        @AttSpec(length=2, orientation=FillOrientation.LEFT, fillChar='0')
        private Integer segundaInstrucaoCobranca;
        @AttSpec(length=13, orientation=FillOrientation.LEFT, fillChar='0', format = Format.DECIMAL_DD, cleanerType = CleanerType.NUMBER_ONLY)
        private BigDecimal valorMoraCobradoDiaAtraso;
        @AttSpec(length=6, format=Format.DATE_DDMMYY, cleanerType=CleanerType.NUMBER_ONLY)
        private LocalDate dataLimiteDesconto;
        @AttSpec(length=13, format=Format.DECIMAL_DD, cleanerType=CleanerType.NUMBER_ONLY, orientation=FillOrientation.LEFT, fillChar='0')
        private BigDecimal valorDesconto;
        @AttSpec(length=13, format=Format.DECIMAL_DD, cleanerType=CleanerType.NUMBER_ONLY, orientation=FillOrientation.LEFT, fillChar='0')
        private BigDecimal valorIof;
        @AttSpec(length=13, format=Format.DECIMAL_DD, cleanerType=CleanerType.NUMBER_ONLY, orientation=FillOrientation.LEFT, fillChar='0')
        private BigDecimal valorAbatimento;
        @AttSpec(length=2, orientation=FillOrientation.LEFT, fillChar='0')
        private Integer tipoInscricaoPagador;
        @AttSpec(length=14, orientation=FillOrientation.LEFT, fillChar='0')
        private String inscricaoPagador;
        @AttSpec(length=40)
        private String nomePagador;
        @AttSpec(length=40)
        private String enderecoPagador;
        @AttSpec(length=12)
        private String bairroPagador;
        @AttSpec(length=8, orientation=FillOrientation.LEFT, fillChar='0')
        private String cepPagador;
        @AttSpec(length=15)
        private String cidadePagador;
        @AttSpec(length=2)
        private String ufPagador;
        @AttSpec(length=6, format=Format.DATE_DDMMYY, cleanerType=CleanerType.NUMBER_ONLY)
        private LocalDate dataMulta;
        @AttSpec(length=10, orientation=FillOrientation.LEFT, fillChar='0')
        private Integer valorMulta;
        @AttSpec(length=22)
        private String nomeSacador;
        @AttSpec(length=2, orientation=FillOrientation.LEFT, fillChar='0')
        private Integer terceiraInstrucaoCobranca;
        @AttSpec(length=2, orientation=FillOrientation.LEFT, fillChar='0')
        private Integer prazo;
        /**
         * Default: 1
         */
        @AttSpec(value = "1")
        private String codigoMoeda;
        @AttSpec(length=6, orientation=FillOrientation.LEFT, fillChar='0')
        private Integer sequencialRegistro;
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
        @AttSpec("9")
        private String codigoDoRegistro;
        @AttSpec(length=393)
        private final String brancos = "";
        @AttSpec(length=6, orientation=FillOrientation.LEFT, fillChar='0')
        private Integer numeroSequencialRegistro;
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