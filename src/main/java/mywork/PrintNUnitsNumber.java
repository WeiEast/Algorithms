package mywork;

import java.util.ArrayList;
import java.util.Iterator;

public class PrintNUnitsNumber {

	public static void main(String[] args) {
		PrintNUnitsNumber printNunitsNumber = new PrintNUnitsNumber();
		printNunitsNumber.maxNUnits(3);
	}

	public void maxNUnits(int n) {
		ArrayList<Integer> numberList = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			numberList.add(0);
		}
		calculate(numberList);
	}

	public void calculate(ArrayList<Integer> numberList) {
		int bit = 0;
		boolean end = false;
		// No.1
		// 开始写代码，输出1~n位数
		while (!end) {
			for (int i = numberList.size() - 1; i >= 0; i--) {
				int tmp = numberList.get(i);
				int sum = tmp + bit;
				if (i == (numberList.size() - 1)) {
					sum++;
				}
				if (sum >= 10) {
					if (i == 0) {
						end = true;
					}
					bit = 1;
					sum -= 10;
				} else {
					bit = 0;
				}

				numberList.set(i, sum);
			}
			print(numberList);
		}
		// end_code
	}

	public void print(ArrayList<Integer> numberList) {
		Iterator<Integer> iterator = numberList.iterator();
		int number;
		boolean first = false;
		while (iterator.hasNext()) {
			if (first) {
				System.out.print(iterator.next());
				continue;
			}
			if ((number = iterator.next()) != 0) {
				first = true;
				System.out.print(number);
			}
		}
		System.out.println();
	}
}
