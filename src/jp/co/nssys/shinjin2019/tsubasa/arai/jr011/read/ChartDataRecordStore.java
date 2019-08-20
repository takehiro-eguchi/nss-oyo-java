package jp.co.nssys.shinjin2019.tsubasa.arai.jr011.read;

import java.util.LinkedHashMap;
import java.util.Map;

import jp.co.nssys.shinjin2019.tsubasa.arai.jr011.model.ChartDataRecord;
import jp.co.nssys.shinjin2019.tsubasa.arai.jr011.model.DrawingCharacter;
import jp.co.nssys.shinjin2019.tsubasa.arai.jr011.model.Geometry;
import jp.co.nssys.shinjin2019.tsubasa.arai.jr011.model.Line;
import jp.co.nssys.shinjin2019.tsubasa.arai.jr011.model.Point;

public class ChartDataRecordStore {

	private Map<Integer, Geometry> 形状一覧;

	private Map<Integer, DrawingCharacter> 描画文字一覧;

	public ChartDataRecordStore() {
		形状一覧 = new LinkedHashMap<>();
		描画文字一覧 = new LinkedHashMap<>();
	}

	public Point 点を取得(int ID) {
		Point point;
		if ((point = (Point) 形状一覧.get(ID)) instanceof Point) {
			return point;
		}
		return null;
	}

	public Line 線を取得(int ID) {
		Line line;
		if ((line = (Line) 形状一覧.get(ID)) instanceof Line) {
			return line;
		}
		return null;
	}

	public Geometry 形状を取得(int ID) {
		Geometry geometry;
		if ((geometry = (Geometry) 形状一覧.get(ID)) instanceof Geometry) {
			return geometry;
		}
		return null;
	}

	public DrawingCharacter 描画文字を取得(int ID) {
		DrawingCharacter drawingCharacter;
		if ((drawingCharacter = (DrawingCharacter) 描画文字一覧.get(ID)) instanceof DrawingCharacter) {
			return drawingCharacter;
		}
		return null;
	}

	public boolean レコードを追加(Integer 形状ID, ChartDataRecord レコード) {

		if (レコード instanceof Geometry) {
//			if (形状一覧.containsKey(形状ID)) {
//				return false;
//			}
			形状一覧.put(形状ID, (Geometry) レコード);
			return true;
		}
		if (レコード instanceof DrawingCharacter) {
//			if (描画文字一覧.containsKey(形状ID)) {
//				return false;
//			}
			描画文字一覧.put(形状ID, (DrawingCharacter) レコード);
			return true;
		}
		return false;
	}

}
