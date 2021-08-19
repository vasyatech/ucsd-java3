package counting_words;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileOperations {
	
	private List<File> fileList = new ArrayList<File>();
	
	public void addFile(File file) {
		fileList.add(file);
	}
	
	public List<File> getFileList(){
		return fileList;
	}
}
