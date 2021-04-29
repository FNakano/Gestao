#!/bin/sh

# echo curl -X POST -d @$1 $UPDATE  # escreve na tela sem executar

curl -X POST -d @$1 $UPDATE

# curl -X POST -d "query=select ?s where { ?s ?p ?o . }" ip-50-62-81-50.ip.secureserver.net:8080/fuseki/testeFabio/query


