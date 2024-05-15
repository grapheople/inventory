package org.grapheople.inmaroom.converter;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Strings;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.grapheople.inmaroom.utils.JsonUtil;

import java.util.List;

@Converter
public class StringListConverter implements AttributeConverter<List<String>, String> {

    @Override
    public String convertToDatabaseColumn(List<String> stringList) {
        return JsonUtil.toJsonString(stringList);
    }

    @Override
    public List<String> convertToEntityAttribute(String string) {
        if (Strings.isNullOrEmpty(string)) return List.of();
        return JsonUtil.jsonStringToObject(string, new TypeReference<>(){});
    }
}
