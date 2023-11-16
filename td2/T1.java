public class T1 extends Thread {
    O o;

    public T1(O o){
        this.o= o;
    }

    public void run (){
        o.m1 (1);
    }
}
