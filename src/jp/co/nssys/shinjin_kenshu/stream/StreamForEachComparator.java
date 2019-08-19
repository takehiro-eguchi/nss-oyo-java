package jp.co.nssys.shinjin_kenshu.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Streamとfor文の比較を行います。
 * @author t-eguchi
 */
public class StreamForEachComparator {

	/** 繰り返し回数 */
	private static final long EPOCH = 10000L;

	public static void main(String[] args) {
		// リストを作成
		List<Integer> list = createList(100000);

		// 繰り返し実行
		System.out.println(EPOCH + "回の繰り返し実行を行います");
		long start = System.nanoTime();
		for (int i = 0; i < EPOCH; i++) {
//			executeByForEach(list);
			executeByStream(list);
		}
		long end = System.nanoTime();
		System.out.println("経過秒数:" + (end - start) + " nano秒");
	}

	private static List<Integer> executeByForEach(List<Integer> list) {
		List<Integer> ret = new ArrayList<Integer>();
		for (int i = 0; i < list.size(); i++) {
			Integer value = list.get(i);
			if (value % 2 == 0) {
				ret.add(value);
			}
		}
		return ret;
	}

	private static List<Integer> executeByStream(List<Integer> list) {
		return list.stream()
				.filter(value -> value % 2 == 0 )
				.collect(Collectors.toList());
	}

	private static List<Integer> createList(int range) {
		List<Integer> ret = new ArrayList<Integer>();
		for (int i = 0; i < range; i++) {
			ret.add(i);
		}
		return ret;
	}
}
