# Usando SPARQL

**estado do documento**: incompleto.

### SPARQL

## Referências
https://www.w3.org/TR/2013/REC-sparql11-update-20130321/#deleteData
https://www.w3.org/TR/sparql11-http-rdf-update/
https://www.ietf.org/rfc/rfc2616.txt

### entailment

https://www.google.com/search?channel=fs&client=ubuntu&q=entailment
https://www.google.com/search?channel=fs&client=ubuntu&q=entailment+w3c
https://www.w3.org/wiki/Entailment
https://www.w3.org/TR/sparql11-entailment/

### HTTP


#### Comprimento máximo da URI

A norma não estabelece comprimento máximo para uma URI, mas há referências que apontam que implementadores escolheram algo em torno de 2k. A resposta na referência 1 traz mais detalhes.

> The HTTP protocol does not place any a priori limit on the length of a URI. Servers MUST be able to handle the URI of any resource they serve, and SHOULD be able to handle URIs of unbounded length if they provide GET-based forms that could generate such URIs. A server SHOULD return 414 (Request-URI Too Long) status if a URI is longer than the server can handle (see section 10.4.15).

Página 19 seção 3.2.1 da [Fonte](https://www.ietf.org/rfc/rfc2616.txt)

Outras referências indicam que o comprimento máximo está em torno de 2k:

1. https://stackoverflow.com/questions/2659952/maximum-length-of-http-get-request
2. https://stackoverflow.com/questions/2880722/can-http-post-be-limitless/55998160
3. https://helpx.adobe.com/mt/experience-manager/scene7/kb/base/is_protocol-_-forming_is/url-character-limit-get-requests.html
4. https://support.microsoft.com/en-us/help/208427/maximum-url-length-is-2-083-characters-in-internet-explorer
5. https://docs.microsoft.com/pt-br/exchange/message-size-limits-exchange-2013-help
6. https://www.outsystems.com/forums/discussion/54206/url-length-with-query-string-parameters/#

Outras referências mais gerais que talvez sejam úteis:

- https://www.w3.org/Protocols/rfc2616/rfc2616-sec4.html
- https://tools.ietf.org/html/

