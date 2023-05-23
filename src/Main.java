import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

class Uye {
    private String ad;
    private String soyad;
    private String email;
    private String telefon;
    private String cinsiyet;

    public Uye(String ad, String soyad, String email, String telefon, String cinsiyet) {
        this.ad = ad;
        this.soyad = soyad;
        this.email = email;
        this.telefon = telefon;
        this.cinsiyet = cinsiyet;
    }

    public String getAd() {
        return ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefon() {
        return telefon;
    }

    public String getCinsiyet() {
        return cinsiyet;
    }
}

public class Main {
    private static List<Uye> uyeler = new ArrayList<>();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Üye Kayıt Formu");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setPreferredSize(new Dimension(410, 500));
            frame.setLayout(new FlowLayout());

            JLabel adLabel = new JLabel("Ad:");
            JTextField adField = new JTextField(15);

            JLabel soyadLabel = new JLabel("Soyad:");
            JTextField soyadField = new JTextField(15);

            JLabel emailLabel = new JLabel("E-mail:");
            JTextField emailField = new JTextField(15);

            JLabel telefonLabel = new JLabel("Telefon:");
            JTextField telefonField = new JTextField(15);

            JLabel cinsiyetLabel = new JLabel("Cinsiyet:");
            JRadioButton erkekRadioButton = new JRadioButton("Erkek");
            JRadioButton kadinRadioButton = new JRadioButton("Kadın");
            JRadioButton digerRadioButton = new JRadioButton("Belirtmek istemiyorum");

            ButtonGroup cinsiyetGroup = new ButtonGroup();
            cinsiyetGroup.add(erkekRadioButton);
            cinsiyetGroup.add(kadinRadioButton);
            cinsiyetGroup.add(digerRadioButton);

            JButton kaydetButton = new JButton("Kaydet");
            kaydetButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String ad = adField.getText();
                    String soyad = soyadField.getText();
                    String email = emailField.getText();
                    String telefon = telefonField.getText();
                    String cinsiyet = "";

                    if (erkekRadioButton.isSelected()) {
                        cinsiyet = "Erkek";
                    } else if (kadinRadioButton.isSelected()) {
                        cinsiyet = "Kadın";
                    } else if (digerRadioButton.isSelected()) {
                        cinsiyet = "Belirtmek istemiyorum";
                    }

                    Uye uye = new Uye(ad, soyad, email, telefon, cinsiyet);
                    uyeler.add(uye);

                    JOptionPane.showMessageDialog(frame, "Üye bilgileri kaydedildi.");

                    // Reset input fields
                    adField.setText("");
                    soyadField.setText("");
                    emailField.setText("");
                    telefonField.setText("");
                    cinsiyetGroup.clearSelection();
                }
            });

            JTextArea outputArea = new JTextArea(20, 20);
            outputArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(outputArea);

            JButton gosterButton = new JButton("Üyeleri Göster");
            gosterButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    StringBuilder sb = new StringBuilder();
                    for (Uye uye : uyeler) {
                        sb.append("Ad: ").append(uye.getAd()).append("\n");
                        sb.append("Soyad: ").append(uye.getSoyad()).append("\n");
                        sb.append("E-mail: ").append(uye.getEmail()).append("\n");
                        sb.append("Telefon: ").append(uye.getTelefon()).append("\n");
                        sb.append("Cinsiyet: ").append(uye.getCinsiyet()).append("\n");
                        sb.append("--------------------\n");
                    }
                    outputArea.setText(sb.toString());
                }
            });

            frame.add(adLabel);
            frame.add(adField);
            frame.add(soyadLabel);
            frame.add(soyadField);
            frame.add(emailLabel);
            frame.add(emailField);
            frame.add(telefonLabel);
            frame.add(telefonField);
            frame.add(cinsiyetLabel);
            frame.add(erkekRadioButton);
            frame.add(kadinRadioButton);
            frame.add(digerRadioButton);
            frame.add(kaydetButton);
            frame.add(scrollPane);
            frame.add(gosterButton);

            frame.pack();
            frame.setVisible(true);
        });
    }
}