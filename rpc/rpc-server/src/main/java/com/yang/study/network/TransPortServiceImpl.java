/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.yang.study.network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;

import com.yang.study.domain.RpcRequest;
import com.yang.study.domain.RpcResponse;
import com.yang.study.handler.RpcHandler;

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
                        ObjectOutputStream outputStream = null;
                        ObjectInputStream inputStream = null;
                        try {
                            outputStream = new ObjectOutputStream(socket.getOutputStream());
                            inputStream = new ObjectInputStream(socket.getInputStream());
                            RpcRequest rpcRequest = (RpcRequest) inputStream.readObject();
                            RpcResponse rpcResponse = rpcHandler.handler(rpcRequest);
                            outputStream.writeObject(rpcResponse);
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (ClassNotFoundException e) {
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