package org.example;

import com.indvd00m.ascii.render.Render;
import com.indvd00m.ascii.render.api.ICanvas;
import com.indvd00m.ascii.render.api.IContextBuilder;
import com.indvd00m.ascii.render.api.IRender;
import com.indvd00m.ascii.render.elements.PseudoText;

public class Main {

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Error: Please enter your name.");
            return;
        }

        String name = args[0];
        String language = args.length > 1 ? args[1].toLowerCase() : "hun";

        String greeting;

        switch (language) {
            case "hun":
                greeting = "Szia, " + name + "!";
                break;

            case "eng":
                greeting = "Hello, " + name + "!";
                break;

            case "hin":
                greeting = "Namaste, " + name + "!";
                break;

            default:
                System.out.println("Error: Unknown language.");
                return;
        }

        IRender render = new Render();
        IContextBuilder builder = render.newBuilder();

        builder.width(100).height(15);
        builder.element(new PseudoText(greeting));

        ICanvas canvas = render.render(builder.build());

        System.out.println(canvas.getText());
    }
}