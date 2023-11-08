public class CalculTP extends Thread{

    private MatriceTP M1;
    private MatriceTP M2;
    private MatriceTP M3; // Matrice resultat
    private int rowIndex; // Numero de la ligne de m1 a multiplier avec les colonnes de m2
     
    CalculTP(MatriceTP a, MatriceTP b, MatriceTP c, int row)
    {
        M1 = a;
        M2 = b;
        M3 = c;
        rowIndex = row;
    }

    public void run()
    {
        MatriceTP.CalculCoefficients(M1,M2,M3,rowIndex);
    }
}
