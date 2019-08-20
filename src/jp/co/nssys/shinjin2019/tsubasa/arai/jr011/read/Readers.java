package jp.co.nssys.shinjin2019.tsubasa.arai.jr011.read;

import jp.co.nssys.shinjin2019.tsubasa.arai.jr011.model.ChartDataRecord;

enum Readers {

	/**
	 * 地物リーダー
	 */
	FEATURE("10", FeatureRecordReader.getInstance()),

	/**
	 * 点リーダー
	 */
	POINT("20", PointRecordReader.getInstance()),

	/**
	 * 線リーダー
	 */
	LINE("25", LineRecordReader.getInstance()),

	/**
	 * 面リーダー
	 */
	SURFACE("30", SurfaceRecordReader.getInstance()),

	/**
	 * 描画文字リーダー
	 */
	DRAWINGCHARACTER("40", DrawingCharacterRecordReader.getInstance());

	/**
	 * 定数
	 */
	private String code;

	private ChartDataRecordReaderBase<? extends ChartDataRecord> chartDataRecordReaderBase;

	/**
	 * コンストラクタ
	 * @param num 定数
	 * @param putturn 表記
	 */
	private Readers(String code, ChartDataRecordReaderBase<? extends ChartDataRecord> chartDataRecordReaderBase) {
		this.code = code;
		this.chartDataRecordReaderBase = chartDataRecordReaderBase;
	}

	/**
	 * 定数の取得
	 * @return 定数
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 表記の取得
	 * @return 表記
	 */
	public ChartDataRecordReaderBase<? extends ChartDataRecord> getReader() {
		return chartDataRecordReaderBase;
	}

	/**
	 * 定数をStartTypeに変換
	 * @param num 変換したい定数
	 * @return 数値に対応したFileFunction型を返す。なければnullを返す。
	 */
	public static  ChartDataRecordReaderBase<? extends ChartDataRecord> getReader(String code) {
		for (Readers type : Readers.values()) {
			if (type.code.equals(code)) {
				return type.getReader();
			}
		}
		return null;
	}
}
