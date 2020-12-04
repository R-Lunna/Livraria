package Entities;

import java.util.ArrayList;

public class livros {
	private String isbn;
	private String tittle;
	private String descrition;
	private String author;
	private double price;
	private livros obj;
	ArrayList<livros> livros = new ArrayList<livros>();
	
	public String getIsbn() {
		return isbn;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public String getTittle() {
		return tittle;
	}
	
	public void setTittle(String tittle) {
		this.tittle = tittle;
	}
	
	public String getDescrition() {
		return descrition;
	}
	
	public void setDescrition(String descrition) {
		this.descrition = descrition;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public ArrayList<livros> getLivros() {
		return livros;
	}
	
	public void insertLivros() {
		this.obj = new livros();
		obj.setTittle("Game of Thrones");
		obj.setDescrition("Uma história no mundo medieval, com dragões, reis e rainhas...");
		obj.setAuthor("Jorge Martins");
		obj.setIsbn("123-1-11-123456-1");
		obj.setPrice(50.00);
		livros.add(obj);
		
		obj = new livros();
		obj.setTittle("A menina que roubava livros");
		obj.setDescrition("Uma história de uma pequena garota que viveu na época da segunda guerra mundial...");
		obj.setAuthor("Markus Zusak");
		obj.setIsbn("321-3-12-432112-0");
		obj.setPrice(45.90);
		livros.add(obj);
		
		obj = new livros();
		obj.setTittle("Harry Potter - relíquias da morte");
		obj.setDescrition("A história gira em torno de um pequeno jovem bruxo, que perdeu os seus pais quando pequeno...");
		obj.setAuthor("J. K. Rowling");
		obj.setIsbn("567-2-85-985767-9");
		obj.setPrice(23.70);
		livros.add(obj);
		
		obj = new livros();
		obj.setTittle("20 mil léguas submarinas");
		obj.setDescrition("É uma das obras literárias mais famosas do escritor Júlio Verne...");
		obj.setAuthor("Júlio Verne");
		obj.setIsbn("435-9-23-823462-7");
		obj.setPrice(60.40);
		livros.add(obj);
		
		obj = new livros();
		obj.setTittle("Harry Potter - ordem da fenix");
		obj.setDescrition("A história gira em torno de um pequeno jovem bruxo, que perdeu os seus pais quando pequeno...");
		obj.setAuthor("J. K. Rowling");
		obj.setIsbn("567-2-85-985767-9");
		obj.setPrice(80.75);
		livros.add(obj);
	}
	
	public ArrayList<Integer> ChecksLivro(String tittle) {
		ArrayList<Integer> position = new ArrayList<Integer>();
		int i = 0;
		while (livros.size() - 1 >= i) {
			if (livros.get(i).getTittle().toUpperCase().contains(tittle.toUpperCase())) position.add(i);	
			i++;
		}
		return position;
	}
}
