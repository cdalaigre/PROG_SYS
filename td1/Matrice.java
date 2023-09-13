public class Matrice {
    
    private
        int m11,m12,m21,m22;
    
    public Matrice(int a, int b, int c, int d){
        m11 = a;
        m12 = b;
        m21 = c;
        m22 = d ;
    }

    public int getM11(){ return m11;}
    public int getM12(){ return m12;}
    public int getM21(){ return m21;}
    public int getM22(){ return m22;}

    public Matrice MultiplierPar(Matrice m){
        Matrice Res = null ;

        int res11 = m11*m.m11 + m12*m.m21;
        int res12 = m11*m.m12 + m12*m.m22;
        int res21 = m21*m.m11 + m22*m.m21;
        int res22 = m21*m.m12 + m22*m.m22;

        Res = new Matrice (res11,res12, res21, res22);

        return Res;
    }

    public void Afficher(){
        System.out.println(m11 + "\t" + m12);
        System.out.println(m21 + "\t" + m22);
    }

    
}
