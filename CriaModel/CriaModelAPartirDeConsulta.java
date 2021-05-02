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

