package main;

import entities.NumberRepo;
import fileOperations.FileExtractor;
import fileOperations.FileInputer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Scanner;

import static fileOperations.DataValidator.checkIfNumber;
import static mathActions.MathFunctions.*;

public class Main {
    private static Logger logger = LogManager.getLogger();
    public static void main(String[] args) {
        boolean signal = true;
        NumberRepo repo = new NumberRepo();
        Scanner scanner = new Scanner(System.in);
        boolean indicator = false;
        while(signal){
            logger.info("1. Extract numbers from file.");
            logger.info("2. Count sum.");
            logger.info("3. Count diff.");
            logger.info("4.Count multi.");
            logger.info("5.Count div.");
            logger.info("6.Write number in the file.");
            logger.info("7.Exit.");
            String choice = scanner.nextLine();
            switch (choice){
                case "1":{
                    FileExtractor extractor = new FileExtractor();
                    try {
                        repo = extractor.extractNumbersFromFileToRepo();
                        if(repo.numberList.size() == 0){
                            logger.error("File is empty.");
                            return;
                        }
                    } catch (IOException e) {
                        logger.error(e.getMessage());
                    }
                    indicator = true;
                    break;
                }
                case "2":{
                    if(indicator){
                        logger.info(countSum(repo));
                    }
                    break;
                }
                case "3":{
                    if(indicator){
                        logger.info(countDiff(repo));
                    }
                    break;
                }
                case "4":{
                    if(indicator){
                        logger.info(countMulti(repo));
                    }
                    break;

                }
                case "5":{
                    if(indicator){
                        logger.info(countDiv(repo));
                    }
                    break;
                }
                case "6":{
                    FileInputer fileInputer = new FileInputer();
                    String number = scanner.nextLine();
                    if(checkIfNumber(number)){
                        try {
                            fileInputer.putNumberIntoFile(number);
                        } catch (IOException e) {
                            logger.error(e.getMessage());
                        }
                    }else {
                        logger.error("Invalid data was entered.");
                    }
                    break;
                }
                case "7":{
                    signal = false;
                    break;
                }
            }
        }
    }
}
