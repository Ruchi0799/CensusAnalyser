import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class CensusAnalyserTest {
    @Test
    public void LoadCSVFile_AndReturnFileSize() throws IOException, CustomException {
        AnalyzingStateCensus asc = new AnalyzingStateCensus();
        asc.loadingDataFromCSV();
        Assert.assertEquals(29,asc.scd.size());
    }

    @Test
    public void checkCensusCSV_IsCorrect(){
        try {
            AnalyzingStateCensus isc = new AnalyzingStateCensus();
            Assert.assertEquals(1,isc.checkingFileIfExists());
        } catch (CustomException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void checkCensusCSV_IsCorrect_IfNotReturnCustomMessage(){
        try {
            AnalyzingStateCensus isc = new AnalyzingStateCensus();
            Assert.assertEquals("File not found",isc.checkingFileIfExists());
        } catch (CustomException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void checking_IfFileCorrect_ButTypeIncorrect(){
        try {
            AnalyzingStateCensus isc = new AnalyzingStateCensus();
            isc.loadingDataFromCSV();
            Assert.assertEquals(58,isc.loadingDataFromCSV());
        }
        catch (Exception e){
            e.getMessage();
        }
    }


    @Test
    public void checkIfDelimeter_IsCorrect_IfNot_ReturnException(){
        try {
            AnalyzingStateCensus isc = new AnalyzingStateCensus();
            isc.loadingDataFromCSV();
            Assert.assertEquals(58,isc.loadingDataFromCSV());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            e.getMessage();
        }
    }

    @Test
    public void checkIfHeader_IsCorrect_IfNot_ReturnException(){
        try {
            AnalyzingStateCensus isc = new AnalyzingStateCensus();
            isc.loadingDataFromCSV();
            Assert.assertEquals(58,isc.loadingDataFromCSV());
        }
        catch (CustomException | IOException e){
            System.out.println(e.getMessage());
            e.getMessage();
        }
    }

    @Test
    public void LoadCSVFileState_AndReturnFileSize() throws IOException, CustomException {
        CSVStates asc1 = new CSVStates();
        asc1.loadingDataFromCSV();
        Assert.assertEquals(37,asc1.scd1.size());
    }

    @Test
    public void checkStateCodeCSV_IsCorrect(){
        try {
            CSVStates isc = new CSVStates();
            Assert.assertEquals(1,isc.checkingFileIfExists());
        } catch (CustomException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void checkStateCodeCSV_IsCorrect_IfNotReturnCustomMessage(){
        try {
            CSVStates isc = new CSVStates();
            Assert.assertEquals("File not found",isc.checkingFileIfExists());
        } catch (CustomException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void checking_IfStateCodeFileCorrect_ButTypeIncorrect(){
        try {
            CSVStates isc = new CSVStates();
            isc.loadingDataFromCSV();
            Assert.assertEquals(74,isc.loadingDataFromCSV());
        }
        catch (Exception e){
            e.getMessage();
        }
    }

    




}
