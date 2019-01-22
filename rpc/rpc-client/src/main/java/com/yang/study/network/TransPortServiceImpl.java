/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.yang.study.network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import com.yang.study.domain.RpcResponse;
import com.yang.study.util.KryoUtil;

/**
 * @author fuyang
 * @version $Id: TransPortServiceImpl.java, v 0.1 2019年01月18日 5:01 PM fuyang Exp $
 */
public class TransPortServiceImpl implements TransPortService {

    @Override
    public RpcResponse transport(String ip, int port, Object data) {
        Socket socket = null;
        DataOutputStream outputStream = null;
        DataInputStream inputStream = null;
        try {
            socket = new Socket(ip, port);
            outputStream = new DataOutputStream(socket.getOutputStream());
            byte[] bytes = KryoUtil.serializer(data);
            outputStream.writeInt(bytes.length);
            outputStream.write(bytes);
            outputStream.flush();
            inputStream = new DataInputStream(socket.getInputStream());
            int length = inputStream.readInt();
            bytes = new byte[length];
            inputStream.read(bytes);
            return KryoUtil.deserializer(bytes, RpcResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                if (socket != null) {
                    socket.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}