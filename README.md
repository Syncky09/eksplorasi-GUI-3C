# Form Minat Mata Kuliah Mahasiswa (`TugasGUI.java`)

Aplikasi desktop berbasis Java Swing untuk mendata pilihan bidang minat mata kuliah mahasiswa beserta validasi input dan interaksi antarmuka dinamis.

---

## 5 Komponen Utama GUI yang Digunakan

Program ini menerapkan 5 pilar arsitektur komponen Java Swing dan AWT dengan rincian `class` dan `interface` sebagai berikut:

### 1. Top-Level Container (`Class`)
* **`javax.swing.JFrame`**
  * **Peran:** Berfungsi sebagai jendela utama (*main window*) aplikasi berjudul `"Form Minat Mahasiswa"` dengan ukuran `500 x 350` piksel yang menjadi wadah induk bagi seluruh komponen GUI lainnya.

### 2. Intermediate Container (`Class`)
* **`javax.swing.JPanel`**
  * **Peran:** Berfungsi sebagai wadah perantara untuk mengelompokkan komponen berdasarkan fungsinya (`panelHeader`, `panelForm`, `panelTombol`, `panelOutput`, dan `panelTengah`) agar mudah diatur tata letaknya.
* **`javax.swing.JScrollPane`**
  * **Peran:** Membungkus komponen `JTextArea` (`areaHasil`) sehingga area output memiliki kemampuan *scrolling* otomatis apabila teks melebihi ukuran area tampilan.

### 3. Atomic Component (`Class`)
Komponen dasar penyusun antarmuka yang berinteraksi langsung dengan pengguna:
* **`javax.swing.JLabel`:** Menampilkan teks statis pada judul header (`lblJudul`) dan label kolom input (`lblNama`, `lblNim`, `lblMinat`).
* **`javax.swing.JTextField`:** Kolom input satu baris untuk mengisi Nama Mahasiswa (`txtNama`) dan NIM (`txtNim`).
* **`javax.swing.JComboBox<E>`:** Menu *dropdown* (`cbMinat`) untuk memilih salah satu bidang minat (`BlockChain`, `Kriptografi`, `Jaringan Komputer`, `Kecerdasan Buatan`).
* **`javax.swing.JButton`:** Tombol aksi `"Submit"` (`btnTampilkan`) untuk memproses dan menampilkan data input.
* **`javax.swing.JTextArea`:** Area teks multi-baris bersifat *read-only* (`areaHasil`) untuk menampilkan ringkasan hasil input mahasiswa.
* **`javax.swing.JOptionPane`:** Menampilkan jendela dialog peringatan (*pop-up*) apabila kolom Nama atau NIM masih kosong saat tombol ditekan.

### 4. Layout Manager (`Class`)
Mengatur posisi dan proporsi ukuran komponen di dalam *container*:
* **`java.awt.BorderLayout`:** Mengatur kerangka utama `JFrame` serta `panelTengah` dan `panelOutput` ke dalam wilayah `NORTH`, `CENTER`, dan `SOUTH`.
* **`java.awt.FlowLayout`:** Mengatur perataan tengah (`FlowLayout.CENTER`) pada judul di `panelHeader` dan tombol di `panelTombol`.
* **`java.awt.GridLayout`:** Menyusun elemen form pada `panelForm` ke dalam pola matriks teratur berukuran **3 baris × 2 kolom** dengan jarak antar-komponen `8px`.

### 5. Event Handling (`Interface` & `Class`)
Menangani interaksi pengguna (klik tombol dan pergerakan kursor):
* **Event Listener (`Interface`) — `java.awt.event.ActionListener`:**
  * Diimplementasikan pada `btnTampilkan` dengan meng-override method `actionPerformed(ActionEvent e)` untuk memvalidasi input kosong dan mencetak hasil pilihan minat ke `JTextArea`.
* **Event Adapter (`Class`) — `java.awt.event.MouseAdapter`:**
  * Digunakan pada `btnTampilkan` dengan meng-override method `mouseEntered(MouseEvent e)` dan `mouseExited(MouseEvent e)` untuk memberikan efek perubahan warna tombol (*hover*) saat kursor melintas di atasnya tanpa perlu mengimplementasikan seluruh method dari `MouseListener`.

---

## Cara Menjalankan Program

1. Pastikan **Java Development Kit (JDK)** sudah terpasang pada sistem.
2. Kompilasi kode sumber:
   ```bash
   javac TugasGUI.java
3. Jalankan Aplikasi:
   ```bash
   java TugasGUI
<img width="608" height="428" alt="image" src="https://github.com/user-attachments/assets/5aafb52f-63c1-48c3-a341-fc4e231f9ca0" />
<img width="608" height="428" alt="Screenshot 2026-11-24 074534" src="https://github.com/user-attachments/assets/e296c7df-31ac-45e5-a4c7-37457d29d57c" />

