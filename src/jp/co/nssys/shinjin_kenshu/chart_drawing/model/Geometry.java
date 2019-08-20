package jp.co.nssys.shinjin_kenshu.chart_drawing.model;

import java.util.List;

/**
 * 形状。
 */
public abstract class Geometry extends ChartDataRecord {

	/** 形状が含む全ての点のリスト。 */
	protected List<Point> allPoints;

	/**
	 * 形状が含む全ての点のリストを取得します。
	 *
	 * @return 点のリスト。
	 */
	public abstract List<Point> getAllPoints();
}
