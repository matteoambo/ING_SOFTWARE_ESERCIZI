import java.util.ArrayList;
import java.util.List;

// Interfaccia Veicolo 
interface Veicolo {
    void avvia(); //metodo per avviare il veicolo
    void ferma(); //metodo per fermare il veicolo
    String getTipo(); //metodo per ottenere il tipo di veicolo
}

abstract class MezzoDiTrasporto implements Veicolo {
    protected String targa;
    //costruttore della classe astratta MezzoDiTrasporto
    public MezzoDiTrasporto(String targa) {
        this.targa = targa;
    }

    public String getTarga() {
        return targa;
    }
}

class Auto extends MezzoDiTrasporto {
    public Auto(String targa) {
        super(targa);
    }

    @Override
    public void avvia() {
        System.out.println("L'auto con targa " + targa + " è partita.");
    }

    @Override
    public void ferma() {
        System.out.println("L'auto con targa " + targa + " si è fermata.");
    }

    @Override
    public String getTipo() {
        return "Auto";
    }
}

class Moto extends MezzoDiTrasporto {
    public Moto(String targa) {
        super(targa);
    }

    @Override
    public void avvia() {
        System.out.println("La moto con targa " + targa + " è partita.");
    }

    @Override
    public void ferma() {
        System.out.println("La moto con targa " + targa + " si è fermata.");
    }

    @Override
    public String getTipo() {
        return "Moto";
    }
}

public class es1 { //dichiaro la classe GestioneVeicoli che contiene il metodo main questa classe serve a gestire e avviare i veicoli 
    public static void main(String[] args) {
        //crea una lista (mezzi) che può contenere oggetti di tipo veicolo 
        //List<Veicolo> è un interfaccia che definisce una lista di oggetti Veicolo 
        //con una lista posso aggiungere e rimuovere veicoli facilmente
        List<Veicolo> mezzi = new ArrayList<>();
        
        mezzi.add(new Auto("AB123CD"));
        mezzi.add(new Moto("EF456GH"));
        /*grazie al polimorfismo anche se auto e moto sono classi diverse, possono essere memorizzate
        nella stessa lista perchè entrambe implementano l'interfaccia Veicolo*/

        //scorre tutti gli elementi della lista mezzi, Veicolo v --> per ogni elemento della lista viene memorizzato in v
        for (Veicolo v : mezzi) {
            System.out.println("Tipo: " + v.getTipo());
            v.avvia();
            v.ferma();
            System.out.println();
        }
    }
}

