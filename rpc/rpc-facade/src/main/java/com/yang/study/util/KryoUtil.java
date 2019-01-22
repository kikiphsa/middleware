/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.yang.study.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

/**
 * @author fuyang
 * @version $Id: KryoUtil.java, v 0.1 2019年01月21日 7:36 PM fuyang Exp $
 */
public class KryoUtil {

    private static final ThreadLocal<Kryo> threadLocal = new ThreadLocal<Kryo>() {
        @Override
        protected Kryo initialValue() {
            Kryo kryo = new Kryo();
            kryo.setReferences(false);
            kryo.setRegistrationRequired(false);
            return kryo;
        }
    };

    public static <T> byte[] serializer(T object) {
        Kryo kryo = threadLocal.get();
        kryo.register(object.getClass());
        ByteArrayOutputStream outputStream = null;
        Output output = null;
        try {
            outputStream = new ByteArrayOutputStream();
            output = new Output(outputStream);
            kryo.writeObject(output, object);
            output.flush();
            return outputStream.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (output != null) {
                output.close();
            }
        }
        return null;
    }

    public static <T> T deserializer(byte[] data, Class<T> clazz) {
        Kryo kryo = threadLocal.get();
        kryo.register(clazz);
        ByteArrayInputStream inputStream = null;
        Input input = null;
        try {
            inputStream = new ByteArrayInputStream(data);
            input = new Input(inputStream);
            return kryo.readObject(input, clazz);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (input != null) {
                input.close();
            }
        }
        return null;
    }
}