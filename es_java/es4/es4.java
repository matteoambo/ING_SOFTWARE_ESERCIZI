import java.util.*;
abstract class Dipendente {
    public String nome;
    public double stipendio;
    public abstract double calcolaStipendio();
    public Dipendente(String nome , double stipendio){
        this.nome = nome;
        this.stipendio = stipendio;
    }
}
class Impiegato extends Dipendente{
    public Impiegato(String nome , double stipendio){
        super(nome, stipendio);
    }
    public double calcolaStipendio(){
        return stipendio;
    }
    public String Nome(){
        return nome;
    }
    
}
class Manager extends Dipendente{
    public Manager(String nome , double stipendio){
        super(nome, stipendio);
    }
    public double calcolaStipendio(){
       return (stipendio*2)+stipendio;
    }
    public String Nome(){
        return nome;
    }
}
class Azienda{
    public List<Dipendente> dipendenti;
    public Azienda(){
        this.dipendenti = new ArrayList<>();
    }
    public void AggiungiDipendenti(Dipendente d){
        dipendenti.add(d);

    }
    public void RimuoviDipendenti(Dipendente d){
        dipendenti.remove(d);

    }
    public void VisualizzaDipendenti(){
        for(Dipendente d: dipendenti){
            if(d instanceof Impiegato){
                System.out.println(" Impiegato:  " +((Impiegato)d).Nome() + "  Stipendio: " +((Impiegato)d).calcolaStipendio());
            }
            else{
                System.out.println(" Manager: " +((Manager)d).Nome() + " Stipendio: " +((Manager)d).calcolaStipendio());
            }
        }

    }
}
public class es4 {
    public static void main(String[] args) {
        Impiegato Impiegato1 = new Impiegato("Silvio Simani", 5000);
        Manager  Manager1 = new Manager("Cesare Stefanelli",4000);


        Azienda azienda= new Azienda();
        azienda.AggiungiDipendenti(Impiegato1);
        azienda.AggiungiDipendenti(Manager1);
        azienda.VisualizzaDipendenti();
       
        
    }
}
