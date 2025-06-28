package com.terraplanistas.api.test;

import com.terraplanistas.api.model.ChatMessage;
import com.terraplanistas.api.model.Content;
import com.terraplanistas.api.model.Room;
import com.terraplanistas.api.model.User;
import com.terraplanistas.api.repository.ContentRepository;
import com.terraplanistas.api.repository.RoomRepository;
import com.terraplanistas.api.repository.UserRepository;
import com.terraplanistas.api.model.enums.SourceContentEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.*;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.Transport;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;

import java.lang.reflect.Type;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class WebSocketTests extends BaseTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private ContentRepository contentRepository;

    @LocalServerPort
    private int port;

    private WebSocketStompClient stompClient;
    private final CompletableFuture<ChatMessage> completableFuture = new CompletableFuture<>();

    @BeforeEach
    public void setup() {
        List<Transport> transports = new ArrayList<>();
        transports.add(new WebSocketTransport(new StandardWebSocketClient()));
        SockJsClient sockJsClient = new SockJsClient(transports);

        this.stompClient = new WebSocketStompClient(sockJsClient);
        this.stompClient.setMessageConverter(new MappingJackson2MessageConverter());
    }

    @Test
    public void testWebSocketConnection() throws InterruptedException, ExecutionException, TimeoutException {
        String url = String.format("ws://localhost:%d/chat", port);
        final UUID roomId = UUID.randomUUID();
        final String userId = "test-user-id";

        // Crear y guardar el usuario
        User user = new User();
        user.setId(userId);
        user.setEmail("test@gmail.com");
        user.setUsername("testuser");
        final User savedUser = userRepository.saveAndFlush(user);

        // Crear y guardar el content
        Content content = new Content();
        content.setAuthor(savedUser);
        content.setSourceContentEnum(SourceContentEnum.ROOMS);
        content.setCreatedAt(OffsetDateTime.now());
        final Content savedContent = contentRepository.saveAndFlush(content);

        // Crear y guardar la sala
        Room room = new Room();
        room.setId(roomId);
        room.setContent(savedContent);
        final Room savedRoom = roomRepository.saveAndFlush(room);

        StompSessionHandler sessionHandler = new StompSessionHandlerAdapter() {
            @Override
            public void handleException(StompSession session, StompCommand command,
                                        StompHeaders headers, byte[] payload, Throwable exception) {
                completableFuture.completeExceptionally(exception);
            }

            @Override
            public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
                session.subscribe("/room-chat/" + roomId, new StompFrameHandler() {
                    @Override
                    public Type getPayloadType(StompHeaders headers) {
                        return ChatMessage.class;
                    }

                    @Override
                    public void handleFrame(StompHeaders headers, Object payload) {
                        completableFuture.complete((ChatMessage) payload);
                    }
                });

                ChatMessage message = new ChatMessage();
                message.setRoom(savedRoom);
                message.setContent("Test message");
                message.setSender(savedUser);

                session.send("/app/chat.sendMessage", message);
            }
        };

        StompSession session = stompClient.connect(url, sessionHandler)
                .get(10, TimeUnit.SECONDS);
        assertNotNull(session);

        ChatMessage resultado = completableFuture.get(10, TimeUnit.SECONDS);
        assertNotNull(resultado);
    }
}