package jp.co.nssys.shinjin2019.tsubasa.arai.jr011.read;

import jp.co.nssys.shinjin2019.tsubasa.arai.jr011.model.Line;
import jp.co.nssys.shinjin2019.tsubasa.arai.jr011.model.Surface;

public final class SurfaceRecordReader extends GeometryRecordReader<Surface> {
	private static SurfaceRecordReader theInstance;
	private SurfaceRecordReader() {}
	public static SurfaceRecordReader getInstance() {
		if(theInstance == null) {
			theInstance = new SurfaceRecordReader();
		}
		return theInstance;
	}
	@Override
	public Surface 読み込み(String[] レコードのデータ配列, ChartDataRecordStore 読み込み済みレコード保管庫) {
		Line[] lines = new Line[レコードのデータ配列.length - 2];
		for (int i = 0; i < レコードのデータ配列.length - 2; i++) {
			Line line = 読み込み済みレコード保管庫.線を取得(Integer.valueOf(レコードのデータ配列[i + 2]));
			lines[i] = line;
		}
		Surface surface = new Surface(lines);
		return surface;
	}

}
