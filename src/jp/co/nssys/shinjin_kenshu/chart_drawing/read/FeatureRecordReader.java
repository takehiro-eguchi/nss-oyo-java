package jp.co.nssys.shinjin_kenshu.chart_drawing.read;

import jp.co.nssys.shinjin_kenshu.chart_drawing.model.DrawingCharacter;
import jp.co.nssys.shinjin_kenshu.chart_drawing.model.Feature;
import jp.co.nssys.shinjin_kenshu.chart_drawing.model.Geometry;

/**
 * 地物レコードを読み込むオブジェクト。
 */
public class FeatureRecordReader extends ChartDataRecordReaderBase<Feature> {

	/** レコードにおける地物名のデータのインデックス。 */
	private static final int NAME_INDEX_IN_RECORD = 2;

	/** レコードにおける形状IDのデータのインデックス。 */
	private static final int GEOMETRY_ID_INDEX_IN_RECORD = 3;

	/** レコードにおける描画文字IDのデータのインデックス。 */
	private static final int DRAWING_CHARACTER_ID_INDEX_IN_RECORD = 4;

	/** レコードにおける描画優先度のデータのインデックス。 */
	private static final int DRAWING_PRIORITY_INDEX_IN_RECORD = 5;

	/**
	 * コンストラクタ。
	 */
	protected FeatureRecordReader() {
		super(6);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @return 地物（データが不正の場合はnull）。
	 * @throws NumberFormatException
	 */
	@Override
	public Feature read(String[] recordDataArray, ChartDataRecordStore recordStore) {
		if (recordDataArray.length < this.minRecordDataCount) {
			return null;
		}

		Geometry geometry = recordStore.getGeometry(Integer.parseInt(recordDataArray[GEOMETRY_ID_INDEX_IN_RECORD]));
		DrawingCharacter drawingCharacter = recordStore.getDrawingCharacter(Integer.parseInt(recordDataArray[DRAWING_CHARACTER_ID_INDEX_IN_RECORD]));
		if (geometry == null || drawingCharacter == null) {
			return null;
		}

		return new Feature(
				recordDataArray[NAME_INDEX_IN_RECORD],
				geometry,
				drawingCharacter,
				Integer.parseInt(recordDataArray[DRAWING_PRIORITY_INDEX_IN_RECORD]));
	}
}
