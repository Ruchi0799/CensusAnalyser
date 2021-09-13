import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class CensusAnalyserTest {
    @Test
    public void LoadCSVFile_AndReturnFileSize() throws IOException {
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


}
