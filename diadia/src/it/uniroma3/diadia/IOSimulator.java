package it.uniroma3.diadia;

public class IOSimulator implements IO {

	private String[] input;
	private int inputIndex;
	private String[] output;
	private int outputIndex;


	public IOSimulator(String[] input) {
		this.input = input;
		this.inputIndex=0;
		this.output = new String[input.length+2];
		this.outputIndex=0;
	}

	@Override
	public void mostraMessaggio(String msg) {
		if(outputIndex>output.length) 
			return;
		output[outputIndex++]=msg;
//		System.out.println(msg);
	}

	@Override
	public String leggiRiga() {
		if(inputIndex<input.length)
			return input[inputIndex++];
		return "";
	}

	public String[] getOutput() {
		return output;
	}
}
