package com.ishmam.DhrubokPracticeProject1.Helpers;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDeserializer extends JsonDeserializer<Date> {
    @Override
    public Date deserialize(
            JsonParser jsonParser,
            DeserializationContext deserializationContext) throws IOException, JacksonException {

        try{
            return  new SimpleDateFormat("dd-MM-yyyy HH:mm").parse(jsonParser.getText());
        }catch (Exception ex){
            throw new RuntimeException("Date Parser Error! | Json Date Deserializer occurs problem!");
        }
    }
}
