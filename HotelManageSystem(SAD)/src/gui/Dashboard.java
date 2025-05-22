package gui;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.intellijthemes.FlatDarkFlatIJTheme;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.raven.chart.ModelChart;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import model.Mysql2;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartMouseEvent;
import org.jfree.chart.ChartMouseListener;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.entity.CategoryItemEntity;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author ABC
 */
public class Dashboard extends javax.swing.JFrame {

    CardLayout CardLayout;
    private String currentUserEmail;

    public Dashboard() {
        initComponents();
        loadsvgicon();
        loadchart2();
        LoardTotalBppking();
        LoardTotalAmount();
        LoadRoomAllEmployeeDetails();
        LoardToatalrevenue();
        LoardgUESTcOUNT();
         LoadRoomBookingDetails1();
        LoadRoomBookingDetails();
        LoadRoomFacilitiesDetails();
        LoadRHouseKeepingDetails();
        LoadTransactionDetails();
        LoadBookingDetails();
        LoadCabBookingDetails();
        LoadHousekeepingData();
        LoardToatalTransacione();
        panelRound2.setBackground(Color.decode("#3EAC91"));

        CardLayout = (CardLayout) (panelRound10.getLayout());

    }

    Dashboard(String email, boolean b) {
        this.currentUserEmail = email;
        System.out.println(currentUserEmail);
        initComponents();
        loadsvgicon();
        loadchart2();
        LoadRoomAllEmployeeDetails();
        LoardgUESTcOUNT();
        LoardTotalBppking();
        LoardToatalTransacione();
        LoardToatalrevenue();
         LoadRoomBookingDetails1();
        LoardTotalAmount();
        LoadRoomBookingDetails();
        LoadRoomFacilitiesDetails();
        LoadRHouseKeepingDetails();
        LoadTransactionDetails();
        LoadBookingDetails();
        LoadCabBookingDetails();
        LoadHousekeepingData();
        panelRound2.setBackground(Color.decode("#3EAC91"));

        CardLayout = (CardLayout) (panelRound10.getLayout());

        if (email.equals("j@gmail.com")) {

        } else if (email.equals("hash@gmail.com")) {
            panelRound21.setVisible(false);
        } else if (b) {

        }

    }
    
      private void LoadRoomAllEmployeeDetails() {
        try {
            ResultSet resultSet = Mysql2.msearch("SELECT * FROM employee INNER JOIN gender ON employee.gender_id=gender.id INNER JOIN department ON employee.department_id=department.id INNER JOIN designation ON employee.designation_id = designation.id");

            DefaultTableModel model = (DefaultTableModel) jTable7.getModel();
            model.setRowCount(0);

            while (resultSet.next()) {
                Vector<String> vector = new Vector<>();
                vector.add(resultSet.getString("emp_id"));
                vector.add(resultSet.getString("fname"));
                vector.add(resultSet.getString("lname"));
                vector.add(resultSet.getString("join_date"));
                vector.add(resultSet.getString("email"));
                vector.add(resultSet.getString("password"));
                vector.add(resultSet.getString("mobile"));
                vector.add(resultSet.getString("gender_name"));
                vector.add(resultSet.getString("birth_day"));
                vector.add(resultSet.getString("nic"));
                vector.add(resultSet.getString("department_name"));
                vector.add(resultSet.getString("designation_name"));

                model.addRow(vector);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void startCounterAnimation() {

        try {
            ResultSet resultSet = Mysql2.msearch("SELECT COUNT(id) AS total FROM employee");

            if (resultSet.next()) {
                int x1 = resultSet.getInt("total");
                String t1 = String.valueOf(x1);

                String t2 = jLabel64.getText();
                String t3 = jLabel65.getText();
                String t4 = jLabel66.getText();

                int target1 = Integer.parseInt(t1);
                int target2 = Integer.parseInt(t2);
                int target3 = Integer.parseInt(t3);
                int target4 = Integer.parseInt(t4);

                final int[] count1 = {0};
                final int[] count2 = {0};
                final int[] count3 = {0};
                final int[] count4 = {0};

                Timer timer = new Timer(50, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        boolean allCompleted = true;

                        if (count1[0] < target1) {
                            count1[0]++;
                            jLabel63.setText(String.valueOf(count1[0]));
                            allCompleted = false;
                        }

                        if (count2[0] < target2) {
                            count2[0]++;
                            jLabel64.setText(String.valueOf(count2[0]));
                            allCompleted = false;
                        }

                        // Update jLabel65
                        if (count3[0] < target3) {
                            count3[0]++;
                            jLabel65.setText(String.valueOf(count3[0]));
                            allCompleted = false;
                        }

                        // Update jLabel66
                        if (count4[0] < target4) {
                            count4[0]++;
                            jLabel66.setText(String.valueOf(count4[0]));
                            allCompleted = false;
                        }

                        // Stop the timer when all labels have reached their targets
                        if (allCompleted) {
                            ((Timer) e.getSource()).stop();
                        }
                    }
                });

                timer.start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void loadchart2() {
        try {
            // Execute SQL query and retrieve result set
            ResultSet resultSet = Mysql2.msearch("SELECT \n"
                    + "    DATE_FORMAT(check_in, '%M') AS month_name,  \n"
                    + "    COUNT(reference_no) AS total_reservations\n"
                    + "FROM \n"
                    + "    reservation_details\n"
                    + "GROUP BY \n"
                    + "    DATE_FORMAT(check_in, '%M'), MONTH(check_in);");

            // Prepare a map to store total reservations for each month
            Map<String, Integer> reservationData = new HashMap<>();
            List<String> months = Arrays.asList("January", "February", "March", "April", "May", "June",
                    "July", "August", "September", "October", "November", "December");

            // Initialize map with all months and 0 values
            for (String month : months) {
                reservationData.put(month, 0);
            }

            // Process the result set and populate the reservation data map
            while (resultSet.next()) {
                String monthName = resultSet.getString("month_name");
                int totalReservations = resultSet.getInt("total_reservations");

                // Update reservation count for the specific month
                reservationData.put(monthName, totalReservations);
            }

            // Add legends to chart
            chart1.addLegend("Booking", new Color(219, 253, 130));

            // Add data to chart for each month dynamically
            for (String month : months) {
                int bookings = reservationData.get(month); // Get booking count for the month
                chart1.addData(new ModelChart(month, new double[]{bookings}));
            }

        } catch (Exception e) {
            System.err.println("SQL error while loading chart data: " + e.getMessage());
        }

        // Set the chart background color
        getContentPane().setBackground(new Color(250, 250, 250));
    }

    private void loadsvgicon() {
        sVGIcon1.setsvgIcon("icon/dashboard.svg", 24, 24);
        sVGIcon2.setsvgIcon("icon/concierge.svg", 24, 24);
        sVGIcon3.setsvgIcon("icon/account_balance.svg", 24, 24);
        sVGIcon4.setsvgIcon("icon/bedroom.svg", 24, 24);
        sVGIcon5.setsvgIcon("icon/remote.svg", 24, 24);
        sVGIcon6.setsvgIcon("icon/cleaning_services_24dp.svg", 24, 24);
        sVGIcon7.setsvgIcon("icon/local_taxi.svg", 24, 24);
        sVGIcon8.setsvgIcon("icon/dashboard_customize_24dp.svg", 24, 24);
        sVGIcon9.setsvgIcon("icon/chevron_right.svg", 24, 24);
        sVGIcon10.setsvgIcon("icon/chevron_right.svg", 24, 24);
        sVGIcon11.setsvgIcon("icon/chevron_right.svg", 24, 24);
        sVGIcon12.setsvgIcon("icon/chevron_right.svg", 24, 24);
        sVGIcon18.setsvgIcon("icon/chevron_right.svg", 24, 24);
        sVGIcon20.setsvgIcon("icon/chevron_right.svg", 24, 24);
        sVGIcon22.setsvgIcon("icon/chevron_right.svg", 24, 24);
        sVGIcon24.setsvgIcon("icon/chevron_right.svg", 24, 24);
        sVGIcon32.setsvgIcon("icon/chevron_right.svg", 24, 24);
        sVGIcon26.setsvgIcon("icon/chevron_right.svg", 24, 24);
        sVGIcon27.setsvgIcon("icon/attach_money_24dp_FFFFFF_FILL0_wght400_GRAD0_opsz24.svg", 24, 24);
        sVGIcon14.setsvgIcon("icon/subject.svg", 34, 34);
        sVGIcon15.setsvgIcon("icon/detector_status.svg", 34, 34);
        sVGIcon16.setsvgIcon("icon/image_24dp_000000_FILL0_wght400_GRAD0_opsz24.svg", 34, 34);
        sVGIcon17.setsvgIcon("icon/tv_24dp_000000_FILL0_wght400_GRAD0_opsz24.svg", 34, 34);
        sVGIcon19.setsvgIcon("icon/directions_car_24dp_000000_FILL0_wght400_GRAD0_opsz24.svg", 34, 34);
        sVGIcon21.setsvgIcon("icon/no_crash_24dp_000000_FILL0_wght400_GRAD0_opsz24.svg", 34, 34);
        sVGIcon13.setsvgIcon("icon/king_bed_24dp_000000_FILL0_wght400_GRAD0_opsz24.svg", 34, 34);
        sVGIcon25.setsvgIcon("icon/radio_button_unchecked_24dp_000000_FILL0_wght400_GRAD0_opsz24.svg", 34, 34);
        sVGIcon31.setsvgIcon("icon/mop_24dp_000000_FILL0_wght400_GRAD0_opsz24.svg", 34, 34);
        sVGIcon23.setsvgIcon("icon/place_item_24dp_000000_FILL0_wght400_GRAD0_opsz24.svg", 34, 34);
        sVGIcon28.setsvgIcon("icon/apartment_24dp_FFFFFF_FILL0_wght400_GRAD0_opsz24.svg", 34, 34);
        sVGIcon29.setsvgIcon("icon/groups_24dp_FFFFFF_FILL0_wght400_GRAD0_opsz24.svg", 34, 34);
        sVGIcon30.setsvgIcon("icon/move_item_24dp_FFFFFF_FILL0_wght400_GRAD0_opsz24.svg", 34, 34);
        sVGIcon33.setsvgIcon("icon/event_24dp_FFFFFF_FILL0_wght400_GRAD0_opsz24.svg", 34, 34);
        sVGIcon34.setsvgIcon("icon/money_bag_24dp_FFFFFF_FILL0_wght400_GRAD0_opsz24.svg", 34, 34);
        sVGIcon35.setsvgIcon("icon/manage_accounts_24dp_FFFFFF_FILL0_wght400_GRAD0_opsz24.svg", 34, 34);
        sVGIcon36.setsvgIcon("icon/person_add_24dp_FFFFFF_FILL0_wght400_GRAD0_opsz24.svg", 34, 34);
        sVGIcon37.setsvgIcon("icon/finance_chip_24dp_000000_FILL0_wght400_GRAD0_opsz24.svg", 34, 34);
        sVGIcon38.setsvgIcon("icon/request_quote_24dp_000000_FILL0_wght400_GRAD0_opsz24.svg", 34, 34);
        sVGIcon39.setsvgIcon("icon/lab_profile_24dp_000000_FILL0_wght400_GRAD0_opsz24.svg", 34, 34);
        

    }

    private void LoadRoomBookingDetails() {
        try {
            ResultSet resultSet = Mysql2.msearch("SELECT * FROM reservation_details INNER JOIN guest_details ON reservation_details.id=guest_details.reservation_details_id INNER JOIN room_type ON reservation_details.room_type_id=room_type.id INNER JOIN payment_details ON guest_details.payment_details_id=payment_details.id");

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

            model.setRowCount(0);

            while (resultSet.next()) {
                Vector<String> vector = new Vector<>();
                vector.add(resultSet.getString("fname"));
                vector.add(resultSet.getString("type"));
                vector.add(resultSet.getString("check_in"));
                vector.add(resultSet.getString("check_out"));
                vector.add(resultSet.getString("payment_details.total_amount"));

                model.addRow(vector);
            }
           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void LoadRoomBookingDetails1() {

        try {
            ResultSet resultSet = Mysql2.msearch("SELECT * FROM reservation_details INNER JOIN guest_details ON reservation_details.id=guest_details.reservation_details_id INNER JOIN room_type ON reservation_details.room_type_id=room_type.id INNER JOIN payment_details ON guest_details.payment_details_id=payment_details.id");
            DefaultTableModel model1 = (DefaultTableModel) jTable2.getModel();
            model1.setRowCount(0);
            
             while (resultSet.next()) {
                Vector<String> vector = new Vector<>();
                vector.add(resultSet.getString("id"));
                vector.add(resultSet.getString("reference_no"));
                vector.add(resultSet.getString("fname"));
                vector.add(resultSet.getString("type"));
                vector.add(resultSet.getString("check_in"));
                vector.add(resultSet.getString("check_out"));
                vector.add(resultSet.getString("payment_details.advance_amount"));
                vector.add(resultSet.getString("number_of_Nights"));
                vector.add(resultSet.getString("status"));

                model1.addRow(vector);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void LoadHousekeepingData() {
        try {
            ResultSet resultSet = Mysql2.msearch("SELECT * FROM `housekeeping` INNER JOIN `employee` ON housekeeping.employee_id = employee.id INNER JOIN `housekeeping_status` ON housekeeping.houseKeeping_status_id=housekeeping_status.id INNER JOIN room_type ON housekeeping.room_type_id=room_type.id");

            DefaultTableModel model = (DefaultTableModel) jTable4.getModel();
            model.setRowCount(0);

            while (resultSet.next()) {
                Vector<String> vector = new Vector<>();

                vector.add(resultSet.getString("housekeeping.id"));
                vector.add(resultSet.getString("fname"));
                vector.add(resultSet.getString("status"));
                vector.add(resultSet.getString("type"));
                vector.add(resultSet.getString("assign_status"));

                model.addRow(vector);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void LoadRoomFacilitiesDetails() {
        try {
            ResultSet resultSet = Mysql2.msearch("SELECT * FROM room_facilites");

            DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
            model.setRowCount(0);

            while (resultSet.next()) {
                Vector<String> vector = new Vector<>();
                vector.add(resultSet.getString("id"));
                vector.add(resultSet.getString("facilites"));

                model.addRow(vector);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void LoadRHouseKeepingDetails() {
        try {
            ResultSet resultSet = Mysql2.msearch("SELECT * FROM housekeeping INNER JOIN employee ON  housekeeping.employee_id = employee.id INNER JOIN housekeeping_status ON housekeeping.houseKeeping_status_id=housekeeping_status.id INNER JOIN room_type ON housekeeping.room_type_id=room_type.id ");

            DefaultTableModel model = (DefaultTableModel) jTable4.getModel();
            model.setRowCount(0);

            while (resultSet.next()) {
                Vector<String> vector = new Vector<>();
                vector.add(resultSet.getString("id"));
                vector.add(resultSet.getString("fname"));
                vector.add(resultSet.getString("status"));
                vector.add(resultSet.getString("type"));
                vector.add(resultSet.getString("assign_status"));

                model.addRow(vector);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void LoadTransactionDetails() {
        try {
            ResultSet resultSet = Mysql2.msearch("SELECT * FROM transaction ");

            DefaultTableModel model = (DefaultTableModel) jTable6.getModel();
            model.setRowCount(0);

            while (resultSet.next()) {
                Vector<String> vector = new Vector<>();
                vector.add(resultSet.getString("id"));
                vector.add(resultSet.getString("production_description"));
                vector.add(resultSet.getString("status"));
                vector.add(resultSet.getString("price"));
                vector.add(resultSet.getString("order_no"));
                vector.add(resultSet.getString("date"));

                model.addRow(vector);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void LoadBookingDetails() {
        try {
            ResultSet resultSet = Mysql2.msearch("SELECT * FROM `transaction`");

            DefaultTableModel model = (DefaultTableModel) jTable6.getModel();
            model.setRowCount(0);

            while (resultSet.next()) {
                Vector<String> vector = new Vector<>();
                vector.add(resultSet.getString("id"));
                vector.add(resultSet.getString("production_description"));
                vector.add(resultSet.getString("status"));
                vector.add(resultSet.getString("price"));
                vector.add(resultSet.getString("order_no"));
                vector.add(resultSet.getString("date"));

                model.addRow(vector);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void LoadCabBookingDetails() {
        try {
            ResultSet resultSet = Mysql2.msearch("SELECT * FROM car_booking INNER JOIN car_booking_type ON car_booking.car_booking_type_id = car_booking_type.id INNER JOIN cab_list ON car_booking.cab_list_id=cab_list.id INNER JOIN employee ON car_booking.employee_id = employee.id INNER JOIN guest_details ON car_booking.guest_details_id = guest_details.id");

            DefaultTableModel model = (DefaultTableModel) jTable5.getModel();
            model.setRowCount(0);

            while (resultSet.next()) {
                Vector<String> vector = new Vector<>();
                vector.add(resultSet.getString("cab_list.id"));
                vector.add(resultSet.getString("cab_list.car"));
                vector.add(resultSet.getString("cab_list.car_number"));
                vector.add(resultSet.getString("employee.fname"));
                vector.add(resultSet.getString("guest_details.fname"));
                vector.add(resultSet.getString("datetime"));
                vector.add(resultSet.getString("car_booking_type.tyoe"));

                model.addRow(vector);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        panelRound36 = new test.PanelRound();
        chart1 = new com.raven.chart.Chart();
        panelRound37 = new test.PanelRound();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        panelRound6 = new test.PanelRound();
        jLabel32 = new javax.swing.JLabel();
        panelRound39 = new test.PanelRound();
        panelRound52 = new test.PanelRound();
        sVGIcon27 = new svg.SVGIcon();
        jLabel47 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        panelRound42 = new test.PanelRound();
        jLabel33 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        panelRound44 = new test.PanelRound();
        panelRound46 = new test.PanelRound();
        jLabel40 = new javax.swing.JLabel();
        panelRound43 = new test.PanelRound();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jLabel39 = new javax.swing.JLabel();
        panelRound5 = new test.PanelRound();
        jLabel14 = new javax.swing.JLabel();
        panelRound38 = new test.PanelRound();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        panelRound4 = new test.PanelRound();
        jLabel15 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        panelRound3 = new test.PanelRound();
        jLabel16 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        panelRound14 = new test.PanelRound();
        jLabel30 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        panelRound13 = new test.PanelRound();
        panelRound47 = new test.PanelRound();
        jLabel59 = new javax.swing.JLabel();
        panelRound62 = new test.PanelRound();
        jLabel63 = new javax.swing.JLabel();
        panelRound63 = new test.PanelRound();
        jLabel64 = new javax.swing.JLabel();
        panelRound64 = new test.PanelRound();
        jLabel66 = new javax.swing.JLabel();
        panelRound65 = new test.PanelRound();
        jLabel65 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        panelRound48 = new test.PanelRound();
        panelRound51 = new test.PanelRound();
        sVGIcon28 = new svg.SVGIcon();
        jLabel31 = new javax.swing.JLabel();
        panelRound53 = new test.PanelRound();
        sVGIcon29 = new svg.SVGIcon();
        jLabel41 = new javax.swing.JLabel();
        panelRound54 = new test.PanelRound();
        sVGIcon30 = new svg.SVGIcon();
        jLabel42 = new javax.swing.JLabel();
        panelRound55 = new test.PanelRound();
        sVGIcon33 = new svg.SVGIcon();
        jLabel43 = new javax.swing.JLabel();
        panelRound56 = new test.PanelRound();
        sVGIcon34 = new svg.SVGIcon();
        jLabel44 = new javax.swing.JLabel();
        panelRound57 = new test.PanelRound();
        sVGIcon35 = new svg.SVGIcon();
        jLabel52 = new javax.swing.JLabel();
        panelRound58 = new test.PanelRound();
        sVGIcon36 = new svg.SVGIcon();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        panelRound49 = new test.PanelRound();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();
        panelRound50 = new test.PanelRound();
        jLabel55 = new javax.swing.JLabel();
        panelRound59 = new test.PanelRound();
        sVGIcon37 = new svg.SVGIcon();
        jLabel56 = new javax.swing.JLabel();
        panelRound60 = new test.PanelRound();
        sVGIcon38 = new svg.SVGIcon();
        jLabel57 = new javax.swing.JLabel();
        panelRound61 = new test.PanelRound();
        sVGIcon39 = new svg.SVGIcon();
        jLabel58 = new javax.swing.JLabel();
        panelRound67 = new test.PanelRound();
        jLabel68 = new javax.swing.JLabel();
        panelRound12 = new test.PanelRound();
        panelRound27 = new test.PanelRound();
        jLabel18 = new javax.swing.JLabel();
        panelRound23 = new test.PanelRound();
        jLabel17 = new javax.swing.JLabel();
        sVGIcon13 = new model.SVGIcon();
        sVGIcon9 = new svg.SVGIcon();
        panelRound24 = new test.PanelRound();
        jLabel19 = new javax.swing.JLabel();
        sVGIcon14 = new model.SVGIcon();
        sVGIcon10 = new svg.SVGIcon();
        panelRound25 = new test.PanelRound();
        jLabel20 = new javax.swing.JLabel();
        sVGIcon15 = new model.SVGIcon();
        sVGIcon11 = new svg.SVGIcon();
        panelRound26 = new test.PanelRound();
        jLabel21 = new javax.swing.JLabel();
        sVGIcon16 = new model.SVGIcon();
        sVGIcon12 = new svg.SVGIcon();
        panelRound28 = new test.PanelRound();
        jLabel22 = new javax.swing.JLabel();
        sVGIcon17 = new model.SVGIcon();
        sVGIcon18 = new svg.SVGIcon();
        panelRound29 = new test.PanelRound();
        jLabel23 = new javax.swing.JLabel();
        panelRound30 = new test.PanelRound();
        jLabel24 = new javax.swing.JLabel();
        sVGIcon19 = new model.SVGIcon();
        sVGIcon20 = new svg.SVGIcon();
        panelRound31 = new test.PanelRound();
        jLabel25 = new javax.swing.JLabel();
        sVGIcon21 = new model.SVGIcon();
        sVGIcon22 = new svg.SVGIcon();
        panelRound32 = new test.PanelRound();
        jLabel26 = new javax.swing.JLabel();
        panelRound33 = new test.PanelRound();
        jLabel27 = new javax.swing.JLabel();
        sVGIcon23 = new model.SVGIcon();
        sVGIcon24 = new svg.SVGIcon();
        panelRound66 = new test.PanelRound();
        jLabel67 = new javax.swing.JLabel();
        sVGIcon40 = new model.SVGIcon();
        sVGIcon41 = new svg.SVGIcon();
        panelRound34 = new test.PanelRound();
        panelRound35 = new test.PanelRound();
        jLabel29 = new javax.swing.JLabel();
        sVGIcon25 = new model.SVGIcon();
        sVGIcon26 = new svg.SVGIcon();
        panelRound40 = new test.PanelRound();
        jLabel34 = new javax.swing.JLabel();
        panelRound41 = new test.PanelRound();
        jLabel35 = new javax.swing.JLabel();
        sVGIcon31 = new model.SVGIcon();
        sVGIcon32 = new svg.SVGIcon();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dashboard");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(21, 21, 21));

        panelRound1.setBackground(new java.awt.Color(32, 48, 47));
        panelRound1.setRoundBottomLeft(20);
        panelRound1.setRoundBottomRight(20);
        panelRound1.setRoundTopLeft(20);
        panelRound1.setRoundTopRight(20);

        panelRound2.setBackground(new java.awt.Color(32, 48, 47));
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

        panelRound15.setBackground(new java.awt.Color(32, 48, 47));
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

        panelRound16.setBackground(new java.awt.Color(32, 48, 47));
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

        panelRound17.setBackground(new java.awt.Color(32, 48, 47));
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

        panelRound18.setBackground(new java.awt.Color(32, 48, 47));
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

        panelRound19.setBackground(new java.awt.Color(32, 48, 47));
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

        panelRound20.setBackground(new java.awt.Color(32, 48, 47));
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

        panelRound21.setBackground(new java.awt.Color(32, 48, 47));
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

        panelRound7.setBackground(new java.awt.Color(13, 208, 157));

        jScrollPane1.setBackground(new java.awt.Color(13, 208, 157));
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jPanel2.setBackground(new java.awt.Color(13, 208, 157));

        panelRound8.setBackground(new java.awt.Color(32, 48, 47));
        panelRound8.setRoundBottomLeft(15);
        panelRound8.setRoundBottomRight(15);
        panelRound8.setRoundTopLeft(15);
        panelRound8.setRoundTopRight(15);

        jLabel1.setFont(new java.awt.Font("Poppins Medium", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Today Booking");

        jLabel5.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(219, 253, 130));
        jLabel5.setText("1,587");

        jLabel9.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("From previous period");

        javax.swing.GroupLayout panelRound8Layout = new javax.swing.GroupLayout(panelRound8);
        panelRound8.setLayout(panelRound8Layout);
        panelRound8Layout.setHorizontalGroup(
            panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        panelRound9.setBackground(new java.awt.Color(32, 48, 47));
        panelRound9.setRoundBottomLeft(15);
        panelRound9.setRoundBottomRight(15);
        panelRound9.setRoundTopLeft(15);
        panelRound9.setRoundTopRight(15);

        jLabel2.setFont(new java.awt.Font("Poppins Medium", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Total Amount");

        jLabel6.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(219, 253, 130));
        jLabel6.setText("$2,258");

        jLabel10.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText(" New income");

        javax.swing.GroupLayout panelRound9Layout = new javax.swing.GroupLayout(panelRound9);
        panelRound9.setLayout(panelRound9Layout);
        panelRound9Layout.setHorizontalGroup(
            panelRound9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        panelRound11.setBackground(new java.awt.Color(32, 48, 47));
        panelRound11.setRoundBottomLeft(15);
        panelRound11.setRoundBottomRight(15);
        panelRound11.setRoundTopLeft(15);
        panelRound11.setRoundTopRight(15);

        jLabel3.setFont(new java.awt.Font("Poppins Medium", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Total Customer");

        jLabel7.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(219, 253, 130));
        jLabel7.setText("2.3k");

        jLabel11.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("From previous period");

        javax.swing.GroupLayout panelRound11Layout = new javax.swing.GroupLayout(panelRound11);
        panelRound11.setLayout(panelRound11Layout);
        panelRound11Layout.setHorizontalGroup(
            panelRound11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        panelRound22.setBackground(new java.awt.Color(32, 48, 47));
        panelRound22.setRoundBottomLeft(15);
        panelRound22.setRoundBottomRight(15);
        panelRound22.setRoundTopLeft(15);
        panelRound22.setRoundTopRight(15);

        jLabel4.setFont(new java.awt.Font("Poppins Medium", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Total Revenue");

        jLabel8.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(219, 253, 130));
        jLabel8.setText("11,5587");

        jLabel12.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("From previous period");

        javax.swing.GroupLayout panelRound22Layout = new javax.swing.GroupLayout(panelRound22);
        panelRound22.setLayout(panelRound22Layout);
        panelRound22Layout.setHorizontalGroup(
            panelRound22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        panelRound36.setBackground(new java.awt.Color(32, 48, 47));
        panelRound36.setRoundBottomLeft(20);
        panelRound36.setRoundBottomRight(20);
        panelRound36.setRoundTopLeft(20);
        panelRound36.setRoundTopRight(20);

        chart1.setBackground(new java.awt.Color(32, 48, 47));
        panelRound36.add(chart1);

        panelRound37.setBackground(new java.awt.Color(32, 48, 47));
        panelRound37.setRoundBottomLeft(20);
        panelRound37.setRoundBottomRight(20);
        panelRound37.setRoundTopLeft(20);
        panelRound37.setRoundTopRight(20);

        jLabel13.setFont(new java.awt.Font("Poppins Medium", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Today Booking List");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Room Type", "Check In", "Check Out", "Due Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout panelRound37Layout = new javax.swing.GroupLayout(panelRound37);
        panelRound37.setLayout(panelRound37Layout);
        panelRound37Layout.setHorizontalGroup(
            panelRound37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound37Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound37Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        panelRound37Layout.setVerticalGroup(
            panelRound37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound37Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(panelRound8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelRound9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelRound11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelRound22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelRound36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelRound37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelRound36, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRound37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel2);

        javax.swing.GroupLayout panelRound7Layout = new javax.swing.GroupLayout(panelRound7);
        panelRound7.setLayout(panelRound7Layout);
        panelRound7Layout.setHorizontalGroup(
            panelRound7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 899, Short.MAX_VALUE)
        );
        panelRound7Layout.setVerticalGroup(
            panelRound7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)
        );

        panelRound10.add(panelRound7, "card9");

        panelRound6.setBackground(new java.awt.Color(13, 208, 157));

        jLabel32.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Transaction");

        panelRound39.setBackground(new java.awt.Color(32, 48, 47));
        panelRound39.setRoundBottomLeft(35);
        panelRound39.setRoundBottomRight(35);
        panelRound39.setRoundTopLeft(35);
        panelRound39.setRoundTopRight(35);

        panelRound52.setBackground(new java.awt.Color(139, 121, 241));
        panelRound52.setRoundBottomLeft(100);
        panelRound52.setRoundBottomRight(100);
        panelRound52.setRoundTopLeft(100);
        panelRound52.setRoundTopRight(100);

        sVGIcon27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelRound52Layout = new javax.swing.GroupLayout(panelRound52);
        panelRound52.setLayout(panelRound52Layout);
        panelRound52Layout.setHorizontalGroup(
            panelRound52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound52Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sVGIcon27, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelRound52Layout.setVerticalGroup(
            panelRound52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound52Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sVGIcon27, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        jLabel47.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("Balance");

        jLabel50.setFont(new java.awt.Font("Poppins Medium", 1, 24)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setText("RS.");

        jLabel51.setFont(new java.awt.Font("Poppins Medium", 1, 24)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setText("32456.00");

        javax.swing.GroupLayout panelRound39Layout = new javax.swing.GroupLayout(panelRound39);
        panelRound39.setLayout(panelRound39Layout);
        panelRound39Layout.setHorizontalGroup(
            panelRound39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound39Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panelRound39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound39Layout.createSequentialGroup()
                        .addComponent(panelRound52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel50)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel51))
                    .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        panelRound39Layout.setVerticalGroup(
            panelRound39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound39Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jLabel47)
                .addGroup(panelRound39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound39Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelRound52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRound39Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(panelRound39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel50)
                            .addComponent(jLabel51))))
                .addGap(36, 36, 36))
        );

        panelRound42.setBackground(new java.awt.Color(32, 48, 47));
        panelRound42.setRoundBottomLeft(35);
        panelRound42.setRoundBottomRight(35);
        panelRound42.setRoundTopLeft(35);
        panelRound42.setRoundTopRight(35);

        jLabel33.setFont(new java.awt.Font("Poppins Medium", 1, 24)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("56790.00");

        jLabel36.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("134 Transaction");

        jLabel37.setFont(new java.awt.Font("Poppins Medium", 1, 24)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("RS.");

        jLabel38.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("Bill");

        javax.swing.GroupLayout panelRound42Layout = new javax.swing.GroupLayout(panelRound42);
        panelRound42.setLayout(panelRound42Layout);
        panelRound42Layout.setHorizontalGroup(
            panelRound42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound42Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(panelRound42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelRound42Layout.createSequentialGroup()
                        .addComponent(jLabel37)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel33))
                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound42Layout.setVerticalGroup(
            panelRound42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound42Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jLabel38)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRound42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel33)
                    .addComponent(jLabel37, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel36)
                .addGap(18, 18, 18))
        );

        panelRound44.setBackground(new java.awt.Color(32, 48, 47));
        panelRound44.setRoundBottomLeft(35);
        panelRound44.setRoundBottomRight(35);
        panelRound44.setRoundTopLeft(35);
        panelRound44.setRoundTopRight(35);

        panelRound46.setBackground(new java.awt.Color(139, 121, 241));
        panelRound46.setRoundBottomLeft(35);
        panelRound46.setRoundBottomRight(35);
        panelRound46.setRoundTopLeft(35);
        panelRound46.setRoundTopRight(35);
        panelRound46.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelRound46MouseClicked(evt);
            }
        });

        jLabel40.setFont(new java.awt.Font("Poppins Medium", 1, 18)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("Add Bill");

        javax.swing.GroupLayout panelRound46Layout = new javax.swing.GroupLayout(panelRound46);
        panelRound46.setLayout(panelRound46Layout);
        panelRound46Layout.setHorizontalGroup(
            panelRound46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound46Layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(jLabel40)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound46Layout.setVerticalGroup(
            panelRound46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound46Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout panelRound44Layout = new javax.swing.GroupLayout(panelRound44);
        panelRound44.setLayout(panelRound44Layout);
        panelRound44Layout.setHorizontalGroup(
            panelRound44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound44Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelRound46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelRound44Layout.setVerticalGroup(
            panelRound44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound44Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(panelRound46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(379, Short.MAX_VALUE))
        );

        panelRound43.setBackground(new java.awt.Color(32, 48, 47));
        panelRound43.setRoundBottomLeft(35);
        panelRound43.setRoundBottomRight(35);
        panelRound43.setRoundTopLeft(35);
        panelRound43.setRoundTopRight(35);

        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Product Description", "Status", "Price", "Order No.", "Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(jTable6);

        jLabel39.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Transaction Histroy");

        javax.swing.GroupLayout panelRound43Layout = new javax.swing.GroupLayout(panelRound43);
        panelRound43.setLayout(panelRound43Layout);
        panelRound43Layout.setHorizontalGroup(
            panelRound43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound43Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7)
                    .addGroup(panelRound43Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelRound43Layout.setVerticalGroup(
            panelRound43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound43Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel39)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelRound6Layout = new javax.swing.GroupLayout(panelRound6);
        panelRound6.setLayout(panelRound6Layout);
        panelRound6Layout.setHorizontalGroup(
            panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound6Layout.createSequentialGroup()
                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 724, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound6Layout.createSequentialGroup()
                        .addGroup(panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelRound42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelRound43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panelRound39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelRound44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        panelRound6Layout.setVerticalGroup(
            panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound6Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelRound42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRound39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRound44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRound43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        panelRound10.add(panelRound6, "card8");

        panelRound5.setBackground(new java.awt.Color(13, 208, 157));

        jLabel14.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Room Booking List");

        panelRound38.setBackground(new java.awt.Color(32, 48, 47));
        panelRound38.setRoundBottomLeft(20);
        panelRound38.setRoundBottomRight(20);
        panelRound38.setRoundTopLeft(20);
        panelRound38.setRoundTopRight(20);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Booking Number", "Name ", "Room Type", "Check In", "Check Out", "Due Amount ", "Number of Night", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable2);

        javax.swing.GroupLayout panelRound38Layout = new javax.swing.GroupLayout(panelRound38);
        panelRound38.setLayout(panelRound38Layout);
        panelRound38Layout.setHorizontalGroup(
            panelRound38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound38Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 881, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelRound38Layout.setVerticalGroup(
            panelRound38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
        );

        jButton1.setBackground(new java.awt.Color(139, 121, 241));
        jButton1.setFont(new java.awt.Font("Poppins Medium", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Room Status");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(139, 121, 241));
        jButton2.setFont(new java.awt.Font("Poppins Medium", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Room Book");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(139, 121, 241));
        jButton3.setFont(new java.awt.Font("Poppins Medium", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Room Checkout");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound5Layout = new javax.swing.GroupLayout(panelRound5);
        panelRound5.setLayout(panelRound5Layout);
        panelRound5Layout.setHorizontalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound5Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(panelRound38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addGap(20, 20, 20))
        );
        panelRound5Layout.setVerticalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addGap(12, 12, 12)
                .addGroup(panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRound38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelRound10.add(panelRound5, "card7");

        panelRound4.setBackground(new java.awt.Color(13, 208, 157));

        jLabel15.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Room Facilites List");

        jButton4.setBackground(new java.awt.Color(139, 121, 241));
        jButton4.setFont(new java.awt.Font("Poppins Medium", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Add  Facilites");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(139, 121, 241));
        jButton5.setFont(new java.awt.Font("Poppins Medium", 1, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Room Size");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Facilites Id", "Facilites Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jTable3);

        javax.swing.GroupLayout panelRound4Layout = new javax.swing.GroupLayout(panelRound4);
        panelRound4.setLayout(panelRound4Layout);
        panelRound4Layout.setHorizontalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 882, Short.MAX_VALUE)
                    .addGroup(panelRound4Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)))
                .addGap(11, 11, 11))
        );
        panelRound4Layout.setVerticalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound4Layout.createSequentialGroup()
                .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel15))
                    .addGroup(panelRound4Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelRound10.add(panelRound4, "card6");

        panelRound3.setBackground(new java.awt.Color(13, 208, 157));

        jLabel16.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Housekeeping");

        jButton6.setBackground(new java.awt.Color(139, 121, 241));
        jButton6.setFont(new java.awt.Font("Poppins Medium", 1, 12)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Cleaning List");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(139, 121, 241));
        jButton7.setFont(new java.awt.Font("Poppins Medium", 1, 12)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Assign House Keeping");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jTable4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Employee", "Status", "Room Type", "Assign Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(jTable4);

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound3Layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 887, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(panelRound3Layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7)
                        .addGap(13, 13, 13))))
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound3Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel16))
                    .addGroup(panelRound3Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelRound10.add(panelRound3, "card5");

        panelRound14.setBackground(new java.awt.Color(13, 208, 157));

        jLabel30.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Cab Booking");

        jButton9.setBackground(new java.awt.Color(139, 121, 241));
        jButton9.setFont(new java.awt.Font("Poppins Medium", 1, 12)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("Add Cab");
        jButton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton9MouseClicked(evt);
            }
        });

        jButton10.setBackground(new java.awt.Color(139, 121, 241));
        jButton10.setFont(new java.awt.Font("Poppins Medium", 1, 12)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setText("Book Cab");
        jButton10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton10MouseClicked(evt);
            }
        });

        jTable5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id ", "Car", "Car Number ", "Driver", "Customer", "Date", "Type "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(jTable5);

        javax.swing.GroupLayout panelRound14Layout = new javax.swing.GroupLayout(panelRound14);
        panelRound14.setLayout(panelRound14Layout);
        panelRound14Layout.setHorizontalGroup(
            panelRound14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound14Layout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 887, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(panelRound14Layout.createSequentialGroup()
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton10)
                        .addGap(18, 18, 18))))
        );
        panelRound14Layout.setVerticalGroup(
            panelRound14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound14Layout.createSequentialGroup()
                .addGroup(panelRound14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound14Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRound14Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(panelRound14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelRound10.add(panelRound14, "card2");

        panelRound13.setBackground(new java.awt.Color(13, 208, 157));

        panelRound47.setBackground(new java.awt.Color(32, 48, 47));
        panelRound47.setRoundBottomLeft(20);
        panelRound47.setRoundBottomRight(20);
        panelRound47.setRoundTopLeft(20);
        panelRound47.setRoundTopRight(20);

        jLabel59.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(255, 255, 255));
        jLabel59.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel59.setText("Total Employees");

        panelRound62.setBackground(new java.awt.Color(219, 253, 130));
        panelRound62.setRoundBottomLeft(100);
        panelRound62.setRoundBottomRight(100);
        panelRound62.setRoundTopLeft(100);
        panelRound62.setRoundTopRight(100);

        jLabel63.setFont(new java.awt.Font("Poppins", 1, 48)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(0, 0, 0));
        jLabel63.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel63.setText("32");

        javax.swing.GroupLayout panelRound62Layout = new javax.swing.GroupLayout(panelRound62);
        panelRound62.setLayout(panelRound62Layout);
        panelRound62Layout.setHorizontalGroup(
            panelRound62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound62Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );
        panelRound62Layout.setVerticalGroup(
            panelRound62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound62Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        panelRound63.setBackground(new java.awt.Color(139, 121, 241));
        panelRound63.setRoundBottomLeft(100);
        panelRound63.setRoundBottomRight(100);
        panelRound63.setRoundTopLeft(100);
        panelRound63.setRoundTopRight(100);

        jLabel64.setFont(new java.awt.Font("Poppins", 1, 48)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(0, 0, 0));
        jLabel64.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel64.setText("12");

        javax.swing.GroupLayout panelRound63Layout = new javax.swing.GroupLayout(panelRound63);
        panelRound63.setLayout(panelRound63Layout);
        panelRound63Layout.setHorizontalGroup(
            panelRound63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound63Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound63Layout.setVerticalGroup(
            panelRound63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound63Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        panelRound64.setBackground(new java.awt.Color(62, 172, 145));
        panelRound64.setRoundBottomLeft(100);
        panelRound64.setRoundBottomRight(100);
        panelRound64.setRoundTopLeft(100);
        panelRound64.setRoundTopRight(100);

        jLabel66.setFont(new java.awt.Font("Poppins", 1, 48)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(0, 0, 0));
        jLabel66.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel66.setText("15");

        javax.swing.GroupLayout panelRound64Layout = new javax.swing.GroupLayout(panelRound64);
        panelRound64.setLayout(panelRound64Layout);
        panelRound64Layout.setHorizontalGroup(
            panelRound64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound64Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        panelRound64Layout.setVerticalGroup(
            panelRound64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound64Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        panelRound65.setBackground(new java.awt.Color(155, 240, 94));
        panelRound65.setRoundBottomLeft(100);
        panelRound65.setRoundBottomRight(100);
        panelRound65.setRoundTopLeft(100);
        panelRound65.setRoundTopRight(100);

        jLabel65.setFont(new java.awt.Font("Poppins", 1, 48)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(0, 0, 0));
        jLabel65.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel65.setText("2");

        javax.swing.GroupLayout panelRound65Layout = new javax.swing.GroupLayout(panelRound65);
        panelRound65.setLayout(panelRound65Layout);
        panelRound65Layout.setHorizontalGroup(
            panelRound65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound65Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        panelRound65Layout.setVerticalGroup(
            panelRound65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound65Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        jLabel60.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(255, 255, 255));
        jLabel60.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel60.setText("Housekeeping Staff");

        jLabel61.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(255, 255, 255));
        jLabel61.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel61.setText("Manager");

        jLabel62.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(255, 255, 255));
        jLabel62.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel62.setText("Receptionist");

        javax.swing.GroupLayout panelRound47Layout = new javax.swing.GroupLayout(panelRound47);
        panelRound47.setLayout(panelRound47Layout);
        panelRound47Layout.setHorizontalGroup(
            panelRound47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound47Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(panelRound47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound47Layout.createSequentialGroup()
                        .addComponent(panelRound62, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addGroup(panelRound47Layout.createSequentialGroup()
                        .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)))
                .addGroup(panelRound47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound47Layout.createSequentialGroup()
                        .addComponent(panelRound63, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addGroup(panelRound47Layout.createSequentialGroup()
                        .addComponent(jLabel60, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                        .addGap(26, 26, 26)))
                .addGroup(panelRound47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound47Layout.createSequentialGroup()
                        .addComponent(panelRound64, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addGroup(panelRound47Layout.createSequentialGroup()
                        .addComponent(jLabel61, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(26, 26, 26)))
                .addGroup(panelRound47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound47Layout.createSequentialGroup()
                        .addComponent(jLabel62, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(9, 9, 9))
                    .addComponent(panelRound65, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(17, 17, 17))
        );
        panelRound47Layout.setVerticalGroup(
            panelRound47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound47Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRound65, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelRound64, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelRound62, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelRound63, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRound47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel59)
                    .addComponent(jLabel60)
                    .addComponent(jLabel61)
                    .addComponent(jLabel62))
                .addContainerGap())
        );

        panelRound48.setBackground(new java.awt.Color(32, 48, 47));
        panelRound48.setRoundBottomLeft(20);
        panelRound48.setRoundBottomRight(20);
        panelRound48.setRoundTopLeft(20);
        panelRound48.setRoundTopRight(20);

        panelRound51.setBackground(new java.awt.Color(139, 121, 241));
        panelRound51.setRoundBottomLeft(35);
        panelRound51.setRoundBottomRight(35);
        panelRound51.setRoundTopLeft(35);
        panelRound51.setRoundTopRight(35);
        panelRound51.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelRound51MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelRound51MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelRound51MouseExited(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Departments");

        javax.swing.GroupLayout panelRound51Layout = new javax.swing.GroupLayout(panelRound51);
        panelRound51.setLayout(panelRound51Layout);
        panelRound51Layout.setHorizontalGroup(
            panelRound51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound51Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(sVGIcon28, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound51Layout.setVerticalGroup(
            panelRound51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sVGIcon28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
        );

        panelRound53.setBackground(new java.awt.Color(139, 121, 241));
        panelRound53.setRoundBottomLeft(35);
        panelRound53.setRoundBottomRight(35);
        panelRound53.setRoundTopLeft(35);
        panelRound53.setRoundTopRight(35);
        panelRound53.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelRound53MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelRound53MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelRound53MouseExited(evt);
            }
        });

        jLabel41.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("All Employee ");

        javax.swing.GroupLayout panelRound53Layout = new javax.swing.GroupLayout(panelRound53);
        panelRound53.setLayout(panelRound53Layout);
        panelRound53Layout.setHorizontalGroup(
            panelRound53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound53Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(sVGIcon29, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound53Layout.setVerticalGroup(
            panelRound53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sVGIcon29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
        );

        panelRound54.setBackground(new java.awt.Color(139, 121, 241));
        panelRound54.setRoundBottomLeft(35);
        panelRound54.setRoundBottomRight(35);
        panelRound54.setRoundTopLeft(35);
        panelRound54.setRoundTopRight(35);
        panelRound54.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelRound54MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelRound54MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelRound54MouseExited(evt);
            }
        });

        jLabel42.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("Leave Tracking");

        javax.swing.GroupLayout panelRound54Layout = new javax.swing.GroupLayout(panelRound54);
        panelRound54.setLayout(panelRound54Layout);
        panelRound54Layout.setHorizontalGroup(
            panelRound54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound54Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(sVGIcon30, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound54Layout.setVerticalGroup(
            panelRound54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sVGIcon30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
        );

        panelRound55.setBackground(new java.awt.Color(139, 121, 241));
        panelRound55.setRoundBottomLeft(35);
        panelRound55.setRoundBottomRight(35);
        panelRound55.setRoundTopLeft(35);
        panelRound55.setRoundTopRight(35);
        panelRound55.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelRound55MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelRound55MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelRound55MouseExited(evt);
            }
        });

        jLabel43.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("Attendance");

        javax.swing.GroupLayout panelRound55Layout = new javax.swing.GroupLayout(panelRound55);
        panelRound55.setLayout(panelRound55Layout);
        panelRound55Layout.setHorizontalGroup(
            panelRound55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound55Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(sVGIcon33, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound55Layout.setVerticalGroup(
            panelRound55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sVGIcon33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
        );

        panelRound56.setBackground(new java.awt.Color(139, 121, 241));
        panelRound56.setRoundBottomLeft(35);
        panelRound56.setRoundBottomRight(35);
        panelRound56.setRoundTopLeft(35);
        panelRound56.setRoundTopRight(35);
        panelRound56.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelRound56MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelRound56MouseExited(evt);
            }
        });

        jLabel44.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("Employees Loan");

        javax.swing.GroupLayout panelRound56Layout = new javax.swing.GroupLayout(panelRound56);
        panelRound56.setLayout(panelRound56Layout);
        panelRound56Layout.setHorizontalGroup(
            panelRound56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound56Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(sVGIcon34, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );
        panelRound56Layout.setVerticalGroup(
            panelRound56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sVGIcon34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
        );

        panelRound57.setBackground(new java.awt.Color(139, 121, 241));
        panelRound57.setRoundBottomLeft(35);
        panelRound57.setRoundBottomRight(35);
        panelRound57.setRoundTopLeft(35);
        panelRound57.setRoundTopRight(35);
        panelRound57.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelRound57MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelRound57MouseExited(evt);
            }
        });

        jLabel52.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setText("Appraisal");

        javax.swing.GroupLayout panelRound57Layout = new javax.swing.GroupLayout(panelRound57);
        panelRound57.setLayout(panelRound57Layout);
        panelRound57Layout.setHorizontalGroup(
            panelRound57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound57Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(sVGIcon35, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound57Layout.setVerticalGroup(
            panelRound57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sVGIcon35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel52, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
        );

        panelRound58.setBackground(new java.awt.Color(139, 121, 241));
        panelRound58.setRoundBottomLeft(35);
        panelRound58.setRoundBottomRight(35);
        panelRound58.setRoundTopLeft(35);
        panelRound58.setRoundTopRight(35);
        panelRound58.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelRound58MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelRound58MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelRound58MouseExited(evt);
            }
        });

        jLabel53.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setText("Add Employees");

        javax.swing.GroupLayout panelRound58Layout = new javax.swing.GroupLayout(panelRound58);
        panelRound58.setLayout(panelRound58Layout);
        panelRound58Layout.setHorizontalGroup(
            panelRound58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound58Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(sVGIcon36, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound58Layout.setVerticalGroup(
            panelRound58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sVGIcon36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel53, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
        );

        jLabel54.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setText("Employees ");

        javax.swing.GroupLayout panelRound48Layout = new javax.swing.GroupLayout(panelRound48);
        panelRound48.setLayout(panelRound48Layout);
        panelRound48Layout.setHorizontalGroup(
            panelRound48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound48Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRound51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRound53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRound54, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRound55, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRound56, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRound57, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRound58, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelRound48Layout.createSequentialGroup()
                        .addComponent(jLabel54)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelRound48Layout.setVerticalGroup(
            panelRound48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound48Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel54)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRound51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelRound53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelRound54, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelRound55, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelRound56, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelRound57, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelRound58, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelRound49.setBackground(new java.awt.Color(32, 48, 47));
        panelRound49.setRoundBottomLeft(20);
        panelRound49.setRoundBottomRight(20);
        panelRound49.setRoundTopLeft(20);
        panelRound49.setRoundTopRight(20);

        jTable7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Employee Id", "First Name", "Last Name", "Join Date", "Email", "Password", "Mobile", "Gender", "Birth Day", "NIC", "Department", "Designation"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane8.setViewportView(jTable7);

        javax.swing.GroupLayout panelRound49Layout = new javax.swing.GroupLayout(panelRound49);
        panelRound49.setLayout(panelRound49Layout);
        panelRound49Layout.setHorizontalGroup(
            panelRound49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound49Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelRound49Layout.setVerticalGroup(
            panelRound49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound49Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8)
                .addContainerGap())
        );

        panelRound50.setBackground(new java.awt.Color(32, 48, 47));
        panelRound50.setRoundBottomLeft(20);
        panelRound50.setRoundBottomRight(20);
        panelRound50.setRoundTopLeft(20);
        panelRound50.setRoundTopRight(20);

        jLabel55.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setText("Payroll");

        panelRound59.setBackground(new java.awt.Color(219, 253, 130));
        panelRound59.setRoundBottomLeft(35);
        panelRound59.setRoundBottomRight(35);
        panelRound59.setRoundTopLeft(35);
        panelRound59.setRoundTopRight(35);
        panelRound59.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelRound59MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelRound59MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelRound59MouseExited(evt);
            }
        });

        jLabel56.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(0, 0, 0));
        jLabel56.setText("Employee Salary ");

        javax.swing.GroupLayout panelRound59Layout = new javax.swing.GroupLayout(panelRound59);
        panelRound59.setLayout(panelRound59Layout);
        panelRound59Layout.setHorizontalGroup(
            panelRound59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound59Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(sVGIcon37, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelRound59Layout.setVerticalGroup(
            panelRound59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sVGIcon37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel56, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
        );

        panelRound60.setBackground(new java.awt.Color(219, 253, 130));
        panelRound60.setRoundBottomLeft(35);
        panelRound60.setRoundBottomRight(35);
        panelRound60.setRoundTopLeft(35);
        panelRound60.setRoundTopRight(35);
        panelRound60.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelRound60MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelRound60MouseExited(evt);
            }
        });

        jLabel57.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(0, 0, 0));
        jLabel57.setText("Payslip");
        jLabel57.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel57MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelRound60Layout = new javax.swing.GroupLayout(panelRound60);
        panelRound60.setLayout(panelRound60Layout);
        panelRound60Layout.setHorizontalGroup(
            panelRound60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound60Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(sVGIcon38, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelRound60Layout.setVerticalGroup(
            panelRound60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sVGIcon38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel57, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
        );

        panelRound61.setBackground(new java.awt.Color(219, 253, 130));
        panelRound61.setRoundBottomLeft(35);
        panelRound61.setRoundBottomRight(35);
        panelRound61.setRoundTopLeft(35);
        panelRound61.setRoundTopRight(35);
        panelRound61.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelRound61MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelRound61MouseExited(evt);
            }
        });

        jLabel58.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(0, 0, 0));
        jLabel58.setText("Report");

        javax.swing.GroupLayout panelRound61Layout = new javax.swing.GroupLayout(panelRound61);
        panelRound61.setLayout(panelRound61Layout);
        panelRound61Layout.setHorizontalGroup(
            panelRound61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound61Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(sVGIcon39, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelRound61Layout.setVerticalGroup(
            panelRound61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sVGIcon39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel58, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
        );

        panelRound67.setBackground(new java.awt.Color(219, 253, 130));
        panelRound67.setRoundBottomLeft(35);
        panelRound67.setRoundBottomRight(35);
        panelRound67.setRoundTopLeft(35);
        panelRound67.setRoundTopRight(35);
        panelRound67.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelRound67MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelRound67MouseExited(evt);
            }
        });

        jLabel68.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(0, 0, 0));
        jLabel68.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel68.setText("$ - Pay Salary");
        jLabel68.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel68MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelRound67Layout = new javax.swing.GroupLayout(panelRound67);
        panelRound67.setLayout(panelRound67Layout);
        panelRound67Layout.setHorizontalGroup(
            panelRound67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound67Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel68, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE))
        );
        panelRound67Layout.setVerticalGroup(
            panelRound67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel68, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelRound50Layout = new javax.swing.GroupLayout(panelRound50);
        panelRound50.setLayout(panelRound50Layout);
        panelRound50Layout.setHorizontalGroup(
            panelRound50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound50Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound50Layout.createSequentialGroup()
                        .addComponent(jLabel55)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound50Layout.createSequentialGroup()
                        .addGap(0, 3, Short.MAX_VALUE)
                        .addGroup(panelRound50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelRound59, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelRound60, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelRound61, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelRound67, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        panelRound50Layout.setVerticalGroup(
            panelRound50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound50Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel55)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRound59, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRound60, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRound61, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRound67, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelRound13Layout = new javax.swing.GroupLayout(panelRound13);
        panelRound13.setLayout(panelRound13Layout);
        panelRound13Layout.setHorizontalGroup(
            panelRound13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound13Layout.createSequentialGroup()
                        .addComponent(panelRound48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelRound49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(panelRound47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRound50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelRound13Layout.setVerticalGroup(
            panelRound13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRound50, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelRound13Layout.createSequentialGroup()
                        .addComponent(panelRound47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelRound13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelRound48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelRound49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );

        panelRound10.add(panelRound13, "card4");

        panelRound12.setBackground(new java.awt.Color(13, 208, 157));

        panelRound27.setBackground(new java.awt.Color(32, 48, 47));
        panelRound27.setRoundBottomLeft(20);
        panelRound27.setRoundBottomRight(20);
        panelRound27.setRoundTopLeft(20);
        panelRound27.setRoundTopRight(20);

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Poppins Light", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Room");

        panelRound23.setBackground(new java.awt.Color(62, 172, 145));
        panelRound23.setRoundBottomLeft(35);
        panelRound23.setRoundBottomRight(35);
        panelRound23.setRoundTopLeft(35);
        panelRound23.setRoundTopRight(35);
        panelRound23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelRound23MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelRound23MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelRound23MouseExited(evt);
            }
        });

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Poppins Light", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Room Book");

        sVGIcon13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelRound23Layout = new javax.swing.GroupLayout(panelRound23);
        panelRound23.setLayout(panelRound23Layout);
        panelRound23Layout.setHorizontalGroup(
            panelRound23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound23Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(sVGIcon13, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sVGIcon9, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        panelRound23Layout.setVerticalGroup(
            panelRound23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound23Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panelRound23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(sVGIcon9, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(sVGIcon13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelRound23Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        panelRound24.setBackground(new java.awt.Color(62, 172, 145));
        panelRound24.setRoundBottomLeft(35);
        panelRound24.setRoundBottomRight(35);
        panelRound24.setRoundTopLeft(35);
        panelRound24.setRoundTopRight(35);
        panelRound24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelRound24MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelRound24MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelRound24MouseExited(evt);
            }
        });

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setFont(new java.awt.Font("Poppins Light", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("Room List");

        sVGIcon14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelRound24Layout = new javax.swing.GroupLayout(panelRound24);
        panelRound24.setLayout(panelRound24Layout);
        panelRound24Layout.setHorizontalGroup(
            panelRound24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound24Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(sVGIcon14, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sVGIcon10, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        panelRound24Layout.setVerticalGroup(
            panelRound24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound24Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panelRound24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(sVGIcon10, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(sVGIcon14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelRound24Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        panelRound25.setBackground(new java.awt.Color(62, 172, 145));
        panelRound25.setRoundBottomLeft(35);
        panelRound25.setRoundBottomRight(35);
        panelRound25.setRoundTopLeft(35);
        panelRound25.setRoundTopRight(35);
        panelRound25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelRound25MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelRound25MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelRound25MouseExited(evt);
            }
        });

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setFont(new java.awt.Font("Poppins Light", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setText("Room Status");

        sVGIcon15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelRound25Layout = new javax.swing.GroupLayout(panelRound25);
        panelRound25.setLayout(panelRound25Layout);
        panelRound25Layout.setHorizontalGroup(
            panelRound25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound25Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(sVGIcon15, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sVGIcon11, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        panelRound25Layout.setVerticalGroup(
            panelRound25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound25Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panelRound25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(sVGIcon11, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(sVGIcon15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelRound25Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        panelRound26.setBackground(new java.awt.Color(62, 172, 145));
        panelRound26.setRoundBottomLeft(35);
        panelRound26.setRoundBottomRight(35);
        panelRound26.setRoundTopLeft(35);
        panelRound26.setRoundTopRight(35);
        panelRound26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelRound26MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelRound26MouseExited(evt);
            }
        });

        jLabel21.setBackground(new java.awt.Color(255, 255, 255));
        jLabel21.setFont(new java.awt.Font("Poppins Light", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setText("Room Image");

        sVGIcon16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelRound26Layout = new javax.swing.GroupLayout(panelRound26);
        panelRound26.setLayout(panelRound26Layout);
        panelRound26Layout.setHorizontalGroup(
            panelRound26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound26Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(sVGIcon16, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sVGIcon12, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        panelRound26Layout.setVerticalGroup(
            panelRound26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound26Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panelRound26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(sVGIcon12, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(sVGIcon16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelRound26Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        panelRound28.setBackground(new java.awt.Color(62, 172, 145));
        panelRound28.setRoundBottomLeft(35);
        panelRound28.setRoundBottomRight(35);
        panelRound28.setRoundTopLeft(35);
        panelRound28.setRoundTopRight(35);
        panelRound28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelRound28MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelRound28MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelRound28MouseExited(evt);
            }
        });

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setFont(new java.awt.Font("Poppins Light", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 0, 0));
        jLabel22.setText("Room  Facilites ");

        sVGIcon17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelRound28Layout = new javax.swing.GroupLayout(panelRound28);
        panelRound28.setLayout(panelRound28Layout);
        panelRound28Layout.setHorizontalGroup(
            panelRound28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound28Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(sVGIcon17, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(sVGIcon18, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        panelRound28Layout.setVerticalGroup(
            panelRound28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound28Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panelRound28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(sVGIcon18, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(sVGIcon17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelRound28Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelRound27Layout = new javax.swing.GroupLayout(panelRound27);
        panelRound27.setLayout(panelRound27Layout);
        panelRound27Layout.setHorizontalGroup(
            panelRound27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound27Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRound23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelRound27Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(panelRound24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRound25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRound26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRound28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelRound27Layout.setVerticalGroup(
            panelRound27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound27Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(panelRound23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRound24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRound25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRound26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRound28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        panelRound29.setBackground(new java.awt.Color(32, 48, 47));
        panelRound29.setRoundBottomLeft(20);
        panelRound29.setRoundBottomRight(20);
        panelRound29.setRoundTopLeft(20);
        panelRound29.setRoundTopRight(20);

        jLabel23.setBackground(new java.awt.Color(255, 255, 255));
        jLabel23.setFont(new java.awt.Font("Poppins Light", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Cab");

        panelRound30.setBackground(new java.awt.Color(62, 172, 145));
        panelRound30.setRoundBottomLeft(35);
        panelRound30.setRoundBottomRight(35);
        panelRound30.setRoundTopLeft(35);
        panelRound30.setRoundTopRight(35);
        panelRound30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelRound30MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelRound30MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelRound30MouseExited(evt);
            }
        });

        jLabel24.setBackground(new java.awt.Color(255, 255, 255));
        jLabel24.setFont(new java.awt.Font("Poppins Light", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 0, 0));
        jLabel24.setText("Cab Book");

        sVGIcon19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelRound30Layout = new javax.swing.GroupLayout(panelRound30);
        panelRound30.setLayout(panelRound30Layout);
        panelRound30Layout.setHorizontalGroup(
            panelRound30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound30Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(sVGIcon19, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sVGIcon20, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        panelRound30Layout.setVerticalGroup(
            panelRound30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound30Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panelRound30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(sVGIcon20, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(sVGIcon19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelRound30Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        panelRound31.setBackground(new java.awt.Color(62, 172, 145));
        panelRound31.setRoundBottomLeft(35);
        panelRound31.setRoundBottomRight(35);
        panelRound31.setRoundTopLeft(35);
        panelRound31.setRoundTopRight(35);
        panelRound31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelRound31MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelRound31MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelRound31MouseExited(evt);
            }
        });

        jLabel25.setBackground(new java.awt.Color(255, 255, 255));
        jLabel25.setFont(new java.awt.Font("Poppins Light", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 0, 0));
        jLabel25.setText("Cab List");

        sVGIcon21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelRound31Layout = new javax.swing.GroupLayout(panelRound31);
        panelRound31.setLayout(panelRound31Layout);
        panelRound31Layout.setHorizontalGroup(
            panelRound31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound31Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(sVGIcon21, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sVGIcon22, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        panelRound31Layout.setVerticalGroup(
            panelRound31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound31Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panelRound31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(sVGIcon22, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(sVGIcon21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelRound31Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelRound29Layout = new javax.swing.GroupLayout(panelRound29);
        panelRound29.setLayout(panelRound29Layout);
        panelRound29Layout.setHorizontalGroup(
            panelRound29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound29Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRound30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelRound29Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(panelRound31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelRound29Layout.setVerticalGroup(
            panelRound29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound29Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRound30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRound31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        panelRound32.setBackground(new java.awt.Color(32, 48, 47));
        panelRound32.setRoundBottomLeft(20);
        panelRound32.setRoundBottomRight(20);
        panelRound32.setRoundTopLeft(20);
        panelRound32.setRoundTopRight(20);

        jLabel26.setBackground(new java.awt.Color(255, 255, 255));
        jLabel26.setFont(new java.awt.Font("Poppins Light", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Items");

        panelRound33.setBackground(new java.awt.Color(62, 172, 145));
        panelRound33.setRoundBottomLeft(35);
        panelRound33.setRoundBottomRight(35);
        panelRound33.setRoundTopLeft(35);
        panelRound33.setRoundTopRight(35);
        panelRound33.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelRound33MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelRound33MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelRound33MouseExited(evt);
            }
        });

        jLabel27.setBackground(new java.awt.Color(255, 255, 255));
        jLabel27.setFont(new java.awt.Font("Poppins Light", 1, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 0, 0));
        jLabel27.setText("Items Manage");

        sVGIcon23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelRound33Layout = new javax.swing.GroupLayout(panelRound33);
        panelRound33.setLayout(panelRound33Layout);
        panelRound33Layout.setHorizontalGroup(
            panelRound33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound33Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(sVGIcon23, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sVGIcon24, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        panelRound33Layout.setVerticalGroup(
            panelRound33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound33Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panelRound33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(sVGIcon24, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(sVGIcon23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelRound33Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        panelRound66.setBackground(new java.awt.Color(62, 172, 145));
        panelRound66.setRoundBottomLeft(35);
        panelRound66.setRoundBottomRight(35);
        panelRound66.setRoundTopLeft(35);
        panelRound66.setRoundTopRight(35);
        panelRound66.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelRound66MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelRound66MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelRound66MouseExited(evt);
            }
        });

        jLabel67.setBackground(new java.awt.Color(255, 255, 255));
        jLabel67.setFont(new java.awt.Font("Poppins Light", 1, 18)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(0, 0, 0));
        jLabel67.setText("Reports");

        sVGIcon40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelRound66Layout = new javax.swing.GroupLayout(panelRound66);
        panelRound66.setLayout(panelRound66Layout);
        panelRound66Layout.setHorizontalGroup(
            panelRound66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound66Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(sVGIcon40, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sVGIcon41, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        panelRound66Layout.setVerticalGroup(
            panelRound66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound66Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panelRound66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(sVGIcon41, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(sVGIcon40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelRound66Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelRound32Layout = new javax.swing.GroupLayout(panelRound32);
        panelRound32.setLayout(panelRound32Layout);
        panelRound32Layout.setHorizontalGroup(
            panelRound32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound32Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRound33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelRound32Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(panelRound66, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelRound32Layout.setVerticalGroup(
            panelRound32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound32Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRound33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRound66, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelRound34.setBackground(new java.awt.Color(32, 48, 47));
        panelRound34.setRoundBottomLeft(20);
        panelRound34.setRoundBottomRight(20);
        panelRound34.setRoundTopLeft(20);
        panelRound34.setRoundTopRight(20);

        panelRound35.setBackground(new java.awt.Color(62, 172, 145));
        panelRound35.setRoundBottomLeft(35);
        panelRound35.setRoundBottomRight(35);
        panelRound35.setRoundTopLeft(35);
        panelRound35.setRoundTopRight(35);
        panelRound35.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelRound35MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelRound35MouseExited(evt);
            }
        });

        jLabel29.setBackground(new java.awt.Color(255, 255, 255));
        jLabel29.setFont(new java.awt.Font("Poppins Light", 1, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(0, 0, 0));
        jLabel29.setText("Personalised");

        sVGIcon25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelRound35Layout = new javax.swing.GroupLayout(panelRound35);
        panelRound35.setLayout(panelRound35Layout);
        panelRound35Layout.setHorizontalGroup(
            panelRound35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound35Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(sVGIcon25, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sVGIcon26, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        panelRound35Layout.setVerticalGroup(
            panelRound35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound35Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panelRound35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(sVGIcon26, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(sVGIcon25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(panelRound35Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelRound34Layout = new javax.swing.GroupLayout(panelRound34);
        panelRound34.setLayout(panelRound34Layout);
        panelRound34Layout.setHorizontalGroup(
            panelRound34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound34Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelRound35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelRound34Layout.setVerticalGroup(
            panelRound34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound34Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(panelRound35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        panelRound40.setBackground(new java.awt.Color(32, 48, 47));
        panelRound40.setRoundBottomLeft(20);
        panelRound40.setRoundBottomRight(20);
        panelRound40.setRoundTopLeft(20);
        panelRound40.setRoundTopRight(20);

        jLabel34.setBackground(new java.awt.Color(255, 255, 255));
        jLabel34.setFont(new java.awt.Font("Poppins Light", 1, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("House Keeping");

        panelRound41.setBackground(new java.awt.Color(62, 172, 145));
        panelRound41.setRoundBottomLeft(35);
        panelRound41.setRoundBottomRight(35);
        panelRound41.setRoundTopLeft(35);
        panelRound41.setRoundTopRight(35);
        panelRound41.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelRound41MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelRound41MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelRound41MouseExited(evt);
            }
        });

        jLabel35.setBackground(new java.awt.Color(255, 255, 255));
        jLabel35.setFont(new java.awt.Font("Poppins Light", 1, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(0, 0, 0));
        jLabel35.setText("Assign House Keeping");

        sVGIcon31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelRound41Layout = new javax.swing.GroupLayout(panelRound41);
        panelRound41.setLayout(panelRound41Layout);
        panelRound41Layout.setHorizontalGroup(
            panelRound41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound41Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(sVGIcon31, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 240, Short.MAX_VALUE)
                .addComponent(sVGIcon32, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        panelRound41Layout.setVerticalGroup(
            panelRound41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound41Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panelRound41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(sVGIcon32, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(sVGIcon31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelRound41Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelRound40Layout = new javax.swing.GroupLayout(panelRound40);
        panelRound40.setLayout(panelRound40Layout);
        panelRound40Layout.setHorizontalGroup(
            panelRound40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound40Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRound41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelRound40Layout.createSequentialGroup()
                        .addComponent(jLabel34)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelRound40Layout.setVerticalGroup(
            panelRound40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound40Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRound41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelRound12Layout = new javax.swing.GroupLayout(panelRound12);
        panelRound12.setLayout(panelRound12Layout);
        panelRound12Layout.setHorizontalGroup(
            panelRound12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound12Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(panelRound12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRound32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelRound12Layout.createSequentialGroup()
                        .addComponent(panelRound27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelRound12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelRound29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelRound34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelRound40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        panelRound12Layout.setVerticalGroup(
            panelRound12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound12Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(panelRound12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRound27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelRound12Layout.createSequentialGroup()
                        .addComponent(panelRound29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelRound40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelRound34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelRound32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
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
        // chart2
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
        startCounterAnimation();
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
        startCounterAnimation();
    }//GEN-LAST:event_sVGIcon8MouseClicked

    private void sVGIcon8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sVGIcon8MouseEntered
        panelRound21.setBackground(Color.decode("#3EAC91"));
        panelRound21.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_sVGIcon8MouseEntered

    private void sVGIcon8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sVGIcon8MouseExited
        panelRound21.setBackground(new Color(32, 48, 47));
    }//GEN-LAST:event_sVGIcon8MouseExited

    private void panelRound24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound24MouseClicked
        Room_List list = new Room_List(this, true);
        list.setVisible(true);

    }//GEN-LAST:event_panelRound24MouseClicked

    private void panelRound25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound25MouseClicked
        Room_Status room_Status = new Room_Status(this, true);
        room_Status.setVisible(true);
    }//GEN-LAST:event_panelRound25MouseClicked

    private void panelRound23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound23MouseClicked
        Room_Book book = new Room_Book(this, true);
        book.setVisible(true);
    }//GEN-LAST:event_panelRound23MouseClicked

    private void panelRound23MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound23MouseEntered

        panelRound23.setBackground(new Color(219, 253, 130));
        panelRound23.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_panelRound23MouseEntered

    private void panelRound23MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound23MouseExited
        panelRound23.setBackground(new Color(62, 172, 145));
    }//GEN-LAST:event_panelRound23MouseExited

    private void panelRound24MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound24MouseEntered
        panelRound24.setBackground(new Color(219, 253, 130));
        panelRound24.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_panelRound24MouseEntered

    private void panelRound24MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound24MouseExited
        panelRound24.setBackground(new Color(62, 172, 145));
    }//GEN-LAST:event_panelRound24MouseExited

    private void panelRound25MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound25MouseEntered
        panelRound25.setBackground(new Color(219, 253, 130));
        panelRound25.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_panelRound25MouseEntered

    private void panelRound26MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound26MouseEntered
        panelRound26.setBackground(new Color(219, 253, 130));
        panelRound26.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_panelRound26MouseEntered

    private void panelRound28MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound28MouseEntered
        panelRound28.setBackground(new Color(219, 253, 130));
        panelRound28.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_panelRound28MouseEntered

    private void panelRound30MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound30MouseEntered
        panelRound30.setBackground(new Color(219, 253, 130));
        panelRound30.setCursor(new Cursor(Cursor.HAND_CURSOR));

    }//GEN-LAST:event_panelRound30MouseEntered

    private void panelRound31MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound31MouseEntered
        panelRound31.setBackground(new Color(219, 253, 130));
        panelRound31.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_panelRound31MouseEntered

    private void panelRound41MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound41MouseClicked
        Assign_House_Keeping ahk = new Assign_House_Keeping(this, true);
        ahk.setVisible(true);
    }//GEN-LAST:event_panelRound41MouseClicked

    private void panelRound41MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound41MouseEntered
        panelRound41.setBackground(new Color(219, 253, 130));
        panelRound41.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_panelRound41MouseEntered

    private void panelRound35MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound35MouseEntered
        panelRound35.setBackground(new Color(219, 253, 130));
        panelRound35.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_panelRound35MouseEntered

    private void panelRound33MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound33MouseEntered
        panelRound33.setBackground(new Color(219, 253, 130));
        panelRound33.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_panelRound33MouseEntered

    private void panelRound25MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound25MouseExited
        panelRound25.setBackground(new Color(62, 172, 145));
    }//GEN-LAST:event_panelRound25MouseExited

    private void panelRound26MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound26MouseExited
        panelRound26.setBackground(new Color(62, 172, 145));
    }//GEN-LAST:event_panelRound26MouseExited

    private void panelRound28MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound28MouseExited
        panelRound28.setBackground(new Color(62, 172, 145));
    }//GEN-LAST:event_panelRound28MouseExited

    private void panelRound33MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound33MouseExited
        panelRound33.setBackground(new Color(62, 172, 145));
    }//GEN-LAST:event_panelRound33MouseExited

    private void panelRound30MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound30MouseExited
        panelRound30.setBackground(new Color(62, 172, 145));
    }//GEN-LAST:event_panelRound30MouseExited

    private void panelRound31MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound31MouseExited
        panelRound31.setBackground(new Color(62, 172, 145));
    }//GEN-LAST:event_panelRound31MouseExited

    private void panelRound41MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound41MouseExited
        panelRound41.setBackground(new Color(62, 172, 145));
    }//GEN-LAST:event_panelRound41MouseExited

    private void panelRound35MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound35MouseExited
        panelRound35.setBackground(new Color(62, 172, 145));
    }//GEN-LAST:event_panelRound35MouseExited

    private void panelRound31MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound31MouseClicked
        Cab_List cab_List = new Cab_List(this, true);
        cab_List.setVisible(true);
    }//GEN-LAST:event_panelRound31MouseClicked

    private void panelRound30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound30MouseClicked
        Cab_Booking booking = new Cab_Booking(this, true);
        booking.setVisible(true);
    }//GEN-LAST:event_panelRound30MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        Assign_House_Keeping ahk = new Assign_House_Keeping(this, true);
        ahk.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void chart1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_chart1AncestorAdded

    }//GEN-LAST:event_chart1AncestorAdded

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        Room_Book book = new Room_Book(this, true);
        book.setVisible(true);
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        Room_Status room_Status = new Room_Status(this, true);
        room_Status.setVisible(true);
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseClicked
        Add_Cab_Booking acb = new Add_Cab_Booking(this, true);
        acb.setVisible(true);
    }//GEN-LAST:event_jButton9MouseClicked

    private void jButton10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton10MouseClicked
        Book_Cab bc = new Book_Cab(this, true);
        bc.setVisible(true);
    }//GEN-LAST:event_jButton10MouseClicked

    private void panelRound46MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound46MouseClicked
        AddBill ab = new AddBill(this, true);
        ab.setVisible(true);
        LoadTransactionDetails();
    }//GEN-LAST:event_panelRound46MouseClicked

    private void panelRound28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound28MouseClicked
        Room_Facilites_List facilites_List = new Room_Facilites_List(this, true);
        facilites_List.setVisible(true);
    }//GEN-LAST:event_panelRound28MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        Check_Out check_Out = new Check_Out(this, true);
        check_Out.setVisible(true);
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        Add_Facilites add_Facilites = new Add_Facilites(this, true);
        add_Facilites.setVisible(true);
        LoadRoomFacilitiesDetails();
    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Room_Size_List list = new Room_Size_List(this, true);
        list.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void panelRound51MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound51MouseEntered
        panelRound51.setBackground(new Color(125, 120, 210));
    }//GEN-LAST:event_panelRound51MouseEntered

    private void panelRound53MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound53MouseEntered
        panelRound53.setBackground(new Color(125, 120, 210));
    }//GEN-LAST:event_panelRound53MouseEntered

    private void panelRound53MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound53MouseExited
        panelRound53.setBackground(new Color(139, 121, 241));
    }//GEN-LAST:event_panelRound53MouseExited

    private void panelRound51MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound51MouseExited
        panelRound51.setBackground(new Color(139, 121, 241));
    }//GEN-LAST:event_panelRound51MouseExited

    private void panelRound54MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound54MouseEntered
        panelRound54.setBackground(new Color(125, 120, 210));
    }//GEN-LAST:event_panelRound54MouseEntered

    private void panelRound54MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound54MouseExited
        panelRound54.setBackground(new Color(139, 121, 241));
    }//GEN-LAST:event_panelRound54MouseExited

    private void panelRound55MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound55MouseEntered
        panelRound55.setBackground(new Color(125, 120, 210));
    }//GEN-LAST:event_panelRound55MouseEntered

    private void panelRound55MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound55MouseExited
        panelRound55.setBackground(new Color(139, 121, 241));
    }//GEN-LAST:event_panelRound55MouseExited

    private void panelRound56MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound56MouseEntered
        panelRound56.setBackground(new Color(125, 120, 210));
    }//GEN-LAST:event_panelRound56MouseEntered

    private void panelRound56MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound56MouseExited
        panelRound56.setBackground(new Color(139, 121, 241));
    }//GEN-LAST:event_panelRound56MouseExited

    private void panelRound57MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound57MouseEntered
        panelRound57.setBackground(new Color(125, 120, 210));
    }//GEN-LAST:event_panelRound57MouseEntered

    private void panelRound57MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound57MouseExited
        panelRound57.setBackground(new Color(139, 121, 241));
    }//GEN-LAST:event_panelRound57MouseExited

    private void panelRound58MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound58MouseEntered
        panelRound58.setBackground(new Color(125, 120, 210));
    }//GEN-LAST:event_panelRound58MouseEntered

    private void panelRound58MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound58MouseExited
        panelRound58.setBackground(new Color(139, 121, 241));
    }//GEN-LAST:event_panelRound58MouseExited

    private void panelRound59MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound59MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_panelRound59MouseEntered

    private void panelRound59MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound59MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_panelRound59MouseExited

    private void panelRound60MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound60MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_panelRound60MouseEntered

    private void panelRound60MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound60MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_panelRound60MouseExited

    private void panelRound61MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound61MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_panelRound61MouseEntered

    private void panelRound61MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound61MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_panelRound61MouseExited

    private void panelRound51MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound51MouseClicked
        Departments d = new Departments(this, true);
        d.setVisible(true);
    }//GEN-LAST:event_panelRound51MouseClicked

    private void panelRound53MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound53MouseClicked
        AllEmployee ae = new AllEmployee(this, true);
        ae.setVisible(true);

    }//GEN-LAST:event_panelRound53MouseClicked

    private void panelRound54MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound54MouseClicked
        Leave_Request leave_Request = new Leave_Request(this, true);
        leave_Request.setVisible(true);
    }//GEN-LAST:event_panelRound54MouseClicked

    private void panelRound55MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound55MouseClicked
        Attendances a = new Attendances(this, true);
        a.setVisible(true);
    }//GEN-LAST:event_panelRound55MouseClicked

    private void panelRound58MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound58MouseClicked
        Add_Employee add_Employee = new Add_Employee(this, true);
        add_Employee.setVisible(true);
    }//GEN-LAST:event_panelRound58MouseClicked

    private void panelRound66MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound66MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_panelRound66MouseEntered

    private void panelRound66MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound66MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_panelRound66MouseExited

    private void panelRound66MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound66MouseClicked
        Reports r = new Reports(this, true);
        r.setVisible(true);
    }//GEN-LAST:event_panelRound66MouseClicked

    private void panelRound59MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound59MouseClicked
        Employee_Salary employee_Salary = new Employee_Salary(this, true);
        employee_Salary.setVisible(true);
    }//GEN-LAST:event_panelRound59MouseClicked

    private void panelRound33MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound33MouseClicked
        Items_List il = new Items_List(null, true);
        il.setVisible(true);
    }//GEN-LAST:event_panelRound33MouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Exit", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                Mysql2.miud("UPDATE user_logs SET logout_time = NOW() WHERE email = '" + currentUserEmail + "' ORDER BY id DESC LIMIT 1");
            } catch (Exception ex) {
                Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.exit(0);
        }
    }//GEN-LAST:event_formWindowClosing

    private void panelRound67MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound67MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_panelRound67MouseEntered

    private void panelRound67MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound67MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_panelRound67MouseExited

    private void jLabel68MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel68MouseClicked
        Pay_salary p = new Pay_salary(null, true);
        p.setVisible(true);
    }//GEN-LAST:event_jLabel68MouseClicked

    private void jLabel57MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel57MouseClicked
        PaysliprReport paysliprReport = new PaysliprReport(null, true);
        paysliprReport.setVisible(true);
    }//GEN-LAST:event_jLabel57MouseClicked

    private void LoardTotalBppking() {
        try {
            ResultSet resultSet = Mysql2.msearch("SELECT COUNT(*) FROM reservation_details");
            if (resultSet.next()) {
                String totalbookingcount = String.valueOf(resultSet.getString("COUNT(*)"));
                jLabel5.setText(totalbookingcount);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void LoardTotalAmount() {
        try {
            ResultSet resultSet = Mysql2.msearch("SELECT SUM(advance_amount) FROM payment_details");
            if (resultSet.next()) {
                String totalbookingcount = String.valueOf(resultSet.getString("SUM(advance_amount)"));
                jLabel6.setText(totalbookingcount);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void LoardgUESTcOUNT() {
        try {
            ResultSet resultSet = Mysql2.msearch("SELECT COUNT(*) FROM guest_details");
            if (resultSet.next()) {
                String totalbookingcount = String.valueOf(resultSet.getString("COUNT(*)"));
                jLabel7.setText(totalbookingcount);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void LoardToatalrevenue() {
        try {
            ResultSet resultSet = Mysql2.msearch("SELECT SUM(TotalAmount) FROM check_out");
            if (resultSet.next()) {
                String totalbookingcount = String.valueOf(resultSet.getString("SUM(TotalAmount)"));
                jLabel8.setText(totalbookingcount);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void LoardToatalTransacione() {
        try {
            ResultSet resultSet = Mysql2.msearch("SELECT SUM(`price`) FROM `transaction`");
            if (resultSet.next()) {
                String totalbookingcount = String.valueOf(resultSet.getString("SUM(`price`)"));
                jLabel33.setText(totalbookingcount);
                jLabel51.setText(totalbookingcount);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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
    private com.raven.chart.Chart chart1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTable jTable7;
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
    private test.PanelRound panelRound23;
    private test.PanelRound panelRound24;
    private test.PanelRound panelRound25;
    private test.PanelRound panelRound26;
    private test.PanelRound panelRound27;
    private test.PanelRound panelRound28;
    private test.PanelRound panelRound29;
    private test.PanelRound panelRound3;
    private test.PanelRound panelRound30;
    private test.PanelRound panelRound31;
    private test.PanelRound panelRound32;
    private test.PanelRound panelRound33;
    private test.PanelRound panelRound34;
    private test.PanelRound panelRound35;
    private test.PanelRound panelRound36;
    private test.PanelRound panelRound37;
    private test.PanelRound panelRound38;
    private test.PanelRound panelRound39;
    private test.PanelRound panelRound4;
    private test.PanelRound panelRound40;
    private test.PanelRound panelRound41;
    private test.PanelRound panelRound42;
    private test.PanelRound panelRound43;
    private test.PanelRound panelRound44;
    private test.PanelRound panelRound46;
    private test.PanelRound panelRound47;
    private test.PanelRound panelRound48;
    private test.PanelRound panelRound49;
    private test.PanelRound panelRound5;
    private test.PanelRound panelRound50;
    private test.PanelRound panelRound51;
    private test.PanelRound panelRound52;
    private test.PanelRound panelRound53;
    private test.PanelRound panelRound54;
    private test.PanelRound panelRound55;
    private test.PanelRound panelRound56;
    private test.PanelRound panelRound57;
    private test.PanelRound panelRound58;
    private test.PanelRound panelRound59;
    private test.PanelRound panelRound6;
    private test.PanelRound panelRound60;
    private test.PanelRound panelRound61;
    private test.PanelRound panelRound62;
    private test.PanelRound panelRound63;
    private test.PanelRound panelRound64;
    private test.PanelRound panelRound65;
    private test.PanelRound panelRound66;
    private test.PanelRound panelRound67;
    private test.PanelRound panelRound7;
    private test.PanelRound panelRound8;
    private test.PanelRound panelRound9;
    private svg.SVGIcon sVGIcon1;
    private svg.SVGIcon sVGIcon10;
    private svg.SVGIcon sVGIcon11;
    private svg.SVGIcon sVGIcon12;
    private model.SVGIcon sVGIcon13;
    private model.SVGIcon sVGIcon14;
    private model.SVGIcon sVGIcon15;
    private model.SVGIcon sVGIcon16;
    private model.SVGIcon sVGIcon17;
    private svg.SVGIcon sVGIcon18;
    private model.SVGIcon sVGIcon19;
    private svg.SVGIcon sVGIcon2;
    private svg.SVGIcon sVGIcon20;
    private model.SVGIcon sVGIcon21;
    private svg.SVGIcon sVGIcon22;
    private model.SVGIcon sVGIcon23;
    private svg.SVGIcon sVGIcon24;
    private model.SVGIcon sVGIcon25;
    private svg.SVGIcon sVGIcon26;
    private svg.SVGIcon sVGIcon27;
    private svg.SVGIcon sVGIcon28;
    private svg.SVGIcon sVGIcon29;
    private svg.SVGIcon sVGIcon3;
    private svg.SVGIcon sVGIcon30;
    private model.SVGIcon sVGIcon31;
    private svg.SVGIcon sVGIcon32;
    private svg.SVGIcon sVGIcon33;
    private svg.SVGIcon sVGIcon34;
    private svg.SVGIcon sVGIcon35;
    private svg.SVGIcon sVGIcon36;
    private svg.SVGIcon sVGIcon37;
    private svg.SVGIcon sVGIcon38;
    private svg.SVGIcon sVGIcon39;
    private svg.SVGIcon sVGIcon4;
    private model.SVGIcon sVGIcon40;
    private svg.SVGIcon sVGIcon41;
    private svg.SVGIcon sVGIcon5;
    private svg.SVGIcon sVGIcon6;
    private svg.SVGIcon sVGIcon7;
    private svg.SVGIcon sVGIcon8;
    private svg.SVGIcon sVGIcon9;
    // End of variables declaration//GEN-END:variables
}
