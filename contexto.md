# Fornecer Informação de Contexto

## Introdução

Há circunstâncias em que é útil ter informação sobre o sistema.

Programas de desenvolvimento e aplicação, como `javac`, `firefox`, ... costumam ter a opção de linha de comando `--version`.

Que eu saiba, não há chamada em linha de comando para o núcleo do SO, então existe outra forma de saber sua versão (a versão do núcleo e a versão do SO). 

## Resultados

Sobre núcleo do sistema operacional, quando é linux (talvez no MacOS, ou no iOS também execute sem erros e traga informação equivalente.

```
rname -f
cat /proc/version
dmesg | grep -i linux
```

[Fonte1](https://itsfoss.com/find-which-kernel-version-is-running-in-ubuntu/)

[Fonte2](https://linuxize.com/post/how-to-check-linux-version/)

**comentários/opiniões**: rname é muito sucinto; dmesg é muito verboso.

Sobre sistema operacional

```
cat /etc/os-release
```

Sobre javac

```
javac --version
```

Sobre Fuseki (e Jena)

```
./apache-jena-fuseki-3.17.0/fuseki-server --version
```

Sobre navegador/browser

```
firefox --version
```

## Resumo

```
cat /proc/version
cat /etc/os-release
firefox --version
javac --version
./apache-jena-fuseki-3.17.0/fuseki-server --version
```

## Resultado do teste do resumo em um sistema

<pre><font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~</b></font>$ cat /proc/version
Linux version 5.8.0-34-generic (buildd@lcy01-amd64-015) (gcc (Ubuntu 9.3.0-17ubuntu1~20.04) 9.3.0, GNU ld (GNU Binutils for Ubuntu) 2.34) #37~20.04.2-Ubuntu SMP Thu Dec 17 14:53:00 UTC 2020
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~</b></font>$ firefox --version
Mozilla Firefox 84.0.1
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~</b></font>$ cat /proc/version
Linux version 5.8.0-34-generic (buildd@lcy01-amd64-015) (gcc (Ubuntu 9.3.0-17ubuntu1~20.04) 9.3.0, GNU ld (GNU Binutils for Ubuntu) 2.34) #37~20.04.2-Ubuntu SMP Thu Dec 17 14:53:00 UTC 2020
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~</b></font>$ cat /etc/os-release
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
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~</b></font>$ firefox --version
Mozilla Firefox 84.0.1
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~</b></font>$ javac --version
javac 11.0.9.1
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~</b></font>$ ./apache-jena-fuseki-3.17.0/fuseki-server --version
Jena:       VERSION: 3.17.0
Jena:       BUILD_DATE: 2020-11-25T19:40:23+0000
TDB:        VERSION: 3.17.0
TDB:        BUILD_DATE: 2020-11-25T19:40:23+0000
Fuseki:     VERSION: 3.17.0
Fuseki:     BUILD_DATE: 2020-11-25T19:40:23+0000
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~</b></font>$ 

</pre>

**nota**: fiquei contente porque hoje, 2021-01-07, o kernel foi atualizado para 5.8 . 


