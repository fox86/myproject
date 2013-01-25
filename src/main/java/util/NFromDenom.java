package util;

import java.util.Map;
import java.util.TreeMap;

import com.google.common.base.Joiner;

/**
 * @author kchung
 */
public class NFromDenom {
	public static enum Denom{
		QUARTER(25), DIME(10), NICKEL(5), PENNY(1);

		int amt;

		private Denom(int amt){
			this.amt = amt;
		}

		public int getAmt(){
			return amt;
		}
	}

	public static void main(String[] args) {
		fillN(50, Denom.QUARTER, new TreeMap<Denom, Integer>());
	}

	public static void fillN(int N, Denom denom, Map<Denom, Integer> denomCount){
		if(N == 0){
			print(denomCount);
		} else if(denom == Denom.PENNY){
			denomCount.put(denom, N);
			fillN(0, denom, denomCount);
			denomCount.remove(denom);
		} else{
			for (int i = 0; (i * denom.getAmt()) <= N; i++){
				Denom nextDenom = getNextDenom(denom);
				denomCount.put(denom, i);
				fillN(N - (i * denom.getAmt()), nextDenom, denomCount);
				denomCount.remove(denom);
			}
		}
	}

	private static void print(Map<Denom, Integer> denomCount) {
		String join = Joiner.on("; ").withKeyValueSeparator("=").join(denomCount);
		System.out.println(join);
	}

	public static Denom getNextDenom(Denom denom){
		switch(denom){
		case QUARTER:
			return Denom.DIME;
		case DIME:
			return Denom.NICKEL;
		case NICKEL:
			return Denom.PENNY;
		case PENNY:
			return Denom.PENNY;
		default:
			return null;
		}
	}
}
