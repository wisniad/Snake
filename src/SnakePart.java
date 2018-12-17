public class SnakePart {
    Fields bodyPart;
    int posX;
    int posY;

    public SnakePart() { }

    public SnakePart(Fields bodyPart, int posX, int posY) {
        this.bodyPart = bodyPart;
        this.posX = posX;
        this.posY = posY;
    }

    public Fields getBodyPart() {
        return bodyPart;
    }

    public void setBodyPart(Fields bodyPart) {
        this.bodyPart = bodyPart;
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
