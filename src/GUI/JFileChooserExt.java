package GUI;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * @file JFileChooserExt.java
 * @date Jan 5, 2018 , 11:27:45 PM
 * @author Muhammet Alkan
 */
public class JFileChooserExt extends JFileChooser {

    JFileChooserExt(String title) {
        setOptions(title);
    }

    //experimental
    public void addFileFilter(String description, String... extensions) {
        addChoosableFileFilter(new FileNameExtensionFilter(description, extensions));
    }

    private void setOptions(String title) {
        setDialogTitle(title);
        setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        setAcceptAllFileFilterUsed(false);
        setFileHidingEnabled(true);
    }

    @Override
    public void approveSelection() {
        if (getSelectedFile().isDirectory()) {
            super.approveSelection();
        }
    }
}
