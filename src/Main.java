import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  // TODO: Função para gerar folha de pagamento;
  // TODO: Obtém valores da ArrayList, estrutura e printa;
  // TODO: Mini prompt para retornar ao menu para não comprometer visualização;

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
          // funcao gerar folha
          System.out.println("Folha gerada");
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
   *                      entrada do
   *                      usuário
   * @param colaboradores Informe a instância da ArrayList a ser utilizada para
   *                      armazenar os colaboradores
   * @param tipo          Informe o tipo de funcionário: 1.Padrão, 2.Comissionado
   *                      ou
   *                      3.Produção
   */
  private static void cadastrarFuncionario(Scanner sc, List<Colaborador> colaboradores, Integer tipo) {
    DadosBasicos dados = lerDadosBasicos(sc);

    switch (tipo) {
      case 1:
        colaboradores.add(new Colaborador(dados.nome, dados.matricula, "Padrão", 0.0));
        System.out.println("Funcionário padrão cadastrado com sucesso.");
        break;
      case 2:
        double vendas = lerDecimal(sc, "Informe valor das vendas: ", 0.0);
        double percentual = lerDecimal(sc, "Informe comissão percentual: ", 0.0);
        double comissao = vendas * percentual / 100;
        colaboradores.add(new Colaborador(dados.nome, dados.matricula, "Comissionado", comissao));
        System.out.println("Funcionário comissionado cadastrado com sucesso.");
        break;
      case 3:
        int quantidade = lerInteiro(sc, "Informe qtde de pecas: ", 0);
        double valorPorPeca = lerDecimal(sc, "Informe valor da peca: ", 0.0);
        double bonus = quantidade * valorPorPeca;
        colaboradores.add(new Colaborador(dados.nome, dados.matricula, "Produção", bonus));
        System.out.println("Funcionário produção cadastrado com sucesso.");
        break;

      default:
        break;
    }
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

  private static DadosBasicos lerDadosBasicos(Scanner scanner) {
    String nome;

    do {
      System.out.print("Nome: ");
      nome = scanner.nextLine().trim();
      if (nome.isEmpty()) {
        System.out.println("Nome nao pode ficar vazio.");
      }
    } while (nome.isEmpty());

    int matricula = lerInteiro(scanner, "Matricula: ", 1);
    return new DadosBasicos(nome, matricula);
  }

  private static class Colaborador {
    private final String nome;
    private final int matricula;
    private final String tipo;
    private final double extra;

    private Colaborador(String nome, int matricula, String tipo, double extra) {
      this.nome = nome;
      this.matricula = matricula;
      this.tipo = tipo;
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
