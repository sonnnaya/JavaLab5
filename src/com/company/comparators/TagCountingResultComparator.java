package com.company.comparators;

import com.company.handlers.TagCounter;

import java.util.Comparator;

public class TagCountingResultComparator implements Comparator<TagCounter.CountingResult> {
    @Override
    public int compare(TagCounter.CountingResult o1, TagCounter.CountingResult o2) {
        return o1.getTag().compareTo(o2.getTag());
    }
}
