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
        FileReader fr = new FileReader("StateCode.csv");
        CSVReader csvReader = new CSVReader(fr);
        String[] nextLine;

        nextLine = csvReader.readNext();
        while((nextLine =csvReader.readNext())!=null){

            Iterator<String> it = Arrays.stream(nextLine).iterator();

            String SrNo= it.next();
            String StateName= it.next();
            String TIN= it.next();
            String StateCode= it.next();
            try {
                tempObj = new StateCodeData(Integer.parseInt(SrNo),StateName, Integer.parseInt(TIN),StateCode);
                scd1.add(tempObj);
            }
           catch (Exception e)
           {
               throw new CustomException("Type Incorrect");
           }



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


