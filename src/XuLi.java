import javax.swing.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class XuLi {
    String chuoi;
    String tenFile="index.html";
    String tenThuMuc="1612609";
    public XuLi(){
        chuoi="";
        tenFile="";
        tenThuMuc="";
    }
    public XuLi(String URL, String name, String thuMuc){
        chuoi=URL;
        if(name!="") {
            tenFile = name;
        }
        if(thuMuc!=""){
            tenThuMuc=thuMuc;
        }
      //  else tenFile="index.html";
    }
    public Boolean kiemTraKetNoi(){
      try {
          URL urlObj = new URL(chuoi);
          HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();
          con.setRequestMethod("GET");
          con.setConnectTimeout(3000);
          con.connect();
          int code = con.getResponseCode();
          if (code == 200) {
              return true;
          }
      }catch(Exception e){
          return false;
          }
      return true;
    }
    public void batDau(){
        if (kiemTraKetNoi() == true) {
            new File(tenThuMuc).mkdir();
            try{
                URL website = new URL(chuoi);
                ReadableByteChannel rbc = Channels.newChannel(website.openStream());
                FileOutputStream fos = new FileOutputStream(tenThuMuc+ "\\"+ tenFile);
                fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
                fos.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            JOptionPane.showMessageDialog(null, "Kết nối thành công. Quá trình download sẽ được thực hiện");
        } else {
            JOptionPane.showMessageDialog(null, "Kết nối thất bại, vui lòng kiểm tra lại đường dẫn web");
        }
    }
}
