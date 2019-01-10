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
public class NoiCapCMT {
    private String noiCapCMT;
    private String maNoiCapCMT;

    public NoiCapCMT(){
    }

    public NoiCapCMT(String noiCapCMT, String maNoiCapCMT) {
        this.noiCapCMT = noiCapCMT;
        this.maNoiCapCMT = maNoiCapCMT;
    }

    public String getNoiCapCMT() {
        return noiCapCMT;
    }

    public void setNoiCapCMT(String noiCapCMT) {
        this.noiCapCMT = noiCapCMT;
    }

    public String getMaNoiCapCMT() {
        return maNoiCapCMT;
    }

    public void setMaNoiCapCMT(String maNoiCapCMT) {
        this.maNoiCapCMT = maNoiCapCMT;
    }
   
    
    
}
