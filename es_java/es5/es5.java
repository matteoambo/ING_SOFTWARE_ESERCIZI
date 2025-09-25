import java.util.*;
import java.util.concurrent.ExecutionException;
interface Prenotabile{
    public String prenota();

}
abstract class Viaggio implements Prenotabile{
    public String destinazione;
    public double prezzo;
    public Viaggio(String destinazione, double prezzo){
        this.destinazione=destinazione;
        this.prezzo=prezzo;
    }
    public String descrizione(String destinazione, double prezzo){
        return destinazione + ", con costo di:  "+ prezzo;
    }
}
class ViaggioAereo extends Viaggio{
    public String compagniaAerea;
    public String numeroPosto;
    public String status_viaggio;
    public ViaggioAereo(String destinazione, double prezzo, String compagniaAerea, String numeroPosto, String status_viaggio){
        super(destinazione,prezzo);
        this.compagniaAerea=compagniaAerea;
        this.numeroPosto=numeroPosto;
        this.status_viaggio=status_viaggio;
    }
    public String descrizioneViaggio(){
        return "Viaggio in Aereo con destinazione" + descrizione(destinazione, prezzo);

    }

    public String descrizione(String destinazione, double prezzo){
        return destinazione + ", con costo di:  "+ prezzo;
    }
    @Override
    public String prenota(){
        if(status_viaggio.equals("disponibile")){
            status_viaggio="prenotato";
            System.out.println(descrizione(destinazione, prezzo)+ " " +status_viaggio);
            return "viaggio prenotato";
        } else{
            System.out.println(descrizione(destinazione, prezzo)+ " " +status_viaggio);
            return "viaggio non disponibile";
        }

    }
}
class ViaggioTreno extends Viaggio{
    public String compagniaTreno;
    public String numeroPosto;
    public String status_viaggio;
    public ViaggioTreno(String destinazione, double prezzo, String compagniaTreno, String numeroPosto, String status_viaggio){
        super(destinazione,prezzo);
        this.compagniaTreno=compagniaTreno;
        this.numeroPosto=numeroPosto;
        this.status_viaggio=status_viaggio;

    }
    public String descrizioneViaggio(){
        return "Viaggio in Treno con destinazione" + descrizione(destinazione, prezzo);

    }
    public String descrizione(String destinazione, double prezzo){
        return destinazione + ", con costo di:  "+ prezzo;
    }
    @Override
    public String prenota(){
        if(status_viaggio.equals("disponibile")){
            status_viaggio="prenotato";
            System.out.println(descrizione(destinazione, prezzo)+ " " +status_viaggio);
            return "viaggio prenotato";
        } else{
            System.out.println(descrizione(destinazione, prezzo)+ " " +status_viaggio);
            return "viaggio non disponibile";
        }
    }


    
}
class SistemaPrenotazioni{
    public List<Viaggio> viaggi;
    public SistemaPrenotazioni(){
        this.viaggi=new ArrayList<>();
    }
    public void AggiungiViaggi(Viaggio v){
        viaggi.add(v);

    }
    public void RimuoviViaggio(Viaggio v){
        viaggi.remove(v);
    

    }
}


public class es5 {
    public static void main(String[] args) {
        SistemaPrenotazioni s = new SistemaPrenotazioni();
        ViaggioAereo viaggio1=new ViaggioAereo("roma",345,"luftansa","56","disponibile");
        ViaggioAereo viaggio2=new ViaggioAereo("madrid",365,"rynair","56"," non disponibile");
        ViaggioTreno viaggiot1=new ViaggioTreno("Lisbona", 346,"frecciarossa","89","disponibile");

        s.AggiungiViaggi(viaggio1);
        s.AggiungiViaggi(viaggio2);
        s.AggiungiViaggi(viaggiot1);
        s.RimuoviViaggio(viaggio2);


        try {
            if((viaggio1.prenota()).equals("viaggio non disponibile")){
                throw new ExecutionException("viaggio non prenotato perchè non disponibile", null);
            }
        }catch(ExecutionException e){
            System.err.println(e.getMessage());
        }
        try {
            if((viaggio2.prenota()).equals("viaggio non disponibile")){
                throw new ExecutionException("viaggio non prenotato perchè non disponibile", null);
            }
        }catch(ExecutionException e){
            System.err.println(e.getMessage());
        }

        try {
            if((viaggiot1.prenota()).equals("viaggio non disponibile")){
                throw new ExecutionException("viaggio non prenotato perchè non disponibile", null);
            }
        }catch(ExecutionException e){
            System.err.println(e.getMessage());
        }


    }
    
}
