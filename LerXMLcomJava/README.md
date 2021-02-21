# Parser XML

Há uma variedade deles, com diferentes estratégias para apresentar o conteúdo. Por exemplo, um parser DOM carrega o documento todo em memória, o que pode ter desvantagens, por exemplo, se o arquivo for muito grande. Um parser SAX carrega partes, hierarquicamente, ... Referências:

- https://www.baeldung.com/java-xml

Existem tutoriais na documentação oficial para Java 8. 

- https://docs.oracle.com/javase/tutorial/jaxp/index.html
- https://docs.oracle.com/javase/tutorial/jaxp/intro/simple.html

Existem outros tutoriais:

- https://www.tutorialspoint.com/java_xml/java_dom_query_document.htm
- https://mkyong.com/java/how-to-read-xml-file-in-java-dom-parser/

Existem threads de perguntas/respostas:

- https://www.guj.com.br/t/parse-em-xml/111851

Seguirei por:

- https://www.baeldung.com/java-xml, que aponta para:
- https://howtodoinjava.com/java/xml/read-xml-dom-parser-example/
   - no fim da página tem um link para o código zipado.

O zip tem a seg. estrutura:

<pre><font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/LerXMLcomJava/JavaDOMParserExamples</b></font>$ tree
<font color="#268BD2"><b>.</b></font>
├── <font color="#268BD2"><b>bin</b></font>
│   └── <font color="#268BD2"><b>com</b></font>
│       └── <font color="#268BD2"><b>howtodoinjava</b></font>
│           └── <font color="#268BD2"><b>dom</b></font>
│               ├── Employee.class
│               ├── ParseKnownXMLStructure.class
│               ├── ParseUnknownXMLStructure.class
│               └── PopulateDTOExamplesWithParsedXML.class
├── employees.xml
└── <font color="#268BD2"><b>src</b></font>
    └── <font color="#268BD2"><b>com</b></font>
        └── <font color="#268BD2"><b>howtodoinjava</b></font>
            └── <font color="#268BD2"><b>dom</b></font>
                ├── Employee.java
                ├── ParseKnownXMLStructure.java
                ├── ParseUnknownXMLStructure.java
                └── PopulateDTOExamplesWithParsedXML.java

8 directories, 9 files
</pre>

Quero saber que arquivos contém método `main`:

<pre><font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/LerXMLcomJava/JavaDOMParserExamples</b></font>$ grep -r -i main *
Arquivo binário bin/com/howtodoinjava/dom/ParseKnownXMLStructure.class coincide com o padrão
Arquivo binário bin/com/howtodoinjava/dom/ParseUnknownXMLStructure.class coincide com o padrão
Arquivo binário bin/com/howtodoinjava/dom/PopulateDTOExamplesWithParsedXML.class coincide com o padrão
<font color="#D33682">src/com/howtodoinjava/dom/ParseUnknownXMLStructure.java</font><font color="#2AA198">:</font>   public static void <font color="#DC322F"><b>main</b></font>(String[] args) throws ParserConfigurationException, SAXException, IOException
<font color="#D33682">src/com/howtodoinjava/dom/PopulateDTOExamplesWithParsedXML.java</font><font color="#2AA198">:</font>   public static void <font color="#DC322F"><b>main</b></font>(String[] args) throws ParserConfigurationException, SAXException, IOException
<font color="#D33682">src/com/howtodoinjava/dom/ParseKnownXMLStructure.java</font><font color="#2AA198">:</font>	public static void <font color="#DC322F"><b>main</b></font>(String[] args) throws Exception {
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/LerXMLcomJava/JavaDOMParserExamples</b></font>$ 

</pre>

Esta estrutura tem jeito de que foi feita por algum ambiente integrado, mas o autor não informa qual foi, nem qual a linha de comando que seria equivalente a compilar e executar o código. Escolhi `ParseUnknownXMLStructure.java` como alvo para compilar. Como tem método `main`, o restante do código deve ter sido organizado para que seja possível executá-lo. 

Para compilar, a partir da pasta `JavaDOMParserExamples`, criada quando deszipei o pacote compactado, usei `javac src/com/howtodoinjava/dom/ParseUnknownXMLStructure.java`. O `.class` foi criado na mesma pasta do arquivo-fonte.

No arquivo-fonte, o pacote a que pertence é `com.howtodoinjava.dom`, logo, deve ser executado a partir da pasta acima de `com`. Desta forma a primeira tentativa de execução é `java com.howtodoinjava.dom.ParseUnknownXMLStructure ` a partir da pasta `src`:

<pre><font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/LerXMLcomJava/JavaDOMParserExamples/src</b></font>$ java com.howtodoinjava.dom.ParseUnknownXMLStructure 
Exception in thread &quot;main&quot; java.io.FileNotFoundException: /home/fabio/Documentos/ZZfiles/LerXMLcomJava/JavaDOMParserExamples/src/employees.xml (Arquivo ou diretório inexistente)
	at java.base/java.io.FileInputStream.open0(Native Method)
	at java.base/java.io.FileInputStream.open(FileInputStream.java:219)
	at java.base/java.io.FileInputStream.&lt;init&gt;(FileInputStream.java:157)
	at java.base/java.io.FileInputStream.&lt;init&gt;(FileInputStream.java:112)
	at java.base/sun.net.www.protocol.file.FileURLConnection.connect(FileURLConnection.java:86)
	at java.base/sun.net.www.protocol.file.FileURLConnection.getInputStream(FileURLConnection.java:184)
	at java.xml/com.sun.org.apache.xerces.internal.impl.XMLEntityManager.setupCurrentEntity(XMLEntityManager.java:652)
	at java.xml/com.sun.org.apache.xerces.internal.impl.XMLVersionDetector.determineDocVersion(XMLVersionDetector.java:150)
	at java.xml/com.sun.org.apache.xerces.internal.parsers.XML11Configuration.parse(XML11Configuration.java:860)
	at java.xml/com.sun.org.apache.xerces.internal.parsers.XML11Configuration.parse(XML11Configuration.java:824)
	at java.xml/com.sun.org.apache.xerces.internal.parsers.XMLParser.parse(XMLParser.java:141)
	at java.xml/com.sun.org.apache.xerces.internal.parsers.DOMParser.parse(DOMParser.java:246)
	at java.xml/com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderImpl.parse(DocumentBuilderImpl.java:339)
	at java.xml/javax.xml.parsers.DocumentBuilder.parse(DocumentBuilder.java:206)
	at com.howtodoinjava.dom.ParseUnknownXMLStructure.main(ParseUnknownXMLStructure.java:26)
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/LerXMLcomJava/JavaDOMParserExamples/src</b></font>$ 
</pre>

A mensagem indica que o arquivo contendo o exemplo era esperado na pasta em que executei o programa (mas está na pasta acima, coisas de ambiente integrado) então vou fazer uma cópia no local esperado.

![alt text](Captura%20de%20tela%20de%202021-02-21%2017-03-32.png)

Ok, leu, conforme o tutorial que segui.

**nota**: removi os `.class` para evitar que (você) execute algo que não compilou (e pode não ser o que estão lhe dizendo).

**nota**: quando fui limpar as pastas para por no Github, vi alguns arquivos e pastas ocultos: `.settings`, `.classpath` e `.project`. Pelo conteúdo deu para ver que a IDE que o autor usou era Eclipse e usava Java 7. Removi os arquivos. Caso precise do conjunto completo de arquivos, sugiro baixar da referência original.

