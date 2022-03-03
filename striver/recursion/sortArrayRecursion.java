// sort an array using recursion
public class SortAnArray {
	private static List<Integer> sort(List<Integer> list) {
		if(list.size() == 1) return l;
		
		// hypothesis
		// pop and store last value of list
		// call sort() on decreased input
		Integer temp = list.get(list.size() - 1);
		list.remove(list.size() - 1);
		list = sort(list);
		
		// induction
		// call insert() for putting popped value into correct pos
		insert(list, temp);
		
		return list;
	}

	private static List<Integer> insert(List<Integer> l, int elem) {
		// if inserted elem is largest just insert it in the end
		if(list.size() == 0 || elem >= list.get(list.size() - 1)) {
			l.add(elem);
			return list;
		}
		
		// hypothesis
		// pop last val and store it, call insert on new input
		int val = list.get(list.size() - 1);
		list.remove(list.size() - 1);
		list = insert(list, elem);
		
		// induction
		// add popped value back
		list.add(val);
		return list;
	}
  
	// driver
  public static void main(String[] args) {
		List<Integer> l = new ArrayList();
		l.add(1);
		l.add(0);
		l.add(5);
		l.add(2);
		l = sort(l);
		for(int i : l)
			System.out.println(i);
	}
}
