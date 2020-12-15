# Gestão de Conhecimento

## Antes de começar a ler

Gostaria de avisar que pretendo usar este repositório para trocar idéias com colaboradores, compartilhar opiniões. Quem as ler pode não concordar, considerá-las delírios, encontrar falhas nos argumentos e nas premissas. Falhas, discordância, questionamento, ... fazem parte do processo de desenvolvimento de idéias.

> Alguém puxa um pelo, vem um gato pendurado...
> ... ouvi esta de um colega. Ficarei feliz em dizer quem é, se ele permitir...

Busquei, na esperança de existir, um texto que definisse claramente e diferenciasse *conhecimento* e *informação*, sem restringir o domínio a Computação. Achei um [1] que, na minha interpretação, indica que vou continuar *na esperança*, e outro [2] que, indica que formulei mal a busca e que para esta formulação não existe resposta. A boa formulação seria por uma definição e diferenciação *satisfatória* (para mim). Uma alternativa, não posso pressupor que seja a única, é apresentada. (**nota** nem *claramente* nem *satisfatória* faziam parte da chave de busca: `difference between knowledge and information`).

A idéia de gestão de conhecimento é citada em [1] e em [3]. Existe analogia entre uma parte da discussão em [3] e a distinção entre T-box e A-box.

[1] Braf E. (2002) Knowledge or Information. In: Liu K., Clarke R.J., Andersen P.B., Stamper R.K., Abou-Zeid ES. (eds) Organizational Semiotics. IFIP — The International Federation for Information Processing, vol 94. Springer, Boston, MA. https://doi.org/10.1007/978-0-387-35611-2_5. Disponível em <https://link.springer.com/content/pdf/10.1007%2F978-0-387-35611-2_5.pdf>, acessado em 15/12/2020.

[2] Nake F. (2002) Data, Information, and Knowledge. In: Liu K., Clarke R.J., Andersen P.B., Stamper R.K., Abou-Zeid ES. (eds) Organizational Semiotics. IFIP — The International Federation for Information Processing, vol 94. Springer, Boston, MA. https://doi.org/10.1007/978-0-387-35611-2_3. Disponível em <https://link.springer.com/content/pdf/10.1007%2F978-0-387-35611-2_3.pdf>, acessado em 15/12/2020.

[3] Taborsky E. (2002) Semiosis, Information and Knowledge. In: Liu K., Clarke R.J., Andersen P.B., Stamper R.K., Abou-Zeid ES. (eds) Organizational Semiotics. IFIP — The International Federation for Information Processing, vol 94. Springer, Boston, MA. https://doi.org/10.1007/978-0-387-35611-2_12. Disponível em <file:///tmp/mozilla_fabio0/Taborsky2002_Chapter_SemiosisInformationAndKnowledg.pdf>, acessado em 15/12/2020.


## Motivação

Minha visão particular do ecossistema criado em torno do termo *web semântica*. Ecossistema = ferramentas computacionais, conhecimento sistematizado e o processo de sistematização, pode ser aplicado para aperfeiçoar outras áreas.

O estudo de ontologias colocou-me em contato e permitiu que eu entendesse, em certa medida, como os criadores das ontologias conceitualizam os domínios que modelaram. Os documentos da W3C, além de apresentar as ontologias, também documentam o processo e as considerações feitas na criação das ontologias. É material que contém muita informação e muitos detalhes.

Este entendimento, por sua vez, permite que eu crie sobre as ferramentas já construídas, especulando possíveis aplicações.

1. e se ... sistemas semânticos forem capazes de melhorar a qualidade dos documentos de comunicação, como planos, relatórios, artigos?
2. e se ... sistemas semânticos, por serem baseados em conceitos simples aplicados homogeneamente, puderem condicionar o comportamento humano de maneira a beneficiar-nos, por exemplo, deixando-nos menos sujeitos a enganos cognitivos e falácias lógicas??
3. e se ... o estudo de sistemas semânticos for capaz de aumentar nossa precisão na comunicação entre indivíduos, permitindo que os comunicantes percebam (e evitem) erros cognitivos e falácias lógicas? Isto seria útil em processos educacionais, onde uma fonte de falha na transmissão de conhecimento são esses erros e falácias, criadas por erro do educador ( para simplificar o raciocínio, parte-se do princípio que o educador sabe o conteúdo que vai transmitir. Caso ele não saiba e precise recorrer a outras fontes, acrescente-se o erro das outras fontes, de intermediários (ex:tradutores) e falhas de comunicação do educador), ou por erro de interpretação do educando, e, a partir daí, talvez, repetida pelo educando, inclusive se este vier a tornar-se educador.

Acho que esses três ... e se ... cobrem meus interesses de momento.

O principal(?) processo utilizado para comunicar atividades segue um fluxo: proposta -> plano -> execução -> relatório. 

Artigos científicos são um tipo de relatório.

Aulas expositivas seguem um fluxo:

preparação -> apresentação -> avaliação. A preparação, talvez seja similar à construção de um relatório e a avaliação à comparação entre grafos de conhecimento, ou ao levantamento de indicadores de qualidade desses grafos.

É possível tratar planos como um conjunto de *atividades previstas*, que chamarei de *tarefas*, em alinhamento com a [ontologia PlansLite](http://www.ontologydesignpatterns.org/ont/dul/PlansLite.owl). PlansLite não contém owl:Axioms para lidar com atribuição de tarefas. A ontologia que contém owl:Axioms que expressam essa conexão é [Provenance](https://www.w3.org/TR/prov-overview/), <https://www.w3.org/TR/prov-o/>. Frequentemente, na minha área, prov:Entities são artigos, livros, projetos, editais - a ontologia para esse domínio é [Dublin Core](https://www.dublincore.org/specifications/dublin-core/dcmi-terms/). Existe um [documento da W3C que esclarece como conectar prov: a dc:](https://www.w3.org/TR/prov-dc/). As ontologias escolhidas não lidam com as relações entre eventos temporais. É possível usar a ontologia [Time](https://www.w3.org/TR/owl-time). Uma [seção desta ontologia explica como relacioná-la a Prov](https://www.w3.org/TR/owl-time/#time-prov). com essa finalidade. Caso prov:Entities sejam meios de produção, físicos, é possível que [Good Relations](http://www.productontology.org/) seja uma boa ontologia a se usar. 

Há alguns utilitários que acredito que são necessários, e cujas partes podem ser úteis para construir outros utilitários:

- visualizador de ontologias na forma de grafos;
- editor de instâncias;

## visualizador de ontologias na forma de grafos;

Ferramenta para gerar especificações de grafos(diagramas) a partir de triplas. Estas especificações podem ser codificadas em alguma das especificações: GraphViz, GraphML, [GML Graph Modeling Language](https://en.wikipedia.org/wiki/Graph_Modelling_Language), renderizada usando GraphViz, Gephi, yEd, que contém ferramentas de layout.


Resultados:
- Bibliotecas;
- documentação/sistematização;
- exemplos;

Insumos:
- Jena;
- yEd ou mermaid;
- [Mapeamento de OWL para RDFS](https://www.w3.org/TR/owl-mapping-to-rdf/)
    - a sistematização da informação em triplas (S,P,O) e grafos é característica de RDF e RDFS. OWL não tem essa sistematização nativa, inclusive porque deriva de conceitos em Lógica de Descrição, que prescindem deste elemento. Por outro lado o mapeamento bidirecional (talvez biunívoco) é possível e especificado no documento citado.
     

## criador de instâncias;

Ontologias são especificações de vocabulários e relações. Agir não é sua função (SOSA define uma classe Procedure, o que não contradiz a a negação anterior). 

Ações são executadas por *reasoners*. Programas que interpretam as especificações e executam ações em função da especificação (e da intenção do programador).

Segue então a especificação de um *reasoner* que cria instâncias. A interface do reasoner pode ser por navegador, o que incluiria Fuseki, e talvez Tomcat, aos insumos.

- Importa ontologias (opcionalmente lhes atribui prefixos);
- Apresenta três listas drop-down: {S,P,O};
- Popula cada lista com todos os rdfs:Resources que podem ser usados;
    - atualiza as listas dinamicamente, em função das outras escolhas já feitas, através das propriedades owl:domain, owl:range, marcações xsd:type, xsd:lang;
- Apresenta o grafo de instâncias em formato de grafo.

Resultados:
- Bibliotecas;
- documentação/sistematização;
- exemplos;
    - é possível instanciar planos, a partir da sistematização proposta no início do texto. Mermaid gera GANTT, Time prevê time:Start, time:End, time:Duration, PlansLite provê plans:MainGoal, plans:Accomplishment, plans:Achievement, plans:startTask, plans:CompletionTask, ... Provenance provê prov:Agent, prov:wasGeneratedBy, prov:wasAttributedTo, prov:wasDerivedFrom, ...
        - isto é requisito para criar validadores de planos.
        - a execução de planos pode divergir significativamente do planejado. Por isso convém haver plans:DeliberationTasks, eventuamente levando ao redesenho das etapas posteriores do plano, em função dos plans:Accomplishment e dos plans:Achievement. Convém que os redesenhos façam parte do plano, ou do acompanhamento da execução, o que indica que algum controle de versão pode ser necessário, assim como, ontologias para ligar planos à sua execução. Existem trabalhos acadêmicos nesse sentido.
    - é possível anotar conceitos (através de SKOS e DC), o que permite a uma pessoa anotar o que entendeu em aulas. Medidas de características do grafo resultante, ou comparação com grafos de referência podem ser usados para avaliar o entendimento.
    
Insumos:
- Jena, Fuseki, Tomcat;
- yEd ou mermaid;


[Execução dos programas nos tutoriais Jena](ExecucaoTutoriaisJena.md)

