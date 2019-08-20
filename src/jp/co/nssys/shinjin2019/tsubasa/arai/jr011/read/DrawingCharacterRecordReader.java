package jp.co.nssys.shinjin2019.tsubasa.arai.jr011.read;

import jp.co.nssys.shinjin2019.tsubasa.arai.jr011.model.DrawingCharacter;

public class DrawingCharacterRecordReader extends ChartDataRecordReaderBase<DrawingCharacter> {
	private static DrawingCharacterRecordReader theInstance;

	private DrawingCharacterRecordReader() {
	}

	public static DrawingCharacterRecordReader getInstance() {
		if (theInstance == null) {
			theInstance = new DrawingCharacterRecordReader();
		}
		return theInstance;
	}

	@Override
	public DrawingCharacter 読み込み(String[] レコードのデータ配列, ChartDataRecordStore 読み込み済みレコード保管庫) {
		DrawingCharacter drawingCharacter = new DrawingCharacter(レコードのデータ配列[2]);
		return drawingCharacter;
	}

}
