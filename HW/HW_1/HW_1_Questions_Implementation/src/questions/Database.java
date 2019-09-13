package questions;

import utils.Data;

public class Database {
	private int numRows;
	private int numCols;
	private Data[][] table;

	public Database (int numRows, int numCols) {
      this.numRows = numRows;
      this.numCols = numCols;
      this.table = new Data[numRows][numCols];
    }
}