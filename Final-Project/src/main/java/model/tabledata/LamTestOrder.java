package model.tabledata;

import javafx.scene.control.Button;
import model.LamTest;

public class LamTestOrder {
    private static int idCounter = 1;
    private int stt;
    private String maDonHang;
    private String site;
    private String ngayNhanHang;
    private String trangThai;
    private Button action;
    private LamTest lamTest;

    public LamTestOrder(LamTest lamTest, Button action) {
        this.stt = idCounter++;
        this.lamTest = lamTest;
        this.maDonHang = lamTest.getMaDonHang();
        this.site = lamTest.getSite();
        this.ngayNhanHang = lamTest.getNgayNhanHang();
        this.trangThai = lamTest.getTrangThai();
        this.action = action;
    }

    public int getStt() {
        return stt;
    }

    public String getMaDonHang() {
        return maDonHang;
    }

    public String getSite() {
        return site;
    }

    public String getNgayNhanHang() {
        return ngayNhanHang;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public Button getAction() {
        return action;
    }

    public LamTest getLamTest() {
        return lamTest;
    }

    public void resetIdCounter() {
        idCounter = 1;
    }
}
