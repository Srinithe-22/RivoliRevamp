package utils;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CreateFeatureFile {
    static String[][] testcase = null;
    static Map<String, String> teststep = null;

   /* public static void main(String agrs[]){
        readTestcase();
    }*/
    public static void readTestcase(){
        ReadExcel read = new ReadExcel();
        CreateFeatureFile createfeature = new CreateFeatureFile();

        testcase=read.getSheet("testcases.xlsx","Sheet1");



        teststep = new HashMap<String, String>(testcase.length);
        for (String[] mapping : testcase)
        {
            teststep.put(mapping[0], mapping[1]);
        }
        System.out.println(teststep);

        createfeature.createFeature("./src/main/resources/features/smoke-USDesktop.feature");

    }
    public static void createFeature(String path) {
        try {

            File file = new File(path);
            BufferedWriter xlsFos = new BufferedWriter(new FileWriter(file));

            xlsFos.write("Feature: Sanity Test on anysite\n\n\n @newtest\nScenario : Test\n");

            Iterator mapIterator = teststep.keySet().iterator();

            while (mapIterator.hasNext()) {
                String key = mapIterator.next().toString();

                String value = teststep.get(key);

                //System.out.println(key + " " + value);
                String num[]=key.split(" ");

                if(key.equals("Step 1")){
                    xlsFos.write(value+"\n");
                }else{
                    for(int i=1;i<num.length;i++){
                        //System.out.println(num[i]);
                        if(Integer.parseInt(num[i])%2==0){
                            xlsFos.write(value+"\n");
                        }
                        else{
                            xlsFos.write(value+"\n");
                        }
                    }
                }

            }
            xlsFos.close();
        }catch (FileNotFoundException e) {

            e.printStackTrace();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
