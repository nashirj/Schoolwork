package questions;

public class File {
	private String fileType;
	private long size;

	// size is in bytes
	public File(String fileType, long size) {
		this.fileType = fileType;
		this.size = size;
	}
}