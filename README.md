# 🗳️ VotingSystem

<p align="center">
  <img src="https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=java" />
  <img src="https://img.shields.io/badge/SpringBoot-3.2.2-6DB33F?style=for-the-badge&logo=springboot" />
  <img src="https://img.shields.io/badge/WebSocket-RealTime-blue?style=for-the-badge" />
  <img src="https://img.shields.io/badge/Database-H2-lightgrey?style=for-the-badge" />
</p>

<p align="center">
  <b>Sistema de votação com atualização de resultados em tempo real</b>
</p>

---

## 📖 Sobre o Projeto

O **VotingSystem** é uma API REST desenvolvida com foco em:

- 🔹 Arquitetura organizada em camadas  
- 🔹 Comunicação assíncrona com WebSocket  
- 🔹 Atualização automática de resultados  
- 🔹 Persistência com JPA  
- 🔹 Estrutura pronta para evoluir para produção  

Sempre que um voto é registrado, todos os clientes conectados recebem o novo resultado instantaneamente.

---

## 🛠️ Stack Tecnológica

| Tecnologia | Função |
|------------|--------|
| **Java 17** | Linguagem principal |
| **Spring Boot** | Framework base |
| **Spring Web** | API REST |
| **Spring Data JPA** | Persistência |
| **H2 Database** | Banco em memória |
| **WebSocket (STOMP + SockJS)** | Atualização em tempo real |
| **Maven** | Gerenciador de dependências |

---

## 🏗️ Arquitetura

```
Controller
   ↓
Service
   ↓
Repository
   ↓
Database (H2)
```

**Fluxo de atualização em tempo real:**

```
POST Vote → Atualiza Banco → Recalcula Resultado → Broadcast WebSocket
```

Sem polling.  
Sem refresh.  
Atualização instantânea.

---

## 🚀 Como Executar

### 1️⃣ Clone o projeto

```bash
git clone https://github.com/otaviorodiguess/votingsystem.git
```

### 2️⃣ Acesse a pasta

```bash
cd votingsystem
```

### 3️⃣ Execute a aplicação

```bash
mvn spring-boot:run
```

📍 A aplicação estará disponível em:

```
http://localhost:8080
```

---

## 🎮 Endpoints

### ➕ Criar candidato
`POST /votes/candidate`

```json
{
  "name": "Candidato A"
}
```

---

### 📋 Listar candidatos
`GET /votes/candidates`

---

### 🗳️ Votar
`POST /votes/{candidateId}`

---

### 📊 Resultados
`GET /votes/results`

---

## 📡 WebSocket

| Configuração | Valor |
|--------------|-------|
| Endpoint | `/vote-websocket` |
| Canal | `/topic/results` |

Sempre que um voto é registrado, o sistema envia automaticamente a lista atualizada de candidatos para todos os clientes conectados.

---

## 🗄️ Console H2

📍 Acesse:

```
http://localhost:8080/h2-console
```

**Configuração:**

```
JDBC URL: jdbc:h2:mem:testdb
Usuário: sa
Senha: (em branco)
```

---

## 🔮 Melhorias Futuras

- 🔐 Autenticação com Spring Security  
- 🌐 Frontend consumindo WebSocket  
- 🧪 Testes com JUnit + Mockito  
- 🐳 Dockerização  
- ☁️ Deploy em nuvem  
- 🐘 Migração para PostgreSQL  

---

## 👨‍💻 Autor

**Otávio Rodrigues**  
Desenvolvedor Backend Java  

Se achou interessante, considere deixar uma ⭐ no repositório.
