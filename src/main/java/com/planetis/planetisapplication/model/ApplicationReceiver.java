package com.planetis.planetisapplication.model;

import com.planetis.planetisapplication.controller.ModelController;
import org.eclipse.paho.client.mqttv3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Hello world!
 */
public class ApplicationReceiver implements MqttCallback {

    private final String url = "tcp://145.24.222.106:8883";
    private final String clientId = "Receiving";
    private final String user = "";
    private final String pass = "";
    private MqttClient client;
    private int connectionRetries = 5;
    private final static Logger LOGGER = LoggerFactory.getLogger(ApplicationReceiver.class);

    private final String[] topics = {"POSITIONS", "MONITORING", "EVENTS", "CONNECTIONS"};

    private final ModelController controller;

    public static void main(String[] args) {
        new ApplicationReceiver().connectAndListen();

    }

    public ApplicationReceiver() {
        this.controller = new ModelController();
    }

    /**
     * *
     * Connect to the broker and start listening.
     */
    public void connectAndListen() {
        LOGGER.debug("Connect to message broker at." + url);

        try {
            client = new MqttClient(url, clientId);
            client.connect(createConnectionProperties(user, pass));
            client.setCallback(this);

            for (String topic : topics) {
                try {
                    client.subscribe(topic);
                } catch (MqttException e) {
                }
            }

//            Arrays.stream(topics).forEach(t -> {
//                try {
//                    client.subscribe(t);
//                } catch (MqttException e) {
//                    e.printStackTrace();
//                }
//            });
        } catch (MqttException e) {
            LOGGER.error("Connection failed." + e.getMessage());

        }
    }

    /**
     * *
     * Is called when connection is lost.
     *
     * @param cause
     */
    @Override
    public void connectionLost(Throwable cause) {
        LOGGER.error("Connection lost." + cause.getMessage());

        connectionRetries--;
        if (connectionRetries != 0) {
            LOGGER.error("Retrying establishing a connection.");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            connectAndListen();
        }
    }

    /**
     * *
     * Callback methods for each received method.
     *
     * @param topic the topic where the message originated from.
     * @param message the contents of the actual message
     */
    @Override
    public void messageArrived(String topic, MqttMessage message) {
        controller.liveConvertSave(topic, message.toString());
    }

    /**
     * *
     * Is not called in practice.
     *
     * @param token
     */
    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
        LOGGER.debug("Delivery complete." + token.toString());
    }

    private MqttConnectOptions createConnectionProperties(String user, String password) {
        MqttConnectOptions connectOptions = new MqttConnectOptions();

        connectOptions.setCleanSession(true);
        if (user != null && user.length() > 0) {
            connectOptions.setUserName(user);
            connectOptions.setPassword(password.toCharArray());
        }
        return connectOptions;

    }
}
