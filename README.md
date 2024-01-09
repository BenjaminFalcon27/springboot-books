# Springboot REST demo

When running, swagger is available : http://localhost:8080/swagger-ui/index.html

## Debug

VM Args have to be added

```json
-Dspring.profiles.active=dev -Dspring.config.location=<PATH_TO_PROJECT>/springboot-rest-demo-config/src/main/resources/springboot-rest-demo.yml
```

### On VSCode

```json
{
  "type": "java",
  "name": "DemoRestApplication",
  "request": "launch",
  "mainClass": "org.grostarin.springboot.demorest.DemoRestApplication",
  "projectName": "springboot-rest-demo-ws",
  "vmArgs": "-Dspring.profiles.active=dev -Dspring.config.location=/home/benjamin/springboot-rest-demo/springboot-rest-demo-config/src/main/resources/springboot-rest-demo.yml"
}
```

### Docker commands

```bash
docker build -t springboot-rest-demo-ws .
docker run -p 8080:8080 springboot-rest-demo-ws
```
