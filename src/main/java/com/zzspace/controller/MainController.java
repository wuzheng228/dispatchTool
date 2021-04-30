package com.zzspace.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.Clipboard;
import org.apdplat.word.WordSegmenter;
import org.apdplat.word.segmentation.Word;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainController {
    private static final String POLICY_PATTERN = "82\\d{16}";
    private static final String CHANEEL_POLICY_PATTERN = "2\\d{19}";
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
        List<Word> seg = WordSegmenter.seg(input);
        System.out.println(seg);
        Matcher matcher = Pattern.compile(POLICY_PATTERN).matcher(input);
        if (matcher.find()) {
            textPolicy.setText(matcher.group());
        }
        matcher = Pattern.compile(CHANEEL_POLICY_PATTERN).matcher(input);
        if (matcher.find()) {
            textChennelPolicy.setText(matcher.group());
        }

    }
}
