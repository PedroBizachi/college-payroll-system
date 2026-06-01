import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  private static final double SALARIO_BASE = 2000.00;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    List<Colaborador> colaboradores = new ArrayList<>();
    int opcao;

    do {
      // NOTE: Printa menu antes de pedir a opção
      printMenu();

      opcao = lerInteiro(scanner, "Escolha uma opção", 0);

      // NOTE: Switch case para manejar as opções do menu
      switch (opcao) {
        case 1:
          cadastrarFuncionario(scanner, colaboradores, 1);
          break;
        case 2:
          cadastrarFuncionario(scanner, colaboradores, 2);
          break;
        case 3:
          cadastrarFuncionario(scanner, colaboradores, 3);
          break;
        case 4:
          gerarFolhaPagamento(scanner, colaboradores);
          break;
        case 0:
          System.out.println("Programa encerrado.");
          break;
        default:
          // NOTE: Mensagem de erro para opção inválida
          System.out.println("Opção inválida. Tente novamente.");
          break;
      }
    } while (opcao != 0);

    scanner.close();
  };

  /**
   * Função simples para printar as opções do menu na tela
   */
  private static void printMenu() {
    System.out.println();
    System.out.println("=== Sistema de Folha de Pagamento ===");
    System.out.println("1 - Cadastrar funcionario padrão");
    System.out.println("2 - Cadastrar funcionario comissionado");
    System.out.println("3 - Cadastrar funcionario de produção");
    System.out.println("4 - Gerar folha de pagamento");
    System.out.println("0 - Sair");
    System.out.println();
  }

  /**
   * Função geral de cadastro de Funcionário
   *
   * @param sc            Informe a instância do scanner utilizado para ler a
   *                      entrada do usuário
   * @param colaboradores Informe a instância da ArrayList a ser utilizada para
   *                      armazenar os colaboradores
   * @param tipo          Informe o tipo de funcionário: 1.Padrão, 2.Comissionado
   *                      ou 3.Produção
   */
  private static void cadastrarFuncionario(Scanner sc, List<Colaborador> colaboradores, Integer tipo) {
    DadosBasicos dados = lerDadosBasicos(sc);

    switch (tipo) {
      case 1:
        colaboradores.add(new Colaborador(dados.nome, dados.matricula, "Padrão", 0.0, 0.0, 0.0));
        System.out.println("Funcionário padrão cadastrado com sucesso.");
        break;
      case 2:
        double vendas = lerDecimal(sc, "Informe valor das vendas: ", 0.0);
        double percentual = lerDecimal(sc, "Informe comissão percentual: ", 0.0);
        double comissao = (vendas * percentual) / 100;
        System.out.println(comissao);
        colaboradores.add(new Colaborador(dados.nome, dados.matricula, "Comissionado", vendas, percentual, comissao));
        System.out.println("Funcionário comissionado cadastrado com sucesso.");
        break;
      case 3:
        int quantidade = lerInteiro(sc, "Informe quantidade de peças: ", 0);
        double valorPorPeca = lerDecimal(sc, "Informe valor da peça: ", 0.0);
        double bonus = quantidade * valorPorPeca;
        colaboradores.add(new Colaborador(dados.nome, dados.matricula, "Produção", quantidade, valorPorPeca, bonus));
        System.out.println("Funcionário produção cadastrado com sucesso.");
        break;

      default:
        break;
    }
  }

  /**
   * Função para printar folha de pagamento
   *
   * @param sc            Informe a instância do scanner utilizado para ler a
   *                      entrada do usuário
   * @param colaboradores Informe a instância da ArrayList a ser utilizada para
   *                      armazenar os colaboradores
   */
  private static void gerarFolhaPagamento(Scanner sc, List<Colaborador> colaboradores) {
    System.out.println();
    System.out.println("Total de pessoas cadastradas: " + colaboradores.size());

    if (colaboradores.isEmpty()) {
      System.out.println("Nenhum funcionário cadastrado.");
      aguardarEnter(sc);
      return;
    }

    System.out.printf("%-20s | %-13s | %-9s | %-13s | %-14s | %-10s | %-13s%n",
        "Nome", "Tipo", "Matrícula", "Salário Fixo", "Vendas/Quant.", "%/Valor", "Salário Final");
    System.out.println(
        "-----------------------------------------------------------------------------------------------------");

    for (Colaborador colaborador : colaboradores) {
      System.out.printf("%-20s | %-13s | %-9d | R$ %-10.2f | %-14.2f | %-10.2f | R$ %-10.2f%n",
          colaborador.nome,
          colaborador.tipo,
          colaborador.matricula,
          SALARIO_BASE,
          colaborador.valorMovimento,
          colaborador.percentualOuValor,
          colaborador.calcularSalarioFinal());
    }

    aguardarEnter(sc);
  }

  /**
   * Função para aguardar o print do menu para melhor visibilidade da folha de
   * pagamento
   *
   * @param sc Informe a instância do scanner utilizado para ler a
   *           entrada do usuário
   */
  private static void aguardarEnter(Scanner sc) {
    System.out.println();
    System.out.println("Pressione Enter para voltar ao menu...");
    sc.nextLine();
  }

  /**
   * Função para manejar a leitura de valores inteiros.
   *
   * @param sc  Informe a instância do scanner utilizado para ler a entrada do
   *            usuário
   * @param msg Mensagem que aparecerá pré-prompt
   * @param min Valor mínimo aceito pela entrada
   */
  private static int lerInteiro(Scanner sc, String msg, Integer min) {
    // NOTE: While true aguarda entrada do usuário
    while (true) {
      // NOTE: Mensagem para guiar usuário
      System.out.println(msg);

      String entrada = sc.nextLine().trim();

      try {
        int valor = Integer.parseInt(entrada);
        if (valor >= min) {
          return valor;
        }
        System.out.println("Informe um número maior ou igual a " + min + ".");
      } catch (NumberFormatException e) {
        // NOTE: NumberFormatException para lidar com entrada de caracteres não
        // numéricos
        System.out.println("Informe um número válida.");
      }
    }
  };

  /**
   * Função para manejar a leitura de valores decimais.
   *
   * @param sc  Informe a instância do scanner utilizado para ler a entrada do
   *            usuário
   * @param msg Mensagem que aparecerá pré-prompt
   * @param min Valor mínimo aceito pela entrada
   */
  private static double lerDecimal(Scanner sc, String msg, double min) {
    while (true) {
      System.out.print(msg);
      String entrada = sc.nextLine().trim().replace(",", ".");

      try {
        double valor = Double.parseDouble(entrada);
        if (valor >= min) {
          return valor;
        }
        System.out.printf("Informe um numero maior ou igual a %.2f.%n", min);
      } catch (NumberFormatException erro) {
        System.out.println("Informe um numero decimal valido.");
      }
    }
  }

  /**
   * Função para manejar a entrada dos dados comuns a todos os colaboradores
   *
   * @param sc Informe a instância do scanner utilizado para ler a entrada do
   *           usuário
   * @return Retorna uma classe de dados básicos
   */
  private static DadosBasicos lerDadosBasicos(Scanner sc) {
    String nome;

    do {
      System.out.print("Nome: ");
      nome = sc.nextLine().trim();
      if (nome.isEmpty()) {
        System.out.println("Nome nao pode ficar vazio.");
      }
    } while (nome.isEmpty());

    int matricula = lerInteiro(sc, "Matricula: ", 1);
    return new DadosBasicos(nome, matricula);
  }

  /**
   * Boilerplate para criação de novos colaboradores
   *
   */
  private static class Colaborador {
    private final String nome;
    private final int matricula;
    private final String tipo;
    private final double valorMovimento;
    private final double percentualOuValor;
    private final double extra;

    private Colaborador(String nome, int matricula, String tipo, double valorMovimento, double percentualOuValor,
        double extra) {
      this.nome = nome;
      this.matricula = matricula;
      this.tipo = tipo;
      this.valorMovimento = valorMovimento;
      this.percentualOuValor = percentualOuValor;
      this.extra = extra;
    }

    private double calcularSalarioFinal() {
      return SALARIO_BASE + extra;
    }
  }

  private static class DadosBasicos {
    private final String nome;
    private final int matricula;

    private DadosBasicos(String nome, int matricula) {
      this.nome = nome;
      this.matricula = matricula;
    }
  }
}
