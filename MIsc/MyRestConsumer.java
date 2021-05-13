/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myrestconsumer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 *
 * @author Rishabh
 */
public class MyRestConsumer {
    private static ScriptEngine engine = new ScriptEngineManager().getEngineByName("javascript");
    private static Map<String,Integer> titleMap = new HashMap<>();;
    
    public static void main(String[] args) throws IOException, ScriptException{
        int pageNo = 1;
        String endPoint = "https://jsonmock.hackerrank.com/api/articles?page="+pageNo;
        URL restResponse = new URL(endPoint);
        BufferedReader br = new BufferedReader(new InputStreamReader(
                restResponse.openStream()));

        String response = br.readLine();
        System.out.println("Response from API - " + response);
        String script = "Java.asJSONCompatible(" + response + ")";
        engine = new ScriptEngineManager().getEngineByName("javascript");
        Map<String, Object> map = (Map<String, Object>)engine.eval(script);

        Object data = map.get("data");
        int totalPages = (int) map.get("total_pages");
        int comments = 700;
        
        if(pageNo <= totalPages){
            jsonList((List<Object>) data);
            List<String> titleList = getTitles(comments);
            System.out.println("\n\nPage - " +pageNo+ "\ncomments greater than- " +comments+ "\nTitles - "  +titleList);
        }else{
            System.out.println("Invalid page number!");
        }
        
    }

    private static void jsonList(List<Object> objectList) {
        for (int i = 0; i < objectList.size(); i++)
            jsonMap((Map<Object, Object>) objectList.get(i));
    }
    
    private static void jsonMap(Map<Object,Object> objectMap) {
        int numComments = 0;
        if(!Objects.isNull(objectMap.get("num_comments")))
            numComments = (int) objectMap.get("num_comments");
        String title = "";
        if(!Objects.isNull(objectMap.get("title")))
            title = (String) objectMap.get("title");
        //System.out.println("title  - " + title + " ::: " + " comments - " + numComments );
        titleMap.put(title,numComments);
    }
     
    public static List<String> getTitles(int nComments){
        List<String> titleList = new ArrayList<>();
        for(Map.Entry<String,Integer> e : titleMap.entrySet()){
            if(e.getValue() > nComments){
                if(e.getKey()!="")
                    titleList.add(e.getKey());
            }
        }
        return titleList;
    }
}
