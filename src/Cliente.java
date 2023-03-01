import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import java.util.Date;

public class Cliente {
    private static int counter = 1;
    private int numeroPessoa ;
    private String name;
    private long cpf;
    private String renda;
    private Date accountCreationDate;

    MaskFormatter mascaraCpf = null;
    public Cliente(String name, long cpf, String renda) {
        this.numeroPessoa = Cliente.counter;
        this.name = name;
        this.cpf = cpf;
        this.renda = renda;
        this.accountCreationDate = new Date();
        Cliente.counter += 1;
    }

    public int getNumeroPessoa() {
        return this.numeroPessoa;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public long getCpf() {
        return cpf;
    }
    public void setCpf(long cpf) {
        this.cpf = cpf;
    }
    public String getRenda() {
        return renda;
    }
    public void setRenda(String renda) {
        this.renda = renda;
    }
    public Date getAccountCreationDate() {
        return this.accountCreationDate;
    }

    private <mascaraCpf> void Mascara() throws ParseException {
        mascaraCpf cpf = (mascaraCpf) new MaskFormatter ( "###.000.###-##" );

    }

    public String toString() {
        return  "\nName: " + this.getName() +
                "\nCPF: " + this.getCpf() +
                "\nRenda " + this.getRenda(); // +
                //"\nAccount Creation Date: " + Utils.dateToString(this.getAccountCreationDate());
    }


}
