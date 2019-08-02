package jp.co.nssys.shinjin_kenshu.text;

import dnl.utils.text.table.TextTable;

public class Sample {

	public static void main(String[] args) {
		String[] names = {"#", "Title", "Author", "State  " };
		Object[][] data = {
				{1,"Guernica","Picasso", "lending"},
				{2,"Primavera","Botticelli", "lending"},
				{3,"De Nachtwacht","Rembrandt",""},
				{4,"Meduse","caravaggio",""},
				{5,"The Tower of Babel","Bruegel", "lending"},
		};
		TextTable table = new TextTable(names, data);
		table.printTable();
	}
}
