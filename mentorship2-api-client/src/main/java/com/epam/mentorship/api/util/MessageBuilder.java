package com.epam.mentorship.api.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public final class MessageBuilder {

    private MessageBuilder() {
    }

    public static MessageBuilderAPI createMessageBuilder(
            final Boolean convertToJson) {
        return new MessageBuilderAPI(convertToJson);
    }

    public static MessageBuilderAPI createMessageBuilder() {
        return new MessageBuilderAPI(true);
    }

    public static final class MessageBuilderAPI {
        private boolean convertToJson;
        private ObjectMapper mapper;
        private MessageData messageData;

        private MessageBuilderAPI(final Boolean convertToJson) {
            this.convertToJson = convertToJson;
            mapper = new ObjectMapper();
            messageData = new MessageData();
        }

        public MessageBuilderAPI user(final String user) {
            messageData.user = user;
            return this;
        }

        public MessageBuilderAPI result(final Boolean result) {
            messageData.result = result;
            return this;
        }

        public MessageBuilderAPI data(final Object data) {
            messageData.data = data;
            return this;
        }

        public String generate() {
            try {
                return convertToJson ? mapper.writeValueAsString(messageData)
                        : messageData.toString();
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @SuppressWarnings("unused")
    private static class MessageData {
        private String user;
        private Boolean result;
        private Object data;

        @Override
        public String toString() {
            return "MessageData [user=" + user + ", result=" + result
                    + ", data=" + data + "]";
        }

        public String getUser() {
            return user;
        }

        public void setUser(final String user) {
            this.user = user;
        }

        public Boolean getResult() {
            return result;
        }

        public void setResult(final Boolean result) {
            this.result = result;
        }

        public Object getData() {
            return data;
        }

        public void setData(final Object data) {
            this.data = data;
        }
    }
}
