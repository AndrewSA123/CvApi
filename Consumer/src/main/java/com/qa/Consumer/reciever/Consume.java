package com.qa.Consumer.reciever;

import com.qa.Consumer.persistence.domain.Admin;
import com.qa.Consumer.persistence.repository.JpaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consume {

    @Autowired
    private JpaRepo repo;

    @JmsListener(destination = "BabyQueue", containerFactory = "myFactory")
    public void receiveMessage(Admin admin){
        repo.save(admin);
    }

    @JmsListener(destination = "BabyQueueDelete", containerFactory = "myFactory")
    public void receiveDelete(Admin admin){
        repo.delete(admin);
    }

}
