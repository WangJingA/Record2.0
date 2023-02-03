package com.example.dayrecords.Utils;

import java.io.*;

public class SerializedUtil {
    //序列化
    public static byte [] serialize(Object obj) throws Exception {
        ByteArrayOutputStream bai = null;
        ObjectOutputStream obi = null;
        try {
            bai=new ByteArrayOutputStream();
            obi=new ObjectOutputStream(bai);
            obi.writeObject(obj);
            return bai.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(obi!=null){
                obi.close();
            }
            if(bai!=null){
                bai.close();
            }
        }
        return null;
    }

    //反序列化
    public static Object unserizlize(byte[] byt) throws Exception {
        ObjectInputStream oii=null;
        ByteArrayInputStream bis=null;
        try {
            bis=new ByteArrayInputStream(byt);
            oii=new ObjectInputStream(bis);
            return oii.readObject();
        } catch (Exception e) {

            e.printStackTrace();
        }finally {
            if(oii!=null){
                oii.close();
            }
            if(bis!=null){
                bis.close();
            }
        }
        return null;
    }
}
