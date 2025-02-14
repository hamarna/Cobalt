package it.auties.whatsapp.model.message.standard;

import it.auties.protobuf.base.ProtobufName;
import it.auties.protobuf.base.ProtobufProperty;
import it.auties.whatsapp.model.message.model.Message;
import it.auties.whatsapp.model.message.model.MessageCategory;
import it.auties.whatsapp.model.message.model.MessageType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.jackson.Jacksonized;

import static it.auties.protobuf.base.ProtobufType.*;

/**
 * A message that contains information related to a call
 */
@AllArgsConstructor
@Data
@Builder
@Jacksonized
@Accessors(fluent = true)
@ProtobufName("Call")
public final class CallMessage implements Message {
    /**
     * The key of this call
     */
    @ProtobufProperty(index = 1, type = BYTES)
    private byte[] key;

    /**
     * The source of this call
     */
    @ProtobufProperty(index = 2, type = STRING)
    private String source;

    /**
     * The data of this call
     */
    @ProtobufProperty(index = 3, type = BYTES)
    private byte[] data;

    /**
     * The delay of this call in endTimeStamp
     */
    @ProtobufProperty(index = 4, type = UINT32)
    private int delay;

    @Override
    public MessageType type() {
        return MessageType.CALL;
    }

    @Override
    public MessageCategory category() {
        return MessageCategory.STANDARD;
    }
}