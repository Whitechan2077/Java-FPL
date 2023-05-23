/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab2;

import java.util.ArrayList;

/**
 *
 * @author buidu
 */
public class UserDao {
    public static ArrayList<User> us = new ArrayList<>();
    public int add(User u){
        us.add(u);
        return 1;
    }
    public int findByUserName(String userName){
        int pos = -1;
        
        for(int i = 0 ; i < us.size();i++){
            if (us.get(i).getUserName().equals(userName)) {
                pos = i;
                break;
            }
        }
        return pos;
    }
    public int delUserName(String userName){
        int pos = findByUserName(userName);
        if (pos<0) {
            System.out.println("ko tim thay");
        }
        else{
            us.remove(pos);
            System.out.println("Da tim thay");
        }
        return pos;
    }
    
    public int updateUser(User u){
        int pos = findByUserName(u.getUserName());
        if (pos<0) {
            System.out.println("ko tim thay");
        }else{
            us.set(pos,u);
        }
        return pos;
    }
    public ArrayList<User> getAll(){
        for(User x : us){
            System.out.println(x.getUserName());
        }
        return us;
    }
}
