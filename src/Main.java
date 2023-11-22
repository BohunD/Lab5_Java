import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text: ");
        String userInput = scanner.nextLine();

        TextProcessor textProcessor = new TextProcessor();

        if (textProcessor.isValidInput(userInput)) {
            List<Sentence> sentences = textProcessor.extractSentences(userInput);

            Text text = new Text(sentences);

            textProcessor.sortWordsByVowelsCount(text);

            System.out.println("Sorted words:");
            System.out.println(text);
        } else {
            System.out.println("Invalid input. Please enter a valid text.");
        }

        scanner.close();
    }



}
