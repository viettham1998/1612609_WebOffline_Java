//import jdk.nashorn.internal.scripts.JO;
//
//import javax.swing.*;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.nio.channels.Channels;
//import java.nio.channels.ReadableByteChannel;
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class HamXuLi {
//    String chuoi;
//    String tenFile = "index.html";
//    String tenThuMuc = "1612609";
//    String taoThuMuc = "D:\\";
//    ArrayList<String> arr = new ArrayList<String>();
//    ArrayList<String> dsLink = new ArrayList<>();
//
//    public HamXuLi() {
//        chuoi = "";
//        tenFile = "";
//        tenThuMuc = "";
//    }
//
//    public HamXuLi(String URL, String name, String thuMuc) {
//        chuoi = URL;
//        if (name != "") {
//            tenFile = name;
//        }
//        if (thuMuc != "") {
//            tenThuMuc = "D:\\"+thuMuc;
//        }
//        //  else tenFile="index.html";
//    }
//
//    public Boolean kiemTraKetNoi() {
//        try {
//            URL urlObj = new URL(chuoi);
//            HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();
//            con.setRequestMethod("GET");
//            con.setConnectTimeout(3000);
//            con.connect();
//            int code = con.getResponseCode();
//            if (code == 200) {
//                return true;
//            }
//        } catch (Exception e) {
//            return false;
//        }
//        return true;
//    }
//
//    public void batDau() {
//        if (kiemTraKetNoi() == true) {
//            new File(tenThuMuc).mkdir();
//            try {
//                URL website = new URL(chuoi);
//                ReadableByteChannel rbc = Channels.newChannel(website.openStream());
//                FileOutputStream fos = new FileOutputStream(tenThuMuc + "\\" + tenFile);
//                fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
//                fos.close();
//                dsLink.add(chuoi);
//                docTatCaDuongDan(chuoi);
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }
//            JOptionPane.showMessageDialog(null, "Kết nối thành công. Quá trình download sẽ được thực hiện");
//        } else {
//            JOptionPane.showMessageDialog(null, "Kết nối thất bại, vui lòng kiểm tra lại đường dẫn web");
//        }
//    }
//
//    public void Load(String a, String name) {
//        try {
//            URL website = new URL(a);
//            ReadableByteChannel rbc = Channels.newChannel(website.openStream());
//            FileOutputStream fos = new FileOutputStream(tenThuMuc + "\\" + taoThuMuc + "\\" + name);
//            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
//            fos.close();
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//    }
//
//    public void docTatCaDuongDan(String duongDan) throws IOException {
//        URL pagelocation = new URL(duongDan);
//        Scanner in = new Scanner(pagelocation.openStream());
//        int i = 0, t = 0;
//        String tenFileLuu;
//        while (in.hasNext()) {
//            String line = in.next();
//            // JOptionPane.showMessageDialog(null,line);
//            if (line.contains("href=\"")) {
//                int from = line.indexOf("\"");
//                int to = line.lastIndexOf("\"");
//                if (from != to) {
//                    arr.add(line.substring(from + 1, to));
//                    String M = duongDanChuan(line.substring(from + 1, to));
//                    if (kiemTraLinkNgoai(duongDan, M) == false) {
//                        if (laLinkTrung(M, dsLink) == false) {
//                            t = M.lastIndexOf("/");
//                            if (M.endsWith("/") == false) {
//                                tenFileLuu = M.substring(t + 1);
//                                if (tenFileLuu.contains(".") == false) {
//                                    tenFileLuu = tenFileLuu + ".html";
//                                }
//                                int k = M.indexOf("/", 9);
//                                if (k != t) {
//                                    taoThuMuc = M.substring(k + 1, t);
//                                }
//                                new File(tenThuMuc + "\\" + taoThuMuc).mkdirs();
//
//                            } else {
//                                tenFileLuu = "home" + i + ".html";
//                                i++;
//                            }
//                            //Load(M, tenFileLuu);
//                            taoThuMuc = "";
//                            dsLink.add(M);
//                        }
//                    }
//                    // JOptionPane.showMessageDialog(null, M);
//                    //JOptionPane.showMessageDialog(null, replaceDuongDan(M));
//                    //JOptionPane.showMessageDialog(null, replaceDuongDan(line));;
//                    // line = line.replace("href=\"", "href=\""+tenThuMuc+"\\"+replaceDuongDan(M));
//                    //line = line.replace("href=\"", "href=\""+tenThuMuc);
//                    //line = line.replace("/","\\");
//                    // line = line.replaceAll("/","\\");
//                    // JOptionPane.showMessageDialog(null, line);
//                }
//            }
//        }
//        FileOutputStream dsLink = new FileOutputStream(tenThuMuc + "\\" + "dsLink.txt");
//        for (String chay : arr) {
//            dsLink.write(chay.getBytes());
//            dsLink.write(' ');
//        }
//        dsLink.close();
//    }
//
//
//
//    public void layTatCaLink(String duongDan) throws IOException {
//        URL pagelocation = new URL(duongDan);
//        Scanner in = new Scanner(pagelocation.openStream());
//        while (in.hasNext()) {
//            String line = in.next();
//            // JOptionPane.showMessageDialog(null,line);
//            if (line.contains("href=\"")) {
//                int from = line.indexOf("\"");
//                int to = line.lastIndexOf("\"");
//                if (from != to) {
//                    String M = line.substring(from + 1, to);
//                    arr.add(M);
//                }
//            }
//        }
//    }
//
//    public String taoThuMuc(String link){
//        int t = link.lastIndexOf("/");
//        int i=0;
//        String tenFileLuu;
//        if (link.endsWith("/") == false) {
//            tenFileLuu = link.substring(t + 1);
//            if (tenFileLuu.contains(".") == false) {
//                tenFileLuu = tenFileLuu + ".html";
//            }
//            int k = link.indexOf("/", 9);
//            if (k != t) {
//                taoThuMuc = link.substring(k + 1, t);
//            }
//            new File(tenThuMuc + "\\" + taoThuMuc).mkdirs();
//
//        } else {
//            tenFileLuu = "home" + i + ".html";
//            i++;
//        }
//        return (tenThuMuc + "\\" + taoThuMuc + tenFileLuu);
//    }
//
//
//
//    public void taiTungTrang(String duongDan) throws IOException {
//        URL pagelocation = new URL(duongDan);
//        Scanner in = new Scanner(pagelocation.openStream());
//        int i = 0, t = 0;
//        String tenFileLuu = taoThuMuc(duongDan);
//        FileOutputStream fos = new FileOutputStream(tenFileLuu);
//        while (in.hasNext()) {
//            String line = in.nextLine();
//            String tmp = layLinkChuan(duongDan);
//            // JOptionPane.showMessageDialog(null,line);
//            line = line.replaceAll("href=\"http://www." + tmp+"\"","href=\"");
//            fos.write(line.getBytes());
//        }
//        fos.close();
//    }
//
//    public String layLinkChuan(String duongDan){
//        String tmp = duongDan;
//        if (tmp.startsWith("https://") == true) {
//            tmp = tmp.substring(8);
//            if (tmp.startsWith("www.") == true) {
//                tmp = tmp.substring(4);
//            }
//        } else if (tmp.startsWith("http://") == true) {
//            tmp = tmp.substring(7);
//            if (tmp.startsWith("www") == true) {
//                tmp = tmp.substring(4);
//            }
//        }
//        return tmp;
//    }
//
//
//
//
//
//    public String chuanHoaDuongDan(String duongDan) {
//        int dem = 0;
//        for (int i = 0; i < duongDan.length(); i++) {
//            if (duongDan.charAt(i) == '/') {
//                dem++;
//                if (dem == 3) {
//                    duongDan = duongDan.substring(0, i + 1);
//                    break;
//                }
//            }
//        }
//        if (dem == 2)
//            duongDan = duongDan + '/';
//        return duongDan;
//    }
//
//    public String duongDanChuan(String duongDan) {
//        if (duongDan.startsWith("http") == false) {
//            duongDan = chuanHoaDuongDan(chuoi) + duongDan;
////        }
//        }
//        return duongDan;
//    }
//
//    public Boolean laLinkTrung(String link, ArrayList<String> dsLink) {
//        for (String chay : dsLink) {
//            if (link.equals(chay)) {
//                dsLink.remove(link);
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public String catDuongDan(String duongDanCat) {
//        String tmp = duongDanCat;
//        int k = tmp.indexOf("/", 9);
//        if (tmp.startsWith("https://") == true) {
//            tmp = tmp.substring(8, k - 1);
//            if (tmp.startsWith("www.") == true) {
//                tmp = tmp.substring(4);
//            }
//        } else if (tmp.startsWith("http://") == true) {
//            tmp = tmp.substring(7, k - 1);
//            if (tmp.startsWith("www") == true) {
//                tmp = tmp.substring(4);
//            }
//        }
//        return tmp;
//    }
//
//    public boolean kiemTraLinkNgoai(String duongDanBanDau, String duongDan) {
//        String tmp = duongDan;
//        if (tmp.substring(tmp.lastIndexOf("/")).contains(".") == true)
//            return false;
//        if (catDuongDan(duongDanBanDau).equals(catDuongDan(duongDan)) == true)
//            return false;
//        return true;
//    }
//
//    public String replaceDuongDan(String duongDan){
//        String tmp = duongDan;
//
//        return tmp;
//    }
//}