import java.util.Scanner;

public class Main {
  // TODO: Implementar função de prompt do menu;
  // TODO: Função main pode manejar isso;
  // TODO: Função para cadastro de colaborador de acordo tipo;
  // TODO: Salvar colaboradores em ArrayList;
  // TODO: Retorna ao menu inicial após cadastro;
  // TODO: Função para gerar folha de pagamento;
  // TODO: Obtém valores da ArrayList, estrutura e printa;
  // TODO: Mini prompt para retornar ao menu para não comprometer visualização;

  private static final double SALARIO_BASE = 2000.00;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int opcao;

    do {
      // NOTE: Printa menu antes de pedir a opção
      printMenu();

      opcao = lerOpcao(scanner, "Escolha uma opção", 0);

      // NOTE: Switch case para manejar as opções do menu
      switch (opcao) {
        case 1:
          // funcao cadastrar funcionario com argumento "padrao"
          System.out.println("funcionario padrao cadastrado");
          break;
        case 2:
          // funcao cadastrar funcionario com argumento "comissionado"
          System.out.println("funcionario comissionado cadastrado");
          break;
        case 3:
          // funcao cadastrar funcionario com argumento "producao"
          System.out.println("funcionario producao cadastrado");
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
   * Função para manejar a escolha de opções do usuário.
   *
   * @param sc  Informe a instância do scanner utilizado para ler a entrada do
   *            usuário
   * @param msg Mensagem que aparecerá pré-prompt
   * @param min Valor mínimo aceito pela entrada
   */
  private static int lerOpcao(Scanner sc, String msg, Integer min) {
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
        System.out.println("Informe uma opção válida.");
      }
    }
  };
}
