import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServeurCalculatrice {
    
    //Opérations usuelles sur des entiers
    public static int addition(int a,int b){        return a + b;    }
    public static int soustraction(int a,int b){    return a - b;    }    
    public static int multiplication(int a,int b){  return a * b;    }    
    public static int division(int a,int b){        return a / b;    }

    public static void main(String [] args){

        try {

            //Deux sockets :
            //ServerSocket : ecouter et accepter les connexions
            //Socket : pour communiquer avec le client

            // création du serveur sur un port spécifique 
            ServerSocket serverSocket = new ServerSocket(5555);

            while(true){
                // attente d'une connexion d'un client
                Socket Socket= serverSocket.accept();

                //mécanique pour la lecture des données sur le socket client
                InputStreamReader stream = new InputStreamReader(Socket.getInputStream());
                BufferedReader reader = new BufferedReader(stream);

                //mécanique pour l'écriture des données sur le socket client
                PrintWriter writer = new PrintWriter(Socket.getOutputStream());

                // lecture sur le socket du type d'opération (ex : a + b)
                String message = reader.readLine();
                System.out.println(message);

                // découpage du message selon les espaces
                String[] operations = message.split(" ");

                // récupération de l'opérateur
                String operateur = operations[1];

                //récupération des opérandes
                int operande1 = Integer.parseInt(operations[0]);
                int operande2 = Integer.parseInt(operations[2]);

                //calcul du résultat
                int resultat=0;
                switch(operateur){
                    case "+" : resultat = addition(operande1,operande2); break;
                    case "-" : resultat = soustraction(operande1, operande2);break;
                    case "x" : resultat = multiplication(operande1,operande2);break;
                    case "/" : resultat = division(operande1,operande2);break;
                }

                // écriture du résultat sur le socket client
                writer.println("Resultat = "+resultat);
                writer.flush();

                // fermture socket client
                Socket.close();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

}
