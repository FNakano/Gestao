
## Introdução

Ontologias para indoor são interessantes para sistemas de assistência à navegação indoor. Uma dessas ontologias é IndoorGML.

A mantenedora de IndoorGML codifica suas ontologias em XML-Schema (extensão usual `.xsd`). Embora também seja XML, o modelo de elementos é diferente do usado em XML:RDF, e, que eu saiba, Jena não contém parser para XML-Schema.

Para confirmar, tentei carregar a ontologia IndoorGML no servidor que tenho localmente. O resultado do lado do cliente foi uma mensagem de erro:

<pre><font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/git/Gestao</b></font>$ curl -X POST -d &apos;update= LOAD &lt;http://schemas.opengis.net/indoorgml/1.0/indoorgmlcore.xsd&gt;  &apos; localhost:3030/MeuSSN/update
Failed to LOAD &apos;http://schemas.opengis.net/indoorgml/1.0/indoorgmlcore.xsd&apos; :: Failed to determine the content type: (URI=http://schemas.opengis.net/indoorgml/1.0/indoorgmlcore.xsd : stream=application/xml)
</pre>

Do lado do servidor:

<pre>20:05:09 INFO  Fuseki          :: [97] POST http://localhost:3030/MeuSSN/update
20:05:10 WARN  Fuseki          :: [97] ActionErrorException with cause
org.apache.jena.fuseki.servlets.ActionErrorException: Failed to LOAD &apos;http://schemas.opengis.net/indoorgml/1.0/indoorgmlcore.xsd&apos; :: Failed to determine the content type: (URI=http://schemas.opengis.net/indoorgml/1.0/indoorgmlcore.xsd : stream=application/xml)
	at org.apache.jena.fuseki.servlets.ServletOps.errorOccurred(ServletOps.java:202) ~[fuseki-server.jar:3.17.0]
	at org.apache.jena.fuseki.servlets.SPARQL_Update.execute(SPARQL_Update.java:239) ~[fuseki-server.jar:3.17.0]
	at org.apache.jena.fuseki.servlets.SPARQL_Update.executeForm(SPARQL_Update.java:199) ~[fuseki-server.jar:3.17.0]
	at org.apache.jena.fuseki.servlets.SPARQL_Update.execute(SPARQL_Update.java:102) ~[fuseki-server.jar:3.17.0]
	at org.apache.jena.fuseki.servlets.ActionService.executeLifecycle(ActionService.java:58) ~[fuseki-server.jar:3.17.0]
	at org.apache.jena.fuseki.servlets.SPARQL_Update.execPost(SPARQL_Update.java:83) ~[fuseki-server.jar:3.17.0]
	at org.apache.jena.fuseki.servlets.ActionProcessor.process(ActionProcessor.java:34) ~[fuseki-server.jar:3.17.0]
	at org.apache.jena.fuseki.servlets.ActionBase.process(ActionBase.java:55) ~[fuseki-server.jar:3.17.0]
	at org.apache.jena.fuseki.servlets.ActionExecLib.execAction(ActionExecLib.java:106) ~[fuseki-server.jar:3.17.0]
	at org.apache.jena.fuseki.server.Dispatcher.dispatchAction(Dispatcher.java:118) ~[fuseki-server.jar:3.17.0]
	at org.apache.jena.fuseki.server.Dispatcher.process(Dispatcher.java:110) ~[fuseki-server.jar:3.17.0]
	at org.apache.jena.fuseki.server.Dispatcher.dispatch(Dispatcher.java:96) ~[fuseki-server.jar:3.17.0]
	at org.apache.jena.fuseki.servlets.FusekiFilter.doFilter(FusekiFilter.java:51) ~[fuseki-server.jar:3.17.0]
	at org.eclipse.jetty.servlet.FilterHolder.doFilter(FilterHolder.java:193) ~[fuseki-server.jar:3.17.0]
	at org.eclipse.jetty.servlet.ServletHandler$Chain.doFilter(ServletHandler.java:1601) ~[fuseki-server.jar:3.17.0]
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:61) ~[fuseki-server.jar:3.17.0]
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108) ~[fuseki-server.jar:3.17.0]
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137) ~[fuseki-server.jar:3.17.0]
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125) ~[fuseki-server.jar:3.17.0]
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66) ~[fuseki-server.jar:3.17.0]
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108) ~[fuseki-server.jar:3.17.0]
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137) ~[fuseki-server.jar:3.17.0]
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125) ~[fuseki-server.jar:3.17.0]
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66) ~[fuseki-server.jar:3.17.0]
	at org.apache.shiro.web.servlet.AbstractShiroFilter.executeChain(AbstractShiroFilter.java:450) ~[fuseki-server.jar:3.17.0]
	at org.apache.shiro.web.servlet.AbstractShiroFilter$1.call(AbstractShiroFilter.java:365) ~[fuseki-server.jar:3.17.0]
	at org.apache.shiro.subject.support.SubjectCallable.doCall(SubjectCallable.java:90) ~[fuseki-server.jar:3.17.0]
	at org.apache.shiro.subject.support.SubjectCallable.call(SubjectCallable.java:83) ~[fuseki-server.jar:3.17.0]
	at org.apache.shiro.subject.support.DelegatingSubject.execute(DelegatingSubject.java:387) ~[fuseki-server.jar:3.17.0]
	at org.apache.shiro.web.servlet.AbstractShiroFilter.doFilterInternal(AbstractShiroFilter.java:362) ~[fuseki-server.jar:3.17.0]
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125) ~[fuseki-server.jar:3.17.0]
	at org.eclipse.jetty.servlet.FilterHolder.doFilter(FilterHolder.java:193) ~[fuseki-server.jar:3.17.0]
	at org.eclipse.jetty.servlet.ServletHandler$Chain.doFilter(ServletHandler.java:1601) ~[fuseki-server.jar:3.17.0]
	at org.apache.jena.fuseki.servlets.CrossOriginFilter.handle(CrossOriginFilter.java:284) ~[fuseki-server.jar:3.17.0]
	at org.apache.jena.fuseki.servlets.CrossOriginFilter.doFilter(CrossOriginFilter.java:247) ~[fuseki-server.jar:3.17.0]
	at org.eclipse.jetty.servlet.FilterHolder.doFilter(FilterHolder.java:201) ~[fuseki-server.jar:3.17.0]
	at org.eclipse.jetty.servlet.ServletHandler$Chain.doFilter(ServletHandler.java:1601) ~[fuseki-server.jar:3.17.0]
	at org.eclipse.jetty.servlet.ServletHandler.doHandle(ServletHandler.java:548) ~[fuseki-server.jar:3.17.0]
	at org.eclipse.jetty.server.handler.ScopedHandler.handle(ScopedHandler.java:143) ~[fuseki-server.jar:3.17.0]
	at org.eclipse.jetty.security.SecurityHandler.handle(SecurityHandler.java:602) ~[fuseki-server.jar:3.17.0]
	at org.eclipse.jetty.server.handler.HandlerWrapper.handle(HandlerWrapper.java:127) ~[fuseki-server.jar:3.17.0]
	at org.eclipse.jetty.server.handler.ScopedHandler.nextHandle(ScopedHandler.java:235) ~[fuseki-server.jar:3.17.0]
	at org.eclipse.jetty.server.session.SessionHandler.doHandle(SessionHandler.java:1612) ~[fuseki-server.jar:3.17.0]
	at org.eclipse.jetty.server.handler.ScopedHandler.nextHandle(ScopedHandler.java:233) ~[fuseki-server.jar:3.17.0]
	at org.eclipse.jetty.server.handler.ContextHandler.doHandle(ContextHandler.java:1434) ~[fuseki-server.jar:3.17.0]
	at org.eclipse.jetty.server.handler.ScopedHandler.nextScope(ScopedHandler.java:188) ~[fuseki-server.jar:3.17.0]
	at org.eclipse.jetty.servlet.ServletHandler.doScope(ServletHandler.java:501) ~[fuseki-server.jar:3.17.0]
	at org.eclipse.jetty.server.session.SessionHandler.doScope(SessionHandler.java:1582) ~[fuseki-server.jar:3.17.0]
	at org.eclipse.jetty.server.handler.ScopedHandler.nextScope(ScopedHandler.java:186) ~[fuseki-server.jar:3.17.0]
	at org.eclipse.jetty.server.handler.ContextHandler.doScope(ContextHandler.java:1349) ~[fuseki-server.jar:3.17.0]
	at org.eclipse.jetty.server.handler.ScopedHandler.handle(ScopedHandler.java:141) ~[fuseki-server.jar:3.17.0]
	at org.eclipse.jetty.server.handler.gzip.GzipHandler.handle(GzipHandler.java:716) ~[fuseki-server.jar:3.17.0]
	at org.eclipse.jetty.server.handler.HandlerWrapper.handle(HandlerWrapper.java:127) ~[fuseki-server.jar:3.17.0]
	at org.eclipse.jetty.server.Server.handle(Server.java:516) ~[fuseki-server.jar:3.17.0]
	at org.eclipse.jetty.server.HttpChannel.lambda$handle$1(HttpChannel.java:383) ~[fuseki-server.jar:3.17.0]
	at org.eclipse.jetty.server.HttpChannel.dispatch(HttpChannel.java:556) [fuseki-server.jar:3.17.0]
	at org.eclipse.jetty.server.HttpChannel.handle(HttpChannel.java:375) [fuseki-server.jar:3.17.0]
	at org.eclipse.jetty.server.HttpConnection.onFillable(HttpConnection.java:273) [fuseki-server.jar:3.17.0]
	at org.eclipse.jetty.io.AbstractConnection$ReadCallback.succeeded(AbstractConnection.java:311) [fuseki-server.jar:3.17.0]
	at org.eclipse.jetty.io.FillInterest.fillable(FillInterest.java:105) [fuseki-server.jar:3.17.0]
	at org.eclipse.jetty.io.ChannelEndPoint$1.run(ChannelEndPoint.java:104) [fuseki-server.jar:3.17.0]
	at org.eclipse.jetty.util.thread.QueuedThreadPool.runJob(QueuedThreadPool.java:773) [fuseki-server.jar:3.17.0]
	at org.eclipse.jetty.util.thread.QueuedThreadPool$Runner.run(QueuedThreadPool.java:905) [fuseki-server.jar:3.17.0]
	at java.lang.Thread.run(Thread.java:834) [?:?]
Caused by: org.apache.jena.query.QueryException: Failed to LOAD &apos;http://schemas.opengis.net/indoorgml/1.0/indoorgmlcore.xsd&apos; :: Failed to determine the content type: (URI=http://schemas.opengis.net/indoorgml/1.0/indoorgmlcore.xsd : stream=application/xml)
	at org.apache.jena.sparql.lang.ParserARQUpdate._parse(ParserARQUpdate.java:78) ~[fuseki-server.jar:3.17.0]
	at org.apache.jena.sparql.lang.ParserARQUpdate.parse$(ParserARQUpdate.java:45) ~[fuseki-server.jar:3.17.0]
	at org.apache.jena.sparql.lang.UpdateParser.parse(UpdateParser.java:48) ~[fuseki-server.jar:3.17.0]
	at org.apache.jena.update.UpdateAction.parseExecute(UpdateAction.java:421) ~[fuseki-server.jar:3.17.0]
	at org.apache.jena.update.UpdateAction.parseExecute(UpdateAction.java:380) ~[fuseki-server.jar:3.17.0]
	at org.apache.jena.fuseki.servlets.SPARQL_Update.execute(SPARQL_Update.java:221) ~[fuseki-server.jar:3.17.0]
	... 62 more
Caused by: org.apache.jena.update.UpdateException: Failed to LOAD &apos;http://schemas.opengis.net/indoorgml/1.0/indoorgmlcore.xsd&apos; :: Failed to determine the content type: (URI=http://schemas.opengis.net/indoorgml/1.0/indoorgmlcore.xsd : stream=application/xml)
	at org.apache.jena.sparql.modify.UpdateEngineWorker.visit(UpdateEngineWorker.java:183) ~[fuseki-server.jar:3.17.0]
	at org.apache.jena.sparql.modify.request.UpdateLoad.visit(UpdateLoad.java:64) ~[fuseki-server.jar:3.17.0]
	at org.apache.jena.sparql.modify.UpdateVisitorSink.send(UpdateVisitorSink.java:46) ~[fuseki-server.jar:3.17.0]
	at org.apache.jena.sparql.modify.UpdateVisitorSink.send(UpdateVisitorSink.java:26) ~[fuseki-server.jar:3.17.0]
	at org.apache.jena.sparql.modify.UsingUpdateSink.send(UsingUpdateSink.java:61) ~[fuseki-server.jar:3.17.0]
	at org.apache.jena.sparql.modify.UsingUpdateSink.send(UsingUpdateSink.java:31) ~[fuseki-server.jar:3.17.0]
	at org.apache.jena.sparql.lang.SPARQLParserBase.emitUpdate(SPARQLParserBase.java:189) ~[fuseki-server.jar:3.17.0]
	at org.apache.jena.sparql.lang.arq.ARQParser.Update1(ARQParser.java:1657) ~[fuseki-server.jar:3.17.0]
	at org.apache.jena.sparql.lang.arq.ARQParser.Update(ARQParser.java:1573) ~[fuseki-server.jar:3.17.0]
	at org.apache.jena.sparql.lang.arq.ARQParser.UpdateUnit(ARQParser.java:61) ~[fuseki-server.jar:3.17.0]
	at org.apache.jena.sparql.lang.ParserARQUpdate._parse(ParserARQUpdate.java:62) ~[fuseki-server.jar:3.17.0]
	at org.apache.jena.sparql.lang.ParserARQUpdate.parse$(ParserARQUpdate.java:45) ~[fuseki-server.jar:3.17.0]
	at org.apache.jena.sparql.lang.UpdateParser.parse(UpdateParser.java:48) ~[fuseki-server.jar:3.17.0]
	at org.apache.jena.update.UpdateAction.parseExecute(UpdateAction.java:421) ~[fuseki-server.jar:3.17.0]
	at org.apache.jena.update.UpdateAction.parseExecute(UpdateAction.java:380) ~[fuseki-server.jar:3.17.0]
	at org.apache.jena.fuseki.servlets.SPARQL_Update.execute(SPARQL_Update.java:221) ~[fuseki-server.jar:3.17.0]
	... 62 more
Caused by: org.apache.jena.riot.RiotException: Failed to determine the content type: (URI=http://schemas.opengis.net/indoorgml/1.0/indoorgmlcore.xsd : stream=application/xml)
	at org.apache.jena.riot.RDFParser.parseURI(RDFParser.java:317) ~[fuseki-server.jar:3.17.0]
	at org.apache.jena.riot.RDFParser.parse(RDFParser.java:296) ~[fuseki-server.jar:3.17.0]
	at org.apache.jena.riot.RDFParserBuilder.parse(RDFParserBuilder.java:540) ~[fuseki-server.jar:3.17.0]
	at org.apache.jena.riot.RDFDataMgr.parseFromURI(RDFDataMgr.java:921) ~[fuseki-server.jar:3.17.0]
	at org.apache.jena.riot.RDFDataMgr.read(RDFDataMgr.java:550) ~[fuseki-server.jar:3.17.0]
	at org.apache.jena.riot.RDFDataMgr.read(RDFDataMgr.java:517) ~[fuseki-server.jar:3.17.0]
	at org.apache.jena.riot.RDFDataMgr.read(RDFDataMgr.java:470) ~[fuseki-server.jar:3.17.0]
	at org.apache.jena.riot.RDFDataMgr.read(RDFDataMgr.java:450) ~[fuseki-server.jar:3.17.0]
	at org.apache.jena.sparql.modify.UpdateEngineWorker.visit(UpdateEngineWorker.java:152) ~[fuseki-server.jar:3.17.0]
	at org.apache.jena.sparql.modify.request.UpdateLoad.visit(UpdateLoad.java:64) ~[fuseki-server.jar:3.17.0]
	at org.apache.jena.sparql.modify.UpdateVisitorSink.send(UpdateVisitorSink.java:46) ~[fuseki-server.jar:3.17.0]
	at org.apache.jena.sparql.modify.UpdateVisitorSink.send(UpdateVisitorSink.java:26) ~[fuseki-server.jar:3.17.0]
	at org.apache.jena.sparql.modify.UsingUpdateSink.send(UsingUpdateSink.java:61) ~[fuseki-server.jar:3.17.0]
	at org.apache.jena.sparql.modify.UsingUpdateSink.send(UsingUpdateSink.java:31) ~[fuseki-server.jar:3.17.0]
	at org.apache.jena.sparql.lang.SPARQLParserBase.emitUpdate(SPARQLParserBase.java:189) ~[fuseki-server.jar:3.17.0]
	at org.apache.jena.sparql.lang.arq.ARQParser.Update1(ARQParser.java:1657) ~[fuseki-server.jar:3.17.0]
	at org.apache.jena.sparql.lang.arq.ARQParser.Update(ARQParser.java:1573) ~[fuseki-server.jar:3.17.0]
	at org.apache.jena.sparql.lang.arq.ARQParser.UpdateUnit(ARQParser.java:61) ~[fuseki-server.jar:3.17.0]
	at org.apache.jena.sparql.lang.ParserARQUpdate._parse(ParserARQUpdate.java:62) ~[fuseki-server.jar:3.17.0]
	at org.apache.jena.sparql.lang.ParserARQUpdate.parse$(ParserARQUpdate.java:45) ~[fuseki-server.jar:3.17.0]
	at org.apache.jena.sparql.lang.UpdateParser.parse(UpdateParser.java:48) ~[fuseki-server.jar:3.17.0]
	at org.apache.jena.update.UpdateAction.parseExecute(UpdateAction.java:421) ~[fuseki-server.jar:3.17.0]
	at org.apache.jena.update.UpdateAction.parseExecute(UpdateAction.java:380) ~[fuseki-server.jar:3.17.0]
	at org.apache.jena.fuseki.servlets.SPARQL_Update.execute(SPARQL_Update.java:221) ~[fuseki-server.jar:3.17.0]
	... 62 more
20:05:10 INFO  Fuseki          :: [97] 500 Server Error (1,439 s)
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/apache-jena-fuseki-3.17.0</b></font>$ 

</pre>

Ainda assim, gostaria de usar essa ontologia, então, consultei colegas que, entre outras sugestões, apontaram para [ontmalizer](https://github.com/srdc/ontmalizer). Em uma frase, é um tradutor de formatos de ontologias que contempla XSD para RDF.


## Método

Pretendo clonar o repositório, compilar, testar o exemplo que vem com ele, aplicar sobre IndoorGML, testar o resultado com [Protege](https://protege.stanford.edu/products.php#desktop-protege) e/ou com [Fuseki](https://jena.apache.org/documentation/fuseki2/).

### Clonar

Na pasta onde tenho os clones de repositórios git, uso o comando `git clone https://github.com/srdc/ontmalizer.git`. isto cria a pasta ontmalizer e clona o repositório.

### Compilar

Ontmalizer usa o gerenciador de projetos [maven](http://maven.apache.org/). Na versão de ubuntu que uso, maven vem pré-instalado:

<pre><font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~</b></font>$ mvn --version
<b>Apache Maven 3.6.3</b>
Maven home: /usr/share/maven
Java version: 11.0.9.1, vendor: Ubuntu, runtime: /usr/lib/jvm/java-11-openjdk-amd64
Default locale: pt_BR, platform encoding: UTF-8
OS name: &quot;linux&quot;, version: &quot;5.8.0-36-generic&quot;, arch: &quot;amd64&quot;, family: &quot;unix&quot;
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~</b></font>$ 
</pre>

<pre><font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~</b></font>$ cat /etc/os-release 
NAME=&quot;Ubuntu&quot;
VERSION=&quot;20.04.1 LTS (Focal Fossa)&quot;
ID=ubuntu
ID_LIKE=debian
PRETTY_NAME=&quot;Ubuntu 20.04.1 LTS&quot;
VERSION_ID=&quot;20.04&quot;
HOME_URL=&quot;https://www.ubuntu.com/&quot;
SUPPORT_URL=&quot;https://help.ubuntu.com/&quot;
BUG_REPORT_URL=&quot;https://bugs.launchpad.net/ubuntu/&quot;
PRIVACY_POLICY_URL=&quot;https://www.ubuntu.com/legal/terms-and-policies/privacy-policy&quot;
VERSION_CODENAME=focal
UBUNTU_CODENAME=focal
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~</b></font>$ 
</pre>

<pre><font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/apache-jena-3.17.0/bin</b></font>$ ./arq --version
Jena:       VERSION: 3.17.0
Jena:       BUILD_DATE: 2020-11-25T19:40:23+0000
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/apache-jena-3.17.0/bin</b></font>$ 
</pre>

<pre><font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~</b></font>$ java --version
openjdk 11.0.9.1 2020-11-04
OpenJDK Runtime Environment (build 11.0.9.1+1-Ubuntu-0ubuntu1.20.04)
OpenJDK 64-Bit Server VM (build 11.0.9.1+1-Ubuntu-0ubuntu1.20.04, mixed mode, sharing)
</pre>

Seguindo as instruções do repositório, `mvn install` baixou as dependências, compilou e testou.

### Truque sujo.

> ... porque, na minha opinião, é rápido, resolve, mas é pouco instrutivo.

Como instalou com sucesso e um dos testes é converter de XSD para RDF, então troquei o arquivo de entrada do teste por uma cópia de [indoorgmlcore.xsd](http://schemas.opengis.net/indoorgml/1.0/) e executei os testes com `mvn test`. O arquivo resultante, carreguei no Protegé, que apresentou muitos erros. Na época, não fui adiante (analisar os erros, testar outra ferramenta,...) e interrompi. Esta é a retomada.

### Meu código simples e linha de comando.

> ... tenho algo com ambientes integrados...

Baseado no teste, que não tem método main, e na documentação do ontmalizer, criei o arquivo [MinhaClasse.java](MinhaClasse.java).

```java

/**
 *
 */
//package tr.com.srdc.ontmalizer.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.Writer;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tr.com.srdc.ontmalizer.XSD2OWLMapper;

public class MinhaClasse {
    public static void main(String[] args) throws Exception {

        // This part converts XML schema to OWL ontology.
        XSD2OWLMapper mapping = new XSD2OWLMapper(new File("indoorgmlnavi.xsd"));
        mapping.setObjectPropPrefix("");
        mapping.setDataTypePropPrefix("");
        mapping.convertXSD2OWL();

        // This part prints the ontology to the specified file.
        FileOutputStream ont;
//        try {
            File f = new File("indoorgmlnavi.owl");
//             f.getParentFile().mkdirs();
            ont = new FileOutputStream(f);
//            mapping.writeOntology(ont, "N3");
            mapping.writeOntology(ont, "RDF/XML");
            ont.close();
//        } catch (Exception e) {
//            LOGGER.error("{}", e.getMessage());
//        }
    }
}

```

Ontmalizer, compilado, é uma bibliteca `jar`, armazenada em `ontmalizer/target/`. Na versão que baixei, é `ontmalizer-1.0.3.jar`.

Os testes são feitos usando [jUnit](http://junit.sourceforge.net/doc/cookbook/cookbook.htm) e há log de funcionamento usando [sl4fj](http://www.slf4j.org/). Creio eu, que isto é inserido pelo maven como padrão. Para meu alívio, constam do `pom.xml`. Estas bibliotecas também são `jar`, mas são armazenadas em pastas ocultas. Achei buscando pelo nome:

<pre><font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~</b></font>$ find . -name junit*
./ugsplatform/java/docs/junit-jupiter-api-5.3.1-javadoc.jar
./ugsplatform/java/docs/junit-jupiter-api-5.3.1-sources.jar
./ugsplatform/java/docs/junit-jupiter-engine-5.3.1-sources.jar
./ugsplatform/java/docs/junit-4.12-sources.jar
./ugsplatform/java/docs/junit-jupiter-engine-5.3.1-javadoc.jar
./ugsplatform/java/docs/junit-jupiter-params-5.3.1-sources.jar
./ugsplatform/java/docs/junit-jupiter-params-5.3.1-javadoc.jar
./ugsplatform/java/docs/junit-4.12-javadoc.jar
./ugsplatform/platform/modules/ext/junit-4.12.jar
./ugsplatform/platform/modules/ext/junit-jupiter-engine-5.3.1.jar
./ugsplatform/platform/modules/ext/junit-jupiter-api-5.3.1.jar
./ugsplatform/platform/modules/ext/junit-jupiter-params-5.3.1.jar
./.gradle/wrapper/dists/gradle-5.2.1-all/bviwmvmbexq6idcscbicws5me/gradle-5.2.1/samples/testing/junitplatform
./.gradle/wrapper/dists/gradle-5.2.1-all/bviwmvmbexq6idcscbicws5me/gradle-5.2.1/samples/testing/junitplatform/tagging/groovy/src/test/java/org/gradle/junitplatform
./.gradle/wrapper/dists/gradle-5.2.1-all/bviwmvmbexq6idcscbicws5me/gradle-5.2.1/samples/testing/junitplatform/tagging/groovy/src/main/java/org/gradle/junitplatform
./.gradle/wrapper/dists/gradle-5.2.1-all/bviwmvmbexq6idcscbicws5me/gradle-5.2.1/samples/testing/junitplatform/tagging/kotlin/src/test/java/org/gradle/junitplatform
./.gradle/wrapper/dists/gradle-5.2.1-all/bviwmvmbexq6idcscbicws5me/gradle-5.2.1/samples/testing/junitplatform/tagging/kotlin/src/main/java/org/gradle/junitplatform
./.gradle/wrapper/dists/gradle-5.2.1-all/bviwmvmbexq6idcscbicws5me/gradle-5.2.1/samples/testing/junitplatform/mix/groovy/src/test/java/org/gradle/junitplatform
./.gradle/wrapper/dists/gradle-5.2.1-all/bviwmvmbexq6idcscbicws5me/gradle-5.2.1/samples/testing/junitplatform/mix/kotlin/src/test/java/org/gradle/junitplatform
./.gradle/wrapper/dists/gradle-5.2.1-all/bviwmvmbexq6idcscbicws5me/gradle-5.2.1/samples/testing/junitplatform/engine/groovy/src/test/java/org/gradle/junitplatform
./.gradle/wrapper/dists/gradle-5.2.1-all/bviwmvmbexq6idcscbicws5me/gradle-5.2.1/samples/testing/junitplatform/engine/kotlin/src/test/java/org/gradle/junitplatform
./.gradle/wrapper/dists/gradle-5.2.1-all/bviwmvmbexq6idcscbicws5me/gradle-5.2.1/samples/testing/junitplatform/jupiter/groovy/src/test/java/org/gradle/junitplatform
./.gradle/wrapper/dists/gradle-5.2.1-all/bviwmvmbexq6idcscbicws5me/gradle-5.2.1/samples/testing/junitplatform/jupiter/kotlin/src/test/java/org/gradle/junitplatform
./.gradle/wrapper/dists/gradle-5.2.1-all/bviwmvmbexq6idcscbicws5me/gradle-5.2.1/samples/testing/junit
./.gradle/wrapper/dists/gradle-5.2.1-all/bviwmvmbexq6idcscbicws5me/gradle-5.2.1/samples/testing/junit/categories/groovy/src/test/java/org/gradle/junit
./.gradle/wrapper/dists/gradle-5.2.1-all/bviwmvmbexq6idcscbicws5me/gradle-5.2.1/samples/testing/junit/categories/kotlin/src/test/java/org/gradle/junit
./.gradle/wrapper/dists/gradle-5.2.1-all/bviwmvmbexq6idcscbicws5me/gradle-5.2.1/samples/testKit/gradleRunner/junitQuickstart
./.gradle/wrapper/dists/gradle-5.2.1-all/bviwmvmbexq6idcscbicws5me/gradle-5.2.1/lib/plugins/junit-4.12.jar
./.gradle/wrapper/dists/gradle-5.2.1-all/bviwmvmbexq6idcscbicws5me/gradle-5.2.1/lib/plugins/junit-platform-engine-1.3.1.jar
./.gradle/wrapper/dists/gradle-5.2.1-all/bviwmvmbexq6idcscbicws5me/gradle-5.2.1/lib/plugins/junit-platform-commons-1.3.1.jar
./.gradle/wrapper/dists/gradle-5.2.1-all/bviwmvmbexq6idcscbicws5me/gradle-5.2.1/lib/plugins/junit-platform-launcher-1.3.1.jar
./.gradle/wrapper/dists/gradle-5.2.1-all/bviwmvmbexq6idcscbicws5me/gradle-5.2.1/docs/javadoc/org/gradle/api/tasks/testing/junitplatform
./.gradle/wrapper/dists/gradle-5.2.1-all/bviwmvmbexq6idcscbicws5me/gradle-5.2.1/docs/javadoc/org/gradle/api/tasks/testing/junit
./.gradle/wrapper/dists/gradle-5.2.1-all/bviwmvmbexq6idcscbicws5me/gradle-5.2.1/src/testing-junit-platform/org/gradle/api/internal/tasks/testing/junitplatform
./.gradle/wrapper/dists/gradle-5.2.1-all/bviwmvmbexq6idcscbicws5me/gradle-5.2.1/src/internal-integ-testing/org/gradle/test/fixtures/junitplatform
./.gradle/wrapper/dists/gradle-5.2.1-all/bviwmvmbexq6idcscbicws5me/gradle-5.2.1/src/testing-jvm/org/gradle/api/tasks/testing/junitplatform
./.gradle/wrapper/dists/gradle-5.2.1-all/bviwmvmbexq6idcscbicws5me/gradle-5.2.1/src/testing-jvm/org/gradle/api/tasks/testing/junit
./.gradle/wrapper/dists/gradle-5.2.1-all/bviwmvmbexq6idcscbicws5me/gradle-5.2.1/src/testing-jvm/org/gradle/api/internal/tasks/testing/junitplatform
./.gradle/wrapper/dists/gradle-5.2.1-all/bviwmvmbexq6idcscbicws5me/gradle-5.2.1/src/testing-jvm/org/gradle/api/internal/tasks/testing/junit
./.gradle/wrapper/dists/gradle-5.2.1-all/bviwmvmbexq6idcscbicws5me/gradle-5.2.1/src/testing-base/org/gradle/api/internal/tasks/testing/junit
./.gradle/caches/modules-2/metadata-2.69/descriptors/org.junit/junit-bom
./.gradle/caches/modules-2/metadata-2.69/descriptors/junit
./.gradle/caches/modules-2/metadata-2.69/descriptors/junit/junit
./.gradle/caches/modules-2/files-2.1/org.junit/junit-bom
./.gradle/caches/modules-2/files-2.1/org.junit/junit-bom/5.5.2/83531b7b0cd389ca2f8f8d6abe556d4f1ab2a1cf/junit-bom-5.5.2.pom
./.gradle/caches/modules-2/files-2.1/junit
./.gradle/caches/modules-2/files-2.1/junit/junit
./.gradle/caches/modules-2/files-2.1/junit/junit/4.12/2973d150c0dc1fefe998f834810d68f278ea58ec/junit-4.12.jar
./.gradle/caches/modules-2/files-2.1/junit/junit/4.12/35fb238baee3f3af739074d723279ebea2028398/junit-4.12.pom
./.m2/repository/junit
./.m2/repository/junit/junit
./.m2/repository/junit/junit/3.8.2/junit-3.8.2.jar.sha1
./.m2/repository/junit/junit/3.8.2/junit-3.8.2.jar
./.m2/repository/junit/junit/3.8.2/junit-3.8.2.pom
./.m2/repository/junit/junit/3.8.2/junit-3.8.2.pom.sha1
./.m2/repository/junit/junit/4.11/junit-4.11.pom.sha1
./.m2/repository/junit/junit/4.11/junit-4.11.jar
./.m2/repository/junit/junit/4.11/junit-4.11.jar.sha1
./.m2/repository/junit/junit/4.11/junit-4.11.pom
./.m2/repository/junit/junit/3.8.1/junit-3.8.1.pom
./.m2/repository/junit/junit/3.8.1/junit-3.8.1.pom.sha1
./.m2/repository/junit/junit/3.8.1/junit-3.8.1.jar.sha1
./.m2/repository/junit/junit/3.8.1/junit-3.8.1.jar
./Documentos/git/domotic-swot/client/node_modules/eslint/lib/cli-engine/formatters/junit.js
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~</b></font>$ 


</pre>

<pre><font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/.m2</b></font>$ cd repository/
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/.m2/repository</b></font>$ ls
<font color="#268BD2"><b>backport-util-concurrent</b></font>  <font color="#268BD2"><b>commons-codec</b></font>    <font color="#268BD2"><b>log4j</b></font>            <font color="#268BD2"><b>xerces</b></font>
<font color="#268BD2"><b>ch</b></font>                        <font color="#268BD2"><b>commons-io</b></font>       <font color="#268BD2"><b>net</b></font>              <font color="#268BD2"><b>xml-apis</b></font>
<font color="#268BD2"><b>classworlds</b></font>               <font color="#268BD2"><b>commons-lang</b></font>     <font color="#268BD2"><b>org</b></font>
<font color="#268BD2"><b>com</b></font>                       <font color="#268BD2"><b>commons-logging</b></font>  <font color="#268BD2"><b>relaxngDatatype</b></font>
<font color="#268BD2"><b>commons-cli</b></font>               <font color="#268BD2"><b>junit</b></font>            <font color="#268BD2"><b>tr</b></font>
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/.m2/repository</b></font>$ find . -name sl
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/.m2/repository</b></font>$ find . -name slf4j
./org/slf4j
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/.m2/repository</b></font>$ cd org/slf4j/
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/.m2/repository/org/slf4j</b></font>$ ls
<font color="#268BD2"><b>jcl-over-slf4j</b></font>  <font color="#268BD2"><b>slf4j-api</b></font>  <font color="#268BD2"><b>slf4j-jdk14</b></font>  <font color="#268BD2"><b>slf4j-parent</b></font>
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/.m2/repository/org/slf4j</b></font>$ find . -name *.jav
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/.m2/repository/org/slf4j</b></font>$ find . -name *.jar
./slf4j-api/1.7.25/slf4j-api-1.7.25.jar
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/.m2/repository/org/slf4j</b></font>$ cd slf4j-api/
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/.m2/repository/org/slf4j/slf4j-api</b></font>$ ls
<font color="#268BD2"><b>1.5.6</b></font>  <font color="#268BD2"><b>1.7.20</b></font>  <font color="#268BD2"><b>1.7.25</b></font>
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/.m2/repository/org/slf4j/slf4j-api</b></font>$ cd 1.7.25
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/.m2/repository/org/slf4j/slf4j-api/1.7.25</b></font>$ ls
_remote.repositories  slf4j-api-1.7.25.jar.sha1  slf4j-api-1.7.25.pom.sha1
<font color="#DC322F"><b>slf4j-api-1.7.25.jar</b></font>  slf4j-api-1.7.25.pom
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/.m2/repository/org/slf4j/slf4j-api/1.7.25</b></font>$ pwd
/home/fabio/.m2/repository/org/slf4j/slf4j-api/1.7.25
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/.m2/repository/org/slf4j/slf4j-api/1.7.25</b></font>$ 
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/.m2/repository/org/slf4j/slf4j-api/1.7.25</b></font>$ ls
_remote.repositories  slf4j-api-1.7.25.jar.sha1  slf4j-api-1.7.25.pom.sha1
<font color="#DC322F"><b>slf4j-api-1.7.25.jar</b></font>  slf4j-api-1.7.25.pom
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/.m2/repository/org/slf4j/slf4j-api/1.7.25</b></font>$ cd ..
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/.m2/repository/org/slf4j/slf4j-api</b></font>$ ls
<font color="#268BD2"><b>1.5.6</b></font>  <font color="#268BD2"><b>1.7.20</b></font>  <font color="#268BD2"><b>1.7.25</b></font>
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/.m2/repository/org/slf4j/slf4j-api</b></font>$ cd ..
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/.m2/repository/org/slf4j</b></font>$ ls
<font color="#268BD2"><b>jcl-over-slf4j</b></font>  <font color="#268BD2"><b>slf4j-api</b></font>  <font color="#268BD2"><b>slf4j-jdk14</b></font>  <font color="#268BD2"><b>slf4j-parent</b></font>
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/.m2/repository/org/slf4j</b></font>$ ls jcl-over-slf4j/
<font color="#268BD2"><b>1.5.6</b></font>
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/.m2/repository/org/slf4j</b></font>$ ls slf4j-jdk14/
<font color="#268BD2"><b>1.5.6</b></font>
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/.m2/repository/org/slf4j</b></font>$ ll slf4j-parent/
total 20
drwxrwxr-x 5 fabio fabio 4096 nov 12 16:04 <font color="#268BD2"><b>.</b></font>/
drwxrwxr-x 6 fabio fabio 4096 nov 12 16:04 <font color="#268BD2"><b>..</b></font>/
drwxrwxr-x 2 fabio fabio 4096 nov 12 16:04 <font color="#268BD2"><b>1.5.6</b></font>/
drwxrwxr-x 2 fabio fabio 4096 nov 12 16:03 <font color="#268BD2"><b>1.7.20</b></font>/
drwxrwxr-x 2 fabio fabio 4096 nov 12 16:03 <font color="#268BD2"><b>1.7.25</b></font>/
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/.m2/repository/org/slf4j</b></font>$ ls
<font color="#268BD2"><b>jcl-over-slf4j</b></font>  <font color="#268BD2"><b>slf4j-api</b></font>  <font color="#268BD2"><b>slf4j-jdk14</b></font>  <font color="#268BD2"><b>slf4j-parent</b></font>
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/.m2/repository/org/slf4j</b></font>$ find . -name *.jar
./slf4j-api/1.7.25/slf4j-api-1.7.25.jar
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/.m2/repository/org/slf4j</b></font>$ find . -name &quot;*.jar&quot;
./slf4j-api/1.7.25/slf4j-api-1.7.25.jar
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/.m2/repository/org/slf4j</b></font>$ 

</pre>
 
**nota**: há várias versões em vários gerenciadores. Maven armazena na pasta oculta `.m2`, gradle em `.gradle`.

Ontmalizer é construído sobre `XSDefinition`, veja no [código fonte](https://github.com/srdc/ontmalizer/blob/master/src/main/java/tr/com/srdc/ontmalizer/XSD2OWLMapper.java).

[Foto](Imagens/Captura%20de%20tela%20de%202021-01-14%2021-55-32.png)

Para conseguir `XSDefinition`, usei o serviço: <https://jar-download.com/artifacts/com.sun.xsom/xsom/20070323/source-code/com/sun/xml/xsom/XSDeclaration.java>, recebi dois arquivos: `xsom-20140925.jar` e `relaxngDatatype-20020414.jar`.

No fim, os comandos ficaram:

`javac -cp "./:/home/fabio/Documentos/git/ontmalizer/target/ontmalizer-1.0.3.jar:/home/fabio/.m2/repository/junit/junit/4.11/junit-4.11.jar:/home/fabio/.m2/repository/org/slf4j/slf4j-api/1.7.25/slf4j-api-1.7.25.jar:./xsom-20140925.jar:/home/fabio/apache-jena-3.17.0/lib/*:./relaxngDatatype-20020414.jar" MinhaClasse.java`

`java -cp "./:/home/fabio/Documentos/git/ontmalizer/target/ontmalizer-1.0.3.jar:/home/fabio/.m2/repository/junit/junit/4.11/junit-4.11.jar:/home/fabio/.m2/repository/org/slf4j/slf4j-api/1.7.25/slf4j-api-1.7.25.jar:./xsom-20140925.jar:/home/fabio/apache-jena-3.17.0/lib/*:./relaxngDatatype-20020414.jar" MinhaClasse`

<pre><font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/TesteOntmalizer</b></font>$ javac -cp &quot;./:/home/fabio/Documentos/git/ontmalizer/target/ontmalizer-1.0.3.jar:/home/fabio/.m2/repository/junit/junit/4.11/junit-4.11.jar:/home/fabio/.m2/repository/org/slf4j/slf4j-api/1.7.25/slf4j-api-1.7.25.jar:./xsom-20140925.jar:/home/fabio/apache-jena-3.17.0/lib/*:./relaxngDatatype-20020414.jar&quot; MinhaClasse.java
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/TesteOntmalizer</b></font>$ java -cp &quot;./:/home/fabio/Documentos/git/ontmalizer/target/ontmalizer-1.0.3.jar:/home/fabio/.m2/repository/junit/junit/4.11/junit-4.11.jar:/home/fabio/.m2/repository/org/slf4j/slf4j-api/1.7.25/slf4j-api-1.7.25.jar:./xsom-20140925.jar:/home/fabio/apache-jena-3.17.0/lib/*:./relaxngDatatype-20020414.jar&quot; MinhaClasse
</pre>

A execução leva uns minutos. Creio que acessa recursos na web.

### Carga no Protegé

Foi o mesmo resultado do truque sujo, mas olhei direito as mensagens de erro e não parecem muito graves.

![Captura da tela](Imagens/Captura%20de%20tela%20de%202021-01-14%2012-09-38.png)

### Carga no Fuseki

Pela interface web do Fuseki, criei um novo dataset e fiz o upload dos arquivos.

![alt text](Imagens/Captura%20de%20tela%20de%202021-01-14%2017-07-18.png)

### Consulta SPARQL

Usei uma consulta padrão:

![alt text](Imagens/Captura%20de%20tela%20de%202021-01-14%2017-19-48.png)

## Referências

### jUnit, logger

https://www.google.com/search?channel=fs&client=ubuntu&q=java+include+jar+file+in+classpath
https://javarevisited.blogspot.com/2012/10/5-ways-to-add-multiple-jar-to-classpath-java.html#axzz6jWa5LeMx
https://stackoverflow.com/questions/9395207/how-to-include-jar-files-with-java-file-and-compile-in-command-prompt/9395928
https://www.google.com/search?client=ubuntu&hs=Omk&channel=fs&sxsrf=ALeKk03RS60uvTExkkPnxu9DDfgBF2xMYw%3A1610627872353&ei=IDsAYMT1FMqV5OUP8MW38AE&q=package+org.junit+does+not+exist+command+line&oq=package+org.junit+does+not+exist+command+line&gs_lcp=CgZwc3ktYWIQAzIFCAAQywEyBggAEBYQHjIGCAAQFhAeOgQIABBHOgIIAFDXsANYk8QDYI7GA2gAcAJ4AIABuAGIAf0NkgEEMC4xM5gBAKABAaoBB2d3cy13aXrIAQjAAQE&sclient=psy-ab&ved=0ahUKEwjEhcmxuJvuAhXKCrkGHfDiDR4Q4dUDCAw&uact=5
https://stackoverflow.com/questions/5845990/maven-3-and-junit-4-compilation-problem-package-org-junit-does-not-exist
https://stackoverflow.com/questions/12403497/maven-error-package-org-junit-does-not-exist/54343425
https://talk.openmrs.org/t/failing-to-run-junit-test-in-intellij/24111
https://github.com/s3529120/septsem12017/issues/26
https://stackoverflow.com/questions/27363310/javac-junit-gives-error-package-org-junit-does-not-exist
http://tutoringcenter.cs.usfca.edu/resources/using-java-via-command-line.html
https://github.com/redhat-developer/vscode-java/issues/91
https://ubuntuforums.org/showthread.php?t=1089950
https://www.google.com/search?channel=fs&client=ubuntu&q=java+%40test
https://www.devmedia.com.br/junit-tutorial/1432
https://stackoverflow.com/questions/7455931/java-before-and-test-annotation/7456598
http://junit.sourceforge.net/doc/cookbook/cookbook.htm
https://www.alura.com.br/conteudo/tdd
http://www.slf4j.org/codes.html#StaticLoggerBinder
http://www.slf4j.org/
https://www.google.com/search?channel=fs&client=ubuntu&q=java+file.getparentfile%28%29.mkdirs%28%29
https://docs.oracle.com/javase/7/docs/api/java/io/File.html#getParentFile()
https://stackoverflow.com/questions/4040624/how-to-create-a-file-including-folders-for-a-given-path

### XSDefinition

https://stackoverflow.com/questions/36557308/caused-by-java-lang-classnotfoundexception-com-sun-xml-bind-v2-model-annotatio
https://www.google.com/search?channel=fs&client=ubuntu&q=com.sun.xml.xsom.XSDeclaration
https://jar-download.com/artifacts/com.sun.xsom/xsom/20070323/source-code/com/sun/xml/xsom/XSDeclaration.java
https://jar-download.com/download-handling.php

