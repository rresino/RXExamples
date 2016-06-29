package com.rresino.rx.pattern.eventdriven.service;

import java.util.List;

/**
 * Created by rresino on 29/02/2016.
 */
public interface EmailService {

    void sendMail(List<String> recipentList, String fromEmail, String subject, String text);

}
