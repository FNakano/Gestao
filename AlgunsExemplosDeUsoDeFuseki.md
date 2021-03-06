# Alguns exemplos de uso de Fuseki

## Introdução

Os tutoriais da documentação de Jena a que me refiro são compostos por programas em Java que quando executados operam sobre uma base de conhecimento.

Há algumas formas de usar Fuseki que considero úteis, mas são parte, ou são requisitos, para executar, com Fuseki, os tutoriais da documentação de Jena.

Quando a forma de uso corresponder a um tutorial, sua execução será documentada aqui.

## Objetivo

Apresentar algumas formas de usar Fuseki.

## Método

Para cada tutorial:

1. Entendê-lo;
2. Partindo de uma nova instalação de Fuseki, carregar o que for requisito, apresentando o que motiva o requisito;
3. Apresentar o estado com requisito satisfeito;
4. Apresentar a execução;
5. Apresentar o resultado da execução.
6. Apresentar as referências;

- Os requisitos podem ser outros tutoriais;
- Os resultados podem ser apresentados em ordem diferente da presente nos tutoriais;
- Não há compromisso que o procedimento apresentado seja único, mais rápido, mais curto ou qualquer outra característica além de ser suficientemente próximo do tutorial citado.

### Referências

[Tutoriais](https://jena.apache.org/tutorials/rdf_api.html)

## Resultados

### Ler RDF 

Este corresponde ao tutorial 5.

1. Iniciar Fuseki;
2. Acessar o servidor com um browser, acessando o endereço `localhost:3030`
3. Criar um dataset, clicando em `manage Datasets`, `add new Dataset`;
    - [Tela mostrando estado](Imagens/Captura%20de%20tela%20de%202020-12-26%2011-00-49.png);
4. Baixar o arquivo vc-db-1.rdf das referências;
5. Fazer upload do arquivo no Fuseki;
    - [Tela mostrando estado](Imagens/Captura%20de%20tela%20de%202020-12-28%2014-46-53.png);
6. Verificar, abrindo para edição;
    - [Tela mostrando estado](Imagens/Captura%20de%20tela%20de%202020-12-28%2014-47-02.png);

- Neste exemplo o dataset foi criado em memória. Os dados não persistem quando Fuseki for fechado. 

#### Referências

[Tutorial 5](https://jena.apache.org/tutorials/rdf_api.html#ch-Reading-RDF)

[vc-db-1.rdf](https://jena.apache.org/tutorials/sparql_data/vc-db-1.rdf)

### Fazer uma consulta SPARQL SELECT

1. [Ler RDF](FusekiTutoriais.md#Ler-RDF) para carregar alguma informação;
2. Na [aba query](Imagens/Captura%20de%20tela%20de%202020-12-28%2018-18-18.png) digitar a consulta:
```
SELECT ?subject ?predicate ?object
WHERE {
  ?subject ?predicate ?object
}
LIMIT 25
```
3. Clicar no triângulo no canto superior direito da caixa de texto para executar a consulta;
4. [Ver o resultado](Imagens/Captura%20de%20tela%20de%202020-12-28%2018-20-57.png);

É possível seguir o tutorial em <https://jena.apache.org/tutorials/sparql_query1.html>, copiando e colando a consulta contida em [q1.rq](https://jena.apache.org/tutorials/sparql_data/q1.rq)

![alt text](Imagens/Captura%20de%20tela%20de%202020-12-28%2014-46-32.png)

### Fazer uma consulta SPARQL UPDATE

1. [Ler RDF](FusekiTutoriais.md#Ler-RDF) para carregar alguma informação;
2. Na [aba query](Imagens/Captura%20de%20tela%20de%202020-12-28%2018-18-18.png) digitar a consulta:
```
PREFIX dc: <http://purl.org/dc/elements/1.1/>
INSERT DATA
{ 
  <http://example/book1> dc:title "A new book" ;
                         dc:creator "A.N.Other" .
}
```
3. Clicar no triângulo no canto superior direito da caixa de texto para executar a consulta;
4. Resultou em *bad request* [Ver o resultado](Imagens/Captura%20de%20tela%20de%202020-12-28%2017-55-46.png);

#### Comentários e conclusões

UPDATE não é possível usando somente o navegador (`localhost:3030`). Precisa de outra ferramenta (add-on, plugin) para gerar requisições POST.

A origem da consulta usada para teste é: <https://www.w3.org/TR/sparql11-update/#example_1>

<a name="especula" > A especulação sobre POST </a> funcionar vem da [tela de informação do Fuseki](Imagens/Captura%20de%20tela%20de%202020-12-28%2018-00-17.png). Acessada pela [tela info](Imagens/Captura%20de%20tela%20de%202020-12-28%2017-59-57.png), reforçada pela [postagem em stack overflow](https://stackoverflow.com/questions/43474884/fuseki-sparql-insert-produces-the-error-400-sparql-query-no-query-paramete)

### Fazer uma consulta SPARQL SELECT usando curl e POST

**nota**: isto é um teste para ver se a 'receita' de Hector Correa usando CURL funciona.

Escolhi curl porque o add-on que pensei em instalar **requer acesso à informação de todas as páginas que eu abrir**. Acho isso excessivo.

1. [Ler RDF](FusekiTutoriais.md#Ler-RDF) para carregar alguma informação;
2. Abrir um novo terminal e executar `curl -X POST -d "query=select ?s where { ?s ?p ?o . }" localhost:3030/mydataset/query`
3. Ver o resultado (abaixo)

<pre><font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~</b></font>$ curl -X POST -d &quot;query=select ?s where { ?s ?p ?o . }&quot; localhost:3030/datasetone/query
Error 404: Not Found
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~</b></font>$ curl -X POST -d &quot;query=select ?s where { ?s ?p ?o . }&quot; localhost:3030/mydataset/query
{ &quot;head&quot;: {
    &quot;vars&quot;: [ &quot;s&quot; ]
  } ,
  &quot;results&quot;: {
    &quot;bindings&quot;: [
      { 
        &quot;s&quot;: { &quot;type&quot;: &quot;uri&quot; , &quot;value&quot;: &quot;http://somewhere/MattJones&quot; }
      } ,
      { 
        &quot;s&quot;: { &quot;type&quot;: &quot;uri&quot; , &quot;value&quot;: &quot;http://somewhere/MattJones&quot; }
      } ,
      { 
        &quot;s&quot;: { &quot;type&quot;: &quot;bnode&quot; , &quot;value&quot;: &quot;b0&quot; }
      } ,
      { 
        &quot;s&quot;: { &quot;type&quot;: &quot;bnode&quot; , &quot;value&quot;: &quot;b0&quot; }
      } ,
      { 
        &quot;s&quot;: { &quot;type&quot;: &quot;uri&quot; , &quot;value&quot;: &quot;http://somewhere/SarahJones&quot; }
      } ,
      { 
        &quot;s&quot;: { &quot;type&quot;: &quot;uri&quot; , &quot;value&quot;: &quot;http://somewhere/SarahJones&quot; }
      } ,
      { 
        &quot;s&quot;: { &quot;type&quot;: &quot;uri&quot; , &quot;value&quot;: &quot;http://somewhere/RebeccaSmith&quot; }
      } ,
      { 
        &quot;s&quot;: { &quot;type&quot;: &quot;uri&quot; , &quot;value&quot;: &quot;http://somewhere/RebeccaSmith&quot; }
      } ,
      { 
        &quot;s&quot;: { &quot;type&quot;: &quot;bnode&quot; , &quot;value&quot;: &quot;b1&quot; }
      } ,
      { 
        &quot;s&quot;: { &quot;type&quot;: &quot;bnode&quot; , &quot;value&quot;: &quot;b1&quot; }
      } ,
      { 
        &quot;s&quot;: { &quot;type&quot;: &quot;bnode&quot; , &quot;value&quot;: &quot;b2&quot; }
      } ,
      { 
        &quot;s&quot;: { &quot;type&quot;: &quot;bnode&quot; , &quot;value&quot;: &quot;b2&quot; }
      } ,
      { 
        &quot;s&quot;: { &quot;type&quot;: &quot;bnode&quot; , &quot;value&quot;: &quot;b3&quot; }
      } ,
      { 
        &quot;s&quot;: { &quot;type&quot;: &quot;bnode&quot; , &quot;value&quot;: &quot;b3&quot; }
      } ,
      { 
        &quot;s&quot;: { &quot;type&quot;: &quot;uri&quot; , &quot;value&quot;: &quot;http://somewhere/JohnSmith&quot; }
      } ,
      { 
        &quot;s&quot;: { &quot;type&quot;: &quot;uri&quot; , &quot;value&quot;: &quot;http://somewhere/JohnSmith&quot; }
      }
    ]
  }
}
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~</b></font>$ 

</pre>

#### Referências

[Hector Correa](https://github.com/hectorcorrea/fuseki_demo)

### Fazer uma consulta SPARQL UPDATE usando curl e POST

**nota**: composição de [Fazer uma consulta SPARQL UPDATE usando curl e POST](#Fazer-uma-consulta-SPARQL-UPDATE-usando-curl-e-POST) com a [especulação sobre POST](#especula)

1. [Ler RDF](#ler-rdf) para carregar alguma informação;
2. Abrir um novo terminal e executar ~~`curl -X POST -d "query= PREFIX dc: <http://purl.org/dc/elements/1.1/> INSERT DATA { <http://example/book1> dc:title "A new book" ; dc:creator "A.N.Other" . } " localhost:3030/mydataset/update`~~ `curl -X POST -d 'update= PREFIX dc: <http://purl.org/dc/elements/1.1/> INSERT DATA { <http://example/book1> dc:title "A new book" ; dc:creator "A.N.Other" . } ' localhost:3030/mydataset/update`
3. Ver o resultado (abaixo)

<pre><font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~</b></font>$ curl -X POST -d &quot;query= PREFIX dc: &lt;http://purl.org/dc/elements/1.1/&gt; INSERT DATA { &lt;http://example/book1&gt; dc:title &quot;A new book&quot; ; dc:creator &quot;A.N.Other&quot; . } &quot; localhost:3030/mydataset/update
curl: (6) Could not resolve host: new
curl: (3) unmatched close brace/bracket in URL position 31:
book ; dc:creator A.N.Other . } 
                              ^
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~</b></font>$ curl -X POST -d &apos;query= PREFIX dc: &lt;http://purl.org/dc/elements/1.1/&gt; INSERT DATA { &lt;http://example/book1&gt; dc:title &quot;A new book&quot; ; dc:creator &quot;A.N.Other&quot; . } &apos; localhost:3030/mydataset/update
SPARQL Update: No &apos;update=&apos; parameter
</pre>

O primeiro erro foi uma questão de doublequotes dentro de doublequotes, resolvi trocando os doublequotes mais externos por singlequotes. O segundo erro tem a ver com o nome do parâmetro, tem que ser `update`. Correções feitas:

Terminal em que executei curl:
<pre><font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~</b></font>$ curl -X POST -d &apos;update= PREFIX dc: &lt;http://purl.org/dc/elements/1.1/&gt; INSERT DATA { &lt;http://example/book1&gt; dc:title &quot;A new book&quot; ; dc:creator &quot;A.N.Other&quot; . } &apos; localhost:3030/mydataset/update
&lt;html&gt;
&lt;head&gt;
&lt;/head&gt;
&lt;body&gt;
&lt;h1&gt;Success&lt;/h1&gt;
&lt;p&gt;
Update succeeded
&lt;/p&gt;
&lt;/body&gt;
&lt;/html&gt;
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~</b></font>$ 
</pre>

[tela com mensagens nos terminais](Imagens/Captura%20de%20tela%20de%202020-12-28%2019-11-23.png)

[tela de edição do dataset com as triplas inseridas](Imagens/Captura%20de%20tela%20de%202020-12-28%2019-13-04.png)

### Carregar uma ontologia com uma consulta SPARQL LOAD usando curl e POST

1. Na interface de controle do servidor Fuseki, criar um novo dataset. Neste exemplo chama-se `MeuSSN`.
2. Abrir um novo terminal e executar `curl -X POST -d 'update= LOAD <http://purl.org/dc/elements/1.1/>  ' localhost:3030/MeuSSN/update`
3. Ver o resultado (abaixo)



Terminal em que executei curl:
<pre><font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/git/Gestao</b></font>$ curl -X POST -d &apos;update= LOAD &lt;http://purl.org/dc/elements/1.1/&gt;  &apos; localhost:3030/MeuSSN/update
&lt;html&gt;
&lt;head&gt;
&lt;/head&gt;
&lt;body&gt;
&lt;h1&gt;Success&lt;/h1&gt;
&lt;p&gt;
Update succeeded
&lt;/p&gt;
&lt;/body&gt;
&lt;/html&gt;
</pre>

[tela de edição do dataset com as triplas inseridas](Imagens/Captura%20de%20tela%20de%202021-01-14%2019-46-24.png)

#### Comentário

Tentei fazer esta operação pela interface web do Fuseki. Obtive *bad request* como resposta. Este comportamento é semelhante ao que ocorreu com UPDATE. Creio que consultas que modificam os grafos de conhecimento foram restritas a usar o método POST e nó update.

### Usar a instalação de Fuseki para servir páginas HTML.

Precisei modificar o `index.html` da minha instalação de Fuseki para conseguir renderizar um XML específico. O navegador não permitia o acesso.

Isto permite usar javascript no navegador, o que pode ser bastante útil.

A pasta que contém as páginas é `FUSEKI_HOME/webapp`. Modifiquei o `index.html`, acrescentei uma pasta e, dentro dela, dois arquivos. Serviu as páginas conforme esperado.

### Fazer uma consulta SPARQL SELECT da barra de endereçamento do navegador ié HTTP:GET.

Desta vez o servidor Fuseki está hospedado em VPS e foi implantado como um `.war` no Tomcat.

Aqui a requisição passa pelo navegador, pelo servidor http (Apache), pelo servidor jsp (Tomcat), pelo Fuseki, e volta na direção oposta, para a janela do navegador onde a resposta é renderizada.

Neste caminho, a mensagem é transformada - tem caracteres substituídos, para ser compatível com o protocolo de comunicação usado. MAS nem sempre faz tudo que precisa...

Se copiar e colar a linha abaixo na barra de endereço do navegador e der ENTER:

```
http://ip-50-62-81-50.ip.secureserver.net:8080/fuseki/testeFabio/query?query=select ?s where { ?s ?p ?o}
```

A resposta é:

<body><h1>HTTP Status 400 – Bad Request</h1><hr class="line" /><p><b>Type</b> Exception Report</p><p><b>Message</b> Invalid character found in the request target [&#47;fuseki&#47;testeFabio&#47;query?query=select%20?s%20where%20{%20?s%20?p%20?o}]. The valid characters are defined in RFC 7230 and RFC 3986</p><p><b>Description</b> The server cannot or will not process the request due to something that is perceived to be a client error (e.g., malformed request syntax, invalid request message framing, or deceptive request routing).</p><p><b>Exception</b></p><pre>java.lang.IllegalArgumentException: Invalid character found in the request target [&#47;fuseki&#47;testeFabio&#47;query?query=select%20?s%20where%20{%20?s%20?p%20?o}]. The valid characters are defined in RFC 7230 and RFC 3986
	org.apache.coyote.http11.Http11InputBuffer.parseRequestLine(Http11InputBuffer.java:490)
	org.apache.coyote.http11.Http11Processor.service(Http11Processor.java:261)
	org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:65)
	org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:893)
	org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1707)
	org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:49)
	java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
	java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
	org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)
	java.lang.Thread.run(Thread.java:748)
</pre><p><b>Note</b> The full stack trace of the root cause is available in the server logs.</p><hr class="line" /><h3>Apache Tomcat/9.0.44</h3>

Levei um tempo até entender a mensagem de erro 
> The valid characters are defined in RFC 7230 and RFC 3986

e perceber que as chaves também não são caracteres válidos em uma requisição HTTP:GET (Além dos espaços, que são substituídos por %20 automaticamente pelo navegador. A linha para colar na barra de endereço ficou:

```
http://ip-50-62-81-50.ip.secureserver.net:8080/fuseki/testeFabio/query?query=select%20?s%20where%20%7b%20?s%20?p%20?o%20%7d
```

![alt text](Captura%20de%20tela%20de%202021-04-26%2014-46-57.png)


Referências:

https://stackoverflow.com/questions/54287922/the-valid-characters-are-defined-in-rfc-7230-and-rfc-3986

https://secure.n-able.com/webhelp/nc_9-1-0_so_en/content/sa_docs/api_level_integration/api_integration_urlencoding.html

### Fazer uma consulta SPARQL SELECT com curl e GET

A linha abaixo dá erro 404. (pode ser que a requisição fique com formato diferente: não sei se `-d` coloca os dados na requisição no formato que espero.

```
curl -X GET -d "query=select ?s where { ?s ?p ?o . }" ip-50-62-81-50.ip.secureserver.net:8080/fuseki/testeFabio/query
```

A linha abaixo é executada e retorna o resultado da consulta.

```
curl -X GET ip-50-62-81-50.ip.secureserver.net:8080/fuseki/testeFabio/query?query=select%20?s%20where%7b?s%20?p%20?o%7d
```

<pre><font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~</b></font>$ curl -X GET -d &quot;query=select ?s where { ?s ?p ?o . }&quot; ip-50-62-81-50.ip.secureserver.net:8080/fuseki/testeFabio/query
&lt;!doctype html&gt;&lt;html lang=&quot;en&quot;&gt;&lt;head&gt;&lt;title&gt;HTTP Status 404 – Not Found&lt;/title&gt;&lt;style type=&quot;text/css&quot;&gt;body {font-family:Tahoma,Arial,sans-serif;} h1, h2, h3, b {color:white;background-color:#525D76;} h1 {font-size:22px;} h2 {font-size:16px;} h3 {font-size:14px;} p {font-size:12px;} a {color:black;} .line {height:1px;background-color:#525D76;border:none;}&lt;/style&gt;&lt;/head&gt;&lt;body&gt;&lt;h1&gt;HTTP Status 404 – Not Found&lt;/h1&gt;&lt;hr class=&quot;line&quot; /&gt;&lt;p&gt;&lt;b&gt;Type&lt;/b&gt; Status Report&lt;/p&gt;&lt;p&gt;&lt;b&gt;Message&lt;/b&gt; Service Description: &amp;#47;fuseki&amp;#47;testeFabio&amp;#47;query&lt;/p&gt;&lt;p&gt;&lt;b&gt;Description&lt;/b&gt; The origin server did not find a current representation for the target resource or is not willing to disclose that one exists.&lt;/p&gt;&lt;hr class=&quot;line&quot; /&gt;&lt;h3&gt;Apache Tomcat/9.0.44&lt;/h3&gt;&lt;/body&gt;&lt;/html&gt;<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~</b></font>$ curl -X GET -d &quot;query=select ?s where { ?s 
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~</b></font>$ 
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~</b></font>$ 
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~</b></font>$ 
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~</b></font>$ curl -X GET ip-50-62-81-50.ip.secureserver.net:8080/fuseki/testeFabio/query?query=select%20?s%20where%7b?s%20?p%20?o%7d
{
  &quot;head&quot;: {
    &quot;vars&quot;: [ &quot;s&quot; ]
  } ,
  &quot;results&quot;: {
.....
</pre>

