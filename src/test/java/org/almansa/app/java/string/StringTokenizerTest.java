package org.almansa.app.java.string;

import java.util.StringTokenizer;

import org.junit.Test;

public class StringTokenizerTest {
    
	/**
	 * StringTokenizer implements Enumeration<Object>
	 * 문자열을 토큰으로 분리하는데 사용하는 클래스 
	 * 레거시 클래스로서 새로운 코드에서 사용은 자제하고 String의 split을 사용하라
	 */
    @Test
    public void testStringTokenizer() {
        StringTokenizer stringTokenizer = new StringTokenizer("aaa|bbb|ccc|", "|");
        while(stringTokenizer.hasMoreTokens()) {
            System.out.println(stringTokenizer.nextToken());
        }       
    }
    
}
