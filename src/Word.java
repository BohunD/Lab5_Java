import java.util.List;

/**
 * The Word class represents a sequence of letters forming a word.
 */
class Word {
    /**
     * The list of letters composing the word.
     */
    private List<Letter> letters;

    /**
     * Constructs a Word with the specified list of letters.
     * @param letters The list of letters composing the word.
     */
    public Word(List<Letter> letters) {
        this.letters = letters;
    }

    /**
     * Gets the list of letters composing the word.
     * @return The list of letters composing the word.
     */
    public List<Letter> getLetters() {
        return letters;
    }

    /**
     * Returns a string representation of the Word object.
     * @return A string containing the concatenated characters of the letters in the word.
     */
    @Override
    public String toString() {
        StringBuilder word = new StringBuilder();
        for (Letter letter : letters) {
            word.append(letter);
        }
        return word.toString();
    }
}
