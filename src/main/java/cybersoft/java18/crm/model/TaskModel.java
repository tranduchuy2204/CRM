package cybersoft.java18.crm.model;

import lombok.Data;

@Data
public class TaskModel {
    private int id;
    private String name;
    private String startDate;
    private String endDate;
    private int userId;
    private int jodId;
    private int statusId;

    public TaskModel(int id, String name, String startDate, String endDate, int userId, int jodId, int statusId) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.userId = userId;
        this.jodId = jodId;
        this.statusId = statusId;
    }
}
