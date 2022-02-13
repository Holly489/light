package qwer.QRCode;

import qwer.qwq.util.Insertion_Image_QRCodeUtil;

public class QrCodeTest {

    public static void main(String[] args) throws Exception {
        // 存放在二维码中的内容
        String text = "http://www.baidu.com";
        // 嵌入二维码的图片路径
        String imgPath = "D:\\Qwer\\qwer\\src\\main\\java\\qwer\\QRCode\\qwer.jpg";
        // 生成的二维码的路径及名称
        String destPath = "D:\\Qwer\\qwer\\WebContent\\img\\QR.jpg";
        //生成二维码
        Insertion_Image_QRCodeUtil.encode(text, imgPath, destPath, true);
        // 解析二维码
        String str = Insertion_Image_QRCodeUtil.decode(destPath);
        // 打印出解析出的内容
        System.out.println(str);

    }

}