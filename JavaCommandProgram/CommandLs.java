package EvaluationCommandProgram;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommandLs extends AbstractCommand {

	public File currentDirectory = null;

	public CommandLs(File currentDirectory, String commandLine) {
		super(currentDirectory, commandLine);
		this.currentDirectory = currentDirectory;
	}

//	public Date convertToDate(long unixTime){
//		return new Date(unixTime);
//	}
//
//	public String formatDate(Date date){
//		SimpleDateFormat dateFormat =
//				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		return dateFormat.format(date);
//	}

	public String formatDate(long unixTime){
		Date date = new Date(unixTime);
		SimpleDateFormat dateFormat =
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateFormat.format(date);
	}

	public String byteConverter(long fileLength){
		String lengthStr;
		if (fileLength >= (1000 * 1000 * 1000)){
			fileLength /= (1000 * 1000 * 1000);
			lengthStr = String.valueOf(fileLength) + "G";
		} else if (fileLength >= (1000 * 1000)) {
			fileLength /= (1000 * 1000);
			lengthStr = String.valueOf(fileLength) + "M";
		} else if (fileLength >= 1000) {
			fileLength /= 1000;
			lengthStr = String.valueOf(fileLength) + "K";
		} else{
			lengthStr = String.valueOf(fileLength);
		}
		return lengthStr;
	}

	public void printFileInformation(File file){
		System.out.print(formatDate(file.lastModified())+" ");
		System.out.printf("%6s ", file.isDirectory() ? "<DIR>" : " ");
		System.out.printf(" %-6s", file.isDirectory() ? " " : byteConverter(file.length()));
		System.out.print("%s".formatted(file.getName()));
		System.out.println();
	}

	@Override
	public File executeCommand() {
		// TODO

		boolean exist = currentDirectory.exists();	//

		if (exist == false){
			System.out.println("잘못된 디렉토리 정보입니다.");
		}

		File[] fileDirectoryList = currentDirectory.listFiles();

		for (File file : fileDirectoryList){
			printFileInformation(file);
		}




//		for (String file : fileDirectoryList){
//			File currentFile = new File()
//			System.out.printf("%s %s %s",
//					convertToDate(formatDate(currentDirectory[file].lastModified()))
//					);
//		}
		System.out.println();


//		String path = currentDirectory.getAbsolutePath();

//		System.out.println(path);


		return currentDirectory;
	}
	
}
