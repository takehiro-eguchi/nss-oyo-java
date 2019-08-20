package jp.co.nssys.shinjin2019.tsubasa.arai.jr011.read;

import jp.co.nssys.shinjin2019.tsubasa.arai.jr011.model.DrawingCharacter;
import jp.co.nssys.shinjin2019.tsubasa.arai.jr011.model.Feature;
import jp.co.nssys.shinjin2019.tsubasa.arai.jr011.model.Geometry;

public class FeatureRecordReader extends ChartDataRecordReaderBase<Feature> {
	private static FeatureRecordReader theInstance;

	private FeatureRecordReader() {
	}

	public static FeatureRecordReader getInstance() {
		if (theInstance == null) {
			theInstance = new FeatureRecordReader();
		}
		return theInstance;
	}

	@Override
	public Feature 読み込み(String[] レコードのデータ配列, ChartDataRecordStore 読み込み済みレコード保管庫) {
		String 地物名 = レコードのデータ配列[2];
		int 描画優先度 = Integer.valueOf(レコードのデータ配列[5]);
		Geometry geometry = 読み込み済みレコード保管庫.形状を取得(Integer.valueOf(レコードのデータ配列[3]));
		DrawingCharacter drawingCharacter = 読み込み済みレコード保管庫.描画文字を取得(Integer.valueOf(レコードのデータ配列[4]));

		Feature feature = new Feature(地物名, 描画優先度, geometry, drawingCharacter);
		return feature;
	}

}
