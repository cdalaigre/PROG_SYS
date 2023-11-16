import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main( String args []){

        /* //Questions 1.1 et 1.2 : Pas d'entrelacement car méthodes sychronisées
        System.out.println("************* QUESTION 1.1 ET 1.2 *****************\n");
        List<Thread> listThreads11_12 = new ArrayList<>();
        O o = new O();
        T1 t1 = new T1(o);
        T2 t2 = new T2(o);
        listThreads11_12.add(t1);
        listThreads11_12.add(t2);
        t1.start ();
        t2.start ();

        for(Thread t : listThreads11_12){
			try{
				t.join();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		} */

        
        //Question 1.3 : entrelacement possible car deux objets différents

        //Question 1.4 : Non, car si le thread est dans m1, il a l’accès exclusif sur l’objet courant, donc en appelant
        // une méthode synchronized sur le même objet, il est sûr d’être le seul sur l’objet

        System.out.println("\n ********************* QUESTION 1.3 & 1.4 **********************\n");
        List<Thread> listThreads13 = new ArrayList<>();
        O o1 = new O();
        O o2 = new O();
        T1 t1 = new T1(o1);
        T2 t2 = new T2(o2);
        listThreads13.add(t1);
        listThreads13.add(t2);
        t1.start ();
        t2.start ();

        for(Thread t : listThreads13){
			try{
				t.join();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}


         //Questions 2.1 
        System.out.println("\n ********************* QUESTION 2.1 **********************\n");
         // consultation de deux éléments différents de la liste : pas de conflit
        List<Thread> listThreads21 = new ArrayList<>();
        maListe myList= new maListe();
        T3 t3 = new T3(myList);
        T4 t4 = new T4(myList);
        listThreads21.add(t3);
        listThreads21.add(t4);
        t3.start ();
        t4.start ();

        for(Thread t : listThreads21){
			try{
				t.join();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}

        // incrémentation de deux éléments différents de la liste : pas de conflit
        T5 t5 = new T5(myList);
        T6 t6 = new T6(myList);
        listThreads21.add(t5);
        listThreads21.add(t6);
        t5.start ();
        t6.start ();

        for(Thread t : listThreads21){
			try{
				t.join();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}

        // consultation du même élément de la liste : pas de conflit
        T7 t7 = new T7(myList);
        T8 t8 = new T8(myList);
        listThreads21.add(t7);
        listThreads21.add(t8);
        t7.start ();
        t8.start ();

        for(Thread t : listThreads21){
			try{
				t.join();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}

        // consultation du même élément de la liste : conflit possible
        T9 t9 = new T9(myList);
        T10 t10 = new T10(myList);
        listThreads21.add(t9);
        listThreads21.add(t10);
        t9.start ();
        t10.start ();

        for(Thread t : listThreads21){
			try{
				t.join();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
               
    }
        
    
}
