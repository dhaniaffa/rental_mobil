
package database;

public interface KoneksiDatabase {
    public void disconnect();
    public void login(String user, String pass);
    public void register(String user, String pass, String nama);
}
