/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpustakaan;

/**
 *
 * @author Lenovo
 */
public class BukuDipinjam extends Buku {
    public int lama;

    public BukuDipinjam(String judul, int lama) {
        super(judul);
        this.lama = lama;
    }

    
    
    
}
