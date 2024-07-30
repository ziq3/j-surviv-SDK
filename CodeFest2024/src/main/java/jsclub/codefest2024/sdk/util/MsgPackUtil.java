package jsclub.codefest2024.sdk.util;

import org.msgpack.core.MessageBufferPacker;
import org.msgpack.core.MessagePack;
import org.msgpack.core.MessageUnpacker;
import org.msgpack.value.Value;

import java.io.IOException;

public class MsgPackUtil {
    /**
     * Encodes a message into MsgPack format.
     *
     * @param messages The messages to encode.
     * @return The encoded MsgPack message.
     * @throws IOException If an I/O error occurs.
     */
    public static byte[] encodeMsgPackMessage(String... messages) throws IOException {
        MessageBufferPacker packer = MessagePack.newDefaultBufferPacker();

        for (String message : messages) {
            packer.packString(message);
        }

        packer.close();
        return packer.toByteArray();
    }

    /**
     * Decodes a MsgPack message.
     *
     * @param arg The message to decode.
     * @return The decoded message as a string.
     * @throws IOException If an I/O error occurs.
     */
    public static String decodeMsgPackMessage(Object arg) throws IOException {
        byte[] data = (byte[]) arg;
        MessageUnpacker unpacker = MessagePack.newDefaultUnpacker(data);
        Value msgpackValue =  unpacker.unpackValue();
        return msgpackValue.toJson();
    }
}
