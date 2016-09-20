package hello;

public class SnippetForm {
	private String snippet;

	public String getSnippet() {
		return snippet;
	}

	public void setSnippet(String snippet) {
		this.snippet = snippet;
	}

	@Override
	public String toString() {
		return String.format("SnippetForm(snippet=%s))", snippet);
	}
}
