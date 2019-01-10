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
public class QuocTich {
    private String quocTich;
    private String maQuocTich;

    public QuocTich() {
    }

    public QuocTich(String quocTich, String maQuocTich) {
        this.quocTich = quocTich;
        this.maQuocTich = maQuocTich;
    }

    public String getQuocTich() {
        return quocTich;
    }

    public void setQuocTich(String quocTich) {
        this.quocTich = quocTich;
    }

    public String getMaQuocTich() {
        return maQuocTich;
    }

    public void setMaQuocTich(String maQuocTich) {
        this.maQuocTich = maQuocTich;
    }

   
    
}
