package utils;

import java.util.HashMap;
import java.util.Map;


public class xpathGenerator {

    static Map<String, String> xpaths = null;

    static String[][] data = null;

    public static Map<String,String> xpathGenerate() {

        ReadExcel read = new ReadExcel();

        data=read.getSheet("testsheet.xlsx","xpaths");

        xpaths = new HashMap<String, String>(data.length);
        for (String[] mapping : data)
        {
            xpaths.put(mapping[0], mapping[1]);
        }

       // readWriteExcelProperties.writeToPropertiesFile("./src/main/resources/resources.properties");

       // System.out.println(xpaths);

        return xpaths;
    }


}
