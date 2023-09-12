package perpustakaan;

import java.util.ArrayList;

public class PeminjamanManager {

    public Boolean save(ArrayList<BukuDipinjam> bukuDipinjam) {
        return bukuDipinjam.size() <= 10;
    }
}
