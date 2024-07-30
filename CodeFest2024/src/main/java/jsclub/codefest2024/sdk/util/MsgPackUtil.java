package jsclub.codefest2024.sdk.util;

import org.msgpack.core.MessageBufferPacker;
import org.msgpack.core.MessagePack;
import org.msgpack.core.MessageUnpacker;

import java.io.ByteArrayInputStream;
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
     * @param data The MsgPack message to decode.
     * @return The decoded message.
     * @throws IOException If an I/O error occurs.
     */
    public static String decodeMsgPackMessage(byte[] data) throws IOException {
        MessageUnpacker unpacker = MessagePack.newDefaultUnpacker(new ByteArrayInputStream(data));

        StringBuilder result = new StringBuilder();
        while (unpacker.hasNext()) {
            result.append(unpacker.unpackString()).append(" ");
        }
        unpacker.close();

        return result.toString().trim();
    }
}
