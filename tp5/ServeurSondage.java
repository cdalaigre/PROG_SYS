import java.net.ServerSocket;
import java.net.Socket;

public class ServeurSondage {
   
    public static void main(String [] args){
        
        Sondage sondage = new Sondage();
        sondage.addProposition("alice");
        sondage.addProposition("bob");
        sondage.addProposition("carl");
    
        try {

            // creéation socket serveur
            ServerSocket serverSocket = new ServerSocket(5555);

            while(true){

                // attente de la connexion d'un client
                Socket socketClient= serverSocket.accept();

                //thread initialisé avec le socket client et la ressource sondage
                ClientSondage ClientSondage = new ClientSondage(socketClient,sondage);

                //thread démarré
                ClientSondage.start();

            }
        }
        catch(Exception e ){
            e.printStackTrace();
        }
        
    }


}

