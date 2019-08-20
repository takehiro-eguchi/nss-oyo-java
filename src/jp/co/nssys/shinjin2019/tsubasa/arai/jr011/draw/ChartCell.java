package jp.co.nssys.shinjin2019.tsubasa.arai.jr011.draw;

import lombok.Getter;

public class ChartCell implements Comparable<ChartCell> {
	@Getter
	private double x座標;
	@Getter
	private double y座標;
	@Getter
	private int x座標計算用;
	@Getter
	private int y座標計算用;
	@Getter
	private String 描画文字;

	public ChartCell(jp.co.nssys.shinjin2019.tsubasa.arai.jr011.model.Point point) {
		this.x座標 = point.getX座標();
		this.y座標 = point.getY座標();
		this.x座標計算用 = point.getX座標計算用();
		this.y座標計算用 = point.getY座標計算用();
	}

	public void 描画文字を設定(String 描画文字) {
		this.描画文字 = 描画文字;
	}

	@Override
	public int compareTo(ChartCell o) {
		if (this.y座標 < o.y座標) {
			return 1;
		} else if (this.y座標 > o.y座標) {
			return -1;
		} else {
			if (this.x座標 > o.x座標) {
				return 1;
			} else if (this.x座標 < o.x座標) {
				return -1;
			}
		}
		return 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x座標);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y座標);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChartCell other = (ChartCell) obj;
		if (Double.doubleToLongBits(x座標) != Double.doubleToLongBits(other.x座標))
			return false;
		if (Double.doubleToLongBits(y座標) != Double.doubleToLongBits(other.y座標))
			return false;
		return true;
	}

}
