# 📦 apiPedidoWorker

Projeto Java com Spring Boot responsável por consumir mensagens da fila `pedidos` do RabbitMQ e processar os dados de pedidos realizados.

## 🚀 Funcionalidades

- Conexão com a fila `pedidos` do RabbitMQ
- Consumo de mensagens em formato JSON
- Desserialização automática com Jackson
- Mapeamento das mensagens para objetos Java (`Mensagem` e `Pedido`)
- Processamento desacoplado, facilitando testes e manutenção

---

## 📂 Estrutura da Mensagem (RabbitMQ)

As mensagens possuem o seguinte formato:

```json
{
  "id": "8267a15b-e44f-4cc4-891d-3558476b241e",
  "dataGeracao": "2025-05-24T15:28:11.441+00:00",
  "pedido": {
    "id": 2,
    "cliente": "Kaio Muniz",
    "dataPedido": "2025-05-24T03:00:00.000+00:00",
    "valorTotal": 0.1,
    "descricao": "pedido de compras"
  }
}
```

---

## 🧱 Classes Java

### `Mensagem.java`

```java
import java.time.OffsetDateTime;

public class Mensagem {
    private String id;
    private OffsetDateTime dataGeracao;
    private Pedido pedido;
    // Getters e Setters
}
```

### `Pedido.java`

```java
import java.time.OffsetDateTime;

public class Pedido {
    private int id;
    private String cliente;
    private OffsetDateTime dataPedido;
    private double valorTotal;
    private String descricao;
    // Getters e Setters
}
```

---

## ⚙️ Configuração

### `application.properties`

```properties
spring.rabbitmq.host=localhost
spring.rabbitmq.port=5672
spring.rabbitmq.username=guest
spring.rabbitmq.password=guest
spring.rabbitmq.listener.simple.acknowledge-mode=manual
```

---

## 📁 Estrutura de Diretórios

```
src/
├── main/
│   ├── java/
│   │   └── br/
│   │       └── com/
│   │           └── exemplo/
│   │               ├── consumer/          # Lógica de consumo do RabbitMQ
│   │               ├── model/             # POJOs (Mensagem, Pedido)
│   │               └── Application.java   # Classe principal
│   └── resources/
│       └── application.properties         # Configurações do RabbitMQ
```

---

## ▶️ Como Executar

1. Clone o projeto:
   ```bash
   git clone https://github.com/seu-usuario/apiPedidoWorker.git
   cd apiPedidoWorker
   ```

2. Compile:
   ```bash
   mvn clean install
   ```

3. Rode a aplicação:
   ```bash
   mvn spring-boot:run
   ```

> Certifique-se de que o RabbitMQ está ativo com a fila `pedidos` criada.

---

## 📚 Documentação Adicional

Este projeto foi gerado com o Spring Initializr. Para referência, consulte:

- [Spring Boot Maven Plugin](https://docs.spring.io/spring-boot/3.5.0/maven-plugin)
- [Spring Web](https://docs.spring.io/spring-boot/docs/current/reference/html/web.html)
- [Guia: Criando RESTful Web Services](https://spring.io/guides/gs/rest-service/)

---

## 🧪 Testes

Adicione testes unitários com JUnit para validar a desserialização das mensagens e o comportamento do consumidor RabbitMQ.

---

## 👤 Autor

Desenvolvido por **[Seu Nome]**  
📧 Email: seuemail@exemplo.com  
🔗 LinkedIn: [seulinkedin](https://linkedin.com/in/seulinkedin)
