import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable{

    BufferedReader reader;
    PrintWriter writer;
    Sondage sondage;
    Socket socket;

    public ClientHandler(Socket socketClient, Sondage sondage) {
        this.sondage=sondage;
        this.socket=socketClient;

        try {
            reader = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
            writer = new PrintWriter(socketClient.getOutputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void run(){

        String message="";

        while(!message.equals("quit")){

            try {
                    message = reader.readLine();
                    String[] messages = message.split(" ");
                    String retour="";

                    switch(messages[0]){
                        case "candidats" : retour = sondage.getPropositions().toString();break;
                        case "resultat" : retour =sondage.resultat();break;
                        case "vote" : if (sondage.voter(Integer.parseInt(messages[1]))) retour = "OK"; else retour="ERR"; break;
                        case "quit" : retour="quit";break;
                        default : retour="Erreur";
                }
                writer.println(retour);
                writer.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

