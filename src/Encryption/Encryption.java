package Encryption;

import java.util.HashMap;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Encryption extends Application
{
   Label lblcenter = new Label();

   @Override
   public void start (Stage primaryStage)
   {
      BorderPane root = new BorderPane();

      StackPane sp = new StackPane();
      sp.getChildren().add(lblcenter);
      root.setCenter(sp);

      GridPane gp = new GridPane();
      gp.setPadding(new Insets(10, 10, 10, 130));
      gp.setHgap(10);
      Label lbltop_input = new Label("Enter text to encrypt: ");
      TextField txt_input = new TextField();
      gp.add(lbltop_input, 0, 0);
      gp.add(txt_input, 1, 0);
      root.setTop(gp);

      txt_input.setOnAction(new EventHandler<ActionEvent>()
      {
         @Override
         public void handle (ActionEvent event)
         {
            String message = txt_input.getText().toLowerCase();
            String output = encrypt(message);
            lblcenter.setText(output);
         }
      });

      Scene scene = new Scene(root, 600, 350);
      primaryStage.setTitle("Encryption - Cipher ");
      primaryStage.setScene(scene);
      primaryStage.show();
   }

   public String[] splitStr (String text)
   {
      String[] split = text.split("");
      return split;
   }

   public String encrypt (String message)
   {
      HashMap<String, String> cipher = new HashMap<String, String>();
      cipher.put("a", "!");
      cipher.put("b", "@");
      cipher.put("c", "# ");
      cipher.put("d", "$");
      cipher.put("e", "% ");
      cipher.put("f", "^");
      cipher.put("g", "& ");
      cipher.put("h", "* *");
      cipher.put("i", "( ");
      cipher.put("j", "- --");
      cipher.put("k", ")");
      cipher.put("l", "=+");
      cipher.put("m", "= ?");
      cipher.put("n", "}  ");
      cipher.put("o", "| _");
      cipher.put("p", ": ");
      cipher.put("q", ";");
      cipher.put("r", " ");
      cipher.put("s", "& ~");
      cipher.put("t", ".. ,");
      cipher.put("u", "/  /");
      cipher.put("v", "| |");
      cipher.put("w", "$ ]");
      cipher.put("x", "> ");
      cipher.put("y", "+ <");
      cipher.put("z", "#  _");
      cipher.put("@", "$_##");
      cipher.put(" ", "& %_ _");

      String splitedStr[] = splitStr(message);
      String output = "";
      for (int i = 0; i < cipher.size(); i++) {

         for (int j = 0; j < splitedStr.length; j++) {
            if (cipher.keySet().toArray()[i].equals(splitedStr[j])) {
               output += cipher.get(cipher.keySet().toArray()[i]);
            }
         }
      }
      return output;
   }

   public static void main (String[] args)
   {
      launch(args);
   }
}
