import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;

public class ClientCalculatrice {
    
    public static void main(String args[]){

        try {

            if (args.length != 3){
                System.out.println(args.length+" "+args);
                System.err.println("Séparer les différents éléments de l'opération par des espaces");
                System.exit(1);
            }

            // récupération des opérandes
            try{
                int operande1 = Integer.parseInt(args[0]);
                int operande2 = Integer.parseInt(args[2]);
            }
            catch(NumberFormatException e){
                System.err.println("L'opération est définie sur des entiers");
                System.exit(1);
            }

            // récupération de l'opérateur
            String [] operateurTab={"+","-","x","/"};
            List<String> operateurs = Arrays.asList(operateurTab); 
            if (!operateurs.contains(args[1])){
                System.out.println("Les opérateurs valables sont "+operateurs);
                System.exit(1);
            }
            String operateur = args[1];

            // création socket client
            Socket socket = new Socket("127.0.0.1",5555);

            //mécanique pour la lecture des données sur le socket client
            InputStreamReader stream = new InputStreamReader(socket.getInputStream());
            BufferedReader reader = new BufferedReader(stream);

            //mécanique pour l'écriture des données sur le socket client
            PrintWriter writer = new PrintWriter(socket.getOutputStream());

            // écriture des éléments sur le socket à destination du serveur
            writer.println(args[0]+" "+args[1]+" "+args[2]);
            writer.flush();

            // réception du résultat envoyé par le serveur
            System.out.println(reader.readLine());


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
