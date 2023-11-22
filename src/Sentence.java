import java.util.List;

/**
 * The Sentence class represents a sequence of words and punctuation marks forming a sentence.
 */
class Sentence {
    /**
     * The list of words in the sentence.
     */
    private List<Word> words;

    /**
     * The list of punctuation marks in the sentence.
     */
    private List<PunctuationMark> punctuationMarks;

    /**
     * Constructs a Sentence with the specified lists of words and punctuation marks.
     * @param words             The list of words in the sentence.
     * @param punctuationMarks The list of punctuation marks in the sentence.
     */
    public Sentence(List<Word> words, List<PunctuationMark> punctuationMarks) {
        this.words = words;
        this.punctuationMarks = punctuationMarks;
    }

    /**
     * Gets the list of words in the sentence.
     * @return The list of words in the sentence.
     */
    public List<Word> getWords() {
        return words;
    }

    /**
     * Gets the list of punctuation marks in the sentence.
     * @return The list of punctuation marks in the sentence.
     */
    public List<PunctuationMark> getPunctuationMarks() {
        return punctuationMarks;
    }

    /**
     * Returns a string representation of the Sentence object.
     * @return A string containing the concatenated words and punctuation marks of the sentence.
     */
    @Override
    public String toString() {
        StringBuilder sentence = new StringBuilder();
        for (Word word : words) {
            sentence.append(word).append(" ");
        }
        for (PunctuationMark punctuationMark : punctuationMarks) {
            sentence.append(punctuationMark);
        }
        return sentence.toString().trim();
    }
}
