package com.rresino.rx.pattern.eventdriven.service;

import java.util.ArrayList;

/**
 * Created by rresino on 29/02/2016.
 */
public class EmailMonitor {

    private final EmailService emailService;

    public EmailMonitor(EmailService emailService, UserService userService) {
        this.emailService = emailService;
        userService.subscribeToUserEvents(this::handleUserEvent);
    }

    private void handleUserEvent(UserEvent event) {
        System.out.println("EmailMonitor::handleUserEvent - " + Thread.currentThread().getName());

        ArrayList<String> recipList = new ArrayList<>(1);
        recipList.add(event.getEmail());
        emailService.sendMail(recipList, event.getUsername(),
                "Subject "+event.getEventDate(), "Content "+event.getEventDate());
    }
}
