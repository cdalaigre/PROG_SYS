public class T3 extends Thread {
    maListe mL;
    
    public T3(maListe mlst){
        mL = mlst;
    }

    public void run (){
        System.out.println(" t3 begin get index 19");
        mL.get(19); 
        System.out.println(" t3 fin get index 19");
    }
}