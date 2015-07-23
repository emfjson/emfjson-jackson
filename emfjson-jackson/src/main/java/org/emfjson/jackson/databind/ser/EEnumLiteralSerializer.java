package org.emfjson.jackson.databind.ser;
/*
 * (c) Центр ИТ, 2015. Все права защищены.
 */

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EEnumLiteral;

import java.io.IOException;

/**
 * @author Emelyanov Alexandr
 *         Created on 22.07.2015
 */
public class EEnumLiteralSerializer  extends JsonSerializer<EEnumLiteral> {

    private EnumeratorSerializer enumeratorSerializer;

    public EEnumLiteralSerializer(EnumeratorSerializer enumeratorSerializer){
        this.enumeratorSerializer = enumeratorSerializer;
    }

    @Override
    public void serialize(EEnumLiteral eEnumLiteral, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        enumeratorSerializer.serialize(eEnumLiteral, jsonGenerator, serializerProvider);
    }

    @Override
    public Class<EEnumLiteral> handledType() {
        return EEnumLiteral.class;
    }
}
