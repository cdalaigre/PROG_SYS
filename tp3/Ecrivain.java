import java.util.Random;


class Ecrivain extends Thread{

    Ressource maRessource;

    public Ecrivain(Ressource uneRessource){
	    maRessource = uneRessource;
    }


    public void run(){
	    Random random = new Random();

        try{
            while(true){
                maRessource.ecrire();
                try{
                    Thread.sleep(random.nextInt(5)*10000);
                }
                catch(Exception e){
                    e.printStackTrace();
                }       
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}