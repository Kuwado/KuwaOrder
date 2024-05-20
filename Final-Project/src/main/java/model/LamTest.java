package model;

import javafx.scene.layout.HBox;

import java.util.List;

public class LamTest {
    private int stt;
    private String maDonHang;
    private String site;
    private String ngayNhanHang;
    private String trangThai;

    private List<SanPham> danhSachSanPham;
    // Constructor
    public LamTest(int stt, String maDonHang, String site, String ngayNhanHang, String trangThai, List<SanPham> danhSachSanPham) {
        this.stt = stt;
        this.maDonHang = maDonHang;
        this.site = site;
        this.ngayNhanHang = ngayNhanHang;
        this.trangThai = trangThai;
        this.danhSachSanPham = danhSachSanPham;
    }

    // Getters and setters
    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public String getMaDonHang() {
        return maDonHang;
    }

    public void setMaDonHang(String maDonHang) {
        this.maDonHang = maDonHang;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getNgayNhanHang() {
        return ngayNhanHang;
    }

    public void setNgayNhanHang(String ngayNhanHang) {
        this.ngayNhanHang = ngayNhanHang;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public List<SanPham> getDanhSachSanPham() {
        return danhSachSanPham;
    }

    public void setDanhSachSanPham(List<SanPham> danhSachSanPham) {
        this.danhSachSanPham = danhSachSanPham;
    }


}

