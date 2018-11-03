package assignment7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Interval{
	int start;
	int end;
	public Interval() {
		
	}
	public Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
}

public class Q4 {

	
    public List<Interval> merge(List<Interval> intervals) {
        int n = intervals.size();
        int[] first = new int[n];
        int[] second = new int[n];
        for(int i = 0; i < n; i++){
            first[i] = intervals.get(i).start;
            second[i] = intervals.get(i).end;
        }
        Arrays.sort(first);
        Arrays.sort(second);
        List<Interval> merge = new ArrayList<Interval>();
        for(int i = 0, j = 0; i < n; i++){
            if(i == n -1){
                merge.add(new Interval(first[j],second[i]));
            }
            else if( first[i + 1] > second[i]){
                
                merge.add(new Interval(first[j],second[i]));
                j = i + 1;
            }
        }
        return merge;
    }
}
