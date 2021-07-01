// check if array is subsequence of the main array (need not be contiguous)

/// [1] -> Time: O (n), Space: O(1) 
class Program {
  public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
    int seq_pos = 0;
		for (int i = 0; i < array.size(); i++) {
			if (seq_pos ==  sequence.size()) {
				break;
			}
			if (sequence.get(seq_pos).equals(array.get(i))) {
				seq_pos++;
			}
		}
    return seq_pos == sequence.size();
  }
}


// [2] -> Time: O (n), Space: O(1) 
class Program {
  public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
    int seq_pos = 0;
		for (int i = 0; i < array.size(); i++) {
			if (seq_pos ==  sequence.size()) {
				break;
			}
			if (sequence.get(seq_pos).equals(array.get(i))) {
				seq_pos++;
			}
		}
    return seq_pos == sequence.size();
  }
}

