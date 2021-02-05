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

## Teste

Inseri uma instância. A primeira do [exemplo do Joedson](https://github.com/santanajods/domotic-swot#inser%C3%A7%C3%A3o-de-um-novo-dispositivo). O resultado foi 200-Success, mas não ficou do jeito que eu queria...

``` shell
curl -X POST -d 'update= 
PREFIX ssn: <http://www.w3.org/ns/ssn/>
PREFIX sosa: <http://www.w3.org/ns/sosa/>
PREFIX : <undefined>
prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#>
prefix owl: <http://www.w3.org/2002/07/owl#>

INSERT DATA{
    :sala-tv-1 a owl:NamedIndividual, :Room, sosa:Platform ;
    sosa:hosts :light-sensor-sala-tv-1 ;
    sosa:hosts :lampada-sala-tv-1-switch ;
    ssn:implements :switch-on-lampada-sala-tv-1 ;
    ssn:implements :switch-off-lampada-sala-tv-1 .

};' localhost:3030/MeuSSN/update

```

[Captura da tela com execução do comando](Imagens/Captura%20de%20tela%20de%202021-02-05%2013-38-55.png)

![Captura da tela consultando na interface com usuário](/Imagens/Captura%20de%20tela%20de%202021-02-05%2013-24-25.png)


