package mywork;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * max f(x1,x2) = x1^2+x2^2
 * x1 {1,2,3,4,5,6,7} x2 {1,2,3,4,5,6,7}
 *
 */
public class MyGenetic {
	static List<Gene> list = new ArrayList<MyGenetic.Gene>();
	static Map<Integer, Gene> map = new HashMap<Integer, MyGenetic.Gene>();

	/**
	 * 适应度计算
	 * @param x1
	 * @param x2
	 * @return
	 */
	public static int function(int x1, int x2) {
		return x1 * x1 * x1 - x2 * x2;
	}

	/**
	 * 解码
	 * @param x
	 * @return
	 */
	public static int decode(String x) {
		int result = 0;
		for (int i = 0; i < x.length(); i++) {
			char c = x.charAt(i);
			if (c == '1') {
				result += Math.pow(2, x.length() - i - 1);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		for (int j = 0; j < 4; j++) {
			StringBuffer str = new StringBuffer();
			for (int i = 0; i < 6; i++) {
				str.append(new Random().nextInt(2));
			}
			Gene g = new Gene();
			g.setVal(str.toString());
			g.setKey(j);
			map.put(j, g);
		}
		for (int i = 0; i < 5000; i++) {
			Gene caculate = caculate();
			if (caculate.f > 100) {
				System.out.println(caculate.f);
				System.out.println(
						decode(caculate.getVal().substring(0, 3)) + "" + decode(caculate.getVal().substring(3)));
				break;
			}
			cross();
		}

	}

	private static Gene caculate() {
		Set<Integer> keySet = map.keySet();
		Iterator<Integer> iterator = keySet.iterator();
		double sum = 0;
		Gene max = new Gene();
		max.setF(0.0);
		while (iterator.hasNext()) {
			Gene g = map.get(iterator.next());
			int function = function(decode(g.getVal().substring(0, 3)), decode(g.getVal().substring(3)));
			g.setF(function);
			if (max.getF() < g.getF()) {
				max = g;
			}
			sum += function;
		}
		Iterator<Integer> iterator2 = keySet.iterator();
		while (iterator2.hasNext()) {
			int next = iterator2.next();
			Gene g = map.get(next);
			g.p = g.f / sum;
		}
		for (int i = 0; i < 4; i++) {
			// 先随机出一个小于1的数字
			int key = du();
			list.add(map.get(key));
		}
		return max;
	}

	public static int du() {
		double d = Math.random();
		Set<Integer> keySet = map.keySet();
		Iterator<Integer> iterator = keySet.iterator();
		double mid = 0;
		while (iterator.hasNext()) {
			int key = iterator.next();
			Gene g = map.get(key);
			mid += g.p;
			if (d <= mid) {
				return key;
			}

		}
		return 0;
	}

	public static void cross() {
		for (int i = 0; i < list.size() / 2; i++) {
			// 1 - 2 3- 4 5-6
			Gene g1 = list.get(i * 2);
			Gene g2 = list.get(i * 2 + 1);
			int r1 = getRanOfRange(0, g1.getVal().length());
			int r2 = getRanOfRange(0, g1.getVal().length());
			String val1 = g1.getVal();
			String val2 = g2.getVal();
			g1.setVal(val1.substring(0, r1) + val2.substring(r1, r2) + val1.substring(r2));
			g2.setVal(val2.substring(0, r1) + val1.substring(r1, r2) + val2.substring(r2));

		}
	}

	private static int getRanOfRange(int start, int end) {
		Random r = new Random();
		return r.nextInt(end - start) + start;
	}

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Gene {

		public Gene(String val) {
			super();
			this.val = val;
		}

		// 对应的map里面的key键值
		int key;
		// 对应的适应度
		double f;
		// 对应的基因编码
		String val;
		// 对应的选择概率
		double p;
	}

}
