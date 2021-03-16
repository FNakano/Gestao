# Ler Turtle para dentro de um Model

2021-03-16

Feito das 8:30 até as 9:20,

Documentado das 9:20 até as 9:40,

Revisão da documentaçao das 9:40 até 9:50

## Uso simples

- Converter Turtle para RDF:XML;
- Criar um modelo a partir de uma especificação, para popular e processar (por exemplo fazendo consultas) e salvar resultados.

## Método

1. Procurar a documentação de Jena para ler Turtle e decidir o que fazer.
   - https://jena.apache.org/documentation/io/rdf-input.html#model-usage (Resultado)
2. Copiar o Tutorial 5, que lê um RDF, executar *as is* para garantir que o código de partida compila, executa e apresenta o resultado esperado (ié *funcionar*).
3. Procurar um arquivo em Turtle sintaticamente correto (usei um que criei para avaliar a usabilidade de ontology-visualization)
3. Ajustar (iterativamente, incrementalmente) o código até *funcionar* ou dar uma desistência BEM justificada.

## Resultados

### Documentação de Jena

https://jena.apache.org/documentation/io/rdf-input.html#model-usage 
   
### Memória de Testes

Início do passo 2 do método.

<pre><font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~</b></font>$ cd Documentos/ZZfiles/sobreJena/programas/LerTTLEmUmModel/
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sobreJena/programas/LerTTLEmUmModel</b></font>$ ls
Tutorial05.java  vc-db-1.rdf
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sobreJena/programas/LerTTLEmUmModel</b></font>$ mv Tutorial05.java LeTTL.java
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sobreJena/programas/LerTTLEmUmModel</b></font>$ cp ~/Documentos/git/ontology-visualization/exemplo51.ttl .
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sobreJena/programas/LerTTLEmUmModel</b></font>$ gedit LeTTL.java &amp;
[1] 4050
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sobreJena/programas/LerTTLEmUmModel</b></font>$ javac -cp &apos;.:/home/fabio/apache-jena-3.17.0/lib/*&apos; LeTTL.java
Note: LeTTL.java uses or overrides a deprecated API.
Note: Recompile with -Xlint:deprecation for details.
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sobreJena/programas/LerTTLEmUmModel</b></font>$ javac -cp -Xlint:deprecation &apos;.:/home/fabio/apache-jena-3.17.0/lib/*&apos; LeTTL.java
error: invalid flag: .:/home/fabio/apache-jena-3.17.0/lib/*
Usage: javac &lt;options&gt; &lt;source files&gt;
use --help for a list of possible options
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sobreJena/programas/LerTTLEmUmModel</b></font>$ javac-Xlint:deprecation -cp &apos;.:/home/fabio/apache-jena-3.17.0/lib/*&apos; LeTTL.java
javac-Xlint:deprecation: comando não encontrado
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sobreJena/programas/LerTTLEmUmModel</b></font>$ javac -Xlint:deprecation -cp &apos;.:/home/fabio/apache-jena-3.17.0/lib/*&apos; LeTTL.java
LeTTL.java:42: warning: [deprecation] get() in FileManager has been deprecated
        InputStream in = FileManager.get().open( inputFileName );
                                    ^
1 warning

<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sobreJena/programas/LerTTLEmUmModel</b></font>$ java -cp &apos;.:/home/fabio/apache-jena-3.17.0/lib/*&apos; LeTTL
&lt;rdf:RDF
    xmlns:rdf=&quot;http://www.w3.org/1999/02/22-rdf-syntax-ns#&quot;
    xmlns:vCard=&quot;http://www.w3.org/2001/vcard-rdf/3.0#&quot;&gt;
  &lt;rdf:Description rdf:about=&quot;http://somewhere/SarahJones&quot;&gt;
    &lt;vCard:N rdf:parseType=&quot;Resource&quot;&gt;
      &lt;vCard:Given&gt;Sarah&lt;/vCard:Given&gt;
      &lt;vCard:Family&gt;Jones&lt;/vCard:Family&gt;
    &lt;/vCard:N&gt;
    &lt;vCard:FN&gt;Sarah Jones&lt;/vCard:FN&gt;
  &lt;/rdf:Description&gt;
  &lt;rdf:Description rdf:about=&quot;http://somewhere/JohnSmith&quot;&gt;
    &lt;vCard:N rdf:parseType=&quot;Resource&quot;&gt;
      &lt;vCard:Given&gt;John&lt;/vCard:Given&gt;
      &lt;vCard:Family&gt;Smith&lt;/vCard:Family&gt;
    &lt;/vCard:N&gt;
    &lt;vCard:FN&gt;John Smith&lt;/vCard:FN&gt;
  &lt;/rdf:Description&gt;
  &lt;rdf:Description rdf:about=&quot;http://somewhere/MattJones&quot;&gt;
    &lt;vCard:N rdf:parseType=&quot;Resource&quot;&gt;
      &lt;vCard:Given&gt;Matthew&lt;/vCard:Given&gt;
      &lt;vCard:Family&gt;Jones&lt;/vCard:Family&gt;
    &lt;/vCard:N&gt;
    &lt;vCard:FN&gt;Matt Jones&lt;/vCard:FN&gt;
  &lt;/rdf:Description&gt;
  &lt;rdf:Description rdf:about=&quot;http://somewhere/RebeccaSmith&quot;&gt;
    &lt;vCard:N rdf:parseType=&quot;Resource&quot;&gt;
      &lt;vCard:Given&gt;Rebecca&lt;/vCard:Given&gt;
      &lt;vCard:Family&gt;Smith&lt;/vCard:Family&gt;
    &lt;/vCard:N&gt;
    &lt;vCard:FN&gt;Becky Smith&lt;/vCard:FN&gt;
  &lt;/rdf:Description&gt;
&lt;/rdf:RDF&gt;
</pre>

Fim do passo 2 da seção método.

Início do passo 3 do método.

Compilar e executar depois de ajustar para ler o turtle de exemplo51.ttl

<pre>
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:~/Documentos/ZZfiles/sobreJena/programas/LerTTLEmUmM<font color="#268BD2"><b>odel</b></font>$ java -cp &apos;.:/home/fabio/apache-jena-3.17.0/lib/*&apos; LeTTL
Exception in thread &quot;main&quot; java.lang.IllegalArgumentException: File: example51.ttl not found
	at LeTTL.main(LeTTL.java:51)
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:~/Documentos/ZZfiles/sobreJena/programas/LerTTLEmUmM<font color="#268BD2"><b>odel</b></font>$ javac -Xlint:deprecation -cp &apos;.:/home/fabio/apache-jena-3.17.0/lib/*&apos; LeTTL.java
LeTTL.java:49: warning: [deprecation] get() in FileManager has been deprecated
        InputStream in = FileManager.get().open( inputFileName );
                                    ^
1 warning
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sobreJena/programas/LerTTLEmUmModel</b></font>$ java -cp &apos;.:/home/fabio/apache-jena-3.17.0/lib/*&apos; LeTTL
08:58:07.403 [main] ERROR org.apache.jena.riot - [line: 1, col: 1 ] O conteúdo não é permitido no prólogo.
Exception in thread &quot;main&quot; org.apache.jena.riot.RiotException: [line: 1, col: 1 ] O conteúdo não é permitido no prólogo.
	at org.apache.jena.riot.system.ErrorHandlerFactory$ErrorHandlerStd.fatal(ErrorHandlerFactory.java:153)
	at org.apache.jena.riot.lang.ReaderRIOTRDFXML$ErrorHandlerBridge.fatalError(ReaderRIOTRDFXML.java:313)
	at org.apache.jena.rdfxml.xmlinput.impl.ARPSaxErrorHandler.fatalError(ARPSaxErrorHandler.java:47)
	at org.apache.jena.rdfxml.xmlinput.impl.XMLHandler.warning(XMLHandler.java:199)
	at org.apache.jena.rdfxml.xmlinput.impl.XMLHandler.fatalError(XMLHandler.java:229)
	at java.xml/com.sun.org.apache.xerces.internal.util.ErrorHandlerWrapper.fatalError(ErrorHandlerWrapper.java:181)
	at java.xml/com.sun.org.apache.xerces.internal.impl.XMLErrorReporter.reportError(XMLErrorReporter.java:400)
	at java.xml/com.sun.org.apache.xerces.internal.impl.XMLErrorReporter.reportError(XMLErrorReporter.java:327)
	at java.xml/com.sun.org.apache.xerces.internal.impl.XMLScanner.reportFatalError(XMLScanner.java:1471)
	at java.xml/com.sun.org.apache.xerces.internal.impl.XMLDocumentScannerImpl$PrologDriver.next(XMLDocumentScannerImpl.java:978)
	at java.xml/com.sun.org.apache.xerces.internal.impl.XMLDocumentScannerImpl.next(XMLDocumentScannerImpl.java:605)
	at java.xml/com.sun.org.apache.xerces.internal.impl.XMLNSDocumentScannerImpl.next(XMLNSDocumentScannerImpl.java:112)
	at java.xml/com.sun.org.apache.xerces.internal.impl.XMLDocumentFragmentScannerImpl.scanDocument(XMLDocumentFragmentScannerImpl.java:534)
	at java.xml/com.sun.org.apache.xerces.internal.parsers.XML11Configuration.parse(XML11Configuration.java:888)
	at java.xml/com.sun.org.apache.xerces.internal.parsers.XML11Configuration.parse(XML11Configuration.java:824)
	at java.xml/com.sun.org.apache.xerces.internal.parsers.XMLParser.parse(XMLParser.java:141)
	at java.xml/com.sun.org.apache.xerces.internal.parsers.AbstractSAXParser.parse(AbstractSAXParser.java:1216)
	at java.xml/com.sun.org.apache.xerces.internal.jaxp.SAXParserImpl$JAXPSAXParser.parse(SAXParserImpl.java:635)
	at org.apache.jena.rdfxml.xmlinput.impl.RDFXMLParser.parse(RDFXMLParser.java:101)
	at org.apache.jena.rdfxml.xmlinput.ARP.load(ARP.java:118)
	at org.apache.jena.riot.lang.ReaderRIOTRDFXML.parse(ReaderRIOTRDFXML.java:188)
	at org.apache.jena.riot.lang.ReaderRIOTRDFXML.read(ReaderRIOTRDFXML.java:86)
	at org.apache.jena.riot.RDFParser.read(RDFParser.java:353)
	at org.apache.jena.riot.RDFParser.parseNotUri(RDFParser.java:343)
	at org.apache.jena.riot.RDFParser.parse(RDFParser.java:292)
	at org.apache.jena.riot.RDFParserBuilder.parse(RDFParserBuilder.java:540)
	at org.apache.jena.riot.RDFDataMgr.parseFromInputStream(RDFDataMgr.java:901)
	at org.apache.jena.riot.RDFDataMgr.read(RDFDataMgr.java:299)
	at org.apache.jena.riot.RDFDataMgr.read(RDFDataMgr.java:285)
	at org.apache.jena.riot.adapters.RDFReaderRIOT.read(RDFReaderRIOT.java:69)
	at org.apache.jena.rdf.model.impl.ModelCom.read(ModelCom.java:253)
	at LeTTL.main(LeTTL.java:55)
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sobreJena/programas/LerTTLEmUmModel</b></font>$ 

</pre>

Pelas mensagens de erro, tenho a impressão que o código está usando métodos para ler RDF:XML. Percebo, por comparação com o *snippet* em https://jena.apache.org/documentation/io/rdf-input.html#model-usage, que eu não deveria usar o objeto `FileManager`, lembro também que é o método dessa classe que levanta o aviso de deprecação. [Código-fonte usado](LeTTL-arquivado1.java) .

Vou trocar pelo *snippet*

<pre><font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sobreJena/programas/LerTTLEmUmModel</b></font>$ javac -Xlint:deprecation -cp &apos;.:/home/fabio/apache-jena-3.17.0/lib/*&apos; LeTTL.java
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sobreJena/programas/LerTTLEmUmModel</b></font>$ java -cp &apos;.:/home/fabio/apache-jena-3.17.0/lib/*&apos; LeTTL
&lt;rdf:RDF
    xmlns:rdf=&quot;http://www.w3.org/1999/02/22-rdf-syntax-ns#&quot;
    xmlns:owl=&quot;http://www.w3.org/2002/07/owl#&quot;
    xmlns:prov=&quot;http://www.w3.org/ns/prov#&quot;
    xmlns=&quot;http://example.com/&quot;
    xmlns:rdfs=&quot;http://www.w3.org/2000/01/rdf-schema#&quot;
    xmlns:xsd=&quot;http://www.w3.org/2001/XMLSchema#&quot;&gt;
  &lt;prov:Activity rdf:about=&quot;http://example.com/illustrating&quot;&gt;
    &lt;prov:qualifiedAssociation&gt;
      &lt;prov:Association&gt;
        &lt;rdfs:comment xml:lang=&quot;en&quot;&gt;Steve helped Derek conform with the publisher&apos;s style guide.&lt;/rdfs:comment&gt;
        &lt;prov:hadPlan&gt;
          &lt;prov:Entity rdf:about=&quot;http://example.com/style-guide&quot;&gt;
            &lt;rdf:type rdf:resource=&quot;http://www.w3.org/ns/prov#Plan&quot;/&gt;
          &lt;/prov:Entity&gt;
        &lt;/prov:hadPlan&gt;
        &lt;prov:hadRole&gt;
          &lt;prov:Role rdf:about=&quot;http://example.com/stylist&quot;/&gt;
        &lt;/prov:hadRole&gt;
        &lt;prov:agent&gt;
          &lt;prov:Entity rdf:about=&quot;http://example.com/steve&quot;&gt;
            &lt;rdf:type rdf:resource=&quot;http://www.w3.org/ns/prov#Agent&quot;/&gt;
            &lt;rdf:type rdf:resource=&quot;http://www.w3.org/ns/prov#Person&quot;/&gt;
          &lt;/prov:Entity&gt;
        &lt;/prov:agent&gt;
      &lt;/prov:Association&gt;
    &lt;/prov:qualifiedAssociation&gt;
    &lt;prov:qualifiedAssociation&gt;
      &lt;prov:Association&gt;
        &lt;prov:hadRole rdf:resource=&quot;http://example.com/illustrationist&quot;/&gt;
        &lt;prov:agent&gt;
          &lt;prov:Entity rdf:about=&quot;http://example.com/derek&quot;&gt;
            &lt;rdf:type rdf:resource=&quot;http://www.w3.org/ns/prov#Agent&quot;/&gt;
            &lt;rdf:type rdf:resource=&quot;http://www.w3.org/ns/prov#Person&quot;/&gt;
          &lt;/prov:Entity&gt;
        &lt;/prov:agent&gt;
      &lt;/prov:Association&gt;
    &lt;/prov:qualifiedAssociation&gt;
    &lt;prov:wasAssociatedWith rdf:resource=&quot;http://example.com/steve&quot;/&gt;
    &lt;prov:wasAssociatedWith rdf:resource=&quot;http://example.com/derek&quot;/&gt;
  &lt;/prov:Activity&gt;
  &lt;prov:Role rdf:about=&quot;http://example.com/illustratonist&quot;/&gt;
&lt;/rdf:RDF&gt;
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sobreJena/programas/LerTTLEmUmModel</b></font>$ 

</pre>

## Conclusão (sumário de resultados)

O código-fonte desenvolvido está no [arquivo](LeTTL.java), uma [versão intermediária](LeTTL-arquivado1.java), para documentação, foi criada e citada na memória de teste.

O código foi compilado e executado. O resultado é o esperado (ié Funcionou).

Comando para compilação:

`javac -Xlint:deprecation -cp '.:/home/fabio/apache-jena-3.17.0/lib/*' LeTTL.java`

Comando para execução:

`java -cp '.:/home/fabio/apache-jena-3.17.0/lib/*' LeTTL`

## Discussão.

Preferi comentar o código que substuí, ao invés de removê-lo.

A API de Jena, neste ponto, está mais simples que a apresentada no tutorial (e o tutorial, embora funcione, provavelmente é antigo e poderia ser simplificado).

