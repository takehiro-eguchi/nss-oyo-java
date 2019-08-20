package jp.co.nssys.shinjin_kenshu.chart_drawing.read;

/**
 * 海図データを読み込むインターフェース。
 */
public interface IChartDataReader {

	/**
	 * 海図データを読み込みます。
	 *
	 * @return 海図データ読み込み結果。
	 */
	ChartDataReadResult read();
}
