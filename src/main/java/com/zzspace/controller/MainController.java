package com.zzspace.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.Clipboard;
import javafx.scene.text.Text;

public class MainController {
    @FXML
    private TextArea textAreaInput;
    @FXML
    private Button btnRec;
    @FXML
    private TextField textName;
    @FXML
    private TextField textPhone;
    @FXML
    private TextField textChennelPolicy;
    @FXML
    private TextField textPolicy;
    @FXML
    private TextField textAddress;
    @FXML
    private RadioButton rbtnPm;
    @FXML
    private RadioButton rbtnJd;
    @FXML
    private Button btnMergeCopy;
    @FXML
    private TextArea textAreaOutput;

    @FXML
    private void recognizeClipboardText() {
        Clipboard clipboard = Clipboard.getSystemClipboard();
        String input = clipboard.getString();
        if (input == null || input.equals(""))
            return;
        textAreaInput.setText(input);
    }
}
