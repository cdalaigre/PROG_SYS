import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;

public class ClientSondage {
    
    public static void main(String args[]){

        try {

            String message="";

            if (args.length == 1){
                 message = args[0];
            }

            if (args.length == 2){
                 message = args[0]+ " " +args[1];
            }

            // création socket client
            Socket socket = new Socket("127.0.0.1",5555);

            //mécanique pour la lecture des données sur le socket client
            InputStreamReader stream = new InputStreamReader(socket.getInputStream());
            BufferedReader reader = new BufferedReader(stream);

            //mécanique pour l'écriture des données sur le socket client
            PrintWriter writer = new PrintWriter(socket.getOutputStream());

            // écriture des éléments sur le socket à destination du serveur
            writer.println(message);
            writer.flush();

            // réception du résultat envoyé par le serveur
            System.out.println(reader.readLine());


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

