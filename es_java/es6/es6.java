import java.util.*;
interface Pagabile{
    void effettuaPagamento(double importo);
}
abstract class MetodoPagamento implements Pagabile{
    protected double saldoDisponibile;

    public MetodoPagamento(double saldoDisponibile){
        this.saldoDisponibile=saldoDisponibile;
    }
   
}

class CartaDiCredito extends MetodoPagamento{
    public CartaDiCredito(double saldoDisponibile){
        super(saldoDisponibile);
    }
    @Override
    public void effettuaPagamento(double importo)  {
        try{
             if (importo <= getSaldo()){
            System.out.println("pagamento con carta di credito effettuato: " + importo);
            saldoDisponibile = saldoDisponibile - importo;
            System.out.println("saldo rimanente su carta di credito " + getSaldo());
        }else{
            throw new SecurityException("saldo insufficiente sulla carta di credito. ");
        }
        }catch(SecurityException e){
            System.err.println(e.getMessage());
        }
       
    }
    public double getSaldo(){
       return saldoDisponibile;
    }
}
class Paypal extends MetodoPagamento{
    public Paypal(double saldoDisponibile){
        super(saldoDisponibile);
    }
    @Override
    public void effettuaPagamento(double importo)  {
        try{
             if (importo <= getSaldo()){
            System.out.println("pagamento con paypal effettuato: " + importo);
            saldoDisponibile = saldoDisponibile - importo;
            System.out.println("saldo rimanente su paypal " + getSaldo());
        }else{
            throw new SecurityException("saldo insufficiente sulla Paypal. ");
        }
        }catch(SecurityException e){
            System.err.println(e.getMessage());
        }
       
    }
    public double getSaldo(){
       return saldoDisponibile;
    }
}


class SistemaPagamenti {
    private List<MetodoPagamento> metodiPagamento;
    
    public SistemaPagamenti() {
        this.metodiPagamento = new ArrayList<>();
    }
    public void aggiungiMetodoPagamento(MetodoPagamento m){
        metodiPagamento.add(m);
    }
   public void Remove(MetodoPagamento m){
        metodiPagamento.remove(m);
   }
}


public class es6 {
    public static void main(String[] args) {
        CartaDiCredito c1 = new CartaDiCredito(1233);
       Paypal p1 = new Paypal(345);

        


        c1.effettuaPagamento(50);
        c1.effettuaPagamento(60);
        p1.effettuaPagamento(50);
    }
}
