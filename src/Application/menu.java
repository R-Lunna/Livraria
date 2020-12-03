package Application;

import java.util.ArrayList;
import java.util.Scanner;

import Entities.livros;
import Entities.registro;

public class menu {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		livros obj = new livros();
		obj.insertLivros();
		
		ArrayList<livros> livros = new ArrayList<livros>();
		livros = obj.getLivros();
		
		registro registro = new registro();
		ArrayList<Integer> quantidade = new ArrayList<Integer>();
		
		int i = 0;
		System.out.println("Livros disponíveis no momento para compra: ");
		while (livros.size() - 1 >= i) {
			System.out.println("Título: " + livros.get(i).getTittle());
			System.out.println("Descrição: " + livros.get(i).getDescrition());
			System.out.println("Autor: " + livros.get(i).getAuthor());
			System.out.println("ISBN: " + livros.get(i).getIsbn());
			System.out.println("Preço: $" + livros.get(i).getPrice() + " reais");
			System.out.println();
			i++;
		}
		
		String x;
		do {

			String tittle;
			ArrayList<livros> carrinho = new ArrayList<livros>();
			do {
				System.out.println("Digite o título do livro que deseja comprar: ");
				tittle = sc.nextLine();
				i = obj.ChecksLivro(tittle);
				if (i >= 0) carrinho.add(livros.get(i));
				
				
				System.out.println("Deseja adicionar um novo livro ao carrinho? digite s ou n");
				x = sc.nextLine();
			} while (x.contains("s"));
		
			System.out.println("Os livros escolhidos por você são: ");
			i = 0;
			double price = 0;
			while (carrinho.size() - 1 >= i) {
				System.out.println("Título: " + carrinho.get(i).getTittle());
				System.out.println("Descrição: " + carrinho.get(i).getDescrition());
				System.out.println("Autor: " + carrinho.get(i).getAuthor());
				System.out.println("ISBN: " + carrinho.get(i).getIsbn());
				System.out.println("Preço: $" + carrinho.get(i).getPrice() + " reais");
				System.out.println();
				price += carrinho.get(i).getPrice();
				i++;
			}
			
			System.out.println("Valor total da compra: $" + price + "reais");
			
			System.out.println("Deseja remover algum livro do seu carrinho? digite s ou n");
			x = sc.nextLine();
			
			i = 0;
			boolean check = false;
			while (x.contains("s")) {
				System.out.println("Digite o nome do livro que deseja remover: ");
				tittle = sc.nextLine();
				
				while (carrinho.size() - 1 >= i) {
					if (carrinho.get(i).getTittle().contains(tittle)) {
						price -= carrinho.get(i).getPrice();
						carrinho.remove(i);
						check = true;
					}
					i++;
				}
				
				if (check == false) System.out.println("Esse livro não foi encontrado no seu carrinho, podendo já ter sido removido!!"); 
				System.out.println("Deseja remover um novo livro? digite s ou n");
				x = sc.nextLine();
				
				if (x.contains("n")) System.out.printf("Novo valor total da compra: $%.2f", price, "reais\n");
			}
			
			System.out.println("Finalizar compra? s ou n");
			x = sc.nextLine();
			
			if (x.contains("sim")) System.out.println("Compra finalizada com sucesso!!!");
			
			quantidade.add(carrinho.size());
			
			registro.armazenaRegistro(carrinho, price);
			
			System.out.println("Deseja efetuar uma nova compra? s ou n");
			x = sc.nextLine();
		} while (x.contains("s"));
		
		registro.printRegistro(quantidade);
		sc.close();
	}
}
