# Tentativas com Heroku

**estado**: construção contínua

## Introdução

Este texto está mais para uma coleção de resultados, não é propriamente um relatório.

recomendo a leitura da [descrição na wikipedia](https://en.wikipedia.org/wiki/Heroku) pois traz uma idéia do que é e de alguns conceitos usados na ferramenta.

Heroku é um serviço que oferece uma plataforma na nuvem para implantar outros serviços na nuvem. Desenvolvimento e testes podem ser feitos localmente, inclusive da interface no navegador. 

Para poder implantar no Heroku, é necessário construir o serviço de acordo com o que é oferecido pela plataforma.

Heroku não oferece uma máquina virtual, como fazem Linode e EC2, e não oferece um sistema de arquivos para escrita. Ele oferece *slugs*, que são *containers* para os dados (por exemplo páginas estáticas e imagem do executável do serviço do usuário), *dynos*, que são máquinas de execução, e, armazenamento em um banco de dados POSTGRES.

A visão geral do funcionamento de Heroku e do vocabulário usado na documentação, em especial de conceitos particulares a Heroku, é esclarecido [aqui](https://devcenter.heroku.com/articles/how-heroku-works).

A documentação do Heroku é acessada pelo [devcenter](https://devcenter.heroku.com/).

A fim de facilitar a criação (local) do código, padronizar sua estrutura e compilação, Heroku usa maven.

A fim de implantar o sistema do usuário na nuvem, Heroku usa git (pode usar outros).

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

**Maven Phases**

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

Acho que diferentes tutoriais são escritos por pessoas usando comandos ligeiramente diferentes. É bom para mostrar que há várias formas de fazer algo, mas é ruim porque não é uniforme. Por exemplo, neste tutorial, abre-se mostrando como devia ser o comando para executar e a execução:

```
$ java -jar webapp-runner.jar application.war
deploying app from: /Users/johnsimone/dev/gitrepos/devcenter-webapp-runner/target/webappRunnerSample.war
Feb 14, 2012 5:21:44 PM org.apache.coyote.AbstractProtocol init
INFO: Initializing ProtocolHandler ["http-bio-8080"]
Feb 14, 2012 5:21:44 PM org.apache.catalina.core.StandardService startInternal
INFO: Starting service Tomcat
Feb 14, 2012 5:21:44 PM org.apache.catalina.core.StandardEngine startInternal
INFO: Starting Servlet Engine: Apache Tomcat/8.0.30
Feb 14, 2012 5:21:44 PM org.apache.catalina.startup.ContextConfig webConfig
INFO: No global web.xml found
Feb 14, 2012 5:21:44 PM org.apache.coyote.AbstractProtocol start
INFO: Starting ProtocolHandler ["http-bio-8080"]

```

Aí, depois de criar o esboço, ajustar o POM, e empacotar, o comando para executar é: `java -jar target/dependency/webapp-runner.jar target/*.war`, que é a certa.

Enfim, segui os seguintes passos:

1. [Criar uma pasta contendo o esboço da aplicação denominada pelo artifactId fornecido](https://devcenter.heroku.com/articles/java-webapp-runner#create-an-application-if-you-don-t-already-have-one);
<pre><font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/heroku/deploy-war/hello2</b></font>$ mvn archetype:generate -DarchetypeArtifactId=maven-archetype-webapp
WARNING: An illegal reflective access operation has occurred
WARNING: Illegal reflective access by com.google.inject.internal.cglib.core.$ReflectUtils$1 (file:/usr/share/maven/lib/guice.jar) to method java.lang.ClassLoader.defineClass(java.lang.String,byte[],int,int,java.security.ProtectionDomain)
WARNING: Please consider reporting this to the maintainers of com.google.inject.internal.cglib.core.$ReflectUtils$1
WARNING: Use --illegal-access=warn to enable warnings of further illegal reflective access operations
WARNING: All illegal access operations will be denied in a future release
[<font color="#268BD2"><b>INFO</b></font>] Scanning for projects...
[<font color="#268BD2"><b>INFO</b></font>] 
[<font color="#268BD2"><b>INFO</b></font>] <b>------------------&lt; </b><font color="#2AA198">org.apache.maven:standalone-pom</font><b> &gt;-------------------</b>
[<font color="#268BD2"><b>INFO</b></font>] <b>Building Maven Stub Project (No POM) 1</b>
[<font color="#268BD2"><b>INFO</b></font>] <b>--------------------------------[ pom ]---------------------------------</b>
[<font color="#268BD2"><b>INFO</b></font>] 
[<font color="#268BD2"><b>INFO</b></font>] <b>&gt;&gt;&gt; </b><font color="#859900">maven-archetype-plugin:3.2.0:generate</font> <b>(default-cli) &gt; generate-sources</b> @ <font color="#2AA198">standalone-pom</font><b> &gt;&gt;&gt;</b>
[<font color="#268BD2"><b>INFO</b></font>] 
[<font color="#268BD2"><b>INFO</b></font>] <b>&lt;&lt;&lt; </b><font color="#859900">maven-archetype-plugin:3.2.0:generate</font> <b>(default-cli) &lt; generate-sources</b> @ <font color="#2AA198">standalone-pom</font><b> &lt;&lt;&lt;</b>
[<font color="#268BD2"><b>INFO</b></font>] 
[<font color="#268BD2"><b>INFO</b></font>] 
[<font color="#268BD2"><b>INFO</b></font>] <b>--- </b><font color="#859900">maven-archetype-plugin:3.2.0:generate</font> <b>(default-cli)</b> @ <font color="#2AA198">standalone-pom</font><b> ---</b>
[<font color="#268BD2"><b>INFO</b></font>] Generating project in Interactive mode
Define value for property &apos;groupId&apos;: com.example
Define value for property &apos;artifactId&apos;: helloworld
Define value for property &apos;version&apos; 1.0-SNAPSHOT: : 
Define value for property &apos;package&apos; com.example: : 
Confirm properties configuration:
groupId: com.example
artifactId: helloworld
version: 1.0-SNAPSHOT
package: com.example
 Y: : 
[<font color="#268BD2"><b>INFO</b></font>] ----------------------------------------------------------------------------
[<font color="#268BD2"><b>INFO</b></font>] Using following parameters for creating project from Old (1.x) Archetype: maven-archetype-webapp:1.0
[<font color="#268BD2"><b>INFO</b></font>] ----------------------------------------------------------------------------
[<font color="#268BD2"><b>INFO</b></font>] Parameter: basedir, Value: /home/fabio/Documentos/heroku/deploy-war/hello2
[<font color="#268BD2"><b>INFO</b></font>] Parameter: package, Value: com.example
[<font color="#268BD2"><b>INFO</b></font>] Parameter: groupId, Value: com.example
[<font color="#268BD2"><b>INFO</b></font>] Parameter: artifactId, Value: helloworld
[<font color="#268BD2"><b>INFO</b></font>] Parameter: packageName, Value: com.example
[<font color="#268BD2"><b>INFO</b></font>] Parameter: version, Value: 1.0-SNAPSHOT
[<font color="#268BD2"><b>INFO</b></font>] project created from Old (1.x) Archetype in dir: /home/fabio/Documentos/heroku/deploy-war/hello2/helloworld
[<font color="#268BD2"><b>INFO</b></font>] <b>------------------------------------------------------------------------</b>
[<font color="#268BD2"><b>INFO</b></font>] <font color="#859900"><b>BUILD SUCCESS</b></font>
[<font color="#268BD2"><b>INFO</b></font>] <b>------------------------------------------------------------------------</b>
[<font color="#268BD2"><b>INFO</b></font>] Total time:  01:06 min
[<font color="#268BD2"><b>INFO</b></font>] Finished at: 2021-01-26T18:48:22-03:00
[<font color="#268BD2"><b>INFO</b></font>] <b>------------------------------------------------------------------------</b>
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/heroku/deploy-war/hello2</b></font>$ 
</pre>
2. [Ajustar o arquivo de configuração para baixar webapp-runner como dependência](https://devcenter.heroku.com/articles/java-webapp-runner#configure-maven-to-download-webapp-runner);
3. [Executar localmente](https://devcenter.heroku.com/articles/java-webapp-runner#run-your-application)

- No tutorial não está escrito que uma subpasta com o nome que informamos como artifactId é criada;
- O esboço é completo. `mvn package` cria o `helloworld.war` que não sei se contém ou se aponta para `target/helloworld/index.jsp`.

[Captura de tela da execução](Imagens/Captura%20de%20tela%20de%202021-01-26%2019-08-35.png)

Fiz uns testes:

1. colocar `sample.war`, baixado dos [exemplos de Tomcat](https://tomcat.apache.org/tomcat-7.0-doc/appdev/sample/) na pasta target e tentar executar localmente.
   - resulta que `java -jar target/dependency/webapp-runner.jar target/*.war` avisa que não executa os dois `.war` simultaneamente e usa um deles.
<pre><font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/heroku/deploy-war/helloworld</b></font>$ java -jar target/dependency/webapp-runner.jar target/*.war
WARNING: multiple paths are specified, but no longer supported. First path will be used.</pre>
2. tirar o `helloworld.war`, colocar `fuseki.war` e (tentar) executar.
<pre><font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/heroku/deploy-war/helloworld/target</b></font>$ ls
<font color="#268BD2"><b>classes</b></font>     <font color="#268BD2"><b>helloworld</b></font>           <font color="#268BD2"><b>maven-archiver</b></font>  <font color="#268BD2"><b>tomcat.8080</b></font>
<font color="#268BD2"><b>dependency</b></font>  helloworld.war.hide  <font color="#DC322F"><b>sample.war</b></font>
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/heroku/deploy-war/helloworld/target</b></font>$ mv sample.war sample.war.hide
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/heroku/deploy-war/helloworld/target</b></font>$ cp ~/apache-jena-fuseki-3.17.0/fuseki.war .
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/heroku/deploy-war/helloworld/target</b></font>$ ls
<font color="#268BD2"><b>classes</b></font>     <font color="#DC322F"><b>fuseki.war</b></font>  helloworld.war.hide  sample.war.hide
<font color="#268BD2"><b>dependency</b></font>  <font color="#268BD2"><b>helloworld</b></font>  <font color="#268BD2"><b>maven-archiver</b></font>       <font color="#268BD2"><b>tomcat.8080</b></font>
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/heroku/deploy-war/helloworld/target</b></font>$ cd ..
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/heroku/deploy-war/helloworld</b></font>$ java -jar target/dependency/webapp-runner.jar target/*.war
jan 25, 2021 5:17:35 PM org.apache.catalina.startup.ExpandWar expand
INFORMAÇÕES: An expanded directory [/home/fabio/Documentos/heroku/deploy-war/helloworld/target/tomcat.8080/webapps/expanded] was found with a last modified time that did not match the associated WAR. It will be deleted.
Expanding fuseki.war into /home/fabio/Documentos/heroku/deploy-war/helloworld/target/tomcat.8080/webapps/expanded
Adding Context  for /home/fabio/Documentos/heroku/deploy-war/helloworld/target/tomcat.8080/webapps/expanded
jan 25, 2021 5:17:36 PM org.apache.coyote.AbstractProtocol init
INFORMAÇÕES: Initializing ProtocolHandler [&quot;http-nio-8080&quot;]
jan 25, 2021 5:17:36 PM org.apache.catalina.core.StandardService startInternal
INFORMAÇÕES: Starting service [Tomcat]
jan 25, 2021 5:17:36 PM org.apache.catalina.core.StandardEngine startInternal
INFORMAÇÕES: Starting Servlet engine: [Apache Tomcat/9.0.41]
jan 25, 2021 5:17:37 PM org.apache.catalina.startup.ContextConfig getDefaultWebXmlFragment
INFORMAÇÕES: No global web.xml found
jan 25, 2021 5:17:40 PM org.apache.jasper.servlet.TldScanner scanJars
INFORMAÇÕES: At least one JAR was scanned for TLDs yet contained no TLDs. Enable debug logging for this logger for a complete list of JARs that were scanned but no TLDs were found in them. Skipping unneeded JARs during scanning can improve startup time and JSP compilation time.
[2021-01-25 17:17:41] Config     INFO  FUSEKI_HOME=unset
[2021-01-25 17:17:41] Config     INFO  FUSEKI_BASE=/etc/fuseki
[2021-01-25 17:17:41] Server     ERROR Exception in server initialization
org.apache.jena.fuseki.FusekiConfigException: Failed to create directory: /etc/fuseki
	at org.apache.jena.fuseki.webapp.FusekiWebapp.ensureDir(FusekiWebapp.java:372) ~[jena-fuseki-webapp-3.17.0.jar:3.17.0]
	at org.apache.jena.fuseki.webapp.FusekiWebapp.formatBaseArea(FusekiWebapp.java:145) [jena-fuseki-webapp-3.17.0.jar:3.17.0]
	at org.apache.jena.fuseki.webapp.ShiroEnvironmentLoader.contextInitialized(ShiroEnvironmentLoader.java:50) [jena-fuseki-webapp-3.17.0.jar:3.17.0]
	at org.apache.catalina.core.StandardContext.listenerStart(StandardContext.java:4716) [webapp-runner.jar:?]
	at org.apache.catalina.core.StandardContext.startInternal(StandardContext.java:5177) [webapp-runner.jar:?]
	at org.apache.catalina.util.LifecycleBase.start(LifecycleBase.java:183) [webapp-runner.jar:?]
	at org.apache.catalina.core.ContainerBase$StartChild.call(ContainerBase.java:1384) [webapp-runner.jar:?]
	at org.apache.catalina.core.ContainerBase$StartChild.call(ContainerBase.java:1374) [webapp-runner.jar:?]
	at java.util.concurrent.FutureTask.run(FutureTask.java:264) [?:?]
	at org.apache.tomcat.util.threads.InlineExecutorService.execute(InlineExecutorService.java:75) [webapp-runner.jar:?]
	at java.util.concurrent.AbstractExecutorService.submit(AbstractExecutorService.java:140) [?:?]
	at org.apache.catalina.core.ContainerBase.startInternal(ContainerBase.java:909) [webapp-runner.jar:?]
	at org.apache.catalina.core.StandardHost.startInternal(StandardHost.java:843) [webapp-runner.jar:?]
	at org.apache.catalina.util.LifecycleBase.start(LifecycleBase.java:183) [webapp-runner.jar:?]
	at org.apache.catalina.core.ContainerBase$StartChild.call(ContainerBase.java:1384) [webapp-runner.jar:?]
	at org.apache.catalina.core.ContainerBase$StartChild.call(ContainerBase.java:1374) [webapp-runner.jar:?]
	at java.util.concurrent.FutureTask.run(FutureTask.java:264) [?:?]
	at org.apache.tomcat.util.threads.InlineExecutorService.execute(InlineExecutorService.java:75) [webapp-runner.jar:?]
	at java.util.concurrent.AbstractExecutorService.submit(AbstractExecutorService.java:140) [?:?]
	at org.apache.catalina.core.ContainerBase.startInternal(ContainerBase.java:909) [webapp-runner.jar:?]
	at org.apache.catalina.core.StandardEngine.startInternal(StandardEngine.java:262) [webapp-runner.jar:?]
	at org.apache.catalina.util.LifecycleBase.start(LifecycleBase.java:183) [webapp-runner.jar:?]
	at org.apache.catalina.core.StandardService.startInternal(StandardService.java:434) [webapp-runner.jar:?]
	at org.apache.catalina.util.LifecycleBase.start(LifecycleBase.java:183) [webapp-runner.jar:?]
	at org.apache.catalina.core.StandardServer.startInternal(StandardServer.java:930) [webapp-runner.jar:?]
	at org.apache.catalina.util.LifecycleBase.start(LifecycleBase.java:183) [webapp-runner.jar:?]
	at org.apache.catalina.startup.Tomcat.start(Tomcat.java:486) [webapp-runner.jar:?]
	at webapp.runner.launch.Main.main(Main.java:289) [webapp-runner.jar:?]
jan 25, 2021 5:17:41 PM org.apache.catalina.core.StandardContext listenerStart
GRAVE: Exception sending context initialized event to listener instance of class [org.apache.jena.fuseki.webapp.ShiroEnvironmentLoader]
org.apache.jena.fuseki.FusekiConfigException: Failed to create directory: /etc/fuseki
	at org.apache.jena.fuseki.webapp.FusekiWebapp.ensureDir(FusekiWebapp.java:372)
	at org.apache.jena.fuseki.webapp.FusekiWebapp.formatBaseArea(FusekiWebapp.java:145)
	at org.apache.jena.fuseki.webapp.ShiroEnvironmentLoader.contextInitialized(ShiroEnvironmentLoader.java:50)
	at org.apache.catalina.core.StandardContext.listenerStart(StandardContext.java:4716)
	at org.apache.catalina.core.StandardContext.startInternal(StandardContext.java:5177)
	at org.apache.catalina.util.LifecycleBase.start(LifecycleBase.java:183)
	at org.apache.catalina.core.ContainerBase$StartChild.call(ContainerBase.java:1384)
	at org.apache.catalina.core.ContainerBase$StartChild.call(ContainerBase.java:1374)
	at java.base/java.util.concurrent.FutureTask.run(FutureTask.java:264)
	at org.apache.tomcat.util.threads.InlineExecutorService.execute(InlineExecutorService.java:75)
	at java.base/java.util.concurrent.AbstractExecutorService.submit(AbstractExecutorService.java:140)
	at org.apache.catalina.core.ContainerBase.startInternal(ContainerBase.java:909)
	at org.apache.catalina.core.StandardHost.startInternal(StandardHost.java:843)
	at org.apache.catalina.util.LifecycleBase.start(LifecycleBase.java:183)
	at org.apache.catalina.core.ContainerBase$StartChild.call(ContainerBase.java:1384)
	at org.apache.catalina.core.ContainerBase$StartChild.call(ContainerBase.java:1374)
	at java.base/java.util.concurrent.FutureTask.run(FutureTask.java:264)
	at org.apache.tomcat.util.threads.InlineExecutorService.execute(InlineExecutorService.java:75)
	at java.base/java.util.concurrent.AbstractExecutorService.submit(AbstractExecutorService.java:140)
	at org.apache.catalina.core.ContainerBase.startInternal(ContainerBase.java:909)
	at org.apache.catalina.core.StandardEngine.startInternal(StandardEngine.java:262)
	at org.apache.catalina.util.LifecycleBase.start(LifecycleBase.java:183)
	at org.apache.catalina.core.StandardService.startInternal(StandardService.java:434)
	at org.apache.catalina.util.LifecycleBase.start(LifecycleBase.java:183)
	at org.apache.catalina.core.StandardServer.startInternal(StandardServer.java:930)
	at org.apache.catalina.util.LifecycleBase.start(LifecycleBase.java:183)
	at org.apache.catalina.startup.Tomcat.start(Tomcat.java:486)
	at webapp.runner.launch.Main.main(Main.java:289)

[2021-01-25 17:17:41] Server     ERROR Failed to initialize : Server not running
jan 25, 2021 5:17:41 PM org.apache.catalina.core.StandardContext startInternal
GRAVE: One or more listeners failed to start. Full details will be found in the appropriate container log file
jan 25, 2021 5:17:41 PM org.apache.catalina.core.StandardContext startInternal
GRAVE: Context [] startup failed due to previous errors
SEVERE: Context [] failed in [org.apache.catalina.core.StandardContext] lifecycle. Allowing Tomcat to shutdown.
jan 25, 2021 5:17:41 PM org.apache.catalina.core.ApplicationContext log
INFORMAÇÕES: Cleaning up Shiro Environment
WARNING: An illegal reflective access operation has occurred
WARNING: Illegal reflective access by org.apache.catalina.loader.WebappClassLoaderBase (file:/home/fabio/Documentos/heroku/deploy-war/helloworld/target/dependency/webapp-runner.jar) to field java.io.ObjectStreamClass$Caches.localDescs
WARNING: Please consider reporting this to the maintainers of org.apache.catalina.loader.WebappClassLoaderBase
WARNING: Use --illegal-access=warn to enable warnings of further illegal reflective access operations
WARNING: All illegal access operations will be denied in a future release
jan 25, 2021 5:17:41 PM org.apache.coyote.AbstractProtocol start
INFORMAÇÕES: Starting ProtocolHandler [&quot;http-nio-8080&quot;]
</pre>
 
`fuseki.war` requer leitura e escrita em `/etc/fuseki`, que é uma pasta no sistema de arquivos. Heroku não tem essa pasta, então a execução é abortada. Algumas pessoas tentaram contornar isso, aparentemente, sem sucesso.

- https://stackoverflow.com/questions/43835977/need-help-java-web-app-webapp-runner-tomcat-heroku-app-crashed

### Caminhos que podem ser seguidos:

Fuseki e Spring Boot

Troca de email de março de 2020, contém informação interessante sobre jetty e fuseki-main: http://mail-archives.apache.org/mod_mbox/jena-users/202003.mbox/%3Cd2ebdd2d-5579-7fb0-d69f-b02936eaa39e@apache.org%3E

Fuseki/Jena e Maven

- https://jena.apache.org/download/maven.html
- https://search.maven.org/artifact/org.apache.jena/jena-fuseki-webapp/3.17.0/jar
- https://jena.apache.org/documentation/fuseki2/fuseki-webapp.html
- POM do fuseki-server: https://github.com/apache/jena/blob/master/jena-fuseki2/jena-fuseki-server/pom.xml


Fuseki e Sistema de Arquivos

- https://jena.apache.org/documentation/fuseki2/fuseki-layout.html

Configuração do fuseki-server

- https://jena.apache.org/documentation/fuseki2/fuseki-configuration.html

Raiz da documentação do Fuseki

- https://jena.apache.org/documentation/fuseki2/

### Heroku implantar arquivo WAR (recompilar Fuseki?)

https://devcenter.heroku.com/articles/configuring-war-deployment-with-the-heroku-toolbelt

Falta [implantar no Heroku](https://devcenter.heroku.com/articles/java-webapp-runner#deploy-your-application-to-heroku). **nota** antes de implantar no heroku não tem pasta `.git`.


No futuro melhorarei a apresentação desta seção. Seguir o tutorial para implantar WAR através de Webapp-runner-FIM

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


## Dúvida git:

Clonei de github mas dei push em heroku. Isto quer dizer que substituí a referência para o repositório remoto do github para o heroku?? Esse heroku em especial é meu, privado? Como a operação é transparente, ficam essas perguntas.

Isto poderia gerar interferência, por exemplo, se uso um github remoto para manter código e colaboradores e implanto usando heroku em outro remoto. 


## Discussão e Conclusão

Consegui fechar uma história sobre Heroku, mas estou com várias outras (derivadas) abertas.




