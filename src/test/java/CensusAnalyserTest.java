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
}
