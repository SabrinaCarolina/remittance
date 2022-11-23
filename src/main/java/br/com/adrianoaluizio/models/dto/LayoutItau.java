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
public class LayoutItau implements Layout<LayoutItau.Header.HeaderBuilder, LayoutItau.Details.DetailsBuilder, LayoutItau.Trailer.TrailerBuilder> {
    private Header header;
    private List<Details> details;
    private Trailer trailer;

    public LayoutItau() {
        this.details = new ArrayList<>();
    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Header implements AttSpecProcessor {
        @AttSpec(orientation = FillOrientation.LEFT, fillChar = '0', cleanerType = CleanerType.NUMBER_ONLY)
        private int identificacaoRegistro;
        @AttSpec(orientation = FillOrientation.LEFT, fillChar = '0', cleanerType = CleanerType.NUMBER_ONLY)
        private int tipoOperacao;
        @AttSpec(length = 7)
        private String identificacaoExtensoMovimento;
        @AttSpec(length = 2, orientation = FillOrientation.LEFT, fillChar = '0')
        private String identificacaoTipoServico;
        @AttSpec(length = 15)
        private String identificacaoExtensoTipoServico;
        @AttSpec(length = 4, orientation = FillOrientation.LEFT, fillChar = '0')
        private String agencia;
        @AttSpec(length = 2, orientation = FillOrientation.LEFT, fillChar = '0')
        private String complemento;
        @AttSpec(length = 5, orientation = FillOrientation.LEFT, fillChar = '0')
        private String conta;
        @AttSpec(orientation = FillOrientation.LEFT, fillChar = '0')
        private String dac;
        @AttSpec(length = 8)
        private final String complemento1 = "";
        @AttSpec(length = 30)
        private String nomeEmpresa;
        @AttSpec(length = 3)
        private String codigoBanco;
        @AttSpec(length = 15)
        private String nomeBanco;
        @AttSpec(length = 6, orientation = FillOrientation.LEFT, fillChar = '0', format = Format.DATE_DDMMYY, cleanerType = CleanerType.NUMBER_ONLY)
        private LocalDate dataGeracao;
        @AttSpec(length = 294)
        private final String complemento2 = "";
        @AttSpec(length = 6, orientation = FillOrientation.LEFT, fillChar = '0')
        private int sequencialRemessa;
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
        private int identificacaoRegistro;
        @AttSpec(length = 2, orientation = FillOrientation.LEFT, fillChar = '0')
        private int tipoInscricaoCedente;
        @AttSpec(length = 14, orientation = FillOrientation.LEFT, fillChar = '0', cleanerType = CleanerType.NUMBER_ONLY)
        private String numeroInscricao;
        @AttSpec(length = 4, orientation = FillOrientation.LEFT, fillChar = '0')
        private String prefixoAgencia;
        @AttSpec(length = 2, orientation = FillOrientation.LEFT, fillChar = '0')
        private final String complemento = "";
        @AttSpec(length = 5, orientation = FillOrientation.LEFT, fillChar = '0')
        private String numeroContaCorrente;
        @AttSpec()
        private String digitoConta;
        @AttSpec(length = 4)
        private final String complemento1 = "";
        @AttSpec(length = 4, orientation = FillOrientation.LEFT, fillChar = '0')
        private String codInstrucaoAlegacao;
        @AttSpec(length = 25, orientation = FillOrientation.LEFT, fillChar = '0')
        private long identificacaoTitulo;
        @AttSpec(length = 8, orientation = FillOrientation.LEFT, fillChar = '0')
        private long nossoNumero;
        @AttSpec(length = 13, orientation = FillOrientation.LEFT, fillChar = '0', format = Format.DECIMAL_DD, cleanerType = CleanerType.NUMBER_ONLY)
        private BigDecimal qtdMoeda;
        @AttSpec(length = 3, orientation = FillOrientation.LEFT, fillChar = '0')
        private String numCarteiraBanco;
        @AttSpec(length = 21)
        private String usoDoBanco;
        @AttSpec()
        private String carteira;
        @AttSpec(length = 2, orientation = FillOrientation.LEFT, fillChar = '0')
        private int ocorrencia;
        @AttSpec(length = 10, orientation = FillOrientation.LEFT, fillChar = '0')
        private long numeroDoc;
        @AttSpec(length = 6, orientation = FillOrientation.LEFT, fillChar = '0', format = Format.DATE_DDMMYY, cleanerType = CleanerType.NUMBER_ONLY)
        private LocalDate dataVencimento;
        @AttSpec(length = 13, orientation = FillOrientation.LEFT, fillChar = '0', format = Format.DECIMAL_DD, cleanerType = CleanerType.NUMBER_ONLY)
        private BigDecimal valorTitulo;
        @AttSpec(length = 3, orientation = FillOrientation.LEFT, fillChar = '0')
        private String numeroBanco;
        @AttSpec(length = 5, orientation = FillOrientation.LEFT, fillChar = '0')
        private String agenciaCobradora;
        @AttSpec(length = 2)
        private String especieTitulo;
        @AttSpec()
        private String aceiteTitulo;
        @AttSpec(length = 6, orientation = FillOrientation.LEFT, fillChar = '0', format = Format.DATE_DDMMYY, cleanerType = CleanerType.NUMBER_ONLY)
        private LocalDate dataEmissaoTitulo;
        @AttSpec(length = 2)
        private String instrucao1;
        @AttSpec(length = 2)
        private String instrucao2;
        @AttSpec(length = 13, orientation = FillOrientation.LEFT, fillChar = '0', format = Format.DECIMAL_DD, cleanerType = CleanerType.NUMBER_ONLY)
        private BigDecimal jurosUmDia;
        @AttSpec(length = 6, orientation = FillOrientation.LEFT, fillChar = '0', format = Format.DATE_DDMMYY, cleanerType = CleanerType.NUMBER_ONLY)
        private LocalDate dataLimiteDesconto;
        @AttSpec(length = 13, orientation = FillOrientation.LEFT, fillChar = '0', format = Format.DECIMAL_DD, cleanerType = CleanerType.NUMBER_ONLY)
        private BigDecimal valorDesconto;
        @AttSpec(length = 13, orientation = FillOrientation.LEFT, fillChar = '0', format = Format.DECIMAL_DD, cleanerType = CleanerType.NUMBER_ONLY)
        private BigDecimal valorIof;
        @AttSpec(length = 13, orientation = FillOrientation.LEFT, fillChar = '0', format = Format.DECIMAL_DD, cleanerType = CleanerType.NUMBER_ONLY)
        private BigDecimal valorAbatimento;
        @AttSpec(length = 2, orientation = FillOrientation.LEFT, fillChar = '0')
        private int tipoInscricaoSacado;
        @AttSpec(length = 14, orientation = FillOrientation.LEFT, fillChar = '0', cleanerType = CleanerType.NUMBER_ONLY)
        private String cpfSacado;
        @AttSpec(length = 30)
        private String nomeSacado;
        @AttSpec(length = 10)
        private final String complemento2 = "";
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
        @AttSpec(length = 30)
        private String sacadoravalista;
        @AttSpec(length = 4)
        private String complementoRegistro;
        @AttSpec(length = 6, orientation = FillOrientation.LEFT, fillChar = '0', format = Format.DATE_DDMMYY, cleanerType = CleanerType.NUMBER_ONLY)
        private LocalDate dataMora;
        @AttSpec(length = 2, orientation = FillOrientation.LEFT, fillChar = '0')
        private int diasMora;
        @AttSpec()
        private final String complementoRegistro1 = "";
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
        private final String filler = "";
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
