public class Main {

    public static void main(String []args) throws InterruptedException{

        int TAILLE = 10;
        MatriceTP matrice1 = new MatriceTP(TAILLE,TAILLE);
        MatriceTP matrice2 = new MatriceTP(TAILLE,TAILLE);
        long debseq = System.currentTimeMillis();
        MatriceTP resultat = matrice1.MultSeq(matrice2);
        long finseq = System.currentTimeMillis();
        long time = finseq-debseq;
        System.out.println("Temps exécution séquentiel : " + time + " ms");
        
        System.out.println("Nombre de coeurs possibles : " + Runtime.getRuntime().availableProcessors());
        debseq = System.currentTimeMillis();
        resultat = matrice1.MultPar(matrice2);
        finseq = System.currentTimeMillis();
        time = finseq-debseq-500;
        System.out.println("Temps exécution parallèle : " + time + " ms");
        System.out.println();     

    } 
}

/********************************************/
/* TAILLE   |   SEQUENTIEL  |    PARALLELE  */
/*  5000    |  1 431 362 ms |   891 664 ms  */
/*  2000    |     66 582 ms |    34 065 ms  */
/*  1000    |      4 054 ms |     3 719 ms  */
/*   500    |        340 ms |       266 ms  */
/*   200    |         67 ms |        71 ms  */
/*   100    |         15 ms |        70 ms  */
/*    50    |          3 ms |        25 ms  */
/*    20    |          1 ms |        10 ms  */
/*    10    |          1 ms |         6 ms  */
/********************************************/

