/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.yang.study.network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;

import com.yang.study.domain.RpcRequest;
import com.yang.study.domain.RpcResponse;
import com.yang.study.handler.RpcHandler;
import com.yang.study.util.KryoUtil;

/**
 * @author fuyang
 * @version $Id: TransPortServiceImpl.java, v 0.1 2019年01月21日 11:10 AM fuyang Exp $
 */
public class TransPortServiceImpl implements TransPortService {

    private ExecutorService executorService;

    private RpcHandler rpcHandler;

    public void transport() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(1234);
            while (true) {
                Socket socket = serverSocket.accept();
                executorService.execute(new Runnable() {
                    @Override
                    public void run() {
                        DataOutputStream outputStream = null;
                        DataInputStream inputStream = null;
                        try {
                            outputStream = new DataOutputStream(socket.getOutputStream());
                            inputStream = new DataInputStream(socket.getInputStream());
                            int length = inputStream.readInt();
                            byte[] data = new byte[length];
                            inputStream.read(data);
                            RpcRequest rpcRequest = KryoUtil.deserializer(data, RpcRequest.class);
                            RpcResponse rpcResponse = rpcHandler.handler(rpcRequest);
                            data = KryoUtil.serializer(rpcResponse);
                            outputStream.writeInt(data.length);
                            outputStream.write(data);
                            outputStream.flush();
                        } catch (IOException e) {
                            e.printStackTrace();
                        } finally {
                            try {
                                if (outputStream != null) {
                                    outputStream.close();
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Setter method for property <tt>executorService</tt>.
     *
     * @param executorService value to be assigned to property executorService
     */
    public void setExecutorService(ExecutorService executorService) {
        this.executorService = executorService;
    }

    /**
     * Setter method for property <tt>rpcHanlder</tt>.
     *
     * @param rpcHandler value to be assigned to property rpcHanlder
     */
    public void setRpcHandler(RpcHandler rpcHandler) {
        this.rpcHandler = rpcHandler;
    }
}