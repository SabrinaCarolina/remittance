# Gerador de Arquivos de Remessa

Este projeto tem como inspiração o [JRimum Bopepo](https://github.com/jrimum/bopepo), mas nessa versao foi implementada
apenas a geração de remessa.

## Bancos Suportados:

- Banco do Brasil
- Santander
- Itau
- Bancoob
- Banco Nordeste
- Caixa
- Bradesco

### Biblioteca externa utilizada

- [supple-date](https://github.com/dlduarte/supple-date)


## Exemplo

#### Inicializar o Layout

```
LayoutBB bb = new LayoutBB();
```

#### Definir Header
```
bb.addHeader(header -> header.identificacaoRegistro(1)
        .tipoOperacao(2)
        .identificacaoExtensoTipoOperacao("value")
        .identificacaoTipoServico(1)
        .identificacaoExtensoTipoServico("value")
        .prefixoAgencia("value")
        .digitoVerificadorAgencia("value")
        .numeroContaCorrente("value")
        .digitoConta("value")
        .nomeCedente("value")
        .dataGravacao(LocalDate.now())
        .sequencialRemessa(1)
        .numeroConvenioLider("value")
        .sequencialRegistro(1)
);
```

#### Definir Details
```
bb.addDetails(detail -> detail.identificacaoRegistro(7)
        .tipoInscricaoCedente(1)
        .numeroCPFCliente("value")
        .prefixoAgencia("value")
        .digitoVerificadorAgencia("value")
        .numeroContaCorrente("value")
        .digitoConta("value")
        .NumeroConvenioCliente("value")
        .codigoControleEmpresa("value")
        .nossoNumero("value")
        .numeroPrestacao("value")
        .grupoValor("value")
        .indicativoMensagemSacadorAvalista("value")
        .prefixoTitulo("value")
        .variacaoCarteira("value")
        .contaCaucao("value")
        .numeroBordero("value")
        .tipoCobranca("value")
        .carteiraCobranca("value")
        .comando("value")
        .numeroTitulo("value")
        .dataVencimento(LocalDate.now())
        .valorTitulo(BigDecimal.ZERO)
        .numeroBanco("value")
        .prefixoAgenciaCobradora("value")
        .digitoVerificadorAgenciaCobradora("value")
        .especieTitulo("value")
        .aceiteTitulo("value")
        .dataEmissaoTitulo(LocalDate.now())
        .instrucaoCodificada1("value")
        .instrucaoCodificada2("value")
        .jurosMora(BigDecimal.ONE)
        .dataLimiteDesconto(LocalDate.now())
        .valorDesconto(BigDecimal.ZERO)
        .valorIof(BigDecimal.ONE)
        .valorAbatimento(BigDecimal.TEN)
        .tipoInscricaoSacado("value")
        .cpfSacado("value")
        .nomeSacado("value")
        .complemento("value")
        .enderecoSacado("value")
        .bairroSacado("value")
        .cepSacado("value")
        .cidadeSacado("value")
        .ufCidadeSacado("value")
        .observacaoSacador("value")
        .numeroDiasProtesto("value")
        .complementoRegistro("value")
        .sequencialRegistro("value")
);
```
###### *Os detalhes são adcionados a uma lista.*

#### Definir o Trailer

```
bb.addTrailer(trailer ->
    trailer.codigoDoRegistro("value").numeroSequencialRegistro("value")
);
```
___

#### Observações
- Os campos que forem definidos com "" ou não informados, serão preenchidos com os valores default da biblioteca;
- Campos estão passando por tratamentos de limpeza de dados(Remoção de caracteres epeciais, e Arredondamento de casas decimais e remoção de pontuação)
- Valores informados que ultrapassem o lenght do objeto serão cortados
