package jp.co.nssys.shinjin_kenshu.chart_drawing;

import java.io.FileNotFoundException;

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
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
//		System.out.println("海図データファイルの名前を入力してください。");
//		@SuppressWarnings("resource")
//		Scanner scanner = new Scanner(new FileInputStream("resources/chart.csv"));
//		String filePath = scanner.next();

		IChartDataReader chartDataReader = new ChartDataFileReader("resources/chart.csv");
		IChartDataDrawer chartDataDrawer = new ChartDataDrawer();
		ChartDataController chartDataController = new ChartDataController(chartDataReader, chartDataDrawer);
		chartDataController.drawChart();
	}

}
