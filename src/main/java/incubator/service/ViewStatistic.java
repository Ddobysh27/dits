package incubator.service;

public class ViewStatistic {
    private String name;
    private int countCompleted;
    private int percent;

    public ViewStatistic() {
    }

    public ViewStatistic(String name, int countCompleted, int percent) {
        this.name = name;
        this.countCompleted = countCompleted;
        this.percent = percent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountCompleted() {
        return countCompleted;
    }

    public void setCountCompleted(int countCompleted) {
        this.countCompleted = countCompleted;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    @Override
    public String toString() {
        return "StatisticByQuestion{" +
                "questionDescription='" + name + '\'' +
                ", countCompleted=" + countCompleted +
                ", percent=" + percent +
                '}';
    }
}
