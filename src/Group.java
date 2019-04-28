public class Group {

    private int groupId;
    private int groupSize;
    private int subjectIds[];

    Group(int groupId, int groupSize, int moduleIds[]){
        this.groupId = groupId;
        this.groupSize = groupSize;
        this.subjectIds = moduleIds;
    }

    public int getGroupId(){
        return this.groupId;
    }

    public int getGroupSize(){
        return this.groupSize;
    }

    public int[] getSubjectIds(){
        return this.subjectIds;
    }

}
