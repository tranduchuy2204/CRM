package cybersoft.java18.crm.api;

import com.google.gson.Gson;
import cybersoft.java18.crm.model.TaskModel;
import cybersoft.java18.crm.utils.UrlUtils;
import services.TaskServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "task", urlPatterns = {
        UrlUtils.TASK
})
public class TaskController extends HttpServlet {
    private final Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<TaskModel> taskModels = TaskServices.getInstance().getAllTask();
        String taskJson = gson.toJson(taskModels);
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.addHeader("Access-Control-Allow-Origin", "*");
        resp.setContentType("application/stream+json");
        PrintWriter printWriter = resp.getWriter();
        printWriter.print(taskJson);
        printWriter.flush();
    }
}
