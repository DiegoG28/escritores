package escritores;

public class Book {
	private int words;

	public Book() {
		this.words = 0;
	}

	public int getWords() {
		return words;
	}

	public void setWords(int words) {
		this.words = this.words + words;
		if (this.words > 100) {
			this.words = 100;
		}
	}
}
