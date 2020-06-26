public class ExceptionA extends Exception{
	public ExceptionA() throws ExceptionA {
		throw new ExceptionA();
	}
}