package com.dvimer.rabbitmq.habr;

import org.apache.log4j.Logger;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController {
    Logger logger = Logger.getLogger(SampleController.class);

    @Autowired
    AmqpTemplate template;

    @RequestMapping("/emit")
    @ResponseBody
    String queue1() {
        logger.info("Emit to queue1");
        template.convertAndSend("queue1", "Message to queue");
        return "Emit to queue";
    }

    @RequestMapping("/testic")
    @ResponseBody
    String testic() {
        logger.info("Emit to queue1");
        String warning = "WARNING";
        System.out.println(warning);
        return warning;
    }
}
