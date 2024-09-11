package br.edu.fatecpg.Maven;

import br.edu.fatecpg.Maven.Model.Carro;
import br.edu.fatecpg.Maven.Service.ConsomeApi;
import br.edu.fatecpg.Maven.Service.ConverteDado;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Scanner;

@SpringBootApplication
public class MavenApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(MavenApplication.class, args);
	}
	public static final String BASE_URL = "https://parallelum.com.br/fipe/api/v1/carros/marcas";

	@Override
	public void run(String... args) throws Exception {
		Scanner scan = new Scanner(System.in);
		ConverteDado convesor = new ConverteDado();

		while (true) {
			System.out.println("\n1. Buscar Carro");
			System.out.println("2. Sair");
			System.out.print("\nEscolha uma opção:");
			int opcao = scan.nextInt();
			scan.nextLine();

			switch (opcao) {

				case 1:
					String json = ConsomeApi.consome(BASE_URL);
					System.out.println(json);
					System.out.println("Digite o código do carro: ");
					int codMarca = scan.nextInt();
					String json1 = ConsomeApi.consome(BASE_URL + "/" + codMarca + "/modelos");
					System.out.println(json1);

					System.out.println("\nDigite o código do modelo: ");
					int codModelo = scan.nextInt();
					String json2 = ConsomeApi.consome(BASE_URL + "/" + codMarca + "/modelos" + "/" + codModelo + "/" + "anos");
					System.out.println(json2);

					System.out.println("\nDigite o Ano: ");
					String codAnos = scan.next();
					String json3 = ConsomeApi.consome(BASE_URL + "/" + codMarca + "/modelos" + "/" + codModelo + "/" + "anos" + "/" + codAnos);
					Carro carro = convesor.consome(json3, Carro.class);
					System.out.println(carro);
					break;

				case 2: {
					System.out.println("Saindo...");
					return;
				}
				default: System.out.println("Opção inválida.");

			}

		}
	}
}