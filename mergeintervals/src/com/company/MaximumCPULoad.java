package com.company;

import java.util.*;

class MaximumCPULoad {

    public static int findMaxCPULoad(List<Job> jobs) {
        // TODO: Write your code here
        if(jobs.size() == 0) return 0;
        if(jobs.size() == 1) return jobs.get(0).cpuLoad;

        Collections.sort(jobs, (a,b) -> Integer.compare(a.start, b.start));

        Iterator<Job> jobIterator = jobs.iterator();
        Job job = jobIterator.next();
        int end = job.end;
        int cpuLoad = job.cpuLoad;
        int totalCpuLoad = 0;
        while(jobIterator.hasNext()) {
            job = jobIterator.next();
            if(job.start < end) {
                totalCpuLoad = Math.max(totalCpuLoad, (cpuLoad + job.cpuLoad));
                cpuLoad = totalCpuLoad;
            } else {
                totalCpuLoad = Math.max(totalCpuLoad, job.cpuLoad);
                cpuLoad = job.cpuLoad;
            }
            end = job.end;

        }

        return totalCpuLoad;
    }

    public static void main(String[] args) {
        List<Job> input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 3), new Job(2, 5, 4), new Job(7, 9, 6)));
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));

        input = new ArrayList<Job>(Arrays.asList(new Job(6, 7, 10), new Job(2, 4, 11), new Job(8, 12, 15)));
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));

        input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 2), new Job(2, 4, 1), new Job(3, 6, 5)));
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));
    }
}