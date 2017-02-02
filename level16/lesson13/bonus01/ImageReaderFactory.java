package com.javarush.test.level16.lesson13.bonus01;

import com.javarush.test.level16.lesson13.bonus01.common.*;

/**
 * Created by User on 02/02/17.
 */
public class ImageReaderFactory {
    public static ImageReader getReader (ImageTypes type)
    {
        ImageReader result;
        if (type!=null) {
            switch (type) {
                case BMP:
                    return new BmpReader();
                case JPG:
                    return new JpgReader();
                case PNG:
                    return new PngReader();
                    default: throw new IllegalArgumentException("Неизвестный тип картинки");


            }
        }
        else
         throw new IllegalArgumentException("Неизвестный тип картинки");
    }
}
