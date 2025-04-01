import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;


public class Appplication {
    public static void main(String[] args) {
        try {
            printSmallTextFile("in.txt","out.txt");
            System.out.println("\n\n");
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
    static void printSmallTextFile(String inputfile,String outputfile) throws IOException {
        System.out.println("Using Filesc.readAllLines:");

        Path inputPath=Paths.get(inputfile);
        Path outputPath=Paths.get(outputfile);

        List<String>allLinesInMemory = Files.readAllLines(inputPath);
        StringBuilder modifiedContent = new StringBuilder();


        for(String line: allLinesInMemory){
            System.out.println(line+"\n");

            String modifiedLine=line.replaceAll("\\.", "\n ");
            System.out.println(modifiedLine);

            modifiedContent.append(modifiedLine).append("\n");
        }
        Files.write(outputPath, modifiedContent.toString().getBytes());
    }
}
