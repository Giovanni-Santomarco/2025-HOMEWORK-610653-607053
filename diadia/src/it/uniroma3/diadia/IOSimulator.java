package it.uniroma3.diadia;

public class IOSimulator implements IO {
	
	private String[] input;
	private int inputIndex;
	
	public IOSimulator(String[] input) {
		this.input = input;
		this.inputIndex=0;
	}
	
	@Override
	public void mostraMessaggio(String msg) {
		System.out.println(msg);
	}

	@Override
	public String leggiRiga() {
		if(inputIndex<input.length)
			return input[inputIndex++];
		return null;
	}
	
}
