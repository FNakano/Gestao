# Carregar SSN e SOSA no Fuseki em servidor local.

Os namespaces que contém as ontologias estão na [documentação das ontologias](https://www.w3.org/TR/vocab-ssn/).

## Recursos

SO: Eu uso Linux, mas não deve ser problema usar Windows com powershell.

curl: está instalado no Linux por padrão. Acredito que também seja assim no powershell. Caso você tenha usado no powershell, por favor me avise.

Fuseki [instruções para instalação aqui](https://github.com/santanajods/domotic-swot#rodando-fuseki-server)

## Procedimento

1. Criar o dataset MeuSSN (no meu caso, removi e recriei o dataset)
   - [Captura de tela da recriação de MeuSSN](Imagens/Captura%20de%20tela%20de%202021-02-05%2009-38-11.png)
2. No terminal, execute o comando abaixo para carregar SSN
   - `curl -X POST -d 'update= LOAD <http://www.w3.org/ns/ssn/> ' localhost:3030/MeuSSN/update`
   - [Captura de tela da carga de SSN](Imagens/Captura%20de%20tela%20de%202021-02-05%2009-39-16.png)
   - [Página de consulta ao dataset após carga de SSN](Imagens/Captura%20de%20tela%20de%202021-02-05%2009-40-27.png)
3. No terminal, execute o comando abaixo para carregar SOSA
   - `curl -X POST -d 'update= LOAD <http://www.w3.org/ns/sosa/> ' localhost:3030/MeuSSN/update`
   - [Captura de tela da carga de SOSA](Imagens/Captura%20de%20tela%20de%202021-02-05%2009-40-47.png)
   - [Página de consulta ao dataset após carga de SOSA](Imagens/Captura%20de%20tela%20de%202021-02-05%2009-41-10.png)


