package simulation;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class readBooks {
    private static Logger logger = Logger.getLogger(readBooks.class);
    //    log4j.rootLogger=console;
    static String fileName = ".\\src\\resources\\books.txt";

    public static void main(String[] args) {
        BasicConfigurator.configure();
        testReadFile();
        logger.info(" ---------------------------- ");
        testReadFileBufferedReader();
//        testReadFile_OLD_Scanner();
//        testReadFile_OLD_BufferedReader();
    }


    private static void testReadFile() {
        List<String> list = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
//            stream.forEach(System.out::println);//logger::info

            list = stream
                    .filter(line -> !line.startsWith("line3"))
                    .map(String::toUpperCase)
                    .collect(Collectors.toList());

            stream.close();
        } catch (IOException e) {
//            logger.info(e.getMessage());
            e.printStackTrace();
        }

        list.forEach(System.out::println);
//        list.forEach(logger::info);
    }

    public static void testReadFileBufferedReader() {
        List<String> list = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {

            //br returns as stream and convert it into a List
            list = br.lines().collect(Collectors.toList());

            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        list.forEach(System.out::println);//logger::info
    }

    private static void testReadFile_OLD_Scanner() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(fileName)));
            while (scanner.hasNext()) {
                logger.info(scanner.next());
            }

        } catch (FileNotFoundException e) {
            // e.printStackTrace();
            logger.info("Unable to open file '" + fileName + "'");
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    private static void testReadFile_OLD_BufferedReader() {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line;
            while ((line = br.readLine()) != null) {
                logger.info(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        /// -------------------------------- ex2

        BufferedReader br = null;
        FileReader fr = null;

        try {

            //br = new BufferedReader(new FileReader(FILENAME));
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                logger.info(sCurrentLine);
            }

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (br != null)
                    br.close();

                if (fr != null)
                    fr.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }

        }

    }

}
