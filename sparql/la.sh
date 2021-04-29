#!/bin/sh

curl -X POST -d 'query=SELECT * WHERE { ?s ?p ?o. }' $QUERY


# curl -X POST -d "query=select ?s where { ?s ?p ?o . }" ip-50-62-81-50.ip.secureserver.net:8080/fuseki/testeFabio/query


