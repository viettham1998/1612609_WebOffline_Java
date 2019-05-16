import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class GiaoDien {
    public static final int WIDTH = 400;
    public static final int HEIGHT = 150;
    private JButton tảiButton;
    private JTextField linkTextTextField;
    private JPanel mainForm;
    private JTextField textField1;
    private JTextField fileName;

    public GiaoDien() {
        tảiButton.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                XuLi xL = new XuLi(linkTextTextField.getText(),fileName.getText());
                xL.batDau();
            }
        }));
        linkTextTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==linkTextTextField){
                    tảiButton.doClick();
                }
            }
        });
    }

    public static void main(String[] arga) {
        JFrame frame = new JFrame("Tải Trình Duyệt Offline");
        frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        frame.setResizable(false);
        frame.setContentPane(new GiaoDien().mainForm);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
