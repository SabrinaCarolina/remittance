package br.com.adrianoaluizio.models.dto;

import br.com.adrianoaluizio.processors.AttSpecProcessor;
import br.com.adrianoaluizio.processors.AttSpecProcessorAssistant;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

public interface Layout<H, D, T> {

    @SuppressWarnings("unchecked")
    default String render() {
        AttSpecProcessorAssistant assistant = new AttSpecProcessorAssistant();
        StringBuilder content = new StringBuilder();
        for (Field declaredField : this.getClass().getDeclaredFields()) {
            if (AttSpecProcessor.class.isAssignableFrom(declaredField.getType())) {
                content.append(((AttSpecProcessor) assistant.getValue(declaredField, this)).render()).append("\n");
            } else if (List.class.isAssignableFrom(declaredField.getType())) {
                String type = declaredField.getGenericType().getTypeName().split("<")[1].replace(">", "");
                try {
                    Class<?> clazz = Class.forName(type);
                    if (AttSpecProcessor.class.isAssignableFrom(clazz)) {
                        List<AttSpecProcessor> value = (List<AttSpecProcessor>) assistant.getValue(declaredField, this);
                        for (AttSpecProcessor attSpecProcessor : value) {
                            content.append(attSpecProcessor.render()).append("\n");
                        }
                    }
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return content.toString();
    }

    default File writeFile(File file) {
        try (FileWriter fw = new FileWriter(file)) {
            fw.write(this.render());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return file;
    }

    void addHeader(Execute<H> execute);

    void addDetails(Execute<D> execute);

    void addTrailer(Execute<T> execute);

    AttSpecProcessor getHeader();

    List<? extends AttSpecProcessor> getDetails();

    AttSpecProcessor getTrailer();

}
