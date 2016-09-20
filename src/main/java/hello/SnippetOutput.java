package hello;

import org.javault.VaultOutput;

public class SnippetOutput {
	private String output;
	private int statusCode;

	public SnippetOutput(VaultOutput vaultOutput) {
		this.output = vaultOutput.getOutput();
		this.statusCode = vaultOutput.getStatusCode();
	}

	public SnippetOutput(Throwable t){
		if(t.getCause() != null){
			this.output = t.getCause().getMessage();
		} else {
			this.output = t.getMessage();
		}
		this.statusCode = -2;
	}

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	@Override
	public String toString() {
		return String.format("VaultOutpu(statusCode=%s, sysout=%s, syserr=%s)", statusCode, output);
	}
}
