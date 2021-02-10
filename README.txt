Instruções de instalação
========================

1. Crie um diretório para o projeto na sua máquina local. Ex:
C:\restapimusica

1. Baixe o projeto do github na pasta criada no passo anterior.
https://github.com/juankfe/spotifyrestapi

2. Faça o download do Apache Tomcat 9.0.43:
https://tomcat.apache.org/download-90.cgi

3. Descompacte o zip do tomcat na sua máquina local.
C:\apache-tomcat-9.0.43

4. Copie este arquivo:
C:\restapimusica\deploy\ROOT.war
para
C:\apache-tomcat-9.0.43\webapps

5. Exclua o diretório C:\apache-tomcat-9.0.43\webapps\ROOT (diretório padrão da instalação do tomcat)

6. Inicie o servidor do tomcat.
Duplo-click em C:\apache-tomcat-9.0.43\bin\startup.bat

7. Pronto! Pode acessar a aplicação.

7.1 - Acesso por cidade

http://localhost:8080/cidade

Ex:

http://localhost:8080/pato branco
http://localhost:8080/porto alegre
http://localhost:8080/chicago
http://localhost:8080/barcelona


7.1 - Acesso por coordenadas geográficas

http://localhost:8080/latitude/longitude

Ex:
http://localhost:8080/-26.2286/-52.6706
http://localhost:8080/-30.0331/-51.23
http://localhost:8080/41.851/-87.65
http://localhost:8080/41.3888/2.159

8. Quando terminar pare o tomcat:
Duplo-click em C:\apache-tomcat-9.0.43\bin\shutdown.bat

9. Código fonte disponível em:
C:\restapimusica

