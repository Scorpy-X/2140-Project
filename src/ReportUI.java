import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.security.auth.kerberos.KerberosCredMessage;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ScrollPaneLayout;
import javax.xml.crypto.dsig.spec.HMACParameterSpec;

public class ReportUI extends JFrame {
    public ReportUI(TaylorAdmin th){
        setTitle("Report");
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(false);
        getContentPane().setLayout(new GridLayout(0, 1));
        getContentPane().setBackground(Color.lightGray);

        // JPanel DISPANEL = new JPanel();
        JLabel lbTotOccupants = new JLabel("Total # of Occupants: " + ReportGenerator.getTotalOccupants(th.getBlocks()));
        JLabel lbTotXCLFurn = new JLabel("Total # of Excellent Furniture: " + ReportGenerator.getExcellentFurniture(th.getBlocks()));
        JLabel lbTotFairFurn = new JLabel("Total # of Fair Furniture: " + ReportGenerator.getFairFurniture(th.getBlocks()));
        JLabel lbTotPoorFurn = new JLabel("Total # of Poor Furniture: " + ReportGenerator.getPoorFurniture(th.getBlocks()));
        JLabel lbTotMissingFurn = new JLabel("Total # of Rooms with Missing Furniture: " + ReportGenerator.getMissingFurniture(th.getBlocks()));

        JLabel lbBlockA = new JLabel("Block A");
        JLabel lbTotXCLBlocksA = new JLabel("Total # of Excellent Furniture (A): " + ReportGenerator.getExcellentFBlock('A', th.getBlocks()));
        JLabel lbTotFairBlocksA = new JLabel("Total # of Fair Furniture (A): " + ReportGenerator.getFairFBlock('A', th.getBlocks()));
        JLabel lbTotPoorBlocksA = new JLabel("Total # of Poor Furniture (A): " + ReportGenerator.getPoorFBlock('A', th.getBlocks()));
        JLabel lbTotMissingBlocksA = new JLabel("Total # of Missing Furniture (A): " + ReportGenerator.getMissingFBlock('A', th.getBlocks()));

        JLabel lbBlockB = new JLabel("Block B");
        JLabel lbTotXCLBlocksB = new JLabel("Total # of Excellent Furniture (B): " + ReportGenerator.getExcellentFBlock('B', th.getBlocks()));
        JLabel lbTotFairBlocksB = new JLabel("Total # of Fair Furniture (B): " + ReportGenerator.getFairFBlock('B', th.getBlocks()));
        JLabel lbTotPoorBlocksB = new JLabel("Total # of Poor Furniture (B): " + ReportGenerator.getPoorFBlock('B', th.getBlocks()));
        JLabel lbTotMissingBlocksB = new JLabel("Total # of Missing Furniture (B): " + ReportGenerator.getMissingFBlock('B', th.getBlocks()));

        JLabel lbBlockC = new JLabel("Block C");
        JLabel lbTotXCLBlocksC = new JLabel("Total # of Excellent Furniture (C): " + ReportGenerator.getExcellentFBlock('C', th.getBlocks()));
        JLabel lbTotFairBlocksC = new JLabel("Total # of Fair Furniture (C): " + ReportGenerator.getFairFBlock('C', th.getBlocks()));
        JLabel lbTotPoorBlocksC = new JLabel("Total # of Poor Furniture (C): " + ReportGenerator.getPoorFBlock('C', th.getBlocks()));
        JLabel lbTotMissingBlocksC = new JLabel("Total # of Missing Furniture (C): " + ReportGenerator.getMissingFBlock('C', th.getBlocks()));

        JLabel lbBlockD = new JLabel("Block D");
        JLabel lbTotXCLBlocksD = new JLabel("Total # of Excellent Furniture (D): " + ReportGenerator.getExcellentFBlock('D', th.getBlocks()));
        JLabel lbTotFairBlocksD = new JLabel("Total # of Fair Furniture (D): " + ReportGenerator.getFairFBlock('D', th.getBlocks()));
        JLabel lbTotPoorBlocksD = new JLabel("Total # of Poor Furniture (D): " + ReportGenerator.getPoorFBlock('D', th.getBlocks()));
        JLabel lbTotMissingBlocksD = new JLabel("Total # of Missing Furniture (D): " + ReportGenerator.getMissingFBlock('D', th.getBlocks()));

        JLabel lbBlockE = new JLabel("Block E");
        JLabel lbTotXCLBlocksE = new JLabel("Total # of Excellent Furniture (E): " + ReportGenerator.getExcellentFBlock('E', th.getBlocks()));
        JLabel lbTotFairBlocksE = new JLabel("Total # of Fair Furniture (E): " + ReportGenerator.getFairFBlock('E', th.getBlocks()));
        JLabel lbTotPoorBlocksE = new JLabel("Total # of Poor Furniture (E): " + ReportGenerator.getPoorFBlock('E', th.getBlocks()));
        JLabel lbTotMissingBlocksE = new JLabel("Total # of Missing Furniture (E): " + ReportGenerator.getMissingFBlock('E', th.getBlocks()));

        JLabel lbBlockF = new JLabel("Block F");
        JLabel lbTotXCLBlocksF = new JLabel("Total # of Excellent Furniture (F): " + ReportGenerator.getExcellentFBlock('F', th.getBlocks()));
        JLabel lbTotFairBlocksF = new JLabel("Total # of Fair Furniture (F): " + ReportGenerator.getFairFBlock('F', th.getBlocks()));
        JLabel lbTotPoorBlocksF = new JLabel("Total # of Poor Furniture (F): " + ReportGenerator.getPoorFBlock('F', th.getBlocks()));
        JLabel lbTotMissingBlocksF = new JLabel("Total # of Missing Furniture (F): " + ReportGenerator.getMissingFBlock('F', th.getBlocks()));

        JLabel lbBlockG = new JLabel("Block G");
        JLabel lbTotXCLBlocksG = new JLabel("Total # of Excellent Furniture (G): " + ReportGenerator.getExcellentFBlock('G', th.getBlocks()));
        JLabel lbTotFairBlocksG = new JLabel("Total # of Fair Furniture (G): " + ReportGenerator.getFairFBlock('G', th.getBlocks()));
        JLabel lbTotPoorBlocksG = new JLabel("Total # of Poor Furniture (G): " + ReportGenerator.getPoorFBlock('G', th.getBlocks()));
        JLabel lbTotMissingBlocksG = new JLabel("Total # of Missing Furniture (G): " + ReportGenerator.getMissingFBlock('G', th.getBlocks()));

        getContentPane().add(lbTotOccupants);
        getContentPane().add(lbTotXCLFurn);
        getContentPane().add(lbTotFairFurn);
        getContentPane().add(lbTotPoorFurn);
        getContentPane().add(lbTotMissingFurn);

        getContentPane().add(lbBlockA);
        getContentPane().add(lbTotXCLBlocksA);
        getContentPane().add(lbTotFairBlocksA);
        getContentPane().add(lbTotPoorBlocksA);
        getContentPane().add(lbTotMissingBlocksA);

        getContentPane().add(lbBlockB);
        getContentPane().add(lbTotXCLBlocksB);
        getContentPane().add(lbTotFairBlocksB);
        getContentPane().add(lbTotPoorBlocksB);
        getContentPane().add(lbTotMissingBlocksB);

        getContentPane().add(lbBlockC);
        getContentPane().add(lbTotXCLBlocksC);
        getContentPane().add(lbTotFairBlocksC);
        getContentPane().add(lbTotPoorBlocksC);
        getContentPane().add(lbTotMissingBlocksC);

        getContentPane().add(lbBlockD);
        getContentPane().add(lbTotXCLBlocksD);
        getContentPane().add(lbTotFairBlocksD);
        getContentPane().add(lbTotPoorBlocksD);
        getContentPane().add(lbTotMissingBlocksD);

        getContentPane().add(lbBlockE);
        getContentPane().add(lbTotXCLBlocksE);
        getContentPane().add(lbTotFairBlocksE);
        getContentPane().add(lbTotPoorBlocksE);
        getContentPane().add(lbTotMissingBlocksE);

        getContentPane().add(lbBlockF);
        getContentPane().add(lbTotXCLBlocksF);
        getContentPane().add(lbTotFairBlocksF);
        getContentPane().add(lbTotPoorBlocksF);
        getContentPane().add(lbTotMissingBlocksF);

        getContentPane().add(lbBlockG);
        getContentPane().add(lbTotXCLBlocksG);
        getContentPane().add(lbTotFairBlocksG);
        getContentPane().add(lbTotPoorBlocksG);
        getContentPane().add(lbTotMissingBlocksG);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        TaylorAdmin th = new TaylorAdmin();
        new ReportUI(th);
    }
}