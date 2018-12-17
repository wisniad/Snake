
import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class SnakeGameInterface extends Application {
    LinkedList<SnakePart> fullSnakeBody = new LinkedList<SnakePart>();
    LinkedList<Food> foodPack = new LinkedList<Food>();
    final GridPane grid = new GridPane();
    Random rand = new Random();
    Fields[][] gameBoard = new Fields[20][20];
    KeyCode lastClick = KeyCode.ENTER;
    boolean doOnce = false;

    @Override
    public void start(Stage primaryStage) throws Exception {
        int sceneWidth = 460;
        int sceneHeight = 460;
        int rowNum = 20;
        int colNum = 20;

        Color[] colors = {Color.BLACK, Color.BLUE, Color.GREEN, Color.RED};
        for (int row = 0; row < rowNum; row++) {
            for (int col = 0; col < colNum; col++) {
                Rectangle rec = new Rectangle();
                rec.setWidth(sceneWidth / colNum);
                rec.setHeight(sceneHeight / rowNum);
                rec.setFill(colors[0]);
                GridPane.setRowIndex(rec, row);
                GridPane.setColumnIndex(rec, col);
                grid.getChildren().addAll(rec);
            }
        }
        Scene scene = new Scene(grid, sceneWidth, sceneHeight);

        primaryStage.setTitle("Wąż Nocą");
        primaryStage.setScene(scene);
        primaryStage.show();
        EatingFoodClass.createSnakeAndFood(foodPack, fullSnakeBody, rand);
        DrawingFunctionality.drawAll(this, foodPack, fullSnakeBody, gameBoard, grid);

        scene.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                lastClick = event.getCode();

                if(!doOnce) {
                    Runnable helloRunnable = new Runnable() {
                        public void run() {
                            DrawingFunctionality.keyPressed(SnakeGameInterface.this, foodPack, fullSnakeBody, gameBoard, rand, lastClick, grid);
                        }
                    };
                    ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
                    executor.scheduleAtFixedRate(helloRunnable, 0, 150, TimeUnit.MILLISECONDS);
                    doOnce = true;
                }
            }
        });


    }

    public static void main(String[] args) {
        launch(args);
    }



    public static Rectangle getNodeByRowColumnIndex(final int row, final int column, GridPane gridPane) {
        Node result = null;
        ObservableList<Node> children = gridPane.getChildren();

        for (Node node : children) {
            if (GridPane.getRowIndex(node) == row && GridPane.getColumnIndex(node) == column) {
                result = node;
                break;
            }
        }
        if (result == null) {
            throw new IllegalArgumentException("Ivalid grid coordinates: " + row + " " + column);
        }

        return (Rectangle) result;
    }
}