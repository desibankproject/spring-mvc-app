package com.pk.math;

public class PalindromeMain {
	
	/**
	 * 
	 * @param str
	 * @return
	 */
	public String isPalindrome(String str){
		if(str.length()==0 || str==null){
			RuntimeException exception=new RuntimeException("Hey! length canot be zero for palindrome");
			throw exception;
		}
		int len=str.length();
		String status="yes";
		for(int x=0,k=len-1;x<=len/2;x++,k--){
				if(str.charAt(x)!=str.charAt(k)){
					status="no";
					break;
				}
		}
		return status;
	}
	
	/*public static void main(String[] args) {
		PalindromeMain main=new PalindromeMain();
		System.out.println("Enter string please");
		String str=new Scanner(System.in).next();
		String out=main.isPalindrome(str);
		System.out.println("Result is = "+out);
		
	}*/
	

}
