package assignment7;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


public class JUnitTest {
	@Test
	public void testFight(){
        Scissors s = new Scissors(5);
        Paper p = new Paper(7);
        Rock r = new Rock(15);
        assertTrue(s.fight(p));
        assertFalse(p.fight(s));
        assertTrue(r.fight(p));
        assertFalse(p.fight(r));
        assertTrue(r.fight(s));
        assertFalse(s.fight(r));
        
	}
	@Test
	public void testFindMedianSortedArrays() {
		int[] nums1 = {};
		int[] nums2 = {0,5};
		Q5 q5 = new Q5();
		assertEquals(q5.findMedianSortedArrays(nums1, nums2), 2.5,0);
	}
	@Test
	public void testMerge() {
		Q4 q4 = new Q4();
		Interval interval1 = new Interval(1,3);
		Interval interval2 = new Interval(2,6);
		Interval interval3 = new Interval(8,10);
		Interval interval4 = new Interval(15,18);
		Interval interval5 = new Interval(1,6);
		Interval interval6 = new Interval(8,10);
		Interval interval7 = new Interval(15,18);
		List<Interval> list = new ArrayList<>();
		List<Interval> result = new ArrayList<>();
		list.add(interval1);
		list.add(interval2);
		list.add(interval3);
		list.add(interval4);
		result.add(interval5);
		result.add(interval6);
		result.add(interval7);
		assertEquals(q4.merge(list).size(), result.size());
		for(int i = 0; i < result.size(); i++) {
			assertTrue(q4.merge(list).get(i).start == result.get(i).start);
			assertTrue(q4.merge(list).get(i).end == result.get(i).end);
		}

	}
}
