package modernjavainaction.chap03;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ProcessFile {
    public static String FILE = ProcessFile.class.getResource("./data.txt").getFile();
    public static void main(String[] args) throws IOException {
        processFileLimited();
processFile((BufferedReader br)-> {
    return br.readLine();
});
    processFile((BufferedReader br)->{return br.readLine()+br.readLine();});
    }


    static void processFileLimited() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE));
        String line1 = bufferedReader.readLine();
        System.out.println(line1);
    }


    interface BufferedReaderProcessor{
        String processFileBR(BufferedReader bufferedReader) throws IOException;
    }
    static void processFile(BufferedReaderProcessor processor) throws FileNotFoundException ,IOException{
        BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE));
        System.out.println(processor.processFileBR(bufferedReader));

    }

}
