import java.io.*;


class Punto2D implements java.io.Serializable {
    private double x, y;

    public Punto2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Punto2D() {
        x = 0;
        y = 0;
    }

    public double ascissa() {
        return x;
    }

    public double ordinata() {
        return y;
    }
}

class ScritturaPoint2D {
    public static void main(String[] args) {
        try {
            FileOutputStream f = new FileOutputStream("esempio.bin");
            ObjectOutputStream os = new ObjectOutputStream(f);
            Punto2D p = new Punto2D(3.2, 1.5);
            os.writeObject(p);
            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //deserializzazione
        try{
            FileInputStream f =
            new FileInputStream("esempio.bin");
            ObjectInputStream is =
            new ObjectInputStream(f);
            Punto2D p;
            p = (Punto2D)is.readObject();
            is.close();
            System.out.println("x,y = " + p.ascissa() + ", " + p.ordinata());
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();

        }

    }
 }

