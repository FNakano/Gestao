#!/bin/sh
# sobre shebang: 
# https://stackoverflow.com/questions/7366775/what-does-the-line-bin-sh-mean-in-a-unix-shell-script
# executar com source init.sh para que as variáveis sejam criadas no mesmo shell em que 
# é executado (e não no subshell criado para execução de init.sn.
# ver: https://www.baeldung.com/linux/bash-variables-export

# export QUERY=http://ip-50-62-81-50.ip.secureserver.net:8080/fuseki/testeFabio/query
# export UPDATE=http://ip-50-62-81-50.ip.secureserver.net:8080/fuseki/testeFabio/update

export QUERY=https://swot-fuseki.herokuapp.com/Placa/query
export UPDATE=https://swot-fuseki.herokuapp.com/Placa/update

