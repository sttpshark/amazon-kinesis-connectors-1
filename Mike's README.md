# Running dynamodb sample
1. cd into sample
2. run "mvn package" after setting up aws credentials in local credentials file and editing "KinesisConnectorConfiguration" and "DynamoDBSample.properties"
3. go into git bash, get into samples folder, then do "sh ./target/appassembler/bin/dynamodb-sample