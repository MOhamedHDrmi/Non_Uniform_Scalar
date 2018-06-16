package non_uniform_scalar;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HDrmi
 */
public class GUI extends javax.swing.JFrame {

    private final Non_Uniform_Scalar non_Uniform_Scalar;
    private List<Integer> Qnmubers;
    private String path = "compress.txt";

    public GUI() {
        initComponents();
        jLabel1.setVisible(false);
        Decompress.setVisible(false);
        non_Uniform_Scalar = new Non_Uniform_Scalar();
        Qnmubers = new ArrayList<>();
    }

    private double CalculateMSE(List<Integer> listnumbers, List<Node> Nodes) {
        double MSE = 0;
        for (int n : listnumbers) {
            for (Node node : Nodes) {
                if (node.getList().contains(n)) {
                    MSE += (n - node.getAverage()) * (n - node.getAverage());
                    break;
                }
            }
        }
        return MSE / listnumbers.size();
    }

    private List<Integer> CalcuateRanges(List<Node> nodes, int mn, int mx) {
        List<Integer> Ranges = new ArrayList<>();
        List<Node> list = new ArrayList<>(nodes);
        Node no = list.remove(0);
        double range = no.getAverage();
        for (Node node : list) {
            Ranges.add((int) (range + node.getAverage()) / 2);
            range = node.getAverage();
        }
        return Ranges;
    }

    private List<Integer> Q_numbers(List<Integer> numIntegers, List<Node> nodes) {
        int i = 0;
        List<Integer> tmp = new ArrayList<>();
        for (int n : numIntegers) {
            i = 0;
            for (Node no : nodes) {
                if (no.getList().contains(n)) {
                    tmp.add(i);
                }
                i++;
            }
        }
        return tmp;
    }

    private String ListToString(List<Integer> list) {
        String tmp = " ";
        for (int n : list) {
            tmp += Integer.toString(n) + " ";
        }
        return tmp;
    }

    private String ToBinaryString(List<Integer> list, int levels) {
        String tmp = "", fill = "0000000";
        int length = (int) (Math.log((double) levels) / Math.log(2));
        for (int n : list) {
            String t = Integer.toBinaryString(n);
            if (t.length() < length) {
                t = fill.substring(0, length - t.length()) + t;
            }
            tmp += t;
        }
        return tmp;
    }

    private String ToBinary(List<Integer> list) {
        String tmp = "", fill = "00000000";
        for (int n : list) {
            String t = Integer.toBinaryString(n);
            t = fill.substring(0, 8 - t.length())+t;
            tmp += t;
        }
        return tmp;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        compress = new javax.swing.JButton();
        Input = new javax.swing.JTextField();
        numbers = new javax.swing.JLabel();
        levels = new javax.swing.JLabel();
        levelsinput = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Quantizer = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();
        output = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        MSElabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        Binary = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        Deoutput = new javax.swing.JTextField();
        Decompress = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        compress.setText("Copmress");
        compress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compressActionPerformed(evt);
            }
        });

        Input.setBackground(new java.awt.Color(255, 255, 255));

        numbers.setText("Numbers :");

        levels.setText("Levels :");

        levelsinput.setBackground(new java.awt.Color(255, 255, 255));

        Quantizer.setAutoCreateRowSorter(true);
        Quantizer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Q", "Range", "Q^"
            }
        ));
        Quantizer.setEnabled(false);
        jScrollPane1.setViewportView(Quantizer);

        output.setEditable(false);
        output.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("MSE : ");

        jLabel2.setText("Q-Numbers :");

        Binary.setEditable(false);
        Binary.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setText("Binary : ");

        jLabel4.setText("DeQ-numbers :");

        Deoutput.setEditable(false);
        Deoutput.setBackground(new java.awt.Color(255, 255, 255));

        Decompress.setText("Decompress");
        Decompress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DecompressActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(numbers)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(Input)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(levels)
                                .addGap(47, 47, 47))
                            .addComponent(levelsinput)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Deoutput)
                            .addComponent(jSeparator3)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Binary)
                                    .addComponent(output)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(MSElabel, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(14, 14, 14))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Decompress)
                                        .addGap(54, 54, 54))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(compress, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numbers)
                    .addComponent(levels))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(levelsinput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(output, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Binary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(compress, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(MSElabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Decompress, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Deoutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void compressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compressActionPerformed
        jLabel1.setVisible(true);
        Decompress.setVisible(true);
        String tmp;
        List<Integer> listnumbers = new ArrayList<>();
        List<Integer> QIntegers;
        Map<Integer, Integer> ranges = null;
        int mn, level, mx, i;
        String[] numbersStrings;
        List<Node> Nodes;
        DefaultTableModel model;
        if (Input.getText().equals("") || levelsinput.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Write All Information", "", JOptionPane.WARNING_MESSAGE);
            return;
        }
        this.levelsinput.setEditable(false);
        this.Input.setEditable(false);
        level = Integer.parseInt(this.levelsinput.getText());
        mn = Integer.MAX_VALUE;
        mx = Integer.MIN_VALUE;
        numbersStrings = this.Input.getText().split(" ");
        for (String str : numbersStrings) {
            int n = Integer.parseInt(str);
            mn = Math.min(mn, n);
            mx = Math.max(mx, n);
            listnumbers.add(n);
        }
        Nodes = non_Uniform_Scalar.Compress(listnumbers, level);
        model = (DefaultTableModel) Quantizer.getModel();
        double MSE = CalculateMSE(listnumbers, Nodes);
        i = 0;
        QIntegers = Q_numbers(listnumbers, Nodes);
        this.Qnmubers = new ArrayList<>(QIntegers);
        MSElabel.setText(Double.toString(MSE));
        tmp = ListToString(QIntegers);
        output.setText(tmp.substring(0, tmp.length() - 1));
        Binary.setText(ToBinaryString(QIntegers, level));
        ranges = non_Uniform_Scalar.getQuan();
        String filewrite=ToBinary(QIntegers);
        non_Uniform_Scalar.Write(ranges, filewrite, path);
        for (Map.Entry<Integer, Integer> entry : ranges.entrySet()) {
            model.addRow(new Object[]{Integer.toString(entry.getKey()), " ", Integer.toString(entry.getValue())});
        }
    }//GEN-LAST:event_compressActionPerformed

    private void DecompressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DecompressActionPerformed
        List<Integer> DeQIntegers = new ArrayList<>(non_Uniform_Scalar.Decompress(path));
        String resultString = ListToString(DeQIntegers);
        Deoutput.setText(resultString);
    }//GEN-LAST:event_DecompressActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUI().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Binary;
    private javax.swing.JButton Decompress;
    private javax.swing.JTextField Deoutput;
    private javax.swing.JTextField Input;
    private javax.swing.JLabel MSElabel;
    private javax.swing.JTable Quantizer;
    private javax.swing.JButton compress;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel levels;
    private javax.swing.JTextField levelsinput;
    private javax.swing.JLabel numbers;
    private javax.swing.JTextField output;
    // End of variables declaration//GEN-END:variables
}
