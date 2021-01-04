# Instalar Jena e testar se instalação foi feita com sucesso.

**estado do documento**: concluído, não pretendo fazer atualizações.

## Objetivo

Instalar Jena e testar se instalação foi feita com sucesso.

## Pré-condições:

*Sistema Operacional*

<pre><font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sobreJena/programas/Tutorial1</b></font>$ cat /etc/os-release 
NAME=&quot;Ubuntu&quot;
VERSION=&quot;20.04.1 LTS (Focal Fossa)&quot;
ID=ubuntu
ID_LIKE=debian
PRETTY_NAME=&quot;Ubuntu 20.04.1 LTS&quot;
VERSION_ID=&quot;20.04&quot;
HOME_URL=&quot;https://www.ubuntu.com/&quot;
SUPPORT_URL=&quot;https://help.ubuntu.com/&quot;
BUG_REPORT_URL=&quot;https://bugs.launchpad.net/ubuntu/&quot;
PRIVACY_POLICY_URL=&quot;https://www.ubuntu.com/legal/terms-and-policies/privacy-policy&quot;
VERSION_CODENAME=focal
UBUNTU_CODENAME=focal
</pre>

*JDK*

<pre><font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sobreJena/programas/Tutorial1</b></font>$ javac --version
javac 11.0.9.1
</pre>

**nota:** é open-jdk, ou default-jdk. Com certeza não é o JDK da Oracle.

## Instruções para instalação (método)

1. Baixa de <https://jena.apache.org/download/index.cgi>, 
2. ajusta a variável de ambiente em `.profile` e 
3. chama `sparql --version`, conforme <https://jena.apache.org/documentation/tools/>

*PATH* (depois de ajustar a variável de ambiente, conforme <https://jena.apache.org/documentation/tools/>)

<pre><font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~</b></font>$ echo $PATH
/home/fabio/.local/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/usr/games:/usr/local/games:/snap/bin:/home/fabio/apache-jena-3.17.0/bin
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~</b></font>$ 
</pre>

*Checando se executa algo*
<pre><font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~</b></font>$ sparql --version
Jena:       VERSION: 3.17.0
Jena:       BUILD_DATE: 2020-11-25T19:40:23+0000
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~</b></font>$ 
</pre>

## Resultados

Instalado.

**Resultado Inesperado**: Jena tem um conjunto de ferramentas de linha de comando. É possível testar a instalação pela execução das ferramentas. Talvez seja possível fazer CRUD com as ferramentas de linha de comando.

### Teste da instalação de Jena com as ferramentas de linha de comando.

A documentação das ferramentas de linha de comando parece estar desatualizada: Ela instrui para usar comandos como `arq.query`, que parecem ser nomes de scripts na pasta $JENA_HOME/bin, mas digitando na linha de comando dá `command not found` e não existe esse arquivo na pasta indicada. Por outro lado, existe `arq` e executando `arq --home`, ele é executado.

Segui [este tutorial](https://jena.apache.org/tutorials/sparql_query1.html). O resultado está a seguir.

<pre><font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sobreJena</b></font>$ sparql --help
sparql --data=&lt;file&gt; --query=&lt;query&gt;
  Control
      --explain              Explain and log query execution
      --repeat=N or N,M      Do N times or N warmup and then M times (use for timing to overcome start up costs of Java)
      --optimize=            Turn the query optimizer on or off (default: on)
  Time
      --time                 Time the operation
  Query Engine
      --engine=EngineName    Register another engine factory[ref]
      --unengine=EngineName   Unregister an engine factory
  Dataset
      --data=FILE            Data for the dataset - triple or quad formats
      --graph=FILE           Graph for default graph of the datset
      --namedGraph=FILE      Add a graph into the dataset as a named graph
  Results
      --results=             Results format (Result set: text, XML, JSON, CSV, TSV; Graph: RDF serialization)
      --desc=                Assembler description file
  Query
      --query, --file        File containing a query
      --syntax, --in         Syntax of the query
      --base                 Base URI for the query
  Symbol definition
      --set                  Set a configuration symbol to a value
  General
      -v   --verbose         Verbose
      -q   --quiet           Run with minimal output
      --debug                Output information for debugging
      --help
      --version              Version information
      --strict               Operate in strict SPARQL mode (no extensions of any kind)
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sobreJena</b></font>$ sparql --file q1.rq
-----
| x |
=====
-----
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sobreJena</b></font>$ cat q1.rq 
SELECT ?x
WHERE
 { ?x &lt;http://www.w3.org/2001/vcard-rdf/3.0#FN&gt; &quot;John Smith&quot; }

<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sobreJena</b></font>$ sparql --data=vc-db-1.rdf  --file=q1.rq
--------------------------------
| x                            |
================================
| &lt;http://somewhere/JohnSmith&gt; |
--------------------------------
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sobreJena</b></font>$ 


Seguindo <https://jena.apache.org/tutorials/sparql_basic_patterns.html>:

</pre>

<pre><font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sobreJena</b></font>$ sparql --data=vc-db-1.rdf  --file=g-bp.rq
Failed to load Query: Not found: g-bp.rq
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sobreJena</b></font>$ ls
diario.md  q1.rq  q-bp1.rq  vc-db-1.rdf
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sobreJena</b></font>$ sparql --data=vc-db-1.rdf  --file=q-bp1.rq
---------------------------------------------------
| x                               | name          |
===================================================
| &lt;http://somewhere/JohnSmith&gt;    | &quot;John Smith&quot;  |
| &lt;http://somewhere/SarahJones&gt;   | &quot;Sarah Jones&quot; |
| &lt;http://somewhere/MattJones&gt;    | &quot;Matt Jones&quot;  |
| &lt;http://somewhere/RebeccaSmith&gt; | &quot;Becky Smith&quot; |
---------------------------------------------------
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sobreJena</b></font>$ 
</pre>

**Resultado**: é possivel fazer consultas sparql `SELECT` em linha de comando.

**Decisão, novo objetivo**: Checar se é possível fazer CRUD com as ferramentas de linha de comando que acompanham o pacote.

Tentei uma query `INSERT`: ins1.rq, listada abaixo:

```
PREFIX dc: <http://purl.org/dc/elements/1.1/>
INSERT DATA
{ 
  <http://example/book1> dc:title "A new book" ;
                         dc:creator "A.N.Other" .
}
```

executada com `sparql --data=vc-db-1.rdf  --file=ins1.rq`

recebi como resposta:

<pre><font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sobreJena</b></font>$ sparql --data=vc-db-1.rdf  --file=ins1.rq
Encountered &quot; &lt;INSERT_DATA&gt; &quot;INSERT DATA &quot;&quot; at line 2, column 1.
Was expecting one of:
    &quot;base&quot; ...
    &quot;prefix&quot; ...
    &quot;select&quot; ...
    &quot;json&quot; ...
    &quot;describe&quot; ...
    &quot;construct&quot; ...
    &quot;ask&quot; ...
    
</pre>

**Resultado**: acho que em linha de comando não dá para fazer `INSERT`.

**Decisão, novo objetivo**: explorar os tutoriais de código: <https://jena.apache.org/tutorials/rdf_api.html>

FEITO. Documentado [aqui](ExecucaoTutoriaisJena.md)

