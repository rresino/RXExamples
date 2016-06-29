package com.rresino.rx.pattern.eventdriven.service;

import rx.Observer;
import rx.functions.Action1;

/**
 * Created by rresino on 29/02/2016.
 */
public interface UserService {

    void addUser(String username, String email);

    void subscribeToUserEvents(Observer<UserEvent> subscribe);
    void subscribeToUserEvents(Action1<UserEvent> onNext);

}
