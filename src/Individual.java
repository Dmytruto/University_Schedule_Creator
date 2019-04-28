public class Individual {
    private int[] chromosome;
    private double fitness = -1;

    public Individual(Schedule timetable) {
        int numClasses = timetable.getNumClasses();
        int chromosomeLength = numClasses * 3;
        int newChromosome[] = new int[chromosomeLength];
        int chromosomeIndex = 0;
        for (Group group : timetable.getGroups().values()) {
            for (int subjectId : group.getSubjectIds()) {
                newChromosome[chromosomeIndex++] = timetable.getRandomTime().getTimeId();
                newChromosome[chromosomeIndex++] = timetable.getRandomAudience().getAudienceId();
                newChromosome[chromosomeIndex++] = timetable.getSubject(subjectId).getRandomTeachersId();
            }
        }

        this.chromosome = newChromosome;
    }

    public Individual(int chromosomeLength) {
        int[] individual;
        individual = new int[chromosomeLength];
        for (int gene = 0; gene < chromosomeLength; gene++) {
            individual[gene] = gene;
        }
        this.chromosome = individual;
    }

    public int[] getChromosome() {
        return this.chromosome;
    }

    public int getChromosomeLength() {
        return this.chromosome.length;
    }

    public void setGene(int offset, int gene) {
        this.chromosome[offset] = gene;
    }


    public int getGene(int offset) {
        return this.chromosome[offset];
    }


    public void setFitness(double fitness) {
        this.fitness = fitness;
    }


    public double getFitness() {
        return this.fitness;
    }


}
