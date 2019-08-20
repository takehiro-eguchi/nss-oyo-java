package jp.co.nssys.shinjin_kenshu.chart_drawing.read;

import jp.co.nssys.shinjin_kenshu.chart_drawing.model.DrawingCharacter;

/**
 * 描画文字レコードを読み込むオブジェクト。
 */
public class DrawingCharacterRecordReader extends ChartDataRecordReaderBase<DrawingCharacter> {

	/** レコードにおける描画文字のデータのインデックス。 */
	private static final int DRAWING_CHARACTER_INDEX_IN_RECORD = 2;

	/**
	 * コンストラクタ。
	 */
	public DrawingCharacterRecordReader() {
		super(3);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param 描画文字レコード。
	 * @return 描画文字（データが不正の場合はnull）。
	 */
	@Override
	public DrawingCharacter read(String[] recordDataArray, ChartDataRecordStore recordStore) {
		if (recordDataArray.length < this.minRecordDataCount
				|| recordDataArray[DRAWING_CHARACTER_INDEX_IN_RECORD].length() != 1) {
			return null;
		}

		return new DrawingCharacter(recordDataArray[DRAWING_CHARACTER_INDEX_IN_RECORD]);
	}
}
