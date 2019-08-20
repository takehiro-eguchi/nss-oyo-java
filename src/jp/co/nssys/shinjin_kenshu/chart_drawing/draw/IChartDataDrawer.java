package jp.co.nssys.shinjin_kenshu.chart_drawing.draw;

import java.util.List;

import jp.co.nssys.shinjin_kenshu.chart_drawing.model.Feature;

/**
 * 海図データを描画するインターフェース。
 */
public interface IChartDataDrawer {

	/**
	 * 海図データを描画します。
	 *
	 * @param minX 海図データの最小x座標。
	 * @param minY 海図データの最小y座標。
	 * @param maxX 海図データの最大x座標。
	 * @param maxY 海図データの最大y座標。
	 * @param features 地物のリスト。
	 */
	void draw(double minX, double minY, double maxX, double maxY, List<Feature> features);
}
