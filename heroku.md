# Tentativas com Heroku

**estado**: construção contínua

## Introdução

Este texto está mais para uma coleção de resultados, não é propriamente um relatório.

recomendo a leitura da [descrição na wikipedia](https://en.wikipedia.org/wiki/Heroku) pois traz uma idéia do que é e de alguns conceitos usados na ferramenta.

Heroku é um serviço que oferece uma plataforma na nuvem para implantar outros serviços na nuvem. Desenvolvimento e testes podem ser feitos localmente, inclusive da interface no navegador. 

Para poder implantar no Heroku, é necessário construir o serviço de acordo com o que é oferecido pela plataforma.

Heroku não oferece uma máquina virtual, como fazem Linode e EC2, e não oferece um sistema de arquivos para escrita. Ele oferece *slugs*, que são *containers* para os dados (por exemplo páginas estáticas e imagem do executável do serviço do usuário), *dynos*, que são máquinas de execução, e, armazenamento em um banco de dados POSTGRES.

A visão geral do funcionamento de Heroku e do vocabulário usado na documentação, em especial de conceitos particulares a Heroku, é esclarecido [aqui](https://devcenter.heroku.com/articles/how-heroku-works).

A fim de facilitar a criação (local) do código, padronizar sua estrutura e compilação, Heroku usa maven.

A fim de implantar o sistema do usuário na nuvem, Heroku usa git.

Há (pelo menos) duas interfaces de configuração: O dashboard, acessado com navegador pelo site heroku.com [imagem](Imagens/Captura%20de%20tela%20de%202021-01-24%2016-55-45.png), e a interface de linha de comando (ou CLI) [imagem da instalação no Ubuntu 20.04LTS](Imagens/Captura%20de%20tela%20de%202021-01-25%2009-47-40.png), um programa executado localmente com o comando `heroku`.

[Instruções para instalar e usar o cliente](https://devcenter.heroku.com/articles/heroku-cli)

[Instruções para implantar](https://devcenter.heroku.com/categories/deployment)

[Instruções para implantar usando git](https://devcenter.heroku.com/articles/git)

O usuário pode escrever seu serviço em várias linguagens de programação. Acredito que, para o meu propósito, Java é a melhor linguagem.

[Instruções para implantar código em Java](https://devcenter.heroku.com/categories/java-support)

Seguirei alguns exemplos, documentando como resultado.

## Terminologia

Explica o que é  *dyno*, *slug*, *Procfiles*, *Buildpacks*, *release*.

- Dynos are isolated, virtualized Unix containers, that provide the environment required to run an application.
- Procfiles list process types - named commands that you may want executed.
- Deploying applications involves sending the application to Heroku using either Git, GitHub, or via an API.
- Buildpacks lie behind the slug compilation process. Buildpacks take your application, its dependencies, and the language runtime, and produce slugs.
- A slug is a bundle of your source, fetched dependencies, the language runtime, and compiled/generated output of the build system - ready for execution.
- Config vars contain customizable configuration data that can be changed independently of your source code. The configuration is exposed to a running application via environment variables.
- Add-ons are third party, specialized, value-added cloud services that can be easily attached to an application, extending its functionality.
- A release is a combination of a slug (your application), config vars and add-ons. Heroku maintains an append-only ledger of releases you make.

## Objetivo Principal

Executar Fuseki, ou algo equivalente, na plataforma Heroku.

## Método

À medida que eu for construindo jeitos de trabalhar (significados), na minha opinião, explicáveis e úteis na direção de atingir o objetivo, acrescento aqui como texto ou como link, na seção Resultados.

Como este relatório vai sendo escrito durante o processo (exploratório) até chegar ao objetivo, muitos resultados são *accomplishment*s e não *achievement*s (conforme definidos em PlansLite). Ié são qualificados como feitos ou conquistas mas não precisam ser consequências das tarefas que levam ao objetivo. Consequentemente, alguns resultados apresentados aqui não fazem parte de uma sequência de atividades para atingir o objetivo principal. No momento não se sabe que atividades, nem em que sequência, permitem atingir o objetivo principal.

A ordem de apresentação dos resultados no texto não precisa refletir a ordem cronológica em que esses resultados foram sendo obtidos.

## Resultados


## Criar uma conta

## Criar um app

## Seguir o tutorial para implantar em Java 

[Tutorial](https://devcenter.heroku.com/articles/getting-started-with-java?singlepage=true)

O tutorial recomenda baixar um exemplo pronto, [clonando do github](https://github.com/heroku/java-getting-started). As instruções do readme do repositório são bem mais sintéticas que as do artigo de Heroku. Em quatro linhas executa localmente, em três implanta e executa no Heroku.

Este exemplo usa Spring, então fui ver como funciona. Em princípio, algumas anotações no código Java servem para indicar que método deve ser usado em resposta a que requisição. O valor de retorno do método é o nome do arquivo.

https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/SpringApplication.html
https://spring.io/
https://spring.io/quickstart
https://www.baeldung.com/spring-requestmapping
https://springframework.guru/spring-requestmapping-annotation/
https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/RequestMapping.html
https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/GetMapping.html

A organização dos arquivos é baseada em um MVC.

https://pt.wikipedia.org/wiki/MVC
https://www.logicbig.com/tutorials/spring-framework/spring-web-mvc/spring-mvc-intro.html
https://docs.spring.io/spring-framework/docs/3.2.x/spring-framework-reference/html/mvc.html

Então, incluindo no código de Main.java as linhas:

``` java
  // https://spring.io/
  // @GetMapping("/helloworld")
  @RequestMapping("/helloworld")
  public String hello() {
  //  return "Hello World!";
    return "hello";
  } 

```

e incluindo em `java-getting-started/src/main/resources/templates$ ` um arquivo `hello.html` [imagem](Imagens/Captura%20de%20tela%20de%202021-01-26%2009-49-28.png), e executando `mvn install` [imagem](Imagens/Captura%20de%20tela%20de%202021-01-26%2009-49-49.png) para compilar e `heroku local:start`, devo conseguir acessar `localhost:5000/helloworld`

![Captura de Tela](Imagens/Captura%20de%20tela%20de%202021-01-26%2010-04-20.png)

**notas**: Nesta configuração, `@RequestMapping` informa qual o nome da página [imagem](Imagens/Captura%20de%20tela%20de%202021-01-26%2009-34-55.png). `@GetMapping` dá erro de compilação [imagem](Imagens/Captura%20de%20tela%20de%202021-01-26%2009-35-37.png).

Com isto já dá para pensar em ter um subconjunto de Fuseki sendo executado sobre uma base de conhecimento carregada dos templates, que recebe novas triplas e as armazena em memória.

Outra alternativa seria usar JDBC e o POSTGRES do Heroku.

Heroku é muito aderente a Maven, então segue alguma informação:


Maven Phases

Although hardly a comprehensive list, these are the most common default lifecycle phases executed.

-   validate: validate the project is correct and all necessary information is available
-   compile: compile the source code of the project
-   test: test the compiled source code using a suitable unit testing framework. These tests should not require the code be packaged or deployed
-   package: take the compiled code and package it in its distributable format, such as a JAR.
-   integration-test: process and deploy the package if necessary into an environment where integration tests can be run
-   verify: run any checks to verify the package is valid and meets quality criteria
-   install: install the package into the local repository, for use as a dependency in other projects locally
-   deploy: done in an integration or release environment, copies the final package to the remote repository for sharing with other developers and projects.

There are two other Maven lifecycles of note beyond the default list above. They are

-   clean: cleans up artifacts created by prior builds
-   site: generates site documentation for this project

Referência [aqui](https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html)

## Seguir o tutorial para implantar WAR através de Webapp-runner

[Tutorial](https://devcenter.heroku.com/articles/java-webapp-runner)

## Compilar

Entrar na pasta do app que quer compilar e executar: `mvn install`

## Executar localmente

Entrar na pasta do app que quer executar e executar: `heroku local:start`

Não posso ter dois consoles executando simultaneamente.



## Idéias

Talvez seja possível criar um war do Fuseki para Heroku: https://devcenter.heroku.com/articles/war-deployment



Nos [documentos](https://devcenter.heroku.com/articles/setting-the-http-port-for-java-applications), está escrito que usa Spring Boot (entre outros). Já vi isso em Ontmalizer e na IC do Joedson, então fui ver o que é:

- https://spring.io/projects/spring-boot
- https://spring.io/guides/gs/spring-boot/





Consegui 

## Dúvida git:

Clonei de github mas dei push em heroku. Isto quer dizer que substituí a referência para o repositório remoto do github para o heroku?? Esse heroku em especial é meu, privado? Como a operação é transparente, ficam essas perguntas.


## Criar um app

## Executar em modo local

`heroku local:start`

## Executar no heroku

## Discussão e Conclusão

Consegui fechar uma história.




