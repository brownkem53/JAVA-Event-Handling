import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
/**
 *
 * @author $Shivang Shingala, you miss 100% of the shots you don't take
 * Submission date: 11-08-2021
 * Assignment 6: Event Handling and JavaFX
 */
public class Assignment6 extends Application implements EventHandler<Event>{
    
    private Image flagImage;
    private Label label,labelAllignment,labelTextGap;  
    private ComboBox<String> comboBoxAlignment;
    private TextField textGap;
    private BorderPane flagPane;
    private ImageView holdingImage;
    private VBox flagBox;
    
    @Override
    public void start(Stage primaryStage) {
        
        labelAllignment = new Label("Allignment");
        label = new Label("CANADA");
        labelTextGap = new Label("Text Gap");
        
        textGap = new TextField();
        textGap.setMaxWidth(60);
        comboBoxAlignment = new ComboBox<>();
        comboBoxAlignment.getItems().addAll("BOTTOM","TOP","LEFT","RIGHT");
        ImageView image = new ImageView("image/ca.gif");              
        comboBoxAlignment.setOnAction(this::handle);

        flagBox = new VBox();
        flagBox.setAlignment(Pos.CENTER);
        flagBox.getChildren().add(label);
//        flagBox.getChildren().add(image);
            
        flagPane = new BorderPane();
        holdingImage = new ImageView(flagImage);
        holdingImage.setFitHeight(350);
        holdingImage.setFitWidth(350);
        flagPane.setTop(flagBox);
        flagPane.setCenter(holdingImage);
        flagPane.setCenter(image);
     
        
        var hBox = new HBox();
        hBox.setPadding(new Insets(10,10,10,10));
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(labelAllignment, comboBoxAlignment,labelTextGap,textGap);
        
        
        VBox rootBox = new VBox();
        rootBox.setSpacing(0);
        rootBox.setAlignment(Pos.CENTER);
        rootBox.setPadding(new Insets(10,10,10,10));
        rootBox.getChildren().addAll(flagPane,hBox);
        
        
        
        Scene scene = new Scene(rootBox,700,700);
       
        primaryStage.setTitle("Shingala Shivang, 991600162"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
 
    }
    
        //Event handler
    public void handle(Event event) {
        if(event.getSource().equals(comboBoxAlignment)) {
        int gapBetween =0;
        //Bottom Alignment
        if(comboBoxAlignment.getSelectionModel().getSelectedIndex()==0) {
        flagPane.getChildren().removeAll(holdingImage, flagBox);
        flagPane.setTop(holdingImage);
        flagPane.setBottom(flagBox);

        if(!textGap.getText().equals("")) {
        gapBetween = Integer.parseInt(textGap.getText());
        flagBox.setPadding(new Insets(0,0, gapBetween,0));
        }
        }

        if(comboBoxAlignment.getSelectionModel().getSelectedIndex()==1)
        {
        flagPane.getChildren().removeAll(holdingImage, flagBox);
        flagPane.setBottom(holdingImage);
        flagPane.setTop(flagBox);
        if(!textGap.getText().equals(""))
        {
        gapBetween = Integer.parseInt(textGap.getText());
        flagBox.setPadding(new Insets(gapBetween,0,0,0));
        }
        }

        if(comboBoxAlignment.getSelectionModel().getSelectedIndex()==2)
        {
        flagPane.getChildren().removeAll(holdingImage, flagBox);
        flagPane.setRight(holdingImage);
        flagPane.setLeft(flagBox);
        if(!textGap.getText().equals(""))
        {
        gapBetween = Integer.parseInt(textGap.getText());
        flagBox.setPadding(new Insets(0,0,0, gapBetween));
        }
        }

        if(comboBoxAlignment.getSelectionModel().getSelectedIndex()==3)
        {
        flagPane.getChildren().removeAll(holdingImage, flagBox);
        flagPane.setLeft(holdingImage);
        flagPane.setRight(flagBox);
        if(!textGap.getText().equals(""))
        {
        gapBetween = Integer.parseInt(textGap.getText());
        flagBox.setPadding(new Insets(0, gapBetween,0,0));
        }
        }
        }
        }

        public static void main(String args[]){
            launch(args);
            }

        }
    
