public class T2 extends Thread {
    O o;

    public T2(O o){
        this.o= o;
    }

    public void run (){
        o.m2 (2);
    }
}