// if elements are entirely non ncreasing or non decreasing

// [1] -> Time: O(n), Space: O(1) 
class Program {
  public static boolean isMonotonic(int[] array) {
    boolean inc = true;
		boolean dec = true;
		
		for (int i = 1; i < array.length; i++) {
			if (array[i] < array[i-1]) inc = false;
			if (array[i] > array[i-1]) dec = false;
		}
		return inc || dec;
  }
}
