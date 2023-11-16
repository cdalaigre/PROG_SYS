import java.util.List;
import java.util.ArrayList;

public class maListe {
    List <Integer> liste ;
   
    public maListe() {
        liste = new ArrayList <Integer >();
        for (int i=0 ; i<70; i++) liste.add((int)(Math.random() * 20));
    }

    public int get( int index ){
        System.out.println(" get index " + index);      
        return liste.get(index);        
    }
    
    public void incrémente ( int index ){
        System.out.println(" GO inc index " + index);
        int valeur = liste.get( index );
        valeur = valeur +1;
        liste.set(index , valeur );
        System.out.println(" inc index " + index + " OK : " + valeur);
    }
}