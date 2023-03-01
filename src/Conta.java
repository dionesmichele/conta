import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Conta {

    private static int accountCounter = 1;

    static NumberFormat formatandoNumeros = new DecimalFormat( "R$ #,##0.00" );
    private int numeroConta;
    private Cliente cliente;
    private static Double saldo = 0.0;


    public Conta(Cliente cliente) {
        this.numeroConta = Menu.accountCounter;
        this.cliente = cliente;
        this.updateSaldo();
        Menu.accountCounter += 1;
    }

    public static String doubleToString(Double valor) {
        return Conta.formatandoNumeros.format(valor);
    }
    public int getNumeroConta() {
        return numeroConta;
    }
//    public Cliente getClient() {
//        return cliente;
//    }
//    public void setClient(Cliente cliente) {
//        this.cliente = cliente;
//    }
    public static Double getSaldo() {
        return saldo;
    }
    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    private void updateSaldo() {
        this.saldo = this.getSaldo();
    }



    public String toString() {

        return "\n"+
                "\n               Número da conta: " + this.getNumeroConta() +
                "\n               Cliente: " + this.cliente.getName() +
                "\n               CPF: " + this.cliente.getCpf() +
                "\n               Saldo: " + Conta.doubleToString(this.getSaldo()) +
                "\n" ;
    }

    public void depositar(Double valor) {
        if(valor > 0) {
            setSaldo(getSaldo());
            this.saldo = this.getSaldo() + valor;
            System.out.println("Seu depósito foi realizado com sucesso!");
        }else {
            System.out.println("Não foi possível realizar o depósito!");
        }
    }

    public void sacar(Double valor) {
        if(valor > 0 && this.getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);
            System.out.println("Saque realizado com sucesso!");
        }else {
            System.out.println("Não foi possível realizar o saque!");
        }

    }
    static Conta encontrarConta(int numeroConta) {
        Conta conta = null;
        if (Menu.contasCorrente.size() > 0) {
            for (Conta contas : Menu.contasCorrente) {
                if (contas.getNumeroConta() == numeroConta) {
                    conta = contas;
                }
            }
        }
        return conta;
    }
}
