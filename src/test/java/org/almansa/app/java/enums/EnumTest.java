package org.almansa.app.java.enums;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EnumTest {

	enum YesNoCode{
		YES("Y"),
		NO("N");
		
		private String code;
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
	
}
