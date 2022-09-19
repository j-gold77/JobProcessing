import java.util.Random;

/**
 * The type Driver 2.
 */
public class driver2 {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int maxNumberOfJobs = 10000;
        Jobs[] jobInputArray = new Jobs[maxNumberOfJobs];
        Random random = new Random();
        int count = 0;

        SortedPriorityQueue<Integer, Jobs> spq = new SortedPriorityQueue<>();



        for (int i = 0; i < jobInputArray.length; i++) {
            String jobName = "Job_" + (count + 1);
            Jobs job = new Jobs();
            job.setJobName(jobName);
            int random2 = random.nextInt(70 + 1 - 1) + 1;
            job.setJobLength(random2);
            job.setCurrentJobLength(random2);
            int random3 = random.nextInt(40 + 1 - 1) + 1;
            job.setJobPriority(random3);
            job.setFinalPriority(random3);
            job.setEntryTime(count);
            jobInputArray[count] = job;
            spq.insert(job.getFinalPriority(), job);
            count++;
        }
        int counter2 = 1;
        long sum = 0;
        int terminations =1;
        int starvedJobs= 0;


        while (!spq.isEmpty()){
            Jobs job = new Jobs();


            if (terminations%30==0){
                job=findMax(jobInputArray);
                if(job.getJobName()==null){
                    counter2++;
                    terminations = 1;
                    continue;
                }
                else {

                    job.setFinalPriority(1);
                    spq.setMin(job.getFinalPriority(),job);
                    counter2++;
                    starvedJobs++;
                    terminations=1;
                }
            }


            System.out.println(spq.min().getJob());
            job = spq.removeMin().getJob();
            counter2++;
            if(job.getCurrentJobLength() == 0){
                job.setEndTime(counter2);
                job.setWaitTime(counter2-job.getJobLength()-job.getEntryTime());
                sum += job.getWaitTime();
                terminations++;
                continue;
            }
            job.setCurrentJobLength(job.getCurrentJobLength()-1);
            job.setBeenExecuted(true);
            spq.insert(job.getFinalPriority(),job);
        }

        long endTime = System.currentTimeMillis( ); // record the ending time
        long elapsed = (endTime - startTime);
        System.out.println(sum);
        long average = sum / maxNumberOfJobs;

        System.out.println("Current Systemtime(cycles): " + (counter2 + maxNumberOfJobs));
        System.out.println("Total number of jobs executed: " + maxNumberOfJobs);
        System.out.println("Average process waiting time: " + average + " cycles");
        System.out.println("Total number of priority changes: " + starvedJobs);

       System.out.println("Actual systemtime needed to execute all jobs: " + elapsed + "ms");


    }

    /**
     * Find max jobs.
     *
     * @param array the array
     * @return the jobs
     */
    public static Jobs findMax(Jobs [] array){
        Jobs max = new Jobs();

        for(int i=0; i<array.length;i++) {
            if (!array[i].getBeenExecuted() & array[i].getEntryTime() >= max.getEntryTime()) {
                max = array[i];
            }
        }
        return max;
    }
}

