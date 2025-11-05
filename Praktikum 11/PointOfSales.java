import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Versi fungsional penuh dari aplikasi PointOfSales
 * berdasarkan Pertemuan 11.
 *
 * Fungsionalitas:
 * 1. Memilih produk dari tabel kiri akan memperbarui label.
 * 2. Menambah produk ke keranjang, memperbarui total & poin.
 * 3. Checkout menghasilkan struk dan mengosongkan keranjang.
 * 4. Cetak membuka dialog print.
 */
public class PointOfSales extends JFrame implements ActionListener, ListSelectionListener {

    // Komponen GUI (sebagian besar sudah ada)
    private JTable productTable;
    private JTable cartTable;
    private JLabel lblSelectedProduct;
    private JLabel lblQty;
    private JTextField txtQty;
    private JButton btnAddToCart;
    private JLabel lblTotal;
    private JLabel lblPoints;
    private JButton btnCheckout;
    private JButton btnCetak;
    private JTextArea txtStruk;

    // Model untuk tabel keranjang agar bisa dinamis
    private DefaultTableModel cartModel;

    // Variabel untuk menyimpan data produk yang dipilih
    private String selectedProductId;
    private String selectedProductName;
    private long selectedProductPrice;

    // Formatter untuk mata uang (Rp)
    private NumberFormat currencyFormatter;

    public PointOfSales() {
        setTitle("POIN Off-Sales - Java Swing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setLocationRelativeTo(null);

        // Inisialisasi formatter mata uang
        currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));

        JMenuBar menuBar = new JMenuBar();
        JMenu menuFile = new JMenu("File");
        JMenu menuHelp = new JMenu("Help");
        menuBar.add(menuFile);
        menuBar.add(menuHelp);
        setJMenuBar(menuBar);

        setLayout(new GridLayout(1, 2, 10, 10));

        JPanel leftPanel = createLeftPanel();
        add(leftPanel);

        JPanel rightPanel = createRightPanel();
        add(rightPanel);

        // --- Tambahan Fungsionalitas ---
        // 1. Daftarkan Listener untuk tombol
        btnAddToCart.addActionListener(this);
        btnCheckout.addActionListener(this);
        btnCetak.addActionListener(this);

        // 2. Daftarkan Listener untuk seleksi tabel produk
        productTable.getSelectionModel().addListSelectionListener(this);
    }

    private JPanel createLeftPanel() {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        panel.setBorder(BorderFactory.createTitledBorder("Produk"));

        String[] productColumns = {"ID", "Nama Produk", "Harga (Rp)"};
        Object[][] productData = {
                // Kategori Minuman (M)
                {"M001", "Aqua Air Mineral 600ml", 3900},
                {"M002", "Le Minerale 600ml", 3800},
                {"M003", "Teh Pucuk Harum 350ml", 3800},
                {"M004", "Pocari Sweat 500ml", 7500},
                {"M005", "Coca-Cola Kaleng 330ml", 6000},
                {"M006", "Sprite Kaleng 330ml", 6000},
                {"M007", "Ultra Milk Coklat 250ml", 7000},
                {"M008", "Ultra Milk Full Cream 250ml", 6800},
                {"M009", "Indomilk UHT Kids 115ml", 3000},
                {"M010", "Kopi Sachet Kapal Api", 1500},
                {"M011", "Kopi Sachet Nescafe", 2000},
                {"M012", "Frestea Botol 500ml", 6000},
                {"M013", "Buavita Jambu 250ml", 7200},

                // Kategori Snack & Biskuit (S)
                {"S001", "Chitato Lite Nori 68g", 10500},
                {"S002", "Lay's Rumput Laut 68g", 11000},
                {"S003", "Qtela Singkong 60g", 8000},
                {"S004", "Silverqueen 58g", 12500},
                {"S005", "Cadbury Dairy Milk 62g", 14000},
                {"S006", "Oreo 133g", 9000},
                {"S007", "Roma Malkist Abon 135g", 8500},
                {"S008", "Tango Waffle 25g", 2500},
                {"S009", "Pringles Original 107g", 22000},
                {"S010", "Kacang Garuda 200g", 15000},

                // Kategori Mie Instan (N)
                {"N001", "Indomie Goreng", 3100},
                {"N002", "Indomie Soto", 3000},
                {"N003", "Indomie Kari Ayam", 3000},
                {"N004", "Mie Sedaap Goreng", 3100},
                {"N005", "Samyang Hot Chicken", 18000},
                {"N006", "Nissin Gekikara Ramen", 15000},
                {"N007", "Pop Mie Ayam", 5000},

                // Kategori Kebutuhan Pokok (K)
                {"K001", "Minyak Goreng Sania 2L", 34000},
                {"K002", "Minyak Goreng Bimoli 1L", 18000},
                {"K003", "Beras Raja Udang 5kg", 68000},
                {"K004", "Gulaku Gula Pasir 1kg", 17000},
                {"K005", "Telur Ayam (per 10 butir)", 25000},
                {"K006", "Saus Sambal ABC 135ml", 7000},
                {"K007", "Kecap Bango 210ml", 15000},
                {"K008", "Susu Kental Manis Frisian Flag", 11500},

                // Kategori Lain-lain (L)
                {"L001", "Sari Roti Tawar", 16000},
                {"L002", "Mr. Bread Roti Isi Coklat", 6000},
                {"L003", "Sabun Lifebuoy Batang", 4500},
                {"L004", "Pasta Gigi Pepsodent 190g", 10000},
                {"L005", "Shampo Pantene 135ml", 23000},
                {"L006", "Popok Merries M34", 80000},
                {"L007", "Obat Nyamuk Baygon", 15000},
                {"L008", "Baterai ABC Alkaline AA (isi 2)", 12000}
        };

        // Buat tabel tidak bisa diedit
        productTable = new JTable(productData, productColumns) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        // Hanya bisa pilih satu baris
        productTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        JScrollPane scrollPane = new JScrollPane(productTable);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    private JPanel createRightPanel() {
        JPanel panel = new JPanel(new BorderLayout(5, 5));

        JPanel cartPanel = new JPanel(new BorderLayout());
        cartPanel.setBorder(BorderFactory.createTitledBorder("Keranjang"));

        String[] cartColumns = {"ID", "Nama Produk", "Qty", "Harga", "Subtotal"};
        
        // --- Modifikasi: Gunakan DefaultTableModel ---
        cartModel = new DefaultTableModel(cartColumns, 0); // 0 baris awal
        cartTable = new JTable(cartModel) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        cartPanel.add(new JScrollPane(cartTable), BorderLayout.CENTER);

        // Panel Kontrol (Layout sudah benar dari sebelumnya)
        JPanel controlsPanel = new JPanel();
        controlsPanel.setLayout(new BoxLayout(controlsPanel, BoxLayout.Y_AXIS));

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        lblSelectedProduct = new JLabel("Pilih produk dari tabel di kiri");
        lblSelectedProduct.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        JPanel qtySubPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        lblQty = new JLabel("Qty:");
        txtQty = new JTextField("1", 5);
        btnAddToCart = new JButton("Add to Cart");

        qtySubPanel.add(lblQty);
        qtySubPanel.add(txtQty);
        qtySubPanel.add(btnAddToCart);
        qtySubPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        inputPanel.add(lblSelectedProduct);
        inputPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        inputPanel.add(qtySubPanel);

        JPanel totalPanel = new JPanel();
        totalPanel.setLayout(new BoxLayout(totalPanel, BoxLayout.Y_AXIS));
        totalPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JPanel totalSubPanel1 = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        lblTotal = new JLabel("Total: Rp0,00");
        lblPoints = new JLabel("Points: 0");
        totalSubPanel1.add(lblTotal);
        totalSubPanel1.add(lblPoints);
        totalSubPanel1.setAlignmentX(Component.LEFT_ALIGNMENT);

        JPanel totalSubPanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        btnCheckout = new JButton("Checkout");
        btnCetak = new JButton("Cetak");
        totalSubPanel2.add(btnCheckout);
        totalSubPanel2.add(btnCetak);
        totalSubPanel2.setAlignmentX(Component.LEFT_ALIGNMENT);

        totalPanel.add(totalSubPanel1);
        totalPanel.add(totalSubPanel2);

        JPanel strukPanel = new JPanel(new BorderLayout());
        strukPanel.setBorder(BorderFactory.createTitledBorder("Struk:"));
        txtStruk = new JTextArea();
        txtStruk.setEditable(false);
        txtStruk.setFont(new Font("Monospaced", Font.PLAIN, 12)); // Font agar rapi
        strukPanel.add(new JScrollPane(txtStruk), BorderLayout.CENTER);

        controlsPanel.add(inputPanel);
        controlsPanel.add(totalPanel);
        controlsPanel.add(strukPanel);

        panel.add(cartPanel, BorderLayout.CENTER);
        panel.add(controlsPanel, BorderLayout.SOUTH);

        return panel;
    }

    /**
     * Method ini dipanggil setiap kali ada tombol yang diklik.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == btnAddToCart) {
            handleAddToCart();
        } else if (source == btnCheckout) {
            handleCheckout();
        } else if (source == btnCetak) {
            handleCetak();
        }
    }

    /**
     * Method ini dipanggil setiap kali seleksi di tabel produk berubah.
     */
    @Override
    public void valueChanged(ListSelectionEvent e) {
        // Pastikan event tidak diproses dua kali (saat mouse ditekan dan dilepas)
        if (!e.getValueIsAdjusting()) {
            int selectedRow = productTable.getSelectedRow();

            // Jika ada baris yang dipilih
            if (selectedRow != -1) {
                selectedProductId = (String) productTable.getValueAt(selectedRow, 0);
                selectedProductName = (String) productTable.getValueAt(selectedRow, 1);
                // Konversi harga dari Integer ke long
                selectedProductPrice = ((Integer) productTable.getValueAt(selectedRow, 2)).longValue();

                // Update label 
                String formattedPrice = currencyFormatter.format(selectedProductPrice);
                lblSelectedProduct.setText(String.format("Dipilih: %s - %s (%s)", 
                    selectedProductId, selectedProductName, formattedPrice));
                
                txtQty.setText("1");
            }
        }
    }

    /**
     * Logika untuk tombol "Add to Cart".
     */
    private void handleAddToCart() {
        // Cek apakah sudah ada produk yang dipilih
        if (selectedProductId == null) {
            JOptionPane.showMessageDialog(this, "Silakan pilih produk terlebih dahulu.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int qty;
        try {
            // Ambil Qty dari text field
            qty = Integer.parseInt(txtQty.getText());
            if (qty <= 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Qty harus berupa angka positif.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        long subtotal = selectedProductPrice * qty;

        // Tambahkan sebagai baris baru di tabel keranjang 
        cartModel.addRow(new Object[]{
            selectedProductId,
            selectedProductName,
            qty,
            selectedProductPrice,
            subtotal
        });

        // Update total
        updateTotal();

        // Reset pilihan
        productTable.clearSelection();
        lblSelectedProduct.setText("Pilih produk dari tabel di kiri");
        txtQty.setText("1");
        selectedProductId = null;
        selectedProductName = null;
        selectedProductPrice = 0;
    }

    /**
     * Logika untuk tombol "Checkout".
     */
    private void handleCheckout() {
        int rowCount = cartModel.getRowCount();
        if (rowCount == 0) {
            JOptionPane.showMessageDialog(this, "Keranjang masih kosong.", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // Ambil total dari label (setelah diproses oleh updateTotal)
        long total = 0;
        for (int i = 0; i < rowCount; i++) {
            total += (Long) cartModel.getValueAt(i, 4);
        }
        
        // Hitung poin [cite: 194]
        long points = total / 1000;

        // Buat struk [cite: 191, 192, 193, 194, 195]
        StringBuilder struk = new StringBuilder();
        struk.append("===== POIN OFF-SALES =====\n");
        struk.append("Toko: Demo Toko\n");
        struk.append("---------------------------------\n");
        // Loop isi keranjang
        for (int i = 0; i < rowCount; i++) {
            String id = (String) cartModel.getValueAt(i, 0);
            String nama = (String) cartModel.getValueAt(i, 1);
            int qty = (Integer) cartModel.getValueAt(i, 2);
            long subtotal = (Long) cartModel.getValueAt(i, 4);
            
            // Format agar rapi
            struk.append(String.format("%-5s %-15s %d %s\n", 
                id, 
                nama.substring(0, Math.min(nama.length(), 15)), // Batasi panjang nama
                qty, 
                currencyFormatter.format(subtotal)
            ));
        }
        struk.append("---------------------------------\n");
        struk.append(String.format("TOTAL:         %s\n", currencyFormatter.format(total)));
        struk.append(String.format("POINTS DIDAPAT: %d (1 point per Rp 1000)\n", points));
        struk.append("---------------------------------\n");
        struk.append("Terima kasih! Silakan kunjungi kembali.\n");

        // Tampilkan struk di JTextArea
        txtStruk.setText(struk.toString());

        // Kosongkan keranjang
        cartModel.setRowCount(0);
        
        // Update total (akan menjadi 0)
        updateTotal();
    }

    /**
     * Logika untuk tombol "Cetak".
     */
    private void handleCetak() {
        if (txtStruk.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tidak ada struk untuk dicetak.", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        try {
            // Buka dialog print 
            boolean complete = txtStruk.print();
            if (complete) {
                JOptionPane.showMessageDialog(this, "Struk telah dikirim ke printer.", "Print Sukses", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Proses print dibatalkan.", "Print Dibatalkan", JOptionPane.WARNING_MESSAGE);
            }
        } catch (PrinterException e) {
            JOptionPane.showMessageDialog(this, "Gagal melakukan print: " + e.getMessage(), "Error Print", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Helper method untuk menghitung ulang dan memperbarui total dan poin.
     */
    private void updateTotal() {
        long total = 0;
        int rowCount = cartModel.getRowCount();

        for (int i = 0; i < rowCount; i++) {
            // Ambil subtotal dari kolom ke-4 (index 4)
            total += (Long) cartModel.getValueAt(i, 4);
        }

        // Hitung poin 
        long points = total / 1000;

        // Update label [cite: 143, 144]
        // Gunakan String.format agar sesuai dengan contoh di PDF "Rp14.000,00"
        String formattedTotal = String.format(new Locale("id", "ID"), "Rp%,d,00", total);
        
        lblTotal.setText("Total: " + formattedTotal);
        lblPoints.setText("Points: " + points);
    }

    /**
     * Main method untuk menjalankan aplikasi.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PointOfSales().setVisible(true);
            }
        });
    }
}