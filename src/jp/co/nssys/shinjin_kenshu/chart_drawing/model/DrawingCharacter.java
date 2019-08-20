package jp.co.nssys.shinjin_kenshu.chart_drawing.model;

/**
 * 描画文字。
 */
public class DrawingCharacter extends ChartDataRecord {

	/** 描画文字。 */
	private String character;

	/**
	 * コンストラクタ。
	 *
	 * @param character 描画文字。
	 */
	public DrawingCharacter(String character) {
		this.character = character;
	}

	/**
	 * 描画文字を取得します。
	 *
	 * @return 描画文字。
	 */
	public String getCharacter() {
		return this.character;
	}
}
