package jp.co.nssys.shinjin_kenshu.chart_drawing.draw;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import jp.co.nssys.shinjin_kenshu.chart_drawing.ChartDataController;
import jp.co.nssys.shinjin_kenshu.chart_drawing.model.Feature;
import jp.co.nssys.shinjin_kenshu.chart_drawing.model.Point;

/**
 * 海図データを描画するオブジェクト。
 */
public class ChartDataDrawer implements IChartDataDrawer {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void draw(double minX, double minY, double maxX, double maxY, List<Feature> features) {
		// 海図全体のマスを作成
		ChartCell[][] chartCells = this.createChartCells(minX, minY, maxX, maxY);

		// 描画優先度が小さい順に地物を並べる
		List<Feature> orderedFeatures = features.stream()
				.sorted(Comparator.comparing(Feature::getDrawingPriority))
				.collect(Collectors.toList());

		// 各地物の形状が通るマスに描画文字を設定
		for (Feature feature : orderedFeatures) {
			for (Point point : feature.getGeometry().getAllPoints()) {
				int xIndexInChartCells = (point.getXForCalc() - chartCells[0][0].getXForCalc()) / ChartDataController.CHART_CELL_EDGE_LENGTH_DEGREE_FOR_CALC;
				int yIndexinChartCells = (chartCells[0][0].getYForCalc() - point.getYForCalc()) / ChartDataController.CHART_CELL_EDGE_LENGTH_DEGREE_FOR_CALC;
				chartCells[yIndexinChartCells][xIndexInChartCells].setDrawingCharacter(feature.getDrawingCharacter().getCharacter());
			}
		}

		// 海図全体のマスを表示
		this.printChartCells(chartCells);
	}

	/**
	 * 海図全体のマスを作成します。
	 *
	 * @param minX 最小x座標。
	 * @param minY 最小y座標。
	 * @param maxX 最大x座標。
	 * @param maxY 最大y座標。
	 * @return 海図全体のマス。
	 */
	private ChartCell[][] createChartCells(double minX, double minY, double maxX, double maxY) {
		// マスの縦・横の長さを計算し、マスの2次元配列を作成
		int minXForCalc = (int)Math.round(minX * ChartDataController.FACTOR_FOR_COORDINATE_CALC);
		int minYForCalc = (int)Math.round(minY * ChartDataController.FACTOR_FOR_COORDINATE_CALC);
		int maxXForCalc = (int)Math.round(maxX * ChartDataController.FACTOR_FOR_COORDINATE_CALC);
		int maxYForCalc = (int)Math.round(maxY * ChartDataController.FACTOR_FOR_COORDINATE_CALC);
		int chartCellsWidth = (maxXForCalc - minXForCalc) / ChartDataController.CHART_CELL_EDGE_LENGTH_DEGREE_FOR_CALC + 1;
		int chartCellsHeight = (maxYForCalc - minYForCalc) / ChartDataController.CHART_CELL_EDGE_LENGTH_DEGREE_FOR_CALC + 1;
		ChartCell[][] chartCells = new ChartCell[chartCellsWidth][chartCellsHeight];

		// 1マス1マスに座標を設定
		int xForCalc = minXForCalc;
		int yForCalc = maxYForCalc;
		for (int yIndex = 0; yIndex < chartCells.length; yIndex++) {
			ChartCell[] cellsByY = chartCells[yIndex];
			for (int xIndex = 0; xIndex < cellsByY.length; xIndex++) {
				cellsByY[xIndex] = new ChartCell(
						(double)xForCalc / ChartDataController.FACTOR_FOR_COORDINATE_CALC,
						(double)yForCalc / ChartDataController.FACTOR_FOR_COORDINATE_CALC);

				xForCalc += ChartDataController.CHART_CELL_EDGE_LENGTH_DEGREE_FOR_CALC;
			}

			yForCalc -= ChartDataController.CHART_CELL_EDGE_LENGTH_DEGREE_FOR_CALC;
		}

		return chartCells;
	}

	/**
	 * 海図全体のマスを表示します。
	 *
	 * @param chartCells 海図全体のマス。
	 */
	private void printChartCells(ChartCell[][] chartCells) {
		// 海図上部のボーダー
		System.out.print(" ");
		for (int i = 0; i < chartCells[0].length; i++) {
			System.out.print("＿");
		}

		System.out.println();

		// 海図（左右のボーダー含む）
		for (ChartCell[] cellsOfY : chartCells) {
			System.out.print("|");

			for (ChartCell cell : cellsOfY) {
				System.out.print(cell.getDrawingCharacter());
			}

			System.out.println("|");
		}

		// 海図下部のボーダー
		System.out.print(" ");
		for (int i = 0; i < chartCells[0].length; i++) {
			System.out.print("￣");
		}

		System.out.println();
	}
}
