package projetochekin;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import Modelos.Convidado;

public class ControleEntrada {

	public static void main(String[] args) throws IOException  {
		String nome, res = "sim",res2;
		int dtnasc, idade;
		ArrayList<Convidado> conv = new ArrayList<Convidado>();
		ArrayList<Convidado> convpermitidos = new ArrayList<Convidado>();
		ArrayList<Convidado> convbarrados = new ArrayList<Convidado>();
		
		Scanner teclado = new Scanner(System.in);
		
		LocalDateTime agora = LocalDateTime.now();
		 int ano0 = agora.getYear();
		
		 while (res.contentEquals("sim")) {
		 
		//System.out.println("Insira o ano em que acontece o evento :");
		//ano = teclado.nextInt();
		
		System.out.println("Insira o nome do convidado :");
		nome = teclado.next();
		
		System.out.println("Insira o ano de nascimento do convidado :");
		dtnasc = teclado.nextInt();
		
		idade = ano0 - dtnasc;
		
		FileWriter fw = new FileWriter("convidados.txt",true);
		fw.write("\n\t\t LISTA DE CONVIDADOS");
		fw.write("\nNome : "+nome+"     --------------- Idade : "+idade);
		fw.close();
		
		
		Convidado convidado = new Convidado(nome,idade);
		if (idade < 18) {
			System.out.println(nome + " infelizmente você não pode entrar por ter " + idade + " anos");
			convbarrados.add(convidado);
			conv.add(convidado);
			
		}else {
			System.out.println("Entrada permitida, divirta-se " + nome);
			convpermitidos.add(convidado);
			conv.add(convidado);
		}
		System.out.println("\n\nCadastrar novo convidado? [sim] [não]");
		res = teclado.next();
		System.out.println("\n");
		 
		
		
	
		 }
		 int res2int = 0;
		while (res2int!=4) {
		 System.out.println("\n\nTecle:\n1 para ver a lista geral\n2 para ver a lista de convidados que entraram\n3 para ver a lista de convidados barrados\n4 para encerrar");
		 res2 = teclado.next();
		 res2int = Integer.parseInt(res2);
		 if(res2.contentEquals("1")) {
			 System.out.println("\t\tLista de convidados");
		        for(int i = 0; i < conv.size(); i++) {
		            System.out.println("\nNome : "+conv.get(i).getNome()+" -------  Idade : "+conv.get(i).getIdade());

		        }
		 }
		 if(res2.contentEquals("2")) {
			 	System.out.println("\t\tLista de convidados que entraram");
		        for(int i = 0; i < convpermitidos.size(); i++) {
		            System.out.println("\nNome : "+convpermitidos.get(i).getNome()+" -------  Idade : "+convpermitidos.get(i).getIdade());

		        }
		 }
		 if(res2.contentEquals("3")) {
		     System.out.println("\t\tLista de convidados barrados");  
			 for(int i = 0; i < convbarrados.size(); i++) {
		            System.out.println("\nNome : "+convbarrados.get(i).getNome()+" -------  Idade : "+convbarrados.get(i).getIdade());

		        }
		 }
		 if(res2.contentEquals("4")) {
			 System.exit(0);
		 }
		}
		 
		 teclado.close();
	}
	}


