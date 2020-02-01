## Projeto da cadeira de PEOO
Projeto em Java feito no Eclipse para conter as questões da cadeira de PEOO.

A essa disciplina faz parte da grade do curso de Ciência da Computação na UECE - Universidade Estadual do Ceará, semestre 2019.2.

- [x] Adicionar as classes para trabahar com <b>JSON</b>.

## Dependência do projeto

[JSON.simple](https://mvnrepository.com/artifact/com.googlecode.json-simple/json-simple) - Lib para manipular JSON.
---

## Exercícios (os 1.x não existem)

2.1
- [x] Faça um programa que receba dois números reais (double), calcule e mostre a mÃ©dia entre eles.
- [x] Caso a média seja maior que 7, mostrar a mensagem Aprovado, se não mostrar Reprovado.

2.2
- [x] Faça um programa que receba o nome e a idade de um 5 pessoas e mostre o nome e a idade da pessoa mais nova e da pessoa mais velha.

2.3 
- [x] Faça um programa que peça ao usuário para entrar com 7 números inteiros e armazene-os em um vetor. 
- [x] Peça também para ele entrar com outro número inteiro X e determine se X está no vetor e em que posição. 
- [x] Considerando o vetor da questão anterior, verifique se os números estão em ordem crescente. Caso contrário, ordene e imprima o vetor.

---

3.1 As maçãs custam R$ 1,30 cada se forem compradas menos de uma dúzia, e R$ 1,00 cada se forem compradas pelo menos uma dúzia. Escreva um programa que leia o número de maçãs compradas, calcule e escreva o custo total da compra.

- [x] Escreva um programa que leia o número de maçãs compradas, calcule e escreva o custo total da compra.

3.2 Faça o algoritmo que, dadas três dimensões (A, B e C), faça o seguinte: 
a) Verifique se as três dimensões formam um triângulo. Caso não formem, apresentar uma mensagem para o usuário. Obs.: Três dimensões conseguem formar um triângulo, quando cada uma dessas dimensões, individualmente, for menor que a soma das outras duas dimensões.
b) Caso as dimensões formem um triângulo, apresentar qual tipo de triângulo elas formam. Sabe-se que:
 * Triângulo do tipo equilátero possui os três lados iguais; 
 * Triângulo do tipo isósceles possui dois lados iguais;
 * Triângulo do tipo escaleno possui os três lados diferentes.

- [x] Implementar a).
- [x] Implementar b).

3.3 Faça um algoritmo que leia um vetor de inteiros de 10 posições: 
- [x] a. Informe se existe algum número repetido e que número é esse.
- [x] b. Informe quantos números menores do que 0 existem no vetor.
- [x] c. Informe a soma de todos os números do vetor.
- [x] d. Imprima o vetor em ordem inversa.
- [x] e. Ordene o vetor de menor para o maior número

3.4. Faça um algoritmo que leia a quantidade de dinheiro existente no caixa de uma empresa, a quantidade de produtos a ser comprada e o preço de cada unidade. Caso o valor total da compra seja superior a 80% do valor em caixa, a compra deve ser feita a prazo (3x), com juros de 10% sobre o valor total. Caso contrário, a compra deverá ser realizada a vista, onde a empresa receberá 5% de desconto. Apresentar a forma de pagamento e o valor a ser pago (total a vista ou total a prazo), dependendo da escolha realizada.

- [x] Ler a quantidade de dinheiro existente no caixa de uma empresa.
- [x] Implementar o cálculo do júros.

3.5. Faça o algoritmo para calcular e apresentar o valor a ser pago pelo período de estacionamento do automóvel (PAG). O usuário entra com os seguintes dados: hora (HE) e minuto (ME) de entrada, hora (HS) e minuto (MS) de saída. Sabe-se que esse estacionamento cobra hora cheia, ou seja, se passar um minuto, ele cobra a hora inteira. O valor cobrado pelo estacionamento é:
 * R$ 5,00 para uma hora de estacionamento;
 * R$ 8,00 para duas horas de estacionamento;
 * R$ 2,00 por hora adicional (acima de duas horas).
 
 -[x] Faça o algoritmo para calcular e apresentar o valor a ser pago pelo período de estacionamento do automóvel (PAG). O usuário entra com os seguintes dados: hora (HE) e minuto (ME) de entrada, hora (HS) e minuto (MS) de saída.

3.6. Receber do usuário uma matriz quadrada (número de linhas = número de colunas) de inteiros e preenchê-la de acordo com os valores informados pelo usuário. Ao final exibir 
- [x] a) A soma dos elementos inseridos na matriz.
- [x] b) A soma dos elementos da diagonal principal 
- [x] c) Se a matriz é diagonal (todos os elementos são 0, menos os contidos na diagonal principal)
- [x] d) Qual o maior e o menor elemento da matriz.

---

4.1 Refaça a classe Conta Bancária de forma que ela contenha dois construtores: 

- [x] um que inicializa todos seus atributos por parâmetro 
 -[x] e outro que inicialize apenas o titular e o número por parâmetro e inicialize o saldo como 0 no corpo do construtor. Use a cláusula this. 

4.2 
- [x] Escreva uma classe chamada “Comparavel” que tem como atributo um valor inteiro, 
- [x] um construtor para inicializar o atributo e
- [x] os métodos “eMaiorOuIgual”, “eMenorOuIgual” e “eDiferenteDe” que recebem um valor do tipo int como parâmetro e retornam true se o valor do atributo for, respectivamente, maior ou igual, menor ou igual ou diferente do passado como parâmetro 

4.3 
- [x] Escreva uma classe “Potência” que tem dois atributos inteiros: x, y. 
- [x] Crie um construtor que recebe esses valores e um método “elevar” que calcula e retorna o valor de x elevado a y (atenção: não vale usar classes matemáticas!) 
- [x] Crie uma classe executável para testar a classe acima.

---

5.1 
- [x] Crie uma classe Banco que possui como atributos um nome e um vetor de contas. 
- [x] Faça um construtor que recebe o nome do banco e a quantidade de elementos no vetor, e inicialize os atributos. 
- [x] Faça também métodos de procurar uma conta (passando como parâmetro o número da conta), cadastrar uma nova conta e transferir dinheiro entre contas. 
- [x] Crie uma classe Principal que instancie um banco e forneça ao usuário um menu para ele criar contas, sacar, depositar e alterar dados.

 ---

6.1 Crie uma classe Pessoa contendo nome e telefone. Crie um construtor e métodos de acesso aos atributos. Crie um método para mostrar os dados de uma pessoa. Crie uma classe Agenda que possui uma lista de pessoas. Implemente métodos para adicionar (se já existir, sugerir substituir), procurar (pelo nome ou pelo telefone), alterar telefone e remover pessoas. Crie também um método para mostrar todas as pessoas da lista. Crie uma classe Principal para exercitar sua Agenda

- [x] Classe Pessoa contendo nome e telefone.
- [x] Construtor e métodos de acesso aos atributos. 
- [x] Método para mostrar os dados de uma pessoa.
- [x] Classe Agenda que possui uma lista de pessoas.
- [x] Métodos para <b>adicionar</b> (se já existir, sugerir substituir), <b>procurar</b> (pelo nome ou pelo telefone), <b>alterar telefone</b> e <b>remover</b> pessoas.
- [x] Método para mostrar todas as pessoas da lista.
- [x] Classe Principal para exercitar sua Agenda.

6.2 Incremente sua Agenda para permitir que você possa enviar uma mensagem de texto a um contato. Todas as mensagens devem ser armazenadas na agenda. Para tanto, crie a classe Mensagem, que possui como atributos o contato para o qual a mensagem foi enviada, o texto da mensagem, e a data de envio. Passe os dois primeiros parâmetros no construtor da mensagem, enquanto a data é criada automaticamente. Crie também um método para mostrar o nome do destinatário, a mensagem e a hora de envio. Na classe Agenda, crie uma lista de mensagens e um método enviarMensagem, que recebe o número do contato e a mensagem a ser enviada, e realiza o envio. Disponibilize no seu menu principal opções para visualizar todas as mensagens enviadas ou apenas as enviadas para um determinado contato, mostrando também a quantidade de mensagens enviadas.

- [x] Criar a Classe Mensagem, , que possui como atributos o contato para o qual a mensagem foi enviada, o texto da mensagem, e a data de envio. Passe os dois primeiros parâmetros no construtor da mensagem, enquanto a data é criada automaticamente.
- [x] Metodo para mostrar o nome do destinatário da mensagem, a mensagem e a hora de envio.
- [x] Na classe Agenda, crie uma lista de mensagens e um método enviarMensagem, que recebe o número do contato e a mensagem a ser enviada, e realiza o envio.
- [x] Disponibilize no seu menu principal opções para visualizar todas as mensagens enviadas ou apenas as enviadas para um determinado contato, mostrando também a quantidade de mensagens enviadas.
