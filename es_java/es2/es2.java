import java.util.ArrayList;
import java.util.List;

abstract class MaterialeBibliotecario{
    private String titolo;
    private int annoPubblicazione;
    public MaterialeBibliotecario(String titolo, int annoPubblicazione) {
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
    }
    public String getTitolo() {
        return titolo;
    }
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }
    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }
    public void setAnnoPubblicazione(int annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }   

    public abstract String stampa();

}
class Libro extends MaterialeBibliotecario{
    private String autore;
    public Libro(String titolo, int annoPubblicazione, String autore) {
        super(titolo, annoPubblicazione);
        this.autore = autore;
    }
    public String getAutore() {
        return autore;
    }
    public void setAutore(String autore) {
        this.autore = autore;
    }
    @Override
    public String stampa() {
        return "Libro: " + getTitolo() + " anno pubblicazione  " + getAnnoPubblicazione() + " autore: " + autore;
    }

}
class Riviste extends MaterialeBibliotecario{
    private int numeroEdizione;
    public Riviste(String titolo, int annoPubblicazione, int numeroEdizione){
        super(titolo, annoPubblicazione);
        this.numeroEdizione = numeroEdizione;
     }
     @Override
    public String stampa() {
        return "Rivista: " + getTitolo() + " Anno Pubblicazione: " + getAnnoPubblicazione() + " Numero Edizione: " + numeroEdizione ;
    }

}
class Biblioteca{
     public List<MaterialeBibliotecario> materiale;
     public Biblioteca(){
        this.materiale= new ArrayList<>();
    
     }

    public void AggiungiMateriale(MaterialeBibliotecario m){
        materiale.add(m);

    }
    public void RimuoviMateriale(MaterialeBibliotecario m){
        materiale.remove(m);
    }
    public void VisualizzaMateriale(){
        for(MaterialeBibliotecario a : materiale) {
            if (a instanceof Libro){
                System.out.println(((Libro)a).stampa());
            }
            else if (a instanceof Riviste){
                System.out.println(((Riviste)a).stampa());
            }
        }
    }
}
public class es2{
    public static void main(String[] args){
        Libro libro1 = new Libro("Il Nome della Rosa", 1980, "Umberto Eco");
        Riviste rivista1 = new Riviste("National Geographic", 2021, 12);


        Biblioteca biblioteca = new Biblioteca();
        biblioteca.AggiungiMateriale(libro1);
        biblioteca.AggiungiMateriale(rivista1);
        biblioteca.VisualizzaMateriale();
        biblioteca.RimuoviMateriale(rivista1);
        biblioteca.VisualizzaMateriale();

    }
}