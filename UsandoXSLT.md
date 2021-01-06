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

## Outras Referências

https://stackoverflow.com/questions/25959107/convert-xml-file-to-rdf-xml-using-xslt
https://www.w3.org/XML/2000/04rdf-parse/

https://stackoverflow.com/questions/3669407/convert-xsd-to-rdf-schema
https://rhizomik.net/redefer
https://www.google.com/search?channel=fs&client=ubuntu&q=xs2owl
https://www.researchgate.net/publication/221038830_XS2OWL_A_Formal_Model_and_a_System_for_Enabling_XML_Schema_Applications_to_Interoperate_with_OWL-DL_Domain_Knowledge_and_Semantic_Web_Tools


