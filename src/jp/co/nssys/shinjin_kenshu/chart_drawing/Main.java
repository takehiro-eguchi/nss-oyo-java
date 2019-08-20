package jp.co.nssys.shinjin_kenshu.chart_drawing;

import java.util.Scanner;

import jp.co.nssys.shinjin_kenshu.chart_drawing.draw.ChartDataDrawer;
import jp.co.nssys.shinjin_kenshu.chart_drawing.draw.IChartDataDrawer;
import jp.co.nssys.shinjin_kenshu.chart_drawing.read.ChartDataFileReader;
import jp.co.nssys.shinjin_kenshu.chart_drawing.read.IChartDataReader;

/**
 * Mainクラス。
 */
public class Main {

	/**
	 * mainメソッド。
	 *
	 * @param args 実行時引数（使用しません）。
	 */
	public static void main(String[] args) {
		System.out.println("海図データファイルの名前を入力してください。");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String filePath = scanner.next();

		IChartDataReader chartDataReader = new ChartDataFileReader(filePath);
		IChartDataDrawer chartDataDrawer = new ChartDataDrawer();
		ChartDataController chartDataController = new ChartDataController(chartDataReader, chartDataDrawer);
		chartDataController.drawChart();
	}

}
