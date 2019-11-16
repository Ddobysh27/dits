package incubator.service;

import incubator.dao.TopicRepository;
import incubator.model.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TopicService {

    @Autowired
    TopicRepository topicRepository;

    @Transactional
    public void save(Topic topic) {
        topicRepository.save(topic);
    }
}
