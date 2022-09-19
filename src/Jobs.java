/**
 * The type Jobs.
 */
public class Jobs {

    private String jobName;
    private int jobLength;
    private int currentJobLength;
    private int jobPriority;
    private int finalPriority;
    private long entryTime;
    private long endTime;
    private long waitTime;
    private boolean beenExecuted;

    /**
     * Instantiates a new Jobs.
     */
    public Jobs(){
        jobName = null;
        jobLength = 0;
        currentJobLength = 0;
        jobPriority = 0;
        finalPriority = 0;
        endTime = 0;
        entryTime = 0;
        waitTime = 0;
        beenExecuted = false;
    }

    /**
     * Instantiates a new Jobs.
     *
     * @param jobName          the job name
     * @param jobLength        the job length
     * @param currentJobLength the current job length
     * @param jobPriority      the job priority
     * @param finalPriority    the final priority
     * @param entryTime        the entry time
     * @param endTime          the end time
     * @param waitTime         the wait time
     * @param beenExecuted     the been executed
     */
    public Jobs (String jobName, int jobLength, int currentJobLength, int jobPriority,
                 int finalPriority, long entryTime, long endTime, long waitTime, boolean beenExecuted){

        this.jobName = jobName;
        this.jobLength = jobLength;
        this.currentJobLength = currentJobLength;
        this.jobPriority = jobPriority;
        this.finalPriority = finalPriority;
        this.entryTime = entryTime;
        this.endTime = endTime;
        this.waitTime = waitTime;
        this.beenExecuted = beenExecuted;

    }


    /**
     * Find max entry time jobs.
     *
     * @param array the array
     * @return the jobs
     */
    public Jobs findMaxEntryTime(Jobs [] array){
        Jobs max = new Jobs();
        for (int i=0; i<array.length; i++){
            if(array[i].getEntryTime() >= max.getEntryTime() & !array[i].getBeenExecuted()){
                max = array[i];
            }
        }

        return max;
    }

    /**
     * Sets been executed.
     *
     * @param beenExecuted the been executed
     */
    public void setBeenExecuted(boolean beenExecuted) {
        this.beenExecuted = beenExecuted;
    }

    /**
     * Get been executed boolean.
     *
     * @return the boolean
     */
    public boolean getBeenExecuted(){
        return beenExecuted;
    }

    /**
     * Gets job name.
     *
     * @return the job name
     */
    public String getJobName() {
        return jobName;
    }

    /**
     * Sets job name.
     *
     * @param jobName the job name
     */
    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    /**
     * Gets job length.
     *
     * @return the job length
     */
    public int getJobLength() {
        return jobLength;
    }

    /**
     * Sets job length.
     *
     * @param jobLength the job length
     */
    public void setJobLength(int jobLength) {
        this.jobLength = jobLength;
    }

    /**
     * Gets current job length.
     *
     * @return the current job length
     */
    public int getCurrentJobLength() {
        return currentJobLength;
    }

    /**
     * Sets current job length.
     *
     * @param currentJobLength the current job length
     */
    public void setCurrentJobLength(int currentJobLength) {
        this.currentJobLength = currentJobLength;
    }

    /**
     * Gets job priority.
     *
     * @return the job priority
     */
    public int getJobPriority() {
        return jobPriority;
    }

    /**
     * Sets job priority.
     *
     * @param jobPriority the job priority
     */
    public void setJobPriority(int jobPriority) {
        this.jobPriority = jobPriority;
    }

    /**
     * Gets final priority.
     *
     * @return the final priority
     */
    public int getFinalPriority() {
        return finalPriority;
    }

    /**
     * Sets final priority.
     *
     * @param finalPriority the final priority
     */
    public void setFinalPriority(int finalPriority) {
        this.finalPriority = finalPriority;
    }

    /**
     * Gets entry time.
     *
     * @return the entry time
     */
    public long getEntryTime() {
        return entryTime;
    }

    /**
     * Sets entry time.
     *
     * @param entryTime the entry time
     */
    public void setEntryTime(long entryTime) {
        this.entryTime = entryTime;
    }

    /**
     * Gets end time.
     *
     * @return the end time
     */
    public long getEndTime() {
        return endTime;
    }

    /**
     * Sets end time.
     *
     * @param endTime the end time
     */
    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    /**
     * Gets wait time.
     *
     * @return the wait time
     */
    public long getWaitTime() {
        return waitTime;
    }

    /**
     * Sets wait time.
     *
     * @param waitTime the wait time
     */
    public void setWaitTime(long waitTime) {
        this.waitTime = waitTime;
    }

    @Override
    public String toString() {
        return "Now executing " +
                 jobName + '.' +
                " job length: " + jobLength + " cycles " +
                ", current remaining length " + currentJobLength + " cycles " +
                ", initial priority: " + jobPriority +
                ", current priority " + finalPriority +
                " entryTime= " + entryTime +
                '}';
    }




}
