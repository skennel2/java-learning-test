package org.almansa.app.java.date;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.Date;

import org.junit.Test;

public class DateAndLocalDateTimeTest {
	@Test
	public void Date클래스는_가변클래스() {
		DateWrapper wrapper = new DateWrapper(new Date(2019, 1, 22));
		Date date = wrapper.getDate();
		date.setYear(2018); // 데이터를 변경할 수 있는 setter를 노출한다.

		// 결론적으로는 이게 Date 클래스의 한계
		assertEquals(2018, wrapper.getDate().getYear());
	}

	@Test
	public void LocalDateTime은_불변클래스() {
		LocalDateWrapper localDateWrapper = new LocalDateWrapper(LocalDateTime.of(2019, 1, 22, 0, 0));
		
		// 여느 Immutable 클래스들 처럼 setter를 노출하지 않고 새로운 LocalDateTime를 반환한다.
		LocalDateTime localDateTime = localDateWrapper.getDate().plusMonths(1);
		
		assertEquals(1, localDateWrapper.getDate().getMonth().getValue());
	}

	public class LocalDateWrapper {
		private LocalDateTime date;

		public LocalDateWrapper(LocalDateTime date) {
			this.date = date;
		}

		public LocalDateTime getDate() {
			return date;
		}
	}

	public class DateWrapper {
		private Date date;

		public DateWrapper(Date date) {
			this.date = date;
		}

		public Date getDate() {
			return date;
		}
	}
}
