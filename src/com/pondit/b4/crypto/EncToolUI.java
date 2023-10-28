package com.pondit.b4.crypto;

import net.lingala.zip4j.exception.ZipException;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EncToolUI extends JFrame {

    private static final Logger logger = Logger.getLogger("com.pondit.b4.crypto.EncToolUI");

    /**
     * Every implementation of the Java platform is required to support the following standard Cipher transformations with the keysizes in parentheses:
     * AES/CBC/NoPadding (128)
     * AES/CBC/PKCS5Padding (128)
     * AES/ECB/NoPadding (128)
     * AES/ECB/PKCS5Padding (128)
     * DES/CBC/NoPadding (56)
     * DES/CBC/PKCS5Padding (56)
     * DES/ECB/NoPadding (56)
     * DES/ECB/PKCS5Padding (56)
     * DESede/CBC/NoPadding (168)
     * DESede/CBC/PKCS5Padding (168)
     * DESede/ECB/NoPadding (168)
     * DESede/ECB/PKCS5Padding (168)
     * RSA/ECB/PKCS1Padding (1024, 2048)
     * RSA/ECB/OAEPWithSHA-1AndMGF1Padding (1024, 2048)
     * RSA/ECB/OAEPWithSHA-256AndMGF1Padding (1024, 2048)
     *
     * Usage: Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
     * */
    private static String encryptionCypherItems[] = {
            "AES/CBC/NoPadding",
            "AES/CBC/PKCS5Padding",
            "AES/ECB/NoPadding",
            "AES/ECB/PKCS5Padding",
            "DES/CBC/NoPadding",
            "DES/CBC/PKCS5Padding",
            "DES/ECB/NoPadding",
            "DES/ECB/PKCS5Padding",
            "DESede/CBC/NoPadding",
            "DESede/CBC/PKCS5Padding",
            "DESede/ECB/NoPadding",
            "DESede/ECB/PKCS5Padding",
            "RSA/ECB/PKCS1Padding",
            "RSA/ECB/OAEPWithSHA-1AndMGF1Padding",
            "RSA/ECB/OAEPWithSHA-256AndMGF1Padding"
    };

    public static void main(String[] args) {

        EncToolUI encToolUI = new EncToolUI();
        EncToolUIDto encToolUIDto = new EncToolUIDto();
        encToolUI.setSize(400, 300);
        encToolUI.setDefaultCloseOperation(EXIT_ON_CLOSE);
        var pnlMain = new JPanel();
        pnlMain.setLayout(new BorderLayout());
        var pnlTop = new JPanel();
        var lblHeader = new JLabel("Encryption Tool");
        pnlTop.setLayout(new GridLayout());
        pnlTop.add(lblHeader);

        var pnlCenter = new JPanel();
        pnlCenter.setLayout(new GridLayout(3, 1));
        var pnlRow1 = new JPanel(new GridLayout(3, 1));
        pnlRow1.add(new Label(" "));
//        var cmbEncSelector = new JComboBox<>(encryptionCypherItems);
//        cmbEncSelector.addActionListener( e -> {
//            var obj = (JComboBox)e.getSource();
//            logger.log(Level.INFO, String.valueOf(obj.getSelectedItem()));
//            System.out.println(String.valueOf(obj.getSelectedItem()));
//            encToolUIDto.setEncryptionOption(String.valueOf(obj.getSelectedItem()));
//        });
//        pnlRow1.add(cmbEncSelector);
        pnlRow1.add(new Label(" "));
        pnlCenter.add(pnlRow1);

        var pnlRow2 = new JPanel(new GridLayout(3, 1));
        pnlRow2.add(new Label(" "));

        var lblSelectedFile = new JLabel("No File Selected");
        var btnSelectFile = new JButton("Select File");
        btnSelectFile.addActionListener(e -> {
            var fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            var returnVal = fileChooser.showOpenDialog(pnlRow2);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                logger.log(Level.INFO, "File selected: " + fileChooser.getSelectedFile().getAbsolutePath());
                lblSelectedFile.setText(fileChooser.getSelectedFile().getAbsolutePath());
                encToolUIDto.setInputFilePath(fileChooser.getSelectedFile().getAbsolutePath());
            }
        });
        var pnlRow2Center = new JPanel(new GridLayout(1, 2));
        pnlRow2Center.add(lblSelectedFile);
        pnlRow2Center.add(btnSelectFile);
        pnlRow2.add(pnlRow2Center);
        pnlRow2.add(new Label(" "));
        pnlCenter.add(pnlRow2);

        var pnlRow3 = new JPanel(new GridLayout(3, 1));
        pnlRow3.add(new Label(" "));
        var btnEncrypt = new JButton("Encrypt");

        CryptoService cryptoService = new CryptoService();

        btnEncrypt.addActionListener(e -> {
            String keyPhrase = JOptionPane.showInputDialog(encToolUI, "Please enter key phrase");
            if (keyPhrase != null) {
                System.out.println(keyPhrase);
                encToolUIDto.setKeyPhrase(keyPhrase);
            }

            if (encToolUIDto.getKeyPhrase().isEmpty()) {
                JOptionPane.showMessageDialog(encToolUI, "No Key Phrase Provided!");
            }

//            if (encToolUIDto.getEncryptionOption().isEmpty()) {
//                JOptionPane.showMessageDialog(encToolUI, "No Encryption Option Provided!");
//            }

            if (encToolUIDto.getInputFilePath().isEmpty()) {
                JOptionPane.showMessageDialog(encToolUI, "No File Selected!");
            }

            if (!encToolUIDto.getKeyPhrase().isEmpty() && !encToolUIDto.getInputFilePath().isEmpty()) {
                try {
                    cryptoService.encrypt(encToolUIDto);
                } catch (CryptoException | IOException ex) {
                    throw new RuntimeException(ex);
                }
            }


        });
        pnlRow3.add(btnEncrypt);
        pnlRow3.add(new Label(" "));
        pnlCenter.add(pnlRow3);

        pnlMain.add(pnlTop, BorderLayout.NORTH);
        pnlMain.add(pnlCenter, BorderLayout.CENTER);
        encToolUI.add(pnlMain);
        encToolUI.setVisible(true);

    }
}
