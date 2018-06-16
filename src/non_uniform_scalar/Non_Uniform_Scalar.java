package non_uniform_scalar;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Pair;

/**
 *
 * @author HDrmi
 */
public class Non_Uniform_Scalar {

    private List<Integer> Numbers;
    private List<Node> Nodes;
    private Map<Integer, Integer> Quan;

    public Map<Integer, Integer> getQuan() {
        return Quan;
    }

    private int toint(String s) {
        int sum = 0;
        s = new StringBuilder(s).reverse().toString();
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '1') {
                sum += Math.pow(2, i);
            }
        }
        return sum;
    }

    public void Write(Map<Integer, Integer> map, String str, String path) {
        try {
            try (DataOutputStream out = new DataOutputStream(new FileOutputStream(path))) {
                int size = map.size();
                out.writeByte(size);
                System.out.println(size);
                for (Map.Entry<Integer, Integer> n : map.entrySet()) {
                    out.writeByte(n.getKey());
                    out.writeByte(n.getValue());
                    System.out.println(n.getKey() + " " + n.getValue());
                }
                out.writeByte(str.length() / 8);
                String[] strings = str.split("(?<=\\G.{8})");
                for (String string : strings) {
                    int n = toint(string);
                    out.writeByte(n);
                }
                out.close();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Non_Uniform_Scalar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Non_Uniform_Scalar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private byte[] Read(String Path) {
        byte[] data = null;
        try {
            Path path = Paths.get(Path);
            data = Files.readAllBytes(path);
        } catch (IOException ex) {
            Logger.getLogger(Non_Uniform_Scalar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    private int MSE(double avg, int n) {
        return (int) ((avg - n) * (avg - n));
    }

    private boolean Compare(List<Node> list1, List<Node> list2) {
        if (list1.size() != list2.size()) {
            return false;
        } else {
            for (int i = 0; i < list1.size(); i++) {
                if ((list1.get(i).getAverage() != list2.get(i).getAverage()) || (!list1.get(i).getList().equals(list2.get(i).getList()))) {
                    return false;
                }
            }
        }
        return true;
    }

    private void SplitAndAssociate(int levels) {
        List<Node> temp = new ArrayList<>();
        while (Nodes.size() != levels) {
            temp = new ArrayList<>();
            for (Node tmp : Nodes) {
                double avg = tmp.getAverage();
                double low, high;
                if ((int) avg == avg) {
                    low = avg - 1;
                } else {
                    low = (int) avg;
                }
                if ((int) avg == avg) {
                    high = avg + 1;
                } else {
                    high = (int) avg + 1;
                }
                Node New1 = new Node();
                New1.setAverage(low);
                Node New2 = new Node();
                New2.setAverage(high);
                temp.add(New1);
                temp.add(New2);
            }
            for (int n : Numbers) {
                int i = 0, loc = 0;
                int min = Integer.MAX_VALUE;
                for (Node no : temp) {
                    int error = MSE(no.getAverage(), n);
                    if (error < min) {
                        min = error;
                        loc = i;
                    }
                    i++;
                }
                temp.get(loc).addtoList(n);
            }
            for (Node no : temp) {
                no.calculateAvgerage();
            }
            Nodes = new ArrayList<>(temp);
        }
    }

    private List<Node> Associate() {
        List<Node> list = new ArrayList<>();
        for (Node no : Nodes) {
            Node N = new Node();
            N.setAverage(no.getAverage());
            list.add(N);
        }
        for (int n : Numbers) {
            int i = 0, loc = 0;
            int min = Integer.MAX_VALUE;
            for (Node no : list) {
                int error = MSE(no.getAverage(), n);
                if (error < min) {
                    min = error;
                    loc = i;
                }
                i++;
            }
            list.get(loc).addtoList(n);
        }
        return list;
    }

    public List<Node> Compress(List<Integer> list, int levels) {
        Numbers = new ArrayList<>(list);
        Node node = new Node(list);
        Nodes = new ArrayList<>();
        Quan = new HashMap<>();
        Nodes.add(node);
        SplitAndAssociate(levels);
        while (true) {
            List<Node> temp = Associate();
            if (Compare(temp, Nodes)) {
                break;
            }
            Nodes = new ArrayList<>(temp);
        }
        for (int i = 0; i < levels; i++) {
            Quan.put(i, (int) Nodes.get(i).getAverage());
        }
        return Nodes;
    }

    public List<Integer> Decompress(String path) {
        Quan.clear();
        List<Integer> numbers = new ArrayList<>();
        byte[] data = Read(path);
        int size = data[0], i = 1;
        System.out.println(size);
        List<Integer> temp = new ArrayList<>();
        for (; i <= size*2; ++i) {
            int n = (int) Byte.toUnsignedInt(data[i]);
            temp.add(n);
        }
        for(int j=0;j<temp.size();j+=2){
            Quan.put(temp.get(j), temp.get(j+1));
        }
        int length = data[i++];
        System.out.println(length);
        for (int j=0; j < length; j++) {
            numbers.add(Byte.toUnsignedInt(data[i++]));
        }
        List<Integer> result = new ArrayList<>();
        System.out.println(numbers);
        for (int n : numbers) {
            result.add(Quan.get(n));
        }
        return result;
    }
}
