public class MatriceTD {
    
    public
        int matrix[][];
        int nbrow, nbcol;
    
    public MatriceTD(int r, int c){
        nbrow=r;
        nbcol=c;
        matrix=new int[nbrow][nbcol];

        for (int i = 0; i < nbrow; i++)
        {
            for (int j = 0; j < nbcol; j++)
                matrix[i][j] = (int)(Math.random() * 10);
        }
    }

    public MatriceTD MultiplierPar(MatriceTD m){

        MatriceTD Res = new MatriceTD(this.nbrow, m.nbcol) ;

        // pour chaque ligne de la matrice 1
        for (int i = 0; i < nbrow; i++)
        {
            int[] tmp = new int[m.matrix[0].length];

            // Pour chaque colonne de la matrice 2 ...
            for (int j = 0; j < m.matrix[0].length; j++)
            {
                // Somme des produits, nous donne *un* element de tmp
                for (int k = 0; k < m.nbcol; k++)
                {
                    tmp[j] += matrix[i][k] * m.matrix[k][j];
                }
            }

            Res.matrix[i] = tmp;
        }
        return Res;
    }

    public void Afficher(){
        for (int i = 0; i < nbrow; i++)
        {
            for (int j = 0; j < nbcol; j++)
                System.out.print(matrix[i][j] + " ");
             
            System.out.println("");
        }
    }

    
}
