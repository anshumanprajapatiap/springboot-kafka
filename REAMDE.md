


Navigate to home directory and 
```shell
    docker-compose up -d
```

Verify Kafka
To ensure Kafka is running, check the logs:
```shell
docker logs kafka
```

Create Topics and Send/Consume Messages (Optional)
You can access the Kafka container and use the CLI to create topics or test message production/consumption:

Enter the Kafka container:
```shell
docker exec -it kafka bash
```

Create a topic:

```shell
kafka-topics --create --topic example-topic --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1
```

Produce a message:

```shell
kafka-console-producer --topic example-topic --bootstrap-server localhost:9092
```

Consume the message:

```shell
kafka-console-consumer --topic example-topic --from-beginning --bootstrap-server localhost:9092
```


```shell
    docker-compose down
```