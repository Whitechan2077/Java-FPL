/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.main;
import java.io.IOException;
import poly.io.XFILE;
/**
 *
 * @author buidu
 */
public class XFileDemo {
    public static void main(String[] args) throws IOException {
        byte[] data = XFILE.read("F:/y2mate.com - 可愛くてごめん feat ちゅーたんCV早見沙織HoneyWorks_1080p.mp4");
        XFILE.write("F:/kwaii.mp4", data);
    }
}
