package com.d.ds.hanoii;

import java.util.*;

    public class HT {
        final List<Stack<Integer>> pegs = Arrays.asList(
                new Stack(),
                new Stack(),
                new Stack());

        final int size_;
        final boolean direction_;

        public HT(final int size) {
            size_ = size;
            direction_ = size_ % 2 == 0;
            for (int i = 1; i <= size_; i++) {
                pegs.get(0).push(i);
            }
        }

        public List<Stack<Integer>> play() {
            int steps = 0;
            int a = 0;
            int c =  next(a);
            int last = -1;

            while (!complete()) {
                System.out.println(pegs);
                if (empty(a) || same(a, c)) {
                    a = next(a);
                    c = next(a);
                }
                if (moveValid(a, c, last)) {
                    last = move(a, c);
                    steps++;
                }
                c = next(c);
            }

            System.out.println(steps);
            return pegs;

        }

        int next(int p) {
            p = direction_ ? ++p >= pegs.size() ? 0 : p : --p < 0 ? pegs.size() - 1 : p;
            return p;
        }

        boolean complete() {
            return pegs.get(pegs.size() - 1).size() == size_;
        }

        boolean empty(final int p) {
            return pegs.get(p).empty();
        }

        boolean same(final int a, final int c) {
            return a == c;
        }

        boolean moveValid(final int from, final int to, int last) {
            if (pegs.get(from).peek() == last) return false;
            if (pegs.get(to).empty()) return true;
            return pegs.get(from).peek() > pegs.get(to).peek();
        }

        int move(final int from, final int to) {
            int move = pegs.get(from).pop();
            pegs.get(to).push(move);
            return move;
        }
    }