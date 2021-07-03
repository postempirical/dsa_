// take a 2d array and print its elements in spiral order in another array

// [1] -> Time: O(n), Space: O(n)  
class Program {
  public static List<Integer> spiralTraverse(int[][] array) {
    if (array.length == 0) return new ArrayList<Integer>();
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		int sr = 0; 			// start row
		int er = array.length - 1; 	// end row
		int sc = 0; 			// start column
		int ec = array[0].length - 1;   // end column
		
		while (sr <= er && sc <= ec) {
			for (int col = sc; col <= ec; col++) {
				result.add(array[sr][col]);
			}
			for (int row = sr + 1; row <= er; row++) {
				result.add(array[row][ec]);
			}
			for (int col = ec - 1; col >= sc; col--) {
				if (sr == er) break;
				result.add(array[er][col]);
			}
			for (int row = er - 1; row > sr; row--) {
				if (sc == ec) break;
				result.add(array[row][sc]);
			}
			
			sr++;sc++;
			er--;ec--;
		}
		
    return result;
  }
}


// [2] -> Time: O(n), Space: O(n)  {recursive}
class Program {
  public static List<Integer> spiralTraverse(int[][] array) {
    if (array.length == 0) return new ArrayList<Integer>();
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		spiral(array, 0, array.length - 1, 0, array[0].length - 1, result);
		return result;
  }

	public static void spiral(int[][] array, int sr, int er, int sc, int ec, ArrayList<Integer> result) {
			if (sr > er || sc > ec) return;
	
			for (int col = sc; col <= ec; col++) {
				result.add(array[sr][col]);
			}
			for (int row = sr + 1; row <= er; row++) {
				result.add(array[row][ec]);
			}
			for (int col = ec - 1; col >= sc; col--) {
				if (sr == er) break;
				result.add(array[er][col]);
			}
			for (int row = er - 1; row > sr; row--) {
				if (sc == ec) break;
				result.add(array[row][sc]);
			}

		spiral(array, sr + 1, er - 1, sc + 1, ec - 1, result);
	}
}


// [3] -> Time: O(n), Space: O(n)
class Program {
  public static List<Integer> spiralTraverse(int[][] array) {
    if (array.length == 0) return new ArrayList<Integer>();
		
		int direction = 0;
		// direction 0 -- to right
		// direction 1 -- to bottom
		// direction 2 -- to left
		// direction 3 -- to up
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		int sr = 0; 			// start row
		int er = array.length - 1; 	// end row
		int sc = 0; 			// start column
		int ec = array[0].length - 1;   // end column
		
		while (sr <= er && sc <= ec) {
			if (direction == 0) {
				for (int col = sc; col <= ec; col++) {
					result.add(array[sr][col]);
				}
				sr++;
			}
			if (direction == 1) {
				for (int row = sr; row <= er; row++) {
					result.add(array[row][ec]);
				}
				ec--;
			}
			if (direction == 2) {
				for (int col = ec; col >= sc; col--) {
					result.add(array[er][col]);
				}
				er--;
			}
			if (direction == 3) {
				for (int row = er; row >= sr; row--) {
					result.add(array[row][sc]);
				}
				sc++;
			}
			direction = (direction + 1) % 4;
		}
		
    return result;
  }
}

