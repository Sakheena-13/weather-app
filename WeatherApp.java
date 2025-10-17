import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import org.json.*;

public class WeatherApp extends JFrame implements ActionListener {

    private JTextField cityField;
    private JButton getWeatherButton;
    private JTextArea resultArea;
    private final String API_KEY = "YOUR_API_KEY_HERE";

    public WeatherApp() {
        setTitle("Weather App");
        setSize(400, 300);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        cityField = new JTextField(15);
        getWeatherButton = new JButton("Get Weather");
        getWeatherButton.addActionListener(this);

        panel.add(new JLabel("City: "));
        panel.add(cityField);
        panel.add(getWeatherButton);

        add(panel, BorderLayout.NORTH);

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        add(new JScrollPane(resultArea), BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String city = cityField.getText().trim();
        if(!city.isEmpty()) {
            try {
                String response = getWeatherData(city);
                parseAndDisplay(response);
            } catch(Exception ex) {
                resultArea.setText("Error fetching weather data.");
            }
        } else {
            resultArea.setText("Please enter a city name.");
        }
    }

    private String getWeatherData(String city) throws IOException {
        String urlString = "https://api.openweathermap.org/data/2.5/weather?q=" +
                URLEncoder.encode(city, "UTF-8") + "&appid=" + API_KEY + "&units=metric";
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String line;
        while((line = reader.readLine()) != null) {
            sb.append(line);
        }
        reader.close();
        return sb.toString();
    }

    private void parseAndDisplay(String json) {
        JSONObject obj = new JSONObject(json);
        String name = obj.getString("name");
        JSONObject main = obj.getJSONObject("main");
        double temp = main.getDouble("temp");
        int humidity = main.getInt("humidity");
        String weatherDesc = obj.getJSONArray("weather").getJSONObject(0).getString("description");

        resultArea.setText("City: " + name + "\nTemperature: " + temp + "°C" +
                "\nHumidity: " + humidity + "%" + "\nWeather: " + weatherDesc);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new WeatherApp().setVisible(true);
        });
    }
}
