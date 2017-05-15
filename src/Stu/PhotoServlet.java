package Stu;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;


/**
 * Created by dim on 2017/5/14.
 */
@WebServlet(name = "PhotoServlet", urlPatterns = {"/PhotoServlet"})
public class PhotoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);

        try {
            List<FileItem> items = upload.parseRequest(request);
            int i = 0;
            FileItem fileItem = null;
            while (items.get(i)==null){
                 i++;
            }
            System.out.println("i" + i);
            fileItem = items.get(i);
            System.out.println("fileitem:" + fileItem);
            String storeDirectory = getServletContext().getRealPath("/images");
            System.out.println("storeDirectory" + storeDirectory);
            File uploadDir = new File(storeDirectory);
            System.out.println("file" + uploadDir);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            fileItem.write(new File(storeDirectory, fileItem.getName()));
            String filePath = "/images/" + fileItem.getName();
            System.out.println("filePath" + filePath);
            response.getWriter().print(filePath);
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
