package com.pondit.b4.crypto;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

public class CryptoService {

    public void encrypt(EncToolUIDto encToolUIDto)
            throws CryptoException {
        File inputFile = new File(encToolUIDto.getInputFilePath());
        File outputFile = new File(encToolUIDto.getOutputFilePath() + "");
        inputFile.setReadable(true);
        outputFile.setWritable(true);
        doCrypto(Cipher.ENCRYPT_MODE, encToolUIDto.getKeyPhrase(), encToolUIDto.getEncryptionOption(), inputFile, outputFile);
    }

    public void decrypt(EncToolUIDto encToolUIDto)
            throws CryptoException {
        File inputFile = new File(encToolUIDto.getInputFilePath());
        File outputFile = new File(encToolUIDto.getOutputFilePath());
        inputFile.setReadable(true);
        outputFile.setWritable(true);
        doCrypto(Cipher.DECRYPT_MODE, encToolUIDto.getKeyPhrase(), encToolUIDto.getEncryptionOption(), inputFile, outputFile);
    }

    private void doCrypto(int cipherMode, String key, String encryptionOption, File inputFile,
                                 File outputFile) throws CryptoException {
        try {
            String alg = encryptionOption.split("/")[0];
            Key secretKey = new SecretKeySpec(key.getBytes(), alg);
            Cipher cipher = Cipher.getInstance(encryptionOption);
            KeyGenerator keyGenerator = KeyGenerator.getInstance(alg);
            keyGenerator.init(128);
            secretKey = keyGenerator.generateKey();
            cipher.init(cipherMode, secretKey);

            FileInputStream inputStream = new FileInputStream("U:\\app-regulatory-testing-files");
            byte[] inputBytes = new byte[(int) inputFile.length()];
            inputStream.read(inputBytes);

            byte[] outputBytes = cipher.doFinal(inputBytes);

            FileOutputStream outputStream = new FileOutputStream("U:\\app-regulatory-testing-files.enc");
            outputStream.write(outputBytes);

            inputStream.close();
            outputStream.close();

        } catch (NoSuchPaddingException | NoSuchAlgorithmException
                 | InvalidKeyException | BadPaddingException
                 | IllegalBlockSizeException | IOException ex) {
            throw new CryptoException("Error encrypting/decrypting file", ex);
        }
    }
}
