public class ExceptionA {

	public static void throwException()  {
		try {
			throw new Exception("Exception A");
		} catch (Exception e) {
			System.out.printf("This%n");
		}
		
	}
}