// new array having each elements be the product of the rest of the remaining elements of the array
// eg [5 1 4 2] --> [8 40 10 20]

// [1] -> Time: O(n^2), Space: O(n)
class Program {
  public int[] arrayOfProducts(int[] array) {
		int x = 0;
		int[] result = new int [array.length];
		for (int i = 0; i < array.length; i++) {
			int product = 1;
			for (int j = 0; j < array.length; j++) {
				if (i == j) continue;
				product *= array[j];
			}
			result[i] = product;
		}
    return result;
  }
}


// [2] -> Time: O(n), Space: O(n)
class Program {
  public int[] arrayOfProducts(int[] array) {
    int[] result = new int [array.length];
		int[] leftresult = new int [array.length];
		int[] rightresult = new int [array.length];
		
		
		int leftprod = 1;
		for (int i = 0; i < array.length; i++) {
			leftresult[i] = leftprod;
			leftprod *= array[i];
		}
		int rightprod = 1;
		for (int i = array.length - 1; i >= 0; i--) {
			rightresult[i] = rightprod;
			rightprod *= array[i];
		}
		
		for (int i = 0; i < array.length; i++) {
			result[i] = leftresult[i] * rightresult[i];
		}
    return result;
  }
}


// [4] -> Time: O(n), Space: O(n)
class Program {
  public int[] arrayOfProducts(int[] array) {
    int[] result = new int [array.length];
		
		int leftprod = 1;
		for (int i = 0; i < array.length; i++) {
			result[i] = leftprod;
			leftprod *= array[i];
		}
		int rightprod = 1;
		for (int i = array.length - 1; i >= 0; i--) {
			result[i] *= rightprod;
			rightprod *= array[i];
		}
    return result;
  }
}


