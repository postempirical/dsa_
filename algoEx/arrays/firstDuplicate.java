// print element who duplicate appears first

// [1] -> Time: O(n^2), Space: O(1)  
class Program {
  public int firstDuplicateValue(int[] array) {
    int minIdx = array.length;
		for (int i = 0; i < array.length; i++) {
			for (int j = i; j < array.length; j++) {
				if (array[j] == array[i]) {
					minIdx = Math.min(minIdx, j);
				}
			}
		}
    if (minIdx == array.length) return -1;
		return array[minIdx];
  }
}


// [2] -> Time: O(n), Space: O(n)  
class Program {
  public int firstDuplicateValue(int[] array) {
    HashSet<Integer> duplicate = new HashSet<Integer>();
		for (int i : array) {
			if (duplicate.contains(i)) return i;
			duplicate.add(i);
		}
    return -1;
  }
}


// [1] -> Time: O(n), Space: O(1)  ??
