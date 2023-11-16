public class T8 extends Thread {
    maListe mL;
    
    public T8(maListe mlst){
        mL = mlst;
    }

    public void run (){
        System.out.println(" t8 begin get index 19");
        mL.get(19); 
        System.out.println(" t8 fin get index 19");
    }
}
