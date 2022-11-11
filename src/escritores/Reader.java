package escritores;

public class Reader extends Thread {
	String name;
	private int wordsRead;
	Book book;

	public Reader(String name, Book book) {
		this.name = name;
		this.wordsRead = 0;
		this.book = book;
	}

	public void run() {
		while (getWordsRead() < 100) {
			try {
				synchronized (book) {
					book.wait();
				}
				int initialWordsRead = getWordsRead();
				int finalWordsRead = book.getWords();
				setWordsRead(book.getWords());
				synchronized (book) {
					if (initialWordsRead == finalWordsRead) {
						System.out.println(name + " tried to read but there were not words available.");
					} else {
						System.out
								.println(name + " read from " + initialWordsRead + " to " + finalWordsRead + " words.");
					}
					book.notifyAll();
				}
			} catch (Exception e) {

			}
		}
	}

	public int getWordsRead() {
		return wordsRead;
	}

	public void setWordsRead(int wordsRead) {
		this.wordsRead = wordsRead;
		if (this.wordsRead > 100) {
			this.wordsRead = 100;
		}
	}

}
