import java.util.concurrent.*;

public class ExecutorTab{

    public int [] tab;
    public int max = 0;

    public synchronized boolean majMax(int value){
        if (max < value){
            max = value;
            return true;
        }
        return false;
    }

    public void updateMax(){

        ExecutorService pool = Executors.newFixedThreadPool(4);
        int n = 10;
        int nbp = tab.length/n;
        for (int i=0;i<nbp;i++){
            int deb = i*n;
            int fin = (i+1)*n;
            if (i == nbp-1)
            fin=tab.length;
            pool.submit(new ExecutorWorker(this,deb,fin));
        }
        pool.shutdown();
        try{
            pool.awaitTermination(Long.MAX_VALUE,TimeUnit.SECONDS);
        }
        catch(Exception e){e.printStackTrace();}
    }

    public static void main(String [] args){
        int [] tab = {1,2,3,4,5,6,7,8,9,10,11,12,11,10,9,8,7,6,30};
        ExecutorTab t = new ExecutorTab();
        t.tab= tab;
        t.updateMax();
        System.out.println(t.max);
    }
    
    
}
