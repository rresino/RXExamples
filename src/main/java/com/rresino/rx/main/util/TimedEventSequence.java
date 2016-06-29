package com.rresino.rx.main.util;

import com.rresino.rx.main.util.ThreadUtils;
import rx.Observable;
import rx.subjects.BehaviorSubject;
import rx.subjects.Subject;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/**
 * Created by rresino on 28/02/2016.
 */
public class TimedEventSequence<T> {

    final private long timeToWait;
    final private boolean paused = true;
    final List<T> elements;

    private Observable<T> subject;

    public TimedEventSequence(long timeToWait, List<T> elements) {
        this.timeToWait = timeToWait;
        this.elements = elements;
        this.subject = Observable.from(elements).delay(this.timeToWait, TimeUnit.MILLISECONDS);
    }

    public TimedEventSequence(long timeToWait, T[] elements) {
        this.timeToWait = timeToWait;
        this.elements = Arrays.asList(elements);
        this.subject = Observable.from(elements).delay(this.timeToWait, TimeUnit.MILLISECONDS);
    }

    public Observable<T> toObservable(){
        return this.subject;
    }
}
