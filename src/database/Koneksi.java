
package database;
import java.sql.*;
public class Koneksi implements KoneksiDatabase{
    public Connection kon;
    public boolean login;
    
    public Koneksi(String host){
        try {
            this.kon = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+host, "root", "");
            if(this.kon != null){
                System.out.println("Db Terkoneksi");
            }else{
                System.out.println("Db Gagal Terkoneksi");
            }
        } catch (Exception e) {
        }
    }
    
    @Override
    public void disconnect() {
        try {
            this.kon.close();
        } catch (Exception e) {
        }
    }

    @Override
    public void login(String user, String pass) {
        String sql = "select * from karyawan where username='"+user+"' and password='"+pass+"'";
        try {
            Statement state = kon.createStatement();
            ResultSet result = state.executeQuery(sql);
            
            int cek = 0;
            while(result.next()){
                cek = result.getRow();
            }
            if(cek > 0){
                System.out.println("==============");
                System.out.println("Berhasil Login");
                System.out.println("==============");
                System.out.println("");
                this.login = true;
            }else{
                System.out.println("");
                System.out.println("===============");
                System.out.println("= Login gagal =");
                System.out.println("===============");
                System.out.println("");
                this.login = false;
            }
            
        } catch (Exception e) {
            System.out.println("");
            System.out.println("===========");
            System.out.println("Login Gagal");
            System.out.println("===========");
            System.out.println("");
        }
        
    }

    @Override
    public void register(String user, String pass, String nama) {
        String sql = "insert into karyawan(nama_karyawan, username, password) values(?,?,?)";
        try {
            PreparedStatement state = kon.prepareStatement(sql);
            state.setString(1, nama);
            state.setString(2, user);
            state.setString(3, pass);
            int cek = state.executeUpdate();
            if(cek > 0){
                System.out.println("");
                System.out.println("=================");
                System.out.println("Berhasil Register");
                System.out.println("=================");
                System.out.println("");
                
            }else{
                System.out.println("==============");
                System.out.println("Gagal Register");
                System.out.println("==============");
                System.out.println("");
            }
        } catch (Exception e) {
        }
    }
    
}
