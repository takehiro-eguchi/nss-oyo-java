package jp.co.nssys.shinjin2019.tsubasa.arai.jr011;

import java.io.IOException;

import jp.co.nssys.shinjin2019.tsubasa.arai.jr011.draw.ChartDataDrawer;
import jp.co.nssys.shinjin2019.tsubasa.arai.jr011.draw.IChartDataDrawer;
import jp.co.nssys.shinjin2019.tsubasa.arai.jr011.read.ChartDataFileReader;
import jp.co.nssys.shinjin2019.tsubasa.arai.jr011.read.IChartDataReader;

public class Main {

	private static ChartDataController chartDataController;

	public static void main(String[] args) {
		IChartDataReader chartDataReader = new ChartDataFileReader("resources/char.csv");
		IChartDataDrawer chartDataDrawer = new ChartDataDrawer("result.txt");
		chartDataController = new ChartDataController(chartDataReader, chartDataDrawer);
		try {
			chartDataController.start();
		} catch (IOException e) {
		}
	}

}
