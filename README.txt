Instruções de instalação
========================

1. Instale o PostgreSQL na sua máquina local

2. Crie um banco de dados com o nome restapimusica

3. Crie um diretório para o projeto na sua máquina local. Ex:
C:\restapimusica

4. Baixe o projeto do github na pasta criada no passo anterior.
https://github.com/juankfe/spotifyrestapi

5. Faça o download do Apache Tomcat 9.0.43:
https://tomcat.apache.org/download-90.cgi

6. Descompacte o zip do tomcat na sua máquina local.
C:\apache-tomcat-9.0.43

7. Copie este arquivo:
C:\restapimusica\deploy\ROOT.war
para
C:\apache-tomcat-9.0.43\webapps

8. Exclua o diretório C:\apache-tomcat-9.0.43\webapps\ROOT (diretório padrão da instalação do tomcat)

9. Inicie o servidor do tomcat.
Duplo-click em C:\apache-tomcat-9.0.43\bin\startup.bat
Isso vai descompactar o arquivo ROOT.war no diretório C:\apache-tomcat-9.0.43\webapps\ROOT.

10. Acesse o arquivo application.properties e atualize os campos username e password com usuário e senha do seu banco.
C:\apache-tomcat-9.0.43\webapps\ROOT\WEB-INF\classes\application.properties

11. Pronto! Pode acessar a aplicação.

11.1 - Acesso por cidade

http://localhost:8080/cidade/cidadeAqui

Ex:

http://localhost:8080/cidade/pato branco
http://localhost:8080/cidade/porto alegre
http://localhost:8080/cidade/chicago
http://localhost:8080/cidade/barcelona


11.1 - Acesso por coordenadas geográficas

http://localhost:8080/coordenadas/latitude/longitude

Ex:
http://localhost:8080/coordenadas/-26.2286/-52.6706
http://localhost:8080/coordenadas/-30.0331/-51.23
http://localhost:8080/coordenadas/41.851/-87.65
http://localhost:8080/coordenadas/41.3888/2.159

12. Quando terminar pare o tomcat:
Duplo-click em C:\apache-tomcat-9.0.43\bin\shutdown.bat


Código fonte disponível em:
============================
https://github.com/juankfe/spotifyrestapi