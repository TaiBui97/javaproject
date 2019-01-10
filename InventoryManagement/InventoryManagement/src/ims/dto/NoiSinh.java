/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ims.dto;

/**
 *
 * @author agfor
 */
public class NoiSinh {
    private String tenNoiSinh;
    private String maNoiSinh;

    public NoiSinh() {
    }

    public NoiSinh(String tenNoiSinh, String maNoiSinh) {
        this.tenNoiSinh = tenNoiSinh;
        this.maNoiSinh = maNoiSinh;
    }

    public String getTenNoiSinh() {
        return tenNoiSinh;
    }

    public void setTenNoiSinh(String tenNoiSinh) {
        this.tenNoiSinh = tenNoiSinh;
    }

    public String getMaNoiSinh() {
        return maNoiSinh;
    }

    public void setMaNoiSinh(String maNoiSinh) {
        this.maNoiSinh = maNoiSinh;
    }

    
    

}
