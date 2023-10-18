package com.pondit.b4.crypto;

import java.util.Objects;

public class EncToolUIDto {
    private String encryptionOption;
    private String inputFilePath;
    private String outputFilePath = "u:";
    private String keyPhrase;

    public String getEncryptionOption() {
        return encryptionOption;
    }

    public void setEncryptionOption(String encryptionOption) {
        this.encryptionOption = encryptionOption;
    }

    public String getInputFilePath() {
        return inputFilePath;
    }

    public void setInputFilePath(String inputFilePath) {
        this.inputFilePath = inputFilePath;
    }

    public String getOutputFilePath() {
        return outputFilePath;
    }

    public void setOutputFilePath(String outputFilePath) {
        this.outputFilePath = outputFilePath;
    }

    public String getKeyPhrase() {
        return keyPhrase;
    }

    public void setKeyPhrase(String keyPhrase) {
        this.keyPhrase = keyPhrase;
    }

    @Override public String toString() {
        return "EncToolUIDto{" + "encryptionOption='" + encryptionOption + '\'' + ", inputFilePath='" + inputFilePath + '\'' + ", outputFilePath='" + outputFilePath + '\'' + ", keyPhrase='" + keyPhrase + '\'' + '}';
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        EncToolUIDto that = (EncToolUIDto) o;

        if (!Objects.equals(encryptionOption, that.encryptionOption))
            return false;
        if (!Objects.equals(inputFilePath, that.inputFilePath))
            return false;
        if (!Objects.equals(outputFilePath, that.outputFilePath))
            return false;
        return Objects.equals(keyPhrase, that.keyPhrase);
    }

    @Override public int hashCode() {
        int result = encryptionOption != null ? encryptionOption.hashCode() : 0;
        result = 31 * result + (inputFilePath != null ? inputFilePath.hashCode() : 0);
        result = 31 * result + (outputFilePath != null ? outputFilePath.hashCode() : 0);
        result = 31 * result + (keyPhrase != null ? keyPhrase.hashCode() : 0);
        return result;
    }
}
