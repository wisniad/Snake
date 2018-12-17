import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.LinkedList;
import java.util.Random;

public class DrawingFunctionality {
    public static void drawAll(SnakeGameInterface snakeGameInterface, LinkedList<Food> foodPack, LinkedList<SnakePart> fullSnakeBody, Fields[][] gameBoard, GridPane grid) {
        //DRAW CLEAN BOARD
        for (int row = 0; row < 20; row++) {
            for (int col = 0; col < 20; col++) {
                Rectangle rectangle = SnakeGameInterface.getNodeByRowColumnIndex(row, col, grid);
                rectangle.setFill(Color.BLACK);
                gameBoard[row][col] = Fields.EMPTY;
            }
        }
        // DRAW SNAKE
        for (int i = 0; i < fullSnakeBody.size(); i++) {
            fullSnakeBody.get(i).getBodyPart().printSnake(grid, fullSnakeBody.get(i).getPosX(), fullSnakeBody.get(i).getPosY(), Color.BLACK, snakeGameInterface);
        }
        // DRAW FOOD
        for (int i = 0; i < foodPack.size(); i++) {
            foodPack.get(i).getFood().printSnake(grid, foodPack.get(i).getPosX(), foodPack.get(i).getPosY(), foodPack.get(i).getColor(), snakeGameInterface);
        }
        /*// DRAW CONSOLE
        for (int row = 0; row < gameBoard.length; row++) {
            if (row < 10) {
                System.out.print("0" + row);
            } else {
                System.out.print(row);
            }
            for (int col = 0; col < gameBoard.length; col++) {
                if (gameBoard[row][col] == Fields.EMPTY) {
                    System.out.print(" - ");
                } else if (gameBoard[row][col] == Fields.HEAD) {
                    System.out.print(" Y ");
                } else if (gameBoard[row][col] == Fields.BODY) {
                    System.out.print(" I ");
                } else if (gameBoard[row][col] == Fields.FOOD) {
                    System.out.print(" X ");
                }
            }
            System.out.print("\n");

        }
        */
    }

    public static void keyPressed(SnakeGameInterface snakeGameInterface, LinkedList<Food> foodPack, LinkedList<SnakePart> fullSnakeBody, Fields[][] gameBoard, Random rand, KeyCode code, GridPane grid) {

        if (code == KeyCode.UP) {
            if (fullSnakeBody.get(0).getPosX() > 0) {
                LinkedList<SnakePart> snakeMove = new LinkedList<>();
                for (int i = 0; i < fullSnakeBody.size(); i++) {
                    if (fullSnakeBody.get(i).getBodyPart() == Fields.HEAD) {
                        snakeMove.add(
                                new SnakePart(fullSnakeBody.get(i).getBodyPart()
                                        , fullSnakeBody.get(i).getPosX() - 1
                                        , fullSnakeBody.get(i).getPosY()
                                ));
                    } else if (fullSnakeBody.get(i).getBodyPart() == Fields.BODY) {
                        snakeMove.add(
                                new SnakePart(fullSnakeBody.get(i).getBodyPart()
                                        , fullSnakeBody.get(i - 1).getPosX()
                                        , fullSnakeBody.get(i - 1).getPosY()
                                ));
                    }
                }
                // ADD NEW SNAKE BODY
                fullSnakeBody.clear();
                fullSnakeBody.addAll(snakeMove);


            }
        } else if (code == KeyCode.LEFT) {
            if (fullSnakeBody.get(0).getPosY() > 0) {

                LinkedList<SnakePart> snakeMove = new LinkedList<>();
                for (int i = 0; i < fullSnakeBody.size(); i++) {
                    if (fullSnakeBody.get(i).getBodyPart() == Fields.HEAD) {
                        snakeMove.add(
                                new SnakePart(fullSnakeBody.get(i).getBodyPart()
                                        , fullSnakeBody.get(i).getPosX()
                                        , fullSnakeBody.get(i).getPosY() - 1
                                ));
                    } else if (fullSnakeBody.get(i).getBodyPart() == Fields.BODY) {
                        snakeMove.add(
                                new SnakePart(fullSnakeBody.get(i).getBodyPart()
                                        , fullSnakeBody.get(i - 1).getPosX()
                                        , fullSnakeBody.get(i - 1).getPosY()
                                ));
                    }
                }
                // ADD NEW SNAKE BODY
                fullSnakeBody.clear();
                fullSnakeBody.addAll(snakeMove);
            }
        } else if (code == KeyCode.DOWN) {
            if (fullSnakeBody.get(0).getPosX() < 19) {

                LinkedList<SnakePart> snakeMove = new LinkedList<>();
                for (int i = 0; i < fullSnakeBody.size(); i++) {
                    if (fullSnakeBody.get(i).getBodyPart() == Fields.HEAD) {
                        snakeMove.add(
                                new SnakePart(fullSnakeBody.get(i).getBodyPart()
                                        , fullSnakeBody.get(i).getPosX() + 1
                                        , fullSnakeBody.get(i).getPosY()
                                ));
                    } else if (fullSnakeBody.get(i).getBodyPart() == Fields.BODY) {
                        snakeMove.add(
                                new SnakePart(fullSnakeBody.get(i).getBodyPart()
                                        , fullSnakeBody.get(i - 1).getPosX()
                                        , fullSnakeBody.get(i - 1).getPosY()
                                ));
                    }
                }
                // ADD NEW SNAKE BODY
                fullSnakeBody.clear();
                fullSnakeBody.addAll(snakeMove);
            }
        } else if (code == KeyCode.RIGHT) {
            if (fullSnakeBody.get(0).getPosY() < 19) {
                LinkedList<SnakePart> snakeMove = new LinkedList<>();
                for (int i = 0; i < fullSnakeBody.size(); i++) {
                    if (fullSnakeBody.get(i).getBodyPart() == Fields.HEAD) {
                        snakeMove.add(
                                new SnakePart(fullSnakeBody.get(i).getBodyPart()
                                        , fullSnakeBody.get(i).getPosX()
                                        , fullSnakeBody.get(i).getPosY() + 1
                                ));
                    } else if (fullSnakeBody.get(i).getBodyPart() == Fields.BODY) {
                        snakeMove.add(
                                new SnakePart(fullSnakeBody.get(i).getBodyPart()
                                        , fullSnakeBody.get(i - 1).getPosX()
                                        , fullSnakeBody.get(i - 1).getPosY()
                                ));
                    }
                }
                // ADD NEW SNAKE BODY
                fullSnakeBody.clear();
                fullSnakeBody.addAll(snakeMove);
            }
        }


        EatingFoodClass.eatFood(foodPack, fullSnakeBody, rand);
        drawAll(snakeGameInterface, foodPack, fullSnakeBody, gameBoard, grid);


    }
}
