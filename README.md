### GOALS 
- practice Clean Code Architecture
- practice integration with AWS Simple Email Service (SES)

### HOW TO RUN
```
mvn spring-boot:run
```

Set the following properties in the `application.properties`:
> aws.verified-email=<VERIFIED_AWS_SES_EMAIL>

> aws.region=<AWS_SES_REGION>

Do the request using the curl below:
```
curl --location --request POST 'http://localhost:8081/api/email' \
--header 'Content-Type: application/json' \
--data-raw '{
"toEmail": "<VERIFIED_AWS_SES_EMAIL>",
"subject": "Email teste",
"body": "Descrição do email"
}'
```