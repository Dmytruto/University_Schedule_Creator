import java.time.DayOfWeek;
import java.util.*;

public class Schedule {

    private HashMap<Integer, Audience> audiences;
    private HashMap<Integer, Group> groups;
    private HashMap<Integer, Subject> subjects;
    private HashMap<Integer, Teacher> teachers;
    private HashMap<Integer, Time> times;

    private Lesson lessons[];

    private int numberOfLessons = 0;

    Schedule(){
        this.audiences = new HashMap<>();
        this.groups = new HashMap<>();
        this.subjects = new HashMap<>();
        this.teachers = new HashMap<>();
        this.times = new HashMap<>();
    }

    Schedule(Schedule clonable){
        this.audiences = clonable.getAudiences();
        this.groups = clonable.getGroups();
        this.subjects = clonable.getSubjects();
        this.teachers = clonable.getTeachers();
        this.times = clonable.getTimes();
    }

    public static Schedule initializeConcreateSchedule() {

        Schedule schedule = new Schedule();
        schedule.addAudience(1, 221, 15);
        schedule.addAudience(2, 224, 15);
        schedule.addAudience(3, 225, 120);
        schedule.addAudience(4, 456, 30);
        schedule.addAudience(5, 124, 100);
        schedule.addAudience(6, 453, 100);
        schedule.addAudience(7, 007, 100);

        schedule.addTime(1, DayOfWeek.MONDAY, "8:30 - 10:05");
        schedule.addTime(2, DayOfWeek.MONDAY,"10:20 − 11:55");
        schedule.addTime(3, DayOfWeek.MONDAY,"12:10 − 13:45");
        schedule.addTime(4, DayOfWeek.MONDAY,"14:15 − 15:50");
        schedule.addTime(5, DayOfWeek.MONDAY,"16:00 − 17:35");
        schedule.addTime(6, DayOfWeek.TUESDAY,"8:30 - 10:05");
        schedule.addTime(7, DayOfWeek.TUESDAY,"10:20 − 11:55");
        schedule.addTime(8, DayOfWeek.TUESDAY,"12:10 − 13:45");
        schedule.addTime(9, DayOfWeek.TUESDAY,"14:15 − 15:50");
        schedule.addTime(10, DayOfWeek.TUESDAY,"16:00 − 17:35");
        schedule.addTime(11, DayOfWeek.WEDNESDAY,"8:30 - 10:05");
        schedule.addTime(12, DayOfWeek.WEDNESDAY,"10:20 − 11:55");
        schedule.addTime(13, DayOfWeek.WEDNESDAY,"12:10 − 13:45");
        schedule.addTime(14, DayOfWeek.WEDNESDAY,"14:15 − 15:50");
        schedule.addTime(15, DayOfWeek.WEDNESDAY,"16:00 − 17:35");
        schedule.addTime(16, DayOfWeek.THURSDAY,"8:30 - 10:05");
        schedule.addTime(17, DayOfWeek.THURSDAY,"10:20 − 11:55");
        schedule.addTime(18, DayOfWeek.THURSDAY,"12:10 − 13:45");
        schedule.addTime(19, DayOfWeek.THURSDAY,"14:15 − 15:50");
        schedule.addTime(20, DayOfWeek.THURSDAY,"16:00 − 17:35");
        schedule.addTime(21, DayOfWeek.FRIDAY,"8:30 - 10:05");
        schedule.addTime(22, DayOfWeek.FRIDAY,"10:20 − 11:55");
        schedule.addTime(23, DayOfWeek.FRIDAY,"12:10 − 13:45");
        schedule.addTime(24, DayOfWeek.FRIDAY,"14:15 − 15:50");
        schedule.addTime(25, DayOfWeek.FRIDAY,"16:00 − 17:35");

        schedule.addTeacher(1, "Буров Є.В");
        schedule.addTeacher(2, "Бойко Н.І");
        schedule.addTeacher(3, "Матвійчук Я.М");
        schedule.addTeacher(4, "Тренер з фізкультури №1");
        schedule.addTeacher(5, "Швороб І.Б");
        schedule.addTeacher(6, "Панчак Р.Т");
        schedule.addTeacher(7, "Андруник В.А");
        schedule.addTeacher(8, "Пелещишин О.П");
        schedule.addTeacher(9, "Соколовський Я.І");
        schedule.addTeacher(10, "Мельникова Н.І");
        schedule.addTeacher(11, "Гасько Р.Т");
        schedule.addTeacher(12, "Тимощук П.");
        schedule.addTeacher(13, "Савчук В.В");
        schedule.addTeacher(14, "Виклюк Я.І");
        schedule.addTeacher(15, "Тренер з фізкультури №2");
        schedule.addTeacher(16, "Гутовська О.В");


        schedule.addSubject(1, "Комп'ютерні мережі", new int[] { 1, 7 });
        schedule.addSubject(2,  "Системний аналіз", new int[] { 2 });
        schedule.addSubject(3,  "Комп'ютерна схемотехніка", new int[] { 3, 6, 12 });
        schedule.addSubject(4,  "Фізкультура", new int[] { 4, 15 });
        schedule.addSubject(5,  "Бази даних", new int[] { 5, 10, 14 });
        schedule.addSubject(6,  "Математичні методи дослідження операцій", new int[] { 2, 8 });
        schedule.addSubject(7, "Веб-технології та веб-дизайн", new int[] { 2, 11 });
        schedule.addSubject(7, "Філософія", new int[] {16 });

        schedule.addGroup(1, 10, new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 3, 4, 5, 6, 7});
        schedule.addGroup(2, 25, new int[] { 1, 2, 3, 4, 5, 6, 7});
        schedule.addGroup(3, 38, new int[] { 1, 2, 3, 4, 5, 6, 7});
        schedule.addGroup(4, 14, new int[] { 1, 2, 3, 4, 5, 6, 7});

        return schedule;
    }

    public HashMap<Integer, Audience> getAudiences(){
        return this.audiences;
    }

    public HashMap<Integer, Group> getGroups(){
        return this.groups;
    }

    public HashMap<Integer, Subject> getSubjects(){
        return this.subjects;
    }

    public HashMap<Integer, Teacher> getTeachers(){
        return this.teachers;
    }

    public HashMap<Integer, Time> getTimes(){
        return this.times;
    }

    public Lesson[] getLessons(){
        return this.lessons;
    }

    public void addAudience(int audienceId, int audienceNumber, int audienceCapacity){
        this.audiences.put(audienceId, new Audience(audienceId, audienceNumber, audienceCapacity));
    }

    public void addTeacher(int teacherId, String teacherName){
        this.teachers.put(teacherId, new Teacher(teacherId, teacherName));
    }

    public void addGroup(int groupId, int groupSize, int subjectIds[]){
        this.groups.put(groupId, new Group(groupId,groupSize,subjectIds));
    }

    public void addSubject(int subjectId,  String subjectName, int teachersIds[]){
        this.subjects.put(subjectId, new Subject(subjectId, subjectName, teachersIds));
    }

    public void addTime(int timeId, DayOfWeek day, String time){
        this.times.put(timeId, new Time(timeId, day,  time));
    }

    public void createLessons(Individual individual){
        Lesson lessons[] = new Lesson[this.getNumClasses()];

        int chromosome[] = individual.getChromosome();
        int chromosomePos = 0;
        int lessonIndex = 0;

        for (Group group : this.getGroups().values()) {
            int subjectIds[] = group.getSubjectIds();
            for (int subjectId : subjectIds) {
                lessons[lessonIndex] = new Lesson(lessonIndex, group.getGroupId(), subjectId);
                lessons[lessonIndex].setTimeId(chromosome[chromosomePos++]);
                lessons[lessonIndex].setAudienceId(chromosome[chromosomePos++]);
                lessons[lessonIndex].setTeacherId(chromosome[chromosomePos++]);
                lessonIndex++;
            }
        }
        this.lessons = lessons;
    }

    public int getNumClasses() {
        if (this.numberOfLessons > 0) {
            return this.numberOfLessons;
        }

        int numberOfLessons = 0;
        for (Group group : this.groups.values().toArray(new Group[this.groups.size()])) {
            numberOfLessons += group.getSubjectIds().length;
        }
        this.numberOfLessons = numberOfLessons;

        return this.numberOfLessons;
    }

    public int calcClashes() {
        int clashes = 0;

        for (Lesson lessonA : this.lessons) {
            int roomCapacity = this.getAudience(lessonA.getAudienceId()).getCapacity();
            int groupSize = this.getGroup(lessonA.getGroupId()).getGroupSize();

            if (roomCapacity < groupSize) {
                clashes++;
            }

            for (Lesson lessonB : this.lessons) {
                if (lessonA.getAudienceId() == lessonB.getAudienceId() && lessonA.getTimeId() == lessonB.getTimeId()
                        && lessonA.getLessonId() != lessonB.getLessonId()) {
                    clashes++;
                    break;
                }
            }

            for (Lesson lessonB : this.lessons) {
                if (lessonA.getTeacherId() == lessonB.getTeacherId() && lessonA.getTimeId() == lessonB.getTimeId()
                        && lessonA.getLessonId() != lessonB.getLessonId()) {
                    clashes++;
                    break;
                }
            }

            for (Lesson lessonB : this.lessons) {
                if(lessonA.getTimeId() == lessonB.getTimeId() && lessonA.getGroupId() == lessonB.getGroupId() && lessonA.getLessonId() != lessonB.getLessonId()){
                    clashes++;
                    break;
                }
            }
        }

        return clashes;
    }

    public Audience getAudience(int audienceId){
        return this.audiences.get(audienceId);
    }

    public Teacher getTeacher(int teacherId){
        return this.teachers.get(teacherId);
    }

    public Subject getSubject(int subjectId){
        return this.subjects.get(subjectId);
    }

    public Group getGroup(int groupId){
        return this.groups.get(groupId);
    }

    public Time getTime(int timeId){
        return this.times.get(timeId);
    }

    public Audience getRandomAudience(){
        Object tempArray[] = this.audiences.values().toArray();
        return (Audience)tempArray[new Random().nextInt(tempArray.length)];
    }

    public Time getRandomTime(){
        Object tempArray[] = this.times.values().toArray();
        return (Time)tempArray[new Random().nextInt(tempArray.length)];
    }

}
