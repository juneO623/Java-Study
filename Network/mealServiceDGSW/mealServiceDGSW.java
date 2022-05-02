package mealServiceDGSW;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class MealServiceMain {
   public static void main(String[] args) {
      SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
      Calendar cal = Calendar.getInstance();
      
      String newUrls = "https://open.neis.go.kr/hub/mealServiceDietInfo?\r\n"
            + "Type=json&ATPT_OFCDC_SC_CODE=D10\r\n"
            + "&SD_SCHUL_CODE=7240454\r\n"
            + "&MLSV_YMD=20220502" + sdf.format(cal.getTime());
      try {
         URL url = new URL(newUrls);
         try {
            BufferedReader br = new BufferedReader(
                  new InputStreamReader(url.openStream(),"utf-8"));
            
            JSONParser jsonparser = new JSONParser();
            try {
               JSONObject jsonobject = (JSONObject) jsonparser.parser(br.readLine());
               JSONArray jsonarray = (JSONArray) jsonObject.get("mealServiceDGSW");
               JSONObject row = (JSONObject) jsonArray.get(1);
               JSONArray row_(JSONObject) row.get("row");
               
            } catch (Exception e) {
               // TODO: handle exception
            }
            
         } catch (MalformedURLException e) {
            e.printStackTrace();
         }
      } catch (IOException e) {
         e.printStackTrace();
      }
   } 
}