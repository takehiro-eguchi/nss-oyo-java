package jp.co.nssys.shinjin2019.tsubasa.arai.jr011.model;

import lombok.Getter;

/**
 * 地物
 * @author tsubasa.arai
 *
 */
public class Feature extends ChartDataRecord {
	/**
	 * 地物名
	 */
	@Getter
	private String 地物名;
	/**
	 * 描画優先度
	 */
	@Getter
	private int 描画優先度;
	/**
	 * ジオメトリー
	 */
	@Getter
	private Geometry geometry;
	/**
	 * 描画文字
	 */
	@Getter
	private DrawingCharacter drawingCharacter;

	/**
	 * コンストラクタ
	 * @param 地物名
	 * @param 描画優先度
	 * @param geometry
	 * @param drawingCharacter
	 */
	public Feature(String 地物名, int 描画優先度, Geometry geometry, DrawingCharacter drawingCharacter) {
		this.地物名 = 地物名;
		this.描画優先度 = 描画優先度;
		this.geometry = geometry;
		this.drawingCharacter = drawingCharacter;
	}

}
