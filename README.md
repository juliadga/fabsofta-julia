# Fabrica de Software 2025-1

## Nome da equipe

- Júlia D'Almeida Gaboardi

## Propostas de projeto

- Sistema de E-books
  - Cadastro do usuario
  - Pesquisa do livro
  - Secção gratuita e paga
  - Formas de pagamento
  - Opinião dos livros
  - Recomendações com base nos livros lidos e nas opiniões do usuario em relação aos livros

<s>

- Sistema de banco
  - Cadastro do cliente
  - Transações e transferencias
  - Validação das informações da transação ou transferencia
  - Rendimento e investimentos
</s>

## Livro Eng Software Moderna

[Eng. Soft Moderna - Requisitos](https://engsoftmoderna.info/cap3.html)
https://engsoftmoderna.info/cap3.html#hist%C3%B3rias-de-usu%C3%A1rios

## Histórias de Usuário

- Como um usuário, eu gostaria de ver e editar meus dados de cadastro como: nome, e-mail, idade e senha.
- Como um usuario, eu gostaria de ter uma divisão dos meus livros como: lidos, não lidos e pendentes (começados).
- Como um usuario, eu gostaria de ter filtros, para fazer a pesquisa mais precisa, como: categoria, autor, nome, gratuito, pago e ano lançamento.
- Como um usuario, eu gostaria de ter as formas de pagamento, livres para trocar quando quiser, como: credito, debito, pix e paypal.
- Como um usuario, eu gostaria de poder dar a opinião do livro como: numero de estrelas ate 5 e comentario sobre o livro caso a nota não for 5.

### Configuração inicial

- git config --global user.name "NOME DO USUARIO NO GITHUB"
- git config --global user.email "EMAIL DA CONTA DO GITHUB"

### Criar um branch a partir da branch atual

- git checkout -b branch-seunome

### Commit e Push

- git add .
- git commit -m "tipo: o que foi feito"
- git push -u origin main

### Revisão de Java

https://adoptium.net/

- JRE - Java Runtime Environment (java.exe)
  - Máquina virtual do Java - interpreta o Bytecode(.class) do Java para linguagem de máquina
- JDK - Java Development Kit (javac.exe)
  - Compilar o código Java em bytecode (.class)

### Criação de projeto no VSCode com Maven

1) teclar F1
2) digitar Java e escolher a opção create new java project
3) project type: MAVEN
4) Archetype: No Archetype
5) pacote digitar domínio ao contrário ex: br.univille
6) nome do projeto em minúsculo
7) usar a pasta sugerida pelo vscode