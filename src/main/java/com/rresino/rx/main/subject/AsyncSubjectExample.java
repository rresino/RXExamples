package com.rresino.rx.main.subject;

import com.rresino.rx.main.util.Generator;
import rx.Observable;
import rx.subjects.AsyncSubject;
import rx.subjects.BehaviorSubject;

/**
 * Created by rresino on 28/02/2016.
 */
public class AsyncSubjectExample {

    public static void main(String[] args) {

        AsyncSubject<String> subject = AsyncSubject.create();

        subject.subscribe((letter) -> System.out.println(letter));

        Observable.from(Generator.getGeekAlphabet())
                .subscribe(
                        (letter)->subject.onNext(letter),
                        (t)->subject.onError(t),
                        ()->subject.onCompleted());

    }


}
