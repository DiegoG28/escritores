package escritores;

public class Main {

	public static void main(String[] args) {
		Book book = new Book();

		Reader reader1 = new Reader("Reader 1", book);
		Reader reader2 = new Reader("Reader 2", book);
		Reader reader3 = new Reader("Reader 3", book);

		Writter writter1 = new Writter("Writter 1", true, book);
		Writter writter2 = new Writter("Writter 2", book);
		Writter writter3 = new Writter("Writter 3", book);
		Writter writter4 = new Writter("Writter 4", book);
		Writter writter5 = new Writter("Writter 5", book);

		reader1.start();
		reader2.start();
		reader3.start();

		writter1.start();
		writter2.start();
		writter3.start();
		writter4.start();
		writter5.start();
	}

}
