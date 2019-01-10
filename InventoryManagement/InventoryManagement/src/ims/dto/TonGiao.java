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
public class TonGiao {
    private String tonGiao;
    private String maTonGiao;

    public TonGiao() {
    }

    public TonGiao(String tonGiao, String maTonGiao) {
        this.tonGiao = tonGiao;
        this.maTonGiao = maTonGiao;
    }

    public String getTonGiao() {
        return tonGiao;
    }

    public void setTonGiao(String tonGiao) {
        this.tonGiao = tonGiao;
    }

    public String getMaTonGiao() {
        return maTonGiao;
    }

    public void setMaTonGiao(String maTonGiao) {
        this.maTonGiao = maTonGiao;
    }


    
    
}
