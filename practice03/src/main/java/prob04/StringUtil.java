package prob04;

public class StringUtil {
     public static String concatenate(String[] str) {
    	 String concatStr = new String();
    	 for (int i = 0; i < str.length; i++) {
    		 concatStr.concat(str[i]); 	
		 }
    	 System.out.println("test"+concatStr);
    	 return concatStr;
     }
}

