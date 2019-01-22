package org.almansa.app.java.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.Test;

public class TimePackageClassTest {
	@Test
	public void 시간을_표현하는새로운_클래스들() {
		// LocalDate는 연월일까지 표한한다.
		LocalDate localDate = LocalDate.of(2019, 1, 2);
		
		// LocalTime은 시 분 초 나노초 까지 표현한다.
		LocalTime localTime = LocalTime.of(23, 0, 59);
		
		// LocalDateTime은 연 월 일 시 분 초 나노초까지 표현한다.
		LocalDateTime localDateTime = LocalDateTime.of(2019, 1, 22, 12, 0, 59);			
	}
}
