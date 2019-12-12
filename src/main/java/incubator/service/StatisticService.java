package incubator.service;

import incubator.dao.StatisticRepository;
import incubator.model.Statistic;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class StatisticService {

    @Autowired
    private StatisticRepository statisticRepository;


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
    public void save(Statistic statistic) {
        statisticRepository.save(statistic, statisticRepository.getBeanToBeAutowired());
    }

}
