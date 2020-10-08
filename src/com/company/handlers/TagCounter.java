package com.company.handlers;

import com.company.comparators.CountCountingResultComparator;
import com.company.comparators.TagCountingResultComparator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;

public class TagCounter {

    public final class CountingResult
    {
        private final String tag;
        private final Integer amount;

        public String getTag() { return tag; }
        public Integer getAmount() { return amount; }

        public CountingResult(String tag, Integer amount) {
            this.tag = tag;
            this.amount = amount;
        }
    }

    private final ArrayList<String> tags;

    public TagCounter(String tags) {
        this.tags = new ArrayList<String>();

        var spitedTags = tags.split(" ");
        for (var item : spitedTags)
            this.tags.add(item);
    }

    public TagCounter(ArrayList<String> tags) {
        this.tags = tags;
    }

    public ArrayList<CountingResult> countTags(CharSequence text) {
        var results = new ArrayList<CountingResult>();
        var allCounting = new HashMap<String, Integer>();

        for (var tag : tags) {
            allCounting.put(tag, countTag(tag, text));
        }

        for (var entry : allCounting.entrySet())  {
            results.add(new CountingResult(entry.getKey(), entry.getValue()));
        }

        return results;
    }

    public Integer countTag(CharSequence tag, CharSequence text) {
        Integer count = 0;

        var pattern = Pattern.compile("<" + tag.toString() + ".*?>");
        var matcher = pattern.matcher(text);

        while (matcher.find()) {
            ++count;
        }

        return count;
    }

    public static ArrayList<String> findAllHtmlTags(CharSequence text) {
        var pattern = Pattern.compile("<\\/.+?>");
        var matcher = pattern.matcher(text);
        var tags = new ArrayList<String>();

        while (matcher.find()) {
            var tag = matcher.group();
            tags.add(tag.substring(2, tag.length() - 1));
        }

        return tags;
    }

    public static void sortByTag(ArrayList<CountingResult> results) {
        var comparator = new TagCountingResultComparator();
        results.sort(comparator);
    }

    public static void sortByCount(ArrayList<CountingResult> results) {
        var comparator = new CountCountingResultComparator();
        results.sort(comparator);
    }
}
