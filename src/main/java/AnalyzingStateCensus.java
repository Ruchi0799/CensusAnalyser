
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
//import org.apache.commons.io.FileUtils;

//public class AnalyzingStateCensus {
//}
public class AnalyzingStateCensus {

    ArrayList<StateCensusData> scd = new ArrayList<>();
    StateCensusData tempObj;

//    public static void main(String[] args) throws IOException {
//        AnalyzingStateCensus asc = new AnalyzingStateCensus();
//        asc.loadingDataFromCSV();
//        System.out.println(asc.scd.size());
//    }

    public int loadingDataFromCSV() throws IOException, CustomException {
        try {
            FileReader fr = new FileReader("IndiaStateCensusData.csv");
            //CSVReader csvReader = new CSVReader(fr);
            CSVParser parser = new CSVParserBuilder().withSeparator(',').build();
            CSVReader csvReader = new CSVReaderBuilder(fr).withCSVParser(parser).build();
            String[] nextLine;

            nextLine = csvReader.readNext();
           // try{
                if (nextLine[0].equals("State") && nextLine[1].equals("Population") && nextLine[2].equals("AreaInSqKm") && nextLine[3].equals("DensityPerSqKm")  ){
                }
               else{throw new CustomException("Incorrect header");
                }
//            }
//            catch (CustomException e){
//                throw new CustomException("Incorrect header");
//            }
            while ((nextLine = csvReader.readNext()) != null) {

                Iterator<String> it = Arrays.stream(nextLine).iterator();
                String state = it.next();
                String population = it.next();
                String areaInSqKm = it.next();
                String DensityPerSqKm = it.next();

                tempObj = new StateCensusData(state, Long.parseLong(population), Long.parseLong(areaInSqKm), Integer.parseInt(DensityPerSqKm));
                scd.add(tempObj);
            }
        }
        catch (CustomException e)
        {
            throw new CustomException("Incorrect header");
        }
        catch (Exception e)
        {
            throw new CustomException("Type incorrect or delimeter not proper ");
        }


        System.out.println();
        //return asc.sc.size();
        return scd.size();
        
    }

    public int checkingFileIfExists() throws CustomException {
        File file = new File("IndiaStateCensusData1.csv");
        if (file.exists()){
            return 1;
        }
        else {
            throw new CustomException("File not found");
        }
    }



}
