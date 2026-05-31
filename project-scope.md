# Sistema de Folha de Pagamento em Java

Uma empresa hipotética deseja desenvolver um software em para calcular a folha de pagamento de seus colaboradores. Nesta primeira etapa do projeto, os cálculos serão simples, com foco na aplicação dos conceitos fundamentais da linguagem.

> ## Objetivos do projeto
>
> O objetivo é criar um programa que permita cadastrar colaboradores e calcular o salário final de acordo com o tipo de vínculo. O sistema deverá ser interativo, utilizando entrada e saída de dados, estruturas de decisão, laços de repetição, estruturas de seleção e armazenamento de informações em listas (ArrayList).
>
> Conceitos estudados nesta UC que deverão ser aplicados são:
>
> - Tipos de dados primitivos e compostos.
> - Declaração e utilização de constantes e variáveis.
> - Estrutura de entrada e saída de dados (Scanner e System.out).
> - Processamento de informações e cálculos matemáticos.
> - Uso de estruturas condicionais (if, else if, switch).
> - Estruturas de repetição (for, while, do-while).
> - Estrutura de seleção para escolha de opções no menu.
> - Manipulação de listas dinâmicas com ArrayList.
> - Organização do código em classes e métodos simples.

### Regras do Sistema

Cada colaborador deverá possuir os seguintes dados básicos:

- Número de registro

- Nome completo

<details>
  <summary>Três tipos de colaboradores</summary>

1. **Funcionário padrão**
   - Recebe apenas o salário base.

2. **Funcionário comissionado**
   - Recebe salário base + comissão.
   - A comissão é calculada pela seguinte fórmula: Comissão = (vendas \* percentual / 100)
   - Devem ser informados o valor total de vendas no mês e o percentual de comissão.

3. **Funcionário de produção**
   - Recebe salário base + bônus por produtividade.
   - O bônus é calculado pela seguinte fórmula: Bônus = (valorPorPeça \* quantidadeProduzida)
   - Devem ser informados o valor por peça e a quantidade de peças produzidas no período.

</details>
<br>

```
O valor do salário base é R$ 2.000,00 para todos os colaboradores(utilize uma constante para
representar esse valor).
```

#### Funcionalidades do programa

1. **Cadastrar Funcionário Padrão**

Ao informar a opção 1, o usuário deve informar o nome e a matricula do funcionário. O usuário pode cadastrar quantos funcionários quiser.
Exemplo:

```
1.
Nome: Flavio
Matrícula: 123
```

2. **Cadastrar Funcionário Comissionado**

Ao informar a opção 2, o usuário deve informar o nome, a matrícula, o valor total das vendas e o percentual de comissão do funcionário.
Exemplo:

```
2.
Nome: Maria
Matrícula: 234
Informe valor das vendas: 8000
Informe comissão percentual: 5
```

3. **Cadastrar Funcionário Produção**

Ao informar a opção 3, o usuário deve informar o nome, a matricula, a quantidade de peças produzidas, o valor de cada peça produzida pelo funcionário.
Exemplo:

```
3.
Nome: Paulo
Matrícula: 456
Informe qtde de peças: 150
Informe valor da peça: 0,20
```

4. **Gerar Folha de Pagamento**

Ao informar a opção 4, o sistema deve apresentar todos os dados de cada colaborador, conforme exemplo abaixo (não precisa ser nessa mesma formatação, desde que mostre todos os dados).
Exemplo:

```
Total de pessoas cadastradas: 3

|Nome   | Matrícula | Salário Fixo | Vendas / Quant. | % / Bônus | Salário Final |
|Flavio | 123       | 1500.0       | 0.0             | 0.0       | 1500.0        |
|Maria  | 234       | 1500.0       | 4000.0          | 0.1       | 1900.0        |
|Paulo  | 1500.0    | 1500.0       | 3               | 5.0       | 1515.0        |
```

0. **Sair do Programa**

Ao informar a opção 0 (zero), o sistema deve encerrar o processamento.

**Orientações**

- Utilize fluxogramas para planejar o funcionamento do sistema antes da codificação.
- Valide as entradas de dados (ex.: impedir números negativos).
- Armazene os colaboradores em um ArrayList.
