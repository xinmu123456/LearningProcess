package xinmu.pojo;

import lombok.Data;

/**
 * author: xinmu
 * date: 2022/3/30
 * time: 17:02
 */

@Data
public class Student {
    private int id;
    private String name;

    //学生需要关联一个老师
    private Teacher teacher;
}
