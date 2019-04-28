import java.util.Random;

public class Subject {

    private int subjectId;

    private String subjectName;
    private int teachersIds[];

    Subject(int subjectId, String subjectName, int teachersIds[]){
        this.subjectId = subjectId;

        this.subjectName = subjectName;
        this.teachersIds = teachersIds;
    }

    public int getSubjectId(){
        return this.subjectId;
    }

    public String getSubjectName(){
        return this.subjectName;
    }

    public int getRandomTeachersId(){
        return this.teachersIds[new Random().nextInt(this.teachersIds.length)];
    }


}
