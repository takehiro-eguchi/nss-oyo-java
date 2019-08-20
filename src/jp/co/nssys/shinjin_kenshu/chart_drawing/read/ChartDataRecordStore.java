package jp.co.nssys.shinjin_kenshu.chart_drawing.read;

import java.util.HashMap;
import java.util.Map;

import jp.co.nssys.shinjin_kenshu.chart_drawing.model.ChartDataRecord;
import jp.co.nssys.shinjin_kenshu.chart_drawing.model.DrawingCharacter;
import jp.co.nssys.shinjin_kenshu.chart_drawing.model.Geometry;
import jp.co.nssys.shinjin_kenshu.chart_drawing.model.Line;
import jp.co.nssys.shinjin_kenshu.chart_drawing.model.Point;

/**
 * 読み込み済みの海図データのレコードを蓄えておくオブジェクト。
 * 地物レコードは他レコードから参照されないため蓄えません。
 */
public class ChartDataRecordStore {

	/** 形状の一覧。 */
	private Map<Integer, Geometry> geometries;

	/** 描画文字の一覧。 */
	private Map<Integer, DrawingCharacter> drawingCharacters;

	/**
	 * コンストラクタ。
	 */
	public ChartDataRecordStore() {
		this.geometries = new HashMap<Integer, Geometry>();
		this.drawingCharacters = new HashMap<Integer, DrawingCharacter>();
	}

	/**
	 * 指定IDの点を取得します。
	 *
	 * @param id ID。
	 * @return 点。
	 */
	public Point getPoint(int id) {
		Geometry geometry = this.geometries.get(id);

		return geometry != null && geometry instanceof Point ? (Point)geometry : null;
	}

	/**
	 * 指定IDの線を取得します。
	 *
	 * @param id ID。
	 * @return 線。
	 */
	public Line getLine(int id) {
		Geometry geometry = this.geometries.get(id);

		return geometry != null && geometry instanceof Line ? (Line)geometry : null;
	}

	/**
	 * 指定IDの形状を取得します。
	 *
	 * @param id ID。
	 * @return 形状。
	 */
	public Geometry getGeometry(int id) {
		return this.geometries.get(id);
	}

	/**
	 * 指定IDの描画文字を取得します。
	 *
	 * @param id ID。
	 * @return 描画文字。
	 */
	public DrawingCharacter getDrawingCharacter(int id) {
		return this.drawingCharacters.get(id);
	}

	/**
	 * レコードを追加します（地物レコードは無視します）。
	 *
	 * @param id ID。
	 * @param record レコード。
	 * @return 追加に成功したかどうか。
	 */
	public boolean addRecord(int id, ChartDataRecord record) {
		if (record instanceof Geometry) {
			if (this.geometries.containsKey(id)) {
				return false;
			}

			this.geometries.put(id, (Geometry)record);
		} else if (record instanceof DrawingCharacter) {
			if (this.drawingCharacters.containsKey(id)) {
				return false;
			}

			this.drawingCharacters.put(id, (DrawingCharacter)record);
		}

		return true;
	}
}
