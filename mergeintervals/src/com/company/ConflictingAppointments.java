package com.company;

import java.util.*;


class ConflictingAppointments {

    public static boolean canAttendAllAppointments(Interval[] intervals) {
        // TODO: Write your code here


        List<Interval> intervalsList = Arrays.asList(intervals);
        Collections.sort(intervalsList, (a,b) -> Integer.compare(a.start, b.start));
        Iterator<Interval> intervalIterator = intervalsList.iterator();
        Interval interval = intervalIterator.next();
        int end = interval.end;

        while(intervalIterator.hasNext()) {
            interval = intervalIterator.next();
            if(interval.start < end) {
                return false;
            } else {
                end = interval.end;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Interval[] intervals = { new Interval(1, 4), new Interval(2, 5), new Interval(7, 9) };
        boolean result = ConflictingAppointments.canAttendAllAppointments(intervals);
        System.out.println("Can attend all appointments: " + result);

        Interval[] intervals1 = { new Interval(6, 7), new Interval(2, 4), new Interval(8, 12) };
        result = ConflictingAppointments.canAttendAllAppointments(intervals1);
        System.out.println("Can attend all appointments: " + result);

        Interval[] intervals2 = { new Interval(4, 5), new Interval(2, 3), new Interval(3, 6) };
        result = ConflictingAppointments.canAttendAllAppointments(intervals2);
        System.out.println("Can attend all appointments: " + result);
    }
}