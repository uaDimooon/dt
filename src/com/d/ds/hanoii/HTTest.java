package com.d.ds.hanoii;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Stack;

class HTTest {

    @Test
    void play() {
        final HT ht = new HT(0);
        List<Stack<Integer>> result = ht.play();
        System.out.println("r: " + result);
        assert true;
    }
}