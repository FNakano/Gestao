# Primeiro Servlet

Busca e teste:  i:2021-03-28 11:17 f:2021-03-28 15:48
Documentação: i:2021-03-28 15:48 f:2021-03-28 20:31

## Objetivo

Escrever, compilar e implantar um servlet com ferramentas "mínimas".

## Motivação

Apresentar a estrutura de um `Servlet` simples, sua construção e implantação.

Ideologia ou idiossincrasia?

Anacronismo, talvez?

... apenas alegria em consequência de um (pequeno?) êxito?

## Introdução

Foi fácil encontrar, na Internet, diversas referências demonstrando o primeiro `Servlet` com o uso de uma IDE. [Exemplo](https://www.devmedia.com.br/servlet-tutorial/27841)

IDEs e programas para gestão de ciclo de vida de *software* têm grandes méritos. Entre eles, o de aumentar a produtividade do programador, através, entre outras funcionalidades, da automação de tarefas.

Automatizar também oculta a atividade, a informação e o conhecimento associados, o que pode tornar mais difícil a compreensão do todo. Levando ao extremo, resulta em programas e processos que ninguém sabe como funciona (mágica?), muito menos como trazer de volta ao funcionamento (quando parar de funcionar).

Acrescenta-se a isso que estou construindo algumas ferramentas e para isso pretendo usar `Servlets`. Aproveitei para aprender um pouco mais, mas achar as respostas para minhas perguntas acabou tomando mais tempo do que eu esperava. Perguntas como: 

- Como funciona um `Servlet`: como é executado, de onde recebe mensagens, para onde envia mensagens,...
- Que arquivos compõe um `Servlet`? Como são organizados?
- Como compilar um `Servlet`?
- Como implantar um `Servlet`?

[Esta referência](https://www3.ntu.edu.sg/home/ehchua/programming/java/JavaServlets.html) contém a maioria das respostas, mas está bem longe de ser a primeira oferecida pelo buscador. Pelo tempo que levei para chegar a ela e sua utilidade, vale a pena deixar documentado.

Segue abaixo o que fiz e os arquivos que acredito que sejam necessários.

## Resultados

### Pré-condições (e justificativas)

A compilação depende de pacotes de classes (`.jar`) que existem em JavaEE, por exemplo, `javax.servlet.http.*`. Há muitas formas de consegui-los. São mais usadas:

- Baixar junto com Eclipse IDE para desenvolvimento web;
- Baixar junto como o Java EE da Oracle;
- Baixar junto com Tomcat;
- Baixar junto com Glassfish.

Das opções preferi a terceira. Como não quero instalar Tomcat localmente, fiz a compilação, remotamente, no servidor em que Tomcat é executado. Desta forma:

- não preciso instalar outros programas na máquina local;
- preciso copiar arquivo entre as máquinas.

### Estrutura de diretórios do `servlet`

A estrutura genérica inicial, acredito que também seja a estrutura mínima é: 

```
         `-- WEB-INF
           |-- classes
           |-- src
```

Segundo a referência, para ser executado, o código-fonte deve estar dentro de um pacote e este dentro da pasta `src`:

```
webapps
 `-- HelloServlet
         `-- WEB-INF
           |-- classes
           |-- src
                `-- mypkg
                      `-- HelloServlet.java (criado pelo programador)
```

### Código-fonte

O arquivo `HelloServlet.java`:

```java
// To save as "<CATALINA_HOME>\webapps\helloservlet\WEB-INF\src\mypkg\HelloServlet.java"
package mypkg;
 
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
 
public class HelloServlet extends HttpServlet {
   @Override
   public void doGet(HttpServletRequest request, HttpServletResponse response)
               throws IOException, ServletException {
      // Set the response message's MIME type
      response.setContentType("text/html;charset=UTF-8");
      // Allocate a output writer to write the response message into the network socket
      PrintWriter out = response.getWriter();
 
      // Write the response message, in an HTML page
      try {
         out.println("<!DOCTYPE html>");
         out.println("<html><head>");
         out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
         out.println("<title>Hello, World</title></head>");
         out.println("<body>");
         out.println("<h1>Hello, world!</h1>");  // says Hello
         // Echo client's request information
         out.println("<p>Request URI: " + request.getRequestURI() + "</p>");
         out.println("<p>Protocol: " + request.getProtocol() + "</p>");
         out.println("<p>PathInfo: " + request.getPathInfo() + "</p>");
         out.println("<p>Remote Address: " + request.getRemoteAddr() + "</p>");
         // Generate a random number upon each request
         out.println("<p>A Random Number: <strong>" + Math.random() + "</strong></p>");
         out.println("</body>");
         out.println("</html>");
      } finally {
         out.close();  // Always close the output writer
      }
   }
}
```

### Onde estão os pacotes?

Segundo a referência, na pasta onde está Tomcat existe uma pasta `lib`.
Instalei Tomcat de acordo com estas [instruções em Digital Ocean](https://www.digitalocean.com/community/tutorials/install-tomcat-9-ubuntu-1804-pt). Desta forma, Tomcat está em `/opt/tomcat/` e as sub-pastas estão protegidas, mesmo para leitura. Resultado do `ls`:

<pre>

<font color="#859900"><b>fabio@ip-50-62-81-50</b></font>:<font color="#268BD2"><b>~/HelloServlet/webapps/HelloServlet/WEB-INF</b></font>$ sudo ls /opt/tomcat/lib/
annotations-api.jar	  jaspic-api.jar      tomcat-i18n-ko.jar
catalina-ant.jar	  jsp-api.jar	      tomcat-i18n-pt-BR.jar
catalina-ha.jar		  servlet-api.jar     tomcat-i18n-ru.jar
catalina.jar		  tomcat-api.jar      tomcat-i18n-zh-CN.jar
catalina-ssi.jar	  tomcat-coyote.jar   tomcat-jdbc.jar
catalina-storeconfig.jar  tomcat-dbcp.jar     tomcat-jni.jar
catalina-tribes.jar	  tomcat-i18n-cs.jar  tomcat-util.jar
ecj-4.18.jar		  tomcat-i18n-de.jar  tomcat-util-scan.jar
el-api.jar		  tomcat-i18n-es.jar  tomcat-websocket.jar
jasper-el.jar		  tomcat-i18n-fr.jar  websocket-api.jar
jasper.jar		  tomcat-i18n-ja.jar

</pre>


### Compilação

`sudo javac -d classes -cp .:/opt/tomcat/lib/servlet-api.jar src/mypkg/HelloServlet.java`

<pre>
<font color="#859900"><b>fabio@ip-50-62-81-50</b></font>:<font color="#268BD2"><b>~/HelloServlet/webapps/HelloServlet/WEB-INF</b></font>$ sudo javac -d classes -cp .:/opt/tomcat/lib/servlet-api.jar src/mypkg/HelloServlet.java
<font color="#859900"><b>fabio@ip-50-62-81-50</b></font>:<font color="#268BD2"><b>~/HelloServlet/webapps/HelloServlet/WEB-INF</b></font>$ ls classes/
<font color="#268BD2"><b>mypkg</b></font>
<font color="#859900"><b>fabio@ip-50-62-81-50</b></font>:<font color="#268BD2"><b>~/HelloServlet/webapps/HelloServlet/WEB-INF</b></font>$ ls classes/mypkg/
HelloServlet.class
<font color="#859900"><b>fabio@ip-50-62-81-50</b></font>:<font color="#268BD2"><b>~/HelloServlet/webapps/HelloServlet/WEB-INF</b></font>$ 
</pre>

### Definir a URL que dispara a execução do servlet

O arquivo `web.xml`, listado abaixo, contém, na seção `<servlet>`, informação sobre o servlet e, na seção `servlet-mapping` sobre com que URL o servlet é executado.

```xml
<?xml version="1.0" encoding="ISO-8859-1"?>
<web-app version="3.0"
  xmlns="http://java.sun.com/xml/ns/javaee"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd">
 
  <!-- To save as <CATALINA_HOME>\webapps\helloservlet\WEB-INF\web.xml -->
 
   <servlet>
      <servlet-name>HelloWorldServlet</servlet-name>
      <servlet-class>mypkg.HelloServlet</servlet-class>
   </servlet>
 
   <!-- Note: All <servlet> elements MUST be grouped together and
         placed IN FRONT of the <servlet-mapping> elements -->
 
   <servlet-mapping>
      <servlet-name>HelloWorldServlet</servlet-name>
      <url-pattern>/sayhelloFN</url-pattern>
   </servlet-mapping>
</web-app>
```

### Empacotar

Da forma como administro o servidor, ele recebe por download o `servlet` em um arquivo de extensão `.war`. Para criá-lo:

`jar -cvf HelloServlet.war *` na pasta acima de `WEB-INF`

<pre>
<font color="#859900"><b>fabio@ip-50-62-81-50</b></font>:<font color="#268BD2"><b>~/HelloServlet/webapps/HelloServlet</b></font>$ jar -cvf HelloServlet.war *
added manifest
adding: WEB-INF/(in = 0) (out= 0)(stored 0%)
adding: WEB-INF/src/(in = 0) (out= 0)(stored 0%)
adding: WEB-INF/src/mypkg/(in = 0) (out= 0)(stored 0%)
adding: WEB-INF/src/mypkg/HelloServlet.java(in = 1651) (out= 662)(deflated 59%)
adding: WEB-INF/web.xml(in = 776) (out= 376)(deflated 51%)
adding: WEB-INF/classes/(in = 0) (out= 0)(stored 0%)
adding: WEB-INF/classes/mypkg/(in = 0) (out= 0)(stored 0%)
adding: WEB-INF/classes/mypkg/HelloServlet.class(in = 1828) (out= 1003)(deflated 45%)
<font color="#859900"><b>fabio@ip-50-62-81-50</b></font>:<font color="#268BD2"><b>~/HelloServlet/webapps/HelloServlet</b></font>$ ls
<font color="#DC322F"><b>HelloServlet.war</b></font>  <font color="#268BD2"><b>WEB-INF</b></font>
</pre>


```
webapps
 `-- HelloServlet
        |-- HelloServlet.war  (criado por último)
         `-- WEB-INF
           |-- classes
           |     `-- mypkg
           |          `-- HelloServlet.class (criado na compilação)
           |-- src
           |    `-- mypkg
           |          `-- HelloServlet.java (criado pelo programador)
            `-- web.xml (criado pelo programador)
```

A transferência do `.war` do servidor para meu computador foi feita por `ftp` e a implantação no servidor foi feita pelo gerenciador de aplicações do tomcat (tem uma seção que permite upload de um arquivo `.war`.

### Execução

![alt text](Captura%20de%20tela%20de%202021-03-28%2015-34-58.png)


## Outras referências

https://www.google.com/search?q=servlet+tutorial+command+line&client=ubuntu&hs=v9t&channel=fs&sxsrf=ALeKk03TSzTuJQqYLzi4FSUnWIoIJ8AfUw%3A1616939686231&ei=popgYITXDYLZ5OUPgsi4gAI&oq=servlet+tutorial+command+line&gs_lcp=Cgdnd3Mtd2l6EAMyBQghEKABOgcIABCwAxBDOgQIABATOgYIABAWEB46BwghEAoQoAE6CAghEBYQHRAeUJLEGFj21Rhg_NcYaAFwAngAgAHMAYgBqw6SAQYwLjEzLjGYAQCgAQGqAQdnd3Mtd2l6yAEKwAEB&sclient=gws-wiz&ved=0ahUKEwiEwvvckdPvAhWCLLkGHQIkDiAQ4dUDCAw&uact=5
https://www3.ntu.edu.sg/home/ehchua/programming/java/JavaServlets.html
https://www.devmedia.com.br/servlet-tutorial/27841
https://tomcat.apache.org/tomcat-7.0-doc/appdev/sample/
https://www.google.com/search?q=ubuntu+java+ee&client=ubuntu&hs=iIa&channel=fs&sxsrf=ALeKk02Mhkt0ozwHdMdenK0VFb7f7bi2rw%3A1616942792114&ei=yJZgYJumBvPQ5OUPko2-gAM&oq=ubuntu+java+ee&gs_lcp=Cgdnd3Mtd2l6EAMyBggAEBYQHjIGCAAQFhAeMgYIABAWEB4yBggAEBYQHjIGCAAQFhAeMgYIABAWEB4yBggAEBYQHjIGCAAQFhAeMgYIABAWEB4yBggAEBYQHjoHCAAQRxCwAzoECCMQJzoCCAA6BQgAEMsBOgUIABCxAzoICAAQsQMQgwFQysANWMDgDWDPgg5oAXACeACAAakCiAGhHpIBBjEuMzAuMZgBAKABAaoBB2d3cy13aXrIAQjAAQE&sclient=gws-wiz&ved=0ahUKEwibqvulndPvAhVzKLkGHZKGDzAQ4dUDCAw&uact=5
https://www.google.com/search?channel=fs&client=ubuntu&q=java+ee+ubuntu+intelij
https://www.jetbrains.com/help/idea/java-ee.html
https://www.jetbrains.com/idea/features/editions_comparison_matrix.html
https://www.jetbrains.com/idea/buy/#personal?billing=yearly
https://www.ciceroednilson.com.br/tag/instalando-o-ambiente-de-desenvolvimento-java-ee-no-ubuntu/
https://www.quora.com/How-do-I-run-Java-servlet-in-Ubuntu-terminal
https://mkyong.com/servlet/a-simple-servlet-example-write-deploy-run/
https://serverfault.com/questions/554505/how-to-create-new-servlet-and-jsp-project-on-ubuntu
https://stackoverflow.com/questions/17004284/use-java-servlets-on-command-prompt
https://www.twilio.com/docs/usage/tutorials/how-to-set-up-your-java-and-servlets-development-environment
https://stackoverflow.com/questions/860022/wheres-javax-servlet
https://www.google.com/search?channel=fs&client=ubuntu&q=javax.servlet+in+open-jdk
https://wiki.openjdk.java.net/pages/viewpage.action?pageId=18448519
https://wpcademy.com/how-to-install-glassfish-on-ubuntu-18-04-lts/
https://www.digitalocean.com/community/tutorials/how-to-install-java-with-apt-on-ubuntu-20-04-pt


