package nlu.project.cdweb.custom;

import nlu.project.cdweb.entity.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Query {
    // ---- PRODUCT ----
    // init load
    public static String queryBanner() { return "SELECT * FROM slide where active = 1 GROUP BY idslide "; }
    public static String queryRam() { return "SELECT * FROM ram where active = 1 GROUP BY idram"; }
    public static String queryRom() { return "SELECT * FROM rom where active = 1 GROUP BY idrom"; }
    public static String queryBattery() { return "SELECT * FROM pin where active = 1 GROUP BY idpin"; }
    public static String queryBrand() { return "SELECT * FROM hang where active = 1 GROUP BY idhang"; }
    public static String queryPrice() { return "SELECT * FROM gia where active = 1 GROUP BY idtgia"; }

    // sale
    public static String querySale() {
        return "SELECT * FROM khuyenmai where active = 1 GROUP BY idkm";
    }
    // product
    public static String queryHomeProducts() {
        return "SELECT * FROM sanpham where active = 1 and tinhtrang = ? GROUP BY idsp ORDER by idsp DESC LIMIT " + Config.HOMEITEMS;
    }
    // description by id
    public static String queryProductDescription() {
        return "SELECT * FROM mota where idsp = ?";
    }
    // listproduct
    public static String queryProducts(int page) {
        return "SELECT * FROM sanpham where active = 1 GROUP BY idsp ASC LIMIT " + Config.LISTPRODUCT + " OFFSET " + (page-1) * Config.LISTPRODUCT;
    }
    //  listproduct with filter
    public static String queryProducts(int page, String condition) {
        return "SELECT * FROM sanpham where active = 1 and " + condition + " GROUP BY idsp LIMIT " + Config.LISTPRODUCT + " OFFSET " + (page-1) * Config.LISTPRODUCT;
    }
    // single product
    public static String queryProduct() { return "SELECT * FROM sanpham where active = 1 and idsp = ?"; }
    // relate product (same brand)
    public static String queryRelatedProduct(String idBrand,String id) {
        return "(select * from sanpham where idhang = "+idBrand+ " and idsp < "+id+" limit 4) "+
        "union (select * from sanpham where idhang = "+idBrand+ " and idsp > "+id+" limit 4)";
    }
    // ---- USER ----
    // login
    public static String login() {
        return "SELECT * FROM nguoidung where active = 1 and taikhoan= ? and matkhau= ?";
    }
    // register
    public static String register() {
        return "INSERT INTO nguoidung (taikhoan,matkhau,email,ten,active) value (?,?,?,?,-1)";
    }
    // active user
    public static String active() {
        return "update nguoidung set active = 1 where email=?";
    }
    // wishlist user
    public static String wishlist() {
        return "select * from yeuthich where iduser = ?";
    }
    // multi product by id      ex:(1,4,8,13,29)
    public static String listProductsByID(String listID) {
        return "SELECT * FROM sanpham where idsp in("+listID+ ")";
    }
    public static String order() {
        return "select * from donhang where iduser = ?";
    }
    public static String orderDetailsByID(String listID) {
        return "SELECT * FROM chitietdonhang where iddonhang in("+listID+ ")";
    }

    public static String count_home(){
        return "SELECT 'product' AS Result, COUNT(*) FROM sanpham\n" +
                "UNION SELECT 'user' AS Result, COUNT(*) FROM nguoidung\n" +
                "UNION SELECT 'event' AS Result, COUNT(*) FROM khuyenmai";
    }
    public static String count_productBrand(HttpSession session){
        String result = "";
        HashMap<String, Brand> listBrand = (HashMap<String, Brand>) session.getAttribute("listBrand");
        Iterator iteratorBrand = listBrand.entrySet().iterator();
        boolean union = false;
        while (iteratorBrand.hasNext()) {
            Brand brand = (Brand) ((Map.Entry) iteratorBrand.next()).getValue();
            if(union){
                result += "UNION SELECT "+brand.getId()+", COUNT(*) FROM sanpham WHERE idhang = "+brand.getId()+" ";
            }else {result += "SELECT "+brand.getId()+" AS Result, COUNT(*) FROM sanpham WHERE idhang = "+brand.getId()+" "; union = true;}
        }
        return result;
    }
    public static String count_productRam(HttpSession session){
        String result = "";
        HashMap<String, Ram> listRam = (HashMap<String, Ram>) session.getAttribute("listRam");
        Iterator iteratorRam = listRam.entrySet().iterator();
        boolean union = false;
        while (iteratorRam.hasNext()) {
            Ram ram = (Ram) ((Map.Entry) iteratorRam.next()).getValue();
            if(union){
                result += "UNION SELECT "+ram.getId()+", COUNT(*) FROM sanpham WHERE idram = "+ram.getId()+" ";
            }else {result += "SELECT "+ram.getId()+" AS Result, COUNT(*) FROM sanpham WHERE idram = "+ram.getId()+" "; union = true;}
        }
        return result;
    }
    public static String count_productRom(HttpSession session){
        String result = "";
        HashMap<String, Rom> listRom = (HashMap<String, Rom>) session.getAttribute("listRom");
        Iterator iteratorRom = listRom.entrySet().iterator();
        boolean union = false;
        while (iteratorRom.hasNext()) {
            Rom rom = (Rom) ((Map.Entry) iteratorRom.next()).getValue();
            if(union){
                result += "UNION SELECT "+rom.getId()+", COUNT(*) FROM sanpham WHERE idrom = "+rom.getId()+" ";
            }else {result += "SELECT "+rom.getId()+" AS Result, COUNT(*) FROM sanpham WHERE idrom = "+rom.getId()+" "; union = true;}
        }
        return result;
    }
    public static String count_productBattery(HttpSession session){
        String result = "";
        HashMap<String, Battery> listBattery = (HashMap<String, Battery>) session.getAttribute("listBattery");
        Iterator iteratorBattery = listBattery.entrySet().iterator();
        boolean union = false;
        while (iteratorBattery.hasNext()) {
            Battery battery = (Battery) ((Map.Entry) iteratorBattery.next()).getValue();
            if(union){
                result += "UNION SELECT "+battery.getId()+", COUNT(*) FROM sanpham WHERE idpin = "+battery.getId()+" ";
            }else {result += "SELECT "+battery.getId()+" AS Result, COUNT(*) FROM sanpham WHERE idpin = "+battery.getId()+" "; union = true;}
        }
        return result;
    }
    public static String count_productPrice(HttpSession session) {
        String result = "";
        HashMap<String, Price> listPrice = (HashMap<String, Price>) session.getAttribute("listPrice");
        Iterator iteratorPrice = listPrice.entrySet().iterator();
        boolean union = false;
        while (iteratorPrice.hasNext()) {
            Price price = (Price) ((Map.Entry) iteratorPrice.next()).getValue();
            if (union) {
                if (price.getEnd() != -1)
                    result += "UNION SELECT " + price.getId() + ", COUNT(*) FROM sanpham WHERE gia>" + price.getStart() + " and " + "gia<" + price.getEnd()+" ";
                else
                    result += "UNION SELECT " + price.getId() + ", COUNT(*) FROM sanpham WHERE gia>" + price.getStart()+" ";
            } else {
                if (price.getEnd() != -1){
                    result += "SELECT " + price.getId() + " AS Result, COUNT(*) FROM sanpham WHERE gia>" + price.getStart() + " and " + "gia<" + price.getEnd()+" ";union = true;}
                else{
                    result += "SELECT " + price.getId() + " AS Result, COUNT(*) FROM sanpham WHERE gia>" + price.getStart()+" ";union = true;}
            }
        }
        return result;
    }


    public static String count_productTotal(HttpSession session, String condition) {
        if (condition.equals("")) return "SELECT 'product' AS Result, COUNT(*) FROM sanpham";
        return "SELECT 'product' AS Result, COUNT(*) FROM sanpham where "+condition;
    }
}
