package jp.co.nssys.shinjin_kenshu.chart_drawing.model;

/**
 * 地物。
 */
public class Feature extends ChartDataRecord {

	/** 地物名。 */
	private String name;

	/** 形状。 */
	private Geometry geometry;

	/** 描画文字。 */
	private DrawingCharacter drawingCharacter;

	/** 描画優先度。 */
	private int drawingPriority;

	/**
	 * コンストラクタ。
	 *
	 * @param name 地物名。
	 * @param geometry 形状。
	 * @param drawingCharacter 描画文字。
	 * @param drawingPriority 描画優先度。
	 */
	public Feature(String name, Geometry geometry, DrawingCharacter drawingCharacter, int drawingPriority) {
		this.name = name;
		this.geometry = geometry;
		this.drawingCharacter = drawingCharacter;
		this.drawingPriority = drawingPriority;
	}

	/**
	 * 地物名を取得します。
	 *
	 * @return 地物名。
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * 形状を取得します。
	 *
	 * @return 形状。
	 */
	public Geometry getGeometry() {
		return this.geometry;
	}

	/**
	 * 描画文字を取得します。
	 *
	 * @return 描画文字。
	 */
	public DrawingCharacter getDrawingCharacter() {
		return this.drawingCharacter;
	}

	/**
	 * 描画優先度を取得します。
	 *
	 * @return 描画優先度。
	 */
	public int getDrawingPriority() {
		return this.drawingPriority;
	}
}
