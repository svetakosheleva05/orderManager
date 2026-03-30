/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ordermanager;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author svetl
 */
public class MyFrame extends JFrame {

    private JTable orderTable;
    private DefaultTableModel tableModel;
    private List<JCheckBox> toppingCheckBoxes; 
    private static final int MAX_TOPPINGS = 3;
    
    public MyFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 500);
        setLocationRelativeTo(null);

        toppingCheckBoxes = new ArrayList<>();
        
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        String[] headers = {"Блюдо", "Цена", "Время заказа"};
        tableModel = new DefaultTableModel(headers, 0);
        orderTable = new JTable(tableModel);
        orderTable.setDefaultEditor(Object.class, null);
        JScrollPane scrollPane = new JScrollPane(orderTable);
        
        JPanel checkboxPanel = new JPanel();
        checkboxPanel.setLayout(new BoxLayout(checkboxPanel, BoxLayout.Y_AXIS));
        checkboxPanel.setBorder(BorderFactory.createTitledBorder("Добавки (макс. " + MAX_TOPPINGS + ")"));
        
        JCheckBox cb1 = new JCheckBox("Двойная оленина (20 руб.)");
        JCheckBox cb2 = new JCheckBox("Огненный соус (10 руб.)");
        JCheckBox cb3 = new JCheckBox("Нордская лепешка (7 руб.)");
        JCheckBox cb4 = new JCheckBox("Снежные ягоды (5 руб.)");
        
        toppingCheckBoxes.add(cb1);
        toppingCheckBoxes.add(cb2);
        toppingCheckBoxes.add(cb3);
        toppingCheckBoxes.add(cb4);
        
        ActionListener listener = e -> {
            int selected = 0;
            for (JCheckBox cb : toppingCheckBoxes) {
                if (cb.isSelected()) {
                    selected++;
                }
            }
            for (JCheckBox cb : toppingCheckBoxes) {
                if (selected >= MAX_TOPPINGS && !cb.isSelected()) {
                    cb.setEnabled(false);
                } else {
                    cb.setEnabled(true);
                }
            }
        };
        
        for (JCheckBox cb : toppingCheckBoxes) {
            cb.addActionListener(listener);
            checkboxPanel.add(cb);
        }
        
        JButton addButton = new JButton("Заказать");
        
        addButton.addActionListener(e -> {
            Dish currentDish = new VegetableStew();
            
            if (cb1.isSelected()) 
                currentDish = new DoubleVenison(currentDish);
            if (cb2.isSelected()) 
                currentDish = new FierySauce(currentDish);
            if (cb3.isSelected()) 
                currentDish = new NordicFlatbread(currentDish);
            if (cb4.isSelected()) 
                currentDish = new SnowBerries(currentDish);
            
            Date now = new Date();
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss dd.MM.yyyy");
            String timeString = timeFormat.format(now);
            
            tableModel.addRow(new Object[]{
                currentDish.getName(),  
                currentDish.getPrice(),  
                timeString               
            });
            
        });
        
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.add(addButton);
     
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(checkboxPanel, BorderLayout.EAST);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        
        add(mainPanel);
    }
}