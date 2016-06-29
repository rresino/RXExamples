package com.rresino.rx.pattern.eventdriven.service;

import rx.Observer;
import rx.functions.Action1;
import rx.subjects.PublishSubject;

/**
 * Created by rresino on 29/02/2016.
 */
public class UserServiceImpl implements UserService {

    private final PublishSubject<UserEvent> userEventSubject;

    public UserServiceImpl(){
        this.userEventSubject = PublishSubject.create();
    }

    @Override
    public void addUser(String username, String email) {

        System.out.println("Add user "+username+" - "+email);

        UserEvent userEvent = new UserEvent(username, email);

        this.userEventSubject.onNext(userEvent);

    }

    @Override
    public void subscribeToUserEvents(Observer<UserEvent> subscribe) {
        this.userEventSubject.subscribe(subscribe);
    }

    @Override
    public void subscribeToUserEvents(Action1<UserEvent> onNext) {
        this.userEventSubject.subscribe(onNext);
    }
}
