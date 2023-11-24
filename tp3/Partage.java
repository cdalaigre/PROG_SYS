public class Partage {
    
    public static void main(String args[]){
    
        Ressource r = new Ressource();
        Ecrivain e = new Ecrivain(r);
        Lecteur l1 = new Lecteur(r);
        Lecteur l2 = new Lecteur(r);
    
        e.start();
        l1.start();
        l2.start();   
    }
}
