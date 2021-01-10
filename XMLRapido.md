# XML Rápido

**estado do documento**: pode ser atualizado.

# Exemplo

``` xml
<?xml version="1.0" encoding="UTF-8"?>
<note>
   <to>Tove</to>
   <from>Jani</from>
   <heading>Reminder</heading>
   <body>Don't forget me this weekend!</body>
</note>
```

Conceitos:

O formato XML (eXtensible Markup Language) foi concebido para ser flexível, consequentemente define poucas estruturas, e **poder** representar qualquer coisa.

XSLT, XML:RDF também são formatos, especificações (no sentido OOP da palavra, antônimo: generalizações) de XML. Seria possível falar em formatos derivados de XML (emprestando *derived class*, expressão criada no contexto de C++).

Um particular arquivo `.xml` contém a representação de algo em XML. Caso seja um arquivo `.xsl` contém a representação de uma transformação. Caso seja um arquivo `.rdf`, contém a representação de um grafo de conhecimento. Lembrando que a associação entre conteúdo do arquivo e a extensão em seu nome pode ser diferente em diferentes sistemas operacionais.

Uma consequência desse contexto é: `afirmar que um arquivo está no formato XML pode não ser informação suficiente para algum contexto específico`.

[tag]() `<note>`

Tag, sintaticamente, é um par de *angle brackets* (bracket de abertura e bracket de fechamento, respectivamente) e tudo o que está entre os *brackets*. O que está entre os *brackets*, chamo 'conteúdo' do tag. O tag é usado como marcador. O conteúdo tem ao menos uma letra. Chamo a primeira palavra do conteúdo do tag de nome do tag (uso: `In XML, element names are defined by the...` em https://www.w3schools.com/xml/xml_namespaces.asp).  Não encontrei referência definindo, então preciso dizer que estas definições são minhas...

É útil acrescentar uma indireção: nomes são identificadores. Identificador começa com uma letra, seguida de zero ou mais letras ou números ou símbolos (mas nem todos). É sensível a caixa.

Geralmente tags são pareados, contexto em que passam a existir *tag inicial* e *tag final* (*closing tag*, termo usado [aqui](https://www.w3schools.com/xml/xml_syntax.asp) no tutorial de XML da W3Schools). O tag inicial contém pelo menos uma sequência de caracteres: o identificador. O conteúdo do tag final inicia com uma barra `/`, seguida, sem brancos, pelo identificador do tag inicial.

Existem tags de abertura que declaram seu fechamento. O termo usado é *self-closing* tag, usado [aqui](https://www.w3schools.com/xml/xml_elements.asp). Eles prefixam o *bracket* de fechamento com uma barra.

Em XML, os tags correspondentes precisam estar todos presentes e devidamente aninhados.
 
[prolog](https://www.w3schools.com/xml/xml_syntax.asp) (prólogo) `<?xml version="1.0" encoding="UTF-8"?>`

O prólogo é opcional, se presente deve estar na primeira linha do arquivo, e informa a versão do XML e a codificação de caracteres. A codificação padrão é UTF-8. Por definição, o prólogo não faz parte do documento, portanto não precisa ter tag final.[Ref.](https://www.w3schools.com/xml/xml_syntax.asp)

[element](https://www.w3schools.com/xml/xml_elements.asp) `<to>Tove</to>`

Elemento é tudo que vai do tag inicial ao tag final, incluindo os tags.

O elemento contém o que está entre o tag inicial e o tag final. O conteúdo pode ser:

- vazio
- texto (referenciado logo em seguida como *text content*)
- atributos
- outros elementos (referenciado logo em seguida como *element content*)
- uma mistura dos acima

Baseado em https://www.w3schools.com/xml/xml_elements.asp. Acrescentei vazio pois um elemento pode estar vazio, segundo a mesma referência base.

Evitar `.`, `-` e `:` em identificadores de elementos. Em especial, `:` é caracter reservado em XML. Caracteres acentuados são permitidos pela norma mas podem não ter suporte nas aplicações. Na referência há uma seção sobre práticas para escolha de identificadores de elementos.

[attribute](https://www.w3schools.com/xml/xml_attributes.asp) Em `<person gender="female">`, gender é o identificador do atributo.

Atributo se aproxima de uma variável em linguagens procedurais como Java. São colocados no tag inicial e têm sintaxe `identificador_do_atributo=valor`. Valor sempre entre quotes; quotes sempre pareados. O caso de quotes aninhados é resolvido com *entity references*, na [seção sobre sintaxe](https://www.w3schools.com/xml/xml_syntax.asp).

A funcionalidade de elemento contém a funcionalidade de atributos, de forma que atributos não são essenciais em XML. Na referência há considerações sobre usar ou não atributos.

[namespaces](https://www.w3schools.com/xml/xml_namespaces.asp)

Traduzido da referência: namespaces provêem um método para evitar conflitos de nomes.

Namespaces podem ser declarados como atributos em qualquer tag inicial e valem para o conteúdo do tag (até onde vi). 

O sinal `:` é um operador sobre dois operandos, ou seja, a sintaxe é `A:B`, onde A é um domínio (aqui pode ser entendido como um conjunto) e B é um elemento do domínio. Se esta construção está do lado esquerdo do sinal `=` (atribuição), então `A:B` é um atributo e seu valor é definido pela atribuição.
 
O identificador `xmlns` é reservado e é um atributo. Seu valor padrão é um IRI, que indica/identifica o domínio de XML. `xmlns:h="http://www.w3.org/TR/html4/"` define no domínio `XML` o atributo `h`, que não corresponde a um atributo pré-existente, logo ele é criado, e lhe atribui um valor. Este valor é uma IRI que, em particular, indica o domínio de HTML4. Desta forma, o fragmento abaixo corresponde a uma tabela em HTML(4). Note-se que:

1. é possível usar somente o segundo operando de `:` para indicar o domínio (de HTML4);
2. o atributo pode ser usado no tag, antes de sua definição.

```
<h:table xmlns:h="http://www.w3.org/TR/html4/">
  <h:tr>
    <h:td>Apples</h:td>
    <h:td>Bananas</h:td>
  </h:tr>
</h:table>
```

Desta forma, é possível definir vários domínios, qualificar (prefixar) os identificadores como pertencentes a diferentes domínios e resolver conflitos de nomes. 

[comment](https://www.w3schools.com/xml/xml_syntax.asp)

```
<!-- comentário -->
```

[node](https://www.w3schools.com/xml/dom_nodes.asp)

> According to the XML DOM, everything in an XML document is a node:
>    The entire document is a document node
>    Every XML element is an element node
>    The text in the XML elements are text nodes
>    Every attribute is an attribute node
>    Comments are comment nodes

Um documento XML pode ser visto como uma árvore (*node tree*) e sempre contém um (único) nó raiz (*root node*). A terminologia filho, pai, ... é herdada da teoria de grafos.

## sobre a continuidade da leitura a partir deste documento

A referência contém muitos usos de XML, com exemplos. Meu interesse imediato relacionado a XML é . A sequência da exploração está [aqui](UsandoXSLT.md).

## Referências

[XML em W3Schools](https://www.w3schools.com/xml/default.asp)

[XSLT em W3Schools](https://www.w3schools.com/xml/xsl_intro.asp)

[RDF em W3Schools](https://www.w3schools.com/xml/xml_rdf.asp)

[Especificação de XML em W3C](https://www.w3.org/TR/xml/)

[Especificação de XSLT em W3C](https://www.w3.org/TR/xslt/)

[Especificação de RDF em W3C](https://www.w3.org/TR/rdf11-primer/)

