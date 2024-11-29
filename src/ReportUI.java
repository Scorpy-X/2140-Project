import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.xml.crypto.dsig.spec.HMACParameterSpec;

public class ReportUI extends JFrame {
    public ReportUI(TaylorAdmin th){
        setTitle("Report");
        setSize(600, 600);
        setResizable(false);
        getContentPane().setLayout(new GridLayout(9, 2, 40, 20));

        // JPanel DISPANEL = new JPanel();
        JLabel lbTotOccupants = new JLabel("Total # of Occupants: " + ReportGenerator.getTotalOccupants(th.getBlocks()));
        JLabel lbTotXCLFurn = new JLabel("Total # of Excellent Furniture: " + ReportGenerator.getExcellentFurniture(th.getBlocks()));
        JLabel lbTotFairFurn = new JLabel("Total # of Fair Furniture: " + ReportGenerator.getFairFurniture(th.getBlocks()));
        JLabel lbTotPoorFurn = new JLabel("Total # of Poor Furniture: " + ReportGenerator.getPoorFurniture(th.getBlocks()));
        JLabel lbTotMissingFurn = new JLabel("Total # of Rooms with Missing Furniture: " + ReportGenerator.getMissingFurniture(th.getBlocks()));
        JLabel lbTotXCLBlocks = new JLabel("Total # of Blocks with Excellent Furniture: " + ReportGenerator.getExcellentFBlock('A', th.getBlocks()));
        JLabel lbTotFairBlocks = new JLabel("Total # of Blocks with Fair Furniture: " + ReportGenerator.getFairFBlock('A', th.getBlocks()));
        JLabel lbTotPoorBlocks = new JLabel("Total # of Blocks with Poor Furniture: " + ReportGenerator.getPoorFBlock('A', th.getBlocks()));
        JLabel lbTotMissingBlocks = new JLabel("Total # of Blocks with Missing Furniture: " + ReportGenerator.getMissingFBlock('A', th.getBlocks()));

        getContentPane().add(lbTotOccupants);
        getContentPane().add(lbTotXCLFurn);
        getContentPane().add(lbTotFairFurn);
        getContentPane().add(lbTotPoorFurn);
        getContentPane().add(lbTotMissingFurn);
        getContentPane().add(lbTotXCLBlocks);
        getContentPane().add(lbTotFairBlocks);
        getContentPane().add(lbTotPoorBlocks);
        getContentPane().add(lbTotMissingBlocks);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}