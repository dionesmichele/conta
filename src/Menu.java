import java.util.ArrayList;
import java.util.Scanner;


public class Menu {

    public static int accountCounter;
    static Scanner input = new Scanner(System.in);
    static ArrayList<Conta> contasCorrente;


    public static void main(String[] args) {
        contasCorrente = new ArrayList<Conta>();
        op();
    }

    public static void op() {

        System.out.println("-----------------------------------------------------");
        System.out.println("            Olá, que bom te ver por aqui!            ");
        System.out.println("-----------------------------------------------------");
        System.out.println("                 Já é cliente nosso? " +
                "\n              Digite a opção desejada:                          ");
        System.out.println("    (Para encerrar digite '0' a qualquer momento)      ");
        System.out.println(" _____________________________________________________ ");
        System.out.println("|    1 - Criar conta                                  |");
        System.out.println("|    2 - Já possuo conta                              |");
        System.out.println("|    3 - Depositar                                    |");
        System.out.println("|    4 - Sacar                                        |");
        System.out.println("|    5 - Saldo                                        |");
        System.out.println("|    6 - Extrato                                      |");
        System.out.println("|    0 - Sair                                         |" +
                         "\n|_____________________________________________________|");

        int operacao = input.nextInt();


        switch (operacao) {
            case 1:
                criarConta();
                break;

            case 2:
                Conta.encontrarConta(operacao);//entrar na conta ja existente
                break;

            case 3:
                depositar();
                break;

            case 4:
                sacar();
                break;

            case 5:
                saldo();//saldo();
                break;

            case 6:
                System.out.println("Emitindo extrato");
                break;

            case 0:
                System.out.println("    Agradecemos por usar nossos serviços, até logo!!");
                System.exit(0);
                break;

            default:
                System.out.println("Opção inválida!");
                op();
                break;
        }
    }

    public static void criarConta() {

        System.out.println(" _____________________Criar Conta______________________" +
                "\n         Insira seus dados para abertura de conta:");

        System.out.println("\nNome: ");
        String nome = input.next();

        System.out.println("\nCPF: ");
        long cpf = Long.parseLong(input.next());

        System.out.println("Renda: ");
        String renda = input.next();

        Cliente cliente = new Cliente(nome, cpf, renda);

        Conta conta = new Conta(cliente);

        contasCorrente.add(conta);
        System.out.println("____________________________________________________________\n" +
                "                 Sua conta foi criada com sucesso!     " + conta);
        conta.getNumeroConta();
        op();

    }


    public static void depositar() {
        System.out.println(" ____________________Depósito_________________________");

        System.out.println("            Número da conta que deseja depositar: ");
        int numeroConta = input.nextInt();
        Conta conta = Conta.encontrarConta(numeroConta);

        if (conta != null) {
            System.out.println("         Qual valor deseja depositar? ");
            Double valorDeposito = input.nextDouble();

            conta.depositar(valorDeposito);
        } else {
            System.out.println("             --- Conta não encontrada ---");
        }

        op();

    }

    public static void sacar() {
        System.out.println(" _____________________Saque_________________________");
        System.out.println("Número da conta: ");
        int numeroConta = input.nextInt();

        Conta conta = Conta.encontrarConta(numeroConta);

        if (conta != null) {
            System.out.println("Qual valor deseja sacar? ");
            Double valorSaque = input.nextDouble();

            conta.sacar(valorSaque);
            System.out.println("--- Saque realizado com sucesso! ---");
        } else {
            System.out.println("--- Conta não encontrada ---");
        }

        op();

    }

    private static String saldo() {
        System.out.println(" _____________________Saldo______________________");
        System.out.println("Número da conta: ");
        int numeroConta = input.nextInt();

        Conta conta = Conta.encontrarConta(numeroConta);

        if (conta != null) {
            System.out.println("           O valor do seu saldo é de " + Conta.getSaldo());
            conta.getSaldo();
            op();
        }
        return null;
    }
}