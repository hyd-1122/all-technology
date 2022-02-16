package org.fkit.fileuploadtest.controller;


import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileUtil {


    /**
     * 备份报文,生成文件保存至本地
     * @param tranMngNo
     */
    public static void createXmlFile(String xml,String tranMngNo,String filePath){
        XMLWriter out = null;
        BufferedWriter bw = null;
        OutputStreamWriter osw = null;
        FileOutputStream fos = null;

        SimpleDateFormat smf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String date_str = smf.format(date);

        try {
            File path = new File(filePath+date_str);
            if(!path.exists()){
                path.mkdirs();
            }
            smf.applyPattern("yyyyMMdd-HHmmss");
            File xmlFile = new File(path.getPath()+"\\"+tranMngNo+"("+smf.format(date)+").xml");//输出xml的路径
            if(!xmlFile.exists()){
                xmlFile.createNewFile();
            }
            fos = new FileOutputStream(xmlFile);
            osw = new OutputStreamWriter(fos,"UTF-8");//指定编码，防止写中文乱码
            bw = new BufferedWriter(osw);

            //对xml输出格式化
            OutputFormat format = OutputFormat.createPrettyPrint();
            format.setEncoding("UTF-8");
            out = new XMLWriter(bw, format);
            Document document = DocumentHelper.parseText(xml);
            out.write(document);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            try {
                if(out != null) {
                    out.close();
                }
                if(bw != null) {
                    bw.close();
                }
                if(osw != null) {
                    osw.close();
                }
                if(fos != null) {
                    fos.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
