package org.almansa.app.java.enums;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EnumTest {

	enum YesNoCode{
		YES("Y"),
		NO("N");
		
		private final String code;
		
		YesNoCode(String code){
			this.code = code;
		}
		
		public String getCode() {
			return code;
		}
	}
	
	@Test
	public void Enum다뤄보기() {
		YesNoCode yes = YesNoCode.YES;		
		assertEquals("Y", yes.getCode());
	}
	
	@Test
	public void value로_모든_요소에_접근하기() {
		YesNoCode[] values = YesNoCode.values();
		assertEquals("Y", values[0].getCode());
		assertEquals("N", values[1].getCode());
	}
	
	public void valueOf_상수로_객체리턴받기() {
		YesNoCode yes = YesNoCode.valueOf("Y");
		
		assertEquals("Y", yes.getCode());
	}
}
