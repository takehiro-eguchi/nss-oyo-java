package jp.co.nssys.shinjin2019.tsubasa.arai.jr011;

import java.io.IOException;

import jp.co.nssys.shinjin2019.tsubasa.arai.jr011.draw.IChartDataDrawer;
import jp.co.nssys.shinjin2019.tsubasa.arai.jr011.read.ChartDataReadResult;
import jp.co.nssys.shinjin2019.tsubasa.arai.jr011.read.IChartDataReader;

public class ChartDataController {

	private IChartDataReader iChartDataReader;

	private IChartDataDrawer iChartDataDrawer;


	public ChartDataController(IChartDataReader chartDataReader, IChartDataDrawer chartDataDrawer) {
		this.iChartDataReader = chartDataReader;
		this.iChartDataDrawer = chartDataDrawer;
	}
	public void start() throws IOException {
		ChartDataReadResult chartDataReadResult = iChartDataReader.海図データを読み込み();
		iChartDataDrawer.海図データを描画(chartDataReadResult);
	}

}
