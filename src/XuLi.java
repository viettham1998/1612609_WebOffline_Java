import javax.swing.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class XuLi {
    String chuoi;
    String tenFile="index.html";
    public XuLi(){
        chuoi="";
        tenFile="";
    }
    public XuLi(String URL, String name){
        chuoi=URL;
        if(name!="") {
            tenFile = name;
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
            try{
                URL website = new URL(chuoi);
                ReadableByteChannel rbc = Channels.newChannel(website.openStream());
                FileOutputStream fos = new FileOutputStream(tenFile);
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
