/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.yang.study.network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.yang.study.domain.RpcResponse;

/**
 * @author fuyang
 * @version $Id: TransPortServiceImpl.java, v 0.1 2019年01月18日 5:01 PM fuyang Exp $
 */
public class TransPortServiceImpl implements TransPortService {

    @Override
    public RpcResponse transport(String ip, int port, Object data) {
        Socket socket = null;
        ObjectOutputStream outputStream = null;
        ObjectInputStream inputStream = null;
        try {
            socket = new Socket(ip, port);
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(data);
            inputStream = new ObjectInputStream(socket.getInputStream());
            return (RpcResponse) inputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
                outputStream.close();
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}