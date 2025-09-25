package es_SortingSystem;
import java.util.*;
public class es_SortingSystem{

    // Interfaccia Sortable
     public interface Sortable {
        public void  compare();
        public void  swap();
        public int count();
    }

    // Classe SortedCollection
    public class SortedCollection implements Sortable {
        private Sorter s;
        //private List<Integer> elements;

        public SortedCollection() {
            s = new QuickSorter(); // oppure new HyperSorter()
        
        }

        public void add() {} 
        public String get(){return "";}
        public void remove(){}
        public void compare(){}
        public void swap(){}
        public int count() {return 0;}
        
        public void sort(){
            s.sort(this);
        }

    }

        // Classe astratta Sorter
        public abstract class Sorter extends SortedCollection {
            public Sorter(){}
            public abstract void sort(Sortable sender);
        }

        // Implementazione QuickSorter
        public class QuickSorter extends Sorter {
            public QuickSorter(){}
            public void sort(Sortable sender) {}

        public class HyperSorter extends Sorter{
            public HyperSorter(){}
            public void sort(Sortable sender){}
        }   

    }
}

