public class MatriceTP {
    
    public
        int matrix[][];
        int nbrow, nbcol;
    
        // constructeur
    public MatriceTP(int r, int c){
        nbrow=r;
        nbcol=c;
        matrix=new int[nbrow][nbcol];

        for (int i = 0; i < nbrow; i++)
        {
            for (int j = 0; j < nbcol; j++)
                matrix[i][j] = (int)(Math.random() * 10);
        }
    }

        // séquentiel
    public MatriceTP MultSeq(MatriceTP m){

        MatriceTP Res = new MatriceTP(this.nbrow, m.nbcol) ;

        // pour chaque ligne de la matrice 1
        for (int i = 0; i < this.nbrow; i++)
        {
            CalculCoefficients(this,m,Res,i);            
        }
        return Res;
    }

    public static void CalculCoefficients(MatriceTP a, MatriceTP b, MatriceTP c, int index)
    {
        int[] tmp = new int[b.matrix[0].length];

            // Pour chaque colonne de la matrice 2 ...
            for (int j = 0; j < b.matrix[0].length; j++)
            {
                // Somme des produits, nous donne *un* element de tmp
                for (int k = 0; k < b.nbcol; k++)
                {
                    tmp[j] += a.matrix[index][k] * b.matrix[k][j];
                }
            }

            c.matrix[index] = tmp;
    }

        // parallèle
    public MatriceTP MultPar(MatriceTP m) throws InterruptedException {

        MatriceTP Res = new MatriceTP(this.nbrow, m.nbcol) ;

        ThreadGroup threadGroup = new ThreadGroup("MM");
        Thread t = new Thread();

        // Un thread pour chaque ligne
        for (int i = 0; i < this.nbrow; i++)
        {
            t = new Thread(threadGroup, new CalculTP(this, m, Res, i));
            t.start();
        }
        //On attend que tous les threads termine
        while (threadGroup.activeCount() != 0)
        {
            Thread.sleep(500);
        }

        return Res;
    }
        // affichage matrice
    public void Afficher(){
        for (int i = 0; i < nbrow; i++)
        {
            for (int j = 0; j < nbcol; j++)
                System.out.print(matrix[i][j] + " ");
             
            System.out.println("");
        }
    }

    
}
