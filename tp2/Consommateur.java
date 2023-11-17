import java.util.Random;

public class Consommateur extends Thread {
    
    private Data myData;
    
    public Consommateur (Data d){
        myData = d;        
    }

    public void run() {
        
        Random random = new Random();
        while (true) {
            String message = myData.recuperer() ;
            System.out.format("\u001B[31m" + "Consommateur  a lu : %s \u001B[0m \n", message);
            try {
                Thread.sleep(random.nextInt(500));
            } catch (InterruptedException e) {}
        }
    }   

}
