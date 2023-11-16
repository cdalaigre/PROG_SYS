public class T6 extends Thread {
    maListe mL;
    
    public T6(maListe mlst){
        mL = mlst;
    }

    public void run (){
        System.out.println(" t6 begin inc index 62");
        mL.incrémente(62); 
        System.out.println(" t6 fin inc index 62");
    }
}
