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
		System.out.println("Livros dispon�veis no momento para compra: ");
		while (livros.size() - 1 >= i) {
			System.out.println("T�tulo: " + livros.get(i).getTittle());
			System.out.println("Descri��o: " + livros.get(i).getDescrition());
			System.out.println("Autor: " + livros.get(i).getAuthor());
			System.out.println("ISBN: " + livros.get(i).getIsbn());
			System.out.println("Pre�o: $" + livros.get(i).getPrice() + " reais");
			System.out.println();
			i++;
		}
		
		String x;
		do {

			String tittle;
			ArrayList<livros> carrinho = new ArrayList<livros>();
			do {
				
				ArrayList<Integer> position = encontraLivro(sc, obj);
				for (int z = 0; z < position.size(); z++) {
					System.out.println((z + 1) + "- T�tulo: " + livros.get(position.get(z)).getTittle());
					System.out.println("Descri��o: " + livros.get(position.get(z)).getDescrition());
					System.out.println("Autor: " + livros.get(position.get(z)).getAuthor());
					System.out.println("ISBN: " + livros.get(position.get(z)).getIsbn());
					System.out.println("Pre�o: $" + livros.get(position.get(z)).getPrice() + " reais");
					System.out.println();
				}
				
				if (position.size() == 1) {
					System.out.println("Deseja adicionar o livro? s ou n");
					String adicionar = sc.nextLine();
					if (adicionar.toUpperCase().contains("s".toUpperCase())) {
						carrinho.add(livros.get(position.get(0)));
					}
				} else {
					System.out.println("Encontramos os seguintes livros, escolha o n�mero do livro de sua prefer�ncia: ");
					int escolha = sc.nextInt();
					carrinho.add(livros.get(position.get(escolha - 1)));
				}
			
				System.out.println("Deseja adicionar um novo livro ao carrinho? digite s ou n");
				sc = new Scanner(System.in);
				x = sc.nextLine();
			} while (x.contains("s"));
		
			System.out.println("Os livros escolhidos por voc� s�o: ");
			i = 0;
			double price = 0;
			while (carrinho.size() - 1 >= i) {
				System.out.println("T�tulo: " + carrinho.get(i).getTittle());
				System.out.println("Descri��o: " + carrinho.get(i).getDescrition());
				System.out.println("Autor: " + carrinho.get(i).getAuthor());
				System.out.println("ISBN: " + carrinho.get(i).getIsbn());
				System.out.println("Pre�o: $" + carrinho.get(i).getPrice() + " reais");
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
				
				if (check == false) System.out.println("Esse livro n�o foi encontrado no seu carrinho, podendo j� ter sido removido!!"); 
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
	
	public static ArrayList<Integer> encontraLivro(Scanner sc, livros obj) {
		String tittle;
		System.out.println("Digite o t�tulo do livro que deseja comprar: ");
		tittle = sc.nextLine();
		ArrayList<Integer> position = obj.ChecksLivro(tittle);
		
		if (position.size() == 0) {
			System.out.println("Livro n�o encontrado!!");
			return encontraLivro(sc, obj);
		}
		return position;
	}
}
