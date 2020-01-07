/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author brilyan
 */
public interface TransaksiDatabase {
    public void transaksibaru(Koneksi k, String jenis, String customer, String tgl_pinjam, String tgl_kembali, String total_hari);
    public void hapustransaksi(Koneksi k, String id);
    
}
