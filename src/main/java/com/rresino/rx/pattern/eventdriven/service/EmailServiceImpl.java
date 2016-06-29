package com.rresino.rx.pattern.eventdriven.service;

import java.util.List;

/**
 * Created by rresino on 29/02/2016.
 */
public class EmailServiceImpl implements EmailService {

    @Override
    public void sendMail(List<String> recipentList, String fromEmail, String subject, String text) {

        System.out.println();
        System.out.println("Send Email: ");
        System.out.println("\t\tfrom: "+fromEmail);
        recipentList.forEach((to)-> System.out.println("\t\tto:"+to));
        System.out.println("\t\tsubject:"+subject);
        System.out.println();
        System.out.println("\t\tsubject:"+text);
        System.out.println();
    }

}
