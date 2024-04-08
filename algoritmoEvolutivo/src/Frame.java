import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    private JTextField[][] celdas;

    public Frame() {
        initComponents();
        cargarCeldas();

        jBoton1.setText("Recursividad");
        jBoton2.setText("Genetico");
        jBoton3.setText("Meter un sudoku");
        jBoton4.setText("Corregir");

        for (int x = 0; x < 9; x++)
            for (int y = 0; y < 9; y++) celdas[x][y].setFont(new Font("SANS_SERIF", Font.BOLD, 14));

        getContentPane().setBackground(new Color(248, 227, 171));
        resetearBackgroundCeldas();
        setLocationRelativeTo(null);
    }

    private void cargarCeldas() {
        celdas = new JTextField[9][9];

        celdas[0][0] = jTextField1;
        celdas[0][1] = jTextField2;
        celdas[0][2] = jTextField3;
        celdas[0][3] = jTextField4;
        celdas[0][4] = jTextField5;
        celdas[0][5] = jTextField6;
        celdas[0][6] = jTextField7;
        celdas[0][7] = jTextField8;
        celdas[0][8] = jTextField9;

        celdas[1][0] = jTextField10;
        celdas[1][1] = jTextField11;
        celdas[1][2] = jTextField12;
        celdas[1][3] = jTextField13;
        celdas[1][4] = jTextField14;
        celdas[1][5] = jTextField15;
        celdas[1][6] = jTextField16;
        celdas[1][7] = jTextField17;
        celdas[1][8] = jTextField18;

        celdas[2][0] = jTextField19;
        celdas[2][1] = jTextField20;
        celdas[2][2] = jTextField21;
        celdas[2][3] = jTextField22;
        celdas[2][4] = jTextField23;
        celdas[2][5] = jTextField24;
        celdas[2][6] = jTextField25;
        celdas[2][7] = jTextField26;
        celdas[2][8] = jTextField27;

        celdas[3][0] = jTextField28;
        celdas[3][1] = jTextField29;
        celdas[3][2] = jTextField30;
        celdas[3][3] = jTextField31;
        celdas[3][4] = jTextField32;
        celdas[3][5] = jTextField33;
        celdas[3][6] = jTextField34;
        celdas[3][7] = jTextField35;
        celdas[3][8] = jTextField36;

        celdas[4][0] = jTextField37;
        celdas[4][1] = jTextField38;
        celdas[4][2] = jTextField39;
        celdas[4][3] = jTextField40;
        celdas[4][4] = jTextField41;
        celdas[4][5] = jTextField42;
        celdas[4][6] = jTextField43;
        celdas[4][7] = jTextField44;
        celdas[4][8] = jTextField45;

        celdas[5][0] = jTextField46;
        celdas[5][1] = jTextField47;
        celdas[5][2] = jTextField48;
        celdas[5][3] = jTextField49;
        celdas[5][4] = jTextField50;
        celdas[5][5] = jTextField51;
        celdas[5][6] = jTextField52;
        celdas[5][7] = jTextField53;
        celdas[5][8] = jTextField54;

        celdas[6][0] = jTextField55;
        celdas[6][1] = jTextField56;
        celdas[6][2] = jTextField57;
        celdas[6][3] = jTextField58;
        celdas[6][4] = jTextField59;
        celdas[6][5] = jTextField60;
        celdas[6][6] = jTextField61;
        celdas[6][7] = jTextField62;
        celdas[6][8] = jTextField63;

        celdas[7][0] = jTextField64;
        celdas[7][1] = jTextField65;
        celdas[7][2] = jTextField66;
        celdas[7][3] = jTextField67;
        celdas[7][4] = jTextField68;
        celdas[7][5] = jTextField69;
        celdas[7][6] = jTextField70;
        celdas[7][7] = jTextField71;
        celdas[7][8] = jTextField72;

        celdas[8][0] = jTextField73;
        celdas[8][1] = jTextField74;
        celdas[8][2] = jTextField75;
        celdas[8][3] = jTextField76;
        celdas[8][4] = jTextField77;
        celdas[8][5] = jTextField78;
        celdas[8][6] = jTextField79;
        celdas[8][7] = jTextField80;
        celdas[8][8] = jTextField81;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jTextField1 = new JTextField();
        jTextField2 = new JTextField();
        jTextField3 = new JTextField();
        jTextField4 = new JTextField();
        jTextField5 = new JTextField();
        jTextField6 = new JTextField();
        jTextField7 = new JTextField();
        jTextField8 = new JTextField();
        jTextField9 = new JTextField();
        jTextField10 = new JTextField();
        jTextField11 = new JTextField();
        jTextField12 = new JTextField();
        jTextField13 = new JTextField();
        jTextField14 = new JTextField();
        jTextField15 = new JTextField();
        jTextField16 = new JTextField();
        jTextField17 = new JTextField();
        jTextField18 = new JTextField();
        jTextField19 = new JTextField();
        jTextField20 = new JTextField();
        jTextField21 = new JTextField();
        jTextField22 = new JTextField();
        jTextField23 = new JTextField();
        jTextField24 = new JTextField();
        jTextField25 = new JTextField();
        jTextField26 = new JTextField();
        jTextField27 = new JTextField();
        jTextField28 = new JTextField();
        jTextField29 = new JTextField();
        jTextField30 = new JTextField();
        jTextField31 = new JTextField();
        jTextField32 = new JTextField();
        jTextField33 = new JTextField();
        jTextField34 = new JTextField();
        jTextField35 = new JTextField();
        jTextField36 = new JTextField();
        jTextField37 = new JTextField();
        jTextField38 = new JTextField();
        jTextField39 = new JTextField();
        jTextField40 = new JTextField();
        jTextField41 = new JTextField();
        jTextField42 = new JTextField();
        jTextField43 = new JTextField();
        jTextField44 = new JTextField();
        jTextField45 = new JTextField();
        jTextField46 = new JTextField();
        jTextField47 = new JTextField();
        jTextField48 = new JTextField();
        jTextField49 = new JTextField();
        jTextField50 = new JTextField();
        jTextField51 = new JTextField();
        jTextField52 = new JTextField();
        jTextField53 = new JTextField();
        jTextField54 = new JTextField();
        jTextField55 = new JTextField();
        jTextField56 = new JTextField();
        jTextField57 = new JTextField();
        jTextField58 = new JTextField();
        jTextField59 = new JTextField();
        jTextField60 = new JTextField();
        jTextField61 = new JTextField();
        jTextField62 = new JTextField();
        jTextField63 = new JTextField();
        jTextField64 = new JTextField();
        jTextField65 = new JTextField();
        jTextField66 = new JTextField();
        jTextField67 = new JTextField();
        jTextField68 = new JTextField();
        jTextField69 = new JTextField();
        jTextField70 = new JTextField();
        jTextField71 = new JTextField();
        jTextField72 = new JTextField();
        jTextField73 = new JTextField();
        jTextField74 = new JTextField();
        jTextField75 = new JTextField();
        jTextField76 = new JTextField();
        jTextField77 = new JTextField();
        jTextField78 = new JTextField();
        jTextField79 = new JTextField();
        jTextField80 = new JTextField();
        jTextField81 = new JTextField();
        jBoton1 = new JButton();
        jBoton2 = new JButton();
        jBoton3 = new JButton();
        jBoton4 = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jTextField1.setHorizontalAlignment(JTextField.CENTER);
        jTextField1.setText("0");
        jTextField1.setMaximumSize(new Dimension(5, 5));
        jTextField1.setMinimumSize(new Dimension(5, 5));
        jTextField1.setPreferredSize(new Dimension(5, 5));

        jTextField2.setHorizontalAlignment(JTextField.CENTER);
        jTextField2.setText("0");
        jTextField2.setMaximumSize(new Dimension(5, 5));
        jTextField2.setMinimumSize(new Dimension(5, 5));
        jTextField2.setPreferredSize(new Dimension(5, 5));

        jTextField3.setHorizontalAlignment(JTextField.CENTER);
        jTextField3.setText("0");
        jTextField3.setMaximumSize(new Dimension(5, 5));
        jTextField3.setMinimumSize(new Dimension(5, 5));
        jTextField3.setPreferredSize(new Dimension(5, 5));

        jTextField4.setHorizontalAlignment(JTextField.CENTER);
        jTextField4.setText("0");
        jTextField4.setMaximumSize(new Dimension(5, 5));
        jTextField4.setMinimumSize(new Dimension(5, 5));
        jTextField4.setPreferredSize(new Dimension(5, 5));

        jTextField5.setHorizontalAlignment(JTextField.CENTER);
        jTextField5.setText("0");
        jTextField5.setMaximumSize(new Dimension(5, 5));
        jTextField5.setMinimumSize(new Dimension(5, 5));
        jTextField5.setPreferredSize(new Dimension(5, 5));

        jTextField6.setHorizontalAlignment(JTextField.CENTER);
        jTextField6.setText("0");
        jTextField6.setMaximumSize(new Dimension(5, 5));
        jTextField6.setMinimumSize(new Dimension(5, 5));
        jTextField6.setPreferredSize(new Dimension(5, 5));

        jTextField7.setHorizontalAlignment(JTextField.CENTER);
        jTextField7.setText("0");
        jTextField7.setMaximumSize(new Dimension(5, 5));
        jTextField7.setMinimumSize(new Dimension(5, 5));
        jTextField7.setPreferredSize(new Dimension(5, 5));

        jTextField8.setHorizontalAlignment(JTextField.CENTER);
        jTextField8.setText("0");
        jTextField8.setMaximumSize(new Dimension(5, 5));
        jTextField8.setMinimumSize(new Dimension(5, 5));
        jTextField8.setPreferredSize(new Dimension(5, 5));

        jTextField9.setHorizontalAlignment(JTextField.CENTER);
        jTextField9.setText("0");
        jTextField9.setMaximumSize(new Dimension(5, 5));
        jTextField9.setMinimumSize(new Dimension(5, 5));
        jTextField9.setPreferredSize(new Dimension(5, 5));

        jTextField10.setHorizontalAlignment(JTextField.CENTER);
        jTextField10.setText("0");
        jTextField10.setMaximumSize(new Dimension(5, 5));
        jTextField10.setMinimumSize(new Dimension(5, 5));
        jTextField10.setPreferredSize(new Dimension(5, 5));

        jTextField11.setHorizontalAlignment(JTextField.CENTER);
        jTextField11.setText("0");
        jTextField11.setMaximumSize(new Dimension(5, 5));
        jTextField11.setMinimumSize(new Dimension(5, 5));
        jTextField11.setPreferredSize(new Dimension(5, 5));

        jTextField12.setHorizontalAlignment(JTextField.CENTER);
        jTextField12.setText("0");
        jTextField12.setMaximumSize(new Dimension(5, 5));
        jTextField12.setMinimumSize(new Dimension(5, 5));
        jTextField12.setPreferredSize(new Dimension(5, 5));

        jTextField13.setHorizontalAlignment(JTextField.CENTER);
        jTextField13.setText("0");
        jTextField13.setMaximumSize(new Dimension(5, 5));
        jTextField13.setMinimumSize(new Dimension(5, 5));
        jTextField13.setPreferredSize(new Dimension(5, 5));

        jTextField14.setHorizontalAlignment(JTextField.CENTER);
        jTextField14.setText("0");
        jTextField14.setMaximumSize(new Dimension(5, 5));
        jTextField14.setMinimumSize(new Dimension(5, 5));
        jTextField14.setPreferredSize(new Dimension(5, 5));

        jTextField15.setHorizontalAlignment(JTextField.CENTER);
        jTextField15.setText("0");
        jTextField15.setMaximumSize(new Dimension(5, 5));
        jTextField15.setMinimumSize(new Dimension(5, 5));
        jTextField15.setPreferredSize(new Dimension(5, 5));

        jTextField16.setHorizontalAlignment(JTextField.CENTER);
        jTextField16.setText("0");
        jTextField16.setMaximumSize(new Dimension(5, 5));
        jTextField16.setMinimumSize(new Dimension(5, 5));
        jTextField16.setPreferredSize(new Dimension(5, 5));

        jTextField17.setHorizontalAlignment(JTextField.CENTER);
        jTextField17.setText("0");
        jTextField17.setMaximumSize(new Dimension(5, 5));
        jTextField17.setMinimumSize(new Dimension(5, 5));
        jTextField17.setPreferredSize(new Dimension(5, 5));

        jTextField18.setHorizontalAlignment(JTextField.CENTER);
        jTextField18.setText("0");
        jTextField18.setMaximumSize(new Dimension(5, 5));
        jTextField18.setMinimumSize(new Dimension(5, 5));
        jTextField18.setPreferredSize(new Dimension(5, 5));

        jTextField19.setHorizontalAlignment(JTextField.CENTER);
        jTextField19.setText("0");
        jTextField19.setMaximumSize(new Dimension(5, 5));
        jTextField19.setMinimumSize(new Dimension(5, 5));
        jTextField19.setPreferredSize(new Dimension(5, 5));

        jTextField20.setHorizontalAlignment(JTextField.CENTER);
        jTextField20.setText("0");
        jTextField20.setMaximumSize(new Dimension(5, 5));
        jTextField20.setMinimumSize(new Dimension(5, 5));
        jTextField20.setPreferredSize(new Dimension(5, 5));

        jTextField21.setHorizontalAlignment(JTextField.CENTER);
        jTextField21.setText("0");
        jTextField21.setMaximumSize(new Dimension(5, 5));
        jTextField21.setMinimumSize(new Dimension(5, 5));
        jTextField21.setPreferredSize(new Dimension(5, 5));

        jTextField22.setHorizontalAlignment(JTextField.CENTER);
        jTextField22.setText("0");
        jTextField22.setMaximumSize(new Dimension(5, 5));
        jTextField22.setMinimumSize(new Dimension(5, 5));
        jTextField22.setPreferredSize(new Dimension(5, 5));

        jTextField23.setHorizontalAlignment(JTextField.CENTER);
        jTextField23.setText("0");
        jTextField23.setMaximumSize(new Dimension(5, 5));
        jTextField23.setMinimumSize(new Dimension(5, 5));
        jTextField23.setPreferredSize(new Dimension(5, 5));

        jTextField24.setHorizontalAlignment(JTextField.CENTER);
        jTextField24.setText("0");
        jTextField24.setMaximumSize(new Dimension(5, 5));
        jTextField24.setMinimumSize(new Dimension(5, 5));
        jTextField24.setPreferredSize(new Dimension(5, 5));

        jTextField25.setHorizontalAlignment(JTextField.CENTER);
        jTextField25.setText("0");
        jTextField25.setMaximumSize(new Dimension(5, 5));
        jTextField25.setMinimumSize(new Dimension(5, 5));
        jTextField25.setPreferredSize(new Dimension(5, 5));

        jTextField26.setHorizontalAlignment(JTextField.CENTER);
        jTextField26.setText("0");
        jTextField26.setMaximumSize(new Dimension(5, 5));
        jTextField26.setMinimumSize(new Dimension(5, 5));
        jTextField26.setPreferredSize(new Dimension(5, 5));

        jTextField27.setHorizontalAlignment(JTextField.CENTER);
        jTextField27.setText("0");
        jTextField27.setMaximumSize(new Dimension(5, 5));
        jTextField27.setMinimumSize(new Dimension(5, 5));
        jTextField27.setPreferredSize(new Dimension(5, 5));

        jTextField28.setHorizontalAlignment(JTextField.CENTER);
        jTextField28.setText("0");
        jTextField28.setMaximumSize(new Dimension(5, 5));
        jTextField28.setMinimumSize(new Dimension(5, 5));
        jTextField28.setPreferredSize(new Dimension(5, 5));

        jTextField29.setHorizontalAlignment(JTextField.CENTER);
        jTextField29.setText("0");
        jTextField29.setMaximumSize(new Dimension(5, 5));
        jTextField29.setMinimumSize(new Dimension(5, 5));
        jTextField29.setPreferredSize(new Dimension(5, 5));

        jTextField30.setHorizontalAlignment(JTextField.CENTER);
        jTextField30.setText("0");
        jTextField30.setMaximumSize(new Dimension(5, 5));
        jTextField30.setMinimumSize(new Dimension(5, 5));
        jTextField30.setPreferredSize(new Dimension(5, 5));

        jTextField31.setHorizontalAlignment(JTextField.CENTER);
        jTextField31.setText("0");
        jTextField31.setMaximumSize(new Dimension(5, 5));
        jTextField31.setMinimumSize(new Dimension(5, 5));
        jTextField31.setPreferredSize(new Dimension(5, 5));

        jTextField32.setHorizontalAlignment(JTextField.CENTER);
        jTextField32.setText("0");
        jTextField32.setMaximumSize(new Dimension(5, 5));
        jTextField32.setMinimumSize(new Dimension(5, 5));
        jTextField32.setPreferredSize(new Dimension(5, 5));

        jTextField33.setHorizontalAlignment(JTextField.CENTER);
        jTextField33.setText("0");
        jTextField33.setMaximumSize(new Dimension(5, 5));
        jTextField33.setMinimumSize(new Dimension(5, 5));
        jTextField33.setPreferredSize(new Dimension(5, 5));

        jTextField34.setHorizontalAlignment(JTextField.CENTER);
        jTextField34.setText("0");
        jTextField34.setMaximumSize(new Dimension(5, 5));
        jTextField34.setMinimumSize(new Dimension(5, 5));
        jTextField34.setPreferredSize(new Dimension(5, 5));

        jTextField35.setHorizontalAlignment(JTextField.CENTER);
        jTextField35.setText("0");
        jTextField35.setMaximumSize(new Dimension(5, 5));
        jTextField35.setMinimumSize(new Dimension(5, 5));
        jTextField35.setPreferredSize(new Dimension(5, 5));

        jTextField36.setHorizontalAlignment(JTextField.CENTER);
        jTextField36.setText("0");
        jTextField36.setMaximumSize(new Dimension(5, 5));
        jTextField36.setMinimumSize(new Dimension(5, 5));
        jTextField36.setPreferredSize(new Dimension(5, 5));

        jTextField37.setHorizontalAlignment(JTextField.CENTER);
        jTextField37.setText("0");
        jTextField37.setMaximumSize(new Dimension(5, 5));
        jTextField37.setMinimumSize(new Dimension(5, 5));
        jTextField37.setPreferredSize(new Dimension(5, 5));

        jTextField38.setHorizontalAlignment(JTextField.CENTER);
        jTextField38.setText("0");
        jTextField38.setMaximumSize(new Dimension(5, 5));
        jTextField38.setMinimumSize(new Dimension(5, 5));
        jTextField38.setPreferredSize(new Dimension(5, 5));

        jTextField39.setHorizontalAlignment(JTextField.CENTER);
        jTextField39.setText("0");
        jTextField39.setMaximumSize(new Dimension(5, 5));
        jTextField39.setMinimumSize(new Dimension(5, 5));
        jTextField39.setPreferredSize(new Dimension(5, 5));

        jTextField40.setHorizontalAlignment(JTextField.CENTER);
        jTextField40.setText("0");
        jTextField40.setMaximumSize(new Dimension(5, 5));
        jTextField40.setMinimumSize(new Dimension(5, 5));
        jTextField40.setPreferredSize(new Dimension(5, 5));

        jTextField41.setHorizontalAlignment(JTextField.CENTER);
        jTextField41.setText("0");
        jTextField41.setMaximumSize(new Dimension(5, 5));
        jTextField41.setMinimumSize(new Dimension(5, 5));
        jTextField41.setPreferredSize(new Dimension(5, 5));

        jTextField42.setHorizontalAlignment(JTextField.CENTER);
        jTextField42.setText("0");
        jTextField42.setMaximumSize(new Dimension(5, 5));
        jTextField42.setMinimumSize(new Dimension(5, 5));
        jTextField42.setPreferredSize(new Dimension(5, 5));

        jTextField43.setHorizontalAlignment(JTextField.CENTER);
        jTextField43.setText("0");
        jTextField43.setMaximumSize(new Dimension(5, 5));
        jTextField43.setMinimumSize(new Dimension(5, 5));
        jTextField43.setPreferredSize(new Dimension(5, 5));

        jTextField44.setHorizontalAlignment(JTextField.CENTER);
        jTextField44.setText("0");
        jTextField44.setMaximumSize(new Dimension(5, 5));
        jTextField44.setMinimumSize(new Dimension(5, 5));
        jTextField44.setPreferredSize(new Dimension(5, 5));

        jTextField45.setHorizontalAlignment(JTextField.CENTER);
        jTextField45.setText("0");
        jTextField45.setMaximumSize(new Dimension(5, 5));
        jTextField45.setMinimumSize(new Dimension(5, 5));
        jTextField45.setPreferredSize(new Dimension(5, 5));

        jTextField46.setHorizontalAlignment(JTextField.CENTER);
        jTextField46.setText("0");
        jTextField46.setMaximumSize(new Dimension(5, 5));
        jTextField46.setMinimumSize(new Dimension(5, 5));
        jTextField46.setPreferredSize(new Dimension(5, 5));

        jTextField47.setHorizontalAlignment(JTextField.CENTER);
        jTextField47.setText("0");
        jTextField47.setMaximumSize(new Dimension(5, 5));
        jTextField47.setMinimumSize(new Dimension(5, 5));
        jTextField47.setPreferredSize(new Dimension(5, 5));

        jTextField48.setHorizontalAlignment(JTextField.CENTER);
        jTextField48.setText("0");
        jTextField48.setMaximumSize(new Dimension(5, 5));
        jTextField48.setMinimumSize(new Dimension(5, 5));
        jTextField48.setPreferredSize(new Dimension(5, 5));

        jTextField49.setHorizontalAlignment(JTextField.CENTER);
        jTextField49.setText("0");
        jTextField49.setMaximumSize(new Dimension(5, 5));
        jTextField49.setMinimumSize(new Dimension(5, 5));
        jTextField49.setPreferredSize(new Dimension(5, 5));

        jTextField50.setHorizontalAlignment(JTextField.CENTER);
        jTextField50.setText("0");
        jTextField50.setMaximumSize(new Dimension(5, 5));
        jTextField50.setMinimumSize(new Dimension(5, 5));
        jTextField50.setPreferredSize(new Dimension(5, 5));

        jTextField51.setHorizontalAlignment(JTextField.CENTER);
        jTextField51.setText("0");
        jTextField51.setMaximumSize(new Dimension(5, 5));
        jTextField51.setMinimumSize(new Dimension(5, 5));
        jTextField51.setPreferredSize(new Dimension(5, 5));

        jTextField52.setHorizontalAlignment(JTextField.CENTER);
        jTextField52.setText("0");
        jTextField52.setMaximumSize(new Dimension(5, 5));
        jTextField52.setMinimumSize(new Dimension(5, 5));
        jTextField52.setPreferredSize(new Dimension(5, 5));

        jTextField53.setHorizontalAlignment(JTextField.CENTER);
        jTextField53.setText("0");
        jTextField53.setMaximumSize(new Dimension(5, 5));
        jTextField53.setMinimumSize(new Dimension(5, 5));
        jTextField53.setPreferredSize(new Dimension(5, 5));

        jTextField54.setHorizontalAlignment(JTextField.CENTER);
        jTextField54.setText("0");
        jTextField54.setMaximumSize(new Dimension(5, 5));
        jTextField54.setMinimumSize(new Dimension(5, 5));
        jTextField54.setPreferredSize(new Dimension(5, 5));

        jTextField55.setHorizontalAlignment(JTextField.CENTER);
        jTextField55.setText("0");
        jTextField55.setMaximumSize(new Dimension(5, 5));
        jTextField55.setMinimumSize(new Dimension(5, 5));
        jTextField55.setPreferredSize(new Dimension(5, 5));

        jTextField56.setHorizontalAlignment(JTextField.CENTER);
        jTextField56.setText("0");
        jTextField56.setMaximumSize(new Dimension(5, 5));
        jTextField56.setMinimumSize(new Dimension(5, 5));
        jTextField56.setPreferredSize(new Dimension(5, 5));

        jTextField57.setHorizontalAlignment(JTextField.CENTER);
        jTextField57.setText("0");
        jTextField57.setMaximumSize(new Dimension(5, 5));
        jTextField57.setMinimumSize(new Dimension(5, 5));
        jTextField57.setPreferredSize(new Dimension(5, 5));

        jTextField58.setHorizontalAlignment(JTextField.CENTER);
        jTextField58.setText("0");
        jTextField58.setMaximumSize(new Dimension(5, 5));
        jTextField58.setMinimumSize(new Dimension(5, 5));
        jTextField58.setPreferredSize(new Dimension(5, 5));

        jTextField59.setHorizontalAlignment(JTextField.CENTER);
        jTextField59.setText("0");
        jTextField59.setMaximumSize(new Dimension(5, 5));
        jTextField59.setMinimumSize(new Dimension(5, 5));
        jTextField59.setPreferredSize(new Dimension(5, 5));

        jTextField60.setHorizontalAlignment(JTextField.CENTER);
        jTextField60.setText("0");
        jTextField60.setMaximumSize(new Dimension(5, 5));
        jTextField60.setMinimumSize(new Dimension(5, 5));
        jTextField60.setPreferredSize(new Dimension(5, 5));

        jTextField61.setHorizontalAlignment(JTextField.CENTER);
        jTextField61.setText("0");
        jTextField61.setMaximumSize(new Dimension(5, 5));
        jTextField61.setMinimumSize(new Dimension(5, 5));
        jTextField61.setPreferredSize(new Dimension(5, 5));

        jTextField62.setHorizontalAlignment(JTextField.CENTER);
        jTextField62.setText("0");
        jTextField62.setMaximumSize(new Dimension(5, 5));
        jTextField62.setMinimumSize(new Dimension(5, 5));
        jTextField62.setPreferredSize(new Dimension(5, 5));

        jTextField63.setHorizontalAlignment(JTextField.CENTER);
        jTextField63.setText("0");
        jTextField63.setMaximumSize(new Dimension(5, 5));
        jTextField63.setMinimumSize(new Dimension(5, 5));
        jTextField63.setPreferredSize(new Dimension(5, 5));

        jTextField64.setHorizontalAlignment(JTextField.CENTER);
        jTextField64.setText("0");
        jTextField64.setMaximumSize(new Dimension(5, 5));
        jTextField64.setMinimumSize(new Dimension(5, 5));
        jTextField64.setPreferredSize(new Dimension(5, 5));

        jTextField65.setHorizontalAlignment(JTextField.CENTER);
        jTextField65.setText("0");
        jTextField65.setMaximumSize(new Dimension(5, 5));
        jTextField65.setMinimumSize(new Dimension(5, 5));
        jTextField65.setPreferredSize(new Dimension(5, 5));

        jTextField66.setHorizontalAlignment(JTextField.CENTER);
        jTextField66.setText("0");
        jTextField66.setMaximumSize(new Dimension(5, 5));
        jTextField66.setMinimumSize(new Dimension(5, 5));
        jTextField66.setPreferredSize(new Dimension(5, 5));

        jTextField67.setHorizontalAlignment(JTextField.CENTER);
        jTextField67.setText("0");
        jTextField67.setMaximumSize(new Dimension(5, 5));
        jTextField67.setMinimumSize(new Dimension(5, 5));
        jTextField67.setPreferredSize(new Dimension(5, 5));

        jTextField68.setHorizontalAlignment(JTextField.CENTER);
        jTextField68.setText("0");
        jTextField68.setMaximumSize(new Dimension(5, 5));
        jTextField68.setMinimumSize(new Dimension(5, 5));
        jTextField68.setPreferredSize(new Dimension(5, 5));

        jTextField69.setHorizontalAlignment(JTextField.CENTER);
        jTextField69.setText("0");
        jTextField69.setMaximumSize(new Dimension(5, 5));
        jTextField69.setMinimumSize(new Dimension(5, 5));
        jTextField69.setPreferredSize(new Dimension(5, 5));

        jTextField70.setHorizontalAlignment(JTextField.CENTER);
        jTextField70.setText("0");
        jTextField70.setMaximumSize(new Dimension(5, 5));
        jTextField70.setMinimumSize(new Dimension(5, 5));
        jTextField70.setPreferredSize(new Dimension(5, 5));

        jTextField71.setHorizontalAlignment(JTextField.CENTER);
        jTextField71.setText("0");
        jTextField71.setMaximumSize(new Dimension(5, 5));
        jTextField71.setMinimumSize(new Dimension(5, 5));
        jTextField71.setPreferredSize(new Dimension(5, 5));

        jTextField72.setHorizontalAlignment(JTextField.CENTER);
        jTextField72.setText("0");
        jTextField72.setMaximumSize(new Dimension(5, 5));
        jTextField72.setMinimumSize(new Dimension(5, 5));
        jTextField72.setPreferredSize(new Dimension(5, 5));

        jTextField73.setHorizontalAlignment(JTextField.CENTER);
        jTextField73.setText("0");
        jTextField73.setMaximumSize(new Dimension(5, 5));
        jTextField73.setMinimumSize(new Dimension(5, 5));
        jTextField73.setPreferredSize(new Dimension(5, 5));

        jTextField74.setHorizontalAlignment(JTextField.CENTER);
        jTextField74.setText("0");
        jTextField74.setMaximumSize(new Dimension(5, 5));
        jTextField74.setMinimumSize(new Dimension(5, 5));
        jTextField74.setPreferredSize(new Dimension(5, 5));

        jTextField75.setHorizontalAlignment(JTextField.CENTER);
        jTextField75.setText("0");
        jTextField75.setMaximumSize(new Dimension(5, 5));
        jTextField75.setMinimumSize(new Dimension(5, 5));
        jTextField75.setPreferredSize(new Dimension(5, 5));

        jTextField76.setHorizontalAlignment(JTextField.CENTER);
        jTextField76.setText("0");
        jTextField76.setMaximumSize(new Dimension(5, 5));
        jTextField76.setMinimumSize(new Dimension(5, 5));
        jTextField76.setPreferredSize(new Dimension(5, 5));

        jTextField77.setHorizontalAlignment(JTextField.CENTER);
        jTextField77.setText("0");
        jTextField77.setMaximumSize(new Dimension(5, 5));
        jTextField77.setMinimumSize(new Dimension(5, 5));
        jTextField77.setPreferredSize(new Dimension(5, 5));

        jTextField78.setHorizontalAlignment(JTextField.CENTER);
        jTextField78.setText("0");
        jTextField78.setMaximumSize(new Dimension(5, 5));
        jTextField78.setMinimumSize(new Dimension(5, 5));
        jTextField78.setPreferredSize(new Dimension(5, 5));

        jTextField79.setHorizontalAlignment(JTextField.CENTER);
        jTextField79.setText("0");
        jTextField79.setMaximumSize(new Dimension(5, 5));
        jTextField79.setMinimumSize(new Dimension(5, 5));
        jTextField79.setPreferredSize(new Dimension(5, 5));

        jTextField80.setHorizontalAlignment(JTextField.CENTER);
        jTextField80.setText("0");
        jTextField80.setMaximumSize(new Dimension(5, 5));
        jTextField80.setMinimumSize(new Dimension(5, 5));
        jTextField80.setPreferredSize(new Dimension(5, 5));

        jTextField81.setHorizontalAlignment(JTextField.CENTER);
        jTextField81.setText("0");
        jTextField81.setMaximumSize(new Dimension(5, 5));
        jTextField81.setMinimumSize(new Dimension(5, 5));
        jTextField81.setPreferredSize(new Dimension(5, 5));

        jBoton1.setLabel("boton1");
        jBoton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBoton1ActionPerformed(evt);
            }
        });

        jBoton2.setLabel("boton2");
        jBoton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBoton2ActionPerformed(evt);
            }
        });

        jBoton3.setText("boton3");
        jBoton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBoton3ActionPerformed(evt);
            }
        });

        jBoton4.setText("boton4");
        jBoton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBoton4ActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout
                .createSequentialGroup().addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
                                GroupLayout.Alignment.TRAILING,
                                layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addGroup(layout
                                        .createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jTextField19, GroupLayout.PREFERRED_SIZE, 28,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField20, GroupLayout.PREFERRED_SIZE, 28,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField21, GroupLayout.PREFERRED_SIZE, 28,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jTextField22, GroupLayout.PREFERRED_SIZE, 28,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField23, GroupLayout.PREFERRED_SIZE, 28,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField24, GroupLayout.PREFERRED_SIZE, 28,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jTextField25, GroupLayout.PREFERRED_SIZE, 28,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField26, GroupLayout.PREFERRED_SIZE, 28,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField27, GroupLayout.PREFERRED_SIZE, 28,
                                                        GroupLayout.PREFERRED_SIZE))
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jTextField28, GroupLayout.PREFERRED_SIZE, 28,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField29, GroupLayout.PREFERRED_SIZE, 28,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField30, GroupLayout.PREFERRED_SIZE, 28,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jTextField31, GroupLayout.PREFERRED_SIZE, 28,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField32, GroupLayout.PREFERRED_SIZE, 28,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField33, GroupLayout.PREFERRED_SIZE, 28,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jTextField34, GroupLayout.PREFERRED_SIZE, 28,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField35, GroupLayout.PREFERRED_SIZE, 28,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField36, GroupLayout.PREFERRED_SIZE, 28,
                                                        GroupLayout.PREFERRED_SIZE))
                                        .addGroup(GroupLayout.Alignment.TRAILING,
                                                layout.createSequentialGroup()
                                                        .addComponent(jTextField37, GroupLayout.PREFERRED_SIZE, 28,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jTextField38, GroupLayout.PREFERRED_SIZE, 28,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jTextField39, GroupLayout.PREFERRED_SIZE, 28,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jTextField40, GroupLayout.PREFERRED_SIZE, 28,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jTextField41, GroupLayout.PREFERRED_SIZE, 28,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jTextField42, GroupLayout.PREFERRED_SIZE, 28,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jTextField43, GroupLayout.PREFERRED_SIZE, 28,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jTextField44, GroupLayout.PREFERRED_SIZE, 28,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jTextField45, GroupLayout.PREFERRED_SIZE, 28,
                                                                GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 28,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 28,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, 28,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, 28,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField5, GroupLayout.PREFERRED_SIZE, 28,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField6, GroupLayout.PREFERRED_SIZE, 28,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jTextField7, GroupLayout.PREFERRED_SIZE, 28,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField8, GroupLayout.PREFERRED_SIZE, 28,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField9, GroupLayout.PREFERRED_SIZE, 28,
                                                        GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jTextField10, GroupLayout.PREFERRED_SIZE, 28,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField11, GroupLayout.PREFERRED_SIZE, 28,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField12, GroupLayout.PREFERRED_SIZE, 28,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jTextField13, GroupLayout.PREFERRED_SIZE, 28,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField14, GroupLayout.PREFERRED_SIZE, 28,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField15, GroupLayout.PREFERRED_SIZE, 28,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jTextField16, GroupLayout.PREFERRED_SIZE, 28,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField17, GroupLayout.PREFERRED_SIZE, 28,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField18, GroupLayout.PREFERRED_SIZE, 28,
                                                        GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jTextField46, GroupLayout.PREFERRED_SIZE, 28,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField47, GroupLayout.PREFERRED_SIZE, 28,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField48, GroupLayout.PREFERRED_SIZE, 28,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jTextField49, GroupLayout.PREFERRED_SIZE, 28,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField50, GroupLayout.PREFERRED_SIZE, 28,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField51, GroupLayout.PREFERRED_SIZE, 28,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jTextField52, GroupLayout.PREFERRED_SIZE, 28,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField53, GroupLayout.PREFERRED_SIZE, 28,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(
                                                        jTextField54, GroupLayout.PREFERRED_SIZE, 28,
                                                        GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jTextField55,
                                                                GroupLayout.PREFERRED_SIZE, 28,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(
                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jTextField56,
                                                                GroupLayout.PREFERRED_SIZE, 28,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(
                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jTextField57,
                                                                GroupLayout.PREFERRED_SIZE, 28,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jTextField58,
                                                                GroupLayout.PREFERRED_SIZE, 28,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(
                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jTextField59,
                                                                GroupLayout.PREFERRED_SIZE, 28,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(
                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jTextField60,
                                                                GroupLayout.PREFERRED_SIZE, 28,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jTextField61,
                                                                GroupLayout.PREFERRED_SIZE, 28,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(
                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jTextField62,
                                                                GroupLayout.PREFERRED_SIZE, 28,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(
                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jTextField63,
                                                                GroupLayout.PREFERRED_SIZE, 28,
                                                                GroupLayout.PREFERRED_SIZE))
                                                .addGroup(GroupLayout.Alignment.TRAILING, layout
                                                        .createSequentialGroup()
                                                        .addComponent(jTextField64,
                                                                GroupLayout.PREFERRED_SIZE, 28,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(
                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jTextField65,
                                                                GroupLayout.PREFERRED_SIZE, 28,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(
                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jTextField66,
                                                                GroupLayout.PREFERRED_SIZE, 28,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jTextField67,
                                                                GroupLayout.PREFERRED_SIZE, 28,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(
                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jTextField68,
                                                                GroupLayout.PREFERRED_SIZE, 28,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(
                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jTextField69,
                                                                GroupLayout.PREFERRED_SIZE, 28,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jTextField70,
                                                                GroupLayout.PREFERRED_SIZE, 28,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(
                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jTextField71,
                                                                GroupLayout.PREFERRED_SIZE, 28,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(
                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jTextField72,
                                                                GroupLayout.PREFERRED_SIZE, 28,
                                                                GroupLayout.PREFERRED_SIZE))
                                                .addGroup(GroupLayout.Alignment.TRAILING, layout
                                                        .createSequentialGroup()
                                                        .addComponent(jTextField73,
                                                                GroupLayout.PREFERRED_SIZE, 28,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(
                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jTextField74,
                                                                GroupLayout.PREFERRED_SIZE, 28,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(
                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jTextField75,
                                                                GroupLayout.PREFERRED_SIZE, 28,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jTextField76,
                                                                GroupLayout.PREFERRED_SIZE, 28,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(
                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jTextField77,
                                                                GroupLayout.PREFERRED_SIZE, 28,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(
                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jTextField78,
                                                                GroupLayout.PREFERRED_SIZE, 28,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jTextField79,
                                                                GroupLayout.PREFERRED_SIZE, 28,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(
                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jTextField80,
                                                                GroupLayout.PREFERRED_SIZE, 28,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(
                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jTextField81,
                                                                GroupLayout.PREFERRED_SIZE, 28,
                                                                GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jBoton1, GroupLayout.PREFERRED_SIZE, 154,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jBoton2, GroupLayout.PREFERRED_SIZE, 154,
                                                        GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jBoton3, GroupLayout.PREFERRED_SIZE, 154,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jBoton4, GroupLayout.PREFERRED_SIZE, 154,
                                                        GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addContainerGap()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 28,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 28,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, 28,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, 28,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField5, GroupLayout.PREFERRED_SIZE, 28,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField6, GroupLayout.PREFERRED_SIZE, 28,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField7, GroupLayout.PREFERRED_SIZE, 28,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField8, GroupLayout.PREFERRED_SIZE, 28,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField9, GroupLayout.PREFERRED_SIZE, 28,
                                        GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField10, GroupLayout.PREFERRED_SIZE, 28,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField11, GroupLayout.PREFERRED_SIZE, 28,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField12, GroupLayout.PREFERRED_SIZE, 28,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField13, GroupLayout.PREFERRED_SIZE, 28,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField14, GroupLayout.PREFERRED_SIZE, 28,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField15, GroupLayout.PREFERRED_SIZE, 28,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField16, GroupLayout.PREFERRED_SIZE, 28,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField17, GroupLayout.PREFERRED_SIZE, 28,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField18, GroupLayout.PREFERRED_SIZE, 28,
                                        GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField19, GroupLayout.PREFERRED_SIZE, 28,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField20, GroupLayout.PREFERRED_SIZE, 28,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField21, GroupLayout.PREFERRED_SIZE, 28,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField22, GroupLayout.PREFERRED_SIZE, 28,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField23, GroupLayout.PREFERRED_SIZE, 28,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField24, GroupLayout.PREFERRED_SIZE, 28,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField25, GroupLayout.PREFERRED_SIZE, 28,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField26, GroupLayout.PREFERRED_SIZE, 28,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField27, GroupLayout.PREFERRED_SIZE, 28,
                                        GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField28, GroupLayout.PREFERRED_SIZE, 28,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField29, GroupLayout.PREFERRED_SIZE, 28,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField30, GroupLayout.PREFERRED_SIZE, 28,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField31, GroupLayout.PREFERRED_SIZE, 28,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField32, GroupLayout.PREFERRED_SIZE, 28,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField33, GroupLayout.PREFERRED_SIZE, 28,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField34, GroupLayout.PREFERRED_SIZE, 28,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField35, GroupLayout.PREFERRED_SIZE, 28,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField36, GroupLayout.PREFERRED_SIZE, 28,
                                        GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField37, GroupLayout.PREFERRED_SIZE, 28,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField38, GroupLayout.PREFERRED_SIZE, 28,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField39, GroupLayout.PREFERRED_SIZE, 28,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField40, GroupLayout.PREFERRED_SIZE, 28,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField41, GroupLayout.PREFERRED_SIZE, 28,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField42, GroupLayout.PREFERRED_SIZE, 28,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField43, GroupLayout.PREFERRED_SIZE, 28,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField44, GroupLayout.PREFERRED_SIZE, 28,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField45, GroupLayout.PREFERRED_SIZE, 28,
                                        GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField46, GroupLayout.PREFERRED_SIZE, 28,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField47, GroupLayout.PREFERRED_SIZE, 28,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField48, GroupLayout.PREFERRED_SIZE, 28,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField49, GroupLayout.PREFERRED_SIZE, 28,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField50, GroupLayout.PREFERRED_SIZE, 28,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField51, GroupLayout.PREFERRED_SIZE, 28,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField52, GroupLayout.PREFERRED_SIZE, 28,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField53, GroupLayout.PREFERRED_SIZE, 28,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField54, GroupLayout.PREFERRED_SIZE, 28,
                                        GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField55, GroupLayout.PREFERRED_SIZE, 28,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField56, GroupLayout.PREFERRED_SIZE, 28,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField57, GroupLayout.PREFERRED_SIZE, 28,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField58, GroupLayout.PREFERRED_SIZE, 28,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField59, GroupLayout.PREFERRED_SIZE, 28,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField60, GroupLayout.PREFERRED_SIZE, 28,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField61, GroupLayout.PREFERRED_SIZE, 28,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField62, GroupLayout.PREFERRED_SIZE, 28,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField63, GroupLayout.PREFERRED_SIZE, 28,
                                        GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField64, GroupLayout.PREFERRED_SIZE, 28,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField65, GroupLayout.PREFERRED_SIZE, 28,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField66, GroupLayout.PREFERRED_SIZE, 28,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField67, GroupLayout.PREFERRED_SIZE, 28,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField68, GroupLayout.PREFERRED_SIZE, 28,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField69, GroupLayout.PREFERRED_SIZE, 28,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField70, GroupLayout.PREFERRED_SIZE, 28,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField71, GroupLayout.PREFERRED_SIZE, 28,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField72, GroupLayout.PREFERRED_SIZE, 28,
                                        GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField73, GroupLayout.PREFERRED_SIZE, 28,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField74, GroupLayout.PREFERRED_SIZE, 28,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField75, GroupLayout.PREFERRED_SIZE, 28,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField76, GroupLayout.PREFERRED_SIZE, 28,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField77, GroupLayout.PREFERRED_SIZE, 28,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField78, GroupLayout.PREFERRED_SIZE, 28,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField79, GroupLayout.PREFERRED_SIZE, 28,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField80, GroupLayout.PREFERRED_SIZE, 28,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField81, GroupLayout.PREFERRED_SIZE, 28,
                                        GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jBoton1, GroupLayout.PREFERRED_SIZE, 47,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(jBoton2, GroupLayout.PREFERRED_SIZE, 47,
                                        GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jBoton3, GroupLayout.PREFERRED_SIZE, 47,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(jBoton4, GroupLayout.PREFERRED_SIZE, 47,
                                        GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        pack();
    }// </editor-fold>

    // Resolver por recursividad
    private void jBoton1ActionPerformed(java.awt.event.ActionEvent evt) {
        resetearBackgroundCeldas();
        // Cargamos los datos
        int[][] datos = new int[9][9];
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                datos[x][y] = Integer.parseInt(String.valueOf(celdas[x][y].getText()));
            }
        }
        Recursivo.resolver(datos);
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                celdas[x][y].setText(datos[x][y] + "");
            }
        }
    }

    // Resolver por genetica
    private void jBoton2ActionPerformed(java.awt.event.ActionEvent evt) {
        resetearBackgroundCeldas();
        int[][] datosI = new int[9][9];
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                datosI[x][y] = Integer.parseInt(celdas[x][y].getText());
            }
        }

        Individuo solucion = Poblacion.resolverPorGenetica(datosI);

        solucion.printIndividuo();
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                celdas[x][y].setText(solucion.filas[x].filaGen[y] + "");
            }
        }

        System.out.println(solucion.getStringIndi());
    }

    // Generar un sudoku
    private void jBoton3ActionPerformed(java.awt.event.ActionEvent evt) {
        resetearBackgroundCeldas();
        int[][] meter = Recursivo.generarSudokuAleatorio();
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                celdas[x][y].setText(meter[x][y] + "");
            }
        }
    }

    // Corregir
    private void jBoton4ActionPerformed(java.awt.event.ActionEvent evt) {
        resetearBackgroundCeldas();
        // Cargamos el tablero
        int[][] datos = new int[9][9];
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                datos[x][y] = Integer.parseInt(celdas[x][y].getText());
            }
        }

        // Comprobamos todas las celdas a ver cuales estan mal
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                int temp = datos[x][y];
                datos[x][y] = 0;
                if (!Recursivo.posibleSitio(datos, temp, x, y)) {
                    celdas[x][y].setBackground(Color.red);
                }
                datos[x][y] = temp;
            }
        }
    }

    private void resetearBackgroundCeldas() {
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                celdas[x][y].setBackground(new Color(216, 182, 88));
            }
        }
    }

    // Variables declaration - do not modify
    private JButton jBoton1;
    private JButton jBoton2;
    private JButton jBoton3;
    private JButton jBoton4;
    private JTextField jTextField1;
    private JTextField jTextField10;
    private JTextField jTextField11;
    private JTextField jTextField12;
    private JTextField jTextField13;
    private JTextField jTextField14;
    private JTextField jTextField15;
    private JTextField jTextField16;
    private JTextField jTextField17;
    private JTextField jTextField18;
    private JTextField jTextField19;
    private JTextField jTextField2;
    private JTextField jTextField20;
    private JTextField jTextField21;
    private JTextField jTextField22;
    private JTextField jTextField23;
    private JTextField jTextField24;
    private JTextField jTextField25;
    private JTextField jTextField26;
    private JTextField jTextField27;
    private JTextField jTextField28;
    private JTextField jTextField29;
    private JTextField jTextField3;
    private JTextField jTextField30;
    private JTextField jTextField31;
    private JTextField jTextField32;
    private JTextField jTextField33;
    private JTextField jTextField34;
    private JTextField jTextField35;
    private JTextField jTextField36;
    private JTextField jTextField37;
    private JTextField jTextField38;
    private JTextField jTextField39;
    private JTextField jTextField4;
    private JTextField jTextField40;
    private JTextField jTextField41;
    private JTextField jTextField42;
    private JTextField jTextField43;
    private JTextField jTextField44;
    private JTextField jTextField45;
    private JTextField jTextField46;
    private JTextField jTextField47;
    private JTextField jTextField48;
    private JTextField jTextField49;
    private JTextField jTextField5;
    private JTextField jTextField50;
    private JTextField jTextField51;
    private JTextField jTextField52;
    private JTextField jTextField53;
    private JTextField jTextField54;
    private JTextField jTextField55;
    private JTextField jTextField56;
    private JTextField jTextField57;
    private JTextField jTextField58;
    private JTextField jTextField59;
    private JTextField jTextField6;
    private JTextField jTextField60;
    private JTextField jTextField61;
    private JTextField jTextField62;
    private JTextField jTextField63;
    private JTextField jTextField64;
    private JTextField jTextField65;
    private JTextField jTextField66;
    private JTextField jTextField67;
    private JTextField jTextField68;
    private JTextField jTextField69;
    private JTextField jTextField7;
    private JTextField jTextField70;
    private JTextField jTextField71;
    private JTextField jTextField72;
    private JTextField jTextField73;
    private JTextField jTextField74;
    private JTextField jTextField75;
    private JTextField jTextField76;
    private JTextField jTextField77;
    private JTextField jTextField78;
    private JTextField jTextField79;
    private JTextField jTextField8;
    private JTextField jTextField80;
    private JTextField jTextField81;
    private JTextField jTextField9;
    // End of variables declaration
}
