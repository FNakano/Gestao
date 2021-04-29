## <a id="2021-04-28-154332" href="#2021-04-28-154332">2021-04-28-154332</a>

Esta pasta contém shell scripts ligados a operações sobre o servidor fuseki hospedado na GoDaddy.

Este arquivo é o diário de uso e de referências.

O shell script `init.sh` cria variáveis de ambiente que correspodem aos endpoints do servidor.

Resultados hoje

1. criei `init.sh`
2. criei `la.sh`
3. criei `up.sh`
4. criei `qs.sh`
5. criei `rms.sh`

Problemas que ocorreram e foram resolvidos hoje:

1. parser do `curl` não aceita URL dentro do --data
2. parser do `sh` não aceita linha de comando terminada por >. Usa como comando de redirecionamento.
3. sintaxe do comando para remover algo do Fuseki: `sh ./rms.sh "<http://example/book1>"`

Referências consultadas:
https://mail.google.com/mail/u/0/#inbox
https://mail.google.com/mail/u/1/#inbox/FMfcgxwLsdKmRRrkzPZrhMDXxGWBsbCP
http://ip-50-62-81-50.ip.secureserver.net:8080/fuseki/dataset.html?tab=upload&ds=/testeFabio
https://jena.apache.org/documentation/fuseki2/fuseki-webapp.html
https://drive.google.com/drive/u/1/folders/1U27ANB1tztKGMy2Nh_vJtwK104O2jFpx
https://calendar.google.com/calendar/u/1/r?tab=mc
https://drive.google.com/drive/u/1/folders/10c2YHl9WerZ2IoqxNfltfjVNZWMj1DOR
https://drive.google.com/drive/u/1/folders/0AF-c4AWp0y84Uk9PVA
https://github.com/
https://github.com/FNakano/Gestao
https://github.com/FNakano/Gestao/blob/main/SSNeSOSA-Dados.md
https://github.com/FNakano/Gestao/blob/main/AlgunsExemplosDeUsoDeFuseki.md
https://github.com/FNakano/Gestao/blob/main/CarregarSSNeSOSA.md
https://www.google.com/search?channel=fs&client=ubuntu&q=fuseki+return+rdf
https://stackoverflow.com/questions/45192163/rdf-format-output-from-fuseki-1-0
https://jena.apache.org/documentation/archive/serving_data/fuseki1.html
https://www.google.com/search?channel=fs&client=ubuntu&q=sparql+construct+example
https://www.w3.org/TR/sparql11-query/#construct
https://www.futurelearn.com/info/courses/linked-data/0/steps/16104
https://www.google.com/search?channel=fs&client=ubuntu&q=curl+posting+file+content
https://stackoverflow.com/questions/15912924/how-to-send-file-contents-as-body-entity-using-curl
https://www.google.com/search?q=sparql+delete+all+data&client=ubuntu&hs=CBD&channel=fs&sxsrf=ALeKk03ON96-ePkFAdmSaKeVxY6K4W6xDg%3A1619634315778&ei=i6iJYIaPL57E5OUPr9aamAI&oq=sparql+delete+all+&gs_lcp=Cgdnd3Mtd2l6EAEYATIFCAAQywEyBQgAEMsBMgUIABDLATIFCAAQywEyBggAEBYQHjIGCAAQFhAeOgcIABBHELADOgQIIxAnOggIABAIEA0QHjoKCAAQCBANEAoQHjoCCAA6BggjECcQE1Cp-QtYzJgMYOe2DGgBcAJ4AIAB4gGIAawXkgEGMC4yMy4xmAEAoAEBqgEHZ3dzLXdpesgBCMABAQ&sclient=gws-wiz
http://vos.openlinksw.com/owiki/wiki/VOS/VirtTipsAndTricksSPARQL11Delete#DELETE%20DATA%20Examples
https://www.w3.org/TR/sparql11-update/#deleteData
https://www.google.com/search?channel=fs&client=ubuntu&q=bash+export+variable
https://www.baeldung.com/linux/bash-variables-export
https://www.google.com/search?channel=fs&client=ubuntu&q=%23%21+sh
https://stackoverflow.com/questions/7366775/what-does-the-line-bin-sh-mean-in-a-unix-shell-script
https://www.google.com/search?channel=fs&client=ubuntu&q=shell+script+command+line+arguments
http://faculty.salina.k-state.edu/tim/unix_sg/shell/variables.html
https://www.baeldung.com/linux/use-command-line-arguments-in-bash-script
https://superuser.com/questions/149329/what-is-the-curl-command-line-syntax-to-do-a-post-request
https://gist.github.com/subfuzion/08c5d85437d5d4f00e58
https://www.google.com/search?q=curl+data+syntax+url+into+payload&client=ubuntu&hs=Bet&channel=fs&sxsrf=ALeKk01tbGbc65KOI5zMGRAvQt_YocWLuw%3A1619638678251&ei=lrmJYMfdDuKG0AbD8JrYAQ&oq=curl+data+syntax+url+into+payload&gs_lcp=Cgdnd3Mtd2l6EAMyBQghEKABOgcIABBHELADOgYIABAWEB46CAghEBYQHRAeOgQIIRAVOgcIIRAKEKABUOWsAVjF0wFgg9gBaAFwAngAgAHxAYgB9hiSAQYwLjEzLjWYAQCgAQGqAQdnd3Mtd2l6yAEIwAEB&sclient=gws-wiz&ved=0ahUKEwjHgNOg2KHwAhViA9QKHUO4BhsQ4dUDCA0&uact=5
https://linuxize.com/post/curl-post-request/
https://www.google.com/search?channel=fs&client=ubuntu&q=curl+problem+with+angle+brackets
https://stackoverflow.com/questions/8333920/passing-a-url-with-brackets-to-curl


