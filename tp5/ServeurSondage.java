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
                Thread t = new Thread( new ClientHandler(socketClient,sondage));

                //thread démarré
                t.start();

            }
        }
        catch(Exception e ){
            e.printStackTrace();
        }
        
    }


}

