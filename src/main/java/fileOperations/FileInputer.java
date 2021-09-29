package fileOperations;

import entities.NumberRepo;
import entities.SomeNumber;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

public class FileInputer {
    private static Logger logger = LogManager.getLogger();
    private final String FILEPATH = "Source.txt";
    public void putNumberIntoFile(String number) throws IOException {
        BufferedWriter bufferedWriter = null;
        try {
            FileWriter fileWriter = new FileWriter(FILEPATH,true);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(number + "\n");
            bufferedWriter.flush();
        } catch (IOException e) {
            logger.error(e.getMessage());
        } finally {
            bufferedWriter.close();
        }
    }
}
