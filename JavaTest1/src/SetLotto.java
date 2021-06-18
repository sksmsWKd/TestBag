import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetLotto {
	

	private static int num;

	public static void main(String[] args) {
		Set<Integer> lottoNums = new HashSet<>();
		while (lottoNums.size() < 6) {
			int num = ((int) (Math.random() * 45) + 1);

			if (lottoNums.add(num)) {
				System.out.print(num + ", ");

			}
		}
		System.out.println(" ");

		Iterator<Integer> iter = lottoNums.iterator();
		while (iter.hasNext()) {
			System.out.print(iter.next() + " ,");
		}
		System.out.println(" ");
		System.out.println(lottoNums);
//	for(int i = 0 ; i<46 ;i++){
//		lottoNums.add(i);
//	}
//	System.out.println(lottoNums<>[]);

	}
}
//디자인패턴class MyComparator implements Comparator<Integer>{}
   