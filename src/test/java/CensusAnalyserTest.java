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
            e.getMessage();
        }
    }


}
