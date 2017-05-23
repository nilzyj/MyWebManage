package Stu;

import Util.DbUtil;
import jdk.internal.util.xml.impl.Input;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import static Util.DbUtil.getConn;


/**
 * Created by dim on 2017/5/14.
 */
@WebServlet(name = "PhotoServlet", urlPatterns = {"/PhotoServlet"})
public class PhotoServlet extends HttpServlet {
    private String filePath = "F:/Code/bishe/MyWebManage/web/image/";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        UUID uuid = UUID.randomUUID();
        String fileName = uuid.toString();
        Connection con = getConn();
        Calendar calendar = Calendar.getInstance();
        Statement sm = null;
        ResultSet rs = null;

        try {
            List<FileItem> items = upload.parseRequest(request);
            FileItem fileItem = items.get(0);

            sm = con.createStatement();
            sm.executeUpdate("UPDATE stu_all_info SET stu_photo='"
                    + fileName + "' WHERE stu_name='" + fileItem.getName() + "' AND stu_year='"
                    + calendar.get(Calendar.YEAR) + "'");

            System.out.println(fileItem.getFieldName());
            fileItem.write(new File(filePath, fileName + ".jpg"));
            System.out.println("filePath:" + filePath + fileItem.getName() + ".jpg");
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtil.dbClose(con, sm, rs);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    private static String getStreamFromInputstream(InputStream is) throws Exception {
        //创建字节输出流对象
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        //定义缓冲区
        byte[] buffer = new byte[1024];
        //定义读取的长度
        int len = -1;
        while ((len = is.read(buffer)) != -1) {
            baos.write(buffer, 0, len);
        }
        is.close();
        baos.close();
        String result = baos.toString();
        return result;
    }
}
