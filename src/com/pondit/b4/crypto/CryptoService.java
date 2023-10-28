package com.pondit.b4.crypto;

import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.model.enums.EncryptionMethod;

import javax.crypto.Cipher;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CryptoService {

    public void encrypt(EncToolUIDto encToolUIDto)
            throws CryptoException, IOException {
        doCrypto(Cipher.ENCRYPT_MODE, encToolUIDto);
    }

    public void decrypt(EncToolUIDto encToolUIDto)
            throws CryptoException, IOException {
        doCrypto(Cipher.DECRYPT_MODE, encToolUIDto);
    }

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    private void doCrypto(int cipherMode, EncToolUIDto encToolUIDto) throws IOException {
        ZipParameters zipParameters = new ZipParameters();
        zipParameters.setEncryptFiles(true);
        zipParameters.setEncryptionMethod(EncryptionMethod.ZIP_STANDARD_VARIANT_STRONG);

        List<File> filesToAdd = new ArrayList<File>();
        var fileOrFolder = new File(encToolUIDto.getInputFilePath());
        if (fileOrFolder.isDirectory()) {
            for (File file : Objects.requireNonNull(fileOrFolder.listFiles())) {
                System.out.println(ANSI_BLUE + file.getAbsolutePath() + ANSI_RESET);
                System.out.println(ANSI_RED + file.getCanonicalPath() + ANSI_RESET);
                System.out.println(ANSI_GREEN + file.getPath() + ANSI_RESET);
            }
        }


//        ZipFile zipFile = new ZipFile("compressed.zip", "password".toCharArray());
//        zipFile.addFiles(filesToAdd, zipParameters);
    }
}
