package incubator.service;

import incubator.dao.StatisticRepository;
import incubator.model.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticService {

    @Autowired
    private StatisticRepository statisticRepository;


}
