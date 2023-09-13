public class Calcul extends Thread{
    private Matrice M1;
    private Matrice M2;
    private Matrice M3; // Matrice resultat
    private int rowIndex; // Numero de la ligne de m1 a multiplier avec les colonnes de m2
     
    Calcul(Matrice a, Matrice b, Matrice c, int row)
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
