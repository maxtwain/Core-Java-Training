

public class Source{
	public static void main(String[] args) {
		String a = "blahdnfe";
		int b = '1' - 48;
		String c = "234532345";
		int d = c.charAt(3) - 48;
		
		
		int[] e = new int[10];
		e[0] = 1;
		e[1] = 2;
		String f = "";
		
		int i = e.length - 1;
		for (; e[i] == 0; --i) {}
		
		for (; i >= 0; --i) {
			f += e[i];
		}
		
		System.out.printf("%c%n", a.charAt(3));
		System.out.printf("a length = %d%n", a.length());
		System.out.printf("b = %d%n", b);
		System.out.printf("d = %d%n", d);
		System.out.printf("f = %s%n", f);
		System.out.printf("a.charAt(20) = %c%n", a.length() >= 20 ? a.charAt(20) : ' ');
	}
}