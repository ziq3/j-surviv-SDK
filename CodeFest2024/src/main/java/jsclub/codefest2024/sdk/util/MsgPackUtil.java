package jsclub.codefest2024.sdk.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.msgpack.core.MessageBufferPacker;
import org.msgpack.core.MessagePack;
import org.msgpack.core.MessageUnpacker;
import org.msgpack.value.Value;
import org.msgpack.value.ValueFactory;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;

public class MsgPackUtil {
    /**
     * Encodes a message into MsgPack format.
     *
     * @param obj The object to encode.
     * @return The encoded MsgPack message.
     * @throws IOException If an I/O error occurs.
     */
    public static byte[] encodeMsgPackMessage(Object obj) throws IOException {
        Gson gson = new Gson();

        // Convert the object to a Map using Gson
        Type type = new TypeToken<Map<String, Object>>() {}.getType();
        Map<String, Object> map = gson.fromJson(gson.toJson(obj), type);

        // Create a MessagePack MapBuilder
        ValueFactory.MapBuilder mapBuilder = ValueFactory.newMapBuilder();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            mapBuilder.put(ValueFactory.newString(entry.getKey()), ValueFactory.newString(entry.getValue().toString()));
        }
        Value value = mapBuilder.build();

        MessageBufferPacker packer = MessagePack.newDefaultBufferPacker();
        packer.packValue(value);
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
