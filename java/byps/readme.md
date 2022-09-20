# Release-Branches

## Tomcat 9, Servlet-API < 5
Für Tomcat 9 sind die Quellen im Branch release/byps9

## Tomcat 10, Servlet-API >= 5
Für Tomcat 10 sind die Quellen im Branch master

# Workspace 

## Tomcat-Konfigurationen
Es werden zwei Tomcats benötigt. Die Konfigurationen befinden sich in bypstest-srv/res/tomcat/config...

Die Tomcats müssen mit diesen Optionen gestartet werden, damit die Testsuite läuft:
-Dbyps.http.incomingStreamTimeoutSeconds=5 
-Dbyps.http.sessionCookieRequired=true