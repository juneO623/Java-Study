package EvaluationCommandProgram;

import java.io.File;
import java.util.Objects;

public class CommandCd extends AbstractCommand {

	public CommandCd(File currentDirectory, String commandLine) {
		super(currentDirectory, commandLine);
	}

	public boolean findDirectory(String fileName){
		for (File file: currentDirectory.listFiles()) {
			if (Objects.equals(file.getName(), fileName) && file.isDirectory() == true){
				return true;
			}
		}
		return false;
	}

//	public boolean isDirectory(File file){
//		return file.isDirectory();
//	}



	@Override
	public File executeCommand() {
		// TODO

		String fileName = commandLine.split(" ")[1];

		if (fileName.equals("..")){
			try {
				String filePath = currentDirectory.getParentFile().getAbsolutePath();
				return new File(filePath);
			} catch(NullPointerException e) {
				System.out.println("cannot find the path");
				return new File(currentDirectory.getAbsolutePath());
			}
 		}
		if (findDirectory(fileName) == true){
			return new File(
					currentDirectory.getAbsolutePath() + "/"
							+ fileName);
		}
		System.out.println("cannot find the path");
		return new File(currentDirectory.getAbsolutePath());
	}


}
