package org.simon;

import org.simon.entity.Language;
import org.simon.service.german.GermanPortugueseService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GermanPortugueseService servico = new GermanPortugueseService();
        servico.addNumbers();

        System.out.println("Seja bem vindo ao quiz de alemão.");
        System.out.println("Vamos tentar acertar o máximo de questões possíveis:");
        System.out.println();

        int acertos = 0;
        int tentativas = 0;
        String resposta = "/";

        while(true){
            Language g = servico.getRandomWord();
            System.out.println(g.getOriginal());
            System.out.print("Resposta: ");
            resposta = scanner.nextLine();

            if(resposta.equals("0") || resposta.isEmpty()){
                break;
            }else if(servico.testeResposta(resposta, g)){
                tentativas++;
                acertos++;
                System.out.println("Acertou!\n");
                System.out.printf("%s/%s \n\n", acertos, tentativas);
            }else{
                tentativas++;
                System.out.println("Errou...");
                System.out.printf("Você respondeu: %s\n", resposta);
                System.out.printf("Resposta certa: %s\n", g.getTrasnlation());
                System.out.printf("%s/%s \n\n", acertos, tentativas);
            }
        }
        System.out.println("Programa encerrado.");
        System.out.printf("Nota: %s/%s \n\n", acertos, tentativas);
        scanner.close();
    }
}