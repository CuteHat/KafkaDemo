# KafkaDemo setup

start kafka
> ./bin/zookeeper-server-start.sh ./config/zookeeper.properties
> ./bin/kafka-server-start.sh ./config/server.properties

create topic
> ./bin/kafka-topics.sh --create --topic transaction-events --bootstrap-server localhost:9092