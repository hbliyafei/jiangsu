package websocket;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.WebSocketConnectionManager;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;

public class MyWebSocketClient {

    private static final String WS_URI = "ws://data.ronmei.com:8888/ws";

    public static void main(String[] args) throws IOException, InterruptedException {
        StandardWebSocketClient client = new StandardWebSocketClient();
        WebSocketConnectionManager manager = new WebSocketConnectionManager(client, new MyHandler(), WS_URI);

        manager.start();

        Thread.sleep(10000);
    }

    private static class MyHandler extends TextWebSocketHandler {
        @Override
        public void afterConnectionEstablished(WebSocketSession session) throws Exception {
            System.out.println("connected...........");
            session.sendMessage(new TextMessage("YKCMASTER2"));
            super.afterConnectionEstablished(session);
        }

        @Override
        protected void handleTextMessage(WebSocketSession session, TextMessage message)
                throws Exception {
            System.out.println("receive: " + message.getPayload());
            super.handleTextMessage(session, message);
        }
    }
}