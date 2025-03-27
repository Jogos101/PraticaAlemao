package org.simon;

import org.simon.controller.QuizController;
import org.simon.entity.Language;
import org.simon.service.LanguageService;
import org.simon.service.german.GermanService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QuizController game = new QuizController();

        System.out.println("Seja bem vindo ao quiz de línguas!");
        System.out.println();
        System.out.println("Escolha uma opção de jogo:");
        System.out.println("1- Alemão para português;");
        System.out.println("2- Português para alemão");
        System.out.print("- ");
        game.run(scanner.nextInt());
        scanner.close();
    }
}