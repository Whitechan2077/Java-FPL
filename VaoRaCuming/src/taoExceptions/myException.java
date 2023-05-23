/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taoExceptions;

/**
 *
 * @author buidu
 */
class myException extends Exception{
    private int thongbao;

    public myException(int thongbao) {
        this.thongbao = thongbao;
    }

    @Override
    public String toString() {
        return "My Exception "+thongbao;
    }
    
}
