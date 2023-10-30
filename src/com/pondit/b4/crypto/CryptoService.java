package com.pondit.b4.crypto;

import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.model.enums.EncryptionMethod;

import javax.crypto.Cipher;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
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

    private void doCrypto(int cipherMode, EncToolUIDto encToolUIDto) throws IOException {
        var delim = "/";

        var folderName = encToolUIDto.getInputFilePath().split(delim)[encToolUIDto.getInputFilePath().split(delim).length - 1];

        if (cipherMode == Cipher.ENCRYPT_MODE) {
            ZipParameters zipParameters = new ZipParameters();
            zipParameters.setEncryptFiles(true);
            zipParameters.setEncryptionMethod(EncryptionMethod.AES);

            List<File> filesToAdd = new ArrayList<File>();
            var fileOrFolder = new File(encToolUIDto.getInputFilePath());
            if (fileOrFolder.isDirectory()) {
                // TODO: Implement recursive files adding strategy
//                populateFilesToAddFromDirectory(filesToAdd, fileOrFolder);
                Collections.addAll(filesToAdd, fileOrFolder.listFiles());
            } else if (fileOrFolder.isFile()){
                filesToAdd.add(Objects.requireNonNull(fileOrFolder));
            } else {
                throw new RuntimeException("File not found");
            }
            ZipFile zipFile = new ZipFile(folderName + ".zip", encToolUIDto.getKeyPhrase().toCharArray());
            zipFile.addFiles(filesToAdd, zipParameters);
//            int splitLength = 1024 * 1024 * 1024; //10MB
//            zipFile.createSplitZipFileFromFolder(new File(encToolUIDto.getInputFilePath()), zipParameters, true, splitLength);
        }

        if (cipherMode == Cipher.DECRYPT_MODE) {
            if (System.getProperty("os.name").startsWith("Windows")) {
                delim = "\\\\";
            }
            folderName = encToolUIDto.getInputFilePath().split(delim)[encToolUIDto.getInputFilePath().split(delim).length - 1];

            if (folderName.contains(".zip")) {
                folderName = folderName.split(".zip")[0];
            }
            var zipFile = new ZipFile(encToolUIDto.getInputFilePath(), encToolUIDto.getKeyPhrase().toCharArray());

            zipFile.extractAll(System.getProperty("user.home")+"/Documents/"+folderName);
        }
    }

    private void populateFilesToAddFromDirectory(List<File> filesToAdd, File fileOrFolder) {
        // TODO: Implement recursive folder traverse and add functionality
    }
}
