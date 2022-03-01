# Algumas coisas não são tão difíceis...

## Motivação e apresentação

Creio que muitas pessoas, além de mim, sintam-se desconfortáveis com imperativos do tipo:

1. *tem que apresentar a definição...* 
2. *tem que apresentar a referência...*
3. *tem que formatar a referência...*

Pretendo deixar aqui informação que permite que eu, agora, consiga dizer que não é tão difícil assim...

A partir de um exemplo:

> The W3C Web of Things (WoT) is intended to enable **interoperability** across IoT platforms and application domains. Overall, the goal of the WoT is to preserve and complement existing IoT standards and solutions. In general, the W3C WoT architecture is designed to describe what exists rather than to prescribe what to implement. *grifo meu*

Fonte: https://www.w3.org/TR/2020/REC-wot-architecture-20200409/

## Definições

Há de se observar que definições de termos podem mudar com o tempo. Ainda assim, é melhor apresentar alguma definição declarada e clara, mesmo que, antiga, a não apresentar definição alguma. Se algum dicionário contiver essa definição, poupa-nos tempo.

### O que é *interoperability* (interoperabilidade)?

Passei uns dias lendo artigos, recomendados por colegas, vi, nas referências desses artigos, que existem vocabulários, glossários, dicionários,..., de termos técnicos, mantidos por instituições normativas, como IEEE, W3C,... *(nota: o resultado apresentado aqui não era um dos esperados/desejados)*

Em particular, encontra-se a definição de *interoperability* no *IEEE Standard Glossary of Software Engineering Terminology*. Este glossário tem versões de 1983, 1990, 2010 e 2017. Na versão mais recente:

> 3.1505
> interoperability
> 1. the ability of two or more systems or components to exchange information and to use the information that has been exchanged 
> 2. the ability for two or more ORBs to cooperate to deliver requests to the proper object. ISO/IEC 19500-2:2003, Information technology — Open Distributed Processing — Part 2: General Inter-ORB Protocol (GIOP)/Internet Inter-ORB Protocol (IIOP). 3.2.19. 
> 3. the capability to communicate, execute programs, and transfer data among various functional units in a manner that requires the user to have little or no knowledge of the unique characteristics of those units. ISO/IEC 2382-1:1993, Information technology — Vocabulary — Part 1: Fundamental terms.01.01.47

### O que é *web service*?

> Web service
> There are many things that might be called "Web services" in the world at large. However, for the purpose of this Working Group and this architecture, and without prejudice toward other definitions, we will use the following definition:
> A Web service is a software system designed to support interoperable machine-to-machine interaction over a network. It has an interface described in a machine-processable format (specifically WSDL). Other systems interact with the Web service in a manner prescribed by its description using SOAP-messages, typically conveyed using HTTP with an XML serialization in conjunction with other Web-related standards. 
  
Fonte: https://www.w3.org/TR/ws-gloss/

A W3C mantém uma página que concentra os glossários atuais: https://www.w3.org/Glossary. Também menciona um dicionário iniciado em 2003 e descontinuado, em favor desse outro sistema, em 2010: https://www.w3.org/2003/glossary/

## Sobre referências

Depois de usar a informação, a percepção imediata da utilidade em citar a fonte diminui. *Depois que resolvi o problema (imediato), por que gastar tempo documentando?*. A resposta: Soluções não são únicas e é possível classificá-las de acordo com a finalidade. Outras pessoas, que se interessarem pelo que você apresenta, tem outras finalidades. Seu trabalho é muito mais útil se apresentar indicações para que elas sejam capazes de ajustar o que foi proposto.

Colocar referências no texto tem duas partes muito sentidas (como perda de tempo, mas que, ao contrário, aumentam a qualidade do documento): 1) citar; 2) informar os dados da referência.

O passo 1) requer escrever/ler com atenção e entender o que **está sendo escrito**. Sim, deve-se prestar atenção ao que estamos escrevendo. Acredito que não haja como aliviar este esforço.

O passo 2) requer coletar os dados e organizá-los ou, pior, formatá-los. Este esforço pode ser aliviado. A cada referência usada, coletar os dados em um formato que automatize ao máximo sua formatação. Repositórios, como Scopus, IEEE Explore, ..., geram referências em diversos formatos - geralmente é clicar, copiar e colar. O meu preferido é bibtex pois formatos podem ser aplicados automaticamente na compilação do documento LaTeX para PDF, reduzindo o trabalho, por exemplo, para mudar as referências do modelo ABNT para o modelo APA.

Ainda para o passo 2, existem serviços gratuitos que geram a referência a partir de um DOI, ou a partir de ISBN, ou a partir da URL do relatório da W3C:

- https://www.doi2bib.org/
- Vários, a qualidade não foi verificada
   - http://doi-to-bibtex-converter.herokuapp.com/#query=https%3A//www.w3.org/TR/2004/NOTE-ws-gloss-20040211/
   - https://www.ottobib.com/
   - https://www.bibtex.com/c/isbn-to-bibtex-converter/
- https://w2.syronex.com/jmr/w3c-biblio
   - Funciona com URLs com data e TR, como: https://www.w3.org/TR/2004/NOTE-ws-gloss-20040211/

## Considerações finais

Espero que esta informação seja útil a quem tiver sido recomendada.
   
**nota**: ... porque alguém fez antes, ou porque alguém mantém algo funcionando,...

## Referências

@TechReport{Brown:04:WSG,
  author      = "Allen Brown and Hugo Haas",
  title       = "Web Services Glossary",
  month       = feb,
  note        = "https://www.w3.org/TR/2004/NOTE-ws-gloss-20040211/",
  year        = "2004",
  bibsource   = "https://w2.syronex.com/jmr/w3c-biblio",
  type        = "{W3C} Note",
  institution = "W3C",
}

@TechReport{Kajimoto:20:WTA,
  author      = "Kazuo Kajimoto and Kunihiko Toumura and Toru Kawaguchi and Michael Lagally and Ryuichi Matsukura and Matthias Kovatsch",
  title       = "Web of Things (WoT) Architecture",
  month       = apr,
  note        = "https://www.w3.org/TR/2020/REC-wot-architecture-20200409/",
  year        = "2020",
  bibsource   = "https://w2.syronex.com/jmr/w3c-biblio",
  type        = "{W3C} Recommendation",
  institution = "W3C",
}

@ARTICLE{8016712,
  author={},
  journal={ISO/IEC/IEEE 24765:2017(E)},   
  title={ISO/IEC/IEEE International Standard - Systems and software engineering--Vocabulary},   
  year={2017},  
  volume={},  
  number={},  
  pages={1-541},  
  doi={10.1109/IEEESTD.2017.8016712}
}

