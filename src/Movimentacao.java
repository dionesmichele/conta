public class Movimentacao {

    public static void listarContas() {
        if (Menu.contasCorrente.size() > 0) {
            for (Conta conta : Menu.contasCorrente) {
                System.out.println(conta);
            }
        } else {
            System.out.println("--- Não há contas cadastradas ---");
        }

        Menu.op();
    }
            //TODO fazer tratamento para numeros ex: deposito nao aceita letras e encerra prog



}
