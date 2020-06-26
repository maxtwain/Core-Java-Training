

enum Season {
	spring,
	summer,
	fall,
	winter;
}

public class Source{
	public static void main(String[] args) {
		Season s = Season.spring;
		
		System.out.printf("%s%n", s);
	}
}