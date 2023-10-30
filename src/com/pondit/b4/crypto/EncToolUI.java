package com.pondit.b4.crypto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EncToolUI extends JFrame {

    private static final Logger logger = Logger.getLogger("com.pondit.b4.crypto.EncToolUI");

    public static void main(String[] args) {

        EncToolUI encToolUI = new EncToolUI();
        AtomicReference<EncToolUIDto> encToolUIDto = new AtomicReference<>(new EncToolUIDto());
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
                encToolUIDto.get().setInputFilePath(fileChooser.getSelectedFile().getAbsolutePath());
            }
        });
        var pnlRow2Center = new JPanel(new GridLayout(1, 2));
        pnlRow2Center.add(lblSelectedFile);
        pnlRow2Center.add(btnSelectFile);
        pnlRow2.add(pnlRow2Center);
        pnlRow2.add(new Label(" "));
        pnlCenter.add(pnlRow2);

        var pnlRow3 = new JPanel(new GridLayout(1, 3));
        var btnEncrypt = new JButton("Encrypt");

        CryptoService cryptoService = new CryptoService();

        btnEncrypt.addActionListener(e -> {
            encToolUIDto.set(validateInputsAndProduceDataObject(encToolUI, encToolUIDto.get()));

            if (!encToolUIDto.get().getKeyPhrase().isEmpty() && !encToolUIDto.get().getInputFilePath().isEmpty()) {
                try {
                    cryptoService.encrypt(encToolUIDto.get());
                } catch (CryptoException | IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        pnlRow3.add(btnEncrypt);
        pnlRow3.add(new Label("      "));

        var btnDecrypt = new JButton("Decrypt");
        pnlRow3.add(btnDecrypt);
        btnDecrypt.addActionListener(e -> {
            encToolUIDto.set(validateInputsAndProduceDataObject(encToolUI, encToolUIDto.get()));

            if (!encToolUIDto.get().getKeyPhrase().isEmpty() && !encToolUIDto.get().getInputFilePath().isEmpty()) {
                try {
                    cryptoService.decrypt(encToolUIDto.get());
                } catch (CryptoException | IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        pnlCenter.add(pnlRow3);

        pnlMain.add(pnlTop, BorderLayout.NORTH);
        pnlMain.add(pnlCenter, BorderLayout.CENTER);
        encToolUI.add(pnlMain);
        encToolUI.setVisible(true);

    }

    private static EncToolUIDto validateInputsAndProduceDataObject(EncToolUI encToolUI, final EncToolUIDto encToolUIDto) {
        String keyPhrase = JOptionPane.showInputDialog(encToolUI, "Please enter key phrase");
        if (keyPhrase != null) {
            System.out.println(keyPhrase);
            encToolUIDto.setKeyPhrase(keyPhrase);
        }

        if (encToolUIDto.getKeyPhrase().isEmpty()) {
            JOptionPane.showMessageDialog(encToolUI, "No Key Phrase Provided!");
        }
        return encToolUIDto;
    }
}
