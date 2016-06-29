package com.rresino.rx.main.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rresino on 28/02/2016.
 */
public class Generator {

    final private static String[] GEEK_ALPHABET = new String[]{
            "alpha", "beta", "gamma", "delta", "epsilon", "zeta", "eta", "theta", "iota", "kappa", "lambda", "mu",
            "nu", "xi", "omicron", "pi", "rho", "sigma", "tau", "upsilon", "phi", "chi", "psi", "omega"};

    public static String[] getGeekAlphabet() {
        return GEEK_ALPHABET;
    }

    public static List<Integer> getListIntegers(final int max) {
        List<Integer> result = new ArrayList(max);
        for (int i=1; i<=max; i++) {
            result.add(i);
        }
        return result;
    }
}
