public class gas_station {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // All we need to do is to find the lowest point as our starting line.
        int sum = 0, minGas = 0, index = 0;
        for (int i=0; i<gas.length; ++i) {
            sum += gas[i]-cost[i];
            if (sum<minGas) {
                minGas = sum;
                index = i+1;
            }
        }
        return sum>=0?(index==gas.length?0:index):-1;
    }
}
