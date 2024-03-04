package org.home.m4;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by lje on 4/13/2021.
 */
public class M4W2D6v2 {
    public class NestedIterator implements Iterator<Integer> {

        private final Iterator<NestedInteger> i;

        public NestedIterator(List<NestedInteger> nestedList) {
            i = nestedList.stream()
                    .flatMap(this::expand)
                    .iterator();
        }

        private Stream<NestedInteger> expand(NestedInteger e) {
            if (e.isInteger())
                return Stream.of(e);
            else
                return e.getList()
                        .stream()
                        .flatMap(this::expand);
        }

        @Override
        public Integer next() {
            return i.next().getInteger();
        }

        @Override
        public boolean hasNext() {
            return i.hasNext();
        }
    }

    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }
}
