import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public enum Fields {
    HEAD, BODY, EMPTY, FOOD;

    public void printSnake(GridPane grid, int posX, int posY, Color color, SnakeGameInterface snakeGameInterface) {
        if (this == HEAD) {
            Rectangle rectangle = SnakeGameInterface.getNodeByRowColumnIndex(posX, posY, grid);
            rectangle.setFill(Color.PINK);
            snakeGameInterface.gameBoard[posX][posY] = HEAD;
        } else if (this == BODY) {
            Rectangle rectangle = SnakeGameInterface.getNodeByRowColumnIndex(posX, posY, grid);
            rectangle.setFill(Color.GREEN);
            snakeGameInterface.gameBoard[posX][posY] = BODY;
        } else if (this == FOOD) {
            Rectangle rectangle = SnakeGameInterface.getNodeByRowColumnIndex(posX, posY, grid);
            if (color == Color.RED) {
                rectangle.setFill(Color.RED);
                snakeGameInterface.gameBoard[posX][posY] = FOOD;
            } else {
                rectangle.setFill(Color.BLUE);
                snakeGameInterface.gameBoard[posX][posY] = FOOD;
            }
        }

    }
}
