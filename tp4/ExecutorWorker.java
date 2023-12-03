import java.util.concurrent.*;

public class ExecutorWorker implements Runnable{

    ExecutorTab tab;
    int deb;
    int fin;
    int max=0;
    
    public ExecutorWorker(ExecutorTab tab, int deb, int fin){
	this.tab = tab;
	this.deb= deb;
	this.fin = fin;
    }

    
    public void run(){        
        for (int i=deb;i<fin;i++)
            if (max<tab.tab[i])
            max = tab.tab[i];

        tab.majMax(max);
    }
    
}
