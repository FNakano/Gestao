# Shell scripts para manipular grafos de conhecimento em um servidor Fuseki.

## Motivação

Os shell scripts visam automatizar operações. Essa automatização evita que o programador use seu tempo digitando trechos de comandos que podem ser padronizados, ou precise ajustar-se a sintaxes específicas de ferramentas, como o shell script (que precisa "escapar" certos caracteres), ou requisições GET (que precisam substituir caracteres como espaços por %20 e chaves por %7b e %7d).

Numa camada seguinte, uma IDE pode chamar os shell scripts através de atalhos de teclado ou botões na interface, inclusive passando como argumentos, por exemplo, o texto marcado em uma janela de edição de texto, como é possível fazer com o plug-in de ferramentas externas do gedit [Ver captura de tela](Captura%20de%20tela%20de%202021-04-28%2018-13-35.png).

SPARQL é uma linguagem de consulta que permite muitas construções, por isso sua sintaxe não é das mais simples (https://www.w3.org/TR/sparql11-query/, https://www.w3.org/TR/sparql11-update/).

Consultas SPARQL frequentemente são enviadas a servidores na Internet usando o protocolo HTTP. Por exemplo em dbpedia e wikidata. Algumas consultas podem ser enviadas através de requisições GET, e todas elas podem ser enviadas através de requisições POST (checar afirmação).

A ferramenta mais comum usada para acesso à internet é o navegador. Este, sem o auxílio de plugins ou addons (a denominação depende do particular desenvolvedor), não permite ao usuário enviar requisições POST. Com o auxílio de plugins tornam o usuário capaz de enviar requisições POST, mas os recursos de composição de atividades e resultados (ex. macros e scripts) são limitados. Esta dificuldade geralmente é contornada com o uso de javascript. 

Outra característica do navegador é a implementação da segurança do sistema e da informações do usuário. Navegadores executam os scripts de cada janela/aba em áreas protegidas (sandboxes), com acesso limitado ao sistema de arquivos. Esta estratégia é muito boa para garantir a segurança do usuário contra sites maliciosos, mas muito ruim para, por exemplo, construir uma IDE executada localmente e dentro do navegador. Seria necessário instalar um servidor web na máquina local, estratégia usada por NodeJS.

Seria muito cômodo deixar a conversão de caracteres [RFC3986](https://tools.ietf.org/html/rfc3986#page-12) por conta do navegador, mas esta facilidade não compensa as dificuldades citadas acima.
  
Comunicação por HTTP pode ser feita em linha de comando, por aplicativos como `wget` e `curl`. O primeiro costuma ser usado para transferência de arquivos através de HTTP, o segundo para envio de requisições e apresentação de resultados como listagem de texto (que pode ser redirecionada para arquivos de acordo com a conveniência). Esta escolha acrescenta dois níveis de conversão de caracteres: um pelo aplicativo (`curl`), outro pela linha de comando (`sh`). Ainda assim, como são tratadas por quem constrói os shell scripts (programadores desta ferramenta), são transparentes aos usuários (programadores de aplicação).

## Objetivo

Construir uma coleção de shell scripts para manipulação de grafos de conhecimento.

## Resultados

**nota**: Para SO Linux.

### init.sh

Uso: `source init.sh`

Função: Cria as variáveis de ambiente QUERY e UPDATE, que contém os links para os endpoints SPARQL. *Este script deve ser ajustado para apontar para os seus endpoints.*

**nota**: há formas de tornar esta linha de comando mais curta.

**nota**: o script é executado em um 'sub-shell' (em analogia a subclasses). Em princípio as variáveis definidas nele não seriam propagadas para o 'super-shell' (em analogia a superclasses). O comando `source` faz essa propagação. **As variáveis de ambiente são essenciais para o funcionamento dos outros scripts.**

Exemplo: <pre><font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sparql</b></font>$ source init.sh
</pre>


### la.sh

Uso: `sh la.sh`

Função: Lista todas as triplas armazenadas no dataset.

Exemplo:
<pre><font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sparql</b></font>$ sh la.sh |more
  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed
  0     0    0     0    0     0      0      0 --:--:-- --:--:-- --:--:--     0{
  &quot;head&quot;: {
    &quot;vars&quot;: [ &quot;s&quot; , &quot;p&quot; , &quot;o&quot; ]
  } ,
  &quot;results&quot;: {
    &quot;bindings&quot;: [
      {
        &quot;s&quot;: { &quot;type&quot;: &quot;uri&quot; , &quot;value&quot;: &quot;http://www.semanticweb.org/joeds/ontologies/2020/3/swotDom
oticProject&quot; } ,
        &quot;p&quot;: { &quot;type&quot;: &quot;uri&quot; , &quot;value&quot;: &quot;http://www.w3.org/1999/02/22-rdf-syntax-ns#type&quot; } ,
        &quot;o&quot;: { &quot;type&quot;: &quot;uri&quot; , &quot;value&quot;: &quot;http://www.w3.org/2002/07/owl#Ontology&quot; }
      } ,
      {
        &quot;s&quot;: { &quot;type&quot;: &quot;uri&quot; , &quot;value&quot;: &quot;http://www.semanticweb.org/joeds/ontologies/2020/3/swotDom
oticProject#belongsTo&quot; } ,
        &quot;p&quot;: { &quot;type&quot;: &quot;uri&quot; , &quot;value&quot;: &quot;http://www.w3.org/1999/02/22-rdf-syntax-ns#type&quot; } ,
        &quot;o&quot;: { &quot;type&quot;: &quot;uri&quot; , &quot;value&quot;: &quot;http://www.w3.org/2002/07/owl#ObjectProperty&quot; }
      } ,
      {
        &quot;s&quot;: { &quot;type&quot;: &quot;uri&quot; , &quot;value&quot;: &quot;http://www.semanticweb.org/joeds/ontologies/2020/3/swotDom
oticProject#belongsTo&quot; } ,
        &quot;p&quot;: { &quot;type&quot;: &quot;uri&quot; , &quot;value&quot;: &quot;http://www.w3.org/1999/02/22-rdf-syntax-ns#type&quot; } ,
        &quot;o&quot;: { &quot;type&quot;: &quot;uri&quot; , &quot;value&quot;: &quot;http://www.w3.org/2002/07/owl#FunctionalProperty&quot; }
      } ,
      {
...
</pre>

### up.sh

Uso: `sh up.sh <arquivo>`

Função: Executa a operação definida no arquivo contra o endpoint de update.

#### Operações de inserção de tripla

Arquivo: umaTripla.spq
```
update= 
    PREFIX dc: <http://purl.org/dc/elements/1.1/> 
    INSERT DATA { 
        <http://example/book1> dc:title "A new book" ; 
                               dc:creator "A.N.Other" 
        . 
    }

```

Arquivo: outraTripla.spq
```
update= 
    PREFIX dc: <http://purl.org/dc/elements/1.1/> 
    INSERT DATA { 
        <http://example/book2> dc:title "A new book2" ; 
                               dc:creator "A.N.Other2" 
        . 
    }

```

Exemplo: 
<pre><font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sparql</b></font>$ sh up.sh outraTripla.spq
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

#### Operação de carga de ontologia armazenada em servidor de terceiro

Arquivo: carregassn.spq

```
update= LOAD <http://www.w3.org/ns/ssn/> 
```

Arquivo: carregasosa.spq

```
update= LOAD <http://www.w3.org/ns/sosa/> 
```

Exemplo: ver exemplo de uso de [RMALL.sh](README.md#rmall-sh)

### qs.sh

Uso: `sh qs.sh <sujeito>`

Função: Lista todas as triplas com o sujeito dado como argumento.

Exemplo: <pre><font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sparql</b></font>$ sh ./qs.sh &quot;&lt;http://example/book2&gt;&quot;
{
  &quot;head&quot;: {
    &quot;vars&quot;: [ &quot;p&quot; , &quot;o&quot; ]
  } ,
  &quot;results&quot;: {
    &quot;bindings&quot;: [
      {
        &quot;p&quot;: { &quot;type&quot;: &quot;uri&quot; , &quot;value&quot;: &quot;http://purl.org/dc/elements/1.1/title&quot; } ,
        &quot;o&quot;: { &quot;type&quot;: &quot;literal&quot; , &quot;value&quot;: &quot;A new book2&quot; }
      } ,
      {
        &quot;p&quot;: { &quot;type&quot;: &quot;uri&quot; , &quot;value&quot;: &quot;http://purl.org/dc/elements/1.1/creator&quot; } ,
        &quot;o&quot;: { &quot;type&quot;: &quot;literal&quot; , &quot;value&quot;: &quot;A.N.Other2&quot; }
      }
    ]
  }
}
</pre>

### rms.sh

Uso: `sh rms.sh <sujeito>`

Função: Remove todas as triplas com o sujeito dado como argumento.

Exemplo:<pre><font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sparql</b></font>$ sh ./rms.sh &quot;&lt;http://example/book2&gt;&quot;
update=DELETE {  &lt;http://example/book2&gt; ?p ?o } WHERE {  &lt;http://example/book2&gt;  ?p ?o. }
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
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sparql</b></font>$ sh ./qs.sh &quot;&lt;http://example/book2&gt;&quot;
{
  &quot;head&quot;: {
    &quot;vars&quot;: [ &quot;p&quot; , &quot;o&quot; ]
  } ,
  &quot;results&quot;: {
    &quot;bindings&quot;: [
      
    ]
  }
}
</pre>

### RMALL.sh

Uso: `sh RMALL.sh`

Função: Remove todas as triplas.

Exemplo:

Neste exemplo mostra-se a remoção de todo o conteúdo do dataset usando `RMALL.sh`, a listagem do dataset vazio usando `la.sh`, a carga de SSN usando `up.sh carregassn.spq` e a listagem (parcial) do dataset usando `la.sh`.

<pre><font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sparql</b></font>$ sh RMALL.sh
update=DELETE { ?s ?p ?o } WHERE { ?s ?p ?o. }
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
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sparql</b></font>$ sh la.sh
{
  &quot;head&quot;: {
    &quot;vars&quot;: [ &quot;s&quot; , &quot;p&quot; , &quot;o&quot; ]
  } ,
  &quot;results&quot;: {
    &quot;bindings&quot;: [
      
    ]
  }
}
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sparql</b></font>$ sh up carregassn.spq 
sh: 0: Can&apos;t open up
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sparql</b></font>$ sh up.sh carregassn.spq 
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
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sparql</b></font>$ sh la.sh
{
  &quot;head&quot;: {
    &quot;vars&quot;: [ &quot;s&quot; , &quot;p&quot; , &quot;o&quot; ]
  } ,
  &quot;results&quot;: {
    &quot;bindings&quot;: [
      {
        &quot;s&quot;: { &quot;type&quot;: &quot;uri&quot; , &quot;value&quot;: &quot;http://purl.org/vocommons/voaf#Vocabulary&quot; } ,
        &quot;p&quot;: { &quot;type&quot;: &quot;uri&quot; , &quot;value&quot;: &quot;http://www.w3.org/1999/02/22-rdf-syntax-ns#type&quot; } ,
        &quot;o&quot;: { &quot;type&quot;: &quot;uri&quot; , &quot;value&quot;: &quot;http://www.w3.org/2002/07/owl#Class&quot; }
      } ,
      {
        &quot;s&quot;: { &quot;type&quot;: &quot;uri&quot; , &quot;value&quot;: &quot;http://xmlns.com/foaf/0.1/Agent&quot; } ,
        &quot;p&quot;: { &quot;type&quot;: &quot;uri&quot; , &quot;value&quot;: &quot;http://www.w3.org/1999/02/22-rdf-syntax-ns#type&quot; } ,
        &quot;o&quot;: { &quot;type&quot;: &quot;uri&quot; , &quot;value&quot;: &quot;http://www.w3.org/2002/07/owl#Class&quot; }
      } ,
      {
        &quot;s&quot;: { &quot;type&quot;: &quot;uri&quot; , &quot;value&quot;: &quot;http://xmlns.com/foaf/0.1/name&quot; } ,
        &quot;p&quot;: { &quot;type&quot;: &quot;uri&quot; , &quot;value&quot;: &quot;http://www.w3.org/1999/02/22-rdf-syntax-ns#type&quot; } ,
        &quot;o&quot;: { &quot;type&quot;: &quot;uri&quot; , &quot;value&quot;: &quot;http://www.w3.org/2002/07/owl#AnnotationProperty&quot; }
      } ,
      {
        &quot;s&quot;: { &quot;type&quot;: &quot;uri&quot; , &quot;value&quot;: &quot;http://purl.org/dc/terms/title&quot; } ,
        &quot;p&quot;: { &quot;type&quot;: &quot;uri&quot; , &quot;value&quot;: &quot;http://www.w3.org/1999/02/22-rdf-syntax-ns#type&quot; } ,
        &quot;o&quot;: { &quot;type&quot;: &quot;uri&quot; , &quot;value&quot;: &quot;http://www.w3.org/2002/07/owl#AnnotationProperty&quot; }
      } ,
      {
        &quot;s&quot;: { &quot;type&quot;: &quot;uri&quot; , &quot;value&quot;: &quot;http://purl.org/dc/terms/description&quot; } ,
        &quot;p&quot;: { &quot;type&quot;: &quot;uri&quot; , &quot;value&quot;: &quot;http://www.w3.org/1999/02/22-rdf-syntax-ns#type&quot; } ,
        &quot;o&quot;: { &quot;type&quot;: &quot;uri&quot; , &quot;value&quot;: &quot;http://www.w3.org/2002/07/owl#AnnotationProperty&quot; }
      } ,
      {
        &quot;s&quot;: { &quot;type&quot;: &quot;uri&quot; , &quot;value&quot;: &quot;http://purl.org/dc/terms/rights&quot; } ,
        &quot;p&quot;: { &quot;type&quot;: &quot;uri&quot; , &quot;value&quot;: &quot;http://www.w3.org/1999/02/22-rdf-syntax-ns#type&quot; } ,
        &quot;o&quot;: { &quot;type&quot;: &quot;uri&quot; , &quot;value&quot;: &quot;http://www.w3.org/2002/07/owl#AnnotationProperty&quot; }
      } ,
      {
...
     </pre>

### qf.sh

Uso: `sh qf.sh <arquivo>`

Função: Executa a consulta especificada no arquivo contra o endpoint QUERY.

Exemplos:

Cria triplas usando `sh up.sh umaTripla.spq` e `sh up.sp outraTripla.spq`, consulta sua criação com `sh qs.sh "<http://example/book1>"` (o formato de retorno é JSON). Em seguida usa as consultas CONSTRUCT e DESCRIBE armazenadas em `constructUmaTripla.spq` e `describeUmaTripla.spq` (o formato de retorno é turtle). Estes dois arquivos são listados abaixo, e o *dump* da execução é apresentado em seguida.

constructUmaTripla.spq
```
query= 
    PREFIX dc: <http://purl.org/dc/elements/1.1/> 
    CONSTRUCT { <http://example/book1> ?p ?o } 
        WHERE { <http://example/book1> ?p ?o } 
```

describeUmaTripla.spq
```
query= 
    PREFIX dc: <http://purl.org/dc/elements/1.1/> 
    DESCRIBE <http://example/book1>
```

<pre><font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sparql</b></font>$ source init.sh
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sparql</b></font>$ sh up.sh umaTripla.spq 
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
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sparql</b></font>$ sh up.sh outraTripla.spq 
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
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sparql</b></font>$ cat umaTripla.spq 
update= 
    PREFIX dc: &lt;http://purl.org/dc/elements/1.1/&gt; 
    INSERT DATA { 
        &lt;http://example/book1&gt; dc:title &quot;A new book&quot; ; 
                               dc:creator &quot;A.N.Other&quot; 
        . 
    }

<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sparql</b></font>$ sh ls.sh &quot;&lt;http://example/book1&gt;&quot;
sh: 0: Can&apos;t open ls.sh
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sparql</b></font>$ sh qs.sh &quot;&lt;http://example/book1&gt;&quot;
{
  &quot;head&quot;: {
    &quot;vars&quot;: [ &quot;p&quot; , &quot;o&quot; ]
  } ,
  &quot;results&quot;: {
    &quot;bindings&quot;: [
      {
        &quot;p&quot;: { &quot;type&quot;: &quot;uri&quot; , &quot;value&quot;: &quot;http://purl.org/dc/elements/1.1/title&quot; } ,
        &quot;o&quot;: { &quot;type&quot;: &quot;literal&quot; , &quot;value&quot;: &quot;A new book&quot; }
      } ,
      {
        &quot;p&quot;: { &quot;type&quot;: &quot;uri&quot; , &quot;value&quot;: &quot;http://purl.org/dc/elements/1.1/creator&quot; } ,
        &quot;o&quot;: { &quot;type&quot;: &quot;literal&quot; , &quot;value&quot;: &quot;A.N.Other&quot; }
      }
    ]
  }
}
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sparql</b></font>$ sh qs.sh &quot;&lt;http://example/book1&gt;&quot;^C
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sparql</b></font>$ sh qf.sh constructUmaTripla.spq 
@prefix schema: &lt;http://schema.org/&gt; .
@prefix :      &lt;http://www.semanticweb.org/joeds/ontologies/2020/3/swotDomoticProject#&gt; .
@prefix owl:   &lt;http://www.w3.org/2002/07/owl#&gt; .
@prefix xsd:   &lt;http://www.w3.org/2001/XMLSchema#&gt; .
@prefix skos:  &lt;http://www.w3.org/2004/02/skos/core#&gt; .
@prefix voaf:  &lt;http://purl.org/vocommons/voaf#&gt; .
@prefix rdfs:  &lt;http://www.w3.org/2000/01/rdf-schema#&gt; .
@prefix ssn:   &lt;http://www.w3.org/ns/ssn/&gt; .
@prefix rdf:   &lt;http://www.w3.org/1999/02/22-rdf-syntax-ns#&gt; .
@prefix xml:   &lt;http://www.w3.org/XML/1998/namespace&gt; .
@prefix dcterms: &lt;http://purl.org/dc/terms/&gt; .
@prefix time:  &lt;http://www.w3.org/2006/time#&gt; .
@prefix vann:  &lt;http://purl.org/vocab/vann/&gt; .
@prefix foaf:  &lt;http://xmlns.com/foaf/0.1/&gt; .
@prefix dc:    &lt;http://purl.org/dc/elements/1.1/&gt; .
@prefix sosa:  &lt;http://www.w3.org/ns/sosa/&gt; .
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sparql</b></font>$ sh qf.sh constructUmaTripla.spq 
@prefix schema: &lt;http://schema.org/&gt; .
@prefix :      &lt;http://www.semanticweb.org/joeds/ontologies/2020/3/swotDomoticProject#&gt; .
@prefix owl:   &lt;http://www.w3.org/2002/07/owl#&gt; .
@prefix xsd:   &lt;http://www.w3.org/2001/XMLSchema#&gt; .
@prefix skos:  &lt;http://www.w3.org/2004/02/skos/core#&gt; .
@prefix voaf:  &lt;http://purl.org/vocommons/voaf#&gt; .
@prefix rdfs:  &lt;http://www.w3.org/2000/01/rdf-schema#&gt; .
@prefix ssn:   &lt;http://www.w3.org/ns/ssn/&gt; .
@prefix rdf:   &lt;http://www.w3.org/1999/02/22-rdf-syntax-ns#&gt; .
@prefix xml:   &lt;http://www.w3.org/XML/1998/namespace&gt; .
@prefix dcterms: &lt;http://purl.org/dc/terms/&gt; .
@prefix time:  &lt;http://www.w3.org/2006/time#&gt; .
@prefix vann:  &lt;http://purl.org/vocab/vann/&gt; .
@prefix foaf:  &lt;http://xmlns.com/foaf/0.1/&gt; .
@prefix dc:    &lt;http://purl.org/dc/elements/1.1/&gt; .
@prefix sosa:  &lt;http://www.w3.org/ns/sosa/&gt; .

&lt;http://example/book1&gt;
        dc:creator  &quot;A.N.Other&quot; ;
        dc:title    &quot;A new book&quot; .
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sparql</b></font>$ sh qf.sh describeUmaTripla.spq 
@prefix schema: &lt;http://schema.org/&gt; .
@prefix :      &lt;http://www.semanticweb.org/joeds/ontologies/2020/3/swotDomoticProject#&gt; .
@prefix owl:   &lt;http://www.w3.org/2002/07/owl#&gt; .
@prefix xsd:   &lt;http://www.w3.org/2001/XMLSchema#&gt; .
@prefix skos:  &lt;http://www.w3.org/2004/02/skos/core#&gt; .
@prefix voaf:  &lt;http://purl.org/vocommons/voaf#&gt; .
@prefix rdfs:  &lt;http://www.w3.org/2000/01/rdf-schema#&gt; .
@prefix ssn:   &lt;http://www.w3.org/ns/ssn/&gt; .
@prefix rdf:   &lt;http://www.w3.org/1999/02/22-rdf-syntax-ns#&gt; .
@prefix xml:   &lt;http://www.w3.org/XML/1998/namespace&gt; .
@prefix dcterms: &lt;http://purl.org/dc/terms/&gt; .
@prefix time:  &lt;http://www.w3.org/2006/time#&gt; .
@prefix vann:  &lt;http://purl.org/vocab/vann/&gt; .
@prefix foaf:  &lt;http://xmlns.com/foaf/0.1/&gt; .
@prefix dc:    &lt;http://purl.org/dc/elements/1.1/&gt; .
@prefix sosa:  &lt;http://www.w3.org/ns/sosa/&gt; .

&lt;http://example/book1&gt;
        dc:creator  &quot;A.N.Other&quot; ;
        dc:title    &quot;A new book&quot; .
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sparql</b></font>$ 

</pre>

### Informação sobre o contexto

Em SPARQL há quatro tipos de consultas: SELECT, CONSTRUCT, ASK, DESCRIBE. Documentação [aqui](https://www.w3.org/TR/2008/REC-rdf-sparql-query-20080115/#QueryForms).

O conteúdo e formato de retorno é diferente para cada tipo. Se existe forma de mudar esse formato na configuração do servidor web (ex. configuração do Fuseki), ainda não encontrei. No ajuste padrão da versão de Fuseki que estou usando, SELECT retorna em JSON, CONSTRUCT e DESCRIBE retornam em TURTLE.

### Referências para este script

- https://www.google.com/search?channel=fs&client=ubuntu&q=construct+query+sparql
- https://www.w3.org/TR/rdf-sparql-query/#construct
- https://www.google.com/search?q=jena+fuseki+sparql+set+response+type+to+xml&client=ubuntu&channel=fs&sxsrf=ALeKk02g11hROPddhnlrTu9AoSecmZT76Q%3A1619829035686&ei=K6GMYJ-dKaqU5OUP8KqfuAo&oq=jena+fuseki+sparql+set+response+type+to+xml&gs_lcp=Cgdnd3Mtd2l6EAM6BwgAEEcQsAM6BwgjELACECdQ95wDWNT7A2DJ_QNoBnACeACAAa4BiAH1H5IBBDAuMzWYAQCgAQGqAQdnd3Mtd2l6yAEIwAEB&sclient=gws-wiz&ved=0ahUKEwjf3pKynafwAhUqCrkGHXDVB6cQ4dUDCA0&uact=5
- https://github.com/RDFLib/sparqlwrapper/issues/159
- https://jena.apache.org/documentation/fuseki2/fuseki-config-endpoint.html
- https://stackoverflow.com/questions/64646788/sparqlwrapper-cant-make-construct-query-return-other-than-xml
- https://jena.apache.org/documentation/io/rdfxml_howto.html
- https://www.w3.org/2009/Talks/0615-qbe/
- https://docs.oracle.com/database/121/RDFRM/rdf-jena.htm#RDFRM234
- https://stackoverflow.com/questions/50370001/querying-against-a-wikipedia-rdf-file-turtle-format-with-apache-jena
- https://jena.apache.org/tutorials/
- https://jena.apache.org/tutorials/sparql.html
- https://www.google.com/search?channel=fs&client=ubuntu&q=set+return+format+in+sparql
- https://sparqlwrapper.readthedocs.io/en/latest/SPARQLWrapper.Wrapper.html
- https://www.w3.org/TR/2013/REC-rdf-sparql-XMLres-20130321/
- https://www.w3.org/TR/2008/REC-rdf-sparql-query-20080115/#QueryForms
- https://www.w3.org/TR/2008/REC-rdf-sparql-query-20080115/#describe


## Próximos passos

- (2021-04-28T15:43:32-03) Verificar se alguma consulta SPARQL retorna resposta em ~~RDF:XML~~ qualquer formato que puder ser lido em um Jena.Model, que pode ser armazenada e trabalhada em um *reasoner* Jena. CONSTRUCT pode resolver; (vou considerar FEITO (2021-04-30T22:11:00-03) )
   - consegui com CONSTRUCT que a resposta seja em turtle. Ver `qf.sh`;
   - consegui com DESCRIBE uma consulta mais compacta. Ver `qf.sh`.
- (2021-04-28T15:43:32-03) Criar uma consulta que carregue ontologias em um dataset. ~~Seja em arquivo remoto (como em SPARQL:LOAD)~~ (FEITO (2021-04-29T09:11:00-03) , ver up), seja a partir de um arquivo local.
- (2021-04-30T22:11:00-03) Criar o sub-grafo que representa a placa no grafo de conhecimento e incorporá-lo à base de conhecimento armazenada no servidor Fuseki do grupo;
- (2021-04-30T22:11:00-03) Criar um programa em Java + JENA que faça uma consulta, recupere os sosa:Actuator, os respectivos sosa:Procedure e faça a requisição que corresponde a uma atuação. Estudar as dificuldades e alternativas.

## Referências

- https://stackoverflow.com/questions/7366775/what-does-the-line-bin-sh-mean-in-a-unix-shell-script
- https://superuser.com/questions/149329/what-is-the-curl-command-line-syntax-to-do-a-post-request
- https://www.baeldung.com/linux/bash-variables-export
- https://stackoverflow.com/questions/15912924/how-to-send-file-contents-as-body-entity-using-curl
- http://vos.openlinksw.com/owiki/wiki/VOS/VirtTipsAndTricksSPARQL11Delete#DELETE%20DATA%20Examples
- https://www.w3.org/TR/sparql11-update/
- https://www.baeldung.com/linux/use-command-line-arguments-in-bash-script
- https://en.wikipedia.org/wiki/Percent-encoding
- https://www.w3schools.com/tags/ref_urlencode.ASP

## Referências para os próximos passos

- https://stackoverflow.com/questions/45192163/rdf-format-output-from-fuseki-1-0
- https://www.futurelearn.com/info/courses/linked-data/0/steps/16104

