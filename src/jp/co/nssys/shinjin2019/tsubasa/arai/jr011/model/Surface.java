package jp.co.nssys.shinjin2019.tsubasa.arai.jr011.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import lombok.Getter;

/**
 * 面クラス
 * @author tsubasa.arai
 *
 */
public class Surface extends Geometry {
	/**
	 * 線の配列
	 */
	@Getter
	private Line[] lines;

	/**
	 * コンストラクタ
	 * @param lines
	 */
	public Surface(Line[] lines) {
		this.lines = lines;
	}

	/**
	 * 面内の点を全て格納する.
	 */
	@Override
	public List<Point> 形状が含む全ての点を取得() {
		Set<Point> pointSet = new LinkedHashSet<>();
		Set<Point> pointSetY = new LinkedHashSet<>();
		Set<Point> pointSetResult = new LinkedHashSet<>();
		List<Point> pointListResult = new ArrayList<>();
		for (int i = 0; i < lines.length; i++) {
			for (Point point : lines[i].形状が含む全ての点を取得()) {
				pointSet.add(point);
			}
		}
		int minY = pointSet.stream().map((p) -> (int) (p.getY座標() * 10)).min(Comparator.naturalOrder()).get();
		int maxY = pointSet.stream().map((p) -> (int) (p.getY座標() * 10)).max(Comparator.naturalOrder()).get();
		for (int i = maxY; i >= minY; i--) {
			for (Point point : pointSet) {
				if ((int)Math.round(point.getY座標() * 10) == i) {
					pointSetY.add(point);
				}
			}
			int minX = pointSetY.stream().map((p) -> (int) (p.getX座標() * 10)).min(Comparator.naturalOrder()).get();
			int maxX = pointSetY.stream().map((p) -> (int) (p.getX座標() * 10)).max(Comparator.naturalOrder()).get();
			for (int j = minX; j <= maxX; j++) {
				pointSetResult
						.add(new Point((double) (j) / 10, (double) (i) / 10, (j), (i)));
			}
		}
		for (Point point : pointSetResult) {
			pointListResult.add(point);
		}

		return pointListResult;
	}

}
