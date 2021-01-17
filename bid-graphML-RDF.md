Conversor bidirecional graphML para RDF.

## Introdução

São possíveis várias conversões que partem de graphML e geram XML:RDF.

### Exemplo

(é referenciado por UsandoXSLT.md)

[graphml2rdf](https://github.com/cui-ke/graphml2rdf) define e implementa uma transformação específica que usa o texto da aba de um container ER, implicitamente, como um rdfs:Class, o conteúdo do container como uma instância da classe, e o texto da aresta como uma propriedade (implicitamente, owl:dataProperty). É interessante pois as regras de transformação identificam os padrões contidos no graphML, o que é um trabalho, mas parece incompleto (não tem prefixo para owl).

![alt text](Imagens/Captura%20de%20tela%20de%202021-01-17%2014-45-04.png)

Acredito que a análise do `xsl` seja bastante instrutiva.

## Especificação  

Convém armazenar toda a informação em um único formato, para evitar questões de consistência de dados.

Os rótulos são importantes tanto no RDF quanto no graphML.

Algumas características do grafo, como identificação do arquivo, dos containers, como forma, cor, posição e tamanho, são importantes para a renderização.

## Abordagem


