
# Projeto Pokémon – SPTech

Bem-vindo ao repositório do projeto Pokémon, desenvolvido para a entrega do Projeto Individual da São Paulo Tech School. Este projeto consiste em uma aplicação web para gerenciamento de perfil de treinador (Card de Usuário), seleção de Pokémons favoritos e uma funcionalidade interativa de interagir com os Pokémons.

---

## 💻 Tecnologias Utilizadas

- **Front-end:** HTML5, CSS3, JavaScript (Vanilla)
- **Back-end:** Java 21 (Spring Boot)
- **Banco de Dados:** MySQL

---

## 🛠️ Ferramentas Utilizadas

- Git & GitHub
- Visual Studio Code (com extensão Live Server)
- IntelliJ IDEA 
- MySQL Workbench

---

## 📦 Como Executar o Projeto

### 1. Clone o repositório

```bash
git clone git@github.com:luanag03/Projeto-individual-Pokemon.git

```

### 2. Acesse o diretório do projeto

```bash
cd projetoPokemon

```

### 3. Configure o banco de dados

Abra o MySQL Workbench (ou o cliente MySQL de sua preferência) e execute o script abaixo para criar o banco de dados `pokemon` e suas respectivas tabelas (`pokemon` e `usuario`):

```sql
CREATE DATABASE pokemon;

USE pokemon;

CREATE TABLE pokemon (
    idPokemon INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    tipo VARCHAR(30) NOT NULL
);

CREATE TABLE usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nickname VARCHAR(50) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL,
    nome VARCHAR(100),
    idade INT,
    data_nascimento DATE,
    sexo VARCHAR(20),
    tipos_favoritos VARCHAR(255),
    pokemon_inicial VARCHAR(50)
);

INSERT INTO pokemon (nome, tipo) VALUES
('Bulbasaur', 'Planta'),
('Ivysaur', 'Planta'),
('Venusaur', 'Planta'),
('Charmander', 'Fogo'),
('Charmeleon', 'Fogo'),
('Charizard', 'Fogo'),
('Squirtle', 'Água'),
('Wartortle', 'Água'),
('Blastoise', 'Água'),
('Pikachu', 'Elétrico'),
('Raichu', 'Elétrico'),
('Caterpie', 'Inseto'),
('Pidgey', 'Normal'),
('Gengar', 'Fantasma'),
('Mewtwo', 'Psíquico'),
('Snorlax', 'Normal');

```

---

### 4. Configure a conexão com o banco

No arquivo `application.properties` do projeto Spring Boot, configure as credenciais do seu MySQL:

```properties
spring.application.name=pokemon
spring.datasource.url=jdbc:mysql://localhost:3306/Pokemon?useSSL=false&serverTimezone=UTC
spring.datasource.username= SEU_USER
spring.datasource.password= SUA_SENHA
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

```

> ⚠️ *Substitua `SUA_SENHA` pela senha configurada no seu MySQL.*

---

### 5. Execute o Back-end (Spring Boot)

Abra a pasta do projeto Java no **IntelliJ IDEA** (ou IDE de sua preferência) e execute a classe principal anotada com `@PokemonApplication`.

Alternativamente, execute via linha de comando no diretório raiz do back-end:

**Usando Maven Wrapper:**

```bash
./mvnw spring-boot:run

```

O servidor iniciará no endereço local:

`http://localhost:8080`

---

### 6. Execute o Front-end

1. Acesse a pasta do front-end no terminal ou abra-a no Visual Studio Code:
```bash
cd "Projeto Individual/public"

```

2. Certifique-se de ter a extensão **Live Server** instalada no VS Code.
3. Clique com o botão direito no arquivo `login.html` e selecione **"Open with Live Server"**.
4. O navegador abrirá automaticamente a aplicação (geralmente no endereço `http://127.0.0.1:5500`).



## 🎮 Funcionalidades do Sistema

Com o back-end e o front-end em execução, utilize a interface para:

* **Card de Treinador (Perfil do Usuário):** Exibir as informações de perfil do treinador (nickname, idade, sexo, tipos favoritos e Pokémon inicial).

* **Pokémon Favorito:** Exibir o Pokémon selecionado como favorito do usuário.

* **Interação (Fazer Carinho):** Fazer carinho no Pokémon favorito direto na tela, ativando animações e reações do parceiro.
---
## ❤ Desenvolvido por

**Luana Gomes**

📘 *SPTech School*
```
🔗 GitHub: [https://github.com/luanag03](https://github.com/luanag03)

```