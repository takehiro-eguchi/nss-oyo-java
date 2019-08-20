package jp.co.nssys.shinjin_kenshu.chart_drawing.read;

import jp.co.nssys.shinjin_kenshu.chart_drawing.model.Point;

/**
 * 点レコードを読み込むオブジェクト。
 */
public class PointRecordReader extends GeometryRecordReader<Point> {

	/** レコードにおけるx座標のデータのインデックス。 */
	private static final int X_INDEX_IN_RECORD = 2;

	/** レコードにおけるy座標のデータのインデックス。 */
	private static final int Y_INDEX_IN_RECORD = 3;

	/**
	 * コンストラクタ。
	 */
	protected PointRecordReader() {
		super(4);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @return 点（データが不正の場合はnull）。
	 * @throws NumberFormatException
	 */
	@Override
	public Point read(String[] recordDataArray, ChartDataRecordStore recordStore) {
		if (recordDataArray.length < this.minRecordDataCount) {
			return null;
		}

		return new Point(
				Double.parseDouble(recordDataArray[X_INDEX_IN_RECORD]),
				Double.parseDouble(recordDataArray[Y_INDEX_IN_RECORD]));
	}
}
