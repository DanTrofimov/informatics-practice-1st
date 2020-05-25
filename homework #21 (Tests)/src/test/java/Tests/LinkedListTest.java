package Tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LinkedListTest {

    private LinkedList<Integer> list;
    private LinkedList<Integer> list2;

    @Before
    public void setUp() {
        LinkedList<Integer> list = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();
    }

    @Test
    public void add() {
        list.add(1);
        int actual = list.size();
        int expected = 1;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getByIndex() {
        list.add(1);
        int actual = list.getByIndex(0).value;
        int expected = 1;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getByIndexMult() {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(1);
        list.add(2);
        int actual = list.getByIndex(0).value;
        int expected = 1;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void size() {
        list.add(1);
        int actual = list.size();
        int expected = 1;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void sizeWithRemoving() {
        list.add(1);
        list.removeValue(1);
        int actual = list.size();
        int expected = 0;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void removeValueMult() {
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
    public void removeValueWithDeletingVoid() {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(1);
        list.removeValue(2);
        int actual = list.size();
        int expected = 1;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void removeByIndexMult() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.removeByIndex(1);
        int actual = list.size();
        int expected = 2;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void removeByIndexVoid() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.removeByIndex(4);
        int actual = list.size();
        int expected = 2;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void merge() {
        list.add(1);
        LinkedList<Integer> list2 = new LinkedList<Integer>();
        list2.add(2);
        list.merge(list2);
        int actual = list.size();
        int expected = 2;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void mergeVoid() {
        LinkedList<Integer> list1 = new LinkedList<Integer>();
        list1.add(1);
        LinkedList<Integer> list2 = new LinkedList<Integer>();
        list1.merge(list2);
        int actual = list1.size();
        int expected = 1;
        Assert.assertEquals(actual, expected);
    }
}
