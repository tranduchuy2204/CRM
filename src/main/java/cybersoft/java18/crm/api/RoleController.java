package cybersoft.java18.crm.api;

import com.google.gson.Gson;
import cybersoft.java18.crm.model.ResponseData;
import cybersoft.java18.crm.model.RoleModel;
import cybersoft.java18.crm.utils.UrlUtils;
import services.RoleServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

// api/role
@WebServlet(name = "role", urlPatterns = {
        UrlUtils.URL_ROLE,
        UrlUtils.URL_ROLE_ADD
})
public class RoleController extends HttpServlet {

    private final Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<RoleModel> roleModels = RoleServices.getInstance().getAllRole();
        PrintWriter printWriter = resp.getWriter();
        printWriter.print(gson.toJson(roleModels));
        printWriter.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String role = req.getParameter("role");
        String description = req.getParameter("description");
        System.out.println("kiem tra post " + role + " - " + description);
        Integer result = RoleServices.getInstance().saveRole(role, description);
        ResponseData responseData = new ResponseData();
        if (result == 1) {
            responseData.setStatusCode(200);
            responseData.setSuccess(true);
            responseData.setMessage("Thêm thành công");
        } else {
            responseData.setStatusCode(200);
            responseData.setMessage("Thêm thất bại");
            responseData.setSuccess(false);
        }
        PrintWriter printWriter = resp.getWriter();
        printWriter.print(gson.toJson(responseData));
        printWriter.flush();
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Integer result = RoleServices.getInstance().deleteRoleById(id);
        ResponseData responseData = new ResponseData();
        if (result == 1) {
            responseData.setStatusCode(200);
            responseData.setSuccess(true);
            responseData.setMessage("Xoá thành công");
        } else {
            responseData.setStatusCode(200);
            responseData.setMessage("Xoá thất bại");
            responseData.setSuccess(false);
        }
        PrintWriter printWriter = resp.getWriter();
        printWriter.print(gson.toJson(responseData));
        printWriter.flush();
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader br = new BufferedReader(req.getReader());
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            stringBuilder.append(line);
        }
        String data = stringBuilder.toString();
        RoleModel roleModel = gson.fromJson(data, RoleModel.class);

        Integer result = RoleServices.getInstance().updateRoleById(roleModel);
        ResponseData responseData = new ResponseData();
        if (result == 1) {
            responseData.setStatusCode(200);
            responseData.setSuccess(true);
            responseData.setMessage("Update thành công");
            
        } else {
            responseData.setStatusCode(200);
            responseData.setMessage("Update thất bại");
            responseData.setSuccess(false);
        }
        PrintWriter printWriter = resp.getWriter();
        printWriter.print(gson.toJson(responseData));
        printWriter.flush();
    }

}
