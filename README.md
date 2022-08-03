
<h2 align="center">
    <p>👉 API de controle de estacionamento de condomínio</p>
</h2>

<h4 align="center"> 
	🚧 Em construção...  🚧
</h4>

## Descrição do software

<p align="">🚀 O Software para estacionamento com vagas é um sistema de gestão para estacionamentos com tecnologia para a operação de estacionamento de condomnio.
O processo de cadastro é rápido exigindo apenas a placa do veiculo, número do apartamento e o bloco em seguida selecionar o veículo que já está previamente cadastrado todos modelos e marcas existentes e finalmente selecionar uma vaga  vinculada ao apartamento</p>

### Pré-requisitos

Antes de começar, você vai precisar ter instalado em sua máquina as seguintes ferramentas:
[Java SE JDK 11](https://www.techspot.com/downloads/5553-java-jdk.html),[postgres SQL](https://www.postgresql.org/download/). 
Além disto é bom ter um editor para trabalhar com o código como [Spring Tool suíte](https://https://spring.io/tools).

### 🛠 Tecnologias e padrões

As seguintes ferramentas foram usadas na construção do projeto:

- Spring boot
- validation
- Spring Data
- Spring Security
- Perfil de teste com H2
- perfil de desenvolvimento com postgresql
- Padrão Objeto de Transferência de Dados 
- Tratamento de exceções personalizada
- Respostas padronizadas para requisição https

### Realizados

- [x] Cadastro de vagas
- [x] Cadastro de usuário
- [x] Cadastro de usuário e suas autorizações

### 🎲 Rodando o Back End (servidor)

```bash
# Clone este repositório
$ git clone <https://github.com/jefferson-git/parking-control.git>

# Criar base de dados no postgres com nome parking-control-db antes de iniciar aplicação
$ spring.datasource.url=jdbc:postgresql://localhost:5432/parking-control-db

# As dependências
$ arquivo pom.xml

# Execute a aplicação em modo de desenvolvimento
$ spring.profiles.active=dev

# Execute a aplicação em modo de teste
$ spring.profiles.active=tes

# O servidor inciará na porta:8080 - acesse <http://localhost:8080>

# autor 
$ Jeferson Moreira dos Santos
```
