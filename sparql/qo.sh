#!/bin/sh

# tive dificuldade com o curl interpretando a URI que uso como sujeito da query como 
# URL a acessar. É uma questão de sintaxe do conteúdo do -d.
# a solução está na resposta do Ciro Santilli para a questão abaixo:  
# https://superuser.com/questions/149329/what-is-the-curl-command-line-syntax-to-do-a-post-request
# não é a primeira resposta!
# tive dificuldade semelhante, agora com o interpretador do shell, porque
# ele interpreta o angle bracket como redirecionamento para resolver isso, 
# envolver com aspas duplas.
# comando resultante: sh ./qs.sh "<http://example/book2>"

echo "query=SELECT * WHERE {  ?s ?p " $1 ". }" | curl -X POST -d @- $QUERY


# curl -X POST -d "query=select ?s where { ?s ?p ?o . }" ip-50-62-81-50.ip.secureserver.net:8080/fuseki/testeFabio/query


