import java.util.ArrayList;
import java.util.List;


interface Animale{
    void emettiVerso();
    void muoviti();
}
abstract class AnimaleBase implements Animale{
    protected String nome;

    public AnimaleBase(String nome){
        this.nome = nome;
    }
    public String getNome(){
            return nome;
    }
} 
class Cane extends AnimaleBase{
    public Cane(String nome){
        super(nome);
    }
    @Override
    public void emettiVerso(){
        System.out.println("Il cane " + nome + " abbaia.");
    }
    @Override
    public void muoviti(){
        System.out.println("Il cane " + nome + " corre.");
    }
}
class Gatto extends AnimaleBase{
    public Gatto(String nome){
        super(nome);
    }
    @Override
    public void emettiVerso(){
        System.out.println("Il gatto " + nome + " miagola.");
    }
    @Override
    public void muoviti(){
        System.out.println("Il gatto " + nome + " cammina.");
    }
}

 public class es3 {
    public static void main(String[] args){
        List<Animale> animali = new ArrayList<>();

        //aggiungo alcuni animali alla lista 
        animali.add(new Cane("Fido"));
        animali.add(new Gatto("Fiocco"));
        animali.add(new Cane("wendy"));
        animali.add(new Gatto("Cloe"));
        
        for (Animale animale : animali) {
            animale.emettiVerso();
            animale.muoviti();
            System.out.println();
        }
    }

}
