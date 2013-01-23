package util;

/**
 * @author kchung
 */
public class StringUtils {
	public static void main(String[] args) {
		System.out.println(removeDuplicates("aaabacdbe"));
	}
	public static String removeDuplicates(String s) {
		char[] chars = s.toCharArray();
		int end = 1;

		for (int i = 0; i < chars.length; i++){
			char currChar = chars[i];

			int j=0;
			for (; j < end; j++){//search upto end
				if (currChar == chars[j]) break;
			}

			if(j==end){//no dups found
				chars[end] = chars[i];
				end++;
			} else{//dup found; do nothing

			}
		}

		char[] noDups = new char[end];
		System.arraycopy(chars, 0, noDups, 0, end);
		return charArrayToString(noDups);
	}

	public static String charArrayToString(char[] array) {
		StringBuilder buffer = new StringBuilder(array.length);
		for (char c : array){
			if (c == 0){
				break;
			}
			buffer.append(c);
		}
		return buffer.toString();
	}
}
