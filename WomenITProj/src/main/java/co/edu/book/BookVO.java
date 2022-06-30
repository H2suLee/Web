package co.edu.book;

public class BookVO {
	private String no, name, writer, publisher;
	private int price;

	public String getNo() {
		return no;
	}

	public String getName() {
		return name;
	}

	public String getWriter() {
		return writer;
	}

	public String getPublisher() {
		return publisher;
	}

	public int getPrice() {
		return price;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
