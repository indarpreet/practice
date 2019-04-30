package dynamic;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class IntelligentStrings {

    // Complete the abbreviation function below.
    static String abbreviation(String a, String b) {
      int arr[] =  new int['Z'+ 1];
       int j = 'a';
       int aCounter = 0;
       boolean isSmall = false;
       boolean found = true;
       boolean escapeNextCapital = false;
       char ch[] = new char[arr.length];
       int top = -1;
      for(int i ='A'; i<arr.length ; i++){
              
              arr[i] = j;
              j++;
      }
      int k=0;
      
      while(aCounter < a.length()){
              
              if(k<b.length()){
                      if((int)b.charAt(k) > arr.length){
                              isSmall = true;
                      }else{
                              isSmall = false;
                      }
              

              if(isSmall){
                      if((int)a.charAt(aCounter)> arr.length){
                              if(a.charAt(aCounter)==b.charAt(k)){
                                     
                            	  top = -1;
                                      k++;
                                      
                              }
                      }else{
                              found = false;
                              break;
                      }
                      aCounter++;

              }else{
                      if((int)a.charAt(aCounter) > arr.length){
                              if(arr[b.charAt(k)]==a.charAt(aCounter)){
                                      
                                      k++;
                                     top++;
                                      ch[top] = b.charAt(k);
                                    
                              }
                      }else if(b.charAt(k)==a.charAt(aCounter)){
                              
                             top = -1;
                              k++;
                            
                      }else{
                              if(top > -1 &&  ch[top]==a.charAt(aCounter)){
                                      top--;
                              }else{
                            	  System.out.println(b.charAt(k));
                            	  System.out.println(a.charAt(aCounter));
                                      found = false;
                                      break;
                              }
                      }
                      aCounter++;
              }
              }else{
                      if((int)a.charAt(aCounter)<arr.length && escapeNextCapital && b.charAt(k-1) == a.charAt(aCounter)){
                              aCounter++;
                      }else{
                              if((int)a.charAt(aCounter)> arr.length){
                                      aCounter++;

                              }else{
                                      found = false;
                                      break;

                              }
                             
                      }
              }
      }
    
      if(k == b.length() && found){
              return "YES";
      }else{
              return "NO";
        
      }


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	String a = "bbBbbbbbrbBbbBbbbbbbbbbrbbbbbBbbbbbbbbbbbbbbobbbbbbbsbbbbbtbBbsbbtbbbbbbbobbbbbbbbbbsbbbbbbbbbbbbbbsbbbbbbbbbbrbrbbBbbbbbbTBbbbbbbbbbbbtbbbbbbbbbbbbbbbbBbbbobbbbbbbbbbbbbtbbbbbbbBbbbbbbbbbBbbsbbbbbbbbobbbbbbbsbbbbbbbbbbbbbbbbbbbbbbtbbbbbbbbrbbbbBbbbbbbbbsbbbbbbobBborbbbbbbbbbbrbbbbbbbbbbbbbbbbbbbbbbbbbtbbbbtbbbbbbbbtbbbbbbbbbbbbbbbbbbbbbbbBbobbbbbBbbbbbbbbbbbbbbbBobbbbbbbbbBbbbrbbbbbbbbbbtbboBbbbbbbbbbbbbSbbbtbbbbbbbbbbbbbbbbbbbbbbtbbbrbbbbbBbbbbbbbbbobbbbbbbbbbbbbbsbbbbbbtbrbbrbbbbbbobbbbbbbbbbbbbbbbbbbbbbbbbbrbbbbbbbbbbbbBbbbbbBbbbbbbbbbbBbbbbbbbbbbbObbtrbsbbbbbbbbbbbbbbbbbbbbrbbbbbbbobbbbbbbbbbbbbbbbbBbbbbbbbbbbbbbbbbbbbbbbrbbbbbbbbbbbbbbbBbbBbbbbbrbbbbbbbbbbbbbbbbbbbbrbbbsbbbbbrbbbbbbbbbbbrobbbbsbbbbbsbbbBbbbbbbbbbbtTbbbbbbbbbbbbtbbtrbobbbbbbbbbbbbbBbbbbbbsbbbbbbbbbbbbbbbbbbBbbbbbbbbbbobbbbbbbbbbbbbbbbbbbbobbbTbsBbbbbbbbbbbbbsbbbbbssbbbbbbbbbSbbbbbbbbbbbbbbsbbbbbbbbbbbbbBbbbbbbbbbbbbbsbbbbBbbtbbSbbbbbbbbbbbbbsbobbbBbbbrbBbbbbbbbbbbbBbbobbbbbbbbbbbbbbbbbbbbtbosbbbbbbbbtbbbbbbbbbbrbb";
    	String b ="BBBBBBBBBBBBBBBBBBBBBRBBBBBBBBBBBBOBBBBBSBBBBTBBBSBBTBBBBBBBBBBBBBSBBBBBBBBBBBBBSBBBBBBBRBBBBBBBBBTBBBBBBBBBTBBBBBBBBBBBBBBBBBBBBBBBBBBBBBTBBBBBBBBBBBBBBSBBBBBBOBBBBSBBBBBBBBBBBBBBBBBBBBBBBBBBBRBBBBBBBBBBBBBBOBBBORBBBBBBBBBRBBBBBBBBBBBBBBBBBBBBBTBBBBBBBBTBBBBBBBBBBBBBBBBBBOBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBTBOBBBBBBBBBBSBBTBBBBBBBBBBBBBBBBBBTBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBSBBBBTBBBRBBBBBOBBBBBBBBBBBBBBBBBBBBBBBRBBBBBBBBBBBBBBBBBBBBBBBBBBBBOBTRBSBBBBBBBBBBBBBBBRBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBRBBBBBBBBBBBBBBBBBBRBBBBBBRBBBBBBBBBBROBBBBBBBBSBBBBBBBBBBBBBTTBBBBBBBBBBBTBBTROBBBBBBBBBBBBBSBBBBBBBBBBBBBBBBBBBBBBBOBBBBBBBBBBBBOBBBTBSBBBBBBBBBBSBBBSBBBBBBSBBBBBBBBBBBSBBBBBBBBBBBBBBBBBBBBBBBBSBBBBBBTBBSBBBBBBBBBBSBOBBBBBBRBBBBBBBBBBBBBBOBBBBBBBBBBBBBBBBBTBSBBBBBBTBBBBBBBBRB";

            String result = abbreviation(a, b);
            
            System.out.println(result);
        
    }
}
