import java.util.*;

public class Solution {
    class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
    static class IntervalComp implements Comparator<Interval> {
        public int compare(Interval a, Interval b) {
            return a.start - b.start;
        }
    }
    public static void main(String[] args) {}
    public static List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new IntervalComp());
        List<Interval> ret = new ArrayList<Interval>();
        int l = intervals.size();
        if (l == 0) return ret;
        ret.add(intervals.get(0));
        int s1 = intervals.get(0).start;
        int e1 = intervals.get(0).end;
        for (int i = 1; i < l; i++) {
            int s2 = intervals.get(i).start;
            int e2 = intervals.get(i).end;
            if (s2 > e1) { ret.add(intervals.get(i)); }
            else if (e2 > e1) { ret.get(ret.size() - 1).end = e2; }
            s1 = ret.get(ret.size() - 1).start;
            e1 = ret.get(ret.size() - 1).end;
        }
        return ret;
    }
    public static List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new IntervalComp());
        List<Interval> ret = new ArrayList<Interval>();
        int l = intervals.size();
        if (l == 0) return ret;
        ret.add(intervals.get(0));
        int s1 = intervals.get(0).start;
        int e1 = intervals.get(0).end;
        for (int i = 1; i < l; i++) {
            int s2 = intervals.get(i).start;
            int e2 = intervals.get(i).end;
            if (s2 > e1) { ret.add(intervals.get(i)); }
            else if (e2 > e1) { ret.get(ret.size() - 1).end = e2; }
            s1 = ret.get(ret.size() - 1).start;
            e1 = ret.get(ret.size() - 1).end;
        }
        return ret;
    }
}