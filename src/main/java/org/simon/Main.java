package org.simon;

import org.simon.entity.German;
import org.simon.service.GermanService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GermanService servico = new GermanService();
        servico.addNumbers();

        System.out.println("Seja bem vindo ao quiz de alemão.");
        System.out.println("Vamos tentar acertar o máximo de questões possíveis:");
        System.out.println();

        int acertos = 0;
        int tentativas = 0;
        String resposta = "/";

        while(true){
            German g = servico.getRandomGerman();
            System.out.println(g.alemao);
            System.out.print("Resposta: ");
            resposta = scanner.nextLine();

            if(resposta.equals("0") || resposta.equals("")){
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
                System.out.printf("Resposta certa: %s\n", g.portugues);
                System.out.printf("%s/%s \n\n", acertos, tentativas);
            }
        }
        System.out.println("Programa encerrado.");
        System.out.printf("Nota: %s/%s \n\n", acertos, tentativas);
        scanner.close();
    }
}