package jp.co.nssys.shinjin_kenshu.chart_drawing.read;

import jp.co.nssys.shinjin_kenshu.chart_drawing.model.ChartDataRecord;

/**
 * 海図データレコードを読み込む基底オブジェクト。
 *
 * @param <T> レコードのモデル。
 */
public abstract class ChartDataRecordReaderBase<T extends ChartDataRecord> {

	/** レコードのデータ数の最小値。 */
	protected int minRecordDataCount;

	/**
	 * コンストラクタ。
	 *
	 * @param minRecordDataCount レコードのデータ数の最小値。
	 */
	protected ChartDataRecordReaderBase(int minRecordDataCount) {
		this.minRecordDataCount = minRecordDataCount;
	}

	/**
	 * レコードを読み込みます。
	 *
	 * @param recordDataArray レコードのデータ配列。
	 * @param recordStore 読み込み済みのレコードを蓄えておくオブジェクト。
	 * @return レコードのモデル（データが不正の場合はnull）。
	 */
	public abstract T read(String[] recordDataArray, ChartDataRecordStore recordStore);
}
