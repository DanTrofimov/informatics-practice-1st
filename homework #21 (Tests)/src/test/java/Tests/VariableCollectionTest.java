package Tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

public class VariableCollectionTest {

    private VariableCollection col;

    @Before
    public void setUp() {
        VariableCollection<Integer> col = new VariableCollection<>();
    }

    @Test
    public void sizeFromCollection() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(i);
        }
        VariableCollection<Integer> col = new VariableCollection<>(list);
        int actual = col.size();
        int expected = 3;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void sizeFromCollectionWithAdd() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(i);
        }
        VariableCollection<Integer> col = new VariableCollection<>(list);
        col.add(3);
        int actual = col.size();
        int expected = 4;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void sizeFromCollectionWithAddRemove() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(i);
        }
        VariableCollection<Integer> col = new VariableCollection<>(list);
        col.remove(3);
        col.add(4);
        col.remove(4);
        int actual = col.size();
        int expected = 2;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addWithREmoving() {
        col.add(1);
        col.add(2);
        col.remove(2);
        col.remove(1);
        int actual = col.size();
        int expected = 0;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void add() {
        int actual = col.size();
        col.add(1);
        actual++;
        int expected = 1;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void remove() {
        col.add(1);
        col.remove(1);
        int actual = col.size();
        int expected = 0;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeFromINCollection() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        col = new VariableCollection(list);
        col.add(3);
        col.remove(1);
        int actual = col.size();
        int expected = 2;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeVoid() {
        col.remove(1);
        int actual = col.size();
        int expected = 0;
        Assert.assertEquals(expected, actual);
    }

    @Test
    void iterator() {
        col.add(1);
        Iterator it = col.iterator();
        Assert.assertTrue(it instanceof Iterator);
    }
}
