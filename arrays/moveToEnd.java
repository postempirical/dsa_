// move selected element to end of array without maintaining order 

// [1] -> Time: O(n^2??), Space: O(1)  
class Program {
  public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
		int i = 0;
		int j = array.size() - 1;
		while (i < j) {
			while (i < j && array.get(j) == toMove) j--;
			if (array.get(i) == toMove) {
				int temp = array.get(i);
				array.set(i, array.get(j));
				array.set(j, temp); 
			}
			i++;
		}
		return array;
  }
}
