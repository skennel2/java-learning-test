package org.almansa.app.java.date;

import static org.junit.Assert.assertEquals;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;

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
	
	@Test
	public void 날짜연산하기() {
		LocalDate localDate = LocalDate.of(2019, 1, 1);
		localDate = localDate.minus(Period.ofYears(1));
		
		assertEquals(LocalDate.of(2018, 1, 1), localDate);
		
		localDate = LocalDate.of(2019, 1, 1);
		localDate = localDate.minus(Period.ofDays(1));
		
		assertEquals(LocalDate.of(2018, 12, 31), localDate);
	}
	
	@Test
	public void 날짜비교하기() {
		LocalDate localDate = LocalDate.of(2019, 1, 1);
		
		boolean isBefore = localDate.isBefore(LocalDate.of(2019, 1, 2));
		
		assertEquals(true, isBefore);		
	}
	
	@Test
	public void 날짜조정하기() {
		// 해당 달의 마지막날 가져오기
		LocalDate localDate = LocalDate.of(2019, 2, 15);		
		localDate = localDate.with(TemporalAdjusters.lastDayOfMonth());		
		assertEquals(LocalDate.of(2019, 2, 28), localDate);
		
		// 해당 날짜의 달만 바꾸기, 일자로 마지막날에 맞춰서 자동조정됨 
		localDate = LocalDate.of(2019, 3, 31).withMonth(2);
		assertEquals(LocalDate.of(2019,  2, 28), localDate);
	}
	
	@Test(expected = DateTimeException.class)
	public void 유효하지_않은_날짜를_만든다면() {
		LocalDate localDate = LocalDate.of(2019, 2, 32);				
	}

	@Test
	public void 문자열로부터_파싱하기() {
		String source = "20190626";
		
		LocalDate localDate = LocalDate.parse(source, DateTimeFormatter.ofPattern("yyyyMMdd"));		
		assertEquals(LocalDate.of(2019, 6, 26), localDate);
	}
	
	@Test
	public void 문자열로부터_파싱하기2() {
		String source = "2019-06-26";
		
		LocalDate localDate = LocalDate.parse(source, DateTimeFormatter.ofPattern("yyyy-MM-dd"));		
		assertEquals(LocalDate.of(2019, 6, 26), localDate);
	}
	
	@Test
	public void 문자열로_리턴하기() {	
		LocalDate localDate = LocalDate.of(2019, 6, 26);
		
		String str = localDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		
		assertEquals("2019-06-26", str);
	}
	
	@Test
	public void Date_to_LocalDate() {	
		Calendar calendar = Calendar.getInstance();
		calendar.set(2019, 4, 15); // Month는 0 부터 ㅅㅂ

		Date now = calendar.getTime();
		LocalDate converted = now.toInstant().atZone(ZoneId.systemDefault())
	      .toLocalDate();
		
		assertEquals(LocalDate.of(2019, 5, 15), converted);
	}
}
