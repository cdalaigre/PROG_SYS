import java.util.concurrent.RecursiveTask;

public class ForkJoinTrouverMax extends RecursiveTask<Integer> {
  private final int[] array;
  private final int low;
  private final int high;

  public ForkJoinTrouverMax(int[] array, int low, int high) {
    this.array = array;
    this.low = low;
    this.high = high;
  }

  @Override
  protected Integer compute() {
    if (high - low < 10) {
      // Si la sous-tâche est assez petite, on peut la résoudre de manière séquentielle
      int max = Integer.MIN_VALUE;
      for (int i = low; i < high; i++) {
          max = Math.max(max, array[i]);
      }
      return max;
    } 
    else 
    {
      // Sinon, on divise la tâche en deux et on lance des sous-tâches
      int mid = low + (high - low) / 2;
      ForkJoinTrouverMax left = new ForkJoinTrouverMax(array, low, mid);
      left.fork();
      ForkJoinTrouverMax right = new ForkJoinTrouverMax(array, mid, high);
      return Math.max(right.compute(), left.join());
    }
  }
}
