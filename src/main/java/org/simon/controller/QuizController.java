package org.simon.controller;

import org.simon.entity.Language;
import org.simon.service.LanguageService;
import org.simon.service.german.GermanService;

import java.util.Scanner;

public class QuizController {
    Scanner scanner;
    LanguageService servico;
    int acertos;
    int tentativas;
    int tipo;

    public QuizController() {
        this.acertos = 0;
        this.tentativas = 0;
        this.tipo = 0;
    }

    public void run(int option) {
        switch (option) {
            case 1:
                GermanToPortuguese();
                break;
            case 2:
                PortugueseToGerman();
                break;
            default:
                System.out.println("Opção inválida. Fechando o jogo...");
                break;
        }
    }

    private void PortugueseToGerman() {
        scanner = new Scanner(System.in);
        servico = new GermanService();
        boolean continuar = true;
        this.tipo = 2;
        String translation;
        String original;
        Language g;

        System.out.println("\nVocê escolheu o quiz de portugues para alemão!\n");

        servico.addNumbers();

        System.out.println("Vamos tentar acertar o máximo de questões possíveis:\n");
        while(continuar){
            g = servico.getRandomWord();
            translation = g.getTrasnlation();
            original = g.getOriginal();
            continuar = Quiz(g, translation, original);
        }
        System.out.println("Programa encerrado.");
        System.out.printf("Nota: %s/%s \n\n", acertos, tentativas);
        scanner.close();
    }

    private void GermanToPortuguese() {
        scanner = new Scanner(System.in);
        servico = new GermanService();
        boolean continuar = true;
        this.tipo = 3;
        String translation;
        String original;
        Language g;

        System.out.println("Você escolheu o quiz de alemão para portugues!");

        servico.addNumbers();

        System.out.println("Vamos tentar acertar o máximo de questões possíveis:\n");
        while(continuar){
            g = servico.getRandomWord();
            translation = g.getOriginal();
            original = g.getTrasnlation();
            continuar = Quiz(g, translation, original);
        }
        System.out.println("Programa encerrado.");
        System.out.printf("Nota: %s/%s \n\n", acertos, tentativas);
        scanner.close();
    }

    private boolean Quiz(Language g, String translation, String original) {
        String resposta;

        System.out.println(translation);
        System.out.print("Resposta: ");
        resposta = scanner.nextLine();

        if(resposta.isEmpty()){
            return false;
        }else if(servico.testeResposta(resposta, g, tipo)){
            this.tentativas++;
            this.acertos++;
            System.out.println("Acertou!");
            System.out.printf("%s/%s \n\n", acertos, tentativas);
        }else{
            this.tentativas++;
            System.out.println("Errou...");
            System.out.printf("Você respondeu: %s\n", resposta);
            System.out.printf("Resposta certa: %s\n", original);
            System.out.printf("%s/%s \n\n", acertos, tentativas);
        }
        return true;
    }
}
