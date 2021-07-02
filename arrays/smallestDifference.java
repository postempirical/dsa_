//

// [1] -> Time: O(nlogn + mlogm), Space: O(1) 
class Program {
  public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
    // Write your code here.
		Arrays.sort(arrayOne);
		Arrays.sort(arrayTwo);
		int indexOne = 0;
		int indexTwo = 0;
		
		int minimum = Integer.MAX_VALUE;
		int current = Integer.MAX_VALUE;
		
		int[] smallestPair = new int[2];
		
		while (indexOne < arrayOne.length && indexTwo < arrayTwo.length) {
			int first = arrayOne[indexOne];
			int second = arrayTwo[indexTwo];
			
			if (first < second) {
				current = second - first;
				indexOne++;
			}
			else if (second < first) {
				current = first - second;
				indexTwo++;
			}
			else {
				return new int[] {first, second};
			}
      
			if (current < minimum) {
				minimum = current;
				smallestPair = new int[] {first, second};
			}
		}		
    return smallestPair;
  }
}
