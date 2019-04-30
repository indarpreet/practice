package practise;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaRegex {

	
	public static void main(String[] args) {
		 String a = "[0?|[0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5]]{1,3}(.)";
         String b = "[0?|[0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5]]{1,3})$";
         StringBuilder sb = new StringBuilder("^("+a);
         String pattern =  sb.append(a).append(a).append(b).toString();
		String arr[] = {"12.12.12.12" ,
			"13.13.13.112",  
			 "VUUT.12.12",  
			 "111.111.11.111", 
			 "1.1.1.1.1.1.1",  
			 ".....",  
			 "1...1..1..1",  
			 "0.0.0.0",  
			 "255.0.255.0",  
			 "266.266.266.266",
			 "00000.000000.0000000.00001",
		 "0023.0012.0012.0034"};
		for(int i = 0 ; i < arr.length ; i++){
		System.out.println(arr[i].matches(pattern));
		}
	}
}
