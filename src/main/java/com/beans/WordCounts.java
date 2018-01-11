package com.beans;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;
import java.util.Set;

public class WordCounts {

	public static void main(String args[]){
		Map<String, Integer> mapWords = new HashMap<String, Integer>();
		BufferedReader fileInputReader = null;
		try{
			fileInputReader = new BufferedReader(new FileReader("C:\\Users\\pra\\Desktop\\sample.txt"));
			String docLine = fileInputReader.readLine();
            
            while (docLine != null)
            {    
            	String[] wrds = docLine.toLowerCase().split(" ");
            	for (String word : wrds)
                {
            		 if(mapWords.containsKey(word))
                     {    
            			 mapWords.put(word, mapWords.get(word)+1);
                     }
            		 else
                     {
            			 mapWords.put(word, 1);
                     }
                }
            	docLine = fileInputReader.readLine();
            }
            Set<Entry<String, Integer>> wrdsEntry = mapWords.entrySet();
            List<Entry<String, Integer>> list = new ArrayList<Entry<String,Integer>>(wrdsEntry);
            Collections.sort(list, new Comparator<Entry<String, Integer>>() 
                    {
                        public int compare(Entry<String, Integer> es1, Entry<String, Integer> es2) 
                        {
                            return (es2.getValue().compareTo(es1.getValue()));
                        }
                    });
            System.out.println("RESULT    ");
            for (Entry<String, Integer> entry : list) 
            {
                if (entry.getValue() > 1)
                {
                    System.out.println(entry.getKey().trim() + " - "+ entry.getValue());
                }
            }
		}catch(Exception ex){
		 System.out.println("Exception : "+ex.getMessage().trim());	
		}
	}
}
