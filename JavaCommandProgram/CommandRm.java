package EvaluationCommandProgram;

import java.io.File;

public class CommandRm extends AbstractCommand {

    public File currentDir = null;

    public CommandRm(File currentDirectory, String commandLine) {
        super(currentDirectory, commandLine);
        this.currentDir = currentDirectory;
    }

    @Override
    public File executeCommand() {

        String fileName = commandLine.split(" ")[1];
        File rmFile = new File(currentDir + "\\" + fileName);

        if (rmFile.exists()){
            if (rmFile.isDirectory()){
                System.out.println("디렉토리가 삭제되었습니다.");
            } else {
                System.out.println("파일이 삭제되었습니다.");
            }
            rmFile.delete();
        } else {
            System.out.println("존재하지 않는 파일/디렉토리 입니다.");
            System.out.println("파일/디렉토리 명을 다시 한 번 확인해주세요.");
        }

        return new File(currentDirectory.getAbsolutePath());
    }

}
