package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.net.MalformedURLException;
import java.net.URL;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.*;
import javax.swing.*;

/**
 * @file SimpleSwingBrowser.java
 */
public class SimpleSwingBrowser extends JPanel {

    private final JFXPanel jfxPanel = new JFXPanel();
    private WebEngine engine;

    private final JLabel lblStatus = new JLabel();

    private final JTextField txtURL = new JTextField();

    private final JButton btnReturnResultPage = new JButton("Return Results Page");
    private final JProgressBar progressBar = new JProgressBar();

    public SimpleSwingBrowser() {
        super(new BorderLayout());
        initComponents();
    }

    private void initComponents() {
        createScene();

        btnReturnResultPage.addActionListener((ActionEvent e) -> {
            loadURL(txtURL.getText());
        });

        progressBar.setPreferredSize(new Dimension(150, 18));
        progressBar.setStringPainted(true);

        txtURL.setEditable(false);

        JPanel topBar = new JPanel(new BorderLayout(5, 0));
        topBar.setBorder(BorderFactory.createEmptyBorder(3, 5, 3, 5));
        topBar.add(txtURL, BorderLayout.CENTER);
        topBar.add(btnReturnResultPage, BorderLayout.EAST);

        JPanel statusBar = new JPanel(new BorderLayout(5, 0));
        statusBar.setBorder(BorderFactory.createEmptyBorder(3, 5, 3, 5));
        statusBar.add(lblStatus, BorderLayout.CENTER);
        statusBar.add(progressBar, BorderLayout.EAST);

        add(topBar, BorderLayout.NORTH);
        add(jfxPanel, BorderLayout.CENTER);
        add(statusBar, BorderLayout.SOUTH);

        setPreferredSize(new Dimension(1024, 600));
    }

    public void loadURL(final String url) {
        Platform.runLater(() -> {
            try {
                String mossURL = new URL(url).toExternalForm();

                setURL(mossURL);
                engine.load(mossURL);
            } catch (MalformedURLException ex) {
                System.out.println(ex);
            }
        });
    }

    private void createScene() {
        Platform.runLater(() -> {
            WebView view = new WebView();
            engine = view.getEngine();

            engine.locationProperty().addListener((ObservableValue<? extends String> ov, final String oldLoc, final String loc) -> {
                if (!loc.contains("moss")) {
                    Platform.runLater(() -> {
                        engine.load(oldLoc);
                    });
                }
            });

            engine.setOnStatusChanged((final WebEvent<String> event) -> {
                SwingUtilities.invokeLater(() -> {
                    if (event.getData() != null && !event.getData().equals("") && !event.getData().startsWith("http://moss")) {
                        lblStatus.setText("<html><font color='red'>Out of \"MOSS\" domain !</font></html>");
                    } else {
                        lblStatus.setText(event.getData());
                    }
                });
            });

            engine.getLoadWorker().workDoneProperty().addListener((ObservableValue<? extends Number> observableValue, Number oldValue, final Number newValue) -> {
                SwingUtilities.invokeLater(() -> {
                    progressBar.setValue(newValue.intValue());
                });
            });

            engine.getLoadWorker()
                    .exceptionProperty()
                    .addListener((ObservableValue<? extends Throwable> o, Throwable old, final Throwable value) -> {
                        if (engine.getLoadWorker().getState() == Worker.State.FAILED) {
                            SwingUtilities.invokeLater(() -> {
                                JOptionPane.showMessageDialog(
                                        SimpleSwingBrowser.this,
                                        (value != null)
                                                ? engine.getLocation() + "\n" + value.getMessage()
                                                : engine.getLocation() + "\nUnexpected error.",
                                        "Loading error...",
                                        JOptionPane.ERROR_MESSAGE);
                            });
                        }
                    });

            jfxPanel.setScene(new Scene(view));
        });
    }

    private void setURL(String url) {
        txtURL.setText(url);
    }

    @Override
    public String getName() {
        return "Browser";
    }
}