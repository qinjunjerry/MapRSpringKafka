# MapRSpringKafka

### Build

	mvn package

### Run

Create stream `/s1` and topic `t1`:

	maprcli stream create -path /s1
	maprcli stream topic create -path /s1 -topic t1 -partitions 2

Start the spring consumer:

	java -jar target/MapRSpringKafka-1.0-SNAPSHOT-jar-with-dependencies.jar

When a message is consumed, it is printed on `stdout`

Start the producer to send 10 message to topic: `/s1:t1`

	java -cp target/MapRSpringKafka-1.0-SNAPSHOT-jar-with-dependencies.jar com.mapr.example.SendTest	

### Acknowledgements

This test code is from Daniar.