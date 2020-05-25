package Tests;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

public class VariableCollectionTest {

    @Test
    public void size() {
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
    public void add() {
        VariableCollection<Integer> col = new VariableCollection<>();
        int actual = col.size();
        col.add(1);
        actual++;
        int expected = 1;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void remove() {
        VariableCollection<Integer> col = new VariableCollection<>();
        col.add(1);
        col.remove(1);
        int actual = col.size();
        int expected = 0;
        Assert.assertEquals(expected, actual);
    }

    @Test
    void iterator() {
        VariableCollection<Integer> col = new VariableCollection<>();
        col.add(1);
        Iterator it = col.iterator();
        Assert.assertTrue(it instanceof Iterator);
    }
}
