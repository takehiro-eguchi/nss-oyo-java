package jp.co.nssys.shinjin_kenshu.chart_drawing.read;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import jp.co.nssys.shinjin_kenshu.chart_drawing.model.Line;
import jp.co.nssys.shinjin_kenshu.chart_drawing.model.Point;

/**
 * 線レコードを読み込むオブジェクト。
 */
public class LineRecordReader extends GeometryRecordReader<Line> {

	/** レコードにおいて点IDのデータが開始するインデックス。 */
	private static final int POINT_ID_START_INDEX_IN_RECORD = 2;

	/**
	 * コンストラクタ。
	 */
	protected LineRecordReader() {
		super(4);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @return 線（データが不正の場合はnull）。
	 * @throws NumberFormatException
	 */
	@Override
	public Line read(String[] recordDataArray, ChartDataRecordStore recordStore) {
		if (recordDataArray.length < this.minRecordDataCount) {
			return null;
		}

		List<Integer> pointIds = Arrays.asList(recordDataArray)
				.subList(POINT_ID_START_INDEX_IN_RECORD, recordDataArray.length)
				.stream()
				.map(e -> Integer.parseInt(e))
				.collect(Collectors.toList());
		List<Point> points = pointIds.stream().map(e -> recordStore.getPoint(e)).collect(Collectors.toList());
		if (points.contains(null)) {
			return null;
		}

		return new Line(points);
	}
}
