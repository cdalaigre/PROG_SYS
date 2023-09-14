public class CalculTD extends Thread{

    private MatriceTD M1;
    private MatriceTD M2;
    private MatriceTD M3; // Matrice resultat
    private int rowIndex; // Numero de la ligne de m1 a multiplier avec les colonnes de m2
     
    CalculTD(MatriceTD a, MatriceTD b, MatriceTD c, int row)
    {
        M1 = a;
        M2 = b;
        M3 = c;
        rowIndex = row;
    }

    public void run()
    {
            int[] tmp = new int[M2.matrix[0].length];

            // Pour chaque colonne de la matrice 2 ...
            for (int j = 0; j < M2.matrix[0].length; j++)
            {
                // Somme des produits, nous donne *un* element de tmp
                for (int k = 0; k < M2.nbcol; k++)
                {
                    tmp[j] += M1.matrix[rowIndex][k] * M2.matrix[k][j];
                }
            }

            M3.matrix[rowIndex] = tmp;
    }
}
