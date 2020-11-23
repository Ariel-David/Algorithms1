package Compiler;

public class Program {
	String name;
	int len;
	int freq;

	public Program(String name, int len , int freq) {
		this.name = name;
		this .len = len;
		this.freq = freq;
	}
	
	@Override
	public String toString() {
		return "[" + name + " ," + len + " ," + freq + "]";
	}
}
