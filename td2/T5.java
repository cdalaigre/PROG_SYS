public class T5 extends Thread {
    maListe mL;
    
    public T5(maListe mlst){
        mL = mlst;
    }

    public void run (){
        System.out.println(" t5 begin inc index 19");
        mL.incrémente(19); 
        System.out.println(" t5 fin inc index 19");
    }
}
