public class Teacher {
    private int tescherId;
    private String teacherName;


    Teacher(int tescherId, String teacherName){
        this.tescherId = tescherId;
        this.teacherName = teacherName;
    }


    public int getTescherId(){
        return this.tescherId;
    }

    public String getTeacherName(){
        return this.teacherName;
    }
}
