public class Solution {
 // TC - O(N^2)
    public static int[] findMissingRepeatingNumbers(int []a) {
        
        int rep = -1; int not = -1;
        for(int i = 1 ; i <= a.length; i++){
            int count = 0;
            for(int j = 0 ; j < a.length; j++)
                if(a[j] == i) count++;
            
            if(count == 2) rep = i;
            else if(count == 0) not = i;
            
            if(rep != -1 && not != -1) break;
        }
        
        return new int[]{rep, not};
    }

// TC - O(2N) SC - O(N)
    public static int[] findMissingRepeatingNumbers(int []a) {
        int rep = -1; int not = -1;
        int[] hash = new int[a.length +1];

        for(int i : a)
            hash[i]++;

        for(int i = 1 ; i <= a.length; i++){
            if(hash[i] == 2) rep = i;
            else if(hash[i] == 0) not = i;
            if(rep != -1 && not != -1) break;
        }
        
        return new int[]{rep, not};
    }

// TC - O(N)
    public static int[] findMissingRepeatingNumbers(int []a) {
        long n = a.length;
        long s1 = 0; long s2 = 0;
        long sumationOfNnum = n * (n +1)/2;
        long summationOfSqrOfNnum = (n * (n + 1) * (2 * n + 1)) / 6;

        for(int i : a){
            s1 += i;
            s2 += (long) i * (long) i;
        }

        long val1 = s1 - sumationOfNnum;
        long val2 = s2 - summationOfSqrOfNnum;

        val2 = val2 / val1;

        long  x = (val1 + val2) / 2;
        long y = x - val1;

        return new int[]{(int)x, (int)y};
    }
}



