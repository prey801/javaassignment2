# javaassignment2
# Pet Selector Demo

This Java Swing application demonstrates how to create a simple pet selector with radio buttons and images.

## Features

* **User-friendly interface:**  Select your favorite pet with easy-to-use radio buttons.
* **Image display:**  The selected pet's image is dynamically loaded and displayed.
* **Image scaling:** Images are scaled to fit the display area while maintaining their aspect ratio.

## How It Works

The application is built using Java Swing, a GUI toolkit. 

1. **JFrame:**  The main window of the application is created using a `JFrame`.
2. **JRadioButton:** Radio buttons for each pet (Bird, Cat, Dog, Rabbit, Pig) are created. Only one radio button can be selected at a time.
3. **JLabel:** A `JLabel` is used to display the image of the selected pet.
4. **ActionListener:** When a radio button is clicked, an `ActionListener` is triggered. This listener:
   * Calls the `updateImage()` method, passing the name of the selected pet.
   * Updates the `JLabel` with the corresponding image.
5. **Image Loading:** The `updateImage()` method:
   * Uses the `ImageIO.read()` method to load the image from a URL.
   * Creates an `ImageIcon` from the loaded image.
   * Sets the `ImageIcon` as the icon for the `JLabel`, displaying the image.
6. **Image Scaling:** The `getScaledImage()` method ensures that the image is resized to fit the `JLabel` while maintaining its aspect ratio.

## Usage

1. **Run the `Main.java` file.**
2. **Select a pet from the radio buttons.**
3. **The corresponding image will be displayed.**

## Requirements

* Java Development Kit (JDK)

## Instructions

1. **Download or clone this repository.**
2. **Open the `src/main/java/Main.java` file in your IDE.**
3. **Compile and run the application.**

## Notes

* The image URLs are provided as placeholders. Replace them with your own image URLs for different pets.
* You can customize the pet options and images to your liking.

## License

This project is licensed under the MIT License.
