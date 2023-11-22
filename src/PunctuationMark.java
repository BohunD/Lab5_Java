/**
 * The PunctuationMark class represents a punctuation mark in a sentence.
 */
class PunctuationMark {
    /**
     * The character value of the punctuation mark.
     */
    private char value;

    /**
     * Constructs a PunctuationMark with the specified character value.
     * @param value The character value of the punctuation mark.
     */
    public PunctuationMark(char value) {
        this.value = value;
    }

    /**
     * Returns a string representation of the PunctuationMark object.
     * @return A string containing the character value of the punctuation mark.
     */
    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
