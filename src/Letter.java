/**
 * The Letter class represents a single letter in an alphabet.
 */
class Letter {
    /**
     * The character value of the letter.
     */
    private char value;

    /**
     * Constructs a Letter with the specified character value.
     * @param value The character value of the letter.
     */
    public Letter(char value) {
        this.value = value;
    }

    /**
     * Gets the character value of the letter.
     * @return The character value of the letter.
     */
    public char getValue() {
        return value;
    }

    /**
     * Returns a string representation of the Letter object.
     * @return A string containing the character value of the letter.
     */
    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
