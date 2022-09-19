/**
 * The interface Entry.
 *
 * @param <K>    the type parameter
 * @param <Jobs> the type parameter
 */
public interface Entry <K,Jobs> {

    /**
     * Gets key.
     *
     * @return the key
     */
    K getKey();

    /**
     * Gets job.
     *
     * @return the job
     */
    Jobs getJob();

    /**
     * Sets key.
     *
     * @param i the
     * @return the key
     */
    K setKey(int i);

    /**
     * Sets jobs.
     *
     * @param j the j
     * @return the jobs
     */
    Jobs setJobs(Jobs j);
}
