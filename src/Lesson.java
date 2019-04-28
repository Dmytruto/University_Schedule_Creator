public class Lesson {
    private int lessonId;
    private int audienceId;
    private int groupId;
    private int subjectId;
    private int teacherId;
    private int timeId;


    Lesson(int lessonId, int groupId, int subjectId){
        this.lessonId = lessonId;
        this.groupId = groupId;
        this.subjectId = subjectId;
    }

    public void setAudienceId(int audienceId){
        this.audienceId = audienceId;
    }

    public void setTeacherId(int teacherId){
        this.teacherId = teacherId;
    }

    public void setTimeId(int timeId){
        this.timeId = timeId;
    }

    public int getLessonId(){
        return this.lessonId;
    }

    public int getAudienceId(){
        return this.audienceId;
    }

    public int getGroupId(){
        return this.groupId;
    }

    public int getSubjectId(){
        return this.subjectId;
    }

    public int getTeacherId(){
        return this.teacherId;
    }

    public int getTimeId(){
        return this.timeId;
    }

}
