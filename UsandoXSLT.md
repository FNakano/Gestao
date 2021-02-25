**estado do documento**: incompleto.

> Um colaborador indicou XML Transformations (XSLT) há uns anos. Só agora concluí que é útil explorar mais o assunto.

## Introdução

É uma ferramenta que permite aplicar transformações sobre XML. As transformações são codificadas num 'dialeto' específico de XML, com IRI `http://www.w3.org/1999/XSL/Transform`. Já vi referenciado como XSL e como XSLT. Usualmente a extensão do arquivo que contém a especificação da transformação é `.xsl`. A ferramenta é denominada, genericamente, *XSLT Processor*. Navegadores têm a ferramenta embutida. Existem ferramentas *standalone* como Saxon,que tem [versão gratuita](https://sourceforge.net/projects/saxon/files/).

Em uma abordagem superficial, XSLT é uma transformação sobre XML, semelhante a CSS,que é uma transformação sobre HTML.

As transformações possíveis com XSLT incluem troca de tags XML, inclusão, exclusão de conteúdo e formato. É mais poderosa que CSS, há quem afirme que a XSLT é Turing-Completa. [Fonte Wikipedia](https://en.wikipedia.org/wiki/XSLT). 

**nota**: Não procurei em referências científico-acadêmicas a definição de Turing-Completo, nem a demonstração que XSLT é Turing-Completa.

Atualmente a especificação XSLT está na [versão 3.0](https://www.w3.org/TR/2017/REC-xslt-30-20170608/). Um ['curso' sobre XSLT versão 1.0 está disponível em W3CSchools](https://www.w3schools.com/xml/xsl_intro.asp). A especificação traz as definições de termos explicitamente, contém exemplos, em resumo, contém mais informação e é mais volumosa. O curso apresenta exemplos para replicar, modificar e ver funcionando, com os conceitos necessários para entender o exemplo, sem abordar o funcionamento da ferramenta.

Tenho interesse particular em transformar um formato de codificação de grafos, como graphML ou GML para RDF e vice-versa. Estou inclinado a usar GML (mais precisamente, XGML) pois o graphML gerado pelo yEd é bem complicado, enquanto o XGML parece menos complicado.

## Abordagem escolhida

Navegadores têm um processador XSLT embutido, mas seu controle de segurança e privacidade está configurado de maneira que não permite a execução das transformações armazenadas localmente (ver Discussão). Por isso um servidor web passa a ser necessario. Como tenho Fuseki (Jetty) instalado, é este que será usado. A pasta que contém as páginas é `FUSEKI_HOME/webapp`. Acrescentei uma pasta e, dentro dela, um índice e os arquivos de teste, resultados e cópias de tela. Uma cópia da pasta está neste repositório Github. O endereço de acesso na minha instalação é `http://localhost:3030/xslt/index.html`

## Resultados

### 1

Existem alguns projetos que empregam XSLT para converter XML Schema para XML:RDF :

- https://github.com/srdc/ontmalizer
- https://rhizomik.net/redefer/xsd2owl
- https://github.com/istavrak/XS2OWL

O uso nessa transformação foi objeto de análise por um grupo da W3C. [Wiki da W3C](https://www.w3.org/community/rax/wiki/XML_to_RDF_Transformation_processes_using_XSLT)

### 2

Na elaboração dos [testes](#4) vi que existe um [repositório do github com mais de 11mil testes de XSLT](https://github.com/w3c/xslt30-test/). 

### 3

XSLT usa XPATH.


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

[Conceitos mínimos de XML para avançar para os tópicos XML:RDF, SPARQL, XSLT contidos neste repositório](XMLRapido.md)

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

### 4

São catorze testes ao todo, acessados por [Testes e resultados](xslt/index.html) (para executar, copiar a pasta para dentro da pasta webapp de Fuseki e acessar o conteúdo com o navegador). Abaixo um resumo:

- Teste 1: o do primeiro tutorial da W3Schools. [Fonte: W3S](https://www.w3schools.com/xml/xsl_intro.asp)
- Teste 5: transformação 'identidade'.[Fonte: stackoverflow](https://stackoverflow.com/questions/953197/how-do-you-output-the-current-element-path-in-xslt/10112579)
- Teste 10: Teste superficial de suporte do navegador para migrar para XSLT versão 3.0, que tem mais funcionalidades que a versão 1.0. [Recomendação XLST versão 3.0: Fonte: W3C](https://www.w3.org/TR/2017/REC-xslt-30-20170608/).
- Teste 14: Percorre a árvore XML, escrevendo na saída o caminho descendente até o nó corrente.

Os outros testes, intermediários, são passos incrementais dos citados no resumo.

**nota**: não fiquei muito satisfeito em deixar uma parte da documentação aqui e outra no index.html dentro da pasta xslt.

### Variáveis

Em XSLT, que é dita uma linguagem funcional, variáveis funcionam ligeiramente diferente de C, Java, ...

Uma das diferenças é que variáveis são imutáveis: seu valor é atribuído na criação e uma vez criada, seu valor não muda. Referências listadas abaixo:

- https://stackoverflow.com/questions/19255139/how-to-change-or-reassign-a-variable-in-xslt
- https://stackoverflow.com/questions/36504/why-functional-languages
- https://stackoverflow.com/questions/833118/in-xslt-how-do-i-increment-a-global-variable-from-a-different-scope
- https://stackoverflow.com/questions/3344965/increment-a-value-in-xslt

Isto torna muito mais atraente o uso de parâmetros de funções. Reorganizar o código em função deste mecanismo é sempre possível.

### Templates (funções)

Declarar: https://www.w3schools.com/xml/ref_xsl_el_template.asp

Aplicar (executar, chamar, invocar): https://www.w3schools.com/xml/ref_xsl_el_apply-templates.asp, https://www.w3schools.com/xml/ref_xsl_el_call-template.asp


### Parâmetros

https://www.w3schools.com/xml/ref_xsl_el_with-param.asp
https://www.w3schools.com/xml/ref_xsl_el_param.asp


### Listas, conjuntos, sequências

São úteis para indexar, armazenar e recuperar informação (por exemplo nós em grafos). Em transformações deste tipo, é útil ter algo que sirva como uma tabela de símbolos (terminologia de construção de compiladores). Estas estruturas e as funções associadas podem ser usadas para isso. 

#### Attribute set (são conjuntos de atributos)

https://www.w3schools.com/xml/ref_xsl_el_attributeset.asp

#### Sequências (são value-of)

https://www.w3schools.com/xml/xsl_functions.asp#sequence
https://www.google.com/search?channel=fs&client=ubuntu&q=xslt+sequence
https://stackoverflow.com/questions/14871051/how-to-declare-a-sequence-in-xslt

#### Listas com chave (chave é algum XML:atributo)

https://www.tutorialspoint.com/xslt/xslt_key.htm
https://www.w3schools.com/xml/func_key.asp
https://www.w3schools.com/xml/ref_xsl_el_key.asp

### Teste de Saxon

Experimentei o [Teste 1 na seção 4](#4) usando Saxxon. Copiei os arquivos `cdcatalog.xml` e `cdcatalog.xsl` para uma pasta e executei:

`java -jar ../SaxonHE10-3J/saxon-he-10.3.jar cdcatalog.xml -xsl:cdcatalog.xsl`. Listagem da execução abaixo:

<pre><font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/XSOWL/teste1</b></font>$ ls
cdcatalog2.xml  cdcatalog.xml  cdcatalog.xsl
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/XSOWL/teste1</b></font>$ head cdcatalog.xml
&lt;?xml version=&quot;1.0&quot; encoding=&quot;UTF-8&quot;?&gt;
&lt;catalog&gt;
  &lt;cd&gt;
    &lt;title&gt;Empire Burlesque&lt;/title&gt;
    &lt;artist&gt;Bob Dylan&lt;/artist&gt;
    &lt;country&gt;USA&lt;/country&gt;
    &lt;company&gt;Columbia&lt;/company&gt;
    &lt;price&gt;10.90&lt;/price&gt;
    &lt;year&gt;1985&lt;/year&gt;
  &lt;/cd&gt;
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/XSOWL/teste1</b></font>$ head cdcatalog2.xml
&lt;?xml version=&quot;1.0&quot; encoding=&quot;UTF-8&quot;?&gt;
&lt;?xml-stylesheet type=&quot;text/xsl&quot; href=&quot;cdcatalog.xsl&quot;?&gt;
&lt;catalog&gt;
  &lt;cd&gt;
    &lt;title&gt;Empire Burlesque&lt;/title&gt;
    &lt;artist&gt;Bob Dylan&lt;/artist&gt;
    &lt;country&gt;USA&lt;/country&gt;
    &lt;company&gt;Columbia&lt;/company&gt;
    &lt;price&gt;10.90&lt;/price&gt;
    &lt;year&gt;1985&lt;/year&gt;
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/XSOWL/teste1</b></font>$ rm cdcatalog2.xml 
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/XSOWL/teste1</b></font>$ ls
cdcatalog.xml  cdcatalog.xsl
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/XSOWL/teste1</b></font>$ java -jar ../SaxonHE10-3J/saxon-he-10.3.jar cdcatalog.xml -xsl:cdcatalog.xsl
&lt;!DOCTYPE HTML&gt;&lt;html&gt;
   &lt;body&gt;
      &lt;h2&gt;My CD Collection&lt;/h2&gt;
      &lt;table border=&quot;1&quot;&gt;
         &lt;tr bgcolor=&quot;#9acd32&quot;&gt;
            &lt;th style=&quot;text-align:left&quot;&gt;Title&lt;/th&gt;
            &lt;th style=&quot;text-align:left&quot;&gt;Artist&lt;/th&gt;
         &lt;/tr&gt;
         &lt;tr&gt;
            &lt;td&gt;Empire Burlesque&lt;/td&gt;
            &lt;td&gt;Bob Dylan&lt;/td&gt;
         &lt;/tr&gt;
         &lt;tr&gt;
            &lt;td&gt;Hide your heart&lt;/td&gt;
            &lt;td&gt;Bonnie Tyler&lt;/td&gt;
         &lt;/tr&gt;
         &lt;tr&gt;
            &lt;td&gt;Greatest Hits&lt;/td&gt;
            &lt;td&gt;Dolly Parton&lt;/td&gt;
         &lt;/tr&gt;
         &lt;tr&gt;
            &lt;td&gt;Still got the blues&lt;/td&gt;
            &lt;td&gt;Gary Moore&lt;/td&gt;
         &lt;/tr&gt;
         &lt;tr&gt;
            &lt;td&gt;Eros&lt;/td&gt;
            &lt;td&gt;Eros Ramazzotti&lt;/td&gt;
         &lt;/tr&gt;
         &lt;tr&gt;
            &lt;td&gt;One night only&lt;/td&gt;
            &lt;td&gt;Bee Gees&lt;/td&gt;
         &lt;/tr&gt;
         &lt;tr&gt;
            &lt;td&gt;Sylvias Mother&lt;/td&gt;
            &lt;td&gt;Dr.Hook&lt;/td&gt;
         &lt;/tr&gt;
         &lt;tr&gt;
            &lt;td&gt;Maggie May&lt;/td&gt;
            &lt;td&gt;Rod Stewart&lt;/td&gt;
         &lt;/tr&gt;
         &lt;tr&gt;
            &lt;td&gt;Romanza&lt;/td&gt;
            &lt;td&gt;Andrea Bocelli&lt;/td&gt;
         &lt;/tr&gt;
         &lt;tr&gt;
            &lt;td&gt;When a man loves a woman&lt;/td&gt;
            &lt;td&gt;Percy Sledge&lt;/td&gt;
         &lt;/tr&gt;
         &lt;tr&gt;
            &lt;td&gt;Black angel&lt;/td&gt;
            &lt;td&gt;Savage Rose&lt;/td&gt;
         &lt;/tr&gt;
         &lt;tr&gt;
            &lt;td&gt;1999 Grammy Nominees&lt;/td&gt;
            &lt;td&gt;Many&lt;/td&gt;
         &lt;/tr&gt;
         &lt;tr&gt;
            &lt;td&gt;For the good times&lt;/td&gt;
            &lt;td&gt;Kenny Rogers&lt;/td&gt;
         &lt;/tr&gt;
         &lt;tr&gt;
            &lt;td&gt;Big Willie style&lt;/td&gt;
            &lt;td&gt;Will Smith&lt;/td&gt;
         &lt;/tr&gt;
         &lt;tr&gt;
            &lt;td&gt;Tupelo Honey&lt;/td&gt;
            &lt;td&gt;Van Morrison&lt;/td&gt;
         &lt;/tr&gt;
         &lt;tr&gt;
            &lt;td&gt;Soulsville&lt;/td&gt;
            &lt;td&gt;Jorn Hoel&lt;/td&gt;
         &lt;/tr&gt;
         &lt;tr&gt;
            &lt;td&gt;The very best of&lt;/td&gt;
            &lt;td&gt;Cat Stevens&lt;/td&gt;
         &lt;/tr&gt;
         &lt;tr&gt;
            &lt;td&gt;Stop&lt;/td&gt;
            &lt;td&gt;Sam Brown&lt;/td&gt;
         &lt;/tr&gt;
         &lt;tr&gt;
            &lt;td&gt;Bridge of Spies&lt;/td&gt;
            &lt;td&gt;T`Pau&lt;/td&gt;
         &lt;/tr&gt;
         &lt;tr&gt;
            &lt;td&gt;Private Dancer&lt;/td&gt;
            &lt;td&gt;Tina Turner&lt;/td&gt;
         &lt;/tr&gt;
         &lt;tr&gt;
            &lt;td&gt;Midt om natten&lt;/td&gt;
            &lt;td&gt;Kim Larsen&lt;/td&gt;
         &lt;/tr&gt;
         &lt;tr&gt;
            &lt;td&gt;Pavarotti Gala Concert&lt;/td&gt;
            &lt;td&gt;Luciano Pavarotti&lt;/td&gt;
         &lt;/tr&gt;
         &lt;tr&gt;
            &lt;td&gt;The dock of the bay&lt;/td&gt;
            &lt;td&gt;Otis Redding&lt;/td&gt;
         &lt;/tr&gt;
         &lt;tr&gt;
            &lt;td&gt;Picture book&lt;/td&gt;
            &lt;td&gt;Simply Red&lt;/td&gt;
         &lt;/tr&gt;
         &lt;tr&gt;
            &lt;td&gt;Red&lt;/td&gt;
            &lt;td&gt;The Communards&lt;/td&gt;
         &lt;/tr&gt;
         &lt;tr&gt;
            &lt;td&gt;Unchain my heart&lt;/td&gt;
            &lt;td&gt;Joe Cocker&lt;/td&gt;
         &lt;/tr&gt;
      &lt;/table&gt;
   &lt;/body&gt;
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/XSOWL/teste1</b></font>$ 

</pre> 

Testei Saxon com um gerador de grafos aleatórios (`gnl.xsl`), conforme <http://graphml.graphdrawing.org/download.html>. Acredito que seja um bom exemplo de uso de transformações e da linguagem XSLT (por exemplo, mostra como ler argumentos de linha de comando), mas fiquei frustrado pois a versão gratuita não tem funcionalidade suficiente.

![alt text](Imagens/Captura%20de%20tela%20de%202021-01-17%2016-20-09.png)

Teste Saxon com [graphml2rdf](ttps://github.com/cui-ke/graphml2rdf), que usei [aqui](bid-graphML-RDF.md#exemplo).


## Discussão 

Acreditei que como navegadores têm processador XSLT embutido, seria possível experimentar com XSLT sem um servidor web, apenas com `file:///arquivo.xml` na barra de endereço. Porém, quando tentei, a transformação não foi feita. A busca pela solução, e pelo motivo, trouxe resultados desordenados, que apresento abaixo conforme minha forma de organizar.

Em 2019 foi detectada uma [característica do navegador que poderia ser explorada por programas maliciosos](https://www.mozilla.org/en-US/security/advisories/mfsa2019-21/#CVE-2019-11730): Arquivos locais `file:///` podiam se localizar e se acessar mutuamente, mesmo que tivessem origem diferente. Por exemplo, seria possível enviar cópias de arquivos locais para um servidor, por exemplo.

A funcionalidade do navegador que controla isso está em [Cross Origin Resource Sharing (CORS)](https://developer.mozilla.org/en-US/docs/Web/HTTP/CORS). O controle, bloqueado por padrão, [pode ser habilitado por configuração de usuário](https://developer.mozilla.org/pt-BR/docs/Web/HTTP/Headers/Access-Control-Allow-Origin).

Isto foi corrigido, mas tornou transformações XSL locais inoperantes:

- https://support.mozilla.org/en-US/questions/1264318
- https://bugzilla.mozilla.org/show_bug.cgi?id=1566029
- https://bugzilla.mozilla.org/show_bug.cgi?id=1565261

Como consequência, só é possível experimentar com XSLT sem um servidor web reduzindo a segurança no navegador. Achei melhor usar um servidor web. O que tenho instalado é Fuseki (Jetty, para ser mais preciso).

## Outras Referências

https://stackoverflow.com/questions/25959107/convert-xml-file-to-rdf-xml-using-xslt
https://www.w3.org/XML/2000/04rdf-parse/

https://stackoverflow.com/questions/3669407/convert-xsd-to-rdf-schema
https://rhizomik.net/redefer
https://www.google.com/search?channel=fs&client=ubuntu&q=xs2owl
https://www.researchgate.net/publication/221038830_XS2OWL_A_Formal_Model_and_a_System_for_Enabling_XML_Schema_Applications_to_Interoperate_with_OWL-DL_Domain_Knowledge_and_Semantic_Web_Tools
http://www2.ic.uff.br/~vanessa/material/gdse/09-XSLT.pdf


