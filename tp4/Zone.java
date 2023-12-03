import java.util.concurrent.CyclicBarrier;

public class Zone {

    //carte representant l'état de la zone à instant T
    private int[][] carte;
    
    //carte representant l'état de la zone à instant T+1
    private int[][] carteT1;
    
    //Indicateur d'un changement dans la carte, si la carte à l'instant T est identique à l'intant T+1, l'incendie ne se propage plus
    private boolean hasChanged = true;
    
    //Barriere d'attente
    private CyclicBarrier barrier;
        
    public Zone(int length, int width, CyclicBarrier cb) {
        this.carte = new int[length][width];
        this.carteT1 = new int[carte.length][carte[0].length];
        this.barrier = cb;
        //initialisation de l'incendie
        this.carte[1][1] = 3;
        this.carte[1][2] = 3;
        this.carte[12][2] = 3;
        this.carte[12][1] = 3;
        this.carte[11][11] = 3;
        this.carte[11][12] = 3;
        this.carte[12][12] = 3;
        this.carte[12][11] = 3;
    }

    public int[][] getCarte(){
        return carte;
    }

    public CyclicBarrier getBarrier() {
        return barrier;
    }

     //Conflit possible sur la variable, exclusion mutuelle nécessaire
    public synchronized void setChanged(boolean changed) {
        hasChanged = changed;
    }

    //Conflit possible sur la variable, exclusion mutuelle nécessaire
    public synchronized boolean hasChanged() {
        return hasChanged;
    }

    /**
       Calcul de la valeur de la case i,j au prochain tour à partir de la carte 'carte', et écriture dans la case i,j de la carte 'carteT1'   
     **/
    public void propagationCase(int i, int j) {
        int val = this.carte[i][j];

        //augmentation des flammes
        if (val > 0 && val <= 3) {
            this.carteT1[i][j]++;
            this.setChanged(true);
        }
        //zone intact
        else if (val == 0) {
        for (int k = i - 1; k <= i + 1; k++) {
            if (k >= 0 && k < this.carte.length) {
            for (int l = j - 1; l <= j + 1; l++) {
                if (l >= 0 && l < this.carte[i].length) {
                /*if (this.carte[k][l] < 4)*/ val += this.carte[k][l];
                }
            }
            }
        }
        // voisins suffisamment enflammes, la case s'enflamme
        if (val >= 6) {
            this.carteT1[i][j] = 1;
            this.setChanged(true);
        }
        // voisins pas assez en feu, la case reste intact, recopie de l'ancienne valeur
        else this.carteT1[i][j] = this.carte[i][j];
        } else this.carteT1[i][j] = this.carte[i][j];
    }

    public void display() {
        for (int i = 0; i < carte.length; i++) {
            for (int j = 0; j < carte[0].length; j++) {
                if (carte[i][j]==0) System.out.print("\u001B[32m" + carte[i][j] + "\u001B[0m"+ "|");
                if (carte[i][j]==1) System.out.print("\u001B[33m" + carte[i][j] + "\u001B[0m"+ "|");
                if (carte[i][j]==2) System.out.print("\u001B[31m" + carte[i][j] + "\u001B[0m"+ "|");
                if (carte[i][j]==3) System.out.print("\u001B[35m" + carte[i][j] + "\u001B[0m"+ "|");
                if (carte[i][j]==4) System.out.print("\u001B[40m" + "\u001B[30m" + carte[i][j] + "\u001B[0m"+ "|");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
         Echange des deux cartes, la carte actuelle pointe vers la carte de l'instant T+1
        La carte T+1 pointe vers l'ancienne carte pour éviter d'allouer de la mémoire
        **/
    public void switchCarte() {
        int[][] carteAux = carte;
        carte = carteT1; // la nouvelle matrice prend la place de l'ancienne
        carteT1 = carteAux;
    }
    
}
