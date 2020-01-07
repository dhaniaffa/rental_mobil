
package database;
public abstract class CustomerDatabase {
    public abstract void insert(Koneksi k, String nama, String alamat, String telp);
    public abstract void update(Koneksi k, String id, String nama, String alamat, String telp);
    public abstract void delete(Koneksi k, String id);
    public abstract void show(Koneksi k);
}
