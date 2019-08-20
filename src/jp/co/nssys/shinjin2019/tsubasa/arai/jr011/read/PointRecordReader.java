package jp.co.nssys.shinjin2019.tsubasa.arai.jr011.read;

import jp.co.nssys.shinjin2019.tsubasa.arai.jr011.model.Point;

public class PointRecordReader extends GeometryRecordReader<Point> {
	private static PointRecordReader theInstance;

	private PointRecordReader() {
	}

	public static PointRecordReader getInstance() {
		if (theInstance == null) {
			theInstance = new PointRecordReader();
		}
		return theInstance;
	}

	@Override
	public Point 読み込み(String[] レコードのデータ配列, ChartDataRecordStore 読み込み済みレコード保管庫) {
		Point point = new Point(Double.parseDouble(レコードのデータ配列[2]),
				Double.parseDouble(レコードのデータ配列[3]),
				(int) Double.parseDouble(レコードのデータ配列[2]) * 10,
				(int) Double.parseDouble(レコードのデータ配列[3]) * 10);
		return point;
	}

}
