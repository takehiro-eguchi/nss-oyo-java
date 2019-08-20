package jp.co.nssys.shinjin_kenshu.chart_drawing.read;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import jp.co.nssys.shinjin_kenshu.chart_drawing.model.Line;
import jp.co.nssys.shinjin_kenshu.chart_drawing.model.Surface;

/**
 * 面レコードを読み込むオブジェクト。
 */
public class SurfaceRecordReader extends GeometryRecordReader<Surface> {

	/** レコードにおいて線IDのデータが開始するインデックス。 */
	private static final int LINE_ID_START_INDEX_IN_RECORD = 2;

	/**
	 * コンストラクタ。
	 */
	protected SurfaceRecordReader() {
		super(3);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @return 面（データが不正の場合はnull）。
	 * @throws NumberFormatException
	 */
	@Override
	public Surface read(String[] recordDataArray, ChartDataRecordStore recordStore) {
		if (recordDataArray.length < this.minRecordDataCount) {
			return null;
		}

		List<Integer> lineIds = Arrays.asList(recordDataArray)
				.subList(LINE_ID_START_INDEX_IN_RECORD, recordDataArray.length)
				.stream()
				.map(e -> Integer.parseInt(e))
				.collect(Collectors.toList());
		List<Line> lines = lineIds.stream().map(e -> recordStore.getLine(e)).collect(Collectors.toList());
		if (lines.contains(null)) {
			return null;
		}

		return new Surface(lines);
	}
}
