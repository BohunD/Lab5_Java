import java.util.List;

/**
 * The Text class represents a collection of sentences forming a text.
 */
class Text {
    /**
     * The list of sentences in the text.
     */
    private List<Sentence> sentences;

    /**
     * Constructs a Text with the specified list of sentences.
     * @param sentences The list of sentences in the text.
     */
    public Text(List<Sentence> sentences) {
        this.sentences = sentences;
    }

    /**
     * Gets the list of sentences in the text.
     * @return The list of sentences in the text.
     */
    public List<Sentence> getSentences() {
        return sentences;
    }

    /**
     * Returns a string representation of the Text object.
     * @return A string containing the concatenated sentences of the text.
     */
    @Override
    public String toString() {
        StringBuilder text = new StringBuilder();
        for (Sentence sentence : sentences) {
            text.append(sentence).append(" ");
        }
        return text.toString().trim();
    }
}
