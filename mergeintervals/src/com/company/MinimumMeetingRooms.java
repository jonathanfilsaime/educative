package com.company;

import java.util.*;

class MinimumMeetingRooms {

    public static int findMinimumMeetingRooms(List<Meeting> meetings) {
        // TODO: Write your code here
        if(meetings.size() == 0) return 0;
        if(meetings.size() == 1) return 1;

        Collections.sort(meetings, (a, b) -> Integer.compare(a.start, b.start));
        PriorityQueue<Meeting> roomQueue = new PriorityQueue<>(meetings.size(), (a,b) -> Integer.compare(a.end, b.end));

        int minRooms = 0;
        for(Meeting meeting: meetings) {
            while(!roomQueue.isEmpty() && meeting.start >= roomQueue.peek().end) {
                roomQueue.poll();
            }

            roomQueue.offer(meeting);
            minRooms = Math.max(minRooms, roomQueue.size());
        }

        return minRooms;
    }

    public static void main(String[] args) {
        List<Meeting> input = new ArrayList<Meeting>() {
            {
                add(new Meeting(1, 4));
                add(new Meeting(2, 5));
                add(new Meeting(7, 9));
            }
        };
        int result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);

        input = new ArrayList<Meeting>() {
            {
                add(new Meeting(6, 7));
                add(new Meeting(2, 4));
                add(new Meeting(8, 12));
            }
        };
        result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);

        input = new ArrayList<Meeting>() {
            {
                add(new Meeting(1, 4));
                add(new Meeting(2, 3));
                add(new Meeting(3, 6));
            }
        };
        result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);

        input = new ArrayList<Meeting>() {
            {
                add(new Meeting(4, 5));
                add(new Meeting(2, 3));
                add(new Meeting(2, 4));
                add(new Meeting(3, 5));
            }
        };
        result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);
    }
}