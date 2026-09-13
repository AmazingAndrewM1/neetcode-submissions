class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int lowK = 1;
        int highK = 1_000_000_000;

        while (lowK < highK){
            int midK = (lowK + highK) / 2;
            int totalHours = 0;
            for (int i = 0; i < piles.length && totalHours <= h; ++i){
                totalHours += (piles[i] - 1) / midK + 1;
            }
            if (totalHours > h){
                lowK = midK + 1;
            }
            else{
                highK = midK;
            }
        }

        return lowK;
    }
}
