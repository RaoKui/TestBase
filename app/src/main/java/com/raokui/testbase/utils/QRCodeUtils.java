package com.raokui.testbase.utils;

import android.app.Activity;
import android.graphics.Bitmap;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.raokui.testbase.R;

import java.util.Hashtable;

/**
 * Created by 20151203 on 2017/7/13.
 */

public class QRCodeUtils {

    /**
     * @param activity
     * @param msg      二维码的信息
     * @return
     */
    public static Bitmap createQRCode(Activity activity, String msg) {
        //二维码中包含的文本信息
        String contents = "BEGIN:CAREWEE" + "\nTYPE:Coupon\nCODE:" + msg + "\nEND:CAREWEE";
        Bitmap bitmap = null;
        try {
            // 判断URL合法性
            if (contents == null || "".equals(contents) || contents.length() < 1) {
                return bitmap;
            }
            Hashtable<EncodeHintType, String> hints = new Hashtable<EncodeHintType, String>();
            hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
            // 图像数据转换，使用了矩阵转换
            //TODO
            int QR_WIDTH = (int) activity.getResources().getDimension(R.dimen.activity_horizontal_margin);
            int QR_HEIGHT = (int) activity.getResources().getDimension(R.dimen.activity_horizontal_margin);
            BitMatrix bitMatrix = new QRCodeWriter().encode(contents,
                    BarcodeFormat.QR_CODE, QR_WIDTH, QR_HEIGHT, hints);
            int[] pixels = new int[QR_WIDTH * QR_HEIGHT];
            // 下面这里按照二维码的算法，逐个生成二维码的图片，
            // 两个for循环是图片横列扫描的结果
            for (int y = 0; y < QR_HEIGHT; y++) {
                for (int x = 0; x < QR_WIDTH; x++) {
                    if (bitMatrix.get(x, y)) {
                        pixels[y * QR_WIDTH + x] = 0xff000000;
                    } else {
                        pixels[y * QR_WIDTH + x] = 0xffffffff;
                    }
                }
            }
            // 生成二维码图片的格式，使用ARGB_8888
            bitmap = Bitmap.createBitmap(QR_WIDTH, QR_HEIGHT,
                    Bitmap.Config.ARGB_8888);
            bitmap.setPixels(pixels, 0, QR_WIDTH, 0, 0, QR_WIDTH, QR_HEIGHT);
        } catch (WriterException e) {
            e.printStackTrace();
            return null;
        }

        return bitmap;
    }

}
