package org.almansa.app.java.enums;

/*
 * 참고 이펙티브 자바
 */
public class EnumSpecificMethodImplematationTest {

	enum Operation {
		PLUS("+") {
			@Override
			public double apply(double x, double y) {
				return x + y;
			}
		},
		MINUS("-") {
			@Override
			public double apply(double x, double y) {
				return x - y;
			}
		},
		TIMES("*") {
			@Override
			public double apply(double x, double y) {
				return x * y;
			}
		},
		DIVIDE("/") {
			@Override
			public double apply(double x, double y) {
				return x / y;
			}
		};
		
		private final String symbol;
		
		Operation(String symbol){
			this.symbol = symbol;
		}
		
		public String getSymbol() {
			return symbol;
		}
		
		public abstract double apply(double x, double y);
	}
}
