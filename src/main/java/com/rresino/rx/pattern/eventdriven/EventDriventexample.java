package com.rresino.rx.pattern.eventdriven;

import com.rresino.rx.pattern.eventdriven.service.*;

/**
 * Created by rresino on 29/02/2016.
 */
public class EventDriventexample {


    public static void main(String[] args) {

        try {

            EmailService emailService = new EmailServiceImpl();
            UserService userService = new UserServiceImpl();

            // Link/subcribe userSrvice with emailService
            new EmailMonitor(emailService, userService);

            userService.addUser("John Snow", "john.snow@gmail.com");

            Thread.sleep(2000);

        } catch (Throwable t) {
            t.printStackTrace();
        }

    }
}
