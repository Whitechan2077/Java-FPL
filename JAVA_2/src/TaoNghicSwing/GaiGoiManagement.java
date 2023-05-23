/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TaoNghicSwing;

import java.util.ArrayList;

/**
 *
 * @author buidu
 */
public class GaiGoiManagement implements GaiGoiDao {

    ArrayList<GaiGoi> listGaiGoi = new ArrayList<>();

    @Override
    public void insert(GaiGoi gai) {
        listGaiGoi.add(gai);
    }

    @Override
    public void delete(String tenGai) {
    }

    @Override
    public void find(String tenGai) {
    }

    @Override
    public void update(String tenGai) {
    }

    public ArrayList<GaiGoi> getAll() {
        for (GaiGoi x : listGaiGoi) {
            System.out.println(x.getTenGaiGoi());
        }
        return listGaiGoi ;
    }
}
