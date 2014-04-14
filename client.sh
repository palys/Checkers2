#!/bin/sh

PATH=/home/tpalys/Studia/sem6/rozprochy/lab3/checkers-client
CLASSPATH=$PATH/bin:$PATH/bin/api.jar
SECUR_POLICY=$PATH/src/client.policy
CODEBASE=file:///home/tpalys/Studia/sem6/rozprochy/lab3/checkers-server/bin/serv.jar

/usr/bin/java -cp $CLASSPATH -Djava.security.manager -Djava.security.policy=$SECUR_POLICY -Djava.rmi.server.codebase=$CODEBASE checkersClient.Client $@
