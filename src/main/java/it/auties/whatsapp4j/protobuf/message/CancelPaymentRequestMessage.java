package it.auties.whatsapp4j.protobuf.message;

import com.fasterxml.jackson.annotation.*;

import it.auties.whatsapp4j.api.WhatsappAPI;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * A model class that represents a WhatsappMessage that cancels a {@link RequestPaymentMessage} in a WhatsappBusiness chat.
 * This class is only a model, this means that changing its values will have no real effect on WhatsappWeb's servers.
 * Instead, methods inside {@link WhatsappAPI} should be used.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Accessors(fluent = true)
public final class CancelPaymentRequestMessage implements Message {
  /**
   * The key of the original {@link RequestPaymentMessage} that this message cancels
   */
  @JsonProperty(value = "1")
  private MessageKey key;
}
