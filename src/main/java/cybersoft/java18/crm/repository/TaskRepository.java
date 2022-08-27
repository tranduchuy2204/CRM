package cybersoft.java18.crm.repository;

import cybersoft.java18.crm.model.TaskModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TaskRepository extends AbstractRepository<TaskModel> {
    public List<TaskModel> getAllTask() {
        return executeQuery(connection -> {
            List<TaskModel> listTask = new ArrayList<>();
            String query = "select * from tasks";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                listTask.add(new TaskModel(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("start_date"),
                        resultSet.getString("end_date"),
                        resultSet.getInt("user_id"),
                        resultSet.getInt("jod_id"),
                        resultSet.getInt("status_id")
                ));
            }
            return listTask;
        });
    }
}
