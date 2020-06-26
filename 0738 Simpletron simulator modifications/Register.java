public class Register{
	private int instructionRegister;
	private int operationCode;
	private int operand;
	
	public Register() {
		this.instructionRegister = 0;
		this.operationCode = 0;
		this.operand = 0;
	}
	
	public void setRegister(int insReg) {
		this.instructionRegister = insReg;
		this.operationCode = insReg / 100;
		this.operand = insReg % 100;
	}
	
	public int getRegister() {
		return this.instructionRegister;
	}
	public int getOpCode() {
		return this.operationCode;
	}
	public int getOperand() {
		return this.operand;
	}
}