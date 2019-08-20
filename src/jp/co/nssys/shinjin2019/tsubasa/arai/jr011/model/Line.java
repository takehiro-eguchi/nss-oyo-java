package jp.co.nssys.shinjin2019.tsubasa.arai.jr011.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import lombok.Getter;

/**
 * 線クラス
 * @author tsubasa.arai
 *
 */
public class Line extends Geometry {
	/**
	 * 点の配列
	 */
	@Getter
	private Point[] point;

	/**
	 * コンストラクタ
	 * @param points
	 */
	public Line(Point[] points) {
		this.point = points;
	}

	/**
	 * 形状が含む全ての点を取得
	 */
	@Override
	public List<Point> 形状が含む全ての点を取得() {
		//pointの配列をListに変換
		List<Point> pointList = Arrays.asList(point);
		//同じ点が被らないようにSet
		Set<Point> pointSetResult = new LinkedHashSet<Point>();
		//座標が異なる軸に存在する最小値
		double min;
		//座標が異なる軸に存在する最大値
		double max;

		Set<Point> pointSetCalc = new LinkedHashSet<>();
		//2点間の点の穴埋め

		for (int i = 0; i < point.length-1; i++) {
			if (point[i].getX座標() == point[i+1].getX座標()) {
				for (Point point1 : pointList) {
					if(point[i].getX座標() == point1.getX座標()) {
						pointSetCalc.add(point1);
					}
				}
				min = pointSetCalc.stream().map((p) -> p.getY座標() * 10).min(Comparator.naturalOrder()).get();
				max = pointSetCalc.stream().map((p) -> p.getY座標() * 10).max(Comparator.naturalOrder()).get();
				for (int j = (int)(Math.round(min)); j < (int)(Math.round(max+1)); j++) {
					pointSetResult
							.add(new Point((double) point[i].getX座標(), (double) (j) / 10, point[i].getX座標計算用(),
									(int) (j)));
				}
			}
			if (point[i].getY座標() == point[i+1].getY座標()) {
				for (Point point1 : pointList) {
					if(point[i].getY座標() == point1.getY座標()) {
						pointSetCalc.add(point1);
					}
				}
				min = pointSetCalc.stream().map((p) -> p.getX座標() * 10).min(Comparator.naturalOrder()).get();
				max = pointSetCalc.stream().map((p) -> p.getX座標() * 10).max(Comparator.naturalOrder()).get();
				for (int j = (int)(Math.round(min)); j < (int) (Math.round(max+1)); j++) {
					pointSetResult
							.add(new Point((double) (j) / 10, (double) point[i].getY座標(), (int) (j),
									point[i].getX座標計算用()));
				}
			}
		}

		List<Point> pointListResult = new ArrayList<Point>();
		for (Point point : pointSetResult) {
			pointListResult.add(point);
		}
		return pointListResult;
	}

}
