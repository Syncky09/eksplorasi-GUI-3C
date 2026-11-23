import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FormMahasiswa {
    public static void main(String[] args) {
        // 1. TOP-LEVEL CONTAINER CLASS: JFrame
        JFrame frame = new JFrame("Form Minat Mahasiswa");
        
        frame.setSize(500, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); 
        frame.setVisible(true);

        // 2. INTERMEDIATE CONTAINER CLASS: JPanel
        JPanel panelHeader = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelHeader.setBackground(new Color(41, 128, 185));

        // 3. ATOMIC COMPONENT CLASS: JLabel
        JLabel lblJudul = new JLabel("Form Minat Mata Kuliah Mahasiswa");
        lblJudul.setForeground(Color.WHITE);
        lblJudul.setFont(new Font("SansSerif", Font.BOLD, 14));
        panelHeader.add(lblJudul);

        // 4. LAYOUT CLASS 1: BorderLayout pada container utama
        frame.setLayout(new BorderLayout(10, 10));

        // Panel Form menggunakan LAYOUT CLASS 3: GridLayout
        JPanel panelForm = new JPanel(new GridLayout(3, 2, 8, 8));
        panelForm.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));

        // ATOMIC COMPONENT CLASSES: JLabel, JTextField, JComboBox
        JLabel lblNama = new JLabel("Nama Mahasiswa:");
        JTextField txtNama = new JTextField();

        JLabel lblNim = new JLabel("NIM:");
        JTextField txtNim = new JTextField();

        JLabel lblMinat = new JLabel("Bidang Minat:");
        String[] daftarMinat = {
            "BlockChain",
            "Kriptografi",
            "Jaringan Komputer",
            "Kecerdasan Buatan"
        };
        JComboBox<String> cbMinat = new JComboBox<>(daftarMinat);

        panelForm.add(lblNama);
        panelForm.add(txtNama);
        panelForm.add(lblNim);
        panelForm.add(txtNim);
        panelForm.add(lblMinat);
        panelForm.add(cbMinat);

        JPanel panelTombol = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        // ATOMIC COMPONENT CLASS: JButton
        JButton btnTampilkan = new JButton("Submit");
        panelTombol.add(btnTampilkan);

        // Panel Output menggunakan BorderLayout
        JPanel panelOutput = new JPanel(new BorderLayout());
        panelOutput.setBorder(BorderFactory.createEmptyBorder(0, 15, 10, 15));
        // ATOMIC COMPONENT CLASS: JTextArea & INTERMEDIATE CONTAINER: JScrollPane
        JTextArea areaHasil = new JTextArea(4, 30);
        areaHasil.setEditable(false);
        areaHasil.setText("Status: Silakan isi data lalu klik 'Submit'...");
        JScrollPane scrollPane = new JScrollPane(areaHasil);
        panelOutput.add(scrollPane, BorderLayout.CENTER);

        // Panel Tengah untuk menggabungkan panelForm dan panelTombol
        JPanel panelTengah = new JPanel(new BorderLayout());
        panelTengah.add(panelForm, BorderLayout.CENTER);
        panelTengah.add(panelTombol, BorderLayout.SOUTH);

        // Memasukkan seluruh Intermediate Container ke Top-level Container
        frame.add(panelHeader, BorderLayout.NORTH);
        frame.add(panelTengah, BorderLayout.CENTER);
        frame.add(panelOutput, BorderLayout.SOUTH);

        // 5A. EVENT LISTENER INTERFACE: Override actionPerformed dari ActionListener
        btnTampilkan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = txtNama.getText().trim();
                String nim = txtNim.getText().trim();
                String minat = (String) cbMinat.getSelectedItem();

                if (nama.isEmpty() || nim.isEmpty()) {
                    JOptionPane.showMessageDialog(
                        frame,
                        "Nama dan NIM tidak boleh kosong!",
                        "Peringatan",
                        JOptionPane.WARNING_MESSAGE
                    );
                } else {
                    areaHasil.setText(
                        "=== Hasil Input Form Minat Mahasiswa ===\n" +
                        "Nama  : " + nama + "\n" +
                        "NIM   : " + nim + "\n" +
                        "Minat : " + minat
                    );
                }
            }
        });

        // 5B. EVENT ADAPTER CLASS: Override mouseEntered & mouseExited dari MouseAdapter
        btnTampilkan.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnTampilkan.setBackground(new Color(46, 204, 113));
                btnTampilkan.setForeground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnTampilkan.setBackground(UIManager.getColor("Button.background"));
                btnTampilkan.setForeground(Color.BLACK);
            }
        });

        frame.setVisible(true);
    }
}