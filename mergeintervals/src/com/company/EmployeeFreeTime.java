package com.company;

import java.util.*;

class EmployeeFreeTime {

    public static List<Interval> findEmployeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> result = new ArrayList<>();
        // TODO: Write your code here
        int minStart = Integer.MAX_VALUE;
        int maxEnd = Integer.MIN_VALUE;
        List<Interval> flatSchedule = new LinkedList<>();

        for (List<Interval> intervalList : schedule) {
            for (Interval interval : intervalList) {
                minStart = Math.min(interval.start, minStart);
                maxEnd = Math.max(interval.end, maxEnd);
                flatSchedule.add(new Interval(interval.start, interval.end));
            }
        }

        flatSchedule.add(new Interval(minStart, minStart));
        flatSchedule.add(new Interval(maxEnd, maxEnd));

        Collections.sort(flatSchedule, (a, b) -> Integer.compare(a.start, b.start));

        Iterator<Interval> intervalIterator = flatSchedule.iterator();
        Interval interval = intervalIterator.next();
        int start = interval.start;
        int end = interval.end;

        List<Interval> mergeScheduled = new LinkedList<>();
        while(intervalIterator.hasNext()) {
            interval = intervalIterator.next();
            if(end > interval.start) {
                end = Math.max(end, interval.end);
            } else {
                mergeScheduled.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }

        Iterator<Interval> resultIterator = mergeScheduled.iterator();
        Interval freeTime = resultIterator.next();
        int endTime = freeTime.end;

        while(resultIterator.hasNext()) {
            freeTime = resultIterator.next();
            if(freeTime.start > endTime) {
                result.add(new Interval(endTime, freeTime.start));
            }
            endTime = freeTime.end;
        }

        return result;
    }

    public static void main(String[] args) {

        List<List<Interval>> input = new ArrayList<>();
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3), new Interval(5, 6))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 3), new Interval(6, 8))));
        List<Interval> result = EmployeeFreeTime.findEmployeeFreeTime(input);
        System.out.print("Free intervals: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + ", " + interval.end + "] ");
        System.out.println();

        input = new ArrayList<>();
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3), new Interval(9, 12))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 4))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(6, 8))));
        result = EmployeeFreeTime.findEmployeeFreeTime(input);
        System.out.print("Free intervals: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + ", " + interval.end + "] ");
        System.out.println();

        input = new ArrayList<>();
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 4))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(3, 5), new Interval(7, 9))));
        result = EmployeeFreeTime.findEmployeeFreeTime(input);
        System.out.print("Free intervals: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + ", " + interval.end + "] ");
    }
}