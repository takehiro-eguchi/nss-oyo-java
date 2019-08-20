package jp.co.nssys.shinjin_kenshu.chart_drawing.model;

import java.util.ArrayList;
import java.util.List;

import jp.co.nssys.shinjin_kenshu.chart_drawing.ChartDataController;

/**
 * 線。
 */
public class Line extends Geometry {

	/** 点のリスト。 */
	private List<Point> points;

	/**
	 * コンストラクタ。
	 *
	 * @param points 点のリスト。
	 */
	public Line(List<Point> points) {
		this.points = points;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Point> getAllPoints() {
		if (this.allPoints != null) {
			return this.allPoints;
		}

		List<Point> allPoints = new ArrayList<Point>();

		Point prevPoint = null;
		for (Point point : this.points) {
			if (prevPoint != null) {
				// prevPointからpointまで（prevPoint、pointは含まない）の点を追加

				// pointが、prevPointからx・yどちらの方向にどれだけ移動した点かを計算
				boolean isDifferentX = point.getXForCalc() != prevPoint.getXForCalc();
				int coordinateDifferenceForCalc = isDifferentX
						? point.getXForCalc() - prevPoint.getXForCalc()
						: point.getYForCalc() - prevPoint.getYForCalc();
				int incrementValueForCalc = coordinateDifferenceForCalc > 0
						? ChartDataController.CHART_CELL_EDGE_LENGTH_DEGREE_FOR_CALC
						: (ChartDataController.CHART_CELL_EDGE_LENGTH_DEGREE_FOR_CALC * -1);
				if (isDifferentX) {
					// x方向に移動した点
					for (int xForCalc = prevPoint.getXForCalc() + incrementValueForCalc; xForCalc != point.getXForCalc(); xForCalc += incrementValueForCalc) {
						allPoints.add(new Point((double)xForCalc / ChartDataController.FACTOR_FOR_COORDINATE_CALC, point.getY()));
					}
				} else {
					// y方向に移動した点
					for (int yForCalc = prevPoint.getYForCalc() + incrementValueForCalc; yForCalc != point.getYForCalc(); yForCalc += incrementValueForCalc) {
						allPoints.add(new Point(point.getX(), (double)yForCalc / ChartDataController.FACTOR_FOR_COORDINATE_CALC));
					}
				}
			}

			allPoints.add(point);
			prevPoint = point;
		}

		return this.allPoints = allPoints;
	}
}
