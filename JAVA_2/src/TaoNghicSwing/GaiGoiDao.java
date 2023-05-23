/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package TaoNghicSwing;

/**
 *
 * @author buidu
 */
public interface GaiGoiDao {
    public void insert(GaiGoi gai);
    public void delete(String tenGai);
    public void find(String tenGai);
    public void update(String tenGai);
}
