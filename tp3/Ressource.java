import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Ressource {
    
    int compteur=0;
    ReadWriteLock verrou = new ReentrantReadWriteLock();

    public void lire(int id) {
        verrou.readLock().lock();
        System.out.println("Lecteur" + id +"  commence lecture");
          try{
		Thread.sleep(1000);
	    }
	    catch(Exception e){
		e.printStackTrace();
	    }
        compteur--;
        System.out.println("Lecteur" +id +" termine lecture \t" + compteur);
        verrou.readLock().unlock();
    }

    public void ecrire()  {
        verrou.writeLock().lock();
        System.out.println("Ecrivain commence ecriture");
        try{
            Thread.sleep(5000);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        compteur++;
        System.out.println("Ecrivain termine ecriture \t" + compteur);
        verrou.writeLock().unlock();
    }

}
