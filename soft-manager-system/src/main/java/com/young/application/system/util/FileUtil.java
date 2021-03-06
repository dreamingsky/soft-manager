package com.young.application.system.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by huiyangchen1 on 2017/6/26.
 */
public class FileUtil {

    private static Logger logger = LoggerFactory.getLogger(FileUtil.class);

    private static String path = "";

    public static String upload(String filename,InputStream in){
        String suffix = filename.substring(filename.lastIndexOf("."));
        String filepath = FileUtil.class.getResource("/").getPath();
        String newFileName = "static/image/"+System.currentTimeMillis()+suffix;
        OutputStream ot = null;
        try {

            byte[] buffer = new byte[1024];
            File file = new File(filepath+newFileName);
            if(!file.exists())
                file.createNewFile();
            ot = new FileOutputStream(file);
            int len;
            while ((len = in.read(buffer)) !=-1){
                ot.write(buffer,0,len);
            }

        }catch (Exception e){
            logger.error("file",e);
        }finally {
            try {
                if(ot!=null)
                    ot.close();
            }catch (Exception e){
                logger.error("file",e);
            }

        }


        return newFileName;

    }

    public static void delete(String filename){
        String filepath = FileUtil.class.getResource("/").getPath();
        try {
            if(!StringUtils.isEmpty(filename)){
                File file = new File(filepath+filename);
                if(file.exists())
                    file.delete();
            }

        }catch (Exception e){
            logger.error("file",e);
        }
    }
}
