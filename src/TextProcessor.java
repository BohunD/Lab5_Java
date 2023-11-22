import java.util.ArrayList;
import java.util.List;

/**
 * The TextProcessor class provides functionality for processing and analyzing text.
 */
class TextProcessor {
    /**
     * Sorts words in each sentence of the given Text object based on the count of vowels in each word.
     *
     * @param text The Text object to process.
     */
    public void sortWordsByVowelsCount(Text text) {
        List<Word> allWords = new ArrayList<>();

        for (Sentence sentence : text.getSentences()) {
            allWords.addAll(sentence.getWords());
        }

        allWords.sort((word1, word2) -> {
            int vowelsCount1 = countVowels(word1);
            int vowelsCount2 = countVowels(word2);
            return Integer.compare(vowelsCount1, vowelsCount2);
        });

        int wordIndex = 0;
        for (Sentence sentence : text.getSentences()) {
            List<Word> sortedWords = allWords.subList(wordIndex, wordIndex + sentence.getWords().size());
            sentence.getWords().clear();
            sentence.getWords().addAll(sortedWords);
            wordIndex += sentence.getWords().size();
        }
    }

    /**
     * Checks if the input string is valid, i.e., not null and not empty after trimming.
     *
     * @param userInput The input string to validate.
     * @return True if the input is valid, false otherwise.
     */
    public boolean isValidInput(String userInput) {
        // Check if the input is not null, not empty
        return userInput != null && !userInput.trim().isEmpty();
    }

    /**
     * Extracts sentences from the given input string.
     *
     * @param userInput The input string containing sentences.
     * @return A list of Sentence objects extracted from the input string.
     */
    public List<Sentence> extractSentences(String userInput) {
        List<Sentence> sentences = new ArrayList<>();
        String[] sentenceArray = userInput.split("[.!?]+");

        for (String sentence : sentenceArray) {
            List<Word> wordsInSentence = extractWords(sentence);
            List<PunctuationMark> punctuationMarksInSentence = extractPunctuationMarks(sentence);

            Sentence s = new Sentence(wordsInSentence, punctuationMarksInSentence);
            sentences.add(s);
        }

        return sentences;
    }

    /**
     * Extracts words from the given sentence string.
     *
     * @param sentence The input sentence string.
     * @return A list of Word objects extracted from the sentence.
     */
    public List<Word> extractWords(String sentence) {
        List<Word> words = new ArrayList<>();
        String[] wordArray = sentence.split("\\s+");

        for (String word : wordArray) {
            String cleanedWord = removePunctuationAndNumbers(word);
            if (!cleanedWord.isEmpty()) {
                List<Letter> letters = extractLetters(cleanedWord);
                Word w = new Word(letters);
                words.add(w);
            }
        }

        return words;
    }

    /**
     * Extracts letters from the given word string.
     *
     * @param word The input word string.
     * @return A list of Letter objects extracted from the word.
     */
    public List<Letter> extractLetters(String word) {
        List<Letter> letters = new ArrayList<>();
        char[] charArray = word.toCharArray();

        for (char c : charArray) {
            letters.add(new Letter(c));
        }

        return letters;
    }

    /**
     * Removes punctuation marks and numbers from the input string.
     *
     * @param input The input string to clean.
     * @return The input string without punctuation marks and numbers.
     */
    public String removePunctuationAndNumbers(String input) {
        return input.replaceAll("[^а-яА-Яa-zA-Z]", "");
    }

    /**
     * Extracts punctuation marks from the given sentence string.
     *
     * @param sentence The input sentence string.
     * @return A list of PunctuationMark objects extracted from the sentence.
     */
    public List<PunctuationMark> extractPunctuationMarks(String sentence) {
        List<PunctuationMark> punctuationMarks = new ArrayList<>();
        char[] charArray = sentence.toCharArray();

        for (char c : charArray) {
            if (Character.toString(c).matches("[.,!?]")) {
                punctuationMarks.add(new PunctuationMark(c));
            }
        }

        if (!punctuationMarks.isEmpty() && punctuationMarks.get(punctuationMarks.size() - 1).toString().matches("[.,!?]")) {
            punctuationMarks.remove(punctuationMarks.size() - 1);
        }

        return punctuationMarks;
    }

    /**
     * Counts the number of vowels in a given word.
     *
     * @param word The Word object for which to count vowels.
     * @return The count of vowels in the word.
     */
    private int countVowels(Word word) {
        int count = 0;
        for (Letter letter : word.getLetters()) {
            char lowercaseLetter = Character.toLowerCase(letter.getValue());
            if ("eyuioaуеиоиеяюые".indexOf(lowercaseLetter) != -1) {
                count++;
            }
        }
        return count;
    }
}