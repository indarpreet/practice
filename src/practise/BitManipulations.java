package practise;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class BitManipulations {

	
	public static void main(String[] args) {
		
		//insertion5_1();
		//binaryToString5_2(3.703125);
		//flipBitToWin5_3(1775);
		//nextNumber5_4(31);
		//conversion(1002 , 150);
		//pairWiseSwap("10101010011");
		drawLine();
		
		
	}

	private static void drawLine() {
				
	}

	private static void pairWiseSwap(String bits) {
		int length = bits.length();
		if(length <= 1){
			System.out.println(bits);
		}else{
			int i = length-1 ;
			int j= length-2;
			StringBuilder sb = new StringBuilder();
			while(i >=0 &&  j>=0){
				sb.insert(0, bits.charAt(j));
				sb.insert(0, bits.charAt(i));
				i -=2;
				j-=2;
			}
			if(i==0){
				sb.insert(0, bits.charAt(i));
			}
			System.out.println(sb.toString());
		}
		
		
	}

	private static void conversion(int large , int small) {
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		bitRepresentationOfDouble(small, sb1);
		bitRepresentationOfDouble(large, sb2);
		
		System.out.println(sb1.reverse().toString());
		System.out.println(sb2.reverse().toString());
		int count = sb2.length()-sb1.length();
		for(int i=sb1.length()-1; i>=0 ;i --){
			
			if(sb1.charAt(i) != sb2.charAt(i) ){
				count ++;
			}
		}
		System.out.println(count);
		
		
	}

	private static void nextNumber5_4(int val) {
		StringBuilder sb = new StringBuilder();
		bitRepresentationOfDouble(val, sb);
		String bitReversed = sb.toString();
		String bitRep = sb.reverse().toString();
		System.out.println(bitRep);
		boolean firstZeroBeforeOne = false;
		boolean firstZeroAfterOne = false;
		boolean lengthSmall = false;
		short setBit = 0;
		StringBuilder small = new StringBuilder();
		StringBuilder large = new StringBuilder();
		int changeIndexAt = -1;
		int length = bitRep.length();
		for(int i= length-1; i>=0 ; i-- ){
			if(bitRep.charAt(i) == '1'&& !firstZeroBeforeOne){
				if(i+1 < length && bitRep.charAt(i+1) == '0' ){
					firstZeroBeforeOne = true;
					small.deleteCharAt(small.length()-1);
					small.append('1');
					small.append('0');
					
					
				}else{
					small.append(bitRep.charAt(i));
				}
			}else{
				small.append(bitRep.charAt(i));
			}
			
			
			if(bitRep.charAt(i) == '1' && !firstZeroAfterOne){
				if(i-1 >= 0 && bitRep.charAt(i-1) == '0'){
					firstZeroAfterOne = true;
					large.append("01");
					
					changeIndexAt = large.length();
					
				}else{
					large.append(bitRep.charAt(i));
				}
			}else{
				
				large.append(bitRep.charAt(i));
			}
			
			if(bitRep.charAt(i)=='1')
			{setBit++;}
		}
		if(changeIndexAt != -1){
			large.deleteCharAt(changeIndexAt);
		}
		if(!firstZeroAfterOne){
			large.replace(large.length()-1, large.length(), "01");
			
		}
		if(small.charAt(small.length()-1) == '0'){
			System.out.println("length changed");
			small = new StringBuilder();
			int smallZeros = length-2-setBit;
			for(int i = 0 ; i<length-1 ; i++){
				
				if(i<= smallZeros){
					small.append('0');
				}else{
					small.append('1');
				}
			}
		}
		
		System.out.println("Large--> " + large.reverse().toString());
		System.out.println("Small--> " + small.reverse().toString());
		
	}

	private static void flipBitToWin5_3(int intVal) {
		StringBuilder sb = new StringBuilder();
		//bitRepresentationOfDouble(intVal, sb);
		
		String bits = sb.append("110111011111101111111011101111111111111111111111111111111011111").toString();
		int counter = 0;
		int result = 0;
		
		
		int indexOfZero = 0;
		for(int i =0 ; i < bits.length() ; i++){
			if(bits.charAt(i) == '0'){
				
				if( i - indexOfZero != i){
					if(counter > result){
						result = counter;
					}	
					counter = i-indexOfZero-1;
				}
				indexOfZero = i;
			}
			
			counter++;
			if(i == bits.length()-1){
				if(counter > result){
					result = counter;
				}
			}
		}
		System.out.println(result);
	}

	private static void binaryToString5_2(double d) {
	
		int intVal = (int)d;
		StringBuilder sb = new StringBuilder();
		bitRepresentationOfDouble(intVal, sb);
		sb = sb.reverse().append(".");
		
		String d1=BigDecimal.valueOf(d).toPlainString();
		d1 = d1.substring(d1.indexOf('.'));
		System.out.println();
		Map<Double , Result> memoization = new HashMap<>();
		
		valueAfterDecimal(Double.parseDouble(d1) , memoization , sb );
		
	}

	private static void valueAfterDecimal(double parseDouble , Map<Double, Result> memoization ,StringBuilder sb) {
		
		
			double res = parseDouble * 2;
			if(null == memoization.get(res)){
				if(sb.length() <= 32){
					Result rs = new Result();
					rs.binary =  (int)res;
					System.out.println(res);
					sb.append(rs.binary);
					String d1=BigDecimal.valueOf(res).toPlainString();
					d1 = d1.substring(d1.indexOf('.'));
					rs.result = Double.parseDouble(d1);
					memoization.put(res, rs);
					if(res == 1.0){
						System.out.println(sb.length());
						System.out.println(sb.toString());
						System.out.println("SUCCESS");
					}else{
						
						valueAfterDecimal(rs.result, memoization, sb);
					}
					
				}else{
					System.out.println(sb.length());
					System.out.println(memoization);
					System.out.println(sb.toString());
					System.out.println("ERROR");
				}
				
			}else{
				System.out.println(memoization);
				System.out.println(sb.length());
				System.out.println(sb.toString());
				System.out.println("ERROR");
			}
		
	}

	private static void insertion5_1() {
		int i = 2;
		int j = 6;
		
		
		
		
		
		String s = "10000000000";
		String s2 =    "10011";
		if(i >=0 && j < s.length() && j-i >= s2.length()-1 ){
			
		
		double m1 = 0;
		int z = s.length() -1;
		for(int k=0; k < s.length() ; k++){
			if(Character.getNumericValue(s.charAt(k)) == 1){
				m1 = Math.pow(2, z) + m1;
			}
		
			z--;
		}
		
		double m2 = 0;
		
		int d = j;
		for(int k=0; k < s2.length() ; k++){
			if(Character.getNumericValue(s2.charAt(k)) == 1){
				m2 = Math.pow(2, d) + m2;
			}
		
			d--;
		}
		System.out.println(m2);
		
		System.out.println(m1+m2);
		
		System.out.println(Math.pow(2, 10));
		
		double m = m1+m2;
		System.out.println(m);
		StringBuilder sb = new StringBuilder();
		bitRepresentationOfDouble((int)m , sb);
		System.out.println(sb.reverse().toString());
		}
	}

	private static void bitRepresentationOfDouble(int m , StringBuilder sb) {
		
		 
		 if(m / 2 == 0){
			 sb.append(m % 2);
		 }else{
			 sb.append(m % 2);
			 bitRepresentationOfDouble(m/2, sb);
		 }
		
		 
		 
		
	}
	
	
	
}
