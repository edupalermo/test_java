connect 'jdbc:derby://localhost:1527/TestDb';


export DERBY_INSTALL=/c/java/db-derby-10.14.2.0-bin
export CLASSPATH=$DERBY_INSTALL/lib/derby.jar:$DERBY_INSTALL/lib/derbytools.jar:.
export PATH="$DERBY_INSTALL/bin:$PATH"
export DERBY_OPTS="-Dderby.system.home=$DERBY_INSTALL/data"
