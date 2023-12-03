import java.util.Random;
import java.util.concurrent.*;

public class ForkJoinTab {

  public static void main(String[] args) {
	final int TAILLE= 100000000;
	final int VMAX = 10;
	Random rand = new Random();

	int[] array = {1,2,3,4,5,6,7,8,9,10,11,12,11,10,9,8,7,6,30};


	ForkJoinPool pool = new ForkJoinPool();
	ForkJoinTrouverMax finder = new ForkJoinTrouverMax(array, 0, array.length);
    System.out.println("Le maximum est : " + pool.invoke(finder));


	array = new int[TAILLE];
	for (int i=0;i<array.length;i++){
		array[i]=rand.nextInt(VMAX);
	}
	array[rand.nextInt(TAILLE)]=VMAX+1;
	finder = new ForkJoinTrouverMax(array, 0, array.length);
    System.out.println("Le maximum est : " + pool.invoke(finder));
	
  }
}