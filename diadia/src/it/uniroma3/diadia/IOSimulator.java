package it.uniroma3.diadia;

import java.util.ArrayList;
import java.util.List;

public class IOSimulator implements IO {

//	private String[] input;
	private int inputIndex;
//	private String[] output;
//	private int outputIndex;
	
	private List<String> input;
	private List<String> output;


	public IOSimulator(List<String> input) {
//		this.input = input;
		this.inputIndex=0;
//		this.output = new String[input.length+2];
//		this.outputIndex=0;
		this.input = input;
		this.output = new ArrayList<>();
		
	}

	@Override
	public void mostraMessaggio(String msg) {
//		if(outputIndex>output.length) 
//			return;
//		output[outputIndex++]=msg;
//		System.out.println(msg);
		
		output.add(msg);
	}

	@Override
	public String leggiRiga() {
		if(inputIndex<input.size())
			return input.get(inputIndex++);
		return "";
	}

	public List<String> getOutput() {
		return output;
	}
}
