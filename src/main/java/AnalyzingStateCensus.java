
import com.opencsv.CSVReader;
import com.opencsv.exceptions.*;
//import com.opencsv.exceptions.CsvValidationException;
import javax.swing.text.html.HTMLDocument;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

//public class AnalyzingStateCensus {
//}
public class AnalyzingStateCensus {

    ArrayList<StateCensusData> scd = new ArrayList<>();
    StateCensusData tempObj;

    public static void main(String[] args) throws IOException {
        AnalyzingStateCensus asc = new AnalyzingStateCensus();
        asc.loadingDataFromCSV();
        System.out.println(asc.scd.size());
    }

    public void loadingDataFromCSV() throws IOException {
        FileReader fr = new FileReader("IndiaStateCensusData.csv");
        CSVReader csvReader = new CSVReader(fr);
        String[] nextLine;

        nextLine = csvReader.readNext();
        while((nextLine =csvReader.readNext())!=null){

            Iterator<String> it = Arrays.stream(nextLine).iterator();
            String state = it.next();
            String  population = it.next();
            String areaInSqKm = it.next();
            String DensityPerSqKm = it.next();

            tempObj = new StateCensusData(state, Long.parseLong(population), Long.parseLong(areaInSqKm), Integer.parseInt(DensityPerSqKm));
            scd.add(tempObj);
        }
        System.out.println();
        //return asc.sc.size();
        
    }
}