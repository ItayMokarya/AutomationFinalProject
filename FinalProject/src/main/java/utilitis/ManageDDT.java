package utilitis;

import org.testng.annotations.DataProvider;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

public class ManageDDT extends CommonOps {

    @DataProvider(name = "data-provider-users")
    public Object[][] getDataObjectUsers(){
        return getDataFromCSV(getData("DDTFile"));
    }

    @DataProvider(name = "data-provider-loans")
    public Object[][] getDataObjectLoans(){
        return getDataFromCSV(getData("DDTFile2"));
    }

    public static List<String> readCSV(String csvFile) {
        List<String> lines = null;
        File file = new File(csvFile);
        try {
            lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
        }catch (Exception e){
            e.printStackTrace();
        }
        return lines;
    }

    public static Object[][] getDataFromCSV(String filePath){
        Object[][] data = new Object[4][3];
        List<String> csvData = readCSV(filePath);

        // Init the csvData
        for (int i=0; i< csvData.size(); i++){
            for (int j = 0; j<3 ; j++){
                data [i][j] = csvData.get(i).split(",")[j];
            }
        }
        return data;
    }
}
