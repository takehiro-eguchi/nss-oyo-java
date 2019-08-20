package jp.co.nssys.shinjin2019.tsubasa.arai.jr011.read;

import jp.co.nssys.shinjin2019.tsubasa.arai.jr011.model.ChartDataRecord;

public abstract class ChartDataRecordReaderBase<T extends ChartDataRecord> {
	public abstract T 読み込み(String[] レコードのデータ配列, ChartDataRecordStore 読み込み済みレコード保管庫);
}
