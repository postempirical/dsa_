// find the length of the longest peak segment in an array

// [1] -> Time: O(n^2??), Space: O(1)  
class Program {
  public static int longestPeak(int[] array) {
		int longestPeak = 0;
		int i = 1; //first element cannot be peak
		while (i < array.length - 1) {
			boolean isPeak = array [i] > array[i-1] && array[i] > array[i+1];
			if (!isPeak) {
				i++;
				continue;
			}
			
			int leftIndex = i - 2;
			while (leftIndex >=0 && array[leftIndex] < array[leftIndex + 1]) {
				leftIndex--;
			}
			int rightIndex = i + 2;
			while (rightIndex < array.length && array[rightIndex] < array[rightIndex - 1]) {
				rightIndex++;
			}
			
			int peakLength = rightIndex - leftIndex - 1;
			if (peakLength > longestPeak) {
				longestPeak = peakLength;
			}
      //skipping all in between as they cannot be peak since they are strictly dec
			i = rightIndex; 
		}
		return longestPeak;
  }
}
