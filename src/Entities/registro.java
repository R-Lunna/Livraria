package Entities;

import java.util.ArrayList;

public class registro {
	ArrayList<livros> registro = new ArrayList<livros>();
	double priceRegistro;
	
	public registro() {
		
	}
	
	public double getPriceRegistro() {
		return priceRegistro;
	}
	
	public void armazenaRegistro(ArrayList<livros> carrinho, double price) {
		int i = 0;
		while (carrinho.size() - 1 >= i) {
			registro.add(carrinho.get(i));
			i++;
		}
		this.priceRegistro += price;
	}
	
	public void printRegistro(ArrayList<Integer> quantidade) {
		int i = 0, y = 0, z = 1;
		double price = 0;
		System.out.println("Número de livros comprados: " + registro.size());
		while (registro.size() - 1 >= i) {
			
			System.out.println("Título: " + registro.get(i).getTittle());
			System.out.println("Descrição: " + registro.get(i).getDescrition());
			System.out.println("Autor: " + registro.get(i).getAuthor());
			System.out.println("ISBN: " + registro.get(i).getIsbn());
			System.out.println("Preço: $" + registro.get(i).getPrice() + " reais");
			price += registro.get(i).getPrice();
			if (quantidade.get(y) == z) {
				System.out.println("Valor total da compra acima: $" + price + "reais");
				price = 0;
				y++;
				z = 0;
			}
			System.out.println();
			z++;
			i++;
		}
		
		System.out.printf("Preço total de todas as compras: $" + priceRegistro + "reais");
	}
}
