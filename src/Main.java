import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws ParseException {
        Schedule schedule = new Schedule().initializeConcreateSchedule();
        GeneticAlgorithm ga = new GeneticAlgorithm(100, 0.01, 0.9, 2, 5);
        Population population = ga.initPopulation(schedule);
        ga.evalPopulation(population, schedule);
        int generation = 0;

        while (generation < 1000 && population.getFittest(0).getFitness() != 1.0 ) {
            System.out.println("G" + generation + " Найкраща пристосованість: " + population.getFittest(0).getFitness());
            population = ga.crossoverPopulation(population);
            population = ga.mutatePopulation(population, schedule);
            ga.evalPopulation(population, schedule);
            generation++;
        }
        schedule.createLessons(population.getFittest(0));
        System.out.println();
        System.out.println("Рішення було знайдене за таку кількість поколінь " + generation);
        System.out.println("Пристосованість рішення: " + population.getFittest(0).getFitness());
        System.out.println("Не зістиковок в поточному розкладі: " + schedule.calcClashes());
        System.out.println();
        ArrayList<Lesson> lessons = new ArrayList<>(Arrays.asList(schedule.getLessons()));
        int previousGroup = -1;
        Comparator<Lesson> comparator = Comparator.comparing(Lesson::getGroupId)
                .thenComparing(lesson -> schedule.getTime(lesson.getTimeId()).getDay())
                .thenComparing(lesson -> schedule.getTime(lesson.getTimeId()).getLessonStartHour());

        Stream <Lesson> lessonsStream = lessons.stream().sorted(comparator);
        List<Lesson> sortedLessons = lessonsStream.collect(Collectors.toList());
        for (Lesson bestClass : sortedLessons) {
            if(schedule.getGroup(bestClass.getGroupId()).getGroupId() != previousGroup ){
                System.out.println("++++++++++++++++++++++");
                System.out.println("Група: " + schedule.getGroup(bestClass.getGroupId()).getGroupId());
                previousGroup = schedule.getGroup(bestClass.getGroupId()).getGroupId();
            }
            System.out.println("Предмет: " +
                    schedule.getSubject(bestClass.getSubjectId()).getSubjectName());
            System.out.println("Аудиторія: " +
                    schedule.getAudience(bestClass.getAudienceId()).getAudienceNumber());
            System.out.println("Викладач: " +
                    schedule.getTeacher(bestClass.getTeacherId()).getTeacherName());
            System.out.println("Час: " +
                    schedule.getTime(bestClass.getTimeId()).getTime());
            System.out.println("-----");
        }
    }


}
