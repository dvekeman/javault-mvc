package hello;

import org.javault.VaultOutput;

public class SnippetOutput {
	private String sysout;
	private String syserr;
	private int statusCode;

	public SnippetOutput(VaultOutput vaultOutput) {
		this.sysout = vaultOutput.getSysout();
		this.syserr = vaultOutput.getSyserr();
		this.statusCode = vaultOutput.getStatusCode();
	}

	public SnippetOutput(Throwable t){
		this.syserr = t.getMessage();
		this.statusCode = -2;
		this.sysout = "";
	}

	public String getSysout() {
		return sysout;
	}

	public void setSysout(String sysout) {
		this.sysout = sysout;
	}

	public String getSyserr() {
		return syserr;
	}

	public void setSyserr(String syserr) {
		this.syserr = syserr;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	@Override
	public String toString() {
		return String.format("VaultOutpu(statusCode=%s, sysout=%s, syserr=%s)", statusCode, sysout, syserr);
	}
}
