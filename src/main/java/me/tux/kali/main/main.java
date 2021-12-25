package me.tux.kali.main;

import me.tux.kali.util.SizeUtils;
import me.tux.kali.util.TerminalUtils;


import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.awt.image.BufferedImage;
import java.util.Optional;
import java.util.Scanner;

public class main {

    private static final Scanner dir = new Scanner(System.in);

    private static final Scanner sizex = new Scanner(System.in);
    private static final Scanner sizey = new Scanner(System.in);

    public static void main(String[] args) {


            System.out.println(" _________\n" + "|  _____  |\\\n" + "| |\\ ___| | \\\n" + "| | |   | | |\n" + "| | |___| | |\n" + "\\ | |____\\| |\n" + " \\|_________| " + TerminalUtils.SKIP);
            System.out.println("Image Resizer by tuxiscool");

        System.out.print(TerminalUtils.SKIP + "Please enter image directory. ");
        String dirval = dir.nextLine();

        try {

            File findfile = new File(dirval);

            if (findfile.getName().endsWith(".png") || findfile.getName().endsWith(".PNG")
                    || findfile.getName().endsWith(".jpg") || findfile.getName().endsWith(".jpg")
                    || findfile.getName().endsWith(".tiff") || findfile.getName().endsWith(".TIFF")) {

                BufferedImage bimg = ImageIO.read(new File(String.valueOf(findfile)));
                int width = bimg.getWidth();
                int height = bimg.getHeight();

                System.out.println("W: " + width + TerminalUtils.SKIP);
                System.out.println("H: " + height);

                System.out.print(TerminalUtils.SKIP + "Please enter resized Width value. ");
                int sizexval = Integer.parseInt(sizex.nextLine());


                System.out.print(TerminalUtils.SKIP + "Please enter resized Height value. ");
                int sizeyval = Integer.parseInt(sizey.nextLine());

                String str = String.valueOf(findfile);
                if (!str.contains(".")) {

                } else {
                    str = str.substring(0, str.lastIndexOf("."));
                }
                File source = new File(dirval);
                String filename = source.getName();

                String extension = Optional.of(filename)
                        .filter(f -> f.contains("."))
                        .map(f -> f.substring(filename.lastIndexOf(".") + 1))
                        .orElse("");

                SizeUtils.resizeFile(String.valueOf(findfile), str + "-modified." + extension, sizexval, sizeyval);


                System.out.print(System.lineSeparator() + "Completed modifying images.");
            } else {
                System.out.println("Filetype unsupported.");

            }

        } catch (Exception e) {
            System.out.println("Failed.");
        }
    }
}


