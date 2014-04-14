#!/bin/sh

PATH=/home/tpalys/Studia/sem6/rozprochy/lab3/checkers-server

/usr/bin/java -cp $PATH/bin:$PATH/bin/api.jar -Djava.security.manager -Djava.security.policy=$PATH/src/server.policy checkersServer.Server
