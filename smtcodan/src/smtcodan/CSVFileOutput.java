package smtcodan;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class CSVFileOutput {
	public StringBuilder builder;
	public FileWriter pw = null;

	public CSVFileOutput() {

		try {
			this.pw = new FileWriter(new File(Config.dumpIntoCSVFile), true);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.builder = new StringBuilder();
		String ColumnNamesList = "SatPaths/Program, UnsatPaths/Program, BranchNodes/Program";
		// No need give the headers Like: id, Name on builder.append
		this.builder.append(ColumnNamesList + "\n");
		try {
			this.pw.write(builder.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void printIntoCSVFile(StringBuilder builder, FileWriter pw2,
			float countSatpaths, float countUNsatpaths, float countBranchNodes) {
		String s1 = Float.toString(countSatpaths);
		String s2 = Float.toString(countUNsatpaths);
		String s3 = Float.toString(countBranchNodes);

		builder = new StringBuilder();
		builder.append(s1 + ",");
		builder.append(s2 + ",");
		builder.append(s3);
		builder.append('\n');
		try {
			this.pw.write(builder.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// pw.close();
		System.out.println("done!");
	}
}
