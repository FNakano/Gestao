# Os mesmos tutoriais com Fuseki

## Objetivo

Verificar quais tutoriais de Jena consigo executar em Fuseki com ajustes que considero mínimos.

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

1. [Ler RDF](FusekiTutoriais.md#Ler-RDF) para carregar alguma informação;
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





