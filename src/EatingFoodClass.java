import javafx.scene.paint.Color;

import java.util.LinkedList;
import java.util.Random;

public class EatingFoodClass {
    static void eatFood(LinkedList<Food> foodPack, LinkedList<SnakePart> fullSnakeBody, Random rand) {
        int workingSize = fullSnakeBody.size() - 1;
        if (fullSnakeBody.get(0).getPosY() == foodPack.get(0).getPosY()
                && fullSnakeBody.get(0).getPosX() == foodPack.get(0).getPosX()) {
            fullSnakeBody.add(new SnakePart(Fields.BODY, fullSnakeBody.get(workingSize).getPosX(), fullSnakeBody.get(workingSize).getPosY() - 1));
            foodPack.removeFirst();
            if (rand.nextInt(2) + 1 == 2) {
                foodPack.add(new Food(Fields.FOOD, Color.RED, rand.nextInt(20), rand.nextInt(20)));
            } else {
                foodPack.add(new Food(Fields.FOOD, Color.BLUE, rand.nextInt(20), rand.nextInt(20)));
            }

        }

    }

    public static void createSnakeAndFood(LinkedList<Food> foodPack, LinkedList<SnakePart> fullSnakeBody, Random rand) {
        fullSnakeBody.add(new SnakePart(Fields.HEAD, 10, 10));
        fullSnakeBody.add(new SnakePart(Fields.BODY, 10, 9));
        fullSnakeBody.add(new SnakePart(Fields.BODY, 10, 8));
        fullSnakeBody.add(new SnakePart(Fields.BODY, 9, 8));
        fullSnakeBody.add(new SnakePart(Fields.BODY, 9, 7));

        foodPack.add(new Food(Fields.FOOD, Color.RED, rand.nextInt(19), rand.nextInt(19)));
    }
}
