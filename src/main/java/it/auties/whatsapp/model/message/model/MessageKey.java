package it.auties.whatsapp.model.message.model;

import it.auties.bytes.Bytes;
import it.auties.protobuf.api.model.ProtobufMessage;
import it.auties.protobuf.api.model.ProtobufProperty;
import it.auties.whatsapp.model.contact.ContactJid;
import it.auties.whatsapp.model.info.MessageInfo;
import lombok.*;
import lombok.Builder.Default;
import lombok.experimental.Accessors;
import lombok.extern.jackson.Jacksonized;

import java.util.Locale;

import static it.auties.protobuf.api.model.ProtobufProperty.Type.BOOLEAN;
import static it.auties.protobuf.api.model.ProtobufProperty.Type.STRING;

/**
 * A container for unique identifiers and metadata linked to a {@link Message} and contained in {@link MessageInfo}.
 */
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@NoArgsConstructor
@Data
@Accessors(fluent = true)
@Jacksonized
@Builder(builderMethodName = "newMessageKey", buildMethodName = "create")
public class MessageKey implements ProtobufMessage {
    /**
     * The jid of the contact or group that sent the message.
     */
    @ProtobufProperty(index = 1, type = STRING, concreteType = ContactJid.class, requiresConversion = true)
    @NonNull
    private ContactJid chatJid;

    /**
     * Determines whether the message was sent by you or by someone else
     */
    @ProtobufProperty(index = 2, type = BOOLEAN)
    private boolean fromMe;

    /**
     * The id of the message
     */
    @ProtobufProperty(index = 3, type = STRING)
    @NonNull
    @Default
    private String id = randomId();

    /**
     * The jid of the sender
     */
    @ProtobufProperty(index = 4, type = STRING, concreteType = ContactJid.class, requiresConversion = true)
    private ContactJid senderJid;

    /**
     * Generates a random message id
     *
     * @return a non-null String
     */
    public static String randomId() {
        return Bytes.ofRandom(8)
                .toHex()
                .toUpperCase(Locale.ROOT);
    }

    /**
     * Copies this key
     *
     * @return a non-null message key
     */
    public MessageKey copy(){
        return new MessageKey(chatJid, fromMe, id, senderJid);
    }
}
