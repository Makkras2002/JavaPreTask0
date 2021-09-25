package fileOperations;

import entities.NumberRepo;
import entities.SomeNumber;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileExtractor {
    private static Logger logger = LogManager.getLogger();
    private final String FILEPATH = "Source.txt";
    public NumberRepo extractNumbersFromFileToRepo() throws IOException {
        BufferedReader bufferedReader = null;
        NumberRepo repo = new NumberRepo();
        try {
            FileReader fileReader = new FileReader(FILEPATH);
            bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            while (line != null){
                if(DataValidator.checkIfNumber(line)){
                    repo.addNumber(new SomeNumber(Float.parseFloat(line)));
                }else {
                    logger.error("Invalid data found in file.");
                }
                line = bufferedReader.readLine();
            }
            return repo;

        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        finally {
            bufferedReader.close();
            return repo;
        }
    }
}