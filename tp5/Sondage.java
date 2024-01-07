import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sondage {
    
    Map<String, Integer> resultats;

    public Sondage(){
        resultats = new HashMap<String,Integer>();
    }

    public void addProposition(String proposition){
        resultats.put(proposition,0);
    }

    public List<String> getPropositions(){
        return new ArrayList<>(resultats.keySet());
    }

    public synchronized String resultat(){
        if (resultats.size()>0){
            int max=0;
            String res = "";
            for (Map.Entry<String, Integer> entry : resultats.entrySet()) {
                // Mettre à jour la valeur maximale si une valeur plus grande est trouvée
                if (entry.getValue() > max) {
                    max = entry.getValue();
                    res = entry.getKey();
                }
            }
            return res;
        }
        else
            return "aucun candidat";
    }

    public synchronized boolean voter (int position){
        if (getPropositions().size() > position){
            String proposition = getPropositions().get(position);
            if (resultats.containsKey(proposition)){
                resultats.put(proposition,resultats.get(proposition)+1);
                return true;
            }
            else return false;
        }
        else
            return false;
    }
}
