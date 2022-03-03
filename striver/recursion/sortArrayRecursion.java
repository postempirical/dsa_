// sort an array using recursion
public class SortAnArray {
	private static List<Integer> sort(List<Integer> list) {
		if(list.size() == 1) return l;
		
		//hypothesis
		Integer temp = list.get(list.size() - 1);
		list.remove(list.size() - 1);
		list = sort(list);
		
		//induction
		insert(list, temp);
		
		return list;
	}

	private static List<Integer> insert(List<Integer> l, int elem) {
		if(list.size() == 0 || elem >= list.get(list.size() - 1))
		{
			l.add(elem);
			return list;
		}
		//hypothesis
		int val = list.get(list.size() - 1);
		list.remove(list.size() - 1);
		list = insert(list, elem);
		//induction
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
