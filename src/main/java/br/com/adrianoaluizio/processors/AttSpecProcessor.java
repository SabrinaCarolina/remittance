package br.com.adrianoaluizio.processors;

import br.com.adrianoaluizio.models.annotations.AttSpec;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public interface AttSpecProcessor {

	@SuppressWarnings("unchecked")
	default String render() {
		AttSpecProcessorAssistant assistant = new AttSpecProcessorAssistant();
		StringBuilder line = new StringBuilder();
		List<String> invalidFields = new ArrayList<>();
		for(Field declaredField: this.getClass().getDeclaredFields()) {
			if(declaredField.isAnnotationPresent(AttSpec.class)) {
				AttSpec annotation = declaredField.getAnnotation(AttSpec.class);
				if(annotation.breakLine()) {
					AttSpecProcessor value = (AttSpecProcessor) assistant.getValue(declaredField, this);
					if(value != null) {
						line.append("\n");
						line.append((value).render());
					}
				} else {
					if(annotation.length() < 0) {
						throw new UnsupportedOperationException("Invalid length validation");
					}
					Object value;

					try {
						if(annotation.reference().isEmpty()) {
							value = assistant.getValue(declaredField, this);
						} else {
							Field field = this.getClass().getField(annotation.reference());
							value = assistant.getValue(field, this);

						}
					} catch(RuntimeException e) {
						invalidFields.add(declaredField.getName());
						continue;
					} catch(NoSuchFieldException e) {
						throw new RuntimeException(e);
					}

					if(value == null) {
						if(!annotation.value().isEmpty()) {
							value = annotation.value();
						}
						if(annotation.required() && value == null) {
							invalidFields.add(declaredField.getName());
							continue;
						}
					}
					String v = annotation.format().format(value);
					v = annotation.cleanerType().cleaner(v).toUpperCase();
					v = assistant.resize(v, annotation.length(), annotation.orientation(), annotation.fillChar());
					line.append(v);
				}
			}

		}
		return line.toString();
	}


}
