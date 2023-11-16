public class Main {
    public static void main(String []args) throws InterruptedException{

        // TD n°1 Exercice 1 
        T1 t1 = new T1();
        T2 t2 = new T2();
        t1.start();
        t2.start();   
        System.out.println("x");
        
        // TD n°1 Exercice 2 algo séquentiel
        MatriceTD matrice1 = new MatriceTD(2,2);
        matrice1.Afficher();
        System.out.println();
        MatriceTD matrice2 = new MatriceTD(2,2);
        matrice2.Afficher();
        System.out.println();
        long debseq = System.currentTimeMillis();
        MatriceTD resultat = matrice1.MultiplierPar(matrice2);
        long finseq = System.currentTimeMillis();
        resultat.Afficher();
        System.out.println(finseq-debseq);

        // TD n°1 Exercice 2 algo parallèle
        debseq = System.currentTimeMillis();
        ThreadGroup threadGroup = new ThreadGroup("MM");
        Thread t = new Thread();
        // Un thread pour chaque ligne
        for (int i = 0; i < 2; i++)
        {
            t = new Thread(threadGroup, new CalculTD(matrice1, matrice2, resultat, i));
            t.start();
        }
        // On attend que tous les threads termine
        while (threadGroup.activeCount() != 0)
        {
            Thread.sleep(500);
        }
        finseq = System.currentTimeMillis();
        resultat.Afficher();
        System.out.println(finseq-debseq);


    } 
}
