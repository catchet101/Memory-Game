package Entity;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Card {
    //******************************************************************************************************************
    //* variables
    //******************************************************************************************************************
    // Card size settings
    public final int cardWidth = 80;
    public final int cardLength = 100;

    // Sprite related variables
    private BufferedImage back, front;
    public boolean flipped = false;

    //******************************************************************************************************************
    //* constructor
    //******************************************************************************************************************
    public Card(Symbol symbol) {
        getCardImage(symbol);
    }

    //******************************************************************************************************************
    //* methods
    //******************************************************************************************************************
    /**
     * Retrieves the images for the card
     */
    private void getCardImage(Symbol symbol) {
        try {
            back = ImageIO.read(Objects.requireNonNull(getClass().getResource("/Resources/tempCardBack.png")));
            switch (symbol) {
                case Diamond -> front = ImageIO.read(Objects.requireNonNull(getClass().getResource("/Resources/tempCardDiamond.png")));
                case Club -> front = ImageIO.read(Objects.requireNonNull(getClass().getResource("/Resources/tempCardClub.png")));
                case Heart -> front = ImageIO.read(Objects.requireNonNull(getClass().getResource("/Resources/tempCardHeart.png")));
                case Spade -> front = ImageIO.read(Objects.requireNonNull(getClass().getResource("/Resources/tempCardSpade.png")));
                case Circle -> front = ImageIO.read(Objects.requireNonNull(getClass().getResource("/Resources/tempCardCircle.png")));
                case Triangle -> front = ImageIO.read(Objects.requireNonNull(getClass().getResource("/Resources/tempCardTriangle.png")));
                case Square -> front = ImageIO.read(Objects.requireNonNull(getClass().getResource("/Resources/tempCardSquare.png")));
                case Hexagon -> front = ImageIO.read(Objects.requireNonNull(getClass().getResource("/Resources/tempCardHexagon.png")));
            }
        }
        catch (IOException e) {
            System.out.println("Card image loading not working");
            e.printStackTrace();
        }
    }

    /**
     * Flips the card so the displayed sprite is changed
     */
    public void flip() {
        flipped = !flipped;
    }

    /**
     * Draws the sprite for this card
     * @param g2 the Graphics2D object used to draw
     */
    public void draw(Graphics2D g2) {
        if (flipped) {
            g2.drawImage(front, 24, 14, cardWidth, cardLength, null);
        }
        else {
            g2.drawImage(back, 24, 14, cardWidth, cardLength, null);
        }
    }

}