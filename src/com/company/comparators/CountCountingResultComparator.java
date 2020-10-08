package com.company.comparators;

import com.company.handlers.TagCounter;

import java.util.Comparator;

public class CountCountingResultComparator implements Comparator<TagCounter.CountingResult> {
    @Override
    public int compare(TagCounter.CountingResult o1, TagCounter.CountingResult o2) {
        return o1.getAmount().compareTo(o2.getAmount());
    }
}
