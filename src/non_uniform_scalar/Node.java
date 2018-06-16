package non_uniform_scalar;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HDrmi
 */
public class Node {

    private List<Integer> list;
    private double Average;

    public Node() {
        list = new ArrayList<>();
    }

    public Node(List<Integer> list) {
        this.list = new ArrayList<>(list);
        double sum = 0;
        for (int n : list) {
            sum += n;
        }
        this.Average = Math.ceil(sum / list.size());
    }

    public List<Integer> getList() {
        return list;
    }

    public void addtoList(int n) {
        this.list.add(n);
    }

    public void calculateAvgerage() {
        double sum = 0;
        for (int n : list) {
            sum += n;
        }
        this.Average = sum / list.size();
    }

    public void view() {
        System.out.print("Average :" + Average+" ( ");
        for (int n : list) {
            System.out.print(n + " ");
        }
        System.out.println(")");
    }

    public double getAverage() {
        return Average;
    }

    public void setAverage(double Average) {
        this.Average = Average;
    }

}
