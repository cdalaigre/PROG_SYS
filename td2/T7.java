public class T7 extends Thread {
    maListe mL;
    
    public T7(maListe mlst){
        mL = mlst;
    }

    public void run (){
        System.out.println(" t7 begin get index 19");
        mL.get(19); 
        System.out.println(" t7 fin get index 19");
    }
}
