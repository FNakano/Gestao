**estado do documento**: incompleto.

> Um colaborador indicou XML Transformations (XSLT) há uns anos. Só agora concluí que é útil explorar mais o assunto.

## Introdução

É uma ferramenta que permite aplicar transformações sobre XML. As transformações são codificadas num 'dialeto' específico de XML, com IRI `http://www.w3.org/1999/XSL/Transform`. Já vi referenciado como XSL e como XSLT. Usualmente a extensão do arquivo é `.xsl`. A ferramenta é denominada, genericamente, *XSLT Processor*. Navegadores tem a ferramenta embutida. Existem ferramentas *standalone* como Saxon,que tem [versão gratuita](https://sourceforge.net/projects/saxon/files/).

Em uma abordagem superficial, XSLT é uma transformação sobre XML, semelhante a CSS,que é uma transformação sobre HTML.

As transformações possíveis com XSLT incluem troca de tags XML, inclusão, exclusão de conteúdo e formato. É mais poderosa que CSS, há quem afirme que a XSLT é Turing-Completa. [Fonte Wikipedia](https://en.wikipedia.org/wiki/XSLT). 

**nota**: Não procurei em referências científico-acadêmicas a definição de Turing-Completo, nem a demonstração que XSLT é Turing-Completa.

Um ['curso' sobre XSLT está disponível em W3CSchools](https://www.w3schools.com/xml/xsl_intro.asp).

Existem alguns projetos que empregam XSLT para converter XML Schema para XML:RDF :

- https://github.com/srdc/ontmalizer
- https://rhizomik.net/redefer/xsd2owl
- https://github.com/istavrak/XS2OWL

O uso nessa transformação foi objeto de análise por um grupo da W3C. [Wiki da W3C](https://www.w3.org/community/rax/wiki/XML_to_RDF_Transformation_processes_using_XSLT)

Tenho interesse particular em transformar um formato de codificação de grafos, como graphML ou GML para RDF e vice-versa. Estou inclinado a usar GML (mais precisamente, XGML) pois o graphML gerado pelo yEd é bem complicado, enquanto o XGML parece menos complicado.

` <xsl:apply-templates/>` aplica os templates no nó corrente e nos filhos, mas não aplica recursivamente.

Quando dentro de um template com um match="coisa" tem um apply-templates com um select="coisa", resulta recursividade. "coisa" é [XPATH](https://www.w3schools.com/xml/xpath_intro.asp)


XPATH introduz novos tipos de nós, além dos definidos em XML: 

- namespace, 
- [processing-instruction](https://www.w3schools.com/xml/xsl_elementref.asp)

[Ref](https://www.w3schools.com/xml/xpath_nodes.asp)

Os tipos de nós definidos em XML são:

- document node
- element node
- text nodes
- attribute node
- comment nodes

[node](https://www.w3schools.com/xml/dom_nodes.asp)
[XML Rápido](XMLRapido.md)

Nós sem pais nem filhos só podem ser valores e são designados valores atômicos (*atomic values*)

valores atômicos ou nós são ítens (*items*).

As relações entre nós é explicada com detalhes em Ref.

Ok, entendi. XPATH é inspirado em sistemas de arquivos.

Agora consegui, em duas tentativas, formular a string de busca do google que retorna o que estou buscando: 

1. `get path in xpath` Esta retornou uma resposta em javascript, por isso na segunda incluí `xslt`
2. `xslt get current path`

**nota**: Ser capaz de formular uma string de busca foi o resultado imediato de alguns dias e estudo focado, somado ao meu contexto.

Para listar os caminhos para os nós: https://stackoverflow.com/questions/953197/how-do-you-output-the-current-element-path-in-xslt/10112579

## Semelhança entre construtos de XSLT com construtos de linguagens procedurais

Esta é a [lista de elementos definidos em XSLT](https://www.w3schools.com/xml/xsl_elementref.asp).

Elemento 	Descrição    Mapeamento
apply-imports 	Applies a template rule from an imported style sheet

apply-templates 	Applies a template rule to the current element or to the current element's child nodes
Semelhante a invocação de método
Semelhante a chamada de procedimento

attribute 	Adds an attribute
attribute-set 	Defines a named set of attributes

call-template 	Calls a named template
Semelhante a invocação de método
Semelhante a chamada de procedimento


choose 	Used in conjunction with <when> and <otherwise> to express multiple conditional tests
Semelhante a switch

comment 	Creates a comment node in the result tree
Semelhante a print

copy 	Creates a copy of the current node (without child nodes and attributes)
Semelhante a print

copy-of 	Creates a copy of the current node (with child nodes and attributes)
Semelhante a print

decimal-format 	Defines the characters and symbols to be used when converting numbers into strings, with the format-number() function

element 	Creates an element node in the output document
semelhante a print

fallback 	Specifies an alternate code to run if the processor does not support an XSLT element
catch

for-each 	Loops through each node in a specified node set
Semelhante a foreach

if 	Contains a template that will be applied only if a specified condition is true
if

import 	Imports the contents of one style sheet into another. Note: An imported style sheet has lower precedence than the importing style sheet
include

include 	Includes the contents of one style sheet into another. Note: An included style sheet has the same precedence as the including style sheet
include

key 	Declares a named key that can be used in the style sheet with the key() function

message 	Writes a message to the output (used to report errors)
System.err.print
fprintf (2, "...

namespace-alias 	Replaces a namespace in the style sheet to a different namespace in the output

number 	Determines the integer position of the current node and formats a number

otherwise 	Specifies a default action for the <choose> element
default

output 	Defines the format of the output document

param 	Declares a local or global parameter
declaraçao de variável

preserve-space 	Defines the elements for which white space should be preserved

processing-instruction 	Writes a processing instruction to the output

sort 	Sorts the output

strip-space 	Defines the elements for which white space should be removed

stylesheet 	Defines the root element of a style sheet

template 	Rules to apply when a specified node is matched

text 	Writes literal text to the output
printf

transform 	Defines the root element of a style sheet

value-of 	Extracts the value of a selected node

variable 	Declares a local or global variable


when 	Specifies an action for the <choose> element
case

with-param 	Defines the value of a parameter to be passed into a template
passagem de parâmetro em chamada de procedimento.

## Outras Referências

https://stackoverflow.com/questions/25959107/convert-xml-file-to-rdf-xml-using-xslt
https://www.w3.org/XML/2000/04rdf-parse/

https://stackoverflow.com/questions/3669407/convert-xsd-to-rdf-schema
https://rhizomik.net/redefer
https://www.google.com/search?channel=fs&client=ubuntu&q=xs2owl
https://www.researchgate.net/publication/221038830_XS2OWL_A_Formal_Model_and_a_System_for_Enabling_XML_Schema_Applications_to_Interoperate_with_OWL-DL_Domain_Knowledge_and_Semantic_Web_Tools


