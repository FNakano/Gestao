# Cria jena.Model a partir de consulta.

## Apresentação

Há [quatro formas de consultas](https://www.w3.org/TR/rdf-sparql-query/#QueryForms) SPARQL, que diferem sobre a informação retornada e sua apresentação.

Frequentemente é conveniente baixar e manipular localmente um sub-grafo de um grafo de conhecimento armazenado na nuvem.

Uma consulta [CONSTRUCT](https://www.w3.org/TR/rdf-sparql-query/#construct) sobre grafos de conhecimento remotos gera sub-grafos locais. Caso a consulta seja feita por um programa em Java/Jena, esse sub-grafo pode ser armazenado diretamente em um [jena.Model](https://jena.apache.org/documentation/javadoc/jena/org/apache/jena/rdf/model/Model.html).


## Objetivo

Criar um programa Java/Jena que consulta uma base de conhecimento remota, armazena o resultado em um jena.Model local e o imprime na tela.

## Método

Ajustar o código criado em [Explorar o TTL lido](../ExplorarOTTLLido/README.md), incorporando idéias de [ProgramCreek1]( https://www.programcreek.com/java-api-examples/?api=org.apache.jena.query.Query) e [ProgramCreek2](https://www.programcreek.com/java-api-examples/?api=org.apache.jena.fuseki.main.FusekiServer), criar o programa.

### Código-fonte

```java
/* 
Criado a partir de https://github.com/FNakano/Gestao/tree/main/ExplorarOTTLLido
2021-05-02 - Iniciado.
comando de compilação: javac -Xlint:deprecation -cp '.:/home/fabio/apache-jena-3.17.0/lib/*' CriaModelAPartirDeConsulta.java 
comando de execução: java -cp '.:/home/fabio/apache-jena-3.17.0/lib/*' CriaModelAPartirDeConsulta

*/

//package jena.examples.rdf ;

import org.apache.jena.rdf.model.*;
import org.apache.jena.util.FileManager;

import org.apache.jena.rdfconnection.*; // https://jena.apache.org/documentation/javadoc/rdfconnection/org/apache/jena/rdfconnection/RDFConnection.html
import org.apache.jena.query.*; // https://www.programcreek.com/java-api-examples/?api=org.apache.jena.query.Query

import java.io.*;

public class CriaModelAPartirDeConsulta {

    static final String queryURL="http://ip-50-62-81-50.ip.secureserver.net:8080/fuseki/testeFabio/query";                              

    static final String queryBody="CONSTRUCT\n" +
                                        "{\n" +
                                        "  ?s ?p ?o\n" +
                                        "}\n" +
                                        "WHERE\n" +
                                        "{\n" +
                                        "  ?s ?p ?o\n" +
                                        "}";

    public static void main (String args[]) {

        RDFConnection testePlaca=null;  // só para inicializar e eliminar o erro
        Model model=null; // 'might not have been initialized'. Solução rápida.
        try {
            testePlaca = RDFConnectionFactory.connect(queryURL) ;
        } catch (Exception e) {
            System.out.println ("Erro ao tentar estabelecer conexão rdf.");
            e.printStackTrace();
            System.exit(0);
        }

        Query q = QueryFactory.create(queryBody);
        try {
            model=testePlaca.queryConstruct(q);
        } catch (Exception e) {
            System.out.println ("Erro ao tentar executar consulta.");
            e.printStackTrace();
            System.exit(0);
        }

        // write it to standard out
        model.write(System.out);            
    }
}

```
[Baixar arquivo](./CriaModelAPartirDeConsulta.java)

O endpoint do servidor Fuseki para consultas é `queryURL`, o corpo da consulta é `queryBody`. Consulta-se a base de conhecimento por todas as triplas. A consulta pode ser ajustada para triplas específicas, filtradas e ordenadas.

No código, a inicialização das variáveis é feita para evitar o erro de "variável não inicializada", mas, em determinados casos, pode não ser a solução mais conveniente.
 
O código contido no primeiro `try` cria um objeto do tipo conexão, para conectar-se ao servidor. 

O código contido no segundo `try` faz a consulta e armazena em um modelo cuja referência é a variável `model`. 

A última linha escreve o grafo na tela.

Compilação: `javac -Xlint:deprecation -cp '.:/home/fabio/apache-jena-3.17.0/lib/*' CriaModelAPartirDeConsulta.java`

Execução: `java -cp '.:/home/fabio/apache-jena-3.17.0/lib/*' CriaModelAPartirDeConsulta`

### Execução do código.

<pre><font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sobreWebSemantica/FrameworkIoT/raciocinador</b></font>$ javac -Xlint:deprecation -cp &apos;.:/home/fabio/apache-jena-3.17.0/lib/*&apos; CriaModelAPartirDeConsulta.java 
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sobreWebSemantica/FrameworkIoT/raciocinador</b></font>$ java -cp &apos;.:/home/fabio/apache-jena-3.17.0/lib/*&apos; CriaModelAPartirDeConsulta
&lt;rdf:RDF
    xmlns:rdf=&quot;http://www.w3.org/1999/02/22-rdf-syntax-ns#&quot;
    xmlns:schema=&quot;http://schema.org/&quot;
    xmlns:voaf=&quot;http://purl.org/vocommons/voaf#&quot;
    xmlns:rdfs=&quot;http://www.w3.org/2000/01/rdf-schema#&quot;
    xmlns:dcterms=&quot;http://purl.org/dc/terms/&quot;
    xmlns:dc=&quot;http://purl.org/dc/elements/1.1/&quot;
    xmlns:time=&quot;http://www.w3.org/2006/time#&quot;
    xmlns:owl=&quot;http://www.w3.org/2002/07/owl#&quot;
    xmlns:sosa=&quot;http://www.w3.org/ns/sosa/&quot;
    xmlns:skos=&quot;http://www.w3.org/2004/02/skos/core#&quot;
    xmlns=&quot;http://www.semanticweb.org/joeds/ontologies/2020/3/swotDomoticProject#&quot;
    xmlns:ssn=&quot;http://www.w3.org/ns/ssn/&quot;
    xmlns:vann=&quot;http://purl.org/vocab/vann/&quot;
    xmlns:foaf=&quot;http://xmlns.com/foaf/0.1/&quot;
    xmlns:xsd=&quot;http://www.w3.org/2001/XMLSchema#&quot;&gt;
  &lt;owl:Class rdf:about=&quot;http://www.w3.org/ns/ssn/System&quot;&gt;
    &lt;rdfs:subClassOf&gt;
      &lt;owl:Restriction&gt;
        &lt;owl:onProperty rdf:parseType=&quot;Resource&quot;&gt;
          &lt;owl:inverseOf&gt;
            &lt;owl:ObjectProperty rdf:about=&quot;http://www.w3.org/ns/ssn/hasSubSystem&quot;/&gt;
          &lt;/owl:inverseOf&gt;
</pre>

## Referências adicionais

- https://jena.apache.org/documentation/javadoc/rdfconnection/org/apache/jena/rdfconnection/RDFConnection.html
- https://jena.apache.org/documentation/javadoc/rdfconnection/org/apache/jena/rdfconnection/RDFConnectionFactory.html
- https://github.com/FNakano/Gestao/tree/main/ExplorarOTTLLido
- https://www.w3.org/TR/rdf-sparql-query/#QueryForms
- https://jena.apache.org/documentation/javadoc/jena/org/apache/jena/rdf/model/Model.html
- https://jena.apache.org/documentation/javadoc/arq/org/apache/jena/query/Query.html
- https://jena.apache.org/documentation/javadoc/arq/org/apache/jena/query/QueryFactory.html

