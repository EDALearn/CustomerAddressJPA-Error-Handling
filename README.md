# Event-Driven Error Handling Patterns Playground

⚠️ WORK IN PROGRESS ⚠️

This project is a playground to test different error handling patterns in event-driven architectures.

## Getting Started

Start the project with the following commands:

```shell
docker-compose up -d
mvn spring-boot:run
```

## Testing

### Create a new Customer via REST API

```shell
curl -X POST --location "http://localhost:8080/api/customers" \
    -H "Authorization: Basic dXNlcjpwYXNzd29yZA==" \
    -H "Content-Type: application/json" \
    -d '{
            "username": "ivangsa{{suffix}}",
            "firstName": "Ivan",
            "lastName": "Garcia Sainz-Aja",
            "email": "ivangsa{{suffix}}@domain.com",
            "phone": "(505) 503-4455",
            "address": {
              "street": "Rue del Percebe, 13",
              "city": "A Coruña",
              "state": "A Coruña",
              "zip": "15002",
              "type": "HOME"
            }
        }'
```

### Create Customers via Kafka

Send a valid message to the `customer.create` topic:

```shell
topic_name='customer.create'
json_message='
{
    "username": "ivangsa",
    "firstName": "Ivan",
    "lastName": "Garcia Sainz-Aja",
    "email": "ivangsa@domain.com",
    "phone": "(505) 503-4455",
    "address": {
      "street": "Rue del Percebe, 13",
      "city": "A Coruña",
      "state": "A Coruña",
      "zip": "15002",
      "type": "HOME"
    }
}
'

json_message=$(echo $json_message | tr -d '\n')
docker-compose exec -T kafka bash -c "echo '$json_message' | kafka-console-producer --broker-list localhost:9092 --topic $topic_name"
```
Send an invalid message (serialization error) to the `customer.create` topic:

```shell
topic_name='customer.create'
json_message='
{
    "username": "ivangsa",
    "firstName": "Ivan",
    "lastName": "Garcia Sainz-Aja",
    "email": "ivangsa@domain.com",
    "phone": "(505) 503-4455",
    "address": {
      "id": "X"
    }
}
'

json_message=$(echo $json_message | tr -d '\n')
docker-compose exec -T kafka bash -c "echo '$json_message' | kafka-console-producer --broker-list localhost:9092 --topic $topic_name"
```

