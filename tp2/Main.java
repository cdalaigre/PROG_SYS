public class Main {

    public static void main(String[] args) {
        Data la_data = new Data();
        Producteur prod = new Producteur(la_data);
        Consommateur conso = new Consommateur(la_data);

        prod.start();
        conso.start();  

        try {
            Thread.sleep(30000);    // s'execute pendant 30 secondes
        } catch (InterruptedException e) {}

       /*  (new Thread(new Producteur(la_data))).start();
	    (new Thread(new Producteur(la_data))).start();

        (new Thread(new Consommateur(la_data))).start();
	    (new Thread(new Consommateur(la_data))).start(); */
    } 

}
