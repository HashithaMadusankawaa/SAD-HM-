/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;

/**
 *
 * @author ABC
 */
public class Dashboard extends javax.swing.JFrame {

    CardLayout CardLayout;
    public Dashboard() {
        initComponents();
        loadsvgicon();
        panelRound2.setBackground(Color.decode("#3EAC91"));
         
         CardLayout = (CardLayout) (panelRound10.getLayout());
    }
    
    private void loadsvgicon(){
       sVGIcon1.setsvgIcon("icon/dashboard.svg", 24, 24);
        sVGIcon2.setsvgIcon("icon/concierge.svg", 24, 24);
        sVGIcon3.setsvgIcon("icon/account_balance.svg", 24, 24);
        sVGIcon4.setsvgIcon("icon/bedroom.svg", 24, 24);
        sVGIcon5.setsvgIcon("icon/remote.svg", 24, 24);
        sVGIcon6.setsvgIcon("icon/vacuum.svg", 24, 24);
        sVGIcon7.setsvgIcon("icon/local_taxi.svg", 24, 24);
        sVGIcon8.setsvgIcon("icon/category.svg", 24, 24);
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelRound1 = new test.PanelRound();
        panelRound2 = new test.PanelRound();
        sVGIcon1 = new svg.SVGIcon();
        panelRound15 = new test.PanelRound();
        sVGIcon2 = new svg.SVGIcon();
        panelRound16 = new test.PanelRound();
        sVGIcon3 = new svg.SVGIcon();
        panelRound17 = new test.PanelRound();
        sVGIcon4 = new svg.SVGIcon();
        panelRound18 = new test.PanelRound();
        sVGIcon5 = new svg.SVGIcon();
        panelRound19 = new test.PanelRound();
        sVGIcon6 = new svg.SVGIcon();
        panelRound20 = new test.PanelRound();
        sVGIcon7 = new svg.SVGIcon();
        panelRound21 = new test.PanelRound();
        sVGIcon8 = new svg.SVGIcon();
        panelRound10 = new test.PanelRound();
        panelRound7 = new test.PanelRound();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        panelRound8 = new test.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        panelRound9 = new test.PanelRound();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        panelRound11 = new test.PanelRound();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        panelRound22 = new test.PanelRound();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        panelRound6 = new test.PanelRound();
        panelRound5 = new test.PanelRound();
        panelRound4 = new test.PanelRound();
        panelRound3 = new test.PanelRound();
        panelRound14 = new test.PanelRound();
        panelRound13 = new test.PanelRound();
        panelRound12 = new test.PanelRound();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dashboard");

        panelRound1.setBackground(new java.awt.Color(32, 48, 47));
        panelRound1.setRoundBottomLeft(20);
        panelRound1.setRoundBottomRight(20);
        panelRound1.setRoundTopLeft(20);
        panelRound1.setRoundTopRight(20);

        panelRound2.setBackground(new java.awt.Color(255, 0, 0));
        panelRound2.setToolTipText("Dashboard");
        panelRound2.setRoundBottomLeft(15);
        panelRound2.setRoundBottomRight(15);
        panelRound2.setRoundTopLeft(15);
        panelRound2.setRoundTopRight(15);
        panelRound2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelRound2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelRound2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelRound2MouseExited(evt);
            }
        });

        sVGIcon1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sVGIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sVGIcon1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelRound15.setBackground(new java.awt.Color(255, 0, 0));
        panelRound15.setRoundBottomLeft(15);
        panelRound15.setRoundBottomRight(15);
        panelRound15.setRoundTopLeft(15);
        panelRound15.setRoundTopRight(15);
        panelRound15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelRound15MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelRound15MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelRound15MouseExited(evt);
            }
        });

        sVGIcon2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelRound15Layout = new javax.swing.GroupLayout(panelRound15);
        panelRound15.setLayout(panelRound15Layout);
        panelRound15Layout.setHorizontalGroup(
            panelRound15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sVGIcon2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound15Layout.setVerticalGroup(
            panelRound15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sVGIcon2, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelRound16.setBackground(new java.awt.Color(255, 0, 0));
        panelRound16.setRoundBottomLeft(15);
        panelRound16.setRoundBottomRight(15);
        panelRound16.setRoundTopLeft(15);
        panelRound16.setRoundTopRight(15);
        panelRound16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelRound16MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelRound16MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelRound16MouseExited(evt);
            }
        });

        sVGIcon3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sVGIcon3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sVGIcon3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sVGIcon3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sVGIcon3MouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelRound16Layout = new javax.swing.GroupLayout(panelRound16);
        panelRound16.setLayout(panelRound16Layout);
        panelRound16Layout.setHorizontalGroup(
            panelRound16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sVGIcon3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound16Layout.setVerticalGroup(
            panelRound16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sVGIcon3, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelRound17.setBackground(new java.awt.Color(255, 0, 0));
        panelRound17.setRoundBottomLeft(15);
        panelRound17.setRoundBottomRight(15);
        panelRound17.setRoundTopLeft(15);
        panelRound17.setRoundTopRight(15);
        panelRound17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelRound17MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelRound17MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelRound17MouseExited(evt);
            }
        });

        sVGIcon4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sVGIcon4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sVGIcon4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sVGIcon4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sVGIcon4MouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelRound17Layout = new javax.swing.GroupLayout(panelRound17);
        panelRound17.setLayout(panelRound17Layout);
        panelRound17Layout.setHorizontalGroup(
            panelRound17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sVGIcon4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound17Layout.setVerticalGroup(
            panelRound17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sVGIcon4, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelRound18.setBackground(new java.awt.Color(255, 0, 0));
        panelRound18.setRoundBottomLeft(15);
        panelRound18.setRoundBottomRight(15);
        panelRound18.setRoundTopLeft(15);
        panelRound18.setRoundTopRight(15);
        panelRound18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelRound18MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelRound18MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelRound18MouseExited(evt);
            }
        });

        sVGIcon5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sVGIcon5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sVGIcon5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sVGIcon5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sVGIcon5MouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelRound18Layout = new javax.swing.GroupLayout(panelRound18);
        panelRound18.setLayout(panelRound18Layout);
        panelRound18Layout.setHorizontalGroup(
            panelRound18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sVGIcon5, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound18Layout.setVerticalGroup(
            panelRound18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sVGIcon5, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelRound19.setBackground(new java.awt.Color(255, 0, 0));
        panelRound19.setRoundBottomLeft(15);
        panelRound19.setRoundBottomRight(15);
        panelRound19.setRoundTopLeft(15);
        panelRound19.setRoundTopRight(15);
        panelRound19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelRound19MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelRound19MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelRound19MouseExited(evt);
            }
        });

        sVGIcon6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sVGIcon6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sVGIcon6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sVGIcon6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sVGIcon6MouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelRound19Layout = new javax.swing.GroupLayout(panelRound19);
        panelRound19.setLayout(panelRound19Layout);
        panelRound19Layout.setHorizontalGroup(
            panelRound19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sVGIcon6, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound19Layout.setVerticalGroup(
            panelRound19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sVGIcon6, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelRound20.setBackground(new java.awt.Color(255, 0, 0));
        panelRound20.setRoundBottomLeft(15);
        panelRound20.setRoundBottomRight(15);
        panelRound20.setRoundTopLeft(15);
        panelRound20.setRoundTopRight(15);
        panelRound20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelRound20MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelRound20MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelRound20MouseExited(evt);
            }
        });

        sVGIcon7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sVGIcon7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sVGIcon7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sVGIcon7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sVGIcon7MouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelRound20Layout = new javax.swing.GroupLayout(panelRound20);
        panelRound20.setLayout(panelRound20Layout);
        panelRound20Layout.setHorizontalGroup(
            panelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sVGIcon7, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound20Layout.setVerticalGroup(
            panelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sVGIcon7, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelRound21.setBackground(new java.awt.Color(255, 0, 0));
        panelRound21.setRoundBottomLeft(15);
        panelRound21.setRoundBottomRight(15);
        panelRound21.setRoundTopLeft(15);
        panelRound21.setRoundTopRight(15);
        panelRound21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelRound21MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelRound21MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelRound21MouseExited(evt);
            }
        });

        sVGIcon8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sVGIcon8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sVGIcon8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sVGIcon8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sVGIcon8MouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelRound21Layout = new javax.swing.GroupLayout(panelRound21);
        panelRound21.setLayout(panelRound21Layout);
        panelRound21Layout.setHorizontalGroup(
            panelRound21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sVGIcon8, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound21Layout.setVerticalGroup(
            panelRound21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sVGIcon8, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelRound15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelRound16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelRound17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelRound18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelRound19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelRound20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelRound21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRound15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRound16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRound17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRound18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRound19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRound20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRound21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelRound10.setBackground(new java.awt.Color(255, 102, 102));
        panelRound10.setLayout(new java.awt.CardLayout());

        panelRound7.setBackground(new java.awt.Color(21, 21, 21));

        jScrollPane1.setBackground(new java.awt.Color(21, 21, 21));
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jPanel2.setBackground(new java.awt.Color(21, 21, 21));

        panelRound8.setRoundBottomLeft(15);
        panelRound8.setRoundBottomRight(15);
        panelRound8.setRoundTopLeft(15);
        panelRound8.setRoundTopRight(15);

        jLabel1.setText("Today Booking");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("1,587");

        jLabel9.setText("From previous period");

        javax.swing.GroupLayout panelRound8Layout = new javax.swing.GroupLayout(panelRound8);
        panelRound8.setLayout(panelRound8Layout);
        panelRound8Layout.setHorizontalGroup(
            panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        panelRound8Layout.setVerticalGroup(
            panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelRound9.setRoundBottomLeft(15);
        panelRound9.setRoundBottomRight(15);
        panelRound9.setRoundTopLeft(15);
        panelRound9.setRoundTopRight(15);

        jLabel2.setText("Total Amount");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("$2,258");

        jLabel10.setText(" New income");

        javax.swing.GroupLayout panelRound9Layout = new javax.swing.GroupLayout(panelRound9);
        panelRound9.setLayout(panelRound9Layout);
        panelRound9Layout.setHorizontalGroup(
            panelRound9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        panelRound9Layout.setVerticalGroup(
            panelRound9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelRound11.setRoundBottomLeft(15);
        panelRound11.setRoundBottomRight(15);
        panelRound11.setRoundTopLeft(15);
        panelRound11.setRoundTopRight(15);

        jLabel3.setText("Total Customer");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("2.3k");

        jLabel11.setText("From previous period");

        javax.swing.GroupLayout panelRound11Layout = new javax.swing.GroupLayout(panelRound11);
        panelRound11.setLayout(panelRound11Layout);
        panelRound11Layout.setHorizontalGroup(
            panelRound11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        panelRound11Layout.setVerticalGroup(
            panelRound11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelRound22.setRoundBottomLeft(15);
        panelRound22.setRoundBottomRight(15);
        panelRound22.setRoundTopLeft(15);
        panelRound22.setRoundTopRight(15);

        jLabel4.setText("Total Revenue");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("11,5587");

        jLabel12.setText("From previous period");

        javax.swing.GroupLayout panelRound22Layout = new javax.swing.GroupLayout(panelRound22);
        panelRound22.setLayout(panelRound22Layout);
        panelRound22Layout.setHorizontalGroup(
            panelRound22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        panelRound22Layout.setVerticalGroup(
            panelRound22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(panelRound8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelRound9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelRound11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelRound22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelRound22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRound11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRound9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRound8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(915, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel2);

        javax.swing.GroupLayout panelRound7Layout = new javax.swing.GroupLayout(panelRound7);
        panelRound7.setLayout(panelRound7Layout);
        panelRound7Layout.setHorizontalGroup(
            panelRound7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        panelRound7Layout.setVerticalGroup(
            panelRound7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 668, Short.MAX_VALUE)
        );

        panelRound10.add(panelRound7, "card9");

        panelRound6.setBackground(new java.awt.Color(255, 0, 153));

        javax.swing.GroupLayout panelRound6Layout = new javax.swing.GroupLayout(panelRound6);
        panelRound6.setLayout(panelRound6Layout);
        panelRound6Layout.setHorizontalGroup(
            panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 880, Short.MAX_VALUE)
        );
        panelRound6Layout.setVerticalGroup(
            panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 668, Short.MAX_VALUE)
        );

        panelRound10.add(panelRound6, "card8");

        panelRound5.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout panelRound5Layout = new javax.swing.GroupLayout(panelRound5);
        panelRound5.setLayout(panelRound5Layout);
        panelRound5Layout.setHorizontalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 880, Short.MAX_VALUE)
        );
        panelRound5Layout.setVerticalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 668, Short.MAX_VALUE)
        );

        panelRound10.add(panelRound5, "card7");

        panelRound4.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout panelRound4Layout = new javax.swing.GroupLayout(panelRound4);
        panelRound4.setLayout(panelRound4Layout);
        panelRound4Layout.setHorizontalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 880, Short.MAX_VALUE)
        );
        panelRound4Layout.setVerticalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 668, Short.MAX_VALUE)
        );

        panelRound10.add(panelRound4, "card6");

        panelRound3.setBackground(new java.awt.Color(51, 204, 0));

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 880, Short.MAX_VALUE)
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 668, Short.MAX_VALUE)
        );

        panelRound10.add(panelRound3, "card5");

        panelRound14.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout panelRound14Layout = new javax.swing.GroupLayout(panelRound14);
        panelRound14.setLayout(panelRound14Layout);
        panelRound14Layout.setHorizontalGroup(
            panelRound14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 880, Short.MAX_VALUE)
        );
        panelRound14Layout.setVerticalGroup(
            panelRound14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 668, Short.MAX_VALUE)
        );

        panelRound10.add(panelRound14, "card2");

        panelRound13.setBackground(new java.awt.Color(102, 102, 255));

        javax.swing.GroupLayout panelRound13Layout = new javax.swing.GroupLayout(panelRound13);
        panelRound13.setLayout(panelRound13Layout);
        panelRound13Layout.setHorizontalGroup(
            panelRound13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 880, Short.MAX_VALUE)
        );
        panelRound13Layout.setVerticalGroup(
            panelRound13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 668, Short.MAX_VALUE)
        );

        panelRound10.add(panelRound13, "card4");

        panelRound12.setBackground(new java.awt.Color(204, 255, 102));

        javax.swing.GroupLayout panelRound12Layout = new javax.swing.GroupLayout(panelRound12);
        panelRound12.setLayout(panelRound12Layout);
        panelRound12Layout.setHorizontalGroup(
            panelRound12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 880, Short.MAX_VALUE)
        );
        panelRound12Layout.setVerticalGroup(
            panelRound12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 668, Short.MAX_VALUE)
        );

        panelRound10.add(panelRound12, "card3");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRound10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRound10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void panelRound2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound2MouseEntered
        panelRound2.setBackground(Color.decode("#3EAC91"));
panelRound2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
    }//GEN-LAST:event_panelRound2MouseEntered

    private void panelRound2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound2MouseExited
        panelRound2.setBackground(new Color(32, 48, 47));
         
    }//GEN-LAST:event_panelRound2MouseExited

    private void panelRound15MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound15MouseEntered
       panelRound15.setBackground(Color.decode("#3EAC91"));
       panelRound15.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_panelRound15MouseEntered

    private void panelRound15MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound15MouseExited
        panelRound15.setBackground(new Color(32, 48, 47));
    }//GEN-LAST:event_panelRound15MouseExited

    private void panelRound16MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound16MouseEntered
      panelRound16.setBackground(Color.decode("#3EAC91"));
       panelRound6.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_panelRound16MouseEntered

    private void panelRound16MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound16MouseExited
        panelRound16.setBackground(new Color(32, 48, 47));
    }//GEN-LAST:event_panelRound16MouseExited

    private void panelRound2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound2MouseClicked
        CardLayout.show(panelRound10, "card9");
    }//GEN-LAST:event_panelRound2MouseClicked

    private void panelRound15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound15MouseClicked
        CardLayout.show(panelRound10, "card3");
    }//GEN-LAST:event_panelRound15MouseClicked

    private void sVGIcon3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sVGIcon3MouseClicked
       CardLayout.show(panelRound10, "card8");
    }//GEN-LAST:event_sVGIcon3MouseClicked

    private void panelRound16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound16MouseClicked
        CardLayout.show(panelRound10, "card8");
    }//GEN-LAST:event_panelRound16MouseClicked

    private void sVGIcon3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sVGIcon3MouseEntered
        panelRound16.setBackground(Color.decode("#3EAC91"));
       panelRound16.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_sVGIcon3MouseEntered

    private void sVGIcon3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sVGIcon3MouseExited
       panelRound16.setBackground(new Color(32, 48, 47));
    }//GEN-LAST:event_sVGIcon3MouseExited

    private void panelRound17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound17MouseClicked
        CardLayout.show(panelRound10, "card7");
    }//GEN-LAST:event_panelRound17MouseClicked

    private void panelRound17MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound17MouseEntered
         panelRound17.setBackground(Color.decode("#3EAC91"));
       panelRound17.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_panelRound17MouseEntered

    private void sVGIcon4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sVGIcon4MouseClicked
         CardLayout.show(panelRound10, "card7");
    }//GEN-LAST:event_sVGIcon4MouseClicked

    private void sVGIcon4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sVGIcon4MouseEntered
         panelRound17.setBackground(Color.decode("#3EAC91"));
       panelRound17.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_sVGIcon4MouseEntered

    private void sVGIcon4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sVGIcon4MouseExited
     panelRound17.setBackground(new Color(32, 48, 47));
    }//GEN-LAST:event_sVGIcon4MouseExited

    private void panelRound17MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound17MouseExited
        panelRound17.setBackground(new Color(32, 48, 47));
    }//GEN-LAST:event_panelRound17MouseExited

    private void panelRound18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound18MouseClicked
        CardLayout.show(panelRound10, "card6");
    }//GEN-LAST:event_panelRound18MouseClicked

    private void panelRound18MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound18MouseEntered
       panelRound18.setBackground(Color.decode("#3EAC91"));
       panelRound18.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_panelRound18MouseEntered

    private void panelRound18MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound18MouseExited
        panelRound18.setBackground(new Color(32, 48, 47));
    }//GEN-LAST:event_panelRound18MouseExited

    private void sVGIcon5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sVGIcon5MouseClicked
       CardLayout.show(panelRound10, "card6");
    }//GEN-LAST:event_sVGIcon5MouseClicked

    private void sVGIcon5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sVGIcon5MouseEntered
       panelRound18.setBackground(Color.decode("#3EAC91"));
       panelRound18.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_sVGIcon5MouseEntered

    private void sVGIcon5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sVGIcon5MouseExited
        panelRound18.setBackground(new Color(32, 48, 47));
    }//GEN-LAST:event_sVGIcon5MouseExited

    private void panelRound19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound19MouseClicked
         CardLayout.show(panelRound10, "card5");
    }//GEN-LAST:event_panelRound19MouseClicked

    private void panelRound19MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound19MouseEntered
        panelRound19.setBackground(Color.decode("#3EAC91"));
       panelRound19.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_panelRound19MouseEntered

    private void panelRound19MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound19MouseExited
        panelRound19.setBackground(new Color(32, 48, 47));
    }//GEN-LAST:event_panelRound19MouseExited

    private void sVGIcon6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sVGIcon6MouseClicked
         CardLayout.show(panelRound10, "card5");
    }//GEN-LAST:event_sVGIcon6MouseClicked

    private void sVGIcon6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sVGIcon6MouseEntered
        panelRound19.setBackground(Color.decode("#3EAC91"));
       panelRound19.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_sVGIcon6MouseEntered

    private void sVGIcon6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sVGIcon6MouseExited
        panelRound19.setBackground(new Color(32, 48, 47));
    }//GEN-LAST:event_sVGIcon6MouseExited

    private void sVGIcon7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sVGIcon7MouseClicked
        CardLayout.show(panelRound10, "card2");
    }//GEN-LAST:event_sVGIcon7MouseClicked

    private void panelRound20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound20MouseClicked
       CardLayout.show(panelRound10, "card2");
    }//GEN-LAST:event_panelRound20MouseClicked

    private void panelRound20MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound20MouseEntered
       panelRound20.setBackground(Color.decode("#3EAC91"));
       panelRound20.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_panelRound20MouseEntered

    private void panelRound20MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound20MouseExited
         panelRound20.setBackground(new Color(32, 48, 47));
    }//GEN-LAST:event_panelRound20MouseExited

    private void sVGIcon7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sVGIcon7MouseEntered
         panelRound20.setBackground(Color.decode("#3EAC91"));
       panelRound20.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_sVGIcon7MouseEntered

    private void sVGIcon7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sVGIcon7MouseExited
         panelRound20.setBackground(new Color(32, 48, 47));
    }//GEN-LAST:event_sVGIcon7MouseExited

    private void panelRound21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound21MouseClicked
       CardLayout.show(panelRound10, "card4");
    }//GEN-LAST:event_panelRound21MouseClicked

    private void panelRound21MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound21MouseEntered
         panelRound21.setBackground(Color.decode("#3EAC91"));
       panelRound21.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_panelRound21MouseEntered

    private void panelRound21MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound21MouseExited
        panelRound21.setBackground(new Color(32, 48, 47));
    }//GEN-LAST:event_panelRound21MouseExited

    private void sVGIcon8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sVGIcon8MouseClicked
         CardLayout.show(panelRound10, "card4");
    }//GEN-LAST:event_sVGIcon8MouseClicked

    private void sVGIcon8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sVGIcon8MouseEntered
        panelRound21.setBackground(Color.decode("#3EAC91"));
       panelRound21.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_sVGIcon8MouseEntered

    private void sVGIcon8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sVGIcon8MouseExited
        panelRound21.setBackground(new Color(32, 48, 47));
    }//GEN-LAST:event_sVGIcon8MouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        FlatMacDarkLaf.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private test.PanelRound panelRound1;
    private test.PanelRound panelRound10;
    private test.PanelRound panelRound11;
    private test.PanelRound panelRound12;
    private test.PanelRound panelRound13;
    private test.PanelRound panelRound14;
    private test.PanelRound panelRound15;
    private test.PanelRound panelRound16;
    private test.PanelRound panelRound17;
    private test.PanelRound panelRound18;
    private test.PanelRound panelRound19;
    private test.PanelRound panelRound2;
    private test.PanelRound panelRound20;
    private test.PanelRound panelRound21;
    private test.PanelRound panelRound22;
    private test.PanelRound panelRound3;
    private test.PanelRound panelRound4;
    private test.PanelRound panelRound5;
    private test.PanelRound panelRound6;
    private test.PanelRound panelRound7;
    private test.PanelRound panelRound8;
    private test.PanelRound panelRound9;
    private svg.SVGIcon sVGIcon1;
    private svg.SVGIcon sVGIcon2;
    private svg.SVGIcon sVGIcon3;
    private svg.SVGIcon sVGIcon4;
    private svg.SVGIcon sVGIcon5;
    private svg.SVGIcon sVGIcon6;
    private svg.SVGIcon sVGIcon7;
    private svg.SVGIcon sVGIcon8;
    // End of variables declaration//GEN-END:variables
}
