# MAVEN

## 2021-02-21-104556

**nota**: renomeei o arquivo `pom.xml` para `pom.xml.exemplo`. É esperado que esse arquivo seja editado e lido como um exemplo, mas não precise ser usado para especificar um projeto pois a informação para sua construção faz parte deste arquivo.

[O que é Maven, segundo o desenvolvedor, em uma seção.](https://maven.apache.org/guides/getting-started/index.html#what-is-maven).

### O que tenho a acrescentar

A proposta é 'facilitar' o uso de 'boas práticas' para vários aspectos do ciclo de vida de um programa. A mim, parece inescapável que isto também 'force' o uso do que 'eles consideram boas práticas'. Consideração que precisa estar presente. Por exemplo, isto serve como resposta para a pergunta *Por que a estrutura de arquivos deste programa é tão complicada?*.

Maven funciona em linha de comando, e pode ser usada atrás de uma interface gráfica (acho que IntelliJ faz isso, gostaria que alguém fosse conferir e trouxesse a informação referenciada).

No aspecto de gerenciar o ciclo de vida de um programa, isto é feito considerando o ponto de vista de um desenvolvedor de grandes sistemas, situação em que é útil considerar as seguintes fases do ciclo de vida de um programa como padrão:

>    validate: validate the project is correct and all necessary information is available
>    compile: compile the source code of the project
>    test: test the compiled source code using a suitable unit testing framework. These tests should not require the code be packaged or deployed
>    package: take the compiled code and package it in its distributable format, such as a JAR.
>    integration-test: process and deploy the package if necessary into an environment where integration tests can be run
>    verify: run any checks to verify the package is valid and meets quality criteria
>    install: install the package into the local repository, for use as a dependency in other projects locally
>    deploy: done in an integration or release environment, copies the final package to the remote repository for sharing with other developers and projects.

Fonte [aqui](https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html#maven-phases).

Vou traduzir os nomes das fases como: validação, compilação, teste, empacotamento, teste de integração, verificação, instalação, implantação.

Maven usa as seguintes funcionalidades:

- pacotes de Java (`package`/`import`); 
   - sobre esta, cria estruturas de diretórios específicas para aplicações. São os [arquétipos](https://maven.apache.org/guides/introduction/introduction-to-archetypes.html);
- ferramentas de compilação como Ant (*make*, para os da velha-guarda);
- controle de versão, como Git (*CVS*, *subversion*, para os da velha-guarda);
- testes unitários (ex. JUnit);
- registro de funcionamento (ex. log4j).

A maior parte da informação de configuração para construir o sistema-alvo (por exemplo dependências para compilação e execução de testes) é armazenada no [Project Object Model (POM.xml)](https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html#the-pom).

### Próximos passos

- Entender os elementos de POM.xml
   - localizar lista de elementos;
   - localizar explicação sobre os elementos;
   - localizar o que Maven faz com cada elemento;
      - ex. que dependência é executada e de que forma quando encontra um determinado elemento;

### Referências visitadas

https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html#the-pom
https://maven.apache.org/guides/getting-started/index.html#what-is-maven
https://maven.apache.org/guides/introduction/introduction-to-archetypes.html
http://velocity.apache.org/
https://maven.apache.org/archetypes/index.html
https://maven.apache.org/archetypes/maven-archetype-quickstart/
https://maven.apache.org/archetypes/maven-archetype-webapp/

## 2021-02-21-135817


Parece que encontrei algo que achei fácil, útil e que testa o que sei sobre Maven. 

Vejo muitos usos que necessitam ler um CSV e poder trabalhar seu conteúdo dentro de Java, por exemplo como um arrayList. Estou com um desses agora: transformar CSV para GML, ou para RDF:XML, ou ...

O leitor de CSV (comma-separated values) é [OpenCSV](http://opencsv.sourceforge.net/).

Interessante é que [o tutorial que encontrei](https://mkyong.com/java/how-to-read-and-parse-csv-file-in-java/), que não está no site do projeto, cita uma seção de um POM.xml de Maven que descreve dependências, mas não dá indicações sobre como usá-lo... talvez por acharem ser muito óbvio, mas para mim não é tanto...

Minha estratégia será:

- iniciar um projeto Maven quickstart e executar;
- acrescentar ou substituir código, dependências e arquivos para testar o exemplo do tutorial;
- anotar comandos e resultados.
 
Comando: `mvn archetype:generate -DgroupId=com.mycompany.app -DartifactId=LeitorDeCSV -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false`

<pre><font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~</b></font>$ cd Documentos/ZZfiles/
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles</b></font>$ mkdir sobreMaven
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles</b></font>$ cd sobreMaven
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sobreMaven</b></font>$ mvn archetype:generate -DgroupId=com.mycompany.app -DartifactId=LeitorDeCSV -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false
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
[<font color="#268BD2"><b>INFO</b></font>] Generating project in Batch mode
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/archetypes/maven-archetype-quickstart/1.4/maven-archetype-quickstart-1.4.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/archetypes/maven-archetype-quickstart/1.4/maven-archetype-quickstart-1.4.pom (1.6 kB at 1.9 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/archetypes/maven-archetype-bundles/1.4/maven-archetype-bundles-1.4.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/archetypes/maven-archetype-bundles/1.4/maven-archetype-bundles-1.4.pom (4.5 kB at 9.9 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/archetypes/maven-archetype-quickstart/1.4/maven-archetype-quickstart-1.4.jar
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/archetypes/maven-archetype-quickstart/1.4/maven-archetype-quickstart-1.4.jar (7.1 kB at 16 kB/s)
[<font color="#268BD2"><b>INFO</b></font>] ----------------------------------------------------------------------------
[<font color="#268BD2"><b>INFO</b></font>] Using following parameters for creating project from Archetype: maven-archetype-quickstart:1.4
[<font color="#268BD2"><b>INFO</b></font>] ----------------------------------------------------------------------------
[<font color="#268BD2"><b>INFO</b></font>] Parameter: groupId, Value: com.mycompany.app
[<font color="#268BD2"><b>INFO</b></font>] Parameter: artifactId, Value: LeitorDeCSV
[<font color="#268BD2"><b>INFO</b></font>] Parameter: version, Value: 1.0-SNAPSHOT
[<font color="#268BD2"><b>INFO</b></font>] Parameter: package, Value: com.mycompany.app
[<font color="#268BD2"><b>INFO</b></font>] Parameter: packageInPathFormat, Value: com/mycompany/app
[<font color="#268BD2"><b>INFO</b></font>] Parameter: package, Value: com.mycompany.app
[<font color="#268BD2"><b>INFO</b></font>] Parameter: groupId, Value: com.mycompany.app
[<font color="#268BD2"><b>INFO</b></font>] Parameter: artifactId, Value: LeitorDeCSV
[<font color="#268BD2"><b>INFO</b></font>] Parameter: version, Value: 1.0-SNAPSHOT
[<font color="#268BD2"><b>INFO</b></font>] Project created from Archetype in dir: /home/fabio/Documentos/ZZfiles/sobreMaven/LeitorDeCSV
[<font color="#268BD2"><b>INFO</b></font>] <b>------------------------------------------------------------------------</b>
[<font color="#268BD2"><b>INFO</b></font>] <font color="#859900"><b>BUILD SUCCESS</b></font>
[<font color="#268BD2"><b>INFO</b></font>] <b>------------------------------------------------------------------------</b>
[<font color="#268BD2"><b>INFO</b></font>] Total time:  01:02 min
[<font color="#268BD2"><b>INFO</b></font>] Finished at: 2021-02-21T14:29:25-03:00
[<font color="#268BD2"><b>INFO</b></font>] <b>------------------------------------------------------------------------</b>
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sobreMaven</b></font>$ 
</pre>

Para criar o projeto, uma quantidade de dependências foi baixada e executada, entre elas, algo do google que gerou um erro de execução. Vamos anotar que código malicioso pode ser incluído em sua aplicação através de um recurso como este.

`mvn package`

<pre><font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sobreMaven/LeitorDeCSV</b></font>$ mvn package
WARNING: An illegal reflective access operation has occurred
WARNING: Illegal reflective access by com.google.inject.internal.cglib.core.$ReflectUtils$1 (file:/usr/share/maven/lib/guice.jar) to method java.lang.ClassLoader.defineClass(java.lang.String,byte[],int,int,java.security.ProtectionDomain)
WARNING: Please consider reporting this to the maintainers of com.google.inject.internal.cglib.core.$ReflectUtils$1
WARNING: Use --illegal-access=warn to enable warnings of further illegal reflective access operations
WARNING: All illegal access operations will be denied in a future release
[<font color="#268BD2"><b>INFO</b></font>] Scanning for projects...
[<font color="#268BD2"><b>INFO</b></font>] 
[<font color="#268BD2"><b>INFO</b></font>] <b>-------------------&lt; </b><font color="#2AA198">com.mycompany.app:LeitorDeCSV</font><b> &gt;--------------------</b>
[<font color="#268BD2"><b>INFO</b></font>] <b>Building LeitorDeCSV 1.0-SNAPSHOT</b>
[<font color="#268BD2"><b>INFO</b></font>] <b>--------------------------------[ jar ]---------------------------------</b>
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-resources-plugin/3.0.2/maven-resources-plugin-3.0.2.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-resources-plugin/3.0.2/maven-resources-plugin-3.0.2.pom (7.1 kB at 5.3 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-plugins/30/maven-plugins-30.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-plugins/30/maven-plugins-30.pom (10 kB at 26 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-resources-plugin/3.0.2/maven-resources-plugin-3.0.2.jar
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-resources-plugin/3.0.2/maven-resources-plugin-3.0.2.jar (32 kB at 66 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-compiler-plugin/3.8.0/maven-compiler-plugin-3.8.0.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-compiler-plugin/3.8.0/maven-compiler-plugin-3.8.0.pom (12 kB at 26 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-plugins/32/maven-plugins-32.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-plugins/32/maven-plugins-32.pom (11 kB at 27 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/maven-parent/32/maven-parent-32.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/maven-parent/32/maven-parent-32.pom (43 kB at 86 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/apache/20/apache-20.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/apache/20/apache-20.pom (16 kB at 39 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-compiler-plugin/3.8.0/maven-compiler-plugin-3.8.0.jar
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-compiler-plugin/3.8.0/maven-compiler-plugin-3.8.0.jar (62 kB at 125 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-surefire-plugin/2.22.1/maven-surefire-plugin-2.22.1.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-surefire-plugin/2.22.1/maven-surefire-plugin-2.22.1.pom (5.0 kB at 13 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/surefire/2.22.1/surefire-2.22.1.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/surefire/2.22.1/surefire-2.22.1.pom (26 kB at 51 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-surefire-plugin/2.22.1/maven-surefire-plugin-2.22.1.jar
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-surefire-plugin/2.22.1/maven-surefire-plugin-2.22.1.jar (41 kB at 82 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-jar-plugin/3.0.2/maven-jar-plugin-3.0.2.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-jar-plugin/3.0.2/maven-jar-plugin-3.0.2.pom (6.2 kB at 13 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-jar-plugin/3.0.2/maven-jar-plugin-3.0.2.jar
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-jar-plugin/3.0.2/maven-jar-plugin-3.0.2.jar (27 kB at 46 kB/s)
[<font color="#268BD2"><b>INFO</b></font>] 
[<font color="#268BD2"><b>INFO</b></font>] <b>--- </b><font color="#859900">maven-resources-plugin:3.0.2:resources</font> <b>(default-resources)</b> @ <font color="#2AA198">LeitorDeCSV</font><b> ---</b>
Downloading from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-component-annotations/1.6/plexus-component-annotations-1.6.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-component-annotations/1.6/plexus-component-annotations-1.6.pom (748 B at 2.2 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-containers/1.6/plexus-containers-1.6.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-containers/1.6/plexus-containers-1.6.pom (3.8 kB at 7.5 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus/3.3.2/plexus-3.3.2.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus/3.3.2/plexus-3.3.2.pom (22 kB at 52 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-component-annotations/1.6/plexus-component-annotations-1.6.jar
Downloading from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-utils/3.0.24/plexus-utils-3.0.24.jar
Downloaded from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-component-annotations/1.6/plexus-component-annotations-1.6.jar (4.3 kB at 9.0 kB/s)
Downloaded from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-utils/3.0.24/plexus-utils-3.0.24.jar (247 kB at 175 kB/s)
[<font color="#268BD2"><b>INFO</b></font>] Using &apos;UTF-8&apos; encoding to copy filtered resources.
[<font color="#268BD2"><b>INFO</b></font>] skip non existing resourceDirectory /home/fabio/Documentos/ZZfiles/sobreMaven/LeitorDeCSV/src/main/resources
[<font color="#268BD2"><b>INFO</b></font>] 
[<font color="#268BD2"><b>INFO</b></font>] <b>--- </b><font color="#859900">maven-compiler-plugin:3.8.0:compile</font> <b>(default-compile)</b> @ <font color="#2AA198">LeitorDeCSV</font><b> ---</b>
[<font color="#268BD2"><b>INFO</b></font>] Changes detected - recompiling the module!
[<font color="#268BD2"><b>INFO</b></font>] Compiling 1 source file to /home/fabio/Documentos/ZZfiles/sobreMaven/LeitorDeCSV/target/classes
[<font color="#268BD2"><b>INFO</b></font>] 
[<font color="#268BD2"><b>INFO</b></font>] <b>--- </b><font color="#859900">maven-resources-plugin:3.0.2:testResources</font> <b>(default-testResources)</b> @ <font color="#2AA198">LeitorDeCSV</font><b> ---</b>
[<font color="#268BD2"><b>INFO</b></font>] Using &apos;UTF-8&apos; encoding to copy filtered resources.
[<font color="#268BD2"><b>INFO</b></font>] skip non existing resourceDirectory /home/fabio/Documentos/ZZfiles/sobreMaven/LeitorDeCSV/src/test/resources
[<font color="#268BD2"><b>INFO</b></font>] 
[<font color="#268BD2"><b>INFO</b></font>] <b>--- </b><font color="#859900">maven-compiler-plugin:3.8.0:testCompile</font> <b>(default-testCompile)</b> @ <font color="#2AA198">LeitorDeCSV</font><b> ---</b>
[<font color="#268BD2"><b>INFO</b></font>] Changes detected - recompiling the module!
[<font color="#268BD2"><b>INFO</b></font>] Compiling 1 source file to /home/fabio/Documentos/ZZfiles/sobreMaven/LeitorDeCSV/target/test-classes
[<font color="#268BD2"><b>INFO</b></font>] 
[<font color="#268BD2"><b>INFO</b></font>] <b>--- </b><font color="#859900">maven-surefire-plugin:2.22.1:test</font> <b>(default-test)</b> @ <font color="#2AA198">LeitorDeCSV</font><b> ---</b>
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/maven-surefire-common/2.22.1/maven-surefire-common-2.22.1.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/maven-surefire-common/2.22.1/maven-surefire-common-2.22.1.pom (11 kB at 27 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/surefire-api/2.22.1/surefire-api-2.22.1.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/surefire-api/2.22.1/surefire-api-2.22.1.pom (3.5 kB at 9.0 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/surefire-logger-api/2.22.1/surefire-logger-api-2.22.1.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/surefire-logger-api/2.22.1/surefire-logger-api-2.22.1.pom (2.0 kB at 4.9 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/surefire-booter/2.22.1/surefire-booter-2.22.1.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/surefire-booter/2.22.1/surefire-booter-2.22.1.pom (7.5 kB at 19 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/maven-surefire-common/2.22.1/maven-surefire-common-2.22.1.jar
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/surefire-api/2.22.1/surefire-api-2.22.1.jar
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/surefire-logger-api/2.22.1/surefire-logger-api-2.22.1.jar
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/surefire-booter/2.22.1/surefire-booter-2.22.1.jar
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/surefire-api/2.22.1/surefire-api-2.22.1.jar (186 kB at 222 kB/s)
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/surefire-logger-api/2.22.1/surefire-logger-api-2.22.1.jar (13 kB at 14 kB/s)
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/maven-surefire-common/2.22.1/maven-surefire-common-2.22.1.jar (528 kB at 477 kB/s)
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/surefire-booter/2.22.1/surefire-booter-2.22.1.jar (274 kB at 174 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/surefire-junit4/2.22.1/surefire-junit4-2.22.1.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/surefire-junit4/2.22.1/surefire-junit4-2.22.1.pom (3.1 kB at 6.4 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/surefire-providers/2.22.1/surefire-providers-2.22.1.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/surefire-providers/2.22.1/surefire-providers-2.22.1.pom (2.5 kB at 7.2 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/surefire-junit4/2.22.1/surefire-junit4-2.22.1.jar
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/surefire-junit4/2.22.1/surefire-junit4-2.22.1.jar (85 kB at 173 kB/s)
[<font color="#268BD2"><b>INFO</b></font>] 
[<font color="#268BD2"><b>INFO</b></font>] -------------------------------------------------------
[<font color="#268BD2"><b>INFO</b></font>]  T E S T S
[<font color="#268BD2"><b>INFO</b></font>] -------------------------------------------------------
[<font color="#268BD2"><b>INFO</b></font>] Running com.mycompany.app.<b>AppTest</b>
[<font color="#268BD2"><b>INFO</b></font>] <font color="#859900"><b>Tests run: 1</b></font>, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.049 s - in com.mycompany.app.<b>AppTest</b>
[<font color="#268BD2"><b>INFO</b></font>] 
[<font color="#268BD2"><b>INFO</b></font>] Results:
[<font color="#268BD2"><b>INFO</b></font>] 
[<font color="#268BD2"><b>INFO</b></font>] <font color="#859900"><b>Tests run: 1, Failures: 0, Errors: 0, Skipped: 0</b></font>
[<font color="#268BD2"><b>INFO</b></font>] 
[<font color="#268BD2"><b>INFO</b></font>] 
[<font color="#268BD2"><b>INFO</b></font>] <b>--- </b><font color="#859900">maven-jar-plugin:3.0.2:jar</font> <b>(default-jar)</b> @ <font color="#2AA198">LeitorDeCSV</font><b> ---</b>
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/maven-archiver/3.1.1/maven-archiver-3.1.1.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/maven-archiver/3.1.1/maven-archiver-3.1.1.pom (4.3 kB at 11 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/shared/maven-shared-utils/3.0.1/maven-shared-utils-3.0.1.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/shared/maven-shared-utils/3.0.1/maven-shared-utils-3.0.1.pom (4.6 kB at 11 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-archiver/3.3/plexus-archiver-3.3.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-archiver/3.3/plexus-archiver-3.3.pom (5.3 kB at 13 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-io/2.7.1/plexus-io-2.7.1.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-io/2.7.1/plexus-io-2.7.1.pom (4.9 kB at 12 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/commons-io/commons-io/2.2/commons-io-2.2.pom
Downloaded from central: https://repo.maven.apache.org/maven2/commons-io/commons-io/2.2/commons-io-2.2.pom (11 kB at 28 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/commons/commons-parent/24/commons-parent-24.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/commons/commons-parent/24/commons-parent-24.pom (47 kB at 116 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/commons/commons-compress/1.11/commons-compress-1.11.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/commons/commons-compress/1.11/commons-compress-1.11.pom (13 kB at 32 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/tukaani/xz/1.5/xz-1.5.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/tukaani/xz/1.5/xz-1.5.pom (1.9 kB at 4.8 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-archiver/3.4/plexus-archiver-3.4.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-archiver/3.4/plexus-archiver-3.4.pom (5.3 kB at 15 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/maven-archiver/3.1.1/maven-archiver-3.1.1.jar
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/shared/maven-shared-utils/3.0.1/maven-shared-utils-3.0.1.jar
Downloading from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-archiver/3.4/plexus-archiver-3.4.jar
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/commons/commons-compress/1.11/commons-compress-1.11.jar
Downloading from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-io/2.7.1/plexus-io-2.7.1.jar
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/maven-archiver/3.1.1/maven-archiver-3.1.1.jar (24 kB at 19 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/tukaani/xz/1.5/xz-1.5.jar
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/shared/maven-shared-utils/3.0.1/maven-shared-utils-3.0.1.jar (154 kB at 107 kB/s)
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/commons/commons-compress/1.11/commons-compress-1.11.jar (426 kB at 276 kB/s)
Downloaded from central: https://repo.maven.apache.org/maven2/org/tukaani/xz/1.5/xz-1.5.jar (100 kB at 58 kB/s)
Downloaded from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-archiver/3.4/plexus-archiver-3.4.jar (187 kB at 109 kB/s)
Downloaded from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-io/2.7.1/plexus-io-2.7.1.jar (86 kB at 39 kB/s)
[<font color="#268BD2"><b>INFO</b></font>] Building jar: /home/fabio/Documentos/ZZfiles/sobreMaven/LeitorDeCSV/target/LeitorDeCSV-1.0-SNAPSHOT.jar
[<font color="#268BD2"><b>INFO</b></font>] <b>------------------------------------------------------------------------</b>
[<font color="#268BD2"><b>INFO</b></font>] <font color="#859900"><b>BUILD SUCCESS</b></font>
[<font color="#268BD2"><b>INFO</b></font>] <b>------------------------------------------------------------------------</b>
[<font color="#268BD2"><b>INFO</b></font>] Total time:  23.571 s
[<font color="#268BD2"><b>INFO</b></font>] Finished at: 2021-02-21T14:41:48-03:00
[<font color="#268BD2"><b>INFO</b></font>] <b>------------------------------------------------------------------------</b>
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sobreMaven/LeitorDeCSV</b></font>$ 
</pre>

`java -cp target/LeitorDeCSV-1.0-SNAPSHOT.jar com.mycompany.app.App`

<pre><font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sobreMaven/LeitorDeCSV</b></font>$ java -cp target/LeitorDeCSV-1.0-SNAPSHOT.jar com.mycompany.app.App
Hello World!
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sobreMaven/LeitorDeCSV</b></font>$ 

</pre>

Após incluir a dependência em POM.xml e ajustar o código-fonte de `App.java`

![alt text](sobreMaven/Captura%20de%20tela%20de%202021-02-21%2015-02-58.png)

<pre><font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sobreMaven/LeitorDeCSV</b></font>$ mvn package
WARNING: An illegal reflective access operation has occurred
WARNING: Illegal reflective access by com.google.inject.internal.cglib.core.$ReflectUtils$1 (file:/usr/share/maven/lib/guice.jar) to method java.lang.ClassLoader.defineClass(java.lang.String,byte[],int,int,java.security.ProtectionDomain)
WARNING: Please consider reporting this to the maintainers of com.google.inject.internal.cglib.core.$ReflectUtils$1
WARNING: Use --illegal-access=warn to enable warnings of further illegal reflective access operations
WARNING: All illegal access operations will be denied in a future release
[<font color="#268BD2"><b>INFO</b></font>] Scanning for projects...
[<font color="#268BD2"><b>INFO</b></font>] 
[<font color="#268BD2"><b>INFO</b></font>] <b>-------------------&lt; </b><font color="#2AA198">com.mycompany.app:LeitorDeCSV</font><b> &gt;--------------------</b>
[<font color="#268BD2"><b>INFO</b></font>] <b>Building LeitorDeCSV 1.0-SNAPSHOT</b>
[<font color="#268BD2"><b>INFO</b></font>] <b>--------------------------------[ jar ]---------------------------------</b>
Downloading from central: https://repo.maven.apache.org/maven2/com/opencsv/opencsv/5.3/opencsv-5.3.pom
Downloaded from central: https://repo.maven.apache.org/maven2/com/opencsv/opencsv/5.3/opencsv-5.3.pom (31 kB at 22 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/commons/commons-lang3/3.11/commons-lang3-3.11.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/commons/commons-lang3/3.11/commons-lang3-3.11.pom (30 kB at 78 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/commons/commons-parent/51/commons-parent-51.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/commons/commons-parent/51/commons-parent-51.pom (78 kB at 129 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/commons/commons-text/1.9/commons-text-1.9.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/commons/commons-text/1.9/commons-text-1.9.pom (17 kB at 44 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/commons-beanutils/commons-beanutils/1.9.4/commons-beanutils-1.9.4.pom
Downloaded from central: https://repo.maven.apache.org/maven2/commons-beanutils/commons-beanutils/1.9.4/commons-beanutils-1.9.4.pom (18 kB at 46 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/commons/commons-parent/47/commons-parent-47.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/commons/commons-parent/47/commons-parent-47.pom (78 kB at 153 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/commons-logging/commons-logging/1.2/commons-logging-1.2.pom
Downloaded from central: https://repo.maven.apache.org/maven2/commons-logging/commons-logging/1.2/commons-logging-1.2.pom (19 kB at 49 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/commons/commons-parent/34/commons-parent-34.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/commons/commons-parent/34/commons-parent-34.pom (56 kB at 111 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/commons-collections/commons-collections/3.2.2/commons-collections-3.2.2.pom
Downloaded from central: https://repo.maven.apache.org/maven2/commons-collections/commons-collections/3.2.2/commons-collections-3.2.2.pom (12 kB at 25 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/commons/commons-collections4/4.4/commons-collections4-4.4.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/commons/commons-collections4/4.4/commons-collections4-4.4.pom (24 kB at 45 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/com/opencsv/opencsv/5.3/opencsv-5.3.jar
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/commons/commons-lang3/3.11/commons-lang3-3.11.jar
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/commons/commons-text/1.9/commons-text-1.9.jar
Downloading from central: https://repo.maven.apache.org/maven2/commons-beanutils/commons-beanutils/1.9.4/commons-beanutils-1.9.4.jar
Downloading from central: https://repo.maven.apache.org/maven2/commons-logging/commons-logging/1.2/commons-logging-1.2.jar
Downloaded from central: https://repo.maven.apache.org/maven2/commons-logging/commons-logging/1.2/commons-logging-1.2.jar (62 kB at 38 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/commons-collections/commons-collections/3.2.2/commons-collections-3.2.2.jar
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/commons/commons-lang3/3.11/commons-lang3-3.11.jar (578 kB at 250 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/commons/commons-collections4/4.4/commons-collections4-4.4.jar
Downloaded from central: https://repo.maven.apache.org/maven2/commons-beanutils/commons-beanutils/1.9.4/commons-beanutils-1.9.4.jar (247 kB at 96 kB/s)
Downloaded from central: https://repo.maven.apache.org/maven2/com/opencsv/opencsv/5.3/opencsv-5.3.jar (218 kB at 85 kB/s)
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/commons/commons-text/1.9/commons-text-1.9.jar (216 kB at 84 kB/s)
Downloaded from central: https://repo.maven.apache.org/maven2/commons-collections/commons-collections/3.2.2/commons-collections-3.2.2.jar (588 kB at 105 kB/s)
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/commons/commons-collections4/4.4/commons-collections4-4.4.jar (752 kB at 111 kB/s)
[<font color="#268BD2"><b>INFO</b></font>] 
[<font color="#268BD2"><b>INFO</b></font>] <b>--- </b><font color="#859900">maven-resources-plugin:3.0.2:resources</font> <b>(default-resources)</b> @ <font color="#2AA198">LeitorDeCSV</font><b> ---</b>
[<font color="#268BD2"><b>INFO</b></font>] Using &apos;UTF-8&apos; encoding to copy filtered resources.
[<font color="#268BD2"><b>INFO</b></font>] skip non existing resourceDirectory /home/fabio/Documentos/ZZfiles/sobreMaven/LeitorDeCSV/src/main/resources
[<font color="#268BD2"><b>INFO</b></font>] 
[<font color="#268BD2"><b>INFO</b></font>] <b>--- </b><font color="#859900">maven-compiler-plugin:3.8.0:compile</font> <b>(default-compile)</b> @ <font color="#2AA198">LeitorDeCSV</font><b> ---</b>
[<font color="#268BD2"><b>INFO</b></font>] Changes detected - recompiling the module!
[<font color="#268BD2"><b>INFO</b></font>] Compiling 1 source file to /home/fabio/Documentos/ZZfiles/sobreMaven/LeitorDeCSV/target/classes
[<font color="#268BD2"><b>INFO</b></font>] -------------------------------------------------------------
[<font color="#DC322F"><b>ERROR</b></font>] COMPILATION ERROR : 
[<font color="#268BD2"><b>INFO</b></font>] -------------------------------------------------------------
[<font color="#DC322F"><b>ERROR</b></font>] /home/fabio/Documentos/ZZfiles/sobreMaven/LeitorDeCSV/src/main/java/com/mycompany/app/App.java:[21,25] lambda expressions are not supported in -source 7
  (use -source 8 or higher to enable lambda expressions)
[<font color="#268BD2"><b>INFO</b></font>] 1 error
[<font color="#268BD2"><b>INFO</b></font>] -------------------------------------------------------------
[<font color="#268BD2"><b>INFO</b></font>] <b>------------------------------------------------------------------------</b>
[<font color="#268BD2"><b>INFO</b></font>] <font color="#DC322F"><b>BUILD FAILURE</b></font>
[<font color="#268BD2"><b>INFO</b></font>] <b>------------------------------------------------------------------------</b>
[<font color="#268BD2"><b>INFO</b></font>] Total time:  14.172 s
[<font color="#268BD2"><b>INFO</b></font>] Finished at: 2021-02-21T15:03:24-03:00
[<font color="#268BD2"><b>INFO</b></font>] <b>------------------------------------------------------------------------</b>
[<font color="#DC322F"><b>ERROR</b></font>] Failed to execute goal <font color="#859900">org.apache.maven.plugins:maven-compiler-plugin:3.8.0:compile</font> <b>(default-compile)</b> on project <font color="#2AA198">LeitorDeCSV</font>: <font color="#DC322F"><b>Compilation failure</b></font>
[<font color="#DC322F"><b>ERROR</b></font>] <font color="#DC322F"><b>/home/fabio/Documentos/ZZfiles/sobreMaven/LeitorDeCSV/src/main/java/com/mycompany/app/App.java:[21,25] lambda expressions are not supported in -source 7</b></font>
[<font color="#DC322F"><b>ERROR</b></font>] <font color="#DC322F"><b>  (use -source 8 or higher to enable lambda expressions)</b></font>
[<font color="#DC322F"><b>ERROR</b></font>] 
[<font color="#DC322F"><b>ERROR</b></font>] -&gt; <b>[Help 1]</b>
[<font color="#DC322F"><b>ERROR</b></font>] 
[<font color="#DC322F"><b>ERROR</b></font>] To see the full stack trace of the errors, re-run Maven with the <b>-e</b> switch.
[<font color="#DC322F"><b>ERROR</b></font>] Re-run Maven using the <b>-X</b> switch to enable full debug logging.
[<font color="#DC322F"><b>ERROR</b></font>] 
[<font color="#DC322F"><b>ERROR</b></font>] For more information about the errors and possible solutions, please read the following articles:
[<font color="#DC322F"><b>ERROR</b></font>] <b>[Help 1]</b> http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sobreMaven/LeitorDeCSV</b></font>$ 

</pre>

Pelo erro, acho que tenho que trocar de versão de Java, mas não sei bem onde fazer isso... depois vi que é mudar no POM.xml, de 1.7 para 1.8.

<pre><font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sobreMaven/LeitorDeCSV</b></font>$ mvn -source 8 package
WARNING: An illegal reflective access operation has occurred
WARNING: Illegal reflective access by com.google.inject.internal.cglib.core.$ReflectUtils$1 (file:/usr/share/maven/lib/guice.jar) to method java.lang.ClassLoader.defineClass(java.lang.String,byte[],int,int,java.security.ProtectionDomain)
WARNING: Please consider reporting this to the maintainers of com.google.inject.internal.cglib.core.$ReflectUtils$1
WARNING: Use --illegal-access=warn to enable warnings of further illegal reflective access operations
WARNING: All illegal access operations will be denied in a future release
[<font color="#DC322F"><b>ERROR</b></font>] Error executing Maven.
[<font color="#DC322F"><b>ERROR</b></font>] The specified user settings file does not exist: /home/fabio/Documentos/ZZfiles/sobreMaven/LeitorDeCSV/ource
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sobreMaven/LeitorDeCSV</b></font>$ mvn package
WARNING: An illegal reflective access operation has occurred
WARNING: Illegal reflective access by com.google.inject.internal.cglib.core.$ReflectUtils$1 (file:/usr/share/maven/lib/guice.jar) to method java.lang.ClassLoader.defineClass(java.lang.String,byte[],int,int,java.security.ProtectionDomain)
WARNING: Please consider reporting this to the maintainers of com.google.inject.internal.cglib.core.$ReflectUtils$1
WARNING: Use --illegal-access=warn to enable warnings of further illegal reflective access operations
WARNING: All illegal access operations will be denied in a future release
[<font color="#268BD2"><b>INFO</b></font>] Scanning for projects...
[<font color="#268BD2"><b>INFO</b></font>] 
[<font color="#268BD2"><b>INFO</b></font>] <b>-------------------&lt; </b><font color="#2AA198">com.mycompany.app:LeitorDeCSV</font><b> &gt;--------------------</b>
[<font color="#268BD2"><b>INFO</b></font>] <b>Building LeitorDeCSV 1.0-SNAPSHOT</b>
[<font color="#268BD2"><b>INFO</b></font>] <b>--------------------------------[ jar ]---------------------------------</b>
[<font color="#268BD2"><b>INFO</b></font>] 
[<font color="#268BD2"><b>INFO</b></font>] <b>--- </b><font color="#859900">maven-resources-plugin:3.0.2:resources</font> <b>(default-resources)</b> @ <font color="#2AA198">LeitorDeCSV</font><b> ---</b>
[<font color="#268BD2"><b>INFO</b></font>] Using &apos;UTF-8&apos; encoding to copy filtered resources.
[<font color="#268BD2"><b>INFO</b></font>] skip non existing resourceDirectory /home/fabio/Documentos/ZZfiles/sobreMaven/LeitorDeCSV/src/main/resources
[<font color="#268BD2"><b>INFO</b></font>] 
[<font color="#268BD2"><b>INFO</b></font>] <b>--- </b><font color="#859900">maven-compiler-plugin:3.8.0:compile</font> <b>(default-compile)</b> @ <font color="#2AA198">LeitorDeCSV</font><b> ---</b>
[<font color="#268BD2"><b>INFO</b></font>] Changes detected - recompiling the module!
[<font color="#268BD2"><b>INFO</b></font>] Compiling 1 source file to /home/fabio/Documentos/ZZfiles/sobreMaven/LeitorDeCSV/target/classes
[<font color="#268BD2"><b>INFO</b></font>] 
[<font color="#268BD2"><b>INFO</b></font>] <b>--- </b><font color="#859900">maven-resources-plugin:3.0.2:testResources</font> <b>(default-testResources)</b> @ <font color="#2AA198">LeitorDeCSV</font><b> ---</b>
[<font color="#268BD2"><b>INFO</b></font>] Using &apos;UTF-8&apos; encoding to copy filtered resources.
[<font color="#268BD2"><b>INFO</b></font>] skip non existing resourceDirectory /home/fabio/Documentos/ZZfiles/sobreMaven/LeitorDeCSV/src/test/resources
[<font color="#268BD2"><b>INFO</b></font>] 
[<font color="#268BD2"><b>INFO</b></font>] <b>--- </b><font color="#859900">maven-compiler-plugin:3.8.0:testCompile</font> <b>(default-testCompile)</b> @ <font color="#2AA198">LeitorDeCSV</font><b> ---</b>
[<font color="#268BD2"><b>INFO</b></font>] Nothing to compile - all classes are up to date
[<font color="#268BD2"><b>INFO</b></font>] 
[<font color="#268BD2"><b>INFO</b></font>] <b>--- </b><font color="#859900">maven-surefire-plugin:2.22.1:test</font> <b>(default-test)</b> @ <font color="#2AA198">LeitorDeCSV</font><b> ---</b>
[<font color="#268BD2"><b>INFO</b></font>] 
[<font color="#268BD2"><b>INFO</b></font>] -------------------------------------------------------
[<font color="#268BD2"><b>INFO</b></font>]  T E S T S
[<font color="#268BD2"><b>INFO</b></font>] -------------------------------------------------------
[<font color="#268BD2"><b>INFO</b></font>] Running com.mycompany.app.<b>AppTest</b>
[<font color="#268BD2"><b>INFO</b></font>] <font color="#859900"><b>Tests run: 1</b></font>, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.042 s - in com.mycompany.app.<b>AppTest</b>
[<font color="#268BD2"><b>INFO</b></font>] 
[<font color="#268BD2"><b>INFO</b></font>] Results:
[<font color="#268BD2"><b>INFO</b></font>] 
[<font color="#268BD2"><b>INFO</b></font>] <font color="#859900"><b>Tests run: 1, Failures: 0, Errors: 0, Skipped: 0</b></font>
[<font color="#268BD2"><b>INFO</b></font>] 
[<font color="#268BD2"><b>INFO</b></font>] 
[<font color="#268BD2"><b>INFO</b></font>] <b>--- </b><font color="#859900">maven-jar-plugin:3.0.2:jar</font> <b>(default-jar)</b> @ <font color="#2AA198">LeitorDeCSV</font><b> ---</b>
[<font color="#268BD2"><b>INFO</b></font>] Building jar: /home/fabio/Documentos/ZZfiles/sobreMaven/LeitorDeCSV/target/LeitorDeCSV-1.0-SNAPSHOT.jar
[<font color="#268BD2"><b>INFO</b></font>] <b>------------------------------------------------------------------------</b>
[<font color="#268BD2"><b>INFO</b></font>] <font color="#859900"><b>BUILD SUCCESS</b></font>
[<font color="#268BD2"><b>INFO</b></font>] <b>------------------------------------------------------------------------</b>
[<font color="#268BD2"><b>INFO</b></font>] Total time:  3.253 s
[<font color="#268BD2"><b>INFO</b></font>] Finished at: 2021-02-21T15:14:55-03:00
[<font color="#268BD2"><b>INFO</b></font>] <b>------------------------------------------------------------------------</b>
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sobreMaven/LeitorDeCSV</b></font>$ 

</pre>

Compilou, agora executar:

`java -cp target/LeitorDeCSV-1.0-SNAPSHOT.jar com.mycompany.app.App`

<pre><font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sobreMaven/LeitorDeCSV</b></font>$ java -cp target/LeitorDeCSV-1.0-SNAPSHOT.jar com.mycompany.app.App
Erro: Não é possível inicializar a classe principal com.mycompany.app.App
Causado por: java.lang.NoClassDefFoundError: com/opencsv/exceptions/CsvException
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sobreMaven/LeitorDeCSV</b></font>$ 

</pre>

Desconfio que falta incluir o opencsv no classpath (embora eu fique me perguntando por quê precisa ser tão complicado).

<pre><font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sobreMaven/LeitorDeCSV</b></font>$ java -cp target/LeitorDeCSV-1.0-SNAPSHOT.jar:~/.m2/repository/com/opencsv/opencsv/5.3/opencsv-5.3.jar com.mycompany.app.App
Erro: Não é possível inicializar a classe principal com.mycompany.app.App
Causado por: java.lang.NoClassDefFoundError: com/opencsv/exceptions/CsvException
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sobreMaven/LeitorDeCSV</b></font>$ java -cp target/LeitorDeCSV-1.0-SNAPSHOT.jar:/home/fabio/.m2/repository/com/opencsv/opencsv/5.3/opencsv-5.3.jar com.mycompany.app.App
Hello World!
Exception in thread &quot;main&quot; java.io.FileNotFoundException: ./../../../../../test/files/backup.csv (Arquivo ou diretório inexistente)
	at java.base/java.io.FileInputStream.open0(Native Method)
	at java.base/java.io.FileInputStream.open(FileInputStream.java:219)
	at java.base/java.io.FileInputStream.&lt;init&gt;(FileInputStream.java:157)
	at java.base/java.io.FileInputStream.&lt;init&gt;(FileInputStream.java:112)
	at java.base/java.io.FileReader.&lt;init&gt;(FileReader.java:60)
	at com.mycompany.app.App.main(App.java:19)
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sobreMaven/LeitorDeCSV</b></font>$ 

</pre>

O programa foi executado, o classpath não aceita atalhos, só que tive que apontar para dentro da pasta escondida onde Maven guarda as dependências, algo que eu não esperaria que fosse necessário e acho que cria fragilidade no ambiente de execução...

Agora é acertar o caminho para o arquivo que estou usando como exemplo... agora é claro para mim que é a partir da pasta em que executo a aplicação, embora isto me faça apontar para `src/...`, o que soa contraditório.

<pre><font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sobreMaven/LeitorDeCSV</b></font>$ java -cp target/LeitorDeCSV-1.0-SNAPSHOT.jar:/home/fabio/.m2/repository/com/opencsv/opencsv/5.3/opencsv-5.3.jar com.mycompany.app.App
Hello World!
Exception in thread &quot;main&quot; java.lang.NoClassDefFoundError: org/apache/commons/lang3/ObjectUtils
	at com.opencsv.CSVParser.&lt;init&gt;(CSVParser.java:99)
	at com.opencsv.CSVReader.&lt;init&gt;(CSVReader.java:99)
	at com.mycompany.app.App.main(App.java:19)
Caused by: java.lang.ClassNotFoundException: org.apache.commons.lang3.ObjectUtils
	at java.base/jdk.internal.loader.BuiltinClassLoader.loadClass(BuiltinClassLoader.java:581)
	at java.base/jdk.internal.loader.ClassLoaders$AppClassLoader.loadClass(ClassLoaders.java:178)
	at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:522)
	... 3 more
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sobreMaven/LeitorDeCSV</b></font>$ 

</pre>

Agora o erro é por `lang3`, uma dependência de `opencsv`, que foi apontada no tutorial, vou ver se está na pasta `.m2` e incluo no classpath...

`java -cp target/LeitorDeCSV-1.0-SNAPSHOT.jar:/home/fabio/.m2/repository/com/opencsv/opencsv/5.3/opencsv-5.3.jar:/home/fabio/.m2/repository/org/apache/commons/commons-lang3/3.11/commons-lang3-3.11.jar com.mycompany.app.App`

Agora executou:

![alt text](sobreMaven/Captura%20de%20tela%20de%202021-02-21%2015-48-03.png)

É um sucesso estranho - *Vitória de Pirro* - pois para ler um CSV, que dá a impressão de ser simples, instalei várias bibliotecas, tive que me dar ao trabalho de encontrar onde as bibliotecas estão instaladas no meu computador e minhas "soluções" tem problemas que deixam o conjunto pouco robusto (para parar de funcionar é só mudar uma biblioteca de lugar).


