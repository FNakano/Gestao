# Gerar Markdown a partir de comentários estilo Javadoc no código-fonte

## Motivação

Resolvi testar a ferramenta [Javadoc-to-Markdown](https://github.com/delight-im/Javadoc-to-Markdown) para gerar documentação em Markdown dos fragmentos de código que publico no gitHub. 

O critério de escolha é bem simples: ele gera a documentação no formato usado no gitHub, permite incluir tanto Markdown quanto HTML nos comentários, a documentação pode ser ampliada facilmente.

Neste arquivo vou manter um histórico de particularidades da ferramenta.

Para evitar que meus códigos-fonte fiquem *passeando pela internet*, decidi clonar o repositório da ferramenta. Olhei o código-fonte da ferramenta e parece que não envia informação para sites externos.

## Como usar

1. Clonar o repositório com `git clone <URL>`
2. Digitar na barra de endereços do navegador a URL do arquivo `index.html`. Algo como `file:///home/usuario/.../index.html`
3. Seguir as instruções da página.

O texto de documentação, que chamarei `doc`, pode ser copiado e colado para a documentação do código em Markdown e acrescida de imagens, links, diagramas e o que mais houver. Em geral, não convém misturar esses elementos com o código-fonte, para não dificultar sua leitura. Por outro lado, um link para a documentação pode ser muito conveniente.

Acrescentar manualmente informação a conteúdo gerado automaticamente implica que haverá (re-)trabalho caso o conteúdo seja gerado novamente. Atenção nisso. 

## Testes e resultados

### 2021-03-22-090423

```java 

/** 
* Classe de algo
*
*/
class Algo {
/**
* explicação
* @param name Nome do negócio
* @return URI do negócio
*/
@Test
public String func (String name) {
    return name;  /** linha x `func`  */
}
}
```

[Captura de Tela mostrando resultado](Imagens/Captura%20de%20tela%20de%202021-03-22%2009-03-08.png)

**Resultado**

### Documentation

#### `class Algo`

Classe de algo

#### `@Test public String func (String name)`

explicação

 * **Parameters:** `name` — Nome do negócio
 * **Returns:** URI do negócio

#### `} }`

linha x `func`



**Observações**

É necessário, para a ferramenta gerar o resultado esperado, deixar o sinal de comentário sozinho na primeira linha e ter o asterisco no começo da linha. Comentários com o formato de `doc` no meio do código também podem ter resultados inesperados.


## Referências adicionais

https://www.oracle.com/br/technical-resources/articles/java/javadoc-tool.html#examples

