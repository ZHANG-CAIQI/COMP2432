// Java program for implementation of FCFS
// scheduling with different arrival time
class GFG{
    // Function to find the waiting time for all
// processes
    static void findWaitingTime(int processes[], int n, int bt[], int wt[], int at[])
    {
        int service_time[] = new int[n];
        service_time[0] = 0;
        wt[0] = 0;

        // calculating waiting time
        for (int i = 1; i < n ; i++)
        {
            // Add burst time of previous processes
            service_time[i] = service_time[i-1] + bt[i-1];

            // Find waiting time for current process =
            // sum - at[i]
            wt[i] = service_time[i] - at[i];

            // If waiting time for a process is in negative
            // that means it is already in the ready queue
            // before CPU becomes idle so its waiting time is 0
            if (wt[i] < 0)
                wt[i] = 0;
        }
    }

    // Function to calculate turn around time
    static void findTurnAroundTime(int processes[], int n, int bt[],
                                   int wt[], int tat[])
    {
        // Calculating turnaround time by adding bt[i] + wt[i]
        for (int i = 0; i < n ; i++)
            tat[i] = bt[i] + wt[i];
    }

    // Function to calculate average waiting and turn-around
// times.
    static void findavgTime(int processes[], int n, int bt[], int at[])
    {
        int wt[] = new int[n], tat[] = new int[n];

        // Function to find waiting time of all processes
        findWaitingTime(processes, n, bt, wt, at);

        // Function to find turn around time for all processes
        findTurnAroundTime(processes, n, bt, wt, tat);

        // Display processes along with all details
        System.out.print("P      " + " Burst   " + "Arrival"
                + " Waiting " + " Turn  "
                + " Completion\n");
        int total_wt = 0, total_tat = 0;
        for (int i = 0 ; i < n ; i++)
        {
            total_wt = total_wt + wt[i];
            total_tat = total_tat + tat[i];
            int compl_time = tat[i] + at[i];
            System.out.println(i+1 + "\t\t" + bt[i] + "\t\t"
                    + at[i] + "\t\t" + wt[i] + "\t\t "
                    + tat[i] + "\t\t " + compl_time);
        }

        System.out.print("Average waiting time = "
                + (float)total_wt / (float)n);
        System.out.print("\nAverage turn around time = "
                + (float)total_tat / (float)n);
    }

// Driver code

    public static void main(String args[]) {
        // Process id's
        int processes[] = {1, 2, 3,4,5};
        int n = processes.length;

        // Burst time of all processes
        int burst_time[] = {9,5,2,3,6};

        // Arrival time of all processes
        int arrival_time[] = {0,1,2,3,4};

        findavgTime(processes, n, burst_time, arrival_time);

    }
}

/*This code is contributed by PrinciRaj1992*/
