package jp.co.nssys.shinjin_kenshu.chart_drawing.read;

import jp.co.nssys.shinjin_kenshu.chart_drawing.model.Geometry;

/**
 * 形状レコードを読み込むオブジェクト。
 *
 * @param <T> 形状。
 */
public abstract class GeometryRecordReader<T extends Geometry> extends ChartDataRecordReaderBase<T> {

	/**
	 * コンストラクタ。
	 *
	 * @param minRecordDataCount レコードのデータ数の最小値。
	 */
	protected GeometryRecordReader(int minRecordDataCount) {
		super(minRecordDataCount);
	}
}
