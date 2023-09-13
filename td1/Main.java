public class Main {
    public static void main(String []args){

        // TD n°1 Exercice 1 
        /*T1 t1 = new T1();
        T2 t2 = new T2();
        t1.start();
        t2.start();   
        System.out.println("x");*/

        // TD n°1 Exercice 2 algo séquentiel
        Matrice M1 = new Matrice (1,2,3,4);
        Matrice M2 = new Matrice (5,6,7,8);
        Matrice R = M1.MultiplierPar(M2);
        R.Afficher();

        // TD n°1 Exercice 2 algo parallèle
        
    } 
}
