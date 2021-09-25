package fileOperations;

import entities.NumberRepo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.IOException;


public class FileExtractorTest {
    FileExtractor fileExtractor;
    NumberRepo repo;
    Logger logger = LogManager.getLogger();
    @BeforeMethod
    public void setUp(){
        fileExtractor = new FileExtractor();
        repo = new NumberRepo();
    }
    @Test(timeOut = 1000)
    public void testExtractionSpeed(){
        int tempCounter =0;
        while (tempCounter <1000){
            try {
                repo = fileExtractor.extractNumbersFromFileToRepo();
            } catch (IOException e) {
                e.printStackTrace();
            }
            tempCounter++;
        }

    }
    @Test
    public void testExtractNumbersFromFileToRepo(){
        try {
            repo = fileExtractor.extractNumbersFromFileToRepo();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(repo.numberList.size(),5,0,"Test failed...");
    }
}