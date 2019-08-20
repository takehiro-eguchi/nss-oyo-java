package jp.co.nssys.shinjin2019.tsubasa.arai.jr011.draw;

import java.io.IOException;

import jp.co.nssys.shinjin2019.tsubasa.arai.jr011.read.ChartDataReadResult;

public interface IChartDataDrawer {

	public abstract void 海図データを描画(ChartDataReadResult chartDataReadResult) throws IOException;

}
