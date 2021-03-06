import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import name.finsterwalder.fileutils.FileUtils;
//import com.opencsv.exceptions.CsvValidationException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Optional;

public class CSVStates {

    ArrayList<StateCodeData> scd1 = new ArrayList<>();
    StateCodeData tempObj;


    public int loadingDataFromCSV() throws IOException, CustomException {
        try {


            FileReader fr = new FileReader("StateCode.csv");
            //CSVReader csvReader = new CSVReader(fr);
            CSVParser parser = new CSVParserBuilder().withSeparator(',').build();
            CSVReader csvReader = new CSVReaderBuilder(fr).withCSVParser(parser).build();
            String[] nextLine;

            nextLine = csvReader.readNext();
            if (nextLine[0].equals("SrNo") && nextLine[1].equals("State Name") && nextLine[2].equals("TIN") && nextLine[3].equals("StateCode")) {
            } else {
                throw new CustomException("Incorrect header");
            }
            while ((nextLine = csvReader.readNext()) != null) {

                Iterator<String> it = Arrays.stream(nextLine).iterator();

                String SrNo = it.next();
                String StateName = it.next();
                String TIN = it.next();
                String StateCode = it.next();

                tempObj = new StateCodeData(Integer.parseInt(SrNo), StateName, Integer.parseInt(TIN), StateCode);
                scd1.add(tempObj);
            }
        }
            catch (CustomException e)
            {
                throw new CustomException("Incorrect header");
            }
            catch (Exception e)
           {
               throw new CustomException("Type Incorrect or delimeter not proper");
           }


        System.out.println();
        //return asc.sc.size();
        return scd1.size();

    }


    public int checkingFileIfExists() throws CustomException {
        File file = new File("StateCode.csv");
        if (file.exists()){
            return 1;
        }
        else {
            throw new CustomException("File not found");
        }
    }
}


