import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GiaoDien {
    public static final int WIDTH = 400;
    public static final int HEIGHT = 200;
    private JButton tảiButton;
    private JTextField linkTextTextField;
    private JPanel mainForm;
    private JTextField tenThuMuc;
    private JTextField fileName;

    public GiaoDien() {
        tảiButton.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                XuLi xL = new XuLi(linkTextTextField.getText(),fileName.getText(), tenThuMuc.getText());
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
