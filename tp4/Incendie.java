import java.util.concurrent.CyclicBarrier;

public class Incendie {
    
    public static void main(String args[]) {

        // la taille de la zone est passé en argument
        final int SIZE = 48; //Integer.parseInt(args[0]);

        // nombre de coeurs disponibles
        int nbThread = Runtime.getRuntime().availableProcessors();
        //System.out.println(nbThread);

        // barriere d'attente
        CyclicBarrier cb = new CyclicBarrier(nbThread);

        // instanciation d'une zone
        Zone zone = new Zone(SIZE, SIZE, cb);

        // division de la carte de la zone
        int size = zone.getCarte().length / nbThread;
        //System.out.println(size);

        // Chaque thread s'occupe de sa portion de carte de la zone
        Pyroman[] tab = new Pyroman[nbThread];

        for (int i = 0; i < nbThread; i++) {
            int debut = i * size;
            int fin = (i + 1) * size;
            if (i == nbThread - 1) fin = zone.getCarte().length;

            //System.out.println("debut : " + debut + " fin : " + fin);
            tab[i] = new Pyroman(zone, debut, fin);
            tab[i].start();
        }
       
      }

}
