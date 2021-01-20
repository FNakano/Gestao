# Raciocinadores 1

**estado**: incompleto

## Introdução

Um raciocinador (reasoner@en), é um programa capaz de inferir consequências lógicas a partir de fatos ou axiomas. Fatos e axiomas são definidos em ontologias. No momento, eis uma [referência da Wikipedia](https://en.wikipedia.org/wiki/Semantic_reasoner). Devem existir referências mais formais.

Por uma questão de desambiguação, é possível qualificar e usar raciocinador semântico para referir-se a esse tipo de programa.

Na [documentação de Jena sobre raciocinadores](https://jena.apache.org/documentation/inference/), informa-se que lá, os termos *inference engine* e *reasoner* são considerados equivalentes (por eles, no momento em que a documentação foi escrita/revisada).

A página específica que cito como documentação traz exemplos, o que me induz a vontade de executá-los, mas os exemplos não trazem o código completo nem instruções para compilação e execução. 

Parece-me que o objetivo da página é manter exemplos e códigos curtos, passar por todos os raciocinadores disponíveis, apresentar algumas configurações. Isto, na minha opinião, é feito bem, mas não apresenta o poder e a utilidade desses raciocinadores (o que pode requerer casos mais complexos). Neste momento estou trabalhando em portar ontologias de XML-Schema para RDF:XML. Validar o RDF:XML gerado é útil para mim e é um exemplo apresentado na documentação. Desta forma, seguir a documentação até o validador e aplicar o validador em um exemplo em que estou trabalhando (vide [ontmalizer](Ontmalizer.md)) é (R)elevante (para mim).

É relevante, também, completar as lacunas deixadas na documentação e documentar todo o processo nesta página. Servirá para eu lembrar o que fiz e para outras pessoas poderem fazer igual.

Os indicadores de sucesso (M) são:

- Apresentar os códigos-fonte, comandos de compilação e execução e resultados de execução de todos os exemplos até o exemplo do validador;
- Apresentar o resultado da execução do validador sobre uma ontologia convertida;
- Depositar o relatório (esta página), contendo esses resultados, no repositório.

O código-fonte, compilação e execução do primeiro exemplo estão feitos, com base em: [JenaReasoner.ppt](https://info.sice.indiana.edu/~dingying/Teaching/Z636/Slides/JenaReasoner.ppt), slide 14, adaptado para apontar para as bibliotecas (`import`) da minha instalação de Jena, o que me leva a acreditar que é factível (A).

Pretendo fazer tudo até segunda-feira que vem (hoje é quarta, 2021-01-20) (T).

## Objetivo

Seguir a documentação até o validador e aplicar o validador em um exemplo em que estou trabalhando, apresentar os resultados nesta página. (S)

## Resultados

### Minimo

<pre><font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sobreJena/reasoner/minimo</b></font>$ javac -cp &apos;./:/home/fabio/apache-jena-3.17.0/lib/*&apos; ReasonerTutorial01.java 
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sobreJena/reasoner/minimo</b></font>$ java -cp &apos;./:/home/fabio/apache-jena-3.17.0/lib/*&apos; ReasonerTutorial01
Statement: [urn:x-hp-jena:eg/a, urn:x-hp-jena:eg/q, &quot;foo&quot;]
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sobreJena/reasoner/minimo</b></font>$ 
</pre>

### Validador

<pre><font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sobreJena/reasoner/validador1</b></font>$ javac -cp &apos;./:/home/fabio/apache-jena-3.17.0/lib/*&apos; Validador1.java 
Validador1.java:12: error: cannot find symbol
        Model data = RDFDataMgr.loadModel(inputFileName);
                     ^
  symbol:   variable RDFDataMgr
  location: class Validador1
Validador1.java:14: error: cannot find symbol
        ValidityReport validity = infmodel.validate();
        ^
  symbol:   class ValidityReport
  location: class Validador1
Validador1.java:19: error: cannot find symbol
            for (Iterator i = validity.getReports(); i.hasNext(); ) {
                 ^
  symbol:   class Iterator
  location: class Validador1
3 errors
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sobreJena/reasoner/validador1</b></font>$ javac -cp &apos;./:/home/fabio/apache-jena-3.17.0/lib/*&apos; Validador1.java 
Validador1.java:16: error: cannot find symbol
        ValidityReport validity = infmodel.validate();
        ^
  symbol:   class ValidityReport
  location: class Validador1
Validador1.java:21: error: cannot find symbol
            for (Iterator i = validity.getReports(); i.hasNext(); ) {
                 ^
  symbol:   class Iterator
  location: class Validador1
2 errors
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sobreJena/reasoner/validador1</b></font>$ javac -cp &apos;./:/home/fabio/apache-jena-3.17.0/lib/*&apos; Validador1.java 
Validador1.java:17: error: cannot find symbol
        ValidityReport validity = infmodel.validate();
        ^
  symbol:   class ValidityReport
  location: class Validador1
Validador1.java:22: error: cannot find symbol
            for (Iterator i = validity.getReports(); i.hasNext(); ) {
                 ^
  symbol:   class Iterator
  location: class Validador1
2 errors
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sobreJena/reasoner/validador1</b></font>$ javac -cp &apos;./:/home/fabio/apache-jena-3.17.0/lib/*&apos; Validador1.java 
Validador1.java:22: error: cannot find symbol
            for (Iterator i = validity.getReports(); i.hasNext(); ) {
                 ^
  symbol:   class Iterator
  location: class Validador1
1 error
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sobreJena/reasoner/validador1</b></font>$ javac -cp &apos;./:/home/fabio/apache-jena-3.17.0/lib/*&apos; Validador1.java 
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sobreJena/reasoner/validador1</b></font>$  

<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sobreJena/reasoner/validador1</b></font>$ cp ../../vc-db-1.rdf .
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sobreJena/reasoner/validador1</b></font>$ java -cp &apos;./:/home/fabio/apache-jena-3.17.0/lib/*&apos; Validador1
OK
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sobreJena/reasoner/validador1</b></font>$  

</pre>

### validador 2

<pre><font color="#859900"><b>abio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sobreJena/reasoner</b></font>$ cp -r validador1 validador2
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sobreJena/reasoner</b></font>$ cd validador2
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sobreJena/reasoner/validador2</b></font>$ ls
Validador1.class  Validador1.java  vc-db-1.rdf
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sobreJena/reasoner/validador2</b></font>$ rm vc-db-1.rdf 
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sobreJena/reasoner/validador2</b></font>$ cp ~/Documentos/ZZfiles/TesteOntmalizer/indoor*.owl .
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sobreJena/reasoner/validador2</b></font>$ ls
indoorgmlnavi.owl  indoorgml.owl  Validador1.class  Validador1.java
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sobreJena/reasoner/validador2</b></font>$  
</pre>

https://jena.apache.org/documentation/inference/#validation
https://jena.apache.org/documentation/ontology/index.html
https://stackoverflow.com/questions/7779927/get-owl-restrictions-on-classes-using-jena
https://stackoverflow.com/questions/29485572/import-pellet-reasoner-into-jena
https://jena.apache.org/documentation/notes/model-factory.html
https://www.google.com/search?channel=fs&client=ubuntu&q=w3c+definition+of+reasoner
https://www.w3.org/standards/semanticweb/inference
https://www.w3.org/OWL/
https://www.google.com/search?client=ubuntu&hs=UqJ&channel=fs&sxsrf=ALeKk00RWj9WRoxtL1ZWbr3Awb9dhtOC6g%3A1611159859770&ei=M1kIYIbNLs_J5OUP39aM6A4&q=jena+reasoner+indiana&oq=jena+reasoner+indiana&gs_lcp=CgZwc3ktYWIQAzIFCCEQoAE6BAgjECc6BggAEAgQHjoECAAQHjoHCCMQsAIQJzoICAAQBxAeEBM6BggjECcQEzoGCAAQBxAeOgUIABDLAToGCAAQFhAeUN6ABVi7sAVg_rcFaABwAHgAgAH7AYgB8Q-SAQYwLjE0LjGYAQCgAQGqAQdnd3Mtd2l6wAEB&sclient=psy-ab&ved=0ahUKEwjGsviY9qruAhXPJLkGHV8rA-0Q4dUDCAw&uact=5
https://www.google.com/search?channel=fs&client=ubuntu&q=info+sice+idiana
https://github.com/FNakano/Gestao/blob/main/Raciocinadores1.md
https://www.google.com/search?client=ubuntu&hs=b3M&channel=fs&sxsrf=ALeKk02zN_T1mjQlHdiPFp1kjtOj3qGAWg%3A1611172204652&ei=bIkIYNK0J5mz5OUPmPaRiAI&q=jena+api+validityreport&oq=jena+api+validityreport&gs_lcp=CgZwc3ktYWIQAzIHCCEQChCgATIHCCEQChCgATIHCCEQChCgAToECCMQJzoGCAAQFhAeOggIABAWEAoQHjoFCAAQywE6CAghEBYQHRAeOgUIIRCgAToECCEQFVDI1QRYhoIFYJeEBWgAcAB4AYABgwOIAaYdkgEIMC4yMC4xLjKYAQCgAQGqAQdnd3Mtd2l6wAEB&sclient=psy-ab&ved=0ahUKEwjSmriXpKvuAhWZGbkGHRh7BCEQ4dUDCAw&uact=5
https://www.javatips.net/api/org.apache.jena.reasoner.validityreport.report
https://jena.apache.org/documentation/javadoc/jena/org/apache/jena/rdf/model/InfModel.html
https://jena.apache.org/documentation/javadoc/arq/org/apache/jena/riot/RDFDataMgr.html
https://www.google.com/search?channel=fs&client=ubuntu&q=java+iterator+import
https://www.w3schools.com/java/java_iterator.asp


<pre><font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sobreJena/reasoner/validador2</b></font>$ javac -cp &apos;./:/home/fabio/apache-jena-3.17.0/lib/*&apos; Validador2.java 
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sobreJena/reasoner/validador2</b></font>$ java -cp &apos;./:/home/fabio/apache-jena-3.17.0/lib/*&apos; Validador2 indoorgmlnavi.owl
OK
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sobreJena/reasoner/validador2</b></font>$ java -cp &apos;./:/home/fabio/apache-jena-3.17.0/lib/*&apos; Validador2 indoorgml.owl
OK
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/ZZfiles/sobreJena/reasoner/validador2</b></font>$  
</pre>


## Discussão e Conclusão


