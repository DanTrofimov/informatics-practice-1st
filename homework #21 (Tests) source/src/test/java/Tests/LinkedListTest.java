package Tests;

import org.junit.Assert;
import org.junit.Test;

public class LinkedListTest {

    @Test
    public void add() {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(1);
        int actual = list.size();
        int expected = 1;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getByIndex() {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(1);
        int actual = list.getByIndex(0).value;
        int expected = 1;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void size() {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(1);
        int actual = list.size();
        int expected = 1;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void removeValue() {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.removeValue(2);
        int actual = list.size();
        int expected = 2;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void removeByIndex() {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.removeByIndex(1);
        int actual = list.size();
        int expected = 2;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void merge() {
        LinkedList<Integer> list1 = new LinkedList<Integer>();
        list1.add(1);
        LinkedList<Integer> list2 = new LinkedList<Integer>();
        list2.add(2);
        list1.merge(list2);
        int actual = list1.size();
        int expected = 2;
        Assert.assertEquals(actual, expected);
    }
}
