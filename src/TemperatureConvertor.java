import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperatureConvertor extends JFrame implements ActionListener {

    JLabel from, to;
    Choice chFrom, chTo;
    JTextField input, output;
    JButton reset, convert;

    TemperatureConvertor() {

        from = new JLabel(" From");
        from.setBounds(50, 50, 40, 20);
        from.setOpaque(true);
        from.setBackground(Color.PINK);

        to = new JLabel(" To");
        to.setBounds(50, 80, 40, 20);
        to.setOpaque(true);
        to.setBackground(Color.ORANGE);

        chFrom = new Choice();
        chFrom.setBounds(100, 50, 100, 30);
        chFrom.setBackground(Color.PINK);
        chFrom.add("Celsius");
        chFrom.add("Farenheit");
        chFrom.add("Kelvin");

        chTo = new Choice();
        chTo.setBounds(100, 80, 100, 30);
        chTo.setBackground(Color.ORANGE);
        chTo.add("Celsius");
        chTo.add("Farenheit");
        chTo.add("Kelvin");

        input = new JTextField();
        input.setBounds(220, 50, 150, 20);
        input.setBackground(Color.PINK);

        output = new JTextField();
        output.setBounds(220, 80, 150, 20);
        output.setBackground(Color.ORANGE);

        reset = new JButton("Reset");
        reset.setBounds(110, 130, 80, 20);
        reset.setBackground(Color.CYAN);
        reset.addActionListener(this);

        convert = new JButton("Convert");
        convert.setBounds(220, 130, 80, 20);
        convert.setBackground(Color.GREEN);
        convert.addActionListener(this);

        add(from);
        add(to);
        add(chFrom);
        add(chTo);
        add(input);
        add(output);
        add(reset);
        add(convert);

        setTitle("Temperature Convertor");
        setLayout(null);
        setSize(500, 300);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == convert) {
            String selectedFrom = chFrom.getSelectedItem();
            String selectedTo = chTo.getSelectedItem();

            if (selectedFrom.equals("Celsius")) {
                float cel = 0;
                String strResult = "";
                switch (selectedTo) {
                    case "Celsius":
                        strResult = input.getText();
                        output.setText(strResult);
                        break;

                    case "Farenheit":
                        strResult = input.getText();
                        cel = Float.parseFloat(strResult);
                        float far = (cel * 9/5) + 32;
                        strResult = String.valueOf(far);
                        output.setText(strResult);
                        break;

                    case "Kelvin":
                        strResult = input.getText();
                        cel = Float.parseFloat(strResult);
                        float kelvin = cel + 273.15f;
                        strResult = String.valueOf(kelvin);
                        output.setText(strResult);
                        break;
                }
            } else if (selectedFrom.equals("Farenheit")) {
                float far = 0;
                String strResult = "";
                switch (selectedTo) {
                    case "Farenheit":
                        strResult = input.getText();
                        output.setText(strResult);
                        break;

                    case "Celsius":
                        far = Float.parseFloat(input.getText());
                        float cel = (far - 32) * 5 / 9;
                        strResult = String.valueOf(cel);
                        output.setText(strResult);
                        break;

                    case "Kelvin":
                        far = Float.parseFloat(input.getText());
                        float kelvin = (far - 32) * 5 / 9 + 273.15f;
                        strResult = String.valueOf(kelvin);
                        output.setText(strResult);
                        break;
                }
            } else {
                float kelvin = 0;
                String strResult = "";
                switch (selectedTo) {
                    case "Kelvin":
                        strResult = input.getText();
                        output.setText(strResult);
                        break;

                    case "Celsius":
                        kelvin = Float.parseFloat(input.getText());
                        float cel = kelvin - 273.15f;
                        strResult = String.valueOf(cel);
                        output.setText(strResult);
                        break;

                    case "Farenheit":
                        kelvin = Float.parseFloat(input.getText());
                        float far = (kelvin - 273.15f) * 9 / 5 + 32;
                        strResult = String.valueOf(far);
                        output.setText(strResult);
                        break;
                }
            }
        } else if (e.getSource() == reset) {
            input.setText("");
            output.setText("");
        }

    }
}