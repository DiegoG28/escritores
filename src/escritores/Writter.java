package escritores;

public class Writter extends Thread {
	String name;
	Boolean isFirstTurn;
	Book book;

	public Writter(String name, Book book) {
		this.name = name;
		this.book = book;
		this.isFirstTurn = false;
	}

	public Writter(String name, Boolean isFirstTurn, Book book) {
		this.name = name;
		this.book = book;
		this.isFirstTurn = isFirstTurn;
	}

	public void run() {
		while (book.getWords() < 100) {
			try {
				if (!isFirstTurn) {
					synchronized (book) {
						book.wait();
					}
				}
				if (book.getWords() >= 100) {
					return;
				}
				synchronized (book) {
					int wordsWritten = (int) (Math.floor(Math.random() * 3) + 1);
					int initalWords = book.getWords();
					book.setWords(wordsWritten);
					int finalWords = book.getWords();
					isFirstTurn = false;
					System.out.println(name + " wrote from " + initalWords + " to " + finalWords + " words.");
					book.notifyAll();
				}
			} catch (Exception e) {
			}
		}
	}
}
