public class T10 extends Thread {
    maListe mL;
    
    public T10(maListe mlst){
        mL = mlst;
    }

    public void run (){
        System.out.println(" t10 begin inc index 62");
        mL.incrémente(62); 
        System.out.println(" t10 fin inc index 62");
    }
}
