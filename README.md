# Gestão de Informação

**estado do documento**: pode ser atualizado.

## Proposta

A proposta neste repositório é armazenar e disponibilizar o que o(s) autor(es) acham útil disponibilizar. Por exemplo, o que têm feito, que assuntos, ferramentas, publicações atraíram seu interesse, como, quando, por quê usaram. O acesso é aberto, para outros indivíduos poderem construir sobre a informação disponibilizada.

Importante notar que imprecisões são inevitáveis e que o conteúdo **pode** ser a opinião particular do autor.

Nas versões iniciais não há referências pois, embora tenha lido, não anotei a referência (eis a importância do fichamento...)

Preferencialmente usar referências científicas: O indicador aqui é que essas referências contém informação publicada e revisada por indivíduos comprometidos em estudar o assunto, acima de outros compromissos;

Sobre referências a objetos construídos por alguém, por exemplo, programas, a documentação do objeto também é referência preferencial.

Alguma referência é melhor que nenhuma referência.

## Avisos

Gostaria de avisar que pretendo usar este repositório para trocar idéias com colaboradores, compartilhar opiniões. Quem as ler pode não concordar, considerá-las delírios, encontrar falhas nos argumentos e nas premissas. Falhas, discordância, questionamento, ... fazem parte do processo de desenvolvimento de idéias.

> Alguém puxa um pelo, vem um gato pendurado...
> ... ouvi esta de um colega. Ficarei feliz em dizer quem é, se ele permitir...

*No momento, tendo a dizer que se vier um gato, a melhor ação é documentar o gato. Compartilhei uma decisão que tomei. O modelo e dados para tomada de decisão: Dá trabalho. Pode ter pouca ou muita utilidade. Isto estabelece um problema de decisão e, na minha opinião, é vinculado a um problema de otimização. Como utilidade listo: 1) pode ser usado em aulas; 2) pode ser usado em trabalhos futuros; 3) pode ser usado em argumentos; 4) pode servir como base para criar algo; 5) pode servir aos outros;...*

Uso muitas ferramentas criadas no domínio da web semântica. Há consenso (acredito que grande consenso) que a principal entidade que cria as normas e recomendações ligadas à infraestrutura desse domínio é a W3C. Por exemplo, HTML, XML, RDF, OWL, seguem normas e recomendações da entidade. W3Schools, ao que me consta, é uma ramificação da W3C que treina e certifica profissionais.

As normas e recomendações às vezes associam nomes iguais a construções ligeiramente diferentes, o que demanda atenção adicional de quem lê. Por exemplo:

No *Document Object Model* (DOM) de XML [apud W3Schools](https://www.w3schools.com/xml/dom_nodes.asp), *tudo num documento XML é um nó*. No modelo de dados RDF, um nó é uma 'figura' (termo meu) em um grafo e há três tipos de nós [Fonte: conceitos de RDF em W3C](https://www.w3.org/TR/2014/REC-rdf11-concepts-20140225/#data-model)

> According to the XML DOM, everything in an XML document is a node:
>    The entire document is a document node
>    Every XML element is an element node
>    The text in the XML elements are text nodes
>    Every attribute is an attribute node
>    Comments are comment nodes
[Fonte: W3Schools](https://www.w3schools.com/xml/dom_nodes.asp)

> The core structure of the abstract syntax is a set of triples, each consisting of a subject, a predicate and an object. A set of such triples is called an RDF graph. An RDF graph can be visualized as a node and directed-arc diagram, in which each triple is represented as a node-arc-node link.
> (...)
> There can be three kinds of nodes in an RDF graph: IRIs, literals, and blank nodes.
[Fonte: conceitos de RDF em W3C](https://www.w3.org/TR/2014/REC-rdf11-concepts-20140225/#data-model)

A demanda de atenção é maior quando os dois conceitos: XML e RDF são usados juntos, por exemplo quando [RDF é serializado (armazenado em um arquivo, ou transmitido) em XML](https://www.w3.org/TR/rdf-syntax-grammar/#section-Syntax). No documento, o cuidado em especificar qual conceito é usado é notável, mas, sempre há chance de alguma parte do texto, ou de outros textos, não serem escritos com tanto cuidado.

Talvez, prefixar os domínios, como feito em XML e em RDF, diminua a confusão. Palavras como `xml:nó` e `rdf:nó` seriam usadas.

## Conteúdo

[]()

[Considerações sobre a escolha do nome do repositório](EscolhaDoNome.md)

[Gerar Markdown a partir de comentários estilo Javadoc no código-fonte](JavadocToMarkdown.md)

[Como pretendo usar web semântica](UsoDeWebSemantica.md)

[Fornecer Informação sobre o ambiente de desenvolvimento/execução](contexto.md)

[Conceitos mínimos de XML para avançar para os tópicos XML:RDF, SPARQL, XSLT contidos neste repositório](XMLRapido.md)

[Biblioteca Java para ler XML](LerXMLcomJava/README.md). Caso precise de um XML específico, como XML:RDF, talvez seja melhor buscar uma biblioteca mais específica.

[Maven, teste, leitor de CSV](sobreMaven.md)

[Comentários sobre XML:RDF](XML-RDF.md)

[Avaliar Jena como ferramenta para implementar ferramentas de gestão de informação](AvaliaJena.md)

[Como instalar Jena](InstalaJena.md)

[Execução dos programas nos tutoriais Jena](ExecucaoTutoriaisJena.md)

[Ler Turtle para um Modelo em Jena e escrever em XML:RDF](LerTTLEmUmModel/README.md) - Também pode ser uma sugestão para documentação (memória) de desenvolvimento de código.

[Explorar o Modelo lido e criar uma tripla baseado na exploração](ExplorarOTTLLido/README.md).

[Escrever, compilar, implantar um servlet em linha de comando, sem IDE instalado](ServletSimples/README.md)

[O que é Fuseki](https://jena.apache.org/documentation/fuseki2/)

[Como Instalar Fuseki](https://github.com/santanajods/domotic-swot#linux)

[Alguns exemplos de uso de Fuseki feitos pelos autores](AlgunsExemplosDeUsoDeFuseki.md): Base para aplicar os tutoriais de Jena usando um servidor Fuseki.

[App para consultar servidor Fuseki](AppParaConsultarFuseki.md)

[Onde/Como os dados gerados pelos sensores podem ser armazenados em SSN/SOSA](SSNeSOSA-Dados.md)

[Carregar SSN e SOSA no Fuseki](CarregarSSNeSOSA.md)

[SPARQL, entailment, HTTP,...](UsandoSPARQL.md) - inicial

[Usando Wikidata](UsandoWikidata.md) - inicial

[Usando XSLT](UsandoXSLT.md) - inicial

[sobre graphML](graphML.md) - inicial - informativo

[Ontmalizer - Conversão de XML Schema para RDF:XML](Ontmalizer.md)

[Raciocinadores e seu uso como validadores](Raciocinadores1.md)

[conversor bidirecional graphML - RDF](bid-graphml-RDF.md) - inicial - proposta de projeto

[Exemplos de uso de Fuseki - precedem 'os mesmos tutoriais com Fuseki'](AlgunsExemplosDeUsoDeFuseki.md)

[Os mesmos tutoriais com Fuseki](FusekiTutoriais.md) - inicial

[Explorando Heroku](heroku.md)

[Automatizando o uso de consultas SPARQL usando shell scripts em Linux](sparql/README.md)

