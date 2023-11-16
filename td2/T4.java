public class T4 extends Thread {
    maListe mL;

    public T4(maListe mlst){
        mL = mlst;
    }

    public void run (){
        System.out.println(" t4 begin get index 62");
        mL.get(62);
        System.out.println(" t4 fin get index 62");
    }
}
