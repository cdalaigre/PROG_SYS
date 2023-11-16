public class O {
    int m =5;

    public synchronized void m1( int id){
        System.out.println(" begin m1");
        for ( int i=0;i<m;i++){
            System.out.println (id+" m1 "+i);
        }
        System.out.println ("end m1");
        m2(3);
    }

    public synchronized void m2( int id){
        System.out.println (" begin m2");
        for ( int i=0;i<m;i++){
            System.out.println (id+" m2 "+i);
        }
        System.out.println ("end m2");
        
    }
}
