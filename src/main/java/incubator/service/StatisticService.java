package incubator.service;

import incubator.dao.StatisticRepository;
import incubator.model.Question;
import incubator.model.Statistic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class StatisticService {

    @Autowired
    private StatisticRepository statisticRepository;

    public Map<String, Statistic> statList;

    public List<Statistic> findAll() {
        return statisticRepository.findAll(Statistic.class, statisticRepository.getBeanToBeAutowired());
    }

    public void userStatistic(int id) {
        double userRate = 0;
        int var = 0;
        List<Statistic> list = statisticRepository.findAll(Statistic.class, statisticRepository.getBeanToBeAutowired());
        List<Statistic> allUserList = new ArrayList<>();
        List<Statistic> correctUserList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUser().getUserId() == id) {
                if (list.get(i).getCorrect() == 1) {
                    correctUserList.add(list.get(i));
                }
                allUserList.add(list.get(i));
                var = i;
            }
        }

        userRate = ((double) correctUserList.size() / allUserList.size()) * 100;
        System.out.println("Рейтинг пользователя " + list.get(var).getUser().getFirstName() + " - " + userRate + "%");
    }

    @Transactional
    public void saveMapOfStat(Map<String, Statistic> map, String endTest) {
        for (Statistic st : map.values()
        ) {
            st.setDate(endTest);
            testingCreateMethod(st);
        }
    }


    public List<QuestionStatModel> getStatList(int userId) {
        return statisticRepository.personalUserStatistic(userId);
    }

    @Transactional
    public void testingCreateMethod(Statistic statistic) {
        statisticRepository.testingCreateMethod(statistic, statisticRepository.getBeanToBeAutowired());
    }

    public List<Statistic> selectUserTestStatistic(String userId, String start, String end) {
        return statisticRepository.personalUserTestStatistic(userId, start, end);
    }

    public Map<String, Statistic> getStatList() {
        return statList;
    }

    public void setStatList(Map<String, Statistic> statList) {
        this.statList = statList;
    }
}


