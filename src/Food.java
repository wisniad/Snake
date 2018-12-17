import javafx.scene.paint.Color;

public class Food {
    Fields food;
    Color color;
    int posX;
    int posY;

    public Food() {}
    public Food(Fields food, Color color, int posX, int posY) {
        this.food = food;
        this.color = color;
        this.posX = posX;
        this.posY = posY;
    }

    public Fields getFood() {
        return food;
    }

    public void setFood(Fields food) {
        this.food = food;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
}
