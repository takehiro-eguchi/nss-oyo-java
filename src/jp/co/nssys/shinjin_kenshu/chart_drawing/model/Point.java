package jp.co.nssys.shinjin_kenshu.chart_drawing.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jp.co.nssys.shinjin_kenshu.chart_drawing.ChartDataController;

/**
 * 点。
 */
public class Point extends Geometry {

	/** x座標。 */
	private double x;

	/** y座標。 */
	private double y;

	/** x座標（計算用）。 */
	private int xForCalc;

	/** y座標（計算用）。 */
	private int yForCalc;

	/**
	 * コンストラクタ。
	 *
	 * @param x x座標。
	 * @param y y座標。
	 */
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
		this.xForCalc = (int)Math.round(this.x * ChartDataController.FACTOR_FOR_COORDINATE_CALC);
		this.yForCalc = (int)Math.round(this.y * ChartDataController.FACTOR_FOR_COORDINATE_CALC);
	}

	/**
	 * x座標を取得します。
	 *
	 * @return x座標。
	 */
	public double getX() {
		return this.x;
	}

	/**
	 * y座標を取得します。
	 *
	 * @return y座標。
	 */
	public double getY() {
		return this.y;
	}

	/**
	 * x座標（計算用）を取得します。
	 *
	 * @return x座標（計算用）。
	 */
	public int getXForCalc() {
		return this.xForCalc;
	}

	/**
	 * y座標（計算用）を取得します。
	 *
	 * @return y座標（計算用）。
	 */
	public int getYForCalc() {
		return this.yForCalc;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Point> getAllPoints() {
		if (this.allPoints != null) {
			return this.allPoints;
		}

		return this.allPoints = new ArrayList<Point>(Arrays.asList(this));
	}
}
