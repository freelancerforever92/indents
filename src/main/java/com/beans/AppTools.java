package com.beans;

import java.util.Random;
import java.util.UUID;

public class AppTools {

	
	static final String randomString = "45632366DGDFVNBVBFDS757813218FDYDF0123efghWXYk456789ABCDE789FGuvwxHIJKLbcdefMNOPbcdefQRST789UVWXYZabcmnopqEFGKLrstyz";
    static Random randomVar = new Random();
    	public String ramdomNumber(int len) {
        StringBuilder strBuilder = new StringBuilder(len);
        for (int lopVar = 0; lopVar < len; lopVar++) {
        	strBuilder.append(randomString.charAt(randomVar.nextInt(randomString.length())));
        }
        return strBuilder.toString();
    }
}
