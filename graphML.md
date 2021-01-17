graphML é uma linguagem para definição de grafos.

Sua especificação é apresentada em: http://graphml.graphdrawing.org. O formato de serialização é uma especificação sobre XML. [Possui XML Schema](http://graphml.graphdrawing.org/xmlns/1.1/graphml.xsd).

A especificação pode ser convertida em XML:RDF [usando ontmalizer](Ontmalizer.md) e [importada em Fuseki](AlgunsExemplosDeFuseki.md). É possível notar na especificação que não faz parte dela a codificação do formato de nós e arestas, nem a codificação das posições. Isto é resolvido através de extensões.

graphML é extensível, usando os tags &lt;data&gt; e &lt;default&gt;, ou criando novos elementos XML (simplificadamente, novos tags). Este último é o recurso usado por yEd. Infelizmente estas extensões não são padronizadas, o que resulta que cada desenvolvedor pode definir uma extensão ligeiramente diferente e, potencialmente, incompatível com as outras.

A linguagem é usada em ferramentas para construção de diagramas como [yEd](https://www.yworks.com/products/yed). Arquivos gerados pelo yEd contém os namespaces utilizados, o que poderia ser usado para entender as extensões definidas pelo fornecedor e facilitar a construção de conversores. A tentativa de acessar o namespace <https://www.yworks.com/xml/yfiles-common/markup/2.0> e sua raiz, <https://www.yworks.com/xml> [resultou em Page Not Found](Imagens/Captura%20de%20tela%20de%202021-01-17%2018-00-47.png).

Uma ferramenta, na minha opinião, útil, seria um conversor bidirecional de graphML para XML:RDF. Ela poderia permitir que grafos de conhecimento sejam visualizados e modificados graficamente. [Proposta aqui](bid-graphML-RDF.md).
