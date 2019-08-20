package jp.co.nssys.shinjin_kenshu.chart_drawing;

import jp.co.nssys.shinjin_kenshu.chart_drawing.draw.IChartDataDrawer;
import jp.co.nssys.shinjin_kenshu.chart_drawing.read.ChartDataReadResult;
import jp.co.nssys.shinjin_kenshu.chart_drawing.read.IChartDataReader;

/**
 * 海図データを管理するオブジェクト。
 */
public class ChartDataController {

	/** 座標値を整数で計算するために乗ずる数値。 */
	public static final int FACTOR_FOR_COORDINATE_CALC = 10;

	/** 海図のマスの辺の長さ（度）。 */
	public static final double CHART_CELL_EDGE_LENGTH_DEGREE = 0.1;

	/** 海図のマスの辺の長さ（度）（計算用）。 */
	public static final int CHART_CELL_EDGE_LENGTH_DEGREE_FOR_CALC = (int)(CHART_CELL_EDGE_LENGTH_DEGREE * FACTOR_FOR_COORDINATE_CALC);

	/** 海図データを読み込むオブジェクト。 */
	private IChartDataReader reader;

	/** 海図データを描画するオブジェクト。 */
	private IChartDataDrawer drawer;

	/**
	 * コンストラクタ。
	 *
	 * @param reader 海図データを読み込むオブジェクト。
	 * @param drawer 海図データを描画するオブジェクト。
	 */
	public ChartDataController(IChartDataReader reader, IChartDataDrawer drawer) {
		this.reader = reader;
		this.drawer = drawer;
	}

	/**
	 * 海図を描画します。
	 */
	public void drawChart() {
		// 読み込み
		ChartDataReadResult readResult = this.reader.read();
		if (!readResult.getIsSuccess()) {
			System.out.println("海図データファイルの読み込みに失敗しました。");
			return;
		}

		// 描画
		this.drawer.draw(
				readResult.getMinX(),
				readResult.getMinY(),
				readResult.getMaxX(),
				readResult.getMaxY(),
				readResult.getFeatures());
	}
}
