package com.mycompany.app;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class App {

    public static void main(String[] args) throws IOException, CsvException {

        String fileName = "./src/test/files/backup.csv";   // isto será interessante: como acha o arquivo para teste?? referência absoluta não vale.
                                                           // faz sentido ser de onde o aplicativo é executado...
        System.out.println( "Hello World!" );

        try (CSVReader reader = new CSVReader(new FileReader(fileName))) {
            List<String[]> r = reader.readAll();
            r.forEach(x -> System.out.println(Arrays.toString(x)));
        }

    }

}

/**
 * Hello world!
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}

 *
 */

