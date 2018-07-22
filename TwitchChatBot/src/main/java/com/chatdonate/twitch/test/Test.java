package com.chatdonate.twitch.test;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import org.json.JSONObject;

public class Test
{
    public static void main(String[] args) throws Exception {

        IO.Options opts = new IO.Options();
        opts.forceNew = true;
        opts.reconnection = true;
        opts.query = "token=";

        Socket socket = IO.socket("http://sockets.streamlabs.com", opts);



        // Receiving an object
        socket.on("Donations", new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                JSONObject obj = (JSONObject)args[0];
                System.out.println(obj);
            }
        });

    }
}
