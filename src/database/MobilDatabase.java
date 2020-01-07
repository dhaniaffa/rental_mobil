
package database;
public abstract class MobilDatabase {
    public abstract void insert(Koneksi k, String plat, String jenis, String merk, String tahun, String warna, String harga, String stok);
    public abstract void update(Koneksi k, String id, String plat, String jenis, String merk, String tahun, String warna, String harga, String stok);
    public abstract void delete(Koneksi k, String id);
    public abstract void show(Koneksi k);
}
