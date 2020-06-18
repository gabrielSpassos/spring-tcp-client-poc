package com.gabrielspassos.poc.service;

import com.gabrielspassos.poc.gateway.TcpGateway;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class CustomerService implements MessageService{

    private TcpGateway tcpGateway;

    @Override
    public void sendMessage(String message) {
        log.info("Sending message {}", message);
        byte[] bytesResponse = tcpGateway.send(message.getBytes());
        String response = new String(bytesResponse);
        log.info("Response {}", response);
    }
}
