package jp.co.nssys.shinjin_kenshu.chart_drawing.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import jp.co.nssys.shinjin_kenshu.chart_drawing.ChartDataController;

/**
 * 面。
 */
public class Surface extends Geometry {

	/** 線のリスト。 */
	private List<Line> lines;

	/**
	 * コンストラクタ。
	 *
	 * @param lines 線のリスト。
	 */
	public Surface(List<Line> lines) {
		this.lines = lines;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Point> getAllPoints() {
		if (this.allPoints != null) {
			return this.allPoints;
		}

		// 参照する線上の全ての点のリストを取得
		List<Point> linePoints = this.lines.stream().flatMap(e -> e.getAllPoints().stream()).collect(Collectors.toList());

		// 参照する線上の点のy座標のうち、最小・最大のものを取得
		List<Integer> linePointYForCalcList = linePoints.stream().map(e -> e.getYForCalc()).collect(Collectors.toList());
		int minYForCalcInLinePoints = linePointYForCalcList.stream().min(Comparator.naturalOrder()).get();
		int maxYForCalcinLinePoints = linePointYForCalcList.stream().max(Comparator.naturalOrder()).get();

		List<Point> allPoints = new ArrayList<Point>();

		// 最小のyから最大のyまでの各y座標について、対象y座標上の点のx座標のうち、最小・最大のものを取得
		for (int yForCalc = minYForCalcInLinePoints; yForCalc <= maxYForCalcinLinePoints; yForCalc += ChartDataController.CHART_CELL_EDGE_LENGTH_DEGREE_FOR_CALC) {
			final int yForFilter = yForCalc;
			List<Integer> xForCalcListOfY = linePoints.stream().filter(e -> e.getYForCalc() == yForFilter).map(e -> e.getXForCalc()).collect(Collectors.toList());
			int minXForCalcOfY = xForCalcListOfY.stream().min(Comparator.naturalOrder()).get();
			int maxXForCalcOfY = xForCalcListOfY.stream().max(Comparator.naturalOrder()).get();
			for (int xForCalc = minXForCalcOfY; xForCalc <= maxXForCalcOfY; xForCalc += ChartDataController.CHART_CELL_EDGE_LENGTH_DEGREE_FOR_CALC) {
				allPoints.add(new Point(
						(double)xForCalc / ChartDataController.FACTOR_FOR_COORDINATE_CALC,
						(double)yForCalc / ChartDataController.FACTOR_FOR_COORDINATE_CALC));
			}
		}

		return this.allPoints = allPoints;
	}
}
