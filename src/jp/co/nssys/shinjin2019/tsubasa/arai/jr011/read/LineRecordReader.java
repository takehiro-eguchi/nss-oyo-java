package jp.co.nssys.shinjin2019.tsubasa.arai.jr011.read;

import jp.co.nssys.shinjin2019.tsubasa.arai.jr011.model.Line;
import jp.co.nssys.shinjin2019.tsubasa.arai.jr011.model.Point;

public class LineRecordReader extends GeometryRecordReader<Line> {
	private static LineRecordReader theInstance;

	private LineRecordReader() {
	}

	public static LineRecordReader getInstance() {
		if (theInstance == null) {
			theInstance = new LineRecordReader();
		}
		return theInstance;
	}

	@Override
	public Line 読み込み(String[] レコードのデータ配列, ChartDataRecordStore 読み込み済みレコード保管庫) {
		Point[] points = new Point[レコードのデータ配列.length - 2];
		for (int i = 0; i < レコードのデータ配列.length - 2; i++) {
			Point point = 読み込み済みレコード保管庫.点を取得(Integer.valueOf(レコードのデータ配列[i + 2]));
			points[i] = point;
		}
		Line line = new Line(points);
		return line;
	}

}
