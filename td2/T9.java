public class T9 extends Thread {
    maListe mL;
    
    public T9(maListe mlst){
        mL = mlst;
    }

    public void run (){
        System.out.println(" t9 begin inc index 62");
        mL.incrémente(62); 
        System.out.println(" t9 fin inc index 62");
    }
}
