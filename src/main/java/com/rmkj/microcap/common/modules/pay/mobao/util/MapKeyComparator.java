package com.rmkj.microcap.common.modules.pay.mobao.util;

import java.io.UnsupportedEncodingException;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;


/**
 * ʹ�� Map��key�������� 
 * @param map 
 * @return 
 */  
public class MapKeyComparator implements Comparator<String> {
    public int compare(String str1, String str2) {  
        return str1.compareTo(str2);  
    }  
    
    
    /** 
     * ʹ�� Map��key�������� 
     * @param map 
     * @return 
     */  
    public static Map<String, String> sortMapByKey(Map<String, String> map) {  
        if (map == null || map.isEmpty()) {  
            return null;  
        }  
        Map<String, String> sortMap = new TreeMap<String, String>(new MapKeyComparator());  
        sortMap.putAll(map);  
        return sortMap;  
    }
    
    
    public static void main(String[] args) {  
        Map<String, String> map = new TreeMap<String, String>();  
        map.put("KFC", "kfc");  
        map.put("WNBA", "wnba");  
        map.put("NBA", "nba");  
        map.put("CBA", "cba");  
        map = sortMapByKey(map);    //��Key��������  
        for (Map.Entry<String, String> entry : map.entrySet()) {  
            System.out.println(entry.getKey() + " " + entry.getValue());  
        }  
    }
    
    /****
     * ת��GBK��ʽ��URL
     * @param map
     * @return
     * @throws UnsupportedEncodingException
     */
    public static  String   convertEncoderGBKUrl(Map map) throws UnsupportedEncodingException{
    	StringBuffer  buf= new StringBuffer();
    	if(null!=map){
    		Iterator  it= map.keySet().iterator();
    		while (it.hasNext()) {
				String key = (String) it.next();
				buf.append(key);
				buf.append("=");
				buf.append(map.get(key));
				if(it.hasNext()){
				buf.append("&");
				}
			}
    		
    		return  buf.toString();
    		
    	}else{
    		return null;
    	}
    }
    

}
