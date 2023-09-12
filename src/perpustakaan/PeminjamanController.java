package perpustakaan;

import java.util.ArrayList;
import java.awt.Dialog;

public class PeminjamanController {

//    private ArrayList bukuPinjam;
    public PeminjamanManager peminjamanManager = new PeminjamanManager();
    
    public void showFormPeminjaman() {
        Perpustakaan.formPeminjaman = new FormPeminjaman();
        Perpustakaan.formPeminjaman.tampilkan();
    }

    public void showPinjam(String judul, int hari) {
        if (hari <= 3 && hari > 0) {
//            Perpustakaan.formPeminjaman.tambahBuku();
        } else {
            DialogUI dial = new DialogUI("Maksimal Waktu Peminjaman adalah 3 hari");
            dial.pack();
            dial.setLocationRelativeTo(null);
            dial.setVisible(true);
        }
    }

    public void cariBuku(String judul) {
        BukuProvider bukuProvider = new BukuProvider();
        try {
            ArrayList<Buku> listBuku = bukuProvider.selectBuku(judul);
            if (listBuku.isEmpty()) {
                DialogUI dialogUI = new DialogUI("Buku tidak terdaftar");
                dialogUI.pack();
                dialogUI.setLocationRelativeTo(null);
                dialogUI.setVisible(true);
            } else {
                Perpustakaan.formPeminjaman.display(listBuku);
            }
        } catch (Exception ex) {
            DialogUI dialogUI = new DialogUI("Connection Error");
            dialogUI.pack();
            dialogUI.setLocationRelativeTo(null);
            dialogUI.setVisible(true);
        }
    }

    public void pinjam(ArrayList<BukuDipinjam> bukuDipinjam) {
        String message;
        System.out.println(bukuDipinjam.size());
        for(BukuDipinjam buku : bukuDipinjam){
            System.out.println(buku.judul + " ");
        }
        Boolean result = peminjamanManager.save(bukuDipinjam);
        System.out.println(result);
        if (result) {
            message = "Peminjaman buku Anda telah dikonfirmasi";
            Perpustakaan.peminjaman.setDaftarBuku(bukuDipinjam);
        } else {
            message = "Jumlah buku yang dipinjam melebihi batas maksimal 10 buku";
        }
        DialogUI dialogUI = new DialogUI(message);
        dialogUI.pack();
        dialogUI.setLocationRelativeTo(null);
        dialogUI.setVisible(true);
    }
}
