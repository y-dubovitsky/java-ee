package dev.tag.jsp2;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.*;
import java.nio.file.Files;
import java.util.List;

public class ChangeBodyContentTag2 extends SimpleTagSupport {

    //TODO С путями разобраться
    private static final File file = new File("/WEB-INF/resources/html.txt");

    @Override
    public void doTag() throws JspException, IOException {
        StringWriter writer = new StringWriter();
        //! getFileContent(file, writer);
        getJspBody().invoke(writer); //* Записываем в объект writer содержание тела тега
        getJspContext().getOut().println(writer.toString().toUpperCase() + " ..... ");
    }

    /**
     * Reads all lines from a file and writes them to the author
     */
    private Writer getFileContent(File file, Writer writer) {
        try {
            if (file != null) {
                List<String> stringList = Files.readAllLines(file.toPath());
                for (String s : stringList) {
                    writer.write(s);
                }
            } else {
                throw new FileNotFoundException();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return writer;
    }
}
