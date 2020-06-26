public class SomeClass{
	public SomeClass() {
		try {
			throw new Exception();
		} catch (Exception e) {
			System.out.println("Caught exception");
		}
	}
}