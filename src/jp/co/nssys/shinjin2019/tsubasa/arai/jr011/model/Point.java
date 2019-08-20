package jp.co.nssys.shinjin2019.tsubasa.arai.jr011.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

/**
 * 点クラス
 * @author tsubasa.arai
 *
 */
public class Point extends Geometry {
	/**
	 * x座標
	 */
	@Getter
	private double x座標;
	/**
	 * y座標
	 */
	@Getter
	private double y座標;
	/**
	 * x座標計算用
	 */
	@Getter
	private int x座標計算用;
	/**
	 * y座標計算用
	 */
	@Getter
	private int y座標計算用;

	/**
	 * コンストラクタ
	 * @param parseDouble
	 * @param parseDouble2
	 * @param i
	 * @param j
	 */
	public Point(double parseDouble, double parseDouble2, int i, int j) {
		this.x座標 = parseDouble;
		this.y座標 = parseDouble2;
		this.x座標計算用 = i;
		this.y座標計算用 = j;
	}

	/**
	 * 形状が含む全ての点を取得
	 */
	@Override
	public List<Point> 形状が含む全ての点を取得() {
		List<Point> pointList = new ArrayList<>();
		pointList.add(this);
		return pointList;
	}

	/**
	 * ハッシュコードのオーバーライド
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x座標);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y座標);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	/**
	 * イコールズのオーバーライド
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (Double.doubleToLongBits(x座標) != Double.doubleToLongBits(other.x座標))
			return false;
		if (Double.doubleToLongBits(y座標) != Double.doubleToLongBits(other.y座標))
			return false;
		return true;
	}
}
