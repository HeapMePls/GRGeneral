package com.GRG.client;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class Controller {

    public static String urlserver = "http://localhost:8080";

    @FXML
    private Button test1Open;
    @FXML
    private AnchorPane paneStart;
    @FXML
    private AnchorPane paneMain;
    @FXML
    private AnchorPane paneTest1;
    @FXML
    private AnchorPane paneTest2;
    @FXML
    private AnchorPane paneSettings;

    // Test 1
    @FXML
    private AnchorPane resultTest1Pane;
    @FXML
    private AnchorPane errPaneTest1;
    @FXML
    private TextField test1UserValue;
    @FXML
    private ImageView test1ArrowB;
    @FXML
    private ImageView test1ArrowM;
    @FXML
    private ImageView test1ArrowG;
    @FXML
    private Text test1NA;
    @FXML
    private SplitMenuButton test1Category;
    @FXML
    private SplitMenuButton test1Property;
    @FXML
    private ToggleGroup properties;
    @FXML
    private ToggleGroup categories;
    @FXML
    private ToggleGroup properties1;
    @FXML
    private ToggleGroup categories1;
    @FXML
    private Text test1PoorValue;
    @FXML
    private Text test1GoodValue;

    // Test 2

    // Settings
    @FXML
    private TextField settingsTest1VCField1;
    @FXML
    private TextField settingsTest1VCField2;
    @FXML
    private Button settingsTest1VCApply;
    @FXML
    private Button settingsTest1VCReset;
    @FXML
    private Text test1LastUpdate;

    // Navigation
    public void openMainPaneWithSync(MouseEvent evt) {
        paneStart.setVisible(false);
        paneMain.setVisible(true);
        paneTest1.setVisible(false);
        paneTest2.setVisible(false);
        paneSettings.setVisible(false);
        resultTest1Pane.setVisible(false);

        try {
            readSettings();
        } catch (Exception e) {
            System.out.println("Wrong file.");
        }
    }

    public void openMainPane(MouseEvent evt) {
        paneStart.setVisible(false);
        paneMain.setVisible(true);
        paneTest1.setVisible(false);
        paneTest2.setVisible(false);
        paneSettings.setVisible(false);
        resultTest1Pane.setVisible(false);

    }

    public void openTest1(MouseEvent evt) {
        paneStart.setVisible(false);
        paneMain.setVisible(false);
        paneTest1.setVisible(true);
        paneTest2.setVisible(false);
        paneSettings.setVisible(false);
        resultTest1Pane.setVisible(false);
        test1UserValue.setText(null);
    }

    public void openTest2(MouseEvent evt) {
        paneStart.setVisible(false);
        paneMain.setVisible(false);
        paneTest1.setVisible(false);
        paneTest2.setVisible(true);
        paneSettings.setVisible(false);
    }

    public void openSettings(MouseEvent evt) {
        paneStart.setVisible(false);
        paneMain.setVisible(false);
        paneTest1.setVisible(false);
        paneTest2.setVisible(false);
        paneSettings.setVisible(true);

        test1LastUpdate.setText(lastEdited.format(formatter));
    }


    // Test 1

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    LocalDate lastEdited;

    public void readSettings() throws IOException {
        InputStream inputStream = null;

        try {
            Properties prop = new Properties();
            inputStream = getClass().getClassLoader().getResourceAsStream("values.properties");
            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR,"Archivo propiedades no encontrado.",ButtonType.OK);
                alert.show();
                throw new FileNotFoundException("Unable to locate/read file. Not found in the classpath");
            }

            lastEdited = LocalDate.parse(prop.getProperty("lastupdated"),formatter);

            volt_O_bm = prop.getProperty("volt_O_bm");
            volt_O_mg = prop.getProperty("volt_O_mg");
            volt_A_bm = prop.getProperty("volt_A_bm");
            volt_A_mg = prop.getProperty("volt_A_mg");
            volt_B_bm = prop.getProperty("volt_B_bm");
            volt_B_mg = prop.getProperty("volt_B_mg");
            volt_C_bm = prop.getProperty("volt_C_bm");
            volt_C_mg = prop.getProperty("volt_C_mg");
            volt_D_bm = prop.getProperty("volt_D_bm");
            volt_D_mg = prop.getProperty("volt_D_mg");
            volt_E_bm = prop.getProperty("volt_E_bm");
            volt_E_mg = prop.getProperty("volt_E_mg");
            volt_F_bm = prop.getProperty("volt_F_bm");
            volt_F_mg = prop.getProperty("volt_F_mg");
            volt_G_bm = prop.getProperty("volt_G_bm");
            volt_G_mg = prop.getProperty("volt_G_mg");

            wc_O_bm = prop.getProperty("wc_O_bm");
            wc_O_mg = prop.getProperty("wc_O_mg");
            wc_A_bm = prop.getProperty("wc_A_bm");
            wc_A_mg = prop.getProperty("wc_A_mg");
            wc_B_bm = prop.getProperty("wc_B_bm");
            wc_B_mg = prop.getProperty("wc_B_mg");
            wc_C_bm = prop.getProperty("wc_C_bm");
            wc_C_mg = prop.getProperty("wc_C_mg");
            wc_D_bm = prop.getProperty("wc_D_bm");
            wc_D_mg = prop.getProperty("wc_D_mg");
            wc_E_bm = prop.getProperty("wc_E_bm");
            wc_E_mg = prop.getProperty("wc_E_mg");
            wc_F_bm = prop.getProperty("wc_F_bm");
            wc_F_mg = prop.getProperty("wc_F_mg");
            wc_G_bm = prop.getProperty("wc_G_bm");
            wc_G_mg = prop.getProperty("wc_G_mg");

            acid_O_bm = prop.getProperty("acid_O_bm");
            acid_O_mg = prop.getProperty("acid_O_mg");
            acid_A_bm = prop.getProperty("acid_A_bm");
            acid_A_mg = prop.getProperty("acid_A_mg");
            acid_B_bm = prop.getProperty("acid_B_bm");
            acid_B_mg = prop.getProperty("acid_B_mg");
            acid_C_bm = prop.getProperty("acid_C_bm");
            acid_C_mg = prop.getProperty("acid_C_mg");
            acid_D_bm = prop.getProperty("acid_D_bm");
            acid_D_mg = prop.getProperty("acid_D_mg");
            acid_E_bm = prop.getProperty("acid_E_bm");
            acid_E_mg = prop.getProperty("acid_E_mg");
            acid_F_bm = prop.getProperty("acid_F_bm");
            acid_F_mg = prop.getProperty("acid_F_mg");
            acid_G_bm = prop.getProperty("acid_G_bm");
            acid_G_mg = prop.getProperty("acid_G_mg");

            diel_O_bm = prop.getProperty("diel_O_bm");
            diel_O_mg = prop.getProperty("diel_O_mg");
            diel_A_bm = prop.getProperty("diel_A_bm");
            diel_A_mg = prop.getProperty("diel_A_mg");
            diel_B_bm = prop.getProperty("diel_B_bm");
            diel_B_mg = prop.getProperty("diel_B_mg");
            diel_C_bm = prop.getProperty("diel_C_bm");
            diel_C_mg = prop.getProperty("diel_C_mg");
            diel_D_bm = prop.getProperty("diel_D_bm");
            diel_D_mg = prop.getProperty("diel_D_mg");
            diel_E_bm = prop.getProperty("diel_E_bm");
            diel_E_mg = prop.getProperty("diel_E_mg");
            diel_F_bm = prop.getProperty("diel_F_bm");
            diel_F_mg = prop.getProperty("diel_F_mg");
            diel_G_bm = prop.getProperty("diel_G_bm");
            diel_G_mg = prop.getProperty("diel_G_mg");

            resist20C_O_bm = prop.getProperty("resist20C_O_bm");
            resist20C_O_mg = prop.getProperty("resist20C_O_mg");
            resist20C_A_bm = prop.getProperty("resist20C_A_bm");
            resist20C_A_mg = prop.getProperty("resist20C_A_mg");
            resist20C_B_bm = prop.getProperty("resist20C_B_bm");
            resist20C_B_mg = prop.getProperty("resist20C_B_mg");
            resist20C_C_bm = prop.getProperty("resist20C_C_bm");
            resist20C_C_mg = prop.getProperty("resist20C_C_mg");
            resist20C_D_bm = prop.getProperty("resist20C_D_bm");
            resist20C_D_mg = prop.getProperty("resist20C_D_mg");
            resist20C_E_bm = prop.getProperty("resist20C_E_bm");
            resist20C_E_mg = prop.getProperty("resist20C_E_mg");
            resist20C_F_bm = prop.getProperty("resist20C_F_bm");
            resist20C_F_mg = prop.getProperty("resist20C_F_mg");
            resist20C_G_bm = prop.getProperty("resist20C_G_bm");
            resist20C_G_mg = prop.getProperty("resist20C_G_mg");

            resist90C_O_bm = prop.getProperty("resist90C_O_bm");
            resist90C_O_mg = prop.getProperty("resist90C_O_mg");
            resist90C_A_bm = prop.getProperty("resist90C_A_bm");
            resist90C_A_mg = prop.getProperty("resist90C_A_mg");
            resist90C_B_bm = prop.getProperty("resist90C_B_bm");
            resist90C_B_mg = prop.getProperty("resist90C_B_mg");
            resist90C_C_bm = prop.getProperty("resist90C_C_bm");
            resist90C_C_mg = prop.getProperty("resist90C_C_mg");
            resist90C_D_bm = prop.getProperty("resist90C_D_bm");
            resist90C_D_mg = prop.getProperty("resist90C_D_mg");
            resist90C_E_bm = prop.getProperty("resist90C_E_bm");
            resist90C_E_mg = prop.getProperty("resist90C_E_mg");
            resist90C_F_bm = prop.getProperty("resist90C_F_bm");
            resist90C_F_mg = prop.getProperty("resist90C_F_mg");
            resist90C_G_bm = prop.getProperty("resist90C_G_bm");
            resist90C_G_mg = prop.getProperty("resist90C_G_mg");

            inhib_O_bm = prop.getProperty("inhib_O_bm");
            inhib_O_mg = prop.getProperty("inhib_O_mg");
            inhib_A_bm = prop.getProperty("inhib_A_bm");
            inhib_A_mg = prop.getProperty("inhib_A_mg");
            inhib_B_bm = prop.getProperty("inhib_B_bm");
            inhib_B_mg = prop.getProperty("inhib_B_mg");
            inhib_C_bm = prop.getProperty("inhib_C_bm");
            inhib_C_mg = prop.getProperty("inhib_C_mg");
            inhib_D_bm = prop.getProperty("inhib_D_bm");
            inhib_D_mg = prop.getProperty("inhib_D_mg");
            inhib_E_bm = prop.getProperty("inhib_E_bm");
            inhib_E_mg = prop.getProperty("inhib_E_mg");
            inhib_F_bm = prop.getProperty("inhib_F_bm");
            inhib_F_mg = prop.getProperty("inhib_F_mg");
            inhib_G_bm = prop.getProperty("inhib_G_bm");
            inhib_G_mg = prop.getProperty("inhib_G_mg");

            passiv_O_bm = prop.getProperty("passiv_O_bm");
            passiv_O_mg = prop.getProperty("passiv_O_mg");
            passiv_A_bm = prop.getProperty("passiv_A_bm");
            passiv_A_mg = prop.getProperty("passiv_A_mg");
            passiv_B_bm = prop.getProperty("passiv_B_bm");
            passiv_B_mg = prop.getProperty("passiv_B_mg");
            passiv_C_bm = prop.getProperty("passiv_C_bm");
            passiv_C_mg = prop.getProperty("passiv_C_mg");
            passiv_D_bm = prop.getProperty("passiv_D_bm");
            passiv_D_mg = prop.getProperty("passiv_D_mg");
            passiv_E_bm = prop.getProperty("passiv_E_bm");
            passiv_E_mg = prop.getProperty("passiv_E_mg");
            passiv_F_bm = prop.getProperty("passiv_F_bm");
            passiv_F_mg = prop.getProperty("passiv_F_mg");
            passiv_G_bm = prop.getProperty("passiv_G_bm");
            passiv_G_mg = prop.getProperty("passiv_G_mg");

            sedi_O_bm = prop.getProperty("sedi_O_bm");
            sedi_O_mg = prop.getProperty("sedi_O_mg");
            sedi_A_bm = prop.getProperty("sedi_A_bm");
            sedi_A_mg = prop.getProperty("sedi_A_mg");
            sedi_B_bm = prop.getProperty("sedi_B_bm");
            sedi_B_mg = prop.getProperty("sedi_B_mg");
            sedi_C_bm = prop.getProperty("sedi_C_bm");
            sedi_C_mg = prop.getProperty("sedi_C_mg");
            sedi_D_bm = prop.getProperty("sedi_D_bm");
            sedi_D_mg = prop.getProperty("sedi_D_mg");
            sedi_E_bm = prop.getProperty("sedi_E_bm");
            sedi_E_mg = prop.getProperty("sedi_E_mg");
            sedi_F_bm = prop.getProperty("sedi_F_bm");
            sedi_F_mg = prop.getProperty("sedi_F_mg");
            sedi_G_bm = prop.getProperty("sedi_G_bm");
            sedi_G_mg = prop.getProperty("sedi_G_mg");

            intertenINH_O_bm = prop.getProperty("intertenINH_O_bm");
            intertenINH_O_mg = prop.getProperty("intertenINH_O_mg");
            intertenINH_A_bm = prop.getProperty("intertenINH_A_bm");
            intertenINH_A_mg = prop.getProperty("intertenINH_A_mg");
            intertenINH_B_bm = prop.getProperty("intertenINH_B_bm");
            intertenINH_B_mg = prop.getProperty("intertenINH_B_mg");
            intertenINH_C_bm = prop.getProperty("intertenINH_C_bm");
            intertenINH_C_mg = prop.getProperty("intertenINH_C_mg");
            intertenINH_D_bm = prop.getProperty("intertenINH_D_bm");
            intertenINH_D_mg = prop.getProperty("intertenINH_D_mg");
            intertenINH_E_bm = prop.getProperty("intertenINH_E_bm");
            intertenINH_E_mg = prop.getProperty("intertenINH_E_mg");
            intertenINH_F_bm = prop.getProperty("intertenINH_F_bm");
            intertenINH_F_mg = prop.getProperty("intertenINH_F_mg");
            intertenINH_G_bm = prop.getProperty("intertenINH_G_bm");
            intertenINH_G_mg = prop.getProperty("intertenINH_G_mg");

            intertenUNINH_O_bm = prop.getProperty("intertenUNINH_O_bm");
            intertenUNINH_O_mg = prop.getProperty("intertenUNINH_O_mg");
            intertenUNINH_A_bm = prop.getProperty("intertenUNINH_A_bm");
            intertenUNINH_A_mg = prop.getProperty("intertenUNINH_A_mg");
            intertenUNINH_B_bm = prop.getProperty("intertenUNINH_B_bm");
            intertenUNINH_B_mg = prop.getProperty("intertenUNINH_B_mg");
            intertenUNINH_C_bm = prop.getProperty("intertenUNINH_C_bm");
            intertenUNINH_C_mg = prop.getProperty("intertenUNINH_C_mg");
            intertenUNINH_D_bm = prop.getProperty("intertenUNINH_D_bm");
            intertenUNINH_D_mg = prop.getProperty("intertenUNINH_D_mg");
            intertenUNINH_E_bm = prop.getProperty("intertenUNINH_E_bm");
            intertenUNINH_E_mg = prop.getProperty("intertenUNINH_E_mg");
            intertenUNINH_F_bm = prop.getProperty("intertenUNINH_F_bm");
            intertenUNINH_F_mg = prop.getProperty("intertenUNINH_F_mg");
            intertenUNINH_G_bm = prop.getProperty("intertenUNINH_G_bm");
            intertenUNINH_G_mg = prop.getProperty("intertenUNINH_G_mg");

        } catch (IOException e) {
            System.out.println("BAD");
        } finally {
            inputStream.close();
        }
    }

    public void showTest1Reasult(MouseEvent evt) {
        float fmtUserValue = 0;

        try {
            fmtUserValue = Float.parseFloat(test1UserValue.getText());

            RadioMenuItem selectedProperty = (RadioMenuItem) properties.getSelectedToggle();

            switch (selectedProperty.getText()) {
                case "Voltage":
                    if (test1Voltage(fmtUserValue).equals("GOOD")) {
                        setTest1Good();
                    } else if (test1Voltage(fmtUserValue).equals("POOR")) {
                        setTest1Bad();
                    } else if (test1Voltage(fmtUserValue).equals("FAIR")) {
                        setTest1Mid();
                    } else {

                        setTest1NA();
                    }
                    break;
                case "Cantidad de Agua":
                    if (test1Water(fmtUserValue).equals("GOOD")) {
                        setTest1Good();
                    } else if (test1Water(fmtUserValue).equals("POOR")) {
                        setTest1Bad();
                    } else if (test1Water(fmtUserValue).equals("FAIR")) {
                        setTest1Mid();
                    } else {
                        setTest1NA();
                    }
                    break;
                case "Acidez":
                    if (test1Acidity(fmtUserValue).equals("GOOD")) {
                        setTest1Good();
                    } else if (test1Acidity(fmtUserValue).equals("POOR")) {
                        setTest1Bad();
                    } else if (test1Acidity(fmtUserValue).equals("FAIR")) {
                        setTest1Mid();
                    } else {
                        setTest1NA();
                    }
                    break;
                case "Factor de Disipacion Dielectrica":
                    if (test1Diel(fmtUserValue).equals("GOOD")) {
                        setTest1Good();
                    } else if (test1Diel(fmtUserValue).equals("POOR")) {
                        setTest1Bad();
                    } else if (test1Diel(fmtUserValue).equals("FAIR")) {
                        setTest1Mid();
                    } else {
                        setTest1NA();
                    }
                    break;
                case "Resistencia 20°":
                    if (test1Resist20(fmtUserValue).equals("GOOD")) {
                        setTest1Good();
                    } else if (test1Resist20(fmtUserValue).equals("POOR")) {
                        setTest1Bad();
                    } else if (test1Resist20(fmtUserValue).equals("FAIR")) {
                        setTest1Mid();
                    } else {
                        setTest1NA();
                    }
                    break;
                case "Resistencia 90°":
                    if (test1Resist90(fmtUserValue).equals("GOOD")) {
                        setTest1Good();
                    } else if (test1Resist90(fmtUserValue).equals("POOR")) {
                        setTest1Bad();
                    } else if (test1Resist90(fmtUserValue).equals("FAIR")) {
                        setTest1Mid();
                    } else {
                        setTest1NA();
                    }
                    break;
                case "Contenido Inhibidor":
                    if (test1Inhibitor(fmtUserValue).equals("GOOD")) {
                        setTest1Good();
                    } else if (test1Inhibitor(fmtUserValue).equals("POOR")) {
                        setTest1Bad();
                    } else if (test1Inhibitor(fmtUserValue).equals("FAIR")) {
                        setTest1Mid();
                    } else {
                        setTest1NA();
                    }
                    break;
                case "Contenido Pasivizador":
                    if (test1Passivator(fmtUserValue).equals("GOOD")) {
                        setTest1Good();
                    } else if (test1Passivator(fmtUserValue).equals("POOR")) {
                        setTest1Bad();
                    } else if (test1Passivator(fmtUserValue).equals("FAIR")) {
                        setTest1Mid();
                    } else {
                        setTest1NA();
                    }
                    break;
                case "Sedimento":
                    if (test1Sediment(fmtUserValue).equals("GOOD")) {
                        setTest1Good();
                    } else if (test1Sediment(fmtUserValue).equals("POOR")) {
                        setTest1Bad();
                    } else if (test1Sediment(fmtUserValue).equals("FAIR")) {
                        setTest1Mid();
                    } else {
                        setTest1NA();
                    }
                    break;
                case "Tension Interfacial Inhibida":
                    if (test1InterTenINH(fmtUserValue).equals("GOOD")) {
                        setTest1Good();
                    } else if (test1InterTenINH(fmtUserValue).equals("POOR")) {
                        setTest1Bad();
                    } else if (test1InterTenINH(fmtUserValue).equals("FAIR")) {
                        setTest1Mid();
                    } else {
                        setTest1NA();
                    }
                    break;
                case "Tension Interfacial Desinhibida":
                    if (test1InterTenUNINH(fmtUserValue).equals("GOOD")) {
                        setTest1Good();
                    } else if (test1InterTenUNINH(fmtUserValue).equals("POOR")) {
                        setTest1Bad();
                    } else if (test1InterTenUNINH(fmtUserValue).equals("FAIR")) {
                        setTest1Mid();
                    } else {
                        setTest1NA();
                    }
                    break;
                default:
                    System.out.println("Error");
            }

        } catch (NumberFormatException e) {
            errPaneTest1.setVisible(true);
            resultTest1Pane.setVisible(false);
        }
    }

    private String volt_O_bm;
    private String volt_O_mg;
    private String volt_A_bm;
    private String volt_A_mg;
    private String volt_B_bm;
    private String volt_B_mg;
    private String volt_C_bm;
    private String volt_C_mg;
    private String volt_D_bm;
    private String volt_D_mg;
    private String volt_E_bm;
    private String volt_E_mg;
    private String volt_F_bm;
    private String volt_F_mg;
    private String volt_G_bm;
    private String volt_G_mg;

    private String wc_O_bm;
    private String wc_O_mg;
    private String wc_A_bm;
    private String wc_A_mg;
    private String wc_B_bm;
    private String wc_B_mg;
    private String wc_C_bm;
    private String wc_C_mg;
    private String wc_D_bm;
    private String wc_D_mg;
    private String wc_E_bm;
    private String wc_E_mg;
    private String wc_F_bm;
    private String wc_F_mg;
    private String wc_G_bm;
    private String wc_G_mg;

    private String acid_O_bm;
    private String acid_O_mg;
    private String acid_A_bm;
    private String acid_A_mg;
    private String acid_B_bm;
    private String acid_B_mg;
    private String acid_C_bm;
    private String acid_C_mg;
    private String acid_D_bm;
    private String acid_D_mg;
    private String acid_E_bm;
    private String acid_E_mg;
    private String acid_F_bm;
    private String acid_F_mg;
    private String acid_G_bm;
    private String acid_G_mg;

    private String diel_O_bm;
    private String diel_O_mg;
    private String diel_A_bm;
    private String diel_A_mg;
    private String diel_B_bm;
    private String diel_B_mg;
    private String diel_C_bm;
    private String diel_C_mg;
    private String diel_D_bm;
    private String diel_D_mg;
    private String diel_E_bm;
    private String diel_E_mg;
    private String diel_F_bm;
    private String diel_F_mg;
    private String diel_G_bm;
    private String diel_G_mg;

    private String resist20C_O_bm;
    private String resist20C_O_mg;
    private String resist20C_A_bm;
    private String resist20C_A_mg;
    private String resist20C_B_bm;
    private String resist20C_B_mg;
    private String resist20C_C_bm;
    private String resist20C_C_mg;
    private String resist20C_D_bm;
    private String resist20C_D_mg;
    private String resist20C_E_bm;
    private String resist20C_E_mg;
    private String resist20C_F_bm;
    private String resist20C_F_mg;
    private String resist20C_G_bm;
    private String resist20C_G_mg;

    private String resist90C_O_bm;
    private String resist90C_O_mg;
    private String resist90C_A_bm;
    private String resist90C_A_mg;
    private String resist90C_B_bm;
    private String resist90C_B_mg;
    private String resist90C_C_bm;
    private String resist90C_C_mg;
    private String resist90C_D_bm;
    private String resist90C_D_mg;
    private String resist90C_E_bm;
    private String resist90C_E_mg;
    private String resist90C_F_bm;
    private String resist90C_F_mg;
    private String resist90C_G_bm;
    private String resist90C_G_mg;

    private String inhib_O_bm;
    private String inhib_O_mg;
    private String inhib_A_bm;
    private String inhib_A_mg;
    private String inhib_B_bm;
    private String inhib_B_mg;
    private String inhib_C_bm;
    private String inhib_C_mg;
    private String inhib_D_bm;
    private String inhib_D_mg;
    private String inhib_E_bm;
    private String inhib_E_mg;
    private String inhib_F_bm;
    private String inhib_F_mg;
    private String inhib_G_bm;
    private String inhib_G_mg;

    private String passiv_O_bm;
    private String passiv_O_mg;
    private String passiv_A_bm;
    private String passiv_A_mg;
    private String passiv_B_bm;
    private String passiv_B_mg;
    private String passiv_C_bm;
    private String passiv_C_mg;
    private String passiv_D_bm;
    private String passiv_D_mg;
    private String passiv_E_bm;
    private String passiv_E_mg;
    private String passiv_F_bm;
    private String passiv_F_mg;
    private String passiv_G_bm;
    private String passiv_G_mg;

    private String sedi_O_bm;
    private String sedi_O_mg;
    private String sedi_A_bm;
    private String sedi_A_mg;
    private String sedi_B_bm;
    private String sedi_B_mg;
    private String sedi_C_bm;
    private String sedi_C_mg;
    private String sedi_D_bm;
    private String sedi_D_mg;
    private String sedi_E_bm;
    private String sedi_E_mg;
    private String sedi_F_bm;
    private String sedi_F_mg;
    private String sedi_G_bm;
    private String sedi_G_mg;

    private String intertenINH_O_bm;
    private String intertenINH_O_mg;
    private String intertenINH_A_bm;
    private String intertenINH_A_mg;
    private String intertenINH_B_bm;
    private String intertenINH_B_mg;
    private String intertenINH_C_bm;
    private String intertenINH_C_mg;
    private String intertenINH_D_bm;
    private String intertenINH_D_mg;
    private String intertenINH_E_bm;
    private String intertenINH_E_mg;
    private String intertenINH_F_bm;
    private String intertenINH_F_mg;
    private String intertenINH_G_bm;
    private String intertenINH_G_mg;

    private String intertenUNINH_O_bm;
    private String intertenUNINH_O_mg;
    private String intertenUNINH_A_bm;
    private String intertenUNINH_A_mg;
    private String intertenUNINH_B_bm;
    private String intertenUNINH_B_mg;
    private String intertenUNINH_C_bm;
    private String intertenUNINH_C_mg;
    private String intertenUNINH_D_bm;
    private String intertenUNINH_D_mg;
    private String intertenUNINH_E_bm;
    private String intertenUNINH_E_mg;
    private String intertenUNINH_F_bm;
    private String intertenUNINH_F_mg;
    private String intertenUNINH_G_bm;
    private String intertenUNINH_G_mg;

    public String test1Voltage(float in) {
        String reply = null;

        RadioMenuItem selectedCategory = (RadioMenuItem) categories.getSelectedToggle();

        switch (selectedCategory.getText()) {
            case "O":
                if (volt_O_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(volt_O_bm);
                    float valTextG = Float.parseFloat(volt_O_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in < valTextB) {
                        reply = "POOR";
                    } else if (in > valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            case "A":
                if (volt_A_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(volt_A_bm);
                    float valTextG = Float.parseFloat(volt_A_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in < valTextB) {
                        reply = "POOR";
                    } else if (in > valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            case "B":
                if (volt_B_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(volt_B_bm);
                    float valTextG = Float.parseFloat(volt_B_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in < valTextB) {
                        reply = "POOR";
                    } else if (in > valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            case "C":
                if (volt_C_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(volt_C_bm);
                    float valTextG = Float.parseFloat(volt_C_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in < valTextB) {
                        reply = "POOR";
                    } else if (in > valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            case "D":
                if (volt_D_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(volt_D_bm);
                    float valTextG = Float.parseFloat(volt_D_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in < valTextB) {
                        reply = "POOR";
                    } else if (in > valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            case "E":
                if (volt_E_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(volt_E_bm);
                    float valTextG = Float.parseFloat(volt_E_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in < valTextB) {
                        reply = "POOR";
                    } else if (in > valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            case "F":
                if (volt_F_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(volt_F_bm);
                    float valTextG = Float.parseFloat(volt_F_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in < valTextB) {
                        reply = "POOR";
                    } else if (in > valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            case "G":
                if (volt_G_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(volt_G_bm);
                    float valTextG = Float.parseFloat(volt_G_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in < valTextB) {
                        reply = "POOR";
                    } else if (in > valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            default:
                System.out.println("Error #3");
        }

        return reply;
    }

    public String test1Water(float in) {
        String reply = null;

        RadioMenuItem selectedCategory = (RadioMenuItem) categories.getSelectedToggle();

        switch (selectedCategory.getText()) {
            case "O":
                if (wc_O_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(wc_O_bm);
                    float valTextG = Float.parseFloat(wc_O_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in > valTextB) {
                        reply = "POOR";
                    } else if (in < valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            case "A":
                if (wc_A_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(wc_A_bm);
                    float valTextG = Float.parseFloat(wc_A_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in > valTextB) {
                        reply = "POOR";
                    } else if (in < valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            case "B":
                if (wc_B_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(wc_B_bm);
                    float valTextG = Float.parseFloat(wc_B_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in > valTextB) {
                        reply = "POOR";
                    } else if (in < valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            case "C":
                if (wc_C_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(wc_C_bm);
                    float valTextG = Float.parseFloat(wc_C_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in > valTextB) {
                        reply = "POOR";
                    } else if (in < valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            case "D":
                if (wc_D_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(wc_D_bm);
                    float valTextG = Float.parseFloat(wc_D_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in > valTextB) {
                        reply = "POOR";
                    } else if (in < valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            case "E":
                if (wc_E_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(wc_E_bm);
                    float valTextG = Float.parseFloat(wc_E_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in > valTextB) {
                        reply = "POOR";
                    } else if (in < valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            case "F":
                if (wc_F_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(wc_F_bm);
                    float valTextG = Float.parseFloat(wc_F_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in > valTextB) {
                        reply = "POOR";
                    } else if (in < valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            case "G":
                if (wc_G_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(wc_G_bm);
                    float valTextG = Float.parseFloat(wc_G_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in > valTextB) {
                        reply = "POOR";
                    } else if (in < valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            default:
                System.out.println("Error #3");
        }

        return reply;
    }

    public String test1Acidity(float in) {
        String reply = null;

        RadioMenuItem selectedCategory = (RadioMenuItem) categories.getSelectedToggle();

        switch (selectedCategory.getText()) {
            case "O":
                if (acid_O_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(acid_O_bm);
                    float valTextG = Float.parseFloat(acid_O_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in > valTextB) {
                        reply = "POOR";
                    } else if (in < valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            case "A":
                if (acid_A_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(acid_A_bm);
                    float valTextG = Float.parseFloat(acid_A_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in > valTextB) {
                        reply = "POOR";
                    } else if (in < valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            case "B":
                if (acid_B_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(acid_B_bm);
                    float valTextG = Float.parseFloat(acid_B_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in > valTextB) {
                        reply = "POOR";
                    } else if (in < valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            case "C":
                if (acid_C_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(acid_C_bm);
                    float valTextG = Float.parseFloat(acid_C_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in > valTextB) {
                        reply = "POOR";
                    } else if (in < valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            case "D":
                if (acid_D_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(acid_D_bm);
                    float valTextG = Float.parseFloat(acid_D_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in > valTextB) {
                        reply = "POOR";
                    } else if (in < valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            case "E":
                if (acid_E_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(acid_E_bm);
                    float valTextG = Float.parseFloat(acid_E_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in > valTextB) {
                        reply = "POOR";
                    } else if (in < valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            case "F":
                if (acid_F_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(acid_F_bm);
                    float valTextG = Float.parseFloat(acid_F_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in > valTextB) {
                        reply = "POOR";
                    } else if (in < valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            case "G":
                if (acid_G_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(acid_G_bm);
                    float valTextG = Float.parseFloat(acid_G_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in > valTextB) {
                        reply = "POOR";
                    } else if (in < valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            default:
                System.out.println("Error #3");
        }

        return reply;
    }

    public String test1Diel(float in) {
        String reply = null;

        RadioMenuItem selectedCategory = (RadioMenuItem) categories.getSelectedToggle();

        switch (selectedCategory.getText()) {
            case "O":
                if (diel_O_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(diel_O_bm);
                    float valTextG = Float.parseFloat(diel_O_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in > valTextB) {
                        reply = "POOR";
                    } else if (in < valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            case "A":
                if (diel_A_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(diel_A_bm);
                    float valTextG = Float.parseFloat(diel_A_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in > valTextB) {
                        reply = "POOR";
                    } else if (in < valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            case "B":
                if (diel_B_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(diel_B_bm);
                    float valTextG = Float.parseFloat(diel_B_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in > valTextB) {
                        reply = "POOR";
                    } else if (in < valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            case "C":
                if (diel_C_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(diel_C_bm);
                    float valTextG = Float.parseFloat(diel_C_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in > valTextB) {
                        reply = "POOR";
                    } else if (in < valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            case "D":
                if (diel_D_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(diel_D_bm);
                    float valTextG = Float.parseFloat(diel_D_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in > valTextB) {
                        reply = "POOR";
                    } else if (in < valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            case "E":
                if (diel_E_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(diel_E_bm);
                    float valTextG = Float.parseFloat(diel_E_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in > valTextB) {
                        reply = "POOR";
                    } else if (in < valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            case "F":
                if (diel_F_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(diel_F_bm);
                    float valTextG = Float.parseFloat(diel_F_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in > valTextB) {
                        reply = "POOR";
                    } else if (in < valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            case "G":
                if (diel_G_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(diel_G_bm);
                    float valTextG = Float.parseFloat(diel_G_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in > valTextB) {
                        reply = "POOR";
                    } else if (in < valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            default:
                System.out.println("Error #3");
        }

        return reply;
    }

    public String test1Resist20(float in) {
        String reply = null;

        RadioMenuItem selectedCategory = (RadioMenuItem) categories.getSelectedToggle();

        switch (selectedCategory.getText()) {
            case "O":
                if (resist20C_O_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(resist20C_O_bm);
                    float valTextG = Float.parseFloat(resist20C_O_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in < valTextB) {
                        reply = "POOR";
                    } else if (in > valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            case "A":
                if (resist20C_A_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(resist20C_A_bm);
                    float valTextG = Float.parseFloat(resist20C_A_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in < valTextB) {
                        reply = "POOR";
                    } else if (in > valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            case "B":
                if (resist20C_B_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(resist20C_B_bm);
                    float valTextG = Float.parseFloat(resist20C_B_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in < valTextB) {
                        reply = "POOR";
                    } else if (in > valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            case "C":
                if (resist20C_C_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(resist20C_C_bm);
                    float valTextG = Float.parseFloat(resist20C_C_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in < valTextB) {
                        reply = "POOR";
                    } else if (in > valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            case "D":
                if (resist20C_D_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(resist20C_D_bm);
                    float valTextG = Float.parseFloat(resist20C_D_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in < valTextB) {
                        reply = "POOR";
                    } else if (in > valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            case "E":
                if (resist20C_E_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(resist20C_E_bm);
                    float valTextG = Float.parseFloat(resist20C_E_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in < valTextB) {
                        reply = "POOR";
                    } else if (in > valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            case "F":
                if (resist20C_F_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(resist20C_F_bm);
                    float valTextG = Float.parseFloat(resist20C_F_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in < valTextB) {
                        reply = "POOR";
                    } else if (in > valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            case "G":
                if (resist20C_G_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(resist20C_G_bm);
                    float valTextG = Float.parseFloat(resist20C_G_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in < valTextB) {
                        reply = "POOR";
                    } else if (in > valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            default:
                System.out.println("Error #3");
        }

        return reply;
    }

    public String test1Resist90(float in) {
        String reply = null;

        RadioMenuItem selectedCategory = (RadioMenuItem) categories.getSelectedToggle();

        switch (selectedCategory.getText()) {
            case "O":
                if (resist90C_O_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(resist90C_O_bm);
                    float valTextG = Float.parseFloat(resist90C_O_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in < valTextB) {
                        reply = "POOR";
                    } else if (in > valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            case "A":
                if (resist90C_A_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(resist90C_A_bm);
                    float valTextG = Float.parseFloat(resist90C_A_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in < valTextB) {
                        reply = "POOR";
                    } else if (in > valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            case "B":
                if (resist90C_B_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(resist90C_B_bm);
                    float valTextG = Float.parseFloat(resist90C_B_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in < valTextB) {
                        reply = "POOR";
                    } else if (in > valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            case "C":
                if (resist90C_C_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(resist90C_C_bm);
                    float valTextG = Float.parseFloat(resist90C_C_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in < valTextB) {
                        reply = "POOR";
                    } else if (in > valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            case "D":
                if (resist90C_D_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(resist90C_D_bm);
                    float valTextG = Float.parseFloat(resist90C_D_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in < valTextB) {
                        reply = "POOR";
                    } else if (in > valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            case "E":
                if (resist90C_E_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(resist90C_E_bm);
                    float valTextG = Float.parseFloat(resist90C_E_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in < valTextB) {
                        reply = "POOR";
                    } else if (in > valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            case "F":
                if (resist90C_F_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(resist90C_F_bm);
                    float valTextG = Float.parseFloat(resist90C_F_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in < valTextB) {
                        reply = "POOR";
                    } else if (in > valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            case "G":
                if (resist90C_G_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(resist90C_G_bm);
                    float valTextG = Float.parseFloat(resist90C_G_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in < valTextB) {
                        reply = "POOR";
                    } else if (in > valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            default:
                System.out.println("Error #3");
        }

        return reply;
    }

    public String test1Inhibitor(float in) {
        String reply = null;

        RadioMenuItem selectedCategory = (RadioMenuItem) categories.getSelectedToggle();

        switch (selectedCategory.getText()) {
            case "O":
                if (inhib_O_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(inhib_O_bm);
                    float valTextG = Float.parseFloat(inhib_O_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in < valTextB) {
                        reply = "POOR";
                    } else if (in > valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            case "A":
                if (inhib_A_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(inhib_A_bm);
                    float valTextG = Float.parseFloat(inhib_A_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in < valTextB) {
                        reply = "POOR";
                    } else if (in > valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            case "B":
                if (inhib_B_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(inhib_B_bm);
                    float valTextG = Float.parseFloat(inhib_B_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in < valTextB) {
                        reply = "POOR";
                    } else if (in > valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            case "C":
                if (inhib_C_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(inhib_C_bm);
                    float valTextG = Float.parseFloat(inhib_C_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in < valTextB) {
                        reply = "POOR";
                    } else if (in > valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            case "D":
                if (inhib_D_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(inhib_D_bm);
                    float valTextG = Float.parseFloat(inhib_D_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in < valTextB) {
                        reply = "POOR";
                    } else if (in > valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            case "E":
                if (inhib_E_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(inhib_E_bm);
                    float valTextG = Float.parseFloat(inhib_E_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in < valTextB) {
                        reply = "POOR";
                    } else if (in > valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            case "F":
                if (inhib_F_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(inhib_F_bm);
                    float valTextG = Float.parseFloat(inhib_F_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in < valTextB) {
                        reply = "POOR";
                    } else if (in > valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            case "G":
                if (inhib_G_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(inhib_G_bm);
                    float valTextG = Float.parseFloat(inhib_G_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in < valTextB) {
                        reply = "POOR";
                    } else if (in > valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            default:
                System.out.println("Error #3");
        }

        return reply;
    }

    public String test1Passivator(float in) {
        String reply = null;

        RadioMenuItem selectedCategory = (RadioMenuItem) categories.getSelectedToggle();

        switch (selectedCategory.getText()) {
            case "O":
                if (passiv_O_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(passiv_O_bm);
                    float valTextG = Float.parseFloat(passiv_O_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in < valTextB) {
                        reply = "POOR";
                    } else if (in > valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            case "A":
                if (passiv_A_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(passiv_A_bm);
                    float valTextG = Float.parseFloat(passiv_A_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in < valTextB) {
                        reply = "POOR";
                    } else if (in > valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            case "B":
                if (passiv_B_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(passiv_B_bm);
                    float valTextG = Float.parseFloat(passiv_B_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in < valTextB) {
                        reply = "POOR";
                    } else if (in > valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            case "C":
                if (passiv_C_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(passiv_C_bm);
                    float valTextG = Float.parseFloat(passiv_C_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in < valTextB) {
                        reply = "POOR";
                    } else if (in > valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            case "D":
                if (passiv_D_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(passiv_D_bm);
                    float valTextG = Float.parseFloat(passiv_D_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in < valTextB) {
                        reply = "POOR";
                    } else if (in > valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            case "E":
                if (passiv_E_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(passiv_E_bm);
                    float valTextG = Float.parseFloat(passiv_E_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in < valTextB) {
                        reply = "POOR";
                    } else if (in > valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            case "F":
                if (passiv_F_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(passiv_F_bm);
                    float valTextG = Float.parseFloat(passiv_F_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in < valTextB) {
                        reply = "POOR";
                    } else if (in > valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            case "G":
                if (passiv_G_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(passiv_G_bm);
                    float valTextG = Float.parseFloat(passiv_G_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in < valTextB) {
                        reply = "POOR";
                    } else if (in > valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            default:
                System.out.println("Error #3");
        }

        return reply;
    }

    public String test1Sediment(float in) {
        String reply = null;

        RadioMenuItem selectedCategory = (RadioMenuItem) categories.getSelectedToggle();

        switch (selectedCategory.getText()) {
            case "O":
                if (sedi_O_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(sedi_O_bm);
                    float valTextG = Float.parseFloat(sedi_O_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in < valTextB) {
                        reply = "POOR";
                    } else if (in > valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            case "A":
                if (sedi_A_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(sedi_A_bm);
                    float valTextG = Float.parseFloat(sedi_A_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in < valTextB) {
                        reply = "POOR";
                    } else if (in > valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            case "B":
                if (sedi_B_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(sedi_B_bm);
                    float valTextG = Float.parseFloat(sedi_B_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in < valTextB) {
                        reply = "POOR";
                    } else if (in > valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            case "C":
                if (sedi_C_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(sedi_C_bm);
                    float valTextG = Float.parseFloat(sedi_C_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in < valTextB) {
                        reply = "POOR";
                    } else if (in > valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            case "D":
                if (sedi_D_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(sedi_D_bm);
                    float valTextG = Float.parseFloat(sedi_D_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in < valTextB) {
                        reply = "POOR";
                    } else if (in > valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            case "E":
                if (sedi_E_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(sedi_E_bm);
                    float valTextG = Float.parseFloat(sedi_E_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in < valTextB) {
                        reply = "POOR";
                    } else if (in > valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            case "F":
                if (sedi_F_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(sedi_F_bm);
                    float valTextG = Float.parseFloat(sedi_F_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in < valTextB) {
                        reply = "POOR";
                    } else if (in > valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            case "G":
                if (sedi_G_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(sedi_G_bm);
                    float valTextG = Float.parseFloat(sedi_G_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in < valTextB) {
                        reply = "POOR";
                    } else if (in > valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            default:
                System.out.println("Error #3");
        }

        return reply;
    }

    public String test1InterTenINH(float in) {
        String reply = null;

        RadioMenuItem selectedCategory = (RadioMenuItem) categories.getSelectedToggle();

        switch (selectedCategory.getText()) {
            case "O":
                if (intertenINH_O_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(intertenINH_O_bm);
                    float valTextG = Float.parseFloat(intertenINH_O_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in < valTextB) {
                        reply = "POOR";
                    } else if (in > valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            case "A":
                if (intertenINH_A_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(intertenINH_A_bm);
                    float valTextG = Float.parseFloat(intertenINH_A_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in < valTextB) {
                        reply = "POOR";
                    } else if (in > valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            case "B":
                if (intertenINH_B_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(intertenINH_B_bm);
                    float valTextG = Float.parseFloat(intertenINH_B_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in < valTextB) {
                        reply = "POOR";
                    } else if (in > valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            case "C":
                if (intertenINH_C_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(intertenINH_C_bm);
                    float valTextG = Float.parseFloat(intertenINH_C_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in < valTextB) {
                        reply = "POOR";
                    } else if (in > valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            case "D":
                if (intertenINH_D_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(intertenINH_D_bm);
                    float valTextG = Float.parseFloat(intertenINH_D_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in < valTextB) {
                        reply = "POOR";
                    } else if (in > valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            case "E":
                if (intertenINH_E_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(intertenINH_E_bm);
                    float valTextG = Float.parseFloat(intertenINH_E_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in < valTextB) {
                        reply = "POOR";
                    } else if (in > valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            case "F":
                if (intertenINH_F_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(intertenINH_F_bm);
                    float valTextG = Float.parseFloat(intertenINH_F_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in < valTextB) {
                        reply = "POOR";
                    } else if (in > valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            case "G":
                if (intertenINH_G_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(intertenINH_G_bm);
                    float valTextG = Float.parseFloat(intertenINH_G_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in < valTextB) {
                        reply = "POOR";
                    } else if (in > valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            default:
                System.out.println("Error #3");
        }

        return reply;
    }

    public String test1InterTenUNINH(float in) {
        String reply = null;

        RadioMenuItem selectedCategory = (RadioMenuItem) categories.getSelectedToggle();

        switch (selectedCategory.getText()) {
            case "O":
                if (intertenUNINH_O_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(intertenUNINH_O_bm);
                    float valTextG = Float.parseFloat(intertenUNINH_O_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in < valTextB) {
                        reply = "POOR";
                    } else if (in > valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            case "A":
                if (intertenUNINH_A_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(intertenUNINH_A_bm);
                    float valTextG = Float.parseFloat(intertenUNINH_A_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in < valTextB) {
                        reply = "POOR";
                    } else if (in > valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            case "B":
                if (intertenUNINH_B_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(intertenUNINH_B_bm);
                    float valTextG = Float.parseFloat(intertenUNINH_B_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in < valTextB) {
                        reply = "POOR";
                    } else if (in > valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            case "C":
                if (intertenUNINH_C_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(intertenUNINH_C_bm);
                    float valTextG = Float.parseFloat(intertenUNINH_C_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in < valTextB) {
                        reply = "POOR";
                    } else if (in > valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            case "D":
                if (intertenUNINH_D_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(intertenUNINH_D_bm);
                    float valTextG = Float.parseFloat(intertenUNINH_D_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in < valTextB) {
                        reply = "POOR";
                    } else if (in > valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            case "E":
                if (intertenUNINH_E_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(intertenUNINH_E_bm);
                    float valTextG = Float.parseFloat(intertenUNINH_E_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in < valTextB) {
                        reply = "POOR";
                    } else if (in > valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            case "F":
                if (intertenUNINH_F_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(intertenUNINH_F_bm);
                    float valTextG = Float.parseFloat(intertenUNINH_F_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in < valTextB) {
                        reply = "POOR";
                    } else if (in > valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            case "G":
                if (intertenUNINH_G_bm.equals("NA")) {
                    reply = "NA";
                    test1PoorValue.setText("");
                    test1GoodValue.setText("");
                } else {
                    float valTextB = Float.parseFloat(intertenUNINH_G_bm);
                    float valTextG = Float.parseFloat(intertenUNINH_G_mg);
                    test1PoorValue.setText(String.valueOf(valTextB));
                    test1GoodValue.setText(String.valueOf(valTextG));

                    if (in < valTextB) {
                        reply = "POOR";
                    } else if (in > valTextG) {
                        reply = "GOOD";
                    } else {
                        reply = "FAIR";
                    }
                }
                break;
            default:
                System.out.println("Error #3");
        }

        return reply;
    }

    public void setTest1Bad() {
        test1ArrowB.setVisible(true);
        test1ArrowM.setVisible(false);
        test1ArrowG.setVisible(false);
        test1NA.setVisible(false);

        errPaneTest1.setVisible(false);
        resultTest1Pane.setVisible(true);
    }

    public void setTest1Mid() {
        test1ArrowB.setVisible(false);
        test1ArrowM.setVisible(true);
        test1ArrowG.setVisible(false);
        test1NA.setVisible(false);

        errPaneTest1.setVisible(false);
        resultTest1Pane.setVisible(true);
    }

    public void setTest1Good() {
        test1ArrowB.setVisible(false);
        test1ArrowM.setVisible(false);
        test1ArrowG.setVisible(true);
        test1NA.setVisible(false);

        errPaneTest1.setVisible(false);
        resultTest1Pane.setVisible(true);
    }

    public void setTest1NA() {
        test1ArrowB.setVisible(false);
        test1ArrowM.setVisible(false);
        test1ArrowG.setVisible(false);
        test1NA.setVisible(true);

        errPaneTest1.setVisible(false);
        resultTest1Pane.setVisible(true);
    }

    // Settings

    public void settingsApplyVCT1 (MouseEvent evt) {
        RadioMenuItem selectedProperty = (RadioMenuItem) properties1.getSelectedToggle();
        RadioMenuItem selectedCategory = (RadioMenuItem) categories1.getSelectedToggle();

        String inputV1 = settingsTest1VCField1.getText();
        String inputV2 = settingsTest1VCField2.getText();

        try {
            if (inputV1 != null) {
                if(inputV1.equals("NA")) {
                    //Write NA
                    try {
                        FileInputStream in = new FileInputStream("src/main/resources/values.properties");
                        Properties props = new Properties();
                        props.load(in);
                        in.close();

                        switch (selectedProperty.getText()) {
                            case "Voltage":
                                switch (selectedCategory.getText()) {
                                    case "O":
                                        props.setProperty("volt_O_bm", "NA");
                                        volt_O_bm = "NA";
                                        break;
                                    case "A":
                                        props.setProperty("volt_A_bm", "NA");
                                        volt_A_bm = "NA";
                                        break;
                                    case "B":
                                        props.setProperty("volt_B_bm", "NA");
                                        volt_B_bm = "NA";
                                        break;
                                    case "C":
                                        props.setProperty("volt_C_bm", "NA");
                                        volt_C_bm = "NA";
                                        break;
                                    case "D":
                                        props.setProperty("volt_D_bm", "NA");
                                        volt_D_bm = "NA";
                                        break;
                                    case "E":
                                        props.setProperty("volt_E_bm", "NA");
                                        volt_E_bm = "NA";
                                        break;
                                    case "F":
                                        props.setProperty("volt_F_bm", "NA");
                                        volt_F_bm = "NA";
                                        break;
                                    case "G":
                                        props.setProperty("volt_G_bm", "NA");
                                        volt_G_bm = "NA";
                                        break;
                                }
                                break;
                            case "Cantidad de Agua":
                                switch (selectedCategory.getText()) {
                                    case "O":
                                        props.setProperty("wc_O_bm", "NA");
                                        wc_O_bm = "NA";
                                        break;
                                    case "A":
                                        props.setProperty("wc_A_bm", "NA");
                                        wc_A_bm = "NA";
                                        break;
                                    case "B":
                                        props.setProperty("wc_B_bm", "NA");
                                        wc_B_bm = "NA";
                                        break;
                                    case "C":
                                        props.setProperty("wc_C_bm", "NA");
                                        wc_C_bm = "NA";
                                        break;
                                    case "D":
                                        props.setProperty("wc_D_bm", "NA");
                                        wc_D_bm = "NA";
                                        break;
                                    case "E":
                                        props.setProperty("wc_E_bm", "NA");
                                        wc_E_bm = "NA";
                                        break;
                                    case "F":
                                        props.setProperty("wc_F_bm", "NA");
                                        wc_F_bm = "NA";
                                        break;
                                    case "G":
                                        props.setProperty("wc_G_bm", "NA");
                                        wc_G_bm = "NA";
                                        break;
                                }
                                break;
                            case "Acidez":
                                switch (selectedCategory.getText()) {
                                    case "O":
                                        props.setProperty("acid_O_bm", "NA");
                                        acid_O_bm = "NA";
                                        break;
                                    case "A":
                                        props.setProperty("acid_A_bm", "NA");
                                        acid_A_bm = "NA";
                                        break;
                                    case "B":
                                        props.setProperty("acid_B_bm", "NA");
                                        acid_B_bm = "NA";
                                        break;
                                    case "C":
                                        props.setProperty("acid_C_bm", "NA");
                                        acid_C_bm = "NA";
                                        break;
                                    case "D":
                                        props.setProperty("acid_D_bm", "NA");
                                        acid_D_bm = "NA";
                                        break;
                                    case "E":
                                        props.setProperty("acid_E_bm", "NA");
                                        acid_E_bm = "NA";
                                        break;
                                    case "F":
                                        props.setProperty("acid_F_bm", "NA");
                                        acid_F_bm = "NA";
                                        break;
                                    case "G":
                                        props.setProperty("acid_G_bm", "NA");
                                        acid_G_bm = "NA";
                                        break;
                                }
                                break;
                            case "Factor de Disipacion Dielectrica":
                                switch (selectedCategory.getText()) {
                                    case "O":
                                        props.setProperty("diel_O_bm", "NA");
                                        diel_O_bm = "NA";
                                        break;
                                    case "A":
                                        props.setProperty("diel_A_bm", "NA");
                                        diel_A_bm = "NA";
                                        break;
                                    case "B":
                                        props.setProperty("diel_B_bm", "NA");
                                        diel_B_bm = "NA";
                                        break;
                                    case "C":
                                        props.setProperty("diel_C_bm", "NA");
                                        diel_C_bm = "NA";
                                        break;
                                    case "D":
                                        props.setProperty("diel_D_bm", "NA");
                                        diel_D_bm = "NA";
                                        break;
                                    case "E":
                                        props.setProperty("diel_E_bm", "NA");
                                        diel_E_bm = "NA";
                                        break;
                                    case "F":
                                        props.setProperty("diel_F_bm", "NA");
                                        diel_F_bm = "NA";
                                        break;
                                    case "G":
                                        props.setProperty("diel_G_bm", "NA");
                                        diel_G_bm = "NA";
                                        break;
                                }
                                break;
                            case "Resistencia 20°":
                                switch (selectedCategory.getText()) {
                                    case "O":
                                        props.setProperty("resist20C_O_bm", "NA");
                                        resist20C_O_bm = "NA";
                                        break;
                                    case "A":
                                        props.setProperty("resist20C_A_bm", "NA");
                                        resist20C_A_bm = "NA";
                                        break;
                                    case "B":
                                        props.setProperty("resist20C_B_bm", "NA");
                                        resist20C_B_bm = "NA";
                                        break;
                                    case "C":
                                        props.setProperty("resist20C_C_bm", "NA");
                                        resist20C_C_bm = "NA";
                                        break;
                                    case "D":
                                        props.setProperty("resist20C_D_bm", "NA");
                                        resist20C_D_bm = "NA";
                                        break;
                                    case "E":
                                        props.setProperty("resist20C_E_bm", "NA");
                                        resist20C_E_bm = "NA";
                                        break;
                                    case "F":
                                        props.setProperty("resist20C_F_bm", "NA");
                                        resist20C_F_bm = "NA";
                                        break;
                                    case "G":
                                        props.setProperty("resist20C_G_bm", "NA");
                                        resist20C_G_bm = "NA";
                                        break;
                                }
                                break;
                            case "Resistencia 90°":
                                switch (selectedCategory.getText()) {
                                    case "O":
                                        props.setProperty("resist90C_O_bm", "NA");
                                        resist90C_O_bm = "NA";
                                        break;
                                    case "A":
                                        props.setProperty("resist90C_A_bm", "NA");
                                        resist90C_A_bm = "NA";
                                        break;
                                    case "B":
                                        props.setProperty("resist90C_B_bm", "NA");
                                        resist90C_B_bm = "NA";
                                        break;
                                    case "C":
                                        props.setProperty("resist90C_C_bm", "NA");
                                        resist90C_C_bm = "NA";
                                        break;
                                    case "D":
                                        props.setProperty("resist90C_D_bm", "NA");
                                        resist90C_D_bm = "NA";
                                        break;
                                    case "E":
                                        props.setProperty("resist90C_E_bm", "NA");
                                        resist90C_E_bm = "NA";
                                        break;
                                    case "F":
                                        props.setProperty("resist90C_F_bm", "NA");
                                        resist90C_F_bm = "NA";
                                        break;
                                    case "G":
                                        props.setProperty("resist90C_G_bm", "NA");
                                        resist90C_G_bm = "NA";
                                        break;
                                }
                                break;
                            case "Contenido Inhibidor":
                                switch (selectedCategory.getText()) {
                                    case "O":
                                        props.setProperty("inhib_O_bm", "NA");
                                        inhib_O_bm = "NA";
                                        break;
                                    case "A":
                                        props.setProperty("inhib_A_bm", "NA");
                                        inhib_A_bm = "NA";
                                        break;
                                    case "B":
                                        props.setProperty("inhib_B_bm", "NA");
                                        inhib_B_bm = "NA";
                                        break;
                                    case "C":
                                        props.setProperty("inhib_C_bm", "NA");
                                        inhib_C_bm = "NA";
                                        break;
                                    case "D":
                                        props.setProperty("inhib_D_bm", "NA");
                                        inhib_D_bm = "NA";
                                        break;
                                    case "E":
                                        props.setProperty("inhib_E_bm", "NA");
                                        inhib_E_bm = "NA";
                                        break;
                                    case "F":
                                        props.setProperty("inhib_F_bm", "NA");
                                        inhib_F_bm = "NA";
                                        break;
                                    case "G":
                                        props.setProperty("inhib_G_bm", "NA");
                                        inhib_G_bm = "NA";
                                        break;
                                }
                                break;
                            case "Contenido Pasivizador":
                                switch (selectedCategory.getText()) {
                                    case "O":
                                        props.setProperty("passiv_O_bm", "NA");
                                        passiv_O_bm = "NA";
                                        break;
                                    case "A":
                                        props.setProperty("passiv_A_bm", "NA");
                                        passiv_A_bm = "NA";
                                        break;
                                    case "B":
                                        props.setProperty("passiv_B_bm", "NA");
                                        passiv_B_bm = "NA";
                                        break;
                                    case "C":
                                        props.setProperty("passiv_C_bm", "NA");
                                        passiv_C_bm = "NA";
                                        break;
                                    case "D":
                                        props.setProperty("passiv_D_bm", "NA");
                                        passiv_D_bm = "NA";
                                        break;
                                    case "E":
                                        props.setProperty("passiv_E_bm", "NA");
                                        passiv_E_bm = "NA";
                                        break;
                                    case "F":
                                        props.setProperty("passiv_F_bm", "NA");
                                        passiv_F_bm = "NA";
                                        break;
                                    case "G":
                                        props.setProperty("passiv_G_bm", "NA");
                                        passiv_G_bm = "NA";
                                        break;
                                }
                                break;
                            case "Sedimento":
                                switch (selectedCategory.getText()) {
                                    case "O":
                                        props.setProperty("sedi_O_bm", "NA");
                                        sedi_O_bm = "NA";
                                        break;
                                    case "A":
                                        props.setProperty("sedi_A_bm", "NA");
                                        sedi_A_bm = "NA";
                                        break;
                                    case "B":
                                        props.setProperty("sedi_B_bm", "NA");
                                        sedi_B_bm = "NA";
                                        break;
                                    case "C":
                                        props.setProperty("sedi_C_bm", "NA");
                                        sedi_C_bm = "NA";
                                        break;
                                    case "D":
                                        props.setProperty("sedi_D_bm", "NA");
                                        sedi_D_bm = "NA";
                                        break;
                                    case "E":
                                        props.setProperty("sedi_E_bm", "NA");
                                        sedi_E_bm = "NA";
                                        break;
                                    case "F":
                                        props.setProperty("sedi_F_bm", "NA");
                                        sedi_F_bm = "NA";
                                        break;
                                    case "G":
                                        props.setProperty("sedi_G_bm", "NA");
                                        sedi_G_bm = "NA";
                                        break;
                                }
                                break;
                            case "Tension Interfacial Inhibida":
                                switch (selectedCategory.getText()) {
                                    case "O":
                                        props.setProperty("intertenINH_O_bm", "NA");
                                        intertenINH_O_bm = "NA";
                                        break;
                                    case "A":
                                        props.setProperty("intertenINH_A_bm", "NA");
                                        intertenINH_A_bm = "NA";
                                        break;
                                    case "B":
                                        props.setProperty("intertenINH_B_bm", "NA");
                                        intertenINH_B_bm = "NA";
                                        break;
                                    case "C":
                                        props.setProperty("intertenINH_C_bm", "NA");
                                        intertenINH_C_bm = "NA";
                                        break;
                                    case "D":
                                        props.setProperty("intertenINH_D_bm", "NA");
                                        intertenINH_D_bm = "NA";
                                        break;
                                    case "E":
                                        props.setProperty("intertenINH_E_bm", "NA");
                                        intertenINH_E_bm = "NA";
                                        break;
                                    case "F":
                                        props.setProperty("intertenINH_F_bm", "NA");
                                        intertenINH_F_bm = "NA";
                                        break;
                                    case "G":
                                        props.setProperty("intertenINH_G_bm", "NA");
                                        intertenINH_G_bm = "NA";
                                        break;
                                }
                                break;
                            case "Tension Interfacial Desinhibida":
                                switch (selectedCategory.getText()) {
                                    case "O":
                                        props.setProperty("intertenUNINH_O_bm", "NA");
                                        intertenUNINH_O_bm = "NA";
                                        break;
                                    case "A":
                                        props.setProperty("intertenUNINH_A_bm", "NA");
                                        intertenUNINH_A_bm = "NA";
                                        break;
                                    case "B":
                                        props.setProperty("intertenUNINH_B_bm", "NA");
                                        intertenUNINH_B_bm = "NA";
                                        break;
                                    case "C":
                                        props.setProperty("intertenUNINH_C_bm", "NA");
                                        intertenUNINH_C_bm = "NA";
                                        break;
                                    case "D":
                                        props.setProperty("intertenUNINH_D_bm", "NA");
                                        intertenUNINH_D_bm = "NA";
                                        break;
                                    case "E":
                                        props.setProperty("intertenUNINH_E_bm", "NA");
                                        intertenUNINH_E_bm = "NA";
                                        break;
                                    case "F":
                                        props.setProperty("intertenUNINH_F_bm", "NA");
                                        intertenUNINH_F_bm = "NA";
                                        break;
                                    case "G":
                                        props.setProperty("intertenUNINH_G_bm", "NA");
                                        intertenUNINH_G_bm = "NA";
                                        break;
                                }
                                break;
                            default:
                                System.out.println("Error");
                        }

                        FileOutputStream out = new FileOutputStream("src/main/resources/values.properties");

                        LocalDate currentDate = LocalDate.now();
                        props.setProperty("lastupdated",currentDate.format(formatter));

                        props.store(out, null);
                        out.close();

                    } catch (FileNotFoundException e) {
                        System.out.println("File not found.");
                    } catch (IOException e) {
                        System.out.println("Something wrong.");
                    }
                } else if (inputV1.matches("[0-9]+")) {
                    //Write value
                    try {
                        FileInputStream in = new FileInputStream("src/main/resources/values.properties");
                        Properties props = new Properties();
                        props.load(in);
                        in.close();

                        switch (selectedProperty.getText()) {
                            case "Voltage":
                                switch (selectedCategory.getText()) {
                                    case "O":
                                        props.setProperty("volt_O_bm", inputV1);
                                        volt_O_bm = inputV1;
                                        break;
                                    case "A":
                                        props.setProperty("volt_A_bm", inputV1);
                                        volt_A_bm = inputV1;
                                        break;
                                    case "B":
                                        props.setProperty("volt_B_bm", inputV1);
                                        volt_B_bm = inputV1;
                                        break;
                                    case "C":
                                        props.setProperty("volt_C_bm", inputV1);
                                        volt_C_bm = inputV1;
                                        break;
                                    case "D":
                                        props.setProperty("volt_D_bm", inputV1);
                                        volt_D_bm = inputV1;
                                        break;
                                    case "E":
                                        props.setProperty("volt_E_bm", inputV1);
                                        volt_E_bm = inputV1;
                                        break;
                                    case "F":
                                        props.setProperty("volt_F_bm", inputV1);
                                        volt_F_bm = inputV1;
                                        break;
                                    case "G":
                                        props.setProperty("volt_G_bm", inputV1);
                                        volt_G_bm = inputV1;
                                        break;
                                }
                                break;
                            case "Cantidad de Agua":
                                switch (selectedCategory.getText()) {
                                    case "O":
                                        props.setProperty("wc_O_bm", inputV1);
                                        wc_O_bm = inputV1;
                                        break;
                                    case "A":
                                        props.setProperty("wc_A_bm", inputV1);
                                        wc_A_bm = inputV1;
                                        break;
                                    case "B":
                                        props.setProperty("wc_B_bm", inputV1);
                                        wc_B_bm = inputV1;
                                        break;
                                    case "C":
                                        props.setProperty("wc_C_bm", inputV1);
                                        wc_C_bm = inputV1;
                                        break;
                                    case "D":
                                        props.setProperty("wc_D_bm", inputV1);
                                        wc_D_bm = inputV1;
                                        break;
                                    case "E":
                                        props.setProperty("wc_E_bm", inputV1);
                                        wc_E_bm = inputV1;
                                        break;
                                    case "F":
                                        props.setProperty("wc_F_bm", inputV1);
                                        wc_F_bm = inputV1;
                                        break;
                                    case "G":
                                        props.setProperty("wc_G_bm", inputV1);
                                        wc_G_bm = inputV1;
                                        break;
                                }
                                break;
                            case "Acidez":
                                switch (selectedCategory.getText()) {
                                    case "O":
                                        props.setProperty("acid_O_bm", inputV1);
                                        acid_O_bm = inputV1;
                                        break;
                                    case "A":
                                        props.setProperty("acid_A_bm", inputV1);
                                        acid_A_bm = inputV1;
                                        break;
                                    case "B":
                                        props.setProperty("acid_B_bm", inputV1);
                                        acid_B_bm = inputV1;
                                        break;
                                    case "C":
                                        props.setProperty("acid_C_bm", inputV1);
                                        acid_C_bm = inputV1;
                                        break;
                                    case "D":
                                        props.setProperty("acid_D_bm", inputV1);
                                        acid_D_bm = inputV1;
                                        break;
                                    case "E":
                                        props.setProperty("acid_E_bm", inputV1);
                                        acid_E_bm = inputV1;
                                        break;
                                    case "F":
                                        props.setProperty("acid_F_bm", inputV1);
                                        acid_F_bm = inputV1;
                                        break;
                                    case "G":
                                        props.setProperty("acid_G_bm", inputV1);
                                        acid_G_bm = inputV1;
                                        break;
                                }
                                break;
                            case "Factor de Disipacion Dielectrica":
                                switch (selectedCategory.getText()) {
                                    case "O":
                                        props.setProperty("diel_O_bm", inputV1);
                                        diel_O_bm = inputV1;
                                        break;
                                    case "A":
                                        props.setProperty("diel_A_bm", inputV1);
                                        diel_A_bm = inputV1;
                                        break;
                                    case "B":
                                        props.setProperty("diel_B_bm", inputV1);
                                        diel_B_bm = inputV1;
                                        break;
                                    case "C":
                                        props.setProperty("diel_C_bm", inputV1);
                                        diel_C_bm = inputV1;
                                        break;
                                    case "D":
                                        props.setProperty("diel_D_bm", inputV1);
                                        diel_D_bm = inputV1;
                                        break;
                                    case "E":
                                        props.setProperty("diel_E_bm", inputV1);
                                        diel_E_bm = inputV1;
                                        break;
                                    case "F":
                                        props.setProperty("diel_F_bm", inputV1);
                                        diel_F_bm = inputV1;
                                        break;
                                    case "G":
                                        props.setProperty("diel_G_bm", inputV1);
                                        diel_G_bm = inputV1;
                                        break;
                                }
                                break;
                            case "Resistencia 20°":
                                switch (selectedCategory.getText()) {
                                    case "O":
                                        props.setProperty("resist20C_O_bm", inputV1);
                                        resist20C_O_bm = inputV1;
                                        break;
                                    case "A":
                                        props.setProperty("resist20C_A_bm", inputV1);
                                        resist20C_A_bm = inputV1;
                                        break;
                                    case "B":
                                        props.setProperty("resist20C_B_bm", inputV1);
                                        resist20C_B_bm = inputV1;
                                        break;
                                    case "C":
                                        props.setProperty("resist20C_C_bm", inputV1);
                                        resist20C_C_bm = inputV1;
                                        break;
                                    case "D":
                                        props.setProperty("resist20C_D_bm", inputV1);
                                        resist20C_D_bm = inputV1;
                                        break;
                                    case "E":
                                        props.setProperty("resist20C_E_bm", inputV1);
                                        resist20C_E_bm = inputV1;
                                        break;
                                    case "F":
                                        props.setProperty("resist20C_F_bm", inputV1);
                                        resist20C_F_bm = inputV1;
                                        break;
                                    case "G":
                                        props.setProperty("resist20C_G_bm", inputV1);
                                        resist20C_G_bm = inputV1;
                                        break;
                                }
                                break;
                            case "Resistencia 90°":
                                switch (selectedCategory.getText()) {
                                    case "O":
                                        props.setProperty("resist90C_O_bm", inputV1);
                                        resist90C_O_bm = inputV1;
                                        break;
                                    case "A":
                                        props.setProperty("resist90C_A_bm", inputV1);
                                        resist90C_A_bm = inputV1;
                                        break;
                                    case "B":
                                        props.setProperty("resist90C_B_bm", inputV1);
                                        resist90C_B_bm = inputV1;
                                        break;
                                    case "C":
                                        props.setProperty("resist90C_C_bm", inputV1);
                                        resist90C_C_bm = inputV1;
                                        break;
                                    case "D":
                                        props.setProperty("resist90C_D_bm", inputV1);
                                        resist90C_D_bm = inputV1;
                                        break;
                                    case "E":
                                        props.setProperty("resist90C_E_bm", inputV1);
                                        resist90C_E_bm = inputV1;
                                        break;
                                    case "F":
                                        props.setProperty("resist90C_F_bm", inputV1);
                                        resist90C_F_bm = inputV1;
                                        break;
                                    case "G":
                                        props.setProperty("resist90C_G_bm", inputV1);
                                        resist90C_G_bm = inputV1;
                                        break;
                                }
                                break;
                            case "Contenido Inhibidor":
                                switch (selectedCategory.getText()) {
                                    case "O":
                                        props.setProperty("inhib_O_bm", inputV1);
                                        inhib_O_bm = inputV1;
                                        break;
                                    case "A":
                                        props.setProperty("inhib_A_bm", inputV1);
                                        inhib_A_bm = inputV1;
                                        break;
                                    case "B":
                                        props.setProperty("inhib_B_bm", inputV1);
                                        inhib_B_bm = inputV1;
                                        break;
                                    case "C":
                                        props.setProperty("inhib_C_bm", inputV1);
                                        inhib_C_bm = inputV1;
                                        break;
                                    case "D":
                                        props.setProperty("inhib_D_bm", inputV1);
                                        inhib_D_bm = inputV1;
                                        break;
                                    case "E":
                                        props.setProperty("inhib_E_bm", inputV1);
                                        inhib_E_bm = inputV1;
                                        break;
                                    case "F":
                                        props.setProperty("inhib_F_bm", inputV1);
                                        inhib_F_bm = inputV1;
                                        break;
                                    case "G":
                                        props.setProperty("inhib_G_bm", inputV1);
                                        inhib_G_bm = inputV1;
                                        break;
                                }
                                break;
                            case "Contenido Pasivizador":
                                switch (selectedCategory.getText()) {
                                    case "O":
                                        props.setProperty("passiv_O_bm", inputV1);
                                        passiv_O_bm = inputV1;
                                        break;
                                    case "A":
                                        props.setProperty("passiv_A_bm", inputV1);
                                        passiv_A_bm = inputV1;
                                        break;
                                    case "B":
                                        props.setProperty("passiv_B_bm", inputV1);
                                        passiv_B_bm = inputV1;
                                        break;
                                    case "C":
                                        props.setProperty("passiv_C_bm", inputV1);
                                        passiv_C_bm = inputV1;
                                        break;
                                    case "D":
                                        props.setProperty("passiv_D_bm", inputV1);
                                        passiv_D_bm = inputV1;
                                        break;
                                    case "E":
                                        props.setProperty("passiv_E_bm", inputV1);
                                        passiv_E_bm = inputV1;
                                        break;
                                    case "F":
                                        props.setProperty("passiv_F_bm", inputV1);
                                        passiv_F_bm = inputV1;
                                        break;
                                    case "G":
                                        props.setProperty("passiv_G_bm", inputV1);
                                        passiv_G_bm = inputV1;
                                        break;
                                }
                                break;
                            case "Sedimento":
                                switch (selectedCategory.getText()) {
                                    case "O":
                                        props.setProperty("sedi_O_bm", inputV1);
                                        sedi_O_bm = inputV1;
                                        break;
                                    case "A":
                                        props.setProperty("sedi_A_bm", inputV1);
                                        sedi_A_bm = inputV1;
                                        break;
                                    case "B":
                                        props.setProperty("sedi_B_bm", inputV1);
                                        sedi_B_bm = inputV1;
                                        break;
                                    case "C":
                                        props.setProperty("sedi_C_bm", inputV1);
                                        sedi_C_bm = inputV1;
                                        break;
                                    case "D":
                                        props.setProperty("sedi_D_bm", inputV1);
                                        sedi_D_bm = inputV1;
                                        break;
                                    case "E":
                                        props.setProperty("sedi_E_bm", inputV1);
                                        sedi_E_bm = inputV1;
                                        break;
                                    case "F":
                                        props.setProperty("sedi_F_bm", inputV1);
                                        sedi_F_bm = inputV1;
                                        break;
                                    case "G":
                                        props.setProperty("sedi_G_bm", inputV1);
                                        sedi_G_bm = inputV1;
                                        break;
                                }
                                break;
                            case "Tension Interfacial Inhibida":
                                switch (selectedCategory.getText()) {
                                    case "O":
                                        props.setProperty("intertenINH_O_bm", inputV1);
                                        intertenINH_O_bm = inputV1;
                                        break;
                                    case "A":
                                        props.setProperty("intertenINH_A_bm", inputV1);
                                        intertenINH_A_bm = inputV1;
                                        break;
                                    case "B":
                                        props.setProperty("intertenINH_B_bm", inputV1);
                                        intertenINH_B_bm = inputV1;
                                        break;
                                    case "C":
                                        props.setProperty("intertenINH_C_bm", inputV1);
                                        intertenINH_C_bm = inputV1;
                                        break;
                                    case "D":
                                        props.setProperty("intertenINH_D_bm", inputV1);
                                        intertenINH_D_bm = inputV1;
                                        break;
                                    case "E":
                                        props.setProperty("intertenINH_E_bm", inputV1);
                                        intertenINH_E_bm = inputV1;
                                        break;
                                    case "F":
                                        props.setProperty("intertenINH_F_bm", inputV1);
                                        intertenINH_F_bm = inputV1;
                                        break;
                                    case "G":
                                        props.setProperty("intertenINH_G_bm", inputV1);
                                        intertenINH_G_bm = inputV1;
                                        break;
                                }
                                break;
                            case "Tension Interfacial Desinhibida":
                                switch (selectedCategory.getText()) {
                                    case "O":
                                        props.setProperty("intertenUNINH_O_bm", inputV1);
                                        intertenUNINH_O_bm = inputV1;
                                        break;
                                    case "A":
                                        props.setProperty("intertenUNINH_A_bm", inputV1);
                                        intertenUNINH_A_bm = inputV1;
                                        break;
                                    case "B":
                                        props.setProperty("intertenUNINH_B_bm", inputV1);
                                        intertenUNINH_B_bm = inputV1;
                                        break;
                                    case "C":
                                        props.setProperty("intertenUNINH_C_bm", inputV1);
                                        intertenUNINH_C_bm = inputV1;
                                        break;
                                    case "D":
                                        props.setProperty("intertenUNINH_D_bm", inputV1);
                                        intertenUNINH_D_bm = inputV1;
                                        break;
                                    case "E":
                                        props.setProperty("intertenUNINH_E_bm", inputV1);
                                        intertenUNINH_E_bm = inputV1;
                                        break;
                                    case "F":
                                        props.setProperty("intertenUNINH_F_bm", inputV1);
                                        intertenUNINH_F_bm = inputV1;
                                        break;
                                    case "G":
                                        props.setProperty("intertenUNINH_G_bm", inputV1);
                                        intertenUNINH_G_bm = inputV1;
                                        break;
                                }
                                break;
                            default:
                                System.out.println("Error");
                        }

                        FileOutputStream out = new FileOutputStream("src/main/resources/values.properties");

                        LocalDate currentDate = LocalDate.now();
                        props.setProperty("lastupdated",currentDate.format(formatter));

                        props.store(out, null);
                        out.close();

                    } catch (FileNotFoundException e) {
                        System.out.println("File not found.");
                    } catch (IOException e) {
                        System.out.println("Something wrong.");
                    }
                } else {
                    throw new NumberFormatException();
                }
            }

            if (inputV2 != null) {
                if(inputV2.equals("NA")) {
                    //Write NA
                    try {
                        FileInputStream in = new FileInputStream("src/main/resources/values.properties");
                        Properties props = new Properties();
                        props.load(in);
                        in.close();

                        switch (selectedProperty.getText()) {
                            case "Voltage":
                                switch (selectedCategory.getText()) {
                                    case "O":
                                        props.setProperty("volt_O_mg", "NA");
                                        volt_O_mg = "NA";
                                        break;
                                    case "A":
                                        props.setProperty("volt_A_mg", "NA");
                                        volt_A_mg = "NA";
                                        break;
                                    case "B":
                                        props.setProperty("volt_B_mg", "NA");
                                        volt_B_mg = "NA";
                                        break;
                                    case "C":
                                        props.setProperty("volt_C_mg", "NA");
                                        volt_C_mg = "NA";
                                        break;
                                    case "D":
                                        props.setProperty("volt_D_mg", "NA");
                                        volt_D_mg = "NA";
                                        break;
                                    case "E":
                                        props.setProperty("volt_E_mg", "NA");
                                        volt_E_mg = "NA";
                                        break;
                                    case "F":
                                        props.setProperty("volt_F_mg", "NA");
                                        volt_F_mg = "NA";
                                        break;
                                    case "G":
                                        props.setProperty("volt_G_mg", "NA");
                                        volt_G_mg = "NA";
                                        break;
                                }
                                break;
                            case "Cantidad de Agua":
                                switch (selectedCategory.getText()) {
                                    case "O":
                                        props.setProperty("wc_O_mg", "NA");
                                        wc_O_mg = "NA";
                                        break;
                                    case "A":
                                        props.setProperty("wc_A_mg", "NA");
                                        wc_A_mg = "NA";
                                        break;
                                    case "B":
                                        props.setProperty("wc_B_mg", "NA");
                                        wc_B_mg = "NA";
                                        break;
                                    case "C":
                                        props.setProperty("wc_C_mg", "NA");
                                        wc_C_mg = "NA";
                                        break;
                                    case "D":
                                        props.setProperty("wc_D_mg", "NA");
                                        wc_D_mg = "NA";
                                        break;
                                    case "E":
                                        props.setProperty("wc_E_mg", "NA");
                                        wc_E_mg = "NA";
                                        break;
                                    case "F":
                                        props.setProperty("wc_F_mg", "NA");
                                        wc_F_mg = "NA";
                                        break;
                                    case "G":
                                        props.setProperty("wc_G_mg", "NA");
                                        wc_G_mg = "NA";
                                        break;
                                }
                                break;
                            case "Acidez":
                                switch (selectedCategory.getText()) {
                                    case "O":
                                        props.setProperty("acid_O_mg", "NA");
                                        acid_O_mg = "NA";
                                        break;
                                    case "A":
                                        props.setProperty("acid_A_mg", "NA");
                                        acid_A_mg = "NA";
                                        break;
                                    case "B":
                                        props.setProperty("acid_B_mg", "NA");
                                        acid_B_mg = "NA";
                                        break;
                                    case "C":
                                        props.setProperty("acid_C_mg", "NA");
                                        acid_C_mg = "NA";
                                        break;
                                    case "D":
                                        props.setProperty("acid_D_mg", "NA");
                                        acid_D_mg = "NA";
                                        break;
                                    case "E":
                                        props.setProperty("acid_E_mg", "NA");
                                        acid_E_mg = "NA";
                                        break;
                                    case "F":
                                        props.setProperty("acid_F_mg", "NA");
                                        acid_F_mg = "NA";
                                        break;
                                    case "G":
                                        props.setProperty("acid_G_mg", "NA");
                                        acid_G_mg = "NA";
                                        break;
                                }
                                break;
                            case "Factor de Disipacion Dielectrica":
                                switch (selectedCategory.getText()) {
                                    case "O":
                                        props.setProperty("diel_O_mg", "NA");
                                        diel_O_mg = "NA";
                                        break;
                                    case "A":
                                        props.setProperty("diel_A_mg", "NA");
                                        diel_A_mg = "NA";
                                        break;
                                    case "B":
                                        props.setProperty("diel_B_mg", "NA");
                                        diel_B_mg = "NA";
                                        break;
                                    case "C":
                                        props.setProperty("diel_C_mg", "NA");
                                        diel_C_mg = "NA";
                                        break;
                                    case "D":
                                        props.setProperty("diel_D_mg", "NA");
                                        diel_D_mg = "NA";
                                        break;
                                    case "E":
                                        props.setProperty("diel_E_mg", "NA");
                                        diel_E_mg = "NA";
                                        break;
                                    case "F":
                                        props.setProperty("diel_F_mg", "NA");
                                        diel_F_mg = "NA";
                                        break;
                                    case "G":
                                        props.setProperty("diel_G_mg", "NA");
                                        diel_G_mg = "NA";
                                        break;
                                }
                                break;
                            case "Resistencia 20°":
                                switch (selectedCategory.getText()) {
                                    case "O":
                                        props.setProperty("resist20C_O_mg", "NA");
                                        resist20C_O_mg = "NA";
                                        break;
                                    case "A":
                                        props.setProperty("resist20C_A_mg", "NA");
                                        resist20C_A_mg = "NA";
                                        break;
                                    case "B":
                                        props.setProperty("resist20C_B_mg", "NA");
                                        resist20C_B_mg = "NA";
                                        break;
                                    case "C":
                                        props.setProperty("resist20C_C_mg", "NA");
                                        resist20C_C_mg = "NA";
                                        break;
                                    case "D":
                                        props.setProperty("resist20C_D_mg", "NA");
                                        resist20C_D_mg = "NA";
                                        break;
                                    case "E":
                                        props.setProperty("resist20C_E_mg", "NA");
                                        resist20C_E_mg = "NA";
                                        break;
                                    case "F":
                                        props.setProperty("resist20C_F_mg", "NA");
                                        resist20C_F_mg = "NA";
                                        break;
                                    case "G":
                                        props.setProperty("resist20C_G_mg", "NA");
                                        resist20C_G_mg = "NA";
                                        break;
                                }
                                break;
                            case "Resistencia 90°":
                                switch (selectedCategory.getText()) {
                                    case "O":
                                        props.setProperty("resist90C_O_mg", "NA");
                                        resist90C_O_mg = "NA";
                                        break;
                                    case "A":
                                        props.setProperty("resist90C_A_mg", "NA");
                                        resist90C_A_mg = "NA";
                                        break;
                                    case "B":
                                        props.setProperty("resist90C_B_mg", "NA");
                                        resist90C_B_mg = "NA";
                                        break;
                                    case "C":
                                        props.setProperty("resist90C_C_mg", "NA");
                                        resist90C_C_mg = "NA";
                                        break;
                                    case "D":
                                        props.setProperty("resist90C_D_mg", "NA");
                                        resist90C_D_mg = "NA";
                                        break;
                                    case "E":
                                        props.setProperty("resist90C_E_mg", "NA");
                                        resist90C_E_mg = "NA";
                                        break;
                                    case "F":
                                        props.setProperty("resist90C_F_mg", "NA");
                                        resist90C_F_mg = "NA";
                                        break;
                                    case "G":
                                        props.setProperty("resist90C_G_mg", "NA");
                                        resist90C_G_mg = "NA";
                                        break;
                                }
                                break;
                            case "Contenido Inhibidor":
                                switch (selectedCategory.getText()) {
                                    case "O":
                                        props.setProperty("inhib_O_mg", "NA");
                                        inhib_O_mg = "NA";
                                        break;
                                    case "A":
                                        props.setProperty("inhib_A_mg", "NA");
                                        inhib_A_mg = "NA";
                                        break;
                                    case "B":
                                        props.setProperty("inhib_B_mg", "NA");
                                        inhib_B_mg = "NA";
                                        break;
                                    case "C":
                                        props.setProperty("inhib_C_mg", "NA");
                                        inhib_C_mg = "NA";
                                        break;
                                    case "D":
                                        props.setProperty("inhib_D_mg", "NA");
                                        inhib_D_mg = "NA";
                                        break;
                                    case "E":
                                        props.setProperty("inhib_E_mg", "NA");
                                        inhib_E_mg = "NA";
                                        break;
                                    case "F":
                                        props.setProperty("inhib_F_mg", "NA");
                                        inhib_F_mg = "NA";
                                        break;
                                    case "G":
                                        props.setProperty("inhib_G_mg", "NA");
                                        inhib_G_mg = "NA";
                                        break;
                                }
                                break;
                            case "Contenido Pasivizador":
                                switch (selectedCategory.getText()) {
                                    case "O":
                                        props.setProperty("passiv_O_mg", "NA");
                                        passiv_O_mg = "NA";
                                        break;
                                    case "A":
                                        props.setProperty("passiv_A_mg", "NA");
                                        passiv_A_mg = "NA";
                                        break;
                                    case "B":
                                        props.setProperty("passiv_B_mg", "NA");
                                        passiv_B_mg = "NA";
                                        break;
                                    case "C":
                                        props.setProperty("passiv_C_mg", "NA");
                                        passiv_C_mg = "NA";
                                        break;
                                    case "D":
                                        props.setProperty("passiv_D_mg", "NA");
                                        passiv_D_mg = "NA";
                                        break;
                                    case "E":
                                        props.setProperty("passiv_E_mg", "NA");
                                        passiv_E_mg = "NA";
                                        break;
                                    case "F":
                                        props.setProperty("passiv_F_mg", "NA");
                                        passiv_F_mg = "NA";
                                        break;
                                    case "G":
                                        props.setProperty("passiv_G_mg", "NA");
                                        passiv_G_mg = "NA";
                                        break;
                                }
                                break;
                            case "Sedimento":
                                switch (selectedCategory.getText()) {
                                    case "O":
                                        props.setProperty("sedi_O_mg", "NA");
                                        sedi_O_mg = "NA";
                                        break;
                                    case "A":
                                        props.setProperty("sedi_A_mg", "NA");
                                        sedi_A_mg = "NA";
                                        break;
                                    case "B":
                                        props.setProperty("sedi_B_mg", "NA");
                                        sedi_B_mg = "NA";
                                        break;
                                    case "C":
                                        props.setProperty("sedi_C_mg", "NA");
                                        sedi_C_mg = "NA";
                                        break;
                                    case "D":
                                        props.setProperty("sedi_D_mg", "NA");
                                        sedi_D_mg = "NA";
                                        break;
                                    case "E":
                                        props.setProperty("sedi_E_mg", "NA");
                                        sedi_E_mg = "NA";
                                        break;
                                    case "F":
                                        props.setProperty("sedi_F_mg", "NA");
                                        sedi_F_mg = "NA";
                                        break;
                                    case "G":
                                        props.setProperty("sedi_G_mg", "NA");
                                        sedi_G_mg = "NA";
                                        break;
                                }
                                break;
                            case "Tension Interfacial Inhibida":
                                switch (selectedCategory.getText()) {
                                    case "O":
                                        props.setProperty("intertenINH_O_mg", "NA");
                                        intertenINH_O_mg = "NA";
                                        break;
                                    case "A":
                                        props.setProperty("intertenINH_A_mg", "NA");
                                        intertenINH_A_mg = "NA";
                                        break;
                                    case "B":
                                        props.setProperty("intertenINH_B_mg", "NA");
                                        intertenINH_B_mg = "NA";
                                        break;
                                    case "C":
                                        props.setProperty("intertenINH_C_mg", "NA");
                                        intertenINH_C_mg = "NA";
                                        break;
                                    case "D":
                                        props.setProperty("intertenINH_D_mg", "NA");
                                        intertenINH_D_mg = "NA";
                                        break;
                                    case "E":
                                        props.setProperty("intertenINH_E_mg", "NA");
                                        intertenINH_E_mg = "NA";
                                        break;
                                    case "F":
                                        props.setProperty("intertenINH_F_mg", "NA");
                                        intertenINH_F_mg = "NA";
                                        break;
                                    case "G":
                                        props.setProperty("intertenINH_G_mg", "NA");
                                        intertenINH_G_mg = "NA";
                                        break;
                                }
                                break;
                            case "Tension Interfacial Desinhibida":
                                switch (selectedCategory.getText()) {
                                    case "O":
                                        props.setProperty("intertenUNINH_O_mg", "NA");
                                        intertenUNINH_O_mg = "NA";
                                        break;
                                    case "A":
                                        props.setProperty("intertenUNINH_A_mg", "NA");
                                        intertenUNINH_A_mg = "NA";
                                        break;
                                    case "B":
                                        props.setProperty("intertenUNINH_B_mg", "NA");
                                        intertenUNINH_B_mg = "NA";
                                        break;
                                    case "C":
                                        props.setProperty("intertenUNINH_C_mg", "NA");
                                        intertenUNINH_C_mg = "NA";
                                        break;
                                    case "D":
                                        props.setProperty("intertenUNINH_D_mg", "NA");
                                        intertenUNINH_D_mg = "NA";
                                        break;
                                    case "E":
                                        props.setProperty("intertenUNINH_E_mg", "NA");
                                        intertenUNINH_E_mg = "NA";
                                        break;
                                    case "F":
                                        props.setProperty("intertenUNINH_F_mg", "NA");
                                        intertenUNINH_F_mg = "NA";
                                        break;
                                    case "G":
                                        props.setProperty("intertenUNINH_G_mg", "NA");
                                        intertenUNINH_G_mg = "NA";
                                        break;
                                }
                                break;
                            default:
                                System.out.println("Error");
                        }

                        FileOutputStream out = new FileOutputStream("src/main/resources/values.properties");

                        LocalDate currentDate = LocalDate.now();
                        props.setProperty("lastupdated",currentDate.format(formatter));

                        props.store(out, null);
                        out.close();

                    } catch (FileNotFoundException e) {
                        System.out.println("File not found.");
                    } catch (IOException e) {
                        System.out.println("Something wrong.");
                    }
                } else if (inputV2.matches("[0-9]+")) {
                    //Write value
                    try {
                        FileInputStream in = new FileInputStream("src/main/resources/values.properties");
                        Properties props = new Properties();
                        props.load(in);
                        in.close();

                        switch (selectedProperty.getText()) {
                            case "Voltage":
                                switch (selectedCategory.getText()) {
                                    case "O":
                                        props.setProperty("volt_O_mg", inputV2);
                                        volt_O_mg = inputV2;
                                        break;
                                    case "A":
                                        props.setProperty("volt_A_mg", inputV2);
                                        volt_A_mg = inputV2;
                                        break;
                                    case "B":
                                        props.setProperty("volt_B_mg", inputV2);
                                        volt_B_mg = inputV2;
                                        break;
                                    case "C":
                                        props.setProperty("volt_C_mg", inputV2);
                                        volt_C_mg = inputV2;
                                        break;
                                    case "D":
                                        props.setProperty("volt_D_mg", inputV2);
                                        volt_D_mg = inputV2;
                                        break;
                                    case "E":
                                        props.setProperty("volt_E_mg", inputV2);
                                        volt_E_mg = inputV2;
                                        break;
                                    case "F":
                                        props.setProperty("volt_F_mg", inputV2);
                                        volt_F_mg = inputV2;
                                        break;
                                    case "G":
                                        props.setProperty("volt_G_mg", inputV2);
                                        volt_G_mg = inputV2;
                                        break;
                                }
                                break;
                            case "Cantidad de Agua":
                                switch (selectedCategory.getText()) {
                                    case "O":
                                        props.setProperty("wc_O_mg", inputV2);
                                        wc_O_mg = inputV2;
                                        break;
                                    case "A":
                                        props.setProperty("wc_A_mg", inputV2);
                                        wc_A_mg = inputV2;
                                        break;
                                    case "B":
                                        props.setProperty("wc_B_mg", inputV2);
                                        wc_B_mg = inputV2;
                                        break;
                                    case "C":
                                        props.setProperty("wc_C_mg", inputV2);
                                        wc_C_mg = inputV2;
                                        break;
                                    case "D":
                                        props.setProperty("wc_D_mg", inputV2);
                                        wc_D_mg = inputV2;
                                        break;
                                    case "E":
                                        props.setProperty("wc_E_mg", inputV2);
                                        wc_E_mg = inputV2;
                                        break;
                                    case "F":
                                        props.setProperty("wc_F_mg", inputV2);
                                        wc_F_mg = inputV2;
                                        break;
                                    case "G":
                                        props.setProperty("wc_G_mg", inputV2);
                                        wc_G_mg = inputV2;
                                        break;
                                }
                                break;
                            case "Acidez":
                                switch (selectedCategory.getText()) {
                                    case "O":
                                        props.setProperty("acid_O_mg", inputV2);
                                        acid_O_mg = inputV2;
                                        break;
                                    case "A":
                                        props.setProperty("acid_A_mg", inputV2);
                                        acid_A_mg = inputV2;
                                        break;
                                    case "B":
                                        props.setProperty("acid_B_mg", inputV2);
                                        acid_B_mg = inputV2;
                                        break;
                                    case "C":
                                        props.setProperty("acid_C_mg", inputV2);
                                        acid_C_mg = inputV2;
                                        break;
                                    case "D":
                                        props.setProperty("acid_D_mg", inputV2);
                                        acid_D_mg = inputV2;
                                        break;
                                    case "E":
                                        props.setProperty("acid_E_mg", inputV2);
                                        acid_E_mg = inputV2;
                                        break;
                                    case "F":
                                        props.setProperty("acid_F_mg", inputV2);
                                        acid_F_mg = inputV2;
                                        break;
                                    case "G":
                                        props.setProperty("acid_G_mg", inputV2);
                                        acid_G_mg = inputV2;
                                        break;
                                }
                                break;
                            case "Factor de Disipacion Dielectrica":
                                switch (selectedCategory.getText()) {
                                    case "O":
                                        props.setProperty("diel_O_mg", inputV2);
                                        diel_O_mg = inputV2;
                                        break;
                                    case "A":
                                        props.setProperty("diel_A_mg", inputV2);
                                        diel_A_mg = inputV2;
                                        break;
                                    case "B":
                                        props.setProperty("diel_B_mg", inputV2);
                                        diel_B_mg = inputV2;
                                        break;
                                    case "C":
                                        props.setProperty("diel_C_mg", inputV2);
                                        diel_C_mg = inputV2;
                                        break;
                                    case "D":
                                        props.setProperty("diel_D_mg", inputV2);
                                        diel_D_mg = inputV2;
                                        break;
                                    case "E":
                                        props.setProperty("diel_E_mg", inputV2);
                                        diel_E_mg = inputV2;
                                        break;
                                    case "F":
                                        props.setProperty("diel_F_mg", inputV2);
                                        diel_F_mg = inputV2;
                                        break;
                                    case "G":
                                        props.setProperty("diel_G_mg", inputV2);
                                        diel_G_mg = inputV2;
                                        break;
                                }
                                break;
                            case "Resistencia 20°":
                                switch (selectedCategory.getText()) {
                                    case "O":
                                        props.setProperty("resist20C_O_mg", inputV2);
                                        resist20C_O_mg = inputV2;
                                        break;
                                    case "A":
                                        props.setProperty("resist20C_A_mg", inputV2);
                                        resist20C_A_mg = inputV2;
                                        break;
                                    case "B":
                                        props.setProperty("resist20C_B_mg", inputV2);
                                        resist20C_B_mg = inputV2;
                                        break;
                                    case "C":
                                        props.setProperty("resist20C_C_mg", inputV2);
                                        resist20C_C_mg = inputV2;
                                        break;
                                    case "D":
                                        props.setProperty("resist20C_D_mg", inputV2);
                                        resist20C_D_mg = inputV2;
                                        break;
                                    case "E":
                                        props.setProperty("resist20C_E_mg", inputV2);
                                        resist20C_E_mg = inputV2;
                                        break;
                                    case "F":
                                        props.setProperty("resist20C_F_mg", inputV2);
                                        resist20C_F_mg = inputV2;
                                        break;
                                    case "G":
                                        props.setProperty("resist20C_G_mg", inputV2);
                                        resist20C_G_mg = inputV2;
                                        break;
                                }
                                break;
                            case "Resistencia 90°":
                                switch (selectedCategory.getText()) {
                                    case "O":
                                        props.setProperty("resist90C_O_mg", inputV2);
                                        resist90C_O_mg = inputV2;
                                        break;
                                    case "A":
                                        props.setProperty("resist90C_A_mg", inputV2);
                                        resist90C_A_mg = inputV2;
                                        break;
                                    case "B":
                                        props.setProperty("resist90C_B_mg", inputV2);
                                        resist90C_B_mg = inputV2;
                                        break;
                                    case "C":
                                        props.setProperty("resist90C_C_mg", inputV2);
                                        resist90C_C_mg = inputV2;
                                        break;
                                    case "D":
                                        props.setProperty("resist90C_D_mg", inputV2);
                                        resist90C_D_mg = inputV2;
                                        break;
                                    case "E":
                                        props.setProperty("resist90C_E_mg", inputV2);
                                        resist90C_E_mg = inputV2;
                                        break;
                                    case "F":
                                        props.setProperty("resist90C_F_mg", inputV2);
                                        resist90C_F_mg = inputV2;
                                        break;
                                    case "G":
                                        props.setProperty("resist90C_G_mg", inputV2);
                                        resist90C_G_mg = inputV2;
                                        break;
                                }
                                break;
                            case "Contenido Inhibidor":
                                switch (selectedCategory.getText()) {
                                    case "O":
                                        props.setProperty("inhib_O_mg", inputV2);
                                        inhib_O_mg = inputV2;
                                        break;
                                    case "A":
                                        props.setProperty("inhib_A_mg", inputV2);
                                        inhib_A_mg = inputV2;
                                        break;
                                    case "B":
                                        props.setProperty("inhib_B_mg", inputV2);
                                        inhib_B_mg = inputV2;
                                        break;
                                    case "C":
                                        props.setProperty("inhib_C_mg", inputV2);
                                        inhib_C_mg = inputV2;
                                        break;
                                    case "D":
                                        props.setProperty("inhib_D_mg", inputV2);
                                        inhib_D_mg = inputV2;
                                        break;
                                    case "E":
                                        props.setProperty("inhib_E_mg", inputV2);
                                        inhib_E_mg = inputV2;
                                        break;
                                    case "F":
                                        props.setProperty("inhib_F_mg", inputV2);
                                        inhib_F_mg = inputV2;
                                        break;
                                    case "G":
                                        props.setProperty("inhib_G_mg", inputV2);
                                        inhib_G_mg = inputV2;
                                        break;
                                }
                                break;
                            case "Contenido Pasivizador":
                                switch (selectedCategory.getText()) {
                                    case "O":
                                        props.setProperty("passiv_O_mg", inputV2);
                                        passiv_O_mg = inputV2;
                                        break;
                                    case "A":
                                        props.setProperty("passiv_A_mg", inputV2);
                                        passiv_A_mg = inputV2;
                                        break;
                                    case "B":
                                        props.setProperty("passiv_B_mg", inputV2);
                                        passiv_B_mg = inputV2;
                                        break;
                                    case "C":
                                        props.setProperty("passiv_C_mg", inputV2);
                                        passiv_C_mg = inputV2;
                                        break;
                                    case "D":
                                        props.setProperty("passiv_D_mg", inputV2);
                                        passiv_D_mg = inputV2;
                                        break;
                                    case "E":
                                        props.setProperty("passiv_E_mg", inputV2);
                                        passiv_E_mg = inputV2;
                                        break;
                                    case "F":
                                        props.setProperty("passiv_F_mg", inputV2);
                                        passiv_F_mg = inputV2;
                                        break;
                                    case "G":
                                        props.setProperty("passiv_G_mg", inputV2);
                                        passiv_G_mg = inputV2;
                                        break;
                                }
                                break;
                            case "Sedimento":
                                switch (selectedCategory.getText()) {
                                    case "O":
                                        props.setProperty("sedi_O_mg", inputV2);
                                        sedi_O_mg = inputV2;
                                        break;
                                    case "A":
                                        props.setProperty("sedi_A_mg", inputV2);
                                        sedi_A_mg = inputV2;
                                        break;
                                    case "B":
                                        props.setProperty("sedi_B_mg", inputV2);
                                        sedi_B_mg = inputV2;
                                        break;
                                    case "C":
                                        props.setProperty("sedi_C_mg", inputV2);
                                        sedi_C_mg = inputV2;
                                        break;
                                    case "D":
                                        props.setProperty("sedi_D_mg", inputV2);
                                        sedi_D_mg = inputV2;
                                        break;
                                    case "E":
                                        props.setProperty("sedi_E_mg", inputV2);
                                        sedi_E_mg = inputV2;
                                        break;
                                    case "F":
                                        props.setProperty("sedi_F_mg", inputV2);
                                        sedi_F_mg = inputV2;
                                        break;
                                    case "G":
                                        props.setProperty("sedi_G_mg", inputV2);
                                        sedi_G_mg = inputV2;
                                        break;
                                }
                                break;
                            case "Tension Interfacial Inhibida":
                                switch (selectedCategory.getText()) {
                                    case "O":
                                        props.setProperty("intertenINH_O_mg", inputV2);
                                        intertenINH_O_mg = inputV2;
                                        break;
                                    case "A":
                                        props.setProperty("intertenINH_A_mg", inputV2);
                                        intertenINH_A_mg = inputV2;
                                        break;
                                    case "B":
                                        props.setProperty("intertenINH_B_mg", inputV2);
                                        intertenINH_B_mg = inputV2;
                                        break;
                                    case "C":
                                        props.setProperty("intertenINH_C_mg", inputV2);
                                        intertenINH_C_mg = inputV2;
                                        break;
                                    case "D":
                                        props.setProperty("intertenINH_D_mg", inputV2);
                                        intertenINH_D_mg = inputV2;
                                        break;
                                    case "E":
                                        props.setProperty("intertenINH_E_mg", inputV2);
                                        intertenINH_E_mg = inputV2;
                                        break;
                                    case "F":
                                        props.setProperty("intertenINH_F_mg", inputV2);
                                        intertenINH_F_mg = inputV2;
                                        break;
                                    case "G":
                                        props.setProperty("intertenINH_G_mg", inputV2);
                                        intertenINH_G_mg = inputV2;
                                        break;
                                }
                                break;
                            case "Tension Interfacial Desinhibida":
                                switch (selectedCategory.getText()) {
                                    case "O":
                                        props.setProperty("intertenUNINH_O_mg", inputV2);
                                        intertenUNINH_O_mg = inputV2;
                                        break;
                                    case "A":
                                        props.setProperty("intertenUNINH_A_mg", inputV2);
                                        intertenUNINH_A_mg = inputV2;
                                        break;
                                    case "B":
                                        props.setProperty("intertenUNINH_B_mg", inputV2);
                                        intertenUNINH_B_mg = inputV2;
                                        break;
                                    case "C":
                                        props.setProperty("intertenUNINH_C_mg", inputV2);
                                        intertenUNINH_C_mg = inputV2;
                                        break;
                                    case "D":
                                        props.setProperty("intertenUNINH_D_mg", inputV2);
                                        intertenUNINH_D_mg = inputV2;
                                        break;
                                    case "E":
                                        props.setProperty("intertenUNINH_E_mg", inputV2);
                                        intertenUNINH_E_mg = inputV2;
                                        break;
                                    case "F":
                                        props.setProperty("intertenUNINH_F_mg", inputV2);
                                        intertenUNINH_F_mg = inputV2;
                                        break;
                                    case "G":
                                        props.setProperty("intertenUNINH_G_mg", inputV2);
                                        intertenUNINH_G_mg = inputV2;
                                        break;
                                }
                                break;
                            default:
                                System.out.println("Error");
                        }

                        FileOutputStream out = new FileOutputStream("src/main/resources/values.properties");

                        LocalDate currentDate = LocalDate.now();
                        props.setProperty("lastupdated",currentDate.format(formatter));

                        props.store(out, null);
                        out.close();

                    } catch (FileNotFoundException e) {
                        System.out.println("File not found.");
                    } catch (IOException e) {
                        System.out.println("Something wrong.");
                    }
                } else {
                    throw new NumberFormatException();
                }
            }
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR,"Valor invalido!",ButtonType.OK);
            alert.show();
        }
    }

    public void settingsResetVCT1 (MouseEvent evt) {
        settingsTest1VCField1.setText(null);
        settingsTest1VCField2.setText(null);
    }
}