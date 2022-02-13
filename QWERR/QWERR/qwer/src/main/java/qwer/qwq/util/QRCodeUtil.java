package qwer.qwq.util;


import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;

public class QRCodeUtil {
    /**
     * 生成二维码文件
     * @param savePath     文件路径
     * @param type 保存类型 比如 png
     * @param savePath 二维码保存路径
     * @param code_charset 编码方式比如utf-8
     * @param width 二维码宽 可为300
     * @param height 二维码高 可为300
     */
    public static void get_QRCode(String content, String type, String savePath, String code_charset, int width, int height) {
        // 定义二维码的配置，使用HashMap
        HashMap hints = new HashMap();
        // 字符集，内容使用的编码
        hints.put(EncodeHintType.CHARACTER_SET, code_charset);
        // 容错等级，H、L、M、Q
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        // 边距，二维码距离边的空白宽度
        hints.put(EncodeHintType.MARGIN, 2);
        try {
            // 生成二维码对象，传入参数：内容、码的类型、宽高、配置
            BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);
            // 定义一个路径对象
            Path file = new File(savePath).toPath();
            // 生成二维码，传入二维码对象、生成图片的格式、生成的路径
            MatrixToImageWriter.writeToPath(bitMatrix, type, file);
        } catch (WriterException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @Description: 解析二维码内容
     * @param filePath 二维码绝对路径
     * @param code_charset 编码方式
     * @return 二维码的内容
     */
    public static String decodeQRCode(String filePath, String code_charset) {
        try {
            // 声明一个解析二维码的对象
            MultiFormatReader formatReader = new MultiFormatReader();
            // 生成一个文件对象，传入刚才生成二维码的路径
            File file = new File(filePath);
            // 把文件对象转成一个图片对象
            BufferedImage image = ImageIO.read(file);
            // 最后需要的是一个binaryBitmap对象。
            BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));
            // 配置，解析时传入
            HashMap hints = new HashMap();
            hints.put(EncodeHintType.CHARACTER_SET, code_charset);
            // 解析得到一个Result对象，该对象包含二维码的信息
            Result result = formatReader.decode(binaryBitmap, hints);
            // 分别输出二维码类型和内容的方法
            System.out.println(result.getBarcodeFormat());
            System.out.println(result.getText());
            return result.getText();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}