# 🏨 Hotel Reservation System

Sistema de gerenciamento de reservas hoteleiras desenvolvido com **Java + Spring Boot** e banco de dados **PostgreSQL**, seguindo uma arquitetura em camadas bem definida.

---

## 📋 Sobre o Projeto

O **Hotel Reservation System** é uma API REST para gerenciamento completo de reservas de hotel. O sistema permite criar, consultar, atualizar e cancelar reservas de forma simples e eficiente, com uma estrutura de código organizada e escalável.

---

## 🚀 Tecnologias Utilizadas

| Tecnologia | Versão | Descrição |
|---|---|---|
| Java | 17+ | Linguagem principal |
| Spring Boot | 3.x | Framework principal |
| Spring Data JPA | — | Persistência e ORM |
| Spring Web | — | Camada REST |
| PostgreSQL | 15+ | Banco de dados relacional |
| Maven | 3.x | Gerenciador de dependências |
| Hibernate | 6+ | Mapeamento objeto-relacional |

---

## 🏗️ Arquitetura

O projeto segue uma **arquitetura em camadas (Layered Architecture)**, garantindo separação de responsabilidades e maior manutenibilidade:

```
src/
└── main/
    └── java/
        └── com/hotel/reservation/
            ├── controller/    # Camada de apresentação (REST Controllers)
            ├── service/       # Camada de negócio (regras e lógica)
            ├── repository/    # Camada de acesso a dados (Spring Data JPA)
            ├── model/         # Entidades JPA
            └── dto/           # Objetos de transferência de dados
```

---

## ✅ Funcionalidades

- [x] Criar nova reserva
- [x] Listar todas as reservas
- [x] Buscar reserva por ID
- [x] Atualizar dados de uma reserva
- [x] Cancelar / remover uma reserva

---

## ⚙️ Como Executar

### Pré-requisitos

- Java 17 ou superior
- Maven 3.x
- PostgreSQL rodando localmente

### 1. Clone o repositório

```bash
git clone https://github.com/GustaBatista4329/hotel-reservation.git
cd hotel-reservation
```

### 2. Configure o banco de dados

Crie o banco de dados no PostgreSQL:

```sql
CREATE DATABASE hotel_reservation;
```

Atualize o arquivo `src/main/resources/application.properties` com suas credenciais:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/hotel_reservation
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
```

### 3. Execute o projeto

```bash
./mvnw spring-boot:run
```

A API estará disponível em: `http://localhost:8080`

---

## 📡 Endpoints da API

### Reservas

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| `GET` | `/reservations` | Lista todas as reservas |
| `GET` | `/reservations/{id}` | Busca reserva por ID |
| `POST` | `/reservations` | Cria nova reserva |
| `PUT` | `/reservations/{id}` | Atualiza uma reserva |
| `DELETE` | `/reservations/{id}` | Remove uma reserva |

### Exemplo de payload (POST /reservations)

```json
{
  "guestName": "João Silva",
  "checkIn": "2025-04-10",
  "checkOut": "2025-04-15",
  "roomNumber": 101
}
```

---

## 🤝 Contribuindo

Contribuições são bem-vindas! Siga os passos:

1. Faça um **fork** do projeto
2. Crie uma branch para sua feature: `git checkout -b feature/minha-feature`
3. Commit suas alterações: `git commit -m 'feat: adiciona minha feature'`
4. Push para a branch: `git push origin feature/minha-feature`
5. Abra um **Pull Request**

---

## 👨‍💻 Autor

**Gustavo Batista**

[![GitHub](https://img.shields.io/badge/GitHub-GustaBatista4329-181717?style=flat&logo=github)](https://github.com/GustaBatista4329)

---

## 📄 Licença

Este projeto está sob a licença MIT. Consulte o arquivo [LICENSE](LICENSE) para mais detalhes.